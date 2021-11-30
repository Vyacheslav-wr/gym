package by.salei.gym.service.api;

import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetDto;
import by.salei.gym.service.dto.AbstractUpdateDto;

import java.util.List;

public interface Service <C extends AbstractCreateDto, U extends AbstractUpdateDto, G extends AbstractGetDto> {
    void save(C createDto);
    void delete(Long id);
    void update(U updateDto);
    G getById(Long id);
    List<G> getAll();
}
