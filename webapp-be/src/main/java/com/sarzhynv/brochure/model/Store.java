package com.sarzhynv.brochure.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
* Created by Vasiliy on 17.09.2016.
*/
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @Embedded
    private GeoLocation geoLocation;

    @ManyToMany
    @JoinTable(name = "store_brochure", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "brochure_id"))
    private List<Brochure> brochures;


    public Store() {
    }

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, GeoLocation geoLocation) {
        this.name = name;
        this.geoLocation = geoLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public List<Brochure> getBrochures() {
        return brochures;
    }

    public void setBrochures(List<Brochure> brochures) {
        this.brochures = brochures;
    }

    public void addBrochure(Brochure brochure) {
        if (brochures == null) {
            brochures = new ArrayList<>();
        }
        brochures.add(brochure);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", geoLocation=" + geoLocation +
                ", brochures=" + brochures +
                '}';
    }
}
