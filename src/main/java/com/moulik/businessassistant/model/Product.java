package com.moulik.businessassistant.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Basic
    @Column(name = "bn_name")
    private String bnName;

    @Basic
    @Column(name = "sku")
    private String sku;

    @Basic
    @Column(name = "purchase_price")
    private double purchasePrice;

    @Basic
    @Column(name = "sale_price")
    private double salePrice;

    @Basic
    @Column(name = "percentage")
    private double percentage;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "product_types", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types;
}
