package com.neophiler.domain.core.user;

import com.neophiler.domain.core.exception.IBaseExceptionIdentifier;

import java.util.UUID;

public enum UserExceptionIdentifier implements IBaseExceptionIdentifier {
    USER_NOT_FOUND("271cd783-4a58-43e4-a3ce-26c3afd61e40"),
    PASSWORD_CANNOT_BE_EMPTY("2fcaf51b-d27e-457d-a714-f9a03972e890"),
    INVALID_PASSWORD("f0b0b2a9-d27e-457d-a714-f9a03972e890");
    private final UUID identifier;

    UserExceptionIdentifier(String uuid) {
        this.identifier = UUID.fromString(uuid);
    }

    public UUID getUUID() {
        return identifier;
    }
}
