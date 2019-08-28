package org.papaja.adminfly.shared.vendor.jtwig.extension.url;

import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.JtwigFunction;
import org.jtwig.value.WrappedCollection;
import org.jtwig.value.convert.Converter.Result;
import org.jtwig.value.environment.ValueEnvironment;
import org.jtwig.web.servlet.ServletRequestHolder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

public class UrlPathFunction implements JtwigFunction {

    @Override
    public String name() {
        return "url";
    }

    @Override
    public Collection<String> aliases() {
        return Collections.emptyList();
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(1).maximumNumberOfArguments(3);

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        builder.path(getPath(request));

        if (request.getNumberOfArguments() > 1) {
            getCollection(request, 1).get()
                    .forEach(entry -> builder.queryParam(entry.getKey(), entry.getValue()));
        }

        if (request.getNumberOfArguments() > 2) {
            getCollection(request, 2).get()
                    .forEach(entry -> builder.replaceQueryParam(entry.getKey(), entry.getValue()));
        }

        return builder.toUriString();
    }

    private String getPath(FunctionRequest request) {
        return getContextPath() + getString(request, 0);
    }

    private String getString(FunctionRequest request, int index) {
        return getValueEnvironment(request).getStringConverter().convert(request.get(index));
    }

    private Result<WrappedCollection> getCollection(FunctionRequest request, int index) {
        return getValueEnvironment(request).getCollectionConverter().convert(request.get(index));
    }

    private ValueEnvironment getValueEnvironment(FunctionRequest request) {
        return request.getEnvironment().getValueEnvironment();
    }

    private HttpServletRequest getServletRequest() {
        return ServletRequestHolder.get();
    }

    private String getContextPath() {
        return getServletRequest().getContextPath();
    }

}
