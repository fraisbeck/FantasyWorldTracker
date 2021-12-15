package worldbuilder.entity.equipment;

import worldbuilder.entity.equipment.information.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Armor {
    @JsonProperty("index")
    private String index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("equipment_category")
    private EquipmentCategories eqpCategory;

    @JsonProperty("armor_category")
    private String armCategory;

    @JsonProperty("armor_class")
    private ArmorClass armClass;

    @JsonProperty("str_minimum")
    private int strMinimum;

    @JsonProperty("steal_disadvantage")
    private Boolean stealth;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("cost")
    private Cost cost;

    @JsonProperty("url")
    private String url;
}
