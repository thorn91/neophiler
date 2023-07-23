package com.neophiler.domain.core.exception;

import java.util.Collection;
import java.util.Collections;

public class BaseException extends RuntimeException {
    protected IBaseExceptionIdentifier baseExceptionType;
    protected Collection<String> additionalData = Collections.emptyList();

    public BaseException(IBaseExceptionIdentifier baseExceptionType) {
        this.baseExceptionType = baseExceptionType;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, IBaseExceptionIdentifier baseExceptionType) {
        super(message);
        this.baseExceptionType = baseExceptionType;
    }

    public BaseException(String message, IBaseExceptionIdentifier baseExceptionType, Collection<String> additionalData) {
        super(message);
        this.baseExceptionType = baseExceptionType;
        this.additionalData = additionalData;
    }

    public IBaseExceptionIdentifier getBaseExceptionType() {
        return baseExceptionType;
    }

    public String getDeveloperMessage() {
        if (baseExceptionType == null) {
            return this.getClass().getSimpleName();
        }

        var exceptionName = baseExceptionType.getClass().getSimpleName();
        var exceptionInfo = baseExceptionType.toString().toLowerCase().replaceAll("_", " ");
        return exceptionName + " - " + exceptionInfo;
    }

    public Collection<String> getAdditionalData() {
        return additionalData;
    }
}
