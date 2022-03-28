package com.automation.mobile.enums;

public enum WorkflowType {

    tomthumb,
    vons,
    acme,
    albertsons,
    jewelosco,
    pavilions,
    randalls,
    safeway,
    shaws,
    starmarket;

    public String getWorkflow() {

        if (name().equalsIgnoreCase(tomthumb.toString())) {

            return "Enterprise-Deploy-TomThumb";
        } else if (name().equalsIgnoreCase(vons.toString())) {

            return "Enterprise-Deploy-Vons";
        } else if (name().equalsIgnoreCase(acme.toString())) {

            return "Enterprise-Deploy-Acme";
        } else if (name().equalsIgnoreCase(albertsons.toString())) {

            return "Enterprise-Deploy-Albertsons";
        } else if (name().equalsIgnoreCase(jewelosco.toString())) {

            return "Enterprise-Deploy-JewelOsco";
        } else if (name().equalsIgnoreCase(pavilions.toString())) {

            return "Enterprise-Deploy-Pavilions";
        } else if (name().equalsIgnoreCase(randalls.toString())) {

            return "Enterprise-Deploy-Randalls";
        } else if (name().equalsIgnoreCase(safeway.toString())) {

            return "Enterprise-Deploy-Safeway";
        } else if (name().equalsIgnoreCase(shaws.toString())) {

            return "Enterprise-Deploy-Shaws";
        } else if (name().equalsIgnoreCase(starmarket.toString())) {

            return "Enterprise-Deploy-StarMarket";
        }

        return "";
    }
}
