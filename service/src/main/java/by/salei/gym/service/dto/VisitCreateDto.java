package by.salei.gym.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitCreateDto extends AbstractCreateDto {

    private Date startDate;
    private Date endDate;
}
