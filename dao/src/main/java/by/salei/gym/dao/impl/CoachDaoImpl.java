package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import org.springframework.stereotype.Repository;

@Repository
public class CoachDaoImpl extends AbstractDao<Coach> implements CoachDao {

    @Override
    protected Class<Coach> getEntityClass() {
        return Coach.class;
    }

}
