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
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Basic
    @Column(name = "amount")
    private double amount;

    @Basic
    @Column(name = "purpose")
    private String purpose;

    @Basic
    @Column(name = "datetime")
    private Timestamp datetime;
}
