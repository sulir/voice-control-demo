package com.github.sulir.vcmapper.impl;

import com.github.sulir.vcmapper.exceptions.UnsupportedParameterException;
import com.github.sulir.vcmapper.parameters.*;

import java.lang.reflect.Parameter;

public class MethodParameter {
    private static final ParameterConverter[] converters = {
            new NumberConverter(),
            new EnumConverter(),
            new StringConverter(),
            new MappedClassConverter()
    };

    private final Parameter parameter;
    private final ParameterConverter converter;

    public MethodParameter(Parameter parameter) throws UnsupportedParameterException {
        this.parameter = parameter;

        for (ParameterConverter converter : converters) {
            if (converter.isForParameter(parameter)) {
                this.converter = converter;
                return;
            }
        }

        throw new UnsupportedParameterException(parameter);
    }

    public Object tryConversion(String term) {
        return converter.tryConversion(term, parameter);
    }
}
