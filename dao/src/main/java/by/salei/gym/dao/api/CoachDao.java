package by.salei.gym.dao.api;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.filter.CoachSearch;

import java.util.List;

public interface CoachDao extends Dao<Coach> {

    List<Coach> findAllByName(String name);

    List<Coach> findAllByEfficiency(Double efficiency);

    List<Coach> search(Integer size, Integer page, CoachSearch search);
}
