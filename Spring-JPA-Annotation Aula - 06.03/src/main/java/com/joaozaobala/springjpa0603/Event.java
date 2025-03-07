package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Column (name = "event_time")
    @Temporal(TemporalType.TIME)
    private Date eventTime;

    @Column (name = "event_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimestamp;



}
