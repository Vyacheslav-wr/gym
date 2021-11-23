package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CoachDaoImpl extends AbstractDao<Coach> implements CoachDao {

    @Override
    protected Class<Coach> getEntityClass() {
        return Coach.class;
    }


}
