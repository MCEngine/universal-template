# universal-template

A forkable template for a **universal Minecraft plugin**: one repository carrying both a
Bukkit server plugin and standalone mods, over a single shared contract.

## Key features

- One Gradle multi-project build for both halves of a Minecraft project.
- Bukkit side: SpigotMC, PaperMC, and Folia, plus a universal engine jar that detects the
  running server at startup and installs the right scheduler — one file instead of three.
- Mod side: Forge, Fabric, and NeoForge, each producing a client jar and a server jar that
  talk over a plugin message channel.
- A shared `api/` contract and a single `common/` facade class, so a developer integrating
  against this plugin reads one file.
- Renaming is driven from `gradle.properties` — organization, repository, and plugin id —
  not scattered across the tree.

## Quick start

The Gradle build is not in place yet; it is being added task by task. Until it lands, see
`.agents/wiki/context/repository-map.md` for exactly what the repository does and does not
contain.

## Documentation

The full map is [`.agents/index/project-wiki-index.md`](.agents/index/project-wiki-index.md).

Start here:

- [Project Overview](wiki/information/overview.md) — what this template is, why both halves
  share one repository, and what a fork changes.

## Working with agents

See [`AGENTS.md`](AGENTS.md). This repository consumes a shared agent instruction set served
over the `lxagents-agents-base` MCP connector; it carries no copy of that set.

## License

See [`LICENSE`](LICENSE).
