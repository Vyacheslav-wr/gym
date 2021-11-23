package by.salei.gym.service.impl;

import by.salei.gym.dao.api.MuscleDao;
import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.api.MuscleService;
import by.salei.gym.service.dto.MuscleGetOrUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuscleServiceImpl implements MuscleService {

    @Autowired
    MuscleDao muscleDao;

    @Override
    public MuscleCreateDto save(MuscleCreateDto createMuscleGetDto) {
        Muscle muscle = Muscle.builder()
                .muscle(createMuscleGetDto.getMuscle())
                .power(createMuscleGetDto.getPower())
                .build();
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
        muscleDao.update(Muscle.builder()
                .muscle(updateMuscleGetDto.getMuscle())
                .power(updateMuscleGetDto.getPower())
                .build());
        return updateMuscleGetDto;
    }

    @Override
    public MuscleGetOrUpdateDto getById(Long id) {
        Muscle muscle = muscleDao.getById(id);
        return MuscleGetOrUpdateDto.builder()
                .muscle(muscle.getMuscle())
                .power(muscle.getPower())
                .build();
    }

    @Override
    public List<MuscleGetOrUpdateDto> getAll() {
        List<Muscle> muscles = muscleDao.getAll();
        List<MuscleGetOrUpdateDto> musclesDto = muscles
                .stream()
                .map(muscle -> MuscleGetOrUpdateDto.builder()
                        .muscle(muscle.getMuscle())
                        .power(muscle.getPower())
                        .build())
                .collect(Collectors.toList());
        return musclesDto;
    }
}
