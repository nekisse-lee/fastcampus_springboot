package com.nekisse.myweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class BoardDto {


    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String location;


    private String img;

    private LocalDate reportingDate;

    @Builder
    public BoardDto(String title, String description, String location, String img, LocalDate reportingDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.img = img;
        this.reportingDate = reportingDate;
    }
}
