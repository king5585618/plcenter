package com.kakarot.plcenter.job;

import java.lang.annotation.*;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleScheduled {

    String cron() default "";

    String description() default "";
}
