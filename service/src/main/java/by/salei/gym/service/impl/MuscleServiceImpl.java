package by.salei.gym.service.impl;

import by.salei.gym.dao.api.MuscleDao;
import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.api.MuscleService;
import by.salei.gym.service.dto.MuscleGetDto;
import by.salei.gym.service.dto.MuscleUpdateDto;
import by.salei.gym.service.mapper.MuscleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleServiceImpl implements MuscleService {

    @Autowired
    private MuscleDao muscleDao;

    @Autowired
    private MuscleMapper muscleMapper;

    @Transactional
    @Override
    public void save(MuscleCreateDto createMuscleGetDto) {
        Muscle muscle = muscleMapper.muscleCreateToMuscle(createMuscleGetDto);
        muscleDao.save(muscle);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        muscleDao.delete(id);
    }

    @Transactional
    @Override
    public void update(MuscleUpdateDto updateMuscleGetDto) {
        muscleDao.update(muscleMapper.muscleUpdateToMuscle(updateMuscleGetDto));
    }

    @Override
    public MuscleGetDto getById(Long id) {
        Muscle muscle = muscleDao.getById(id);
        return muscleMapper.muscleToMuscleGetDto(muscle);
    }

    @Override
    public List<MuscleGetDto> getAll() {
        List<Muscle> muscles = muscleDao.getAll();
        return muscles
                .stream()
                .map(muscle -> muscleMapper.muscleToMuscleGetDto(muscle))
                .collect(Collectors.toList());
    }
}
