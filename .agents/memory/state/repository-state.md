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
`wiki/information/overview.md`, `wiki/logs/0/0/0/CHANGELOG.md`, `README.md`, `LICENSE`.

**Does not exist yet:** the Gradle build (`settings.gradle`, `build.gradle`,
`gradle.properties`, the wrapper), the `api/` and `common/` modules, the five
`platforms/bukkit/` modules, the seven `platforms/mods/` modules, and `PROMPT.md`.

## Stack, once built

Gradle 9.5.0 multi-project; Java 25 toolchain for the shared and Bukkit modules, Java 21 for
the mod modules; `com.gradleup.shadow` for the Bukkit engine jar; fabric-loom and
ModDevGradle for the mod jars. Minecraft target 26.1.2.

## Next step

Task 3 of [`../tasks/universal-plugin-template.md`](../tasks/universal-plugin-template.md):
the Gradle foundation. The tasks are stacked branches and run strictly in order.
