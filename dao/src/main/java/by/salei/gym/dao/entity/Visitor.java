package by.salei.gym.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visitor")
public class Visitor extends Person {

    @ManyToMany
    @JoinTable(
            name = "visitor_to_muscle",
            joinColumns = @JoinColumn(name = "visitor_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private List<Muscle> muscles;

    @OneToMany(mappedBy = "visitor")
    private List<Visit> schedule;
}
