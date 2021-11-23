package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.VisitDao;
import by.salei.gym.dao.entity.Visit;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDaoImpl extends AbstractDao<Visit> implements VisitDao {
    @Override
    protected Class<Visit> getEntityClass() {
        return Visit.class;
    }
}
