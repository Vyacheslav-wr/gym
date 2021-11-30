package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.MusclesController;
import by.salei.gym.service.api.MuscleService;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.dto.MuscleGetDto;
import by.salei.gym.service.dto.MuscleUpdateDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muscles")
public class MusclesControllerImpl extends AbstractController<MuscleUpdateDto, MuscleCreateDto, MuscleGetDto, MuscleService>
        implements MusclesController {

    public MusclesControllerImpl(MuscleService muscleService) {
        super(muscleService);
    }
}
