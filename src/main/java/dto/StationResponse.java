package dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationResponse {
    protected String message;
    protected  long timestamp;

    @JsonProperty("iss_position")
    protected StationPosition position;
}
