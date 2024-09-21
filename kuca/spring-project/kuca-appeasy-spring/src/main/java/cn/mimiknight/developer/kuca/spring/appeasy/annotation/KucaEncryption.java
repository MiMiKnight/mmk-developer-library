package cn.mimiknight.developer.kuca.spring.appeasy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加密标识注解
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 10:59:47
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface KucaEncryption {

    String algorithm() default "";
}

