package by.salei.gym.controller.api;

import by.salei.gym.dao.filter.CoachSearch;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetDto;
import by.salei.gym.service.dto.CoachUpdateDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CoachsController extends Controller<CoachUpdateDto, CoachCreateDto, CoachGetDto>{

    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoachGetDto>> findAllByName(@RequestParam String name);

    @RequestMapping(value = "/efficiency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoachGetDto>> findAllByEfficiency(@RequestParam Double efficiency);

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoachGetDto>> search(@RequestParam(defaultValue = "20") Integer size, @RequestParam(defaultValue = "0") Integer page,
                                             @RequestBody CoachSearch coachSearch);
}
