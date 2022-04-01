package com.hendro.alterra.domain.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseDao {

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "created_by", nullable = false)
    private String created_by;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


    @PrePersist
    void onCreate() {
        this.created_at = LocalDateTime.now();
        this.created_by = "SYSTEM";
        this.isDeleted = Boolean.FALSE;

    }

    @PreUpdate
    void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }


}
