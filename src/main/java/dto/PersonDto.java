package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("craft")
    private String craft;
    public PersonDto() {
    }
}
