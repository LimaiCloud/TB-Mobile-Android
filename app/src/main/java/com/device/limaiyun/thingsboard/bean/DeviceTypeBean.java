package com.device.limaiyun.thingsboard.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class DeviceTypeBean {


    /**
     * data : [{"id":{"entityType":"DEVICE","id":"e61f06d0-4de6-11e8-b870-e189004f66bf"},"createdTime":1525251473341,"tenantId":{"entityType":"TENANT","id":"3facb4a0-4de6-11e8-b870-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"13814000-1dd2-11b2-8080-808080808080"},"name":"奇跃工厂Gateway","type":"网关","additionalInfo":{"gateway":true}},{"id":{"entityType":"DEVICE","id":"659ee560-74f2-11e8-b870-e189004f66bf"},"createdTime":1529544507062,"tenantId":{"entityType":"TENANT","id":"3facb4a0-4de6-11e8-b870-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"a1fa7230-7390-11e8-b870-e189004f66bf"},"name":"工装设备1","type":"工装","additionalInfo":{"description":"奇跃力迈云工装设备"}},{"id":{"entityType":"DEVICE","id":"43c1fb10-5352-11e8-b870-e189004f66bf"},"createdTime":1525847342401,"tenantId":{"entityType":"TENANT","id":"3facb4a0-4de6-11e8-b870-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"13814000-1dd2-11b2-8080-808080808080"},"name":"海天注塑机","type":"注塑机","additionalInfo":{"description":"海天牌注塑机"}}]
     * nextPageLink : null
     * hasNext : false
     */

    private Object nextPageLink;
    private boolean hasNext;
    private List<DataBean> data;

    public Object getNextPageLink() {
        return nextPageLink;
    }

    public void setNextPageLink(Object nextPageLink) {
        this.nextPageLink = nextPageLink;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : {"entityType":"DEVICE","id":"e61f06d0-4de6-11e8-b870-e189004f66bf"}
         * createdTime : 1525251473341
         * tenantId : {"entityType":"TENANT","id":"3facb4a0-4de6-11e8-b870-e189004f66bf"}
         * customerId : {"entityType":"CUSTOMER","id":"13814000-1dd2-11b2-8080-808080808080"}
         * name : 奇跃工厂Gateway
         * type : 网关
         * additionalInfo : {"gateway":true}
         */

        private IdBean id;
        private long createdTime;
        private TenantIdBean tenantId;
        private CustomerIdBean customerId;
        private String name;
        private String type;
        private AdditionalInfoBean additionalInfo;

        public IdBean getId() {
            return id;
        }

        public void setId(IdBean id) {
            this.id = id;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public TenantIdBean getTenantId() {
            return tenantId;
        }

        public void setTenantId(TenantIdBean tenantId) {
            this.tenantId = tenantId;
        }

        public CustomerIdBean getCustomerId() {
            return customerId;
        }

        public void setCustomerId(CustomerIdBean customerId) {
            this.customerId = customerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public AdditionalInfoBean getAdditionalInfo() {
            return additionalInfo;
        }

        public void setAdditionalInfo(AdditionalInfoBean additionalInfo) {
            this.additionalInfo = additionalInfo;
        }

        public static class IdBean {
            /**
             * entityType : DEVICE
             * id : e61f06d0-4de6-11e8-b870-e189004f66bf
             */

            private String entityType;
            private String id;

            public String getEntityType() {
                return entityType;
            }

            public void setEntityType(String entityType) {
                this.entityType = entityType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class TenantIdBean {
            /**
             * entityType : TENANT
             * id : 3facb4a0-4de6-11e8-b870-e189004f66bf
             */

            private String entityType;
            private String id;

            public String getEntityType() {
                return entityType;
            }

            public void setEntityType(String entityType) {
                this.entityType = entityType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class CustomerIdBean {
            /**
             * entityType : CUSTOMER
             * id : 13814000-1dd2-11b2-8080-808080808080
             */

            private String entityType;
            private String id;

            public String getEntityType() {
                return entityType;
            }

            public void setEntityType(String entityType) {
                this.entityType = entityType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class AdditionalInfoBean {
            /**
             * gateway : true
             */

            private boolean gateway;

            public boolean isGateway() {
                return gateway;
            }

            public void setGateway(boolean gateway) {
                this.gateway = gateway;
            }
        }
    }
}
