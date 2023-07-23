package com.neophiler.domain.core.exception;

import java.util.Collection;

public class NotFoundException extends BaseException {
    public NotFoundException(String msg, IBaseExceptionIdentifier domainExceptionType, Collection<String> additionalData) {
        super(msg, domainExceptionType, additionalData);
    }

    public NotFoundException(String msg, IBaseExceptionIdentifier domainExceptionType) {
        super(msg, domainExceptionType);
    }

    public NotFoundException(IBaseExceptionIdentifier domainExceptionType) {
        super(domainExceptionType);
    }
}
