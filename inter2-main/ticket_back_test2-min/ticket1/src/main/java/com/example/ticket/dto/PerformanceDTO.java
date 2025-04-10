package edu.du.tokki.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PerformanceDTO implements Serializable {

    @JsonProperty("pId")
    private Long pId;
    @JsonProperty("pTitle")
    private String pTitle;
    @JsonProperty("pGenre")
    private String pGenre;
    @JsonProperty("pDate")
    private LocalDateTime pDate;
    @JsonProperty("pEndTime")
    private LocalDateTime pEndTime;
    @JsonProperty("pPrice")
    private Integer pPrice;
    @JsonProperty("pPlace")
    private String pPlace;
    @JsonProperty("pImg")
    private String pImg;

    public PerformanceDTO() {}

}


