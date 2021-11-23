package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.Dao;
import by.salei.gym.dao.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Transactional
    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(getEntityClass(),id));
    }

    @Transactional
    @Override
    public void update(T newEntity) {
        entityManager.merge(newEntity);
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }
}
