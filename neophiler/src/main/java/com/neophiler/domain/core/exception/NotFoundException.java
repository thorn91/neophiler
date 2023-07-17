package com.neophiler.domain.core.exception;

import java.util.Collection;

public class NotFoundException extends BaseException {
    public NotFoundException(String msg, IBaseExceptionType domainExceptionType, Collection<String> additionalData) {
        super(msg, domainExceptionType, additionalData);
    }

    public NotFoundException(String msg, IBaseExceptionType domainExceptionType) {
        super(msg, domainExceptionType);
    }

    public NotFoundException(IBaseExceptionType domainExceptionType) {
        super(domainExceptionType);
    }
}
