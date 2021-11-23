package by.salei.gym.service.impl;

import by.salei.gym.dao.api.VisitorDao;
import by.salei.gym.dao.entity.Visitor;
import by.salei.gym.service.dto.VisitorCreateDto;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.dto.VisitorGetOrUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorDao visitorDao;

    @Override
    public VisitorCreateDto save(VisitorCreateDto createVisitorDto) {
        Visitor visitor = new Visitor();
        visitor.setName(createVisitorDto.getName());
        visitorDao.save(visitor);
        return createVisitorDto;
    }

    @Override
    public VisitorGetOrUpdateDto delete(Long id) {
        visitorDao.delete(id);
        return getById(id);
    }

    @Override
    public VisitorGetOrUpdateDto update(VisitorGetOrUpdateDto updateMuscleDto) {
        Visitor visitor = new Visitor();
        visitor.setName(updateMuscleDto.getName());
        visitorDao.update(visitor);
        return updateMuscleDto;
    }

    @Override
    public VisitorGetOrUpdateDto getById(Long id) {
        Visitor visitor = visitorDao.getById(id);
        return VisitorGetOrUpdateDto.builder()
                .id(visitor.getId())
                .name(visitor.getName())
                .muscles(visitor.getMuscles())
                .build();
    }

    @Override
    public List<VisitorGetOrUpdateDto> getAll() {
        List<Visitor> visitors = visitorDao.getAll();
        List<VisitorGetOrUpdateDto> visitorsDto = visitors
                .stream()
                .map(visitor -> VisitorGetOrUpdateDto.builder()
                        .id(visitor.getId())
                        .name(visitor.getName())
                        .build())
                .collect(Collectors.toList());
        return visitorsDto;
    }
}
