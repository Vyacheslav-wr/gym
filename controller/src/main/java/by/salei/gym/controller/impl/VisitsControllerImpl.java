package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.VisitsController;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetOrUpdateDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitsControllerImpl extends AbstractController<VisitGetOrUpdateDto, VisitCreateDto, VisitService>
        implements VisitsController {

    private final VisitService visitService;

    public VisitsControllerImpl(VisitService visitService) {
        super(visitService);
        this.visitService = visitService;
    }
}
