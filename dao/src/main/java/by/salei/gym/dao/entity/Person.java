package by.salei.gym.dao.entity;

import lombok.*;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Person extends AbstractEntity {

    private String name;
}
