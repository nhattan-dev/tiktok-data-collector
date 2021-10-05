package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Ad;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AdList {
    @JsonProperty("page_info")
    private PageInfo page_info;
    @JsonProperty("list")
    private List<Ad> ads;
}
