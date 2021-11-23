package by.salei.gym.service.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import by.salei.gym.service.api.CoachService;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetOrUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl extends AbstractService<CoachGetOrUpdateDto, CoachCreateDto> implements CoachService {

    @Autowired
    CoachDao coachDao;

    @Override
    public CoachCreateDto save(CoachCreateDto entity) {
        Coach coach = new Coach();
        coach.setName(entity.getName());
        coach.setEfficiency(entity.getEfficiency());
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
        Coach coach = new Coach();
        coach.setId(newEntity.getId());
        coach.setName(newEntity.getName());
        coach.setEfficiency(newEntity.getEfficiency());
        coachDao.update(coach);
        return newEntity;
    }

    @Override
    public CoachGetOrUpdateDto getById(Long id) {
        Coach coach = coachDao.getById(id);
        try{
        CoachGetOrUpdateDto coachGetDto = CoachGetOrUpdateDto.builder()
                .id(coach.getId())
                .name(coach.getName())
                .efficiency(coach.getEfficiency())
                .build();
            return coachGetDto;
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
                .map(coach -> CoachGetOrUpdateDto.builder()
                        .id(coach.getId())
                        .name(coach.getName())
                        .efficiency(coach.getEfficiency())
                        .build())
                .collect(Collectors.toList());
    }
}
