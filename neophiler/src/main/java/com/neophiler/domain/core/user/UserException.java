package com.neophiler.domain.core.user;

import com.neophiler.domain.core.exception.IBaseExceptionType;

import java.util.UUID;

public enum UserException implements IBaseExceptionType {
    USER_NOT_FOUND("271cd783-4a58-43e4-a3ce-26c3afd61e40"),
    PASSWORD_CANNOT_BE_EMPTY("2fcaf51b-d27e-457d-a714-f9a03972e890");
    private final UUID identifier;

    UserException(String uuid) {
        this.identifier = UUID.fromString(uuid);
    }

    public UUID getUUID() {
        return identifier;
    }
}
