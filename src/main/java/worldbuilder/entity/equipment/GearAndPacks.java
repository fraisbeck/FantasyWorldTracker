package worldbuilder.entity.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import worldbuilder.entity.equipment.information.Cost;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GearAndPacks {
    @JsonProperty("index")
    private String index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("equipment_category")
    private EquipmentCategories eqpCategory;

    @JsonProperty("gear_category")
    private EquipmentCategories gearCategory;

    @JsonProperty("cost")
    private Cost cost;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("url")
    private String url;
}
