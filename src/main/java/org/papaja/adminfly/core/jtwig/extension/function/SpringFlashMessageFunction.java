package org.papaja.adminfly.core.jtwig.extension.function;

import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.SimpleJtwigFunction;

public class SpringFlashMessageFunction extends SimpleJtwigFunction {

    @Override
    public String name() {
        return "flash";
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(1).maximumNumberOfArguments(2);

        return String.format("[%s_%s]", request.get(0).toString(), request.get(1).toString());
    }
}
