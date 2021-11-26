package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Visit;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetOrUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface VisitMapper {
    Visit visitCreateDtoToVisit(VisitCreateDto visitCreateDto);
    VisitCreateDto visitCreateDtoToVisit(Visit visit);
    VisitGetOrUpdateDto visitGetOrUpdateToVisit(Visit visit);
    Visit visitGetOrUpdateDtoToVisit(VisitGetOrUpdateDto visitGetOrUpdateDto);
}
