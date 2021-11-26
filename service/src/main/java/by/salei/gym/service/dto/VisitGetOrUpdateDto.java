package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Visit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitGetOrUpdateDto extends AbstractGetOrUpdateDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Visit visitorId;
    private Coach coachId;
}
