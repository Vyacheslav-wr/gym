package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.Muscle;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitorCreateDto extends AbstractCreateDto {

    private String name;
    private List<Muscle> muscles;
}
