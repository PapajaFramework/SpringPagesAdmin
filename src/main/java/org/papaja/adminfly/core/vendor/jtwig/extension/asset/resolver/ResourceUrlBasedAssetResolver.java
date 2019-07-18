package org.papaja.adminfly.core.vendor.jtwig.extension.asset.resolver;

import org.jtwig.spring.asset.resolver.AssetResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

public class ResourceUrlBasedAssetResolver implements AssetResolver {

    @Autowired
    private ResourceUrlProvider provider;

    private String prefix = "/";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String resolve(String asset) {
        return provider.getForLookupPath(String.format("%s/%s", prefix, asset));
    }

}
