package worldbuilder.entity.equipment.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DamageType {
    @JsonProperty("name")
    private String name;

    @JsonProperty("index")
    private String index;

    @JsonProperty("url")
    private String url;
}
