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
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private int productId;
    
    @Basic
    @JoinColumn(name = "type_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private int typeId;
}
