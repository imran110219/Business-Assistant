package com.moulik.businessassistant.model;

import lombok.*;

import javax.persistence.*;
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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "unit_id")
    private int unitId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "bn_name")
    private String bnName;

    @Basic
    @Column(name = "purchase_price")
    private double purchasePrice;

    @Basic
    @Column(name = "sale_price")
    private double salePrice;

    @Basic
    @Column(name = "percentage")
    private double percentage;
}
