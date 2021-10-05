package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageInfo {
    @JsonProperty("total_number")
    private int total_number;
    @JsonProperty("page")
    private int page;
    @JsonProperty("page_size")
    private int page_size;
    @JsonProperty("total_page")
    private int total_page;
}
