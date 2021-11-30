package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetDto;
import by.salei.gym.service.dto.CoachUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoachMapper {

    Coach createCoachDtoToCoach(CoachCreateDto coachCreateDto);
    CoachGetDto coachToGetCoachDto(Coach coach);
    Coach getOrUpdateCoachDto(CoachUpdateDto getOrUpdateDto);
}
