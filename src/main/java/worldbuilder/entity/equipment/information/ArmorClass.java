package worldbuilder.entity.equipment.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArmorClass {
    @JsonProperty("base")
    private int base;

    @JsonProperty("dex_bonus")
    private Boolean dexBonus;

    @JsonProperty("max_bonus")
    private int maxBonus;
}
