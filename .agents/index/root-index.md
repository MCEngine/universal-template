---
name: root-index
description: Router for this repository — lists every index it can reach, local and shared, and the shared overrides it declares.
---

# Root Index

This file lists **indexes only**. Never rules, never documentation, never links to leaf
content. Read exactly one branch per task, plus `memory-index.md`, which is read every
session because continuity depends on it.

Adding, removing, or renaming any index updates this table **in the same commit**. Adding or
dropping an override updates the override table below in the same commit.

## Indexes

| Index | Scope | Load when |
|---|---|---|
| `{shared}/index/root-index.md` | The shared instruction set, served by the `lxagents-agents-base` connector | You need a branching, commit, pull request, planning, placement, versioning, or creator convention. |
| [`memory-index.md`](memory-index.md) | `.agents/memory/` dynamic state | You need prior task state, a recorded decision, or must record progress. |

## Shared overrides

| `name` | Local file | Replaces | Why |
|---|---|---|---|

No overrides — this repository uses the shared set unchanged.
