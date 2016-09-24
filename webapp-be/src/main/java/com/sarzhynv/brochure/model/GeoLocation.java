package com.sarzhynv.brochure.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
* Created by Vasiliy on 17.09.2016.
*/
public class GeoLocation implements Serializable {

    @Getter
    @Setter
    private Double latitude;
    @Getter
    @Setter
    private Double longitude;

    public GeoLocation() {
    }

    public GeoLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
