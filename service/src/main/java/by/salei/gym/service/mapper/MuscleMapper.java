package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Muscle;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.dto.MuscleGetDto;
import by.salei.gym.service.dto.MuscleUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface MuscleMapper {

    Muscle muscleCreateToMuscle(MuscleCreateDto muscleCreateDto);
    MuscleGetDto muscleToMuscleGetDto(Muscle muscle);
    Muscle muscleUpdateToMuscle(MuscleUpdateDto muscleUpdateDto);
}
