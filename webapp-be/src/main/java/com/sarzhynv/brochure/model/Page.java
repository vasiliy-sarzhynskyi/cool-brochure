package com.sarzhynv.brochure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Entity
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @NotNull
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String url;

    public Page() {
    }

    public Page(String title, String url) {
        this.title = title;
        this.url = url;
    }

}
