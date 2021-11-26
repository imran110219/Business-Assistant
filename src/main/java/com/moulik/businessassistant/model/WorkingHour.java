package com.moulik.businessassistant.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Sadman
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="working_hours")
public class WorkingHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "worker_id")
    private User worker;

    @Basic
    @Column(name = "hour")
    private double hour;

    @Basic
    @Column(name = "purpose")
    private String purpose;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
