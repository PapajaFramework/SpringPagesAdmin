package org.papaja.adminfly.core.vendor.jtwig.function.theme;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.extension.Extension;

public class ThemeResolverExtension implements Extension {

    @Override
    public void configure(EnvironmentConfigurationBuilder builder) {
        builder.functions()
            .add(new ThemeMessagesFunction())
            .add(new ThemeNameFunction())
        .and();
    }

}
