package by.salei.gym.service.api;

import by.salei.gym.service.dto.*;

import java.util.List;

public interface VisitorService extends Service<VisitorCreateDto, VisitorUpdateDto, VisitorGetDto> {

    VisitorGetDto visit(Long id, VisitCreateDto visitCreateDto);

    VisitorGetDto workout(Long id, Long visitId);

    List<VisitorGetDto> findAllByName(String name);

}
