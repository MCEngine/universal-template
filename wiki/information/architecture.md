# Architecture

[← Back to README](../../README.md)

How this project is laid out, and the dependency rules that keep the layout honest. For what
the project *is*, see [Project Overview](overview.md); for building it, see
[Local Setup](../environments/setup.md).

## Modules

| Module | Package | Contains |
|---|---|---|
| `api` | `io.github.mcengine.universaltemplate.api` | The shared contract: interfaces, records, enums, and one abstract dispatcher. No dependencies at all. |
| `common` | `io.github.mcengine.universaltemplate` and `.common` | The implementation, plus the single public facade `TemplateProvider`. |

The remaining modules — the Bukkit platforms and the mods — are added by later tasks and
documented here as they land.

## The shared contract

`api` depends on nothing: not Bukkit, not a mod loader, not `common`. That is the whole point
of it. A Bukkit listener, a Fabric client, and a NeoForge server all compile against the same
`TemplateAction`, `TemplateRequest`, and `TemplateResponse`, so the protocol between them is
checked by the compiler rather than described in a document that drifts.

Three shapes carry the contract:

- **`TemplateAction`** — the wire vocabulary. Adding a constant changes the protocol.
- **`TemplateRequest` / `TemplateResponse`** — immutable records. `TemplateRequest`
  normalizes a missing payload to the empty string in its compact constructor, so no handler
  has to null-check it.
- **`TemplateService`** — the behaviour, with `AbstractTemplateService` supplying the
  dispatch every implementation would otherwise write itself.

`AbstractTemplateService.handle` switches over the enum with **no `default` branch**. Adding
an action therefore breaks the build until a handler exists, rather than reaching production
and failing on whichever platform received the new action first.

## Asynchronous by signature

Anything that can block, fail, or reach storage returns a `CompletableFuture`. Only
`greetingFor`, which answers from memory, is synchronous. A caller can tell the two apart
from the signature alone, which matters on a Minecraft server where blocking the main thread
is a visible stall for every player online.

## One way in

Every platform module reaches the implementation through
`io.github.mcengine.universaltemplate.TemplateProvider`, and nothing else.

The facade deliberately sits at the **root of the namespace**, one package above the
`common` implementation classes it wraps, so someone opening the source tree meets the
supported entry point before they meet anything they should not depend on. It holds its
service privately and returns it from no method, so there is no supported way to reach
around it.

The rule that follows: **a platform module never imports from
`io.github.mcengine.universaltemplate.common`.** If a platform needs something the facade
does not expose, the fix is a method on the facade, not an import.

## Dependency rules

```
api        <-  nothing
common     <-  api
platforms  <-  api, common   (never each other)
```

`common` declares `api` with Gradle's `api` configuration rather than `implementation`, so a
platform module that depends on `common` sees the contract types on its own compile
classpath without redeclaring them.
