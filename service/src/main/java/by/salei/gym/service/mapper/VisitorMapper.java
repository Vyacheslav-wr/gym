package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Visit;
import by.salei.gym.dao.entity.Visitor;
import by.salei.gym.service.dto.VisitGetOrUpdateDto;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface VisitorMapper {

    Visitor visitorCreateDtoToVisitor(VisitorCreateDto visitorCreateDto);
    VisitorGetOrUpdateDto visitorToVisitGetOrUpdateDto(Visitor visitor);
    Visitor visitorToGetOrUpdateDtoToVisitor(VisitorGetOrUpdateDto visitGetOrUpdateDto);
}
