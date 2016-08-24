package com.allstate.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studios")
public class Studio {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date est;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    public Studio() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Studio(int id) {
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getEst() {
        return est;
    }
    public void setEst(Date est) {
        this.est = est;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
