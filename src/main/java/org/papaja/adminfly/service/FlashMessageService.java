package org.papaja.adminfly.service;

import org.papaja.adminfly.dto.shared.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@SuppressWarnings({"unused"})
@Service
public class FlashMessageService {

    private MessageSource messages;

    public FlashMessageService(@Autowired MessageSource messages) {
        this.messages = messages;
    }

    public FlashMessage getNoticeMessage(String key, Object... parameters) {
        return getMessage(FlashMessage.Severity.NOTICE, key, parameters);
    }

    public FlashMessage getWarningMessage(String key, Object... parameters) {
        return getMessage(FlashMessage.Severity.WARNING, key, parameters);
    }

    public FlashMessage getErrorMessage(String key, Object... parameters) {
        return getMessage(FlashMessage.Severity.ERROR, key, parameters);
    }

    public FlashMessage getInfoMessage(String key, Object... parameters) {
        return getMessage(FlashMessage.Severity.INFO, key, parameters);
    }

    public FlashMessage getSuccessMessage(String key, Object... parameters) {
        return getMessage(FlashMessage.Severity.SUCCESS, key, parameters);
    }

    public FlashMessage getMessage(FlashMessage.Severity severity, String textKey, Object... parameters) {
        return new FlashMessage(severity,
            getMessage(textKey, parameters),
            getMessage(format("label.flash.%s", severity.getName()))
        );
    }

    public String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters, LocaleContextHolder.getLocale());
    }

}
