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
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seller_id")
    private User seller;

    @Basic
    @Column(name = "total")
    private double total;

    @Basic
    @Column(name = "delivery_cost")
    private double deliveryCost;

    @Basic
    @Column(name = "discount")
    private double discount;

    @Basic
    @Column(name = "payable")
    private double payable;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
