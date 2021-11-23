package by.salei.gym.dao.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "muscle")
public class Muscle extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private MuscleType muscle;
    private Integer power;
}
