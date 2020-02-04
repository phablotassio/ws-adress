package com.address.api.util;

import com.address.api.exception.MessageError;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public abstract class MessagesUtil {

    private MessagesUtil() {
    }

    public static String getMessage(MessageError messageCode, Object... args) {
        return getMessage(messageCode.getCode().toString(), args);
    }

    public static String getMessage(String messageCode, Object... args) {
        return getMessageSource().getMessage(messageCode, args, Locale.getDefault());
    }

    public static String getMessage(MessageSourceResolvable resolvable) {
        return getMessageSource().getMessage(resolvable, Locale.getDefault());
    }

    private static MessageSource getMessageSource() {

        ResourceBundleMessageSource newMessageSource = new ResourceBundleMessageSource();
        newMessageSource.setBasename("i18n/messages");
        newMessageSource.setDefaultEncoding("UTF-8");

        return newMessageSource;

    }


}
