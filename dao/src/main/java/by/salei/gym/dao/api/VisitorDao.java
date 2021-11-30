package by.salei.gym.dao.api;

import by.salei.gym.dao.entity.Visitor;

import java.util.List;

public interface VisitorDao extends Dao<Visitor> {

    List<Visitor> findAllByName(String name);
}
