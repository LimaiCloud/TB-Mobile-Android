package com.device.limaiyun.thingsboard.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class DecodeTokenBean {


    /**
     * sub : qiyue@limaicloud.com
     * scopes : ["CUSTOMER_USER"]
     * userId : c01d2320-7390-11e8-b870-e189004f66bf
     * enabled : true
     * isPublic : false
     * tenantId : 3facb4a0-4de6-11e8-b870-e189004f66bf
     * customerId : a1fa7230-7390-11e8-b870-e189004f66bf
     * iss : thingsboard.io
     * iat : 1531271147
     * exp : 1531272047
     */

    private String sub;
    private String userId;
    private boolean enabled;
    private boolean isPublic;
    private String tenantId;
    private String customerId;
    private String iss;
    private int iat;
    private int exp;
    private List<String> scopes;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
}
