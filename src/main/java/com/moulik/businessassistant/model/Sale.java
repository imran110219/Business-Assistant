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
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "income_id")
    private int incomeId;

    @Basic
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stock_id")
    private int stockId;

    @Basic
    @Column(name = "quantity")
    private double quantity;

    @Basic
    @Column(name = "unit_price")
    private double unitPrice;

    @Basic
    @Column(name = "discount")
    private double discount;

    @Basic
    @Column(name = "total")
    private double total;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}