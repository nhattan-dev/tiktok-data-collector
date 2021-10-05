package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AdgroupResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private String code;
    @JsonProperty("data")
    private AdGroupList adGroupList;
}
