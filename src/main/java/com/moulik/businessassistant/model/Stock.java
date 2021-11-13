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
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "unit_id")
    private int unitId;

    @Basic
    @Column(name = "quantity")
    private double quantity;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
