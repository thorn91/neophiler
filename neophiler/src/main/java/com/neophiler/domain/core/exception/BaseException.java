package com.neophiler.domain.core.exception;

import java.util.Collection;
import java.util.Collections;

public class BaseException extends RuntimeException {
    protected IBaseExceptionIdentifier baseExceptionIdentifier;
    protected Collection<String> additionalData = Collections.emptyList();

    public BaseException(IBaseExceptionIdentifier baseExceptionIdentifier) {
        this.baseExceptionIdentifier = baseExceptionIdentifier;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, IBaseExceptionIdentifier baseExceptionIdentifier) {
        super(message);
        this.baseExceptionIdentifier = baseExceptionIdentifier;
    }

    public BaseException(String message, IBaseExceptionIdentifier baseExceptionIdentifier, Collection<String> additionalData) {
        super(message);
        this.baseExceptionIdentifier = baseExceptionIdentifier;
        this.additionalData = additionalData;
    }

    public IBaseExceptionIdentifier getBaseExceptionIdentifier() {
        return baseExceptionIdentifier;
    }

    public String getDeveloperMessage() {
        if (baseExceptionIdentifier == null) {
            return this.getClass().getSimpleName();
        }

        var exceptionName = baseExceptionIdentifier.getClass().getSimpleName();
        var exceptionInfo = baseExceptionIdentifier.toString().toLowerCase().replaceAll("_", " ");
        return exceptionName + " - " + exceptionInfo;
    }

    public Collection<String> getAdditionalData() {
        return additionalData;
    }
}
