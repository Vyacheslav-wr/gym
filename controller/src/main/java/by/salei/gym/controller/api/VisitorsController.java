package by.salei.gym.controller.api;

import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetDto;
import by.salei.gym.service.dto.VisitorUpdateDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface VisitorsController extends Controller<VisitorUpdateDto, VisitorCreateDto, VisitorGetDto>{

    @RequestMapping(value = "/{id}/visit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VisitorGetDto> visit(@PathVariable(name = "id") Long id, @RequestBody VisitCreateDto visitCreateDto);

    @RequestMapping(value = "/{id}/visit/{visitId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VisitorGetDto> workout(@PathVariable(name = "id") Long id, @PathVariable(name = "visitId") Long visitId);
}
