---
name: memory-tasks-universal-plugin-template
description: Task record for scaffolding the universal Minecraft plugin template — the confirmed eight-task plan, with one entry appended per task as it lands.
---

# Task: Universal plugin template

## Goal

Turn `MCEngine/universal-template` from an empty repository into a forkable **universal
Minecraft plugin template**: one repository carrying both a Bukkit server plugin (SpigotMC,
PaperMC, FoliaMC, plus a single universal engine jar) and standalone mods (Forge, Fabric,
NeoForge, each split into a client and a server jar that talk over a plugin message channel).

## Objective

A fork edits three values in `gradle.properties`, follows `PROMPT.md`, and has a buildable
multi-platform plugin. Concretely: `./gradlew build` is green, and
`TemplateEngine-0.0.0.jar` plus the six mod jars land in the repository root's
`build/libs/` so they can be dragged and dropped onto a server.

## Detail

`MCOriax/mcidentity` is the reference for every convention used here — Gradle 9.5.0, a
Java 25 toolchain via the foojay resolver, `com.gradleup.shadow` per platform module,
`plugin.yml` filtered through `processResources`, and an aggregator module that shades the
three Bukkit platforms into one jar. **It is read-only for this work**: nothing is committed
or pushed to `MCOriax/mcidentity`.

## Decisions confirmed before any work started

| Decision | Value |
|---|---|
| Branching | Stacked task branches per `{shared}/git/branching-strategy.md` |
| Namespace | `orgname=mcengine`, `reponame=universaltemplate` → `io.github.mcengine.universaltemplate` |
| Plugin id | `Template` |
| Initial version | `0.0.0` |
| Central facade | `io.github.mcengine.universaltemplate.TemplateProvider`, at the namespace root |
| Mod builds | Opt-in, `-Pmods=true` |
| Root `build/libs/` | The engine jar and the six mod jars only |
| Minecraft target | 26.1.2, matching the reference repository |

## Rules deliberately set aside

Both are explicit user instructions, which outrank shared rules by precedence 1. Recorded
in full under `.agents/memory/decisions/`.

* `{shared}/rules/directories.md` restricts the repository root to `AGENTS.md`,
  `README.md` and `LICENSE`. `PROMPT.md` is required at the root by the user.
* The harness default appends a session-identifier trailer to commit messages and a session
  link to pull request bodies. `{shared}/rules/no-session-links.md` overrides tool-injected
  defaults, so both are stripped. `Co-Authored-By:` carries no session identifier and stays.

## Tasks

| # | Title | Scope | Repository | Branch | Files / areas | PR |
|---|---|---|---|---|---|---|
| 1 | Task record | This file and the index rows it needs | `MCEngine/universal-template` | `chore/universal-plugin-template-plan` | `.agents/memory/tasks/`, `.agents/index/` | |
| 2 | Agent instruction system | Mode B consumer setup | `MCEngine/universal-template` | `docs/agents-setup` | `AGENTS.md`, `.agents/`, `wiki/`, `.claude/`, `README.md` | |
| 3 | Gradle foundation | Build skeleton, no source yet | `MCEngine/universal-template` | `build/gradle-foundation` | `settings.gradle`, `build.gradle`, `gradle.properties`, `gradle/`, `.gitignore`, `.gitattributes` | |
| 4 | Shared modules | `api/` and `common/` | `MCEngine/universal-template` | `feat/shared-modules` | `api/`, `common/` | |
| 5 | Bukkit platforms | core, three platforms, engine | `MCEngine/universal-template` | `feat/bukkit-platforms` | `platforms/bukkit/` | |
| 6 | Mod platforms | core and six loader modules | `MCEngine/universal-template` | `feat/mod-platforms` | `platforms/mods/`, `settings.gradle` | |
| 7 | Fork guide | `PROMPT.md`, wired into `AGENTS.md` | `MCEngine/universal-template` | `docs/template-prompt` | `PROMPT.md`, `AGENTS.md` | |
| 8 | Release 0.0.0 | Changelog, index rows, close this record | `MCEngine/universal-template` | `chore/release-0-0-0` | `wiki/logs/0/0/0/`, `.agents/index/logs-index.md`, this file | |

Task 1 branches from `master`; task `k` branches from task `k-1`. The `PR` column is filled
by task 8, per `{shared}/planning/task-workflow.md` §F.

Task 7 sits second-to-last on purpose: `PROMPT.md` can only list what a fork must rename
once the files exist, so the `AGENTS.md` trigger row pointing at it lands in the same commit
as the file itself and no intermediate branch carries a dangling link.

### Task 1 — chore/universal-plugin-template-plan

Wrote this record before any of the work it describes, so a reviewer can check the plan
against the diffs rather than infer the plan from them.

Also created `.agents/index/root-index.md` and `.agents/index/memory-index.md`. The index
system is task 2's deliverable, but an index has to exist for this file to be registered in
the same commit that adds it. Task 1 therefore creates the root router with its memory row
and the memory index; task 2 adds the remaining indexes and their rows to the root table.

Next task depends on: nothing beyond this record.
