package by.salei.gym.controller.api;

import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface VisitorsController extends Controller<VisitorGetOrUpdateDto, VisitorCreateDto>{

    @RequestMapping(value = "/{id}/visit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VisitCreateDto> visit(@PathVariable(name = "id") Long id, @RequestBody VisitCreateDto visitCreateDto);
}
