package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.MuscleType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class MuscleGetDto extends AbstractGetDto{

    private Long id;
    private MuscleType muscle;
    private Integer power;
}
