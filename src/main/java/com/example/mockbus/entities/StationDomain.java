package com.example.mockbus.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Station")
public class StationDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;


    @OneToMany(mappedBy = "destination")
    private Set<RouteDomain> routeTo;

    @OneToMany(mappedBy = "departure")
    private Set<RouteDomain> routeFrom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RouteDomain> getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(Set<RouteDomain> routeTo) {
        this.routeTo = routeTo;
    }

    public Set<RouteDomain> getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(Set<RouteDomain> routeFrom) {
        this.routeFrom = routeFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDomain that = (StationDomain) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }
}
