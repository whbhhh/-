package com.shsxt.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YgOrderDetails extends BaseModel{
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * order_id
     * id
     */
    private Integer orderId;

    /**
     * goods_name
     * 商品名称
     */
    private String goodsName;

    /**
     * goods_num
     * 订购数量
     */
    private Integer goodsNum;

    /**
     * unit
     * 单位
     */
    private String unit;

    /**
     * price
     * 单价
     */
    private Float price;

    /**
     * sum
     * 金额
     */
    private Float sum;

    /**
     * is_valid
     * 是否删除
     */
    private Integer isValid;

    /**
     * create_date
     * 创建时间
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS,timezone = "GMT+8")
    private Date createDate;

    /**
     * update_date
     * 更新时间
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
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