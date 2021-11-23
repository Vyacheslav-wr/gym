package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.VisitorDao;
import by.salei.gym.dao.entity.Visitor;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorDaoImpl extends AbstractDao<Visitor> implements VisitorDao {
    @Override
    protected Class<Visitor> getEntityClass() {
        return null;
    }
}
