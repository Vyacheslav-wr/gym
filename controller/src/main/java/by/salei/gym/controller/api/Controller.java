package by.salei.gym.controller.api;

import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetDto;
import by.salei.gym.service.dto.AbstractUpdateDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface Controller <U extends AbstractUpdateDto, C extends AbstractCreateDto, G extends AbstractGetDto>{

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<C> save(@RequestBody C createGetDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<G> delete(@PathVariable(name = "id") Long id);

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<G> update(@RequestBody U getOrUpdateDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<G> getById(@PathVariable(name = "id") Long id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<G>> getAll();
}
