package worldbuilder.entity.equipment.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Range {
    @JsonProperty("normal")
    private int normal;

    @JsonProperty("long")
    private int longRange;
}
