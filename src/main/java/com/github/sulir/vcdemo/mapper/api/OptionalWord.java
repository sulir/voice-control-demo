package com.github.sulir.vcdemo.mapper.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalWord {
    String value();
}