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
@Table(name = "investment")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "investor_id")
    private User investor;

    @Basic
    @Column(name = "amount")
    private double amount;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
