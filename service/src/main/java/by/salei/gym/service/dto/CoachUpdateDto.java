package by.salei.gym.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CoachUpdateDto extends AbstractUpdateDto {

    private Long id;
    private String name;
    private Double efficiency;
}
