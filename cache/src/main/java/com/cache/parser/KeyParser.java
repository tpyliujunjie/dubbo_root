package com.cache.parser;
import org.aspectj.lang.reflect.MethodSignature;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public interface KeyParser {
	 /**
     * parse string into keys
     *
     * @param key
     * @return
     */
    String parse(String key, Object[] args, MethodSignature methodSignature) throws IntrospectionException, InvocationTargetException, IllegalAccessException;

    /**
     * determine whether it's variable
     *
     * @param key
     * @return
     */
    boolean isVariable(String key);
}
