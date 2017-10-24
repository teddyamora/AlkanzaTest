/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teddy
 */
//@Entity
//@Table(name = "IMAGE")
@XmlRootElement
public class Image implements Serializable {
    
    private static final long serialVersionUID = 10L;
    
    private int id;
    private String url;
    private String large_url;
    private String source_id;
    private String copyright;
    private String site;

    public Image() {
    }
    
    

    public Image(int id, String url, String large_url, String source_id, String copyright, String site) {
        this.id = id;
        this.url = url;
        this.large_url = large_url;
        this.source_id = source_id;
        this.copyright = copyright;
        this.site = site;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public void setLarge_url(String large_url) {
        this.large_url = large_url;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    
            
    
}
