package org.papaja.adminfly.shared.vendor.jtwig.extension.url;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.extension.Extension;

public class UrlPathExtension implements Extension {

    @Override
    public void configure(EnvironmentConfigurationBuilder builder) {
        builder.functions().add(new UrlPathFunction()).and();
    }

}
