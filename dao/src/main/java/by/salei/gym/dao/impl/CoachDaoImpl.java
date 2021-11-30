package by.salei.gym.dao.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Coach_;
import by.salei.gym.dao.filter.CoachSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CoachDaoImpl extends AbstractDao<Coach> implements CoachDao {

    private String getCriteriaLikeValue(String value) {
        return "%" + value.toLowerCase() + "%";
    }

    @Override
    protected Class<Coach> getEntityClass() {
        return Coach.class;
    }

    @Override
    public List<Coach> findAllByName(String name) {
        log.info("Executing method findAllByName()");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Coach> cq = cb.createQuery(Coach.class);
        Root<Coach> root = cq.from(Coach.class);
        cq.select(root).where(cb.equal(root.get(Coach_.NAME), name));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Coach> findAllByEfficiency(Double efficiency) {
        log.info("Executing method findAllByEfficiency()");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Coach> cq = cb.createQuery(Coach.class);
        Root<Coach> root = cq.from(Coach.class);
        cq.select(root).where(cb.equal(root.get(Coach_.EFFICIENCY), efficiency));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Coach> search(Integer size, Integer page, CoachSearch search) {
        log.info("Executing method search()");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Coach> cq = cb.createQuery(Coach.class);
        Root<Coach> root = cq.from(Coach.class);

        List<Predicate> predicates = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        if (search.getId() != null) {
            predicates.add(cb.equal(root.get(Coach_.ID), search.getId()));
        }

        if (search.getName() != null) {
            predicates.add(cb.like(cb.lower(root.get(Coach_.NAME)), getCriteriaLikeValue(search.getName())));
        }

        if (search.getEfficiency() != null) {
            predicates.add(cb.equal(root.get(Coach_.EFFICIENCY), search.getEfficiency()));
        }

        if (!predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[]{}));
        }

        if (search.getOrder() != null) {
            orders.add(CoachSearch.isDesc(search.getOrder()) ? cb.desc(root.get(Coach_.NAME)) : cb.asc(root.get(Coach_.NAME)));
            orders.add(CoachSearch.isDesc(search.getOrder()) ? cb.desc(root.get(Coach_.EFFICIENCY)) : cb.asc(root.get(Coach_.EFFICIENCY)));
            orders.add(CoachSearch.isDesc(search.getOrder()) ? cb.desc(root.get(Coach_.ID)) : cb.asc(root.get(Coach_.ID)));
            cq.orderBy(orders);
        }
        return entityManager.createQuery(cq).setFirstResult(page * size).setMaxResults(size).getResultList();
    }

}
