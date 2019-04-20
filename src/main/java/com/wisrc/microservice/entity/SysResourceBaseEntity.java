package com.wisrc.microservice.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "sys_resource_base", schema = "iot_system", catalog = "")
@Where(clause = "delete_flag = 0")
public class SysResourceBaseEntity {
    private int id;
    private String name;
    private Integer parentId;
    private Integer authorityControl;
    private String deleteFlag;
    private Integer level;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "authority_control")
    public Integer getAuthorityControl() {
        return authorityControl;
    }

    public void setAuthorityControl(Integer authorityControl) {
        this.authorityControl = authorityControl;
    }

    @Basic
    @Column(name = "delete_flag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysResourceBaseEntity that = (SysResourceBaseEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (authorityControl != null ? !authorityControl.equals(that.authorityControl) : that.authorityControl != null)
            return false;
        if (deleteFlag != null ? !deleteFlag.equals(that.deleteFlag) : that.deleteFlag != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (authorityControl != null ? authorityControl.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
