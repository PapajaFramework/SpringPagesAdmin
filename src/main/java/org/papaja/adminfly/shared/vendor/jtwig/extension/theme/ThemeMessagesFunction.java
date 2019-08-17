package org.papaja.adminfly.shared.vendor.jtwig.extension.theme;

import org.jtwig.functions.FunctionRequest;

import java.util.Collection;
import java.util.Collections;

public class ThemeMessagesFunction extends AbstractThemeMessagesFunction {

    @Override
    public String name() {
        return "theme";
    }

    @Override
    public Collection<String> aliases() {
        return Collections.emptyList();
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(1).maximumNumberOfArguments(1);

        return getThemeMessage(request.get(0).toString());
    }

    protected String getThemeMessage(String key) {
        return getCurrentTheme().getMessageSource().getMessage(key, new Object[]{}, null);
    }

}
