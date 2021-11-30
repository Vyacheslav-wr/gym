package by.salei.gym.service.api;

import by.salei.gym.dao.filter.CoachSearch;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetDto;
import by.salei.gym.service.dto.CoachUpdateDto;

import java.util.List;

public interface CoachService extends Service<CoachCreateDto, CoachUpdateDto, CoachGetDto> {

    List<CoachGetDto> findAllByName(String name);

    List<CoachGetDto> findAllByEfficiency(Double efficiency);

    List<CoachGetDto> search(Integer page, Integer size, CoachSearch coachSearch);
}
