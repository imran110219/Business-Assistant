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
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "table")
    private TableName tableName;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "score")
    private long score;
}
