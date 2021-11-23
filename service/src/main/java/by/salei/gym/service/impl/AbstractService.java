package by.salei.gym.service.impl;

import by.salei.gym.service.api.Service;
import by.salei.gym.service.dto.AbstractCreateDto;
import by.salei.gym.service.dto.AbstractGetOrUpdateDto;

public abstract class AbstractService <G extends AbstractGetOrUpdateDto, C extends AbstractCreateDto> implements Service<C,G> {

}
