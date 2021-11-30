package by.salei.gym.controller.impl;

import by.salei.gym.controller.api.CoachsController;
import by.salei.gym.dao.filter.CoachSearch;
import by.salei.gym.service.api.CoachService;
import by.salei.gym.service.dto.CoachCreateDto;
import by.salei.gym.service.dto.CoachGetDto;
import by.salei.gym.service.dto.CoachUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachsControllerImpl extends AbstractController<CoachUpdateDto, CoachCreateDto, CoachGetDto, CoachService>
        implements CoachsController {

    public CoachsControllerImpl(CoachService coachService) {
        super(coachService);
    }

    @Override
    public ResponseEntity<List<CoachGetDto>> findAllByName(String name) {
        if(name == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(super.getAbstractService().findAllByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CoachGetDto>> findAllByEfficiency(Double efficiency) {
        if(efficiency == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(super.getAbstractService().findAllByEfficiency(efficiency), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CoachGetDto>> search(Integer size, Integer page, CoachSearch coachSearch) {
        return new ResponseEntity<>(super.getAbstractService().search(page,size,coachSearch), HttpStatus.OK);
    }
}
