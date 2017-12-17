package com.shsxt.crm.model;

import java.util.Date;

public class YgUserPermission {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * role_id
     * 角色ID
     */
    private Integer roleId;

    /**
     * module_id
     * 模块ID
     */
    private Integer moduleId;

    /**
     * acl_value
     * 权限值
     */
    private String aclValue;

    /**
     * create_date
     * 
     */
    private Date createDate;

    /**
     * update_date
     * 
     */
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getAclValue() {
        return aclValue;
    }

    public void setAclValue(String aclValue) {
        this.aclValue = aclValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}