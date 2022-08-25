package com.example.invitation_card_projectbackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
@Entity @NoArgsConstructor
public class CardOrder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "Id can't be null")
    @Id
    private Integer id;

    @NotEmpty(message = "Event title can't be empty")
    private String eventTitle;

    @NotEmpty(message = "Content card can't be empty")
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotEmpty(message = "Date can't be empty")
    @JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "date")
    private String date;

    @NotEmpty(message = "Day can't be empty")
    private String day;

    @NotNull(message = "Location can't be empty")
    private String location;

    private Integer price=50;

    private Boolean status=true;

    @NotEmpty(message = "Username can't be empty")
    private String customerUsername;

    @NotNull(message = "Id customer can't be null")
    @Positive(message = "Id must be positive number")
    private Integer customerId;

}
