package com.sarzhynv.brochure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Entity
@ToString
public class Brochure implements Serializable {

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
    private String previewUrl;
    @Getter
    @Setter
    private Date publicationDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brochure_id")
    @Getter
    @Setter
    private List<Page> pages;

    public Brochure() {
    }

    public Brochure(String title, String previewUrl, Date publicationDate) {
        this.title = title;
        this.previewUrl = previewUrl;
        this.publicationDate = publicationDate;
    }

    public void addPage(Page page) {
        if (pages == null) {
            pages = new ArrayList<>();
        }
        pages.add(page);
    }

}
