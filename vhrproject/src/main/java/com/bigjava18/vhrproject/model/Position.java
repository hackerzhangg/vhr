package com.bigjava18.vhrproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 职位实体类
 */
public class Position {
    private Integer id;

    private String name;

    //JsonFormat:格式化时间
    //@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss",timezone = "Asia/Shanghai")
    //private Date createdate;
    private Date createDate;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /*public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }*/

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}