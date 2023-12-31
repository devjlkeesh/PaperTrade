package dev.jlkeesh.papertrade.utils;

import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;


public final class BaseUtils {

    public static final String emailRegex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String phoneRegex = "^\\d{9}$";

    public static final Pattern emailPattern = Pattern.compile(emailRegex);
    public static final Pattern phonePattern = Pattern.compile(phoneRegex);

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    public static boolean isEmpty(Object o) {
        return o == null;
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isEmpty(String o) {
        return !isNotEmpty(o);
    }

    public static boolean isNotEmpty(String o) {
        return StringUtils.hasText(o);
    }

}
