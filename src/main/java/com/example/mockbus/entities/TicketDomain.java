package com.example.mockbus.entities;

import com.example.mockbus.entities.audit.DateAudit;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Ticket")
public class TicketDomain extends DateAudit {
    /**
     *
     */
    private static final long serialVersionUID = -4296209842296808L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "journeyId")
    private JourneyDomain journey;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserDomain user;

    @Column(name = "status", nullable = true)
    private int status;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "seatId", insertable = false, updatable = false),
            @JoinColumn(name = "bus", insertable = false, updatable = false)
    })
    private SeatDomain seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JourneyDomain getJourney() {
        return journey;
    }

    public void setJourney(JourneyDomain journey) {
        this.journey = journey;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SeatDomain getSeat() {
        return seat;
    }

    public void setSeat(SeatDomain seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TicketDomain that = (TicketDomain) o;
        return id == that.id && journey == that.journey && user == that.user && Objects.equals(status, that.status)
                && Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, journey, user, status, seat);
    }
}
