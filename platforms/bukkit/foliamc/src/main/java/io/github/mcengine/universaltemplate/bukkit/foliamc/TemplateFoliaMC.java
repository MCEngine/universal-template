package io.github.mcengine.universaltemplate.bukkit.foliamc;

import io.github.mcengine.universaltemplate.bukkit.core.AbstractTemplatePlugin;
import io.github.mcengine.universaltemplate.bukkit.core.scheduler.PlatformScheduler;
import io.github.mcengine.universaltemplate.bukkit.foliamc.scheduler.FoliaPlatformScheduler;

/**
 * Folia entry point.
 *
 * <p>Installs the region-aware scheduler and inherits everything else from
 * {@link AbstractTemplatePlugin}.</p>
 */
public class TemplateFoliaMC extends AbstractTemplatePlugin {

    /**
     * {@inheritDoc}
     */
    @Override
    protected PlatformScheduler createScheduler() {
        return new FoliaPlatformScheduler(this);
    }
}
