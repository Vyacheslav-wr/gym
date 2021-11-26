package by.salei.gym.service.api;

import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetOrUpdateDto;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;

public interface VisitorService extends Service<VisitorCreateDto, VisitorGetOrUpdateDto> {

    VisitCreateDto visit(Long id, VisitCreateDto visitCreateDtoDtoDto);
}
