package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Visit;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetDto;
import by.salei.gym.service.dto.VisitUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface VisitMapper {
    Visit visitCreateDtoToVisit(VisitCreateDto visitCreateDto);
    VisitGetDto visitToVisitGetDto(Visit visit);
    Visit visitUpdateDtoToVisit(VisitUpdateDto visitGetOrUpdateDto);
}
