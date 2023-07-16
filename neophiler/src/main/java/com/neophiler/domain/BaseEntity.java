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

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDateTime getCreatedDateTime() {
        return createdAt;
    }

    @Override
    public LocalDateTime getUpdatedDateTime() {
        return updatedAt;
    }
}
