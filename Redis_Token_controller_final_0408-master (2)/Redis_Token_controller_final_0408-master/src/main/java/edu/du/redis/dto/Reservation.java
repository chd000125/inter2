package edu.du.redis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class Reservation {

    @JsonProperty("uName")
    private String uName;

    @JsonProperty("uId")
    private Long uId;

    @JsonProperty("pId")
    private Long pId;

    @JsonProperty("pTitle")
    private String pTitle;

    @JsonProperty("pPlace")
    private String pPlace;

    @JsonProperty("pDate")
    private String pDate;

    @JsonProperty("pPrice")
    private String pPrice;

    @JsonProperty("pAllSpot")
    private Integer pAllSpot;

    @JsonProperty("rId")
    private Long rId;

    @JsonProperty("rSpot")
    private String rSpot;

    @JsonProperty("rSpotStatus")
    private String rSpotStatus;

    @JsonProperty("rPhone")
    private String rPhone;

    @JsonProperty("rEmail")
    private String rEmail;

    @JsonProperty("rTime")
    private LocalDateTime rTime;
}
