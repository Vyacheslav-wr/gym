package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Visitor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitCreateDto extends AbstractCreateDto {

    private String startDate;
    private String endDate;
    private Visitor visitor;
    private Coach coach;

    public LocalDate getStartDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh/mm");
        return LocalDate.parse(this.startDate, formatter);
    }

    public LocalDate getEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh/mm");
        return LocalDate.parse(this.endDate, formatter);
    }
}
