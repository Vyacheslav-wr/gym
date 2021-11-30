package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.VisitorDao;
import by.salei.gym.dao.entity.Visitor;
import by.salei.gym.dao.entity.Visitor_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
@Repository
public class VisitorDaoImpl extends AbstractDao<Visitor> implements VisitorDao {

    @Override
    protected Class<Visitor> getEntityClass() {
        return Visitor.class;
    }

    @Override
    public List<Visitor> findAllByName(String name) {
        log.info("Executing method findAllByName()");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitor> cq = cb.createQuery(Visitor.class);
        Root<Visitor> root = cq.from(Visitor.class);
        cq.select(root).where(cb.equal(root.get(Visitor_.NAME), name));
        return entityManager.createQuery(cq).getResultList();
    }
}
