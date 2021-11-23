package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.CoachsController;
import by.salei.gym.service.api.CoachService;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetOrUpdateDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coaches")
public class CoachsControllerImpl extends AbstractController<CoachGetOrUpdateDto, CoachCreateDto, CoachService>
        implements CoachsController {

    private final CoachService coachService;

    public CoachsControllerImpl(CoachService coachService) {
        super(coachService);
        this.coachService = coachService;
    }
}
