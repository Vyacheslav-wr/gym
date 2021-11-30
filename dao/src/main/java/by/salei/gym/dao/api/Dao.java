package by.salei.gym.dao.api;

import by.salei.gym.dao.entity.AbstractEntity;

import java.util.List;

public interface Dao<T extends AbstractEntity> {
    void save(T entity);

    void delete(Long id);

    void update(T newEntity);

    T getById(Long id);

    List<T> getAll();


}
