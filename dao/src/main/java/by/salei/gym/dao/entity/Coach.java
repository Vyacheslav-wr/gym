package by.salei.gym.dao.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coach")
public class Coach extends Person {

    private Double efficiency;

    @OneToMany(mappedBy = "coach")
    private List<Visit> schedule;
}
