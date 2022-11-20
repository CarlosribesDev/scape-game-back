package com.games.calendar.persistence.entity;

import com.games.calendar.model.constants.GameType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="type",nullable = false)
    private GameType type;

    @Column(name="price",nullable = false)
    private Float price;

    @Column(name="duration" ,nullable = false)
    private Integer duration;

    @BatchSize(size = 1000)
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookingEntity> bookings;
}
