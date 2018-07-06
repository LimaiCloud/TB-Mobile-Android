package com.device.limaiyun.thingsboard.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public class DashBoardsBean {


    /**
     * data : [{"id":{"entityType":"DASHBOARD","id":"fc455a60-37d7-11e8-b870-e189004f66bf"},"createdTime":1522826142470,"tenantId":{"entityType":"TENANT","id":"4a161030-2c17-11e8-9904-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"23584090-37d8-11e8-b870-e189004f66bf"},"title":"Factory1-Workshop1-Dashboard","name":"Factory1-Workshop1-Dashboard"},{"id":{"entityType":"DASHBOARD","id":"4ba71070-2c17-11e8-9904-e189004f66bf"},"createdTime":1521533919991,"tenantId":{"entityType":"TENANT","id":"4a161030-2c17-11e8-9904-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"13814000-1dd2-11b2-8080-808080808080"},"title":"Raspberry PI GPIO Demo Dashboard","name":"Raspberry PI GPIO Demo Dashboard"},{"id":{"entityType":"DASHBOARD","id":"4ba2f1c0-2c17-11e8-9904-e189004f66bf"},"createdTime":1521533919964,"tenantId":{"entityType":"TENANT","id":"4a161030-2c17-11e8-9904-e189004f66bf"},"customerId":{"entityType":"CUSTOMER","id":"13814000-1dd2-11b2-8080-808080808080"},"title":"Temperature & Humidity Demo Dashboard","name":"Temperature & Humidity Demo Dashboard"}]
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
         * id : {"entityType":"DASHBOARD","id":"fc455a60-37d7-11e8-b870-e189004f66bf"}
         * createdTime : 1522826142470
         * tenantId : {"entityType":"TENANT","id":"4a161030-2c17-11e8-9904-e189004f66bf"}
         * customerId : {"entityType":"CUSTOMER","id":"23584090-37d8-11e8-b870-e189004f66bf"}
         * title : Factory1-Workshop1-Dashboard
         * name : Factory1-Workshop1-Dashboard
         */

        private IdBean id;
        private long createdTime;
        private TenantIdBean tenantId;
        private CustomerIdBean customerId;
        private String title;
        private String name;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class IdBean {
            /**
             * entityType : DASHBOARD
             * id : fc455a60-37d7-11e8-b870-e189004f66bf
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
             * id : 4a161030-2c17-11e8-9904-e189004f66bf
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
             * id : 23584090-37d8-11e8-b870-e189004f66bf
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
    }
}
