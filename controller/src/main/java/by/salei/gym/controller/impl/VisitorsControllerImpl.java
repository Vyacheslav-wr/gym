package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.VisitorsController;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorsControllerImpl extends AbstractController<VisitorGetOrUpdateDto, VisitorCreateDto, VisitorService>
        implements VisitorsController {

    private final VisitorService visitorService;

    public VisitorsControllerImpl(VisitorService visitorService) {
        super(visitorService);
        this.visitorService = visitorService;
    }
}
