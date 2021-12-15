package worldbuilder.entity.equipment.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cost {

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unit")
    private String coinType;
}
