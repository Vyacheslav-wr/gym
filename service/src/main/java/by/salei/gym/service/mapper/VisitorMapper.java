package by.salei.gym.service.mapper;

import by.salei.gym.dao.entity.Visitor;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetDto;
import by.salei.gym.service.dto.VisitorUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface VisitorMapper {

    Visitor visitorCreateDtoToVisitor(VisitorCreateDto visitorCreateDto);
    VisitorGetDto visitorToVisitorGetDto(Visitor visitor);
    Visitor visitorUpdateDtoToVisitor(VisitorUpdateDto visitGetOrUpdateDto);
}
