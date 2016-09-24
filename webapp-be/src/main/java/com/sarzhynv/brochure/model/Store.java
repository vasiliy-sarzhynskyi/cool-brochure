package com.sarzhynv.brochure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Created by Vasiliy on 17.09.2016.
*/
@Entity
@ToString
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @NotNull
    @Getter
    @Setter
    private String name;
    @Embedded
    @Getter
    @Setter
    private GeoLocation geoLocation;

    @ManyToMany
    @JoinTable(name = "store_brochure", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "brochure_id"))
    @Getter
    @Setter
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

    public void addBrochure(Brochure brochure) {
        if (brochures == null) {
            brochures = new ArrayList<>();
        }
        brochures.add(brochure);
    }

}
