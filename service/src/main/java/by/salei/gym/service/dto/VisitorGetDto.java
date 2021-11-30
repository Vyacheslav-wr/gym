package by.salei.gym.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitorGetDto extends AbstractGetDto{

    private Long id;
    private String name;
    private List<VisitGetDto> schedule;
    private List<MuscleGetDto> muscles;
}
