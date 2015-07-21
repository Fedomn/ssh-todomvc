package com.fedomn.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 附件实体
 */
@Entity
@Table(name = "fj")
public class Fj {

    /**附件标示**/
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "fjbs")
    private String fjbs;

    /**附件名称**/
    @Column(name = "fjmc")
    private String fjmc;

    /**主表标示**/
    @Column(name = "zbbs")
    private String zbbs;

    /**主表名称**/
    @Column(name = "zbmc")
    private String zbmc;

    /**保存路径**/
    @Column(name = "bclj")
    private String bclj;

    public Fj() {
    }

    public Fj(String fjmc) {
        this.fjmc = fjmc;
    }

    public String getFjbs() {
        return fjbs;
    }

    public void setFjbs(String fjbs) {
        this.fjbs = fjbs;
    }

    public String getFjmc() {
        return fjmc;
    }

    public void setFjmc(String fjmc) {
        this.fjmc = fjmc;
    }

    public String getZbbs() {
        return zbbs;
    }

    public void setZbbs(String zbbs) {
        this.zbbs = zbbs;
    }

    public String getZbmc() {
        return zbmc;
    }

    public void setZbmc(String zbmc) {
        this.zbmc = zbmc;
    }

    public String getBclj() {
        return bclj;
    }

    public void setBclj(String bclj) {
        this.bclj = bclj;
    }
}
