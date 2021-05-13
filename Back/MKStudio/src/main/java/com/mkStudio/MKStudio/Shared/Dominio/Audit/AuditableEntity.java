package com.mkStudio.MKStudio.Shared.Dominio.Audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

/**
 * Clase que se encarga de controlar quien es el autor de cada clase, cuando fue creada, cuando se modificó por última vez y quién lo modificó por última vez.
 */
public class AuditableEntity {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar auditCreatedDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar auditLastModifiedDate;

    @Column(nullable = false, updatable = false)
    @CreatedBy
    private String auditCreateBy;

    @LastModifiedBy
    private String auditlLastModifiedBy;
}