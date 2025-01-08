package com.apiplatform.model;

import lombok.Data;

public class Subscription {
    // src/main/java/com/apiplatform/model/SubscriptionDto.java
//package com.apiplatform.model;

//import lombok.Data;

    @Data
    public class SubscriptionDto {
        private String priceId;
        private String planName;
    }
}
