# Local Setup

[← Back to README](../../README.md)

## Requirements

| | |
|---|---|
| **JDK** | 25. Minecraft 26.1.2 requires it, so every module targets it. |
| **Gradle** | None needed — use the committed wrapper (`./gradlew`), which pins Gradle 9.5.0. |
| **Disk** | A few hundred MB for the Bukkit side. Several GB more if you enable the mod modules, which decompile Minecraft. |

You do not have to install JDK 25 yourself. `settings.gradle` applies the Foojay resolver,
so Gradle downloads a matching toolchain on first build if one is not already present.

## Build

```bash
./gradlew build                 # compile every module and run the tests
./gradlew clean                 # remove build output, including the root build/ directory
```

Never invoke a system-installed `gradle`; the wrapper is committed so that everyone builds
with the same version.

## Building the mods

The Forge, Fabric, and NeoForge modules are excluded from the build unless you ask for them:

```bash
./gradlew -Pmods=true build
```

They are opt-in because their toolchains download and decompile Minecraft the first time
they run, which takes a long time and a lot of disk. A change confined to the Bukkit side
does not need to pay that cost. Set `mods=true` in `gradle.properties` if you work on the
mods often enough that passing the flag becomes noise.

## Where the jars go

The distributable jars are built straight into `build/libs/` at the repository root, so you
can drag them onto a server without hunting through module directories. Nothing else is
written there.

Intermediate jars — the individual SpigotMC, PaperMC, and FoliaMC jars that get shaded into
the universal engine jar — stay in their own module's `build/libs/`.

## Configuration

Everything a fork renames lives in `gradle.properties`: `orgname`, `reponame`, and
`pluginid`, plus the Minecraft and loader versions to target. See `PROMPT.md` at the
repository root for the full checklist.
