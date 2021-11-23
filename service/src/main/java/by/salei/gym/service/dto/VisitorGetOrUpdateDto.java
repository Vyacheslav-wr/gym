package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.dao.entity.Visit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitorGetOrUpdateDto extends AbstractGetOrUpdateDto {

    private Long id;
    private String name;
    private List<Muscle> muscles;
    private List<Visit> schedule;
}
