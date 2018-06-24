package com.example.mockbus.entities;

import java.io.Serializable;
import java.util.Objects;

public class SeatDomainPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
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
        SeatDomainPK that = (SeatDomainPK) o;
        return id == that.id &&
                bus == that.bus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bus);
    }
}
