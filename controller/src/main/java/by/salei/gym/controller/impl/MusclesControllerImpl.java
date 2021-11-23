package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.MusclesController;
import by.salei.gym.service.api.MuscleService;
import by.salei.gym.service.dto.MuscleCreateDto;
import by.salei.gym.service.dto.MuscleGetOrUpdateDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muscles")
public class MusclesControllerImpl extends AbstractController<MuscleGetOrUpdateDto, MuscleCreateDto, MuscleService>
        implements MusclesController {

    private final MuscleService muscleService;

    public MusclesControllerImpl(MuscleService muscleService) {
        super(muscleService);
        this.muscleService = muscleService;
    }
}
