package by.salei.gym.service.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.filter.CoachSearch;
import by.salei.gym.service.api.CoachService;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetDto;
import by.salei.gym.service.dto.CoachUpdateDto;
import by.salei.gym.service.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl extends AbstractService<CoachUpdateDto, CoachCreateDto, CoachGetDto> implements CoachService {

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private CoachMapper coachMapper;

    @Transactional
    @Override
    public void save(CoachCreateDto entity) {
        Coach coach = coachMapper.createCoachDtoToCoach(entity);
        coachDao.save(coach);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        coachDao.delete(id);
    }

    @Transactional
    @Override
    public void update(CoachUpdateDto newEntity) {
        Coach coach = coachMapper.getOrUpdateCoachDto(newEntity);
        coachDao.update(coach);
    }

    @Override
    public CoachGetDto getById(Long id) {
        Coach coach = coachDao.getById(id);
        try{
            return coachMapper.coachToGetCoachDto(coach);
        }
        catch (NullPointerException ex){
            return null;
        }
    }

    @Override
    public List<CoachGetDto> getAll() {
        List<Coach> coaches = coachDao.getAll();
        return coaches
                .stream()
                .map(coach -> coachMapper.coachToGetCoachDto(coach))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoachGetDto> findAllByName(String name) {
        List<Coach> coaches = coachDao.findAllByName(name);
        return coaches
                .stream()
                .map(coach -> coachMapper.coachToGetCoachDto(coach))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoachGetDto> findAllByEfficiency(Double efficiency) {
        List<Coach> coaches = coachDao.findAllByEfficiency(efficiency);
        return coaches
                .stream()
                .map(coach -> coachMapper.coachToGetCoachDto(coach))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoachGetDto> search(Integer page, Integer size, CoachSearch coachSearch) {
        List<Coach> coaches = coachDao.search(size, page, coachSearch);
        return coaches
                .stream()
                .map(coach -> coachMapper.coachToGetCoachDto(coach))
                .collect(Collectors.toList());
    }
}
