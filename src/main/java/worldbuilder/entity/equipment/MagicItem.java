package worldbuilder.entity.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MagicItem {
    @JsonProperty("index")
    private String index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("equipment_category")
    private EquipmentCategories eqpCategory;

    @JsonProperty("desc")
    private List<String> description;
}
