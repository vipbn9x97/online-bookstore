package com.learnmonilithic.entity;

import com.learnmonilithic.model.BaseAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "books")
public class Book extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long BookId;
    private String title;
    private Long authorId;
    private Long publisherId;
    private int publicationYear;
    private double price;
    private int quantity;
    private String description;
    private String image;
    private Long categoryId;
    private boolean status;
}
