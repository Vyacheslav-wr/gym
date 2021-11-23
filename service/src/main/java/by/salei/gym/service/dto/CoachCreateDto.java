package by.salei.gym.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CoachCreateDto extends AbstractCreateDto {

    private String name;
    private double efficiency;
}
