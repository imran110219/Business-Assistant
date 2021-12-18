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
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    public Type() {
    }
}
