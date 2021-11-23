package by.salei.gym.service.api;

import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetOrUpdateDto;

import java.util.List;

public interface Service <C extends AbstractCreateDto, G extends AbstractGetOrUpdateDto> {
    C save(C createDto);
    G delete(Long id);
    G update(G updateDto);
    G getById(Long id);
    public List<G> getAll();
}
