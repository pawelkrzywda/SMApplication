package com.smapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title can't be empty.")
    @Size(min=3, message = "Title must be at least 3 characters long.")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Description can't be empty.")
    @Size(min=5, message = "Description must be at least 5 characters long.")
    @Column(name = "description")
    private String description;

    @NotNull(message = "This value can't be empty.")
    @Column(name = "finished")
    private boolean isDone;
}
