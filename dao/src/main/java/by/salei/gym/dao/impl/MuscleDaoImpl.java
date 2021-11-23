package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.MuscleDao;
import by.salei.gym.dao.entity.Muscle;
import org.springframework.stereotype.Repository;

@Repository
public class MuscleDaoImpl extends AbstractDao<Muscle> implements MuscleDao {
    @Override
    protected Class<Muscle> getEntityClass() {
        return Muscle.class;
    }
}
