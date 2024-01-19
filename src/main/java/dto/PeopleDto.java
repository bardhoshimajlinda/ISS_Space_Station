package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleDto {
    @JsonProperty("number")
    private int numberOfPeople;
    @JsonProperty("people")
    private List<PersonDto> people;
}
