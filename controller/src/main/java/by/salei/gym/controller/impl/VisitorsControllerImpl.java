package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.VisitorsController;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorsControllerImpl extends AbstractController<VisitorUpdateDto, VisitorCreateDto, VisitorGetDto, VisitorService>
        implements VisitorsController {

    private final VisitorService visitorService;

    private final VisitService visitService;

    public VisitorsControllerImpl(VisitorService visitorService, VisitService visitService) {
        super(visitorService);
        this.visitorService = visitorService;
        this.visitService = visitService;
    }

    @Override
    public ResponseEntity<VisitorGetDto> visit(Long id, VisitCreateDto visitCreateDto) {
        if(id == null || visitCreateDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(visitorService.visit(id, visitCreateDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitorGetDto> workout(Long id, Long visitId) {
        if(id == null || visitId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        VisitGetDto visit = visitorService.getById(id).getSchedule()
                .stream()
                .filter(entity -> entity.getId().equals(visitId))
                .findFirst()
                .orElse(null);

        if(visitorService.getById(id) == null || visit == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        visitorService.workout(id, visitId);

        return new ResponseEntity<>(visitorService.getById(id), HttpStatus.OK);
    }
}
