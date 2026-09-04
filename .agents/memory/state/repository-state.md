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
`wiki/information/architecture.md`, `wiki/logs/0/0/0/CHANGELOG.md`, `README.md`, `LICENSE`,
the Gradle skeleton — `settings.gradle`, `build.gradle`, `gradle.properties`,
`.gitattributes`, and the committed wrapper pinning Gradle 9.5.0 — the `api/` and `common/`
modules, and the five `platforms/bukkit/` modules. All of it builds and tests green: 20
tests, zero deprecation warnings under `--warning-mode all`, and
`build/libs/TemplateEngine-0.0.0.jar` at the repository root carrying exactly one
`plugin.yml` and one `config.yml`.

**`PROMPT.md`** exists at the root and is the fork setup procedure; it deletes itself once run.

**Identity:** `gradle.properties` carries `git-org-name` and `git-repository-name` only; the
group `io.github.mcengine` is derived from the first. The package segment (`universal`) and
the plugin id (`Template`) live at the top of the root `build.gradle`, because they also
appear in Java source. The namespace is `io.github.mcengine.universal`. The version is
fixed at `0.0.0` permanently.

**Verified:** the Bukkit side, `platforms/mods/core`, and the Fabric and NeoForge client and
server modules. `./gradlew -Pmods=true build` is green and produces five jars in the root
`build/libs/`.

**Written but not building: the two Forge modules.** Behind `-Pforge=true`. NeoFormRuntime
fetches `net.minecraftforge:forge:<version>:universal-srg` outside Gradle's dependency
resolution, so declaring the Forge maven anywhere does not reach it. Not a build-script bug;
do not add more repositories.

## Stack

Gradle 9.5.0 multi-project with the configuration cache on. **One Java 21 toolchain for
every module, mods included**, and the Gradle daemon itself pinned to 21 in
`gradle/gradle-daemon-jvm.properties` because Loom checks the daemon's version rather than
the toolchain's. `com.gradleup.shadow` produces the Bukkit engine jar; fabric-loom and
ModDevGradle produce the mod jars. **Minecraft target 1.21.11** — not a 26.x release, which
publishes no obfuscation mappings and therefore supports no mod toolchain at all. See
[`../decisions/minecraft-target-version.md`](../decisions/minecraft-target-version.md).

## Next step

Task 8 of [`../tasks/universal-plugin-template.md`](../tasks/universal-plugin-template.md):
simplifying the identity properties and renaming the namespace. The tasks are stacked
branches and run strictly in order.
