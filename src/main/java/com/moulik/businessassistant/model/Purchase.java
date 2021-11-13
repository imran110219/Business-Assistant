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
    private int id;

    @Basic
    @Column(name = "expense_id")
    private int expenseId;

    @Basic
    @Column(name = "product_id")
    private int productId;

    @Basic
    @Column(name = "unit_id")
    private int unitId;

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
