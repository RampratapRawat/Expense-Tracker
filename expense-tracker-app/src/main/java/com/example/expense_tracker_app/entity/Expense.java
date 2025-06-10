package com.example.expense_tracker_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate expenseDate;

    @ManyToOne // many expenses belong to one category
    @JoinColumn(name="category_id")//create foreign key column in expenses table
    private Category category;


}
