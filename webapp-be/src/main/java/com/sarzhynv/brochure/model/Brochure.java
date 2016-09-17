package com.sarzhynv.brochure.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Entity
public class Brochure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    private String previewUrl;
    private Date publicationDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brochure_id")
    private List<Page> pages;

    public Brochure() {
    }

    public Brochure(String title, String previewUrl, Date publicationDate) {
        this.title = title;
        this.previewUrl = previewUrl;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void addPage(Page page) {
        if (pages == null) {
            pages = new ArrayList<>();
        }
        pages.add(page);
    }

    @Override
    public String toString() {
        return "Brochure{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                ", publicationDate=" + publicationDate +
                ", pages=" + pages +
                '}';
    }
}
