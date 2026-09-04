# Changelog — 0.0.0

**Released:** 2026-09-04

Establishes the repository: the agent instruction system, the two documentation trees, and
the memory tree. No build and no source modules yet — those land in later entries against
this same version.

## Added

- `AGENTS.md` — entry point carrying the `lxagents-agents-base` connector bootstrap block,
  the auto-activation contract, the trigger table mirrored row for row from the shared
  `auto-activation.md`, the reading order, the routing protocol, the iron rule, the
  discovery protocol, and the version and session-link rules.
- `.claude/CLAUDE.md` — a single import of `../AGENTS.md`, so Claude Code and every other
  agent read one set of instructions rather than two that can disagree.
- `.agents/index/` — six indexes: `root-index.md` with the override table, plus
  `agents-index.md`, `agent-wiki-index.md`, `project-wiki-index.md`, `memory-index.md`, and
  `logs-index.md`.
- `.agents/rules/repository.md` — this repository's rules hub: the consumer mode it runs in,
  the connector it resolves, the template invariant that renameable identifiers are driven
  from `gradle.properties`, and the version carriers.
- `.agents/wiki/context/repository-map.md` — agent orientation: what exists, what does not
  yet, where each kind of new file goes, and the build's gotchas.
- `.agents/memory/state/repository-state.md` and
  `.agents/memory/tasks/universal-plugin-template.md` — current state and the confirmed
  eight-task plan, written before the work it describes.
- `.agents/memory/decisions/` — three durable decisions: the template's identity values, why
  `PROMPT.md` sits at the repository root against the directory rule, and why the harness
  session trailer is stripped from everything recorded here.
- `wiki/information/overview.md` — what the template is, why both halves share one
  repository, and what a fork changes.

## Changed

- `README.md` reduced to an overview, with the detail moved into `wiki/information/overview.md`.
