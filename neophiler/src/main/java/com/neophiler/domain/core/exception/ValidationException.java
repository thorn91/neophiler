package com.neophiler.domain.core.exception;

import java.util.Collection;

public class ValidationException extends BaseException {
    public ValidationException(String msg, IBaseExceptionIdentifier domainExceptionType, Collection<String> additionalData) {
        super(msg, domainExceptionType, additionalData);
    }

    public ValidationException(String msg, IBaseExceptionIdentifier domainExceptionType) {
        super(msg, domainExceptionType);
    }

    public ValidationException(IBaseExceptionIdentifier domainExceptionType) {
        super(domainExceptionType);
    }
}
