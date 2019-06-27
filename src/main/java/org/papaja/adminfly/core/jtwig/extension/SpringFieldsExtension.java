package org.papaja.adminfly.core.jtwig.extension;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.extension.Extension;
import org.papaja.adminfly.core.jtwig.extension.function.SpringFlashMessageFunction;

public class SpringFieldsExtension implements Extension {

    @Override
    public void configure(EnvironmentConfigurationBuilder builder) {
        builder.functions()
                .add(new SpringFlashMessageFunction()).and();
    }

}
