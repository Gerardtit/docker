package com.automation.rest.cart.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {
    private long storeId;
    private String slotSchedule;
    private long orderId;
    private long versionNumber;
    private String status;
    private Double total;
    private Address address;
    private String slotStartTS;
    private String slotEndTS;
    private String displayStartTS;
    private String displayEndTS;
    private boolean hasRestrictedItems;
    private String serviceType;
    private String storeTimeZone;
    private UUID slotId;
    private String slotType;
    private String slotPlan;
    private boolean isHybridStore;
    private boolean isPremiumStore;
    private boolean is3PLStore;
    private boolean isOverSizedCart;
    private boolean isMFC;
    private boolean isErumsEnabled;
    private String storeState;
    private String createdTime;
    private boolean isEditable;
    private String banner;
    private boolean isSnap2;

    public long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "storeId=" + storeId +
                ", slotSchedule='" + slotSchedule + '\'' +
                ", orderId=" + orderId +
                ", versionNumber=" + versionNumber +
                ", status=" + status +
                ", total=" + total +
                ", address=" + address +
                ", slotStartTS='" + slotStartTS + '\'' +
                ", slotEndTS='" + slotEndTS + '\'' +
                ", displayStartTS='" + displayStartTS + '\'' +
                ", displayEndTS='" + displayEndTS + '\'' +
                ", hasRestrictedItems='" + hasRestrictedItems +
                ", serviceType=" + serviceType +
                ", storeTimeZone=" + storeTimeZone +
                ", slotId=" + slotId +
                ", slotType=" + slotType +
                ", slotPlan=" + slotPlan +
                ", isHybridStore=" + isHybridStore +
                ", isPremiumStore=" + isPremiumStore +
                ", is3PLStore=" + is3PLStore +
                ", isOverSizedCart=" + isOverSizedCart +
                ", isMFC=" + isMFC +
                ", isErumsEnabled=" + isErumsEnabled +
                ", storeState=" + storeState +
                ", createdTime='" + createdTime + '\'' +
                ", isEditable=" + isEditable +
                ", banner=" + banner +
                '}';
    }
}
