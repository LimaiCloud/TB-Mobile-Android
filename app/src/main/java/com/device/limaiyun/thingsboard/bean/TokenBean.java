package com.device.limaiyun.thingsboard.bean;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public class TokenBean {

    public static String TOKEN ;
    /**
     * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZW5hbnRAbGltYWljbG91ZC5jb20iLCJzY29wZXMiOlsiVEVOQU5UX0FETUlOIl0sInVzZXJJZCI6IjRkNjY2NGYwLTJjMWQtMTFlOC1iNzY1LTZkMjM4MWRmNjA5NyIsImVuYWJsZWQiOnRydWUsImlzUHVibGljIjpmYWxzZSwidGVuYW50SWQiOiI0ZDY2NjRmMS0yYzFkLTExZTgtYjc2NS02ZDIzODFkZjYwOTciLCJjdXN0b21lcklkIjoiNGQ2NjY0ZjItMmMxZC0xMWU4LWI3NjUtNmQyMzgxZGY2MDk3IiwiaXNzIjoidGhpbmdzYm9hcmQuaW8iLCJpYXQiOjE1MjQ3OTMxNTksImV4cCI6MTUyNDc5NDA1OX0.32NYvhHxtjH4Z0ZOKve0C_wbpx7j5E36jvhajV2eB_1U3WhKwdpOHzUdTGuOcLrq5gQXrT27WC1mdFKu22PDqg
     * refreshToken : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZW5hbnRAbGltYWljbG91ZC5jb20iLCJzY29wZXMiOlsiUkVGUkVTSF9UT0tFTiJdLCJ1c2VySWQiOiI0ZDY2NjRmMC0yYzFkLTExZTgtYjc2NS02ZDIzODFkZjYwOTciLCJpc1B1YmxpYyI6ZmFsc2UsImlzcyI6InRoaW5nc2JvYXJkLmlvIiwianRpIjoiM2Q4OWIxZDUtMWY1NS00MTdmLWJlOWYtYzg1ZGI5M2JmNzZjIiwiaWF0IjoxNTI0NzkzMTU5LCJleHAiOjE1MjQ3OTY3NTl9.veZXaSwoRRwVDghEonQsRIqO7WgSX0TZcxZes8oewMxllQaSoPnIgVQGYJzsJwjmCtjHNMmsaaZHAhLQJqJ9Kw
     */

    private String token;
    private String refreshToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
