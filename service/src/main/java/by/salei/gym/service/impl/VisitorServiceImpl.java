package by.salei.gym.service.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.api.VisitDao;
import by.salei.gym.dao.api.VisitorDao;
import by.salei.gym.dao.entity.Coach;
import by.salei.gym.dao.entity.Visit;
import by.salei.gym.dao.entity.Visitor;
import by.salei.gym.service.dto.*;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.mapper.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public VisitorCreateDto save(VisitorCreateDto createVisitorDto) {
        Visitor visitor = visitorMapper.visitorCreateDtoToVisitor(createVisitorDto);
        visitorDao.save(visitor);
        return createVisitorDto;
    }

    @Override
    public VisitorGetOrUpdateDto delete(Long id) {
        visitorDao.delete(id);
        return getById(id);
    }

    @Override
    public VisitorGetOrUpdateDto update(VisitorGetOrUpdateDto updateVisitorDto) {
        Visitor visitor = visitorMapper.visitorToGetOrUpdateDtoToVisitor(updateVisitorDto);
        visitorDao.update(visitor);
        return updateVisitorDto;
    }

    @Override
    public VisitorGetOrUpdateDto getById(Long id) {
        Visitor visitor = visitorDao.getById(id);
        return visitorMapper.visitorToVisitGetOrUpdateDto(visitor);
    }

    @Override
    public List<VisitorGetOrUpdateDto> getAll() {
        List<Visitor> visitors = visitorDao.getAll();
        List<VisitorGetOrUpdateDto> visitorsDto = visitors
                .stream()
                .map(visitor -> visitorMapper.visitorToVisitGetOrUpdateDto(visitor))
                .collect(Collectors.toList());
        return visitorsDto;
    }

    @Override
    public VisitCreateDto visit(Long id, VisitCreateDto visitCreateDto) {
        return null;
    }
}
