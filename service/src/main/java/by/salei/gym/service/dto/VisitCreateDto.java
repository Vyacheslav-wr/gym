package by.salei.gym.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitCreateDto extends AbstractCreateDto {

    private String startDate;
    private String endDate;

    public Date getStartDate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh/mm");
            dateFormat.setTimeZone(TimeZone.getTimeZone("MSC"));
            return dateFormat.parse(startDate);
        } catch (ParseException e){
            return null;
        }
    }

    public Date getEndDate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh/mm");
            dateFormat.setTimeZone(TimeZone.getTimeZone("MSC"));
            return dateFormat.parse(endDate);
        } catch (ParseException e){
            return null;
        }
    }
}
