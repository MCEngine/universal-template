---
name: memory-decisions-template-identity-values
description: The namespace, plugin id, initial version and Minecraft target chosen for this template, and the reasoning behind each.
---

# Decision: the template's identity values

## Context

The repository is `MCEngine/universal-template`. The group had to be `io.github.{orgname}`
and the namespace `io.github.{orgname}.{reponame}`, with `orgname` and `reponame` taken from
the Git organization and repository names and stored in `gradle.properties`. Java package
segments cannot contain hyphens, so `universal-template` could not be used verbatim.

## Choice

| Property | Value | Consequence |
|---|---|---|
| `orgname` | `mcengine` | Group is `io.github.mcengine`. |
| `reponame` | `universaltemplate` | Namespace is `io.github.mcengine.universaltemplate`. |
| `pluginid` | `Template` | Class and jar base names: `TemplateSpigotMC`, `TemplateEngine-{version}.jar`. |
| `project-version` | `0.0.0` | First log directory is `wiki/logs/0/0/0/`. |
| Minecraft target | `26.1.2` | Matches the reference repository `MCOriax/mcidentity`. |

The hyphen is dropped rather than replaced, so one value serves as both the property and the
package segment and there is no derivation step to keep in sync. The literal Git names are
kept separately as `git-org-name=MCEngine` and `git-repository=universal-template`, used only
to build the GitHub Packages URL, which needs the real repository name.

## Consequence

Everything a fork renames is driven from `gradle.properties`. Adding anything that hardcodes
the organization, repository or plugin id instead of reading a property is a regression, and
`PROMPT.md` is the checklist that keeps the rename honest.
