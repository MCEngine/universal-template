---
name: memory-index
description: Index of .agents/memory/ — task records, durable decisions, and current repository state.
---

# Memory Index

**Scope:** `.agents/memory/`
**Parent:** [root-index](root-index.md)

Any file added to or removed from `.agents/memory/` is reflected here in the same commit.
This index lists memory files only — never rules, never documentation.

Memory is written freely and automatically; it is the one tree exempt from the discovery
protocol's approval gate. See `{shared}/rules/memory-policy.md`.

## Tasks

| File | Purpose |
|---|---|
| [`tasks/universal-plugin-template.md`](../memory/tasks/universal-plugin-template.md) | Scaffolding this repository into a universal plugin template: the confirmed task list and one entry per task. |
