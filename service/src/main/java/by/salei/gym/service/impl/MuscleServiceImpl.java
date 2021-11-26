package by.salei.gym.service.impl;

import by.salei.gym.dao.api.MuscleDao;
import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.api.MuscleService;
import by.salei.gym.service.dto.MuscleGetOrUpdateDto;
import by.salei.gym.service.mapper.MuscleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleServiceImpl implements MuscleService {

    @Autowired
    private MuscleDao muscleDao;

    @Autowired
    private MuscleMapper muscleMapper;

    @Override
    public MuscleCreateDto save(MuscleCreateDto createMuscleGetDto) {
        Muscle muscle = muscleMapper.muscleCreateToMuscle(createMuscleGetDto);
        muscleDao.save(muscle);
        return createMuscleGetDto;
    }

    @Override
    public MuscleGetOrUpdateDto delete(Long id) {
        muscleDao.delete(id);
        return getById(id);
    }

    @Override
    public MuscleGetOrUpdateDto update(MuscleGetOrUpdateDto updateMuscleGetDto) {
        muscleDao.update(muscleMapper.muscleGetOrUpdateToMuscle(updateMuscleGetDto));
        return updateMuscleGetDto;
    }

    @Override
    public MuscleGetOrUpdateDto getById(Long id) {
        Muscle muscle = muscleDao.getById(id);
        return muscleMapper.muscleToGetOrUpdateMuscle(muscle);
    }

    @Override
    public List<MuscleGetOrUpdateDto> getAll() {
        List<Muscle> muscles = muscleDao.getAll();
        return muscles
                .stream()
                .map(muscle -> muscleMapper.muscleToGetOrUpdateMuscle(muscle))
                .collect(Collectors.toList());
    }
}
