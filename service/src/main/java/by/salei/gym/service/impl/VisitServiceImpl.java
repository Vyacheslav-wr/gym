package by.salei.gym.service.impl;

import by.salei.gym.dao.api.VisitDao;
import by.salei.gym.dao.entity.Visit;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.dto.VisitCreateDto;
import by.salei.gym.service.dto.VisitGetDto;
import by.salei.gym.service.dto.VisitUpdateDto;
import by.salei.gym.service.mapper.VisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private VisitMapper visitMapper;

    @Transactional
    @Override
    public void save(VisitCreateDto createVisitDto) {
        visitDao.save(visitMapper.visitCreateDtoToVisit(createVisitDto));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        visitDao.delete(id);
    }

    @Transactional
    @Override
    public void update(VisitUpdateDto updateVisitGetDto) {
        visitDao.update(visitMapper.visitUpdateDtoToVisit(updateVisitGetDto));
    }

    @Override
    public VisitGetDto getById(Long id) {
        Visit visit = visitDao.getById(id);
        return  visitMapper.visitToVisitGetDto(visit);
    }

    @Override
    public List<VisitGetDto> getAll() {
        List<Visit> visits = visitDao.getAll();
        return visits
                .stream()
                .map(visit ->visitMapper.visitToVisitGetDto(visit))
                .collect(Collectors.toList());
    }
}
