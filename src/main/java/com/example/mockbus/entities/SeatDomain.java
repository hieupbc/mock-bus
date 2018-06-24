package com.example.mockbus.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Seat")
@IdClass(SeatDomainPK.class)
public class SeatDomain {

    @Id
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "bus")
    private BusDomain bus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public BusDomain getBus() {
        return bus;
    }

    public void setBus(BusDomain bus) {
        this.bus = bus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDomain that = (SeatDomain) o;
        return id == that.id &&
                bus == that.bus ;    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bus);
    }
}
