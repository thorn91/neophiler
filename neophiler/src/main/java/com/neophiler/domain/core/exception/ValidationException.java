package com.neophiler.domain.core.exception;

import java.util.Collection;

public class ValidationException extends BaseException {
    public ValidationException(String msg, IBaseExceptionType domainExceptionType, Collection<String> additionalData) {
        super(msg, domainExceptionType, additionalData);
    }

    public ValidationException(String msg, IBaseExceptionType domainExceptionType) {
        super(msg, domainExceptionType);
    }

    public ValidationException(IBaseExceptionType domainExceptionType) {
        super(domainExceptionType);
    }
}
