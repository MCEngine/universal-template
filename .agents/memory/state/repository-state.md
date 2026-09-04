---
name: memory-state-repository-state
description: What this repository contains right now, what it does not yet, and the next obvious step.
---

# Repository state

Overwritten in place, always current.

## As of the agent instruction system landing

`MCEngine/universal-template` is a **Mode B consumer** of the shared instruction set served
by the `lxagents-agents-base` connector. It declares no overrides.

**Exists:** `AGENTS.md`, `.claude/CLAUDE.md`, the six indexes under `.agents/index/`,
`.agents/rules/repository.md`, `.agents/wiki/context/repository-map.md`, this memory tree,
`wiki/information/overview.md`, `wiki/environments/setup.md`,
`wiki/logs/0/0/0/CHANGELOG.md`, `README.md`, `LICENSE`, and the Gradle skeleton —
`settings.gradle`, `build.gradle`, `gradle.properties`, `.gitattributes`, and the committed
wrapper pinning Gradle 9.5.0.

**Does not exist yet:** the `api/` and `common/` modules, the five `platforms/bukkit/`
modules, the seven `platforms/mods/` modules, and `PROMPT.md`. `settings.gradle` includes no
modules yet.

## Stack

Gradle 9.5.0 multi-project with the configuration cache on. **One Java 25 toolchain for
every module, mods included** — Mojang's version manifest gives Minecraft 26.1.2 a
`javaVersion` of 25, so the earlier plan to split the mod modules onto Java 21 was dropped
before any of it was written. `com.gradleup.shadow` produces the Bukkit engine jar;
fabric-loom and ModDevGradle produce the mod jars. Minecraft target 26.1.2.

## Next step

Task 4 of [`../tasks/universal-plugin-template.md`](../tasks/universal-plugin-template.md):
the shared `api/` and `common/` modules. The tasks are stacked branches and run strictly in
order.
