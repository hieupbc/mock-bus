package com.example.mockbus.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Route")
public class RouteDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "routeFrom")
    private StationDomain departure;

    @ManyToOne
    @JoinColumn(name = "routeTo")
    private StationDomain destination;

    @Column(name = "price", nullable = false)
    private int price;
    
    @Column(name = "duration", nullable = false)
    private int duration;

    public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@OneToMany(mappedBy = "route")
    private Set<JourneyDomain> journeys;

    public Set<JourneyDomain> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<JourneyDomain> journeys) {
        this.journeys = journeys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StationDomain getDeparture() {
        return departure;
    }

    public void setDeparture(StationDomain departure) {
        this.departure = departure;
    }

    public StationDomain getDestination() {
        return destination;
    }

    public void setDestination(StationDomain destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDomain that = (RouteDomain) o;
        return id == that.id &&
                departure == that.departure &&
                destination == that.destination &&
                price == that.price;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, departure, destination, price);
    }
}
