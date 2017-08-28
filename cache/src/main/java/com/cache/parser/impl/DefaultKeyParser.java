package com.cache.parser.impl;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.cache.parser.KeyParser;

 
@Component
public class DefaultKeyParser implements KeyParser {


    private static String VARIABLE_IDENTIFIER = "#";

    private static String FIELD_IDENTIFIER = ".";

    @Override
    public String parse(String key, Object[] args, MethodSignature methodSignature) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (isBlank(key)) {
            return null;
        }
        if (!isVariable(key)) {
            return key;
        }

        List<String> argNames = Arrays.asList(methodSignature.getParameterNames());
        if (!isFromField(key)) {
            key = key.substring(1);
            if (!argNames.contains(key)) {
                return null;
            }
            Object arg = args[argNames.indexOf(key)];
            return arg == null ? null : arg.toString();
        }

        String[] split = StringUtils.split(key, FIELD_IDENTIFIER);
        String argName = split[0].substring(1);
        if (!argNames.contains(argName)) {
            return null;
        }
        Class[] argTypes = methodSignature.getParameterTypes();
        Object arg = args[argNames.indexOf(argName)];
        Class type = argTypes[argNames.indexOf(argName)];
        List<String> fields = Arrays.asList(split).subList(1, split.length);
        for (String field : fields) {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field, type);
            arg = propertyDescriptor.getReadMethod().invoke(arg);
            type = propertyDescriptor.getPropertyType();
        }
        return arg == null ? null : arg.toString();
    }

    /**
     * 根据井号（#）判断是变量还是字符串。
     *
     * @param str
     * @return
     */
    public boolean isVariable(String str) {
        return str.startsWith(VARIABLE_IDENTIFIER);
    }

    /**
     * 根据点（.）判断是否包含有次级属性
     *
     * @param str
     * @return
     */
    private boolean isFromField(String str) {
        return str.contains(FIELD_IDENTIFIER);
    }
}