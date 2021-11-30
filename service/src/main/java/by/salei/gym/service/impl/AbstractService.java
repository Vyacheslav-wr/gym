package by.salei.gym.service.impl;

import by.salei.gym.service.api.Service;
import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetDto;
import by.salei.gym.service.dto.AbstractUpdateDto;

public abstract class AbstractService <U extends AbstractUpdateDto, C extends AbstractCreateDto, G extends AbstractGetDto>
        implements Service<C, U, G> {

}
