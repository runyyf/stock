package com.hugo.stock.entity;/**
 * @Author: yuyf
 * @Description:
 * @Date: Created in 16:40 2018-12-25
 */

import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName Stock
 *@Description TODO
 *@User Administrator
 *@Date 2018-12-25 16:40
 *@Version 1.0
 **/
public class Stock implements Serializable{

    private Long id;
    //名称
    private String name;
    //股票代码
    private String gid;
    //涨跌幅百分比
    private String increPer;
    //'涨跌额'
    private String increase;
    //'今日开盘价'
    private String todayStartPri;
    //'昨日收盘价'
    private String yesterdayEndPri;
    //'当前价格'
    private String nowPri;
    //'今日最高价'
    private String todayMax;
    //'今日最低价'
    private String todayMin;
    //'分时k线图'
    private String picMinUrl;
    //'日k线图'
    private String picDayUrl;
    //'周k线图'
    private String picWeekUrl;
    //'月k线图'
    private String picMonthUrl;

    private Date  dateCreated;
    private Date  dateLastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getIncrePer() {
        return increPer;
    }

    public void setIncrePer(String increPer) {
        this.increPer = increPer;
    }

    public String getIncrease() {
        return increase;
    }

    public void setIncrease(String increase) {
        this.increase = increase;
    }

    public String getTodayStartPri() {
        return todayStartPri;
    }

    public void setTodayStartPri(String todayStartPri) {
        this.todayStartPri = todayStartPri;
    }

    public String getYesterdayEndPri() {
        return yesterdayEndPri;
    }

    public void setYesterdayEndPri(String yesterdayEndPri) {
        this.yesterdayEndPri = yesterdayEndPri;
    }

    public String getNowPri() {
        return nowPri;
    }

    public void setNowPri(String nowPri) {
        this.nowPri = nowPri;
    }

    public String getTodayMax() {
        return todayMax;
    }

    public void setTodayMax(String todayMax) {
        this.todayMax = todayMax;
    }

    public String getTodayMin() {
        return todayMin;
    }

    public void setTodayMin(String todayMin) {
        this.todayMin = todayMin;
    }

    public String getPicMinUrl() {
        return picMinUrl;
    }

    public void setPicMinUrl(String picMinUrl) {
        this.picMinUrl = picMinUrl;
    }

    public String getPicDayUrl() {
        return picDayUrl;
    }

    public void setPicDayUrl(String picDayUrl) {
        this.picDayUrl = picDayUrl;
    }

    public String getPicWeekUrl() {
        return picWeekUrl;
    }

    public void setPicWeekUrl(String picWeekUrl) {
        this.picWeekUrl = picWeekUrl;
    }

    public String getPicMonthUrl() {
        return picMonthUrl;
    }

    public void setPicMonthUrl(String picMonthUrl) {
        this.picMonthUrl = picMonthUrl;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(Date dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }
}
