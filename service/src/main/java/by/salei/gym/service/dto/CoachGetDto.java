package by.salei.gym.service.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class CoachGetDto extends AbstractGetDto{

    private Long id;
    private String name;
    private Double efficiency;
    private List<VisitGetDto> schedule;
}
