package com.neophiler.domain.core.exception;

import java.util.Collection;

public class NotAuthorizedException extends BaseException {
    public NotAuthorizedException(String msg, IBaseExceptionIdentifier domainExceptionType, Collection<String> additionalData) {
        super(msg, domainExceptionType, additionalData);
    }

    public NotAuthorizedException(String msg, IBaseExceptionIdentifier domainExceptionType) {
        super(msg, domainExceptionType);
    }

    public NotAuthorizedException(IBaseExceptionIdentifier domainExceptionType) {
        super(domainExceptionType);
    }
}
