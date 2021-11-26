package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.dto.MuscleGetOrUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface MuscleMapper {

    Muscle muscleCreateToMuscle(MuscleCreateDto muscleCreateDto);
    MuscleCreateDto muscleToCreateDto(Muscle muscle);
    MuscleGetOrUpdateDto muscleToGetOrUpdateMuscle(Muscle muscle);
    Muscle muscleGetOrUpdateToMuscle(MuscleGetOrUpdateDto muscleGetOrUpdateDto);
}
