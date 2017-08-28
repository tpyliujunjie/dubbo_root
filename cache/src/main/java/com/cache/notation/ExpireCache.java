package com.cache.notation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ExpireCache {

    /**
     * 缓存中key的前缀
     */
    String prefix();

    /**
     * 指定的key的字段
     */
    String[] key() default {};
}