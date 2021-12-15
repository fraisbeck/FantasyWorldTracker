package worldbuilder.entity.equipment.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Damage {
    @JsonProperty("damage_dice")
    private String dice;

    @JsonProperty("damage_type")
    private DamageType type;
}
