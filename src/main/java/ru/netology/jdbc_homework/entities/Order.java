package ru.netology.jdbc_homework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 20)
    private String date;
    @Column(nullable = false, length = 20)
    private String productName;
    @Column(nullable = false, length = 20)
    private String amount;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id",
    insertable = false, updatable = false)
    private Customer customer;




}
