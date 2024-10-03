package com.synergisticIT.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    private Integer authorId;

    private Integer publisherId;

    private String isbn;

    private Integer publicationYear;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;
}
