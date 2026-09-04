---
name: agent-wiki-context-repository-map
description: Orientation for agents — what currently lives in this repository, what is planned, and where each kind of file belongs.
---

# Repository map

Orientation before touching anything. For what this template *is*, read
[`wiki/information/overview.md`](../../../wiki/information/overview.md) — the facts live
there once, and this page links rather than repeats them.

## What exists right now

| Path | What it is |
|---|---|
| `AGENTS.md` | Entry point: shared set resolution, reading order, trigger table. |
| `.claude/CLAUDE.md` | A single import of `../AGENTS.md`, so Claude Code and every other agent read the same instructions. Never paste content into it. |
| `.agents/index/` | Every index. Six files, flat, named `{scope}-index.md`. |
| `.agents/rules/repository.md` | This repository's own rules hub. |
| `.agents/wiki/context/` | This page. |
| `.agents/memory/` | Task record, decisions, current state. |
| `wiki/` | Human documentation, plus `wiki/logs/` for release history. |
| `README.md`, `LICENSE` | Overview and the MIT license. |
| `settings.gradle` | Project name and the module includes. Modules are added by the task that creates them. |
| `build.gradle` | Root build: derived group, the Java 25 toolchain applied to every module, and the root `clean`. |
| `gradle.properties` | Every renameable identifier and every dependency version. The one file a fork edits. |
| `gradlew`, `gradlew.bat`, `gradle/wrapper/` | The committed wrapper, pinning Gradle 9.5.0. |
| `api/` | The shared contract. Interfaces, records, enums, one abstract dispatcher. No dependencies. |
| `common/` | The implementation, plus `TemplateProvider` at the namespace root — the only supported way in. |

## What does not exist yet

The five `platforms/bukkit/` modules, the seven `platforms/mods/` modules, and `PROMPT.md`.
`./gradlew build` currently builds `api` and `common` only. The intended layout, the
identity values and the ordered task list are all recorded in
[`../../memory/tasks/universal-plugin-template.md`](../../memory/tasks/universal-plugin-template.md).
**Do not infer the build from this page** — it is updated by each task as that task makes
something true, so anything absent here is genuinely absent from the repository.

## Where a new file goes

| Kind | Path |
|---|---|
| A rule for this repository | `.agents/{folder}/{file}.md` — and a trigger row in `AGENTS.md` |
| Documentation a person reads | `wiki/{folder}/{file-name}.md` |
| Procedure or framing only an agent needs | `.agents/wiki/{type}/{file-name}.md` |
| Task state, a decision, current state | `.agents/memory/{type}/{file-name}.md` |
| An index | `.agents/index/{scope}-index.md` |

Never an `INDEX.md`. Never a third documentation tree. The authority is
`{shared}/rules/directories.md`.

## Gotchas

* **`.claude/CLAUDE.md` imports `../AGENTS.md`, not `@AGENTS.md`.** The import path resolves
  relative to that file, so `@AGENTS.md` would point at `.claude/AGENTS.md`, which does not
  exist.
* **The trigger table in `AGENTS.md` is mirrored, not authored.** It reproduces
  `{shared}/rules/auto-activation.md` row for row. Repointing a mirrored row at a local file
  is an override and belongs in the root index's override table, never in the table itself.
* **Memory is ungated, instructions are not.** Write `.agents/memory/` freely. Never create
  or edit an instruction file without the user selecting it first.
* **`settings.gradle` tracks the directories that exist.** Each task adds its own `include`
  lines, so every commit has a settings file matching what is on disk. If you add a module,
  add its include in the same commit.
* **The group is derived, never stored.** `build.gradle` builds it from the `orgname`
  property. Do not add a `project-group` property alongside it — that is two sources for one
  fact.
* **Configuration cache is on.** A task that closes over `project` at execution time will
  fail. Capture what you need at configuration time, as the root `clean` does.
* **`api` takes no dependencies, ever.** The moment it depends on Bukkit or a mod loader it
  stops being the thing all four platforms can share.
* **Platform modules never import `...universaltemplate.common`.** They go through
  `TemplateProvider`. If the facade does not expose what you need, add a method to it.
* **`AbstractTemplateService.handle` has no `default` branch on purpose.** Adding a
  `TemplateAction` constant is meant to break the build until every platform handles it.
