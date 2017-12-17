package com.shsxt.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YgCusReprieve extends BaseModel {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * loss_id
     * 
     */
    private Integer lossId;

    /**
     * measure
     * 
     */
    private String measure;

    /**
     * is_valid
     * 
     */
    private Integer isValid;

    /**
     * create_date
     * 
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS,timezone = "GMT+8")
    private Date createDate;

    /**
     * update_date
     * 
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS,timezone = "GMT+8")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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