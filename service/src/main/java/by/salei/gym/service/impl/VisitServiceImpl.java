package by.salei.gym.service.impl;

import by.salei.gym.dao.api.VisitDao;
import by.salei.gym.dao.entity.Visit;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetOrUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    @Override
    public VisitCreateDto save(VisitCreateDto createVisitDto) {
        visitDao.save(Visit.builder()
                .startDate(createVisitDto.getStartDate())
                .endDate(createVisitDto.getEndDate())
                .build());
        return createVisitDto;
    }

    @Override
    public VisitGetOrUpdateDto delete(Long id) {
        VisitGetOrUpdateDto visitGetOrUpdateDto = getById(id);
        visitDao.delete(id);
        return visitGetOrUpdateDto;
    }

    @Override
    public VisitGetOrUpdateDto update(VisitGetOrUpdateDto updateVisitGetDto) {
        visitDao.update(Visit.builder()
                .startDate(updateVisitGetDto.getStartDate())
                .endDate(updateVisitGetDto.getEndDate())
                .build());
        return updateVisitGetDto;
    }

    @Override
    public VisitGetOrUpdateDto getById(Long id) {
        Visit visit = visitDao.getById(id);
        return  VisitGetOrUpdateDto.builder()
                .startDate(visit.getStartDate())
                .endDate(visit.getEndDate())
                .build();
    }

    @Override
    public List<VisitGetOrUpdateDto> getAll() {
        List<Visit> visits = visitDao.getAll();
        List<VisitGetOrUpdateDto> visitsDto = visits
                .stream()
                .map(visit -> VisitGetOrUpdateDto.builder()
                        .startDate(visit.getStartDate())
                        .endDate(visit.getEndDate())
                        .build())
                .collect(Collectors.toList());
        return visitsDto;
    }
}
