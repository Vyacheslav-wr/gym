package by.salei.gym.service.dto;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Visitor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class VisitGetDto extends AbstractGetDto{

    private Long id;
    private Date startDate;
    private Date endDate;
    private Long visitor;
    private Long coach;

    public void setVisitor(Visitor visitor) {
        try{
            this.visitor = visitor.getId();
        }
        catch (Exception ex){}
    }

    public void setCoach(Coach coach) {
        try{
            this.coach = coach.getId();
        }
        catch (Exception ex){}
    }

    public VisitGetDto(Long id, Date startDate, Date endDate, Visitor visitor, Coach coach){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        try{
            this.visitor = visitor.getId();
        }
        catch (Exception ex){}
        try{
            this.coach = coach.getId();
        }
        catch (Exception ex){}
    }
}
