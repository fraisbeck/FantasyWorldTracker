package worldbuilder.entity.equipment;

import worldbuilder.entity.equipment.information.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {
    @JsonProperty("index")
    private String index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("equipment_category")
    private EquipmentCategories eqpCategory;

    @JsonProperty("weapon_category")
    private String wpnCategory;

    @JsonProperty("weapon_range")
    private String wpn_range;

    @JsonProperty("cost")
    private Cost cost;

    @JsonProperty("damage")
    private Damage damage;

    @JsonProperty("range")
    private Range range;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("properties")
    private List<Properties> properties;

    @JsonProperty("url")
    private String url;
}
