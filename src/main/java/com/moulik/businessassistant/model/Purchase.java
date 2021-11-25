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
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Customer_id")
    private Customer Customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Basic
    @Column(name = "quantity")
    private double quantity;

    @Basic
    @Column(name = "unit_price")
    private Double unitPrice;

    @Basic
    @Column(name = "total")
    private double total;

    @Basic
    @Column(name = "expiry_datetime")
    private Timestamp expiryDatetime;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
