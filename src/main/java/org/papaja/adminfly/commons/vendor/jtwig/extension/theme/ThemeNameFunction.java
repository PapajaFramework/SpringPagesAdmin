package org.papaja.adminfly.commons.vendor.jtwig.extension.theme;

import org.jtwig.functions.FunctionRequest;

public class ThemeNameFunction extends AbstractThemeMessagesFunction {

    @Override
    public String name() {
        return "themeName";
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(0).maximumNumberOfArguments(0);

        return getCurrentTheme().getName();
    }

}
