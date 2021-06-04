package com.rapisolver.reservation.entities;

import com.rapisolver.reservation.util.ReservationStatus;
import com.rapisolver.reservation.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date datetime;

    @Column(length = 70, nullable = false)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_attention_id", nullable = false)
    private UserAttention userAttention;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;*/
}
