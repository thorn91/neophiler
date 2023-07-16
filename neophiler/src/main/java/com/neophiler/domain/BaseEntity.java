package com.neophiler.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "createdDateTime", nullable = false)
    @CreationTimestamp
    protected LocalDateTime createdDateTime;

    @Column(name = "updatedDateTime", nullable = false)
    @UpdateTimestamp
    protected LocalDateTime updatedDateTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    @Override
    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }
}
