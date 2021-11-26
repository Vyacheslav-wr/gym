package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.VisitorsController;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorsControllerImpl extends AbstractController<VisitorGetOrUpdateDto, VisitorCreateDto, VisitorService>
        implements VisitorsController {

    private final VisitService visitService;

    private final VisitorService visitorService;

    public VisitorsControllerImpl(VisitorService visitorService, VisitService visitService) {
        super(visitorService);
        this.visitorService = visitorService;
        this.visitService = visitService;
    }

    @Override
    public ResponseEntity<VisitCreateDto> visit(Long id, VisitCreateDto visitCreateDto) {
        if(id == null || visitCreateDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        VisitorGetOrUpdateDto visitorGetOrUpdateDto = visitorService.getById(id);

        if(visitorGetOrUpdateDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        visitorService.visit(id, visitCreateDto);
        return new ResponseEntity<>(visitCreateDto, HttpStatus.OK);

    }
}
