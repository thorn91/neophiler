package com.neophiler.domain;

import java.time.LocalDateTime;

public abstract class AbstractBaseEntity {

    public abstract Long getId();

    public abstract LocalDateTime getCreatedDateTime();

    public abstract LocalDateTime getUpdatedDateTime();

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (getId() == null || other == null || !(this.getClass().equals(other.getClass()))) return false;
        AbstractBaseEntity that = (AbstractBaseEntity) other;
        return getId().equals(that.getId());
    }

}
