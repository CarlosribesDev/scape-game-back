package com.games.calendar.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="service_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private DayEntity day;

    @Column(name="hour")
    private String hour;

    @Column(name="is_busy")
    private Boolean isBusy;
}
