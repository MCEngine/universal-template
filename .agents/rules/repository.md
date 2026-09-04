---
name: repository-rules
description: Rules specific to the universal-template repository — what it is, what it consumes, and the version carriers it gates.
---

# Repository-specific rules — universal-template

This repository is **`MCEngine/universal-template`**, a forkable template for a universal
Minecraft plugin. Read [`../wiki/context/repository-map.md`](../wiki/context/repository-map.md)
for what currently lives where before making changes.

## Mode and the shared set

This repository is a **Mode B consumer**. The shared instruction set — branching, commits,
pull requests, the task workflow, the creators, the placement and versioning rules — is
served by the **`lxagents-agents-base`** MCP connector and is never copied here. This
repository carries only what is its own: its indexes, this file, its two wiki trees, and its
memory.

## Rules

* **Nothing shared is copied here.** A file readable from `agents://` must not exist in
  `.agents/` unless it is a declared override with a row in
  [`../index/root-index.md`](../index/root-index.md). There are currently no overrides.
* **This is a template, not a plugin.** Every identifier a fork must rename is driven from
  `gradle.properties`, not hardcoded across files. When you add something that carries the
  organization name, repository name, or plugin id, drive it from a property.
* **Versions.** Never edit `project-version` in `gradle.properties` on your own initiative,
  and never create a `wiki/logs/{Major}/{Minor}/{Patch}/` directory unasked — that is itself
  a version claim. See `{shared}/rules/versioning.md`.
* **Module boundaries.** `api` depends on nothing and holds only interfaces, records, enums,
  and abstract classes. `common` holds the implementation. Platform modules reach the
  implementation only through `io.github.mcengine.universaltemplate.TemplateProvider` and
  never import from `...universaltemplate.common`. See
  [`../../wiki/information/architecture.md`](../../wiki/information/architecture.md).
* **One package-info per shared module.** `api` and `common` each carry exactly one, at the
  module's root package. Do not add more, and do not create sub-packages that would want one.
* **Docs and indexes.** Keep both wiki trees current with any structural change, and update
  the index that owns the changed scope in the same commit. See
  `{shared}/creators/index-creator.md` and `{shared}/rules/change-propagation.md`.

## Build and test commands

| Command | Purpose |
|---|---|
| `./gradlew build` | Compile every module and run the test suite. |
| `./gradlew -Pmods=true build` | The same, including the six mod modules. |
| `./gradlew clean` | Remove build output, including the root `build/` directory. |

The Gradle wrapper is committed; never invoke a system-installed `gradle`. Full setup notes
are in [`../../wiki/environments/setup.md`](../../wiki/environments/setup.md).

**What "verify" means here.** The shared task workflow says to finish and verify each task
before starting the next. In this repository that means the Gradle build and the tests pass
for the modules you touched — `./gradlew build`, plus `-Pmods=true` when the change reaches
`platforms/mods/`.

## Current state

The instruction, knowledge and memory systems exist, the Gradle skeleton is in place, and
the shared `api` and `common` modules build and test green. The platform modules do not
exist yet — they are the remaining tasks in
[`../memory/tasks/universal-plugin-template.md`](../memory/tasks/universal-plugin-template.md).
This section, and the repository map, are updated by each task that changes what is true.

## Version carriers in this repository

`{shared}/rules/versioning.md` gates every one of these; this table says where they are.

| Carrier | Where |
|---|---|
| `project-version` | `gradle.properties` |
| Gradle wrapper version | `gradle/wrapper/gradle-wrapper.properties` |
| Minecraft, loader and plugin dependency versions | `gradle.properties` |
| Log directories | `wiki/logs/{Major}/{Minor}/{Patch}/` |
| Git tags and release drafts | GitHub releases |
