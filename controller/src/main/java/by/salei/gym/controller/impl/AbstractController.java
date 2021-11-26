package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.Controller;
import by.salei.gym.service.api.Service;
import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetOrUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<G extends AbstractGetOrUpdateDto,
        C extends AbstractCreateDto, S extends Service<C, G>> implements Controller<G, C> {

    private final S abstractService;

    @Autowired
    public AbstractController(S abstractService) {
        this.abstractService = abstractService;
    }

    @Override
    public ResponseEntity<C> save(C createDto) {
        if (createDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abstractService.save(createDto);

        return new ResponseEntity<>(createDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<G> delete(Long id) {
        if (abstractService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abstractService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<G> update(G getOrUpdateDto) {
        if (getOrUpdateDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abstractService.update(getOrUpdateDto);
        return new ResponseEntity<>(getOrUpdateDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<G> getById(Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        G getOrUpdateDto = abstractService.getById(id);

        if (getOrUpdateDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getOrUpdateDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<G>> getAll() {

        List<G> getOrUpdateDtoList = abstractService.getAll();

        if (getOrUpdateDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getOrUpdateDtoList, HttpStatus.OK);
    }
}
