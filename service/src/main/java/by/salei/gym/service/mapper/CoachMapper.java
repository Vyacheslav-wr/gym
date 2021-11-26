package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Person;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetOrUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoachMapper {

    Coach createCoachDtoToCoach(CoachCreateDto coachCreateDto);
    CoachGetOrUpdateDto coachToGetOrUpdateCoachDto(Coach coach);
    Coach getOrUpdateCoachDto(CoachGetOrUpdateDto getOrUpdateDto);
}
