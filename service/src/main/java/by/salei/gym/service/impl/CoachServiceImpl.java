package by.salei.gym.service.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Visit;
import by.salei.gym.service.api.CoachService;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetOrUpdateDto;
import by.salei.gym.service.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl extends AbstractService<CoachGetOrUpdateDto, CoachCreateDto> implements CoachService {

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private CoachMapper coachMapper;

    @Override
    public CoachCreateDto save(CoachCreateDto entity) {
        Coach coach = coachMapper.createCoachDtoToCoach(entity);
        coachDao.save(coach);
        return entity;
    }

    @Override
    public CoachGetOrUpdateDto delete(Long id) {
        coachDao.delete(id);
        return getById(id);
    }

    @Override
    public CoachGetOrUpdateDto update(CoachGetOrUpdateDto newEntity) {
        Coach coach = coachMapper.getOrUpdateCoachDto(newEntity);
        coachDao.update(coach);
        return newEntity;
    }

    @Override
    public CoachGetOrUpdateDto getById(Long id) {
        Coach coach = coachDao.getById(id);
        try{
            CoachGetOrUpdateDto coachGetOrUpdateDto = coachMapper.coachToGetOrUpdateCoachDto(coach);
            return coachGetOrUpdateDto;
        }
        catch (NullPointerException ex){
            return null;
        }
    }

    @Override
    public List<CoachGetOrUpdateDto> getAll() {
        List<Coach> coaches = coachDao.getAll();
        return coaches
                .stream()
                .map(coach -> coachMapper.coachToGetOrUpdateCoachDto(coach))
                .collect(Collectors.toList());
    }

}
