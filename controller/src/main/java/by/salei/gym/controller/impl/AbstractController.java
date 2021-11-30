package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.Controller;
import by.salei.gym.service.api.Service;
import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetDto;
import by.salei.gym.service.dto.AbstractUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<U extends AbstractUpdateDto,
        C extends AbstractCreateDto, G extends AbstractGetDto, S extends Service<C, U, G>> implements Controller<U, C, G> {

    private final S abstractService;

    protected S getAbstractService(){
        return abstractService;
    }

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
    public ResponseEntity<G> update(U getOrUpdateDto) {
        if (getOrUpdateDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abstractService.update(getOrUpdateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<G> getById(Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        G getDto = abstractService.getById(id);

        if (getDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<G>> getAll() {

        List<G> getDtoList = abstractService.getAll();

        if (getDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getDtoList, HttpStatus.OK);
    }
}
