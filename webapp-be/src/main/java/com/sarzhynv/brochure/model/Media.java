package com.sarzhynv.brochure.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Vasiliy on 17.09.2016.
 */
public class Media implements Serializable {

    @Getter
    @Setter
    private String smallImageUrl;
    @Getter
    @Setter
    private String mediumImageUrl;
    @Getter
    @Setter
    private String largeImageUrl;

}
