package by.salei.gym.service.impl;

import by.salei.gym.dao.api.CoachDao;
import by.salei.gym.dao.api.MuscleDao;
import by.salei.gym.dao.api.VisitDao;
import by.salei.gym.dao.api.VisitorDao;
import by.salei.gym.dao.entity.*;
import by.salei.gym.service.api.VisitService;
import by.salei.gym.service.api.VisitorService;
import by.salei.gym.service.dto.*;
import by.salei.gym.service.mapper.VisitMapper;
import by.salei.gym.service.mapper.VisitorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private MuscleDao muscleDao;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private VisitMapper visitMapper;

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Override
    public void save(VisitorCreateDto createVisitorDto) {
        Visitor visitor = visitorMapper.visitorCreateDtoToVisitor(createVisitorDto);

        visitor.setMuscles(createMuscles());
        visitorDao.save(visitor);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        visitorDao.delete(id);
    }

    @Transactional
    @Override
    public void update(VisitorUpdateDto updateVisitorDto) {
        Visitor visitor = visitorMapper.visitorUpdateDtoToVisitor(updateVisitorDto);
        visitorDao.update(visitor);
    }

    @Override
    public VisitorGetDto getById(Long id) {
        Visitor visitor = visitorDao.getById(id);
        return visitorMapper.visitorToVisitorGetDto(visitor);
    }

    @Override
    public List<VisitorGetDto> getAll() {
        List<Visitor> visitors = visitorDao.getAll();
        return visitors
                .stream()
                .map(visitor -> visitorMapper.visitorToVisitorGetDto(visitor))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public VisitorGetDto visit(Long id, VisitCreateDto visitCreateDto) {

        log.info("Executing method visit()");
        log.debug("Executing method visit() for the entity Visitor with id = {}", id);

        List<Coach> coaches = coachDao.getAll();
        Coach availableCoach = null;
        boolean flag;

        for (Coach coach : coaches) {
            flag = true;
            List<Visit> visits = coach.getSchedule();

            if (visits != null) {
                for (Visit visit : visits) {
                    if (visitCreateDto.getStartDate().getTime() - visit.getStartDate().getTime() >= 0 ||
                            visitCreateDto.getStartDate().getTime() - visit.getEndDate().getTime() <= 0 ||
                            visitCreateDto.getEndDate().getTime() - visit.getStartDate().getTime() >= 0 ||
                            visitCreateDto.getEndDate().getTime() - visit.getEndDate().getTime() <= 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                availableCoach = coach;
                break;
            }
        }

        Visit visit = visitMapper.visitCreateDtoToVisit(visitCreateDto);

        if (availableCoach != null) {
            visit.setCoach(availableCoach);
        }

        Visitor visitor = visitorDao.getById(id);
        visit.setVisitor(visitor);

        visitDao.save(visit);
        return getById(id);
    }

    @Transactional
    @Override
    public VisitorGetDto workout(Long id, Long visitId) {

        log.info("SERVICE.VisitorServiceImpl: Executing method workout()");
        log.debug("SERVICE.VisitorServiceImpl: Executing method workout() for the entity Visitor with id = {}, " +
                "Visit with id = {}", id, visitId);

        Coach coach;

        Visitor visitor = visitorDao.getById(id);

        Visit visit = visitor.getSchedule()
                .stream()
                .filter(entity -> entity.getId().equals(visitId))
                .findFirst()
                .orElse(null);

        if (visit != null) {
            coach = visit.getCoach();

            long power = ((visit.getEndDate().getTime() - visit.getStartDate().getTime()) / 3600000);

            if (coach != null) {
                power = power * coach.getEfficiency().longValue();
            }

            long finalPower = power;

            visitor.getMuscles()
                    .forEach(muscle -> muscle.setPower(muscle.getPower() + (int) finalPower));

            visitDao.delete(visitId);

            return visitorMapper.visitorToVisitorGetDto(visitor);
        }

        return null;
    }

    @Override
    public List<VisitorGetDto> findAllByName(String name) {
        List<Visitor> visitors = visitorDao.findAllByName(name);
        return visitors
                .stream()
                .map(visitor -> visitorMapper.visitorToVisitorGetDto(visitor))
                .collect(Collectors.toList());
    }

    @Transactional
    protected List<Muscle> createMuscles() {
        List<Muscle> muscles = new ArrayList<>();

        Muscle muscle1 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.BICEPS)
                .build();
        Muscle muscle2 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.ABDOMINALS)
                .build();
        Muscle muscle3 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.CALVES)
                .build();
        Muscle muscle4 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.DELTOIDS)
                .build();
        Muscle muscle5 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.OBLIQUES)
                .build();
        Muscle muscle6 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.PECTIRALS)
                .build();
        Muscle muscle7 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.QUUADRICEPS)
                .build();
        Muscle muscle8 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.TRAPEZES)
                .build();
        Muscle muscle9 = Muscle.builder()
                .power(0)
                .muscle(MuscleType.TRICEPS)
                .build();

        muscleDao.save(muscle1);
        muscleDao.save(muscle2);
        muscleDao.save(muscle3);
        muscleDao.save(muscle4);
        muscleDao.save(muscle5);
        muscleDao.save(muscle6);
        muscleDao.save(muscle7);
        muscleDao.save(muscle8);
        muscleDao.save(muscle9);

        muscles.add(muscle1);
        muscles.add(muscle2);
        muscles.add(muscle3);
        muscles.add(muscle4);
        muscles.add(muscle5);
        muscles.add(muscle6);
        muscles.add(muscle7);
        muscles.add(muscle8);
        muscles.add(muscle9);

        return muscles;
    }
}
