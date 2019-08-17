package org.papaja.adminfly.shared.vendor.jtwig.extension.theme;

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
