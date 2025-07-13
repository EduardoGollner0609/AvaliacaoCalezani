package com.eduardo.avaliacao_calezani.services;

import com.eduardo.avaliacao_calezani.dtos.AssessmentDTO;
import com.eduardo.avaliacao_calezani.entities.Assessment;
import com.eduardo.avaliacao_calezani.entities.Driver;
import com.eduardo.avaliacao_calezani.entities.Station;
import com.eduardo.avaliacao_calezani.repositories.AssessmentRepository;
import com.eduardo.avaliacao_calezani.repositories.DriverRepository;
import com.eduardo.avaliacao_calezani.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {
    private final AssessmentRepository repository;
    private final DriverRepository driverRepository;
    private final StationRepository stationRepository;

    @Autowired
    public AssessmentService(AssessmentRepository repository, DriverRepository driverRepository, StationRepository stationRepository) {
        this.repository = repository;
        this.driverRepository = driverRepository;
        this.stationRepository = stationRepository;
    }

    // Criar avaliação
    public AssessmentDTO create(AssessmentDTO request) {
        Assessment assessment = new Assessment();
        copyDtoToEntity(assessment, request);

        Station station = findOrSaveStation(request.stationName());

        station.addAssessment(assessment);
        assessment.setStation(station);

        Driver driver = findOrSaveDriver(request.driverName());
        driver.addAssesment(assessment);
        assessment.setDriver(driver);

        return new AssessmentDTO(repository.save(assessment));
    }

    private Station findOrSaveStation(String stationName) {
        return stationRepository.findByName(stationName).orElseGet(() ->
                stationRepository.save(new Station(null, stationName)));

    }

    private Driver findOrSaveDriver(String driverName) {
        return driverRepository.findByName(driverName).orElseGet(() ->
                driverRepository.save(new Driver(null, driverName)));
    }

    private void copyDtoToEntity(Assessment assessment, AssessmentDTO request) {
        assessment.setScore(request.score());
        assessment.setComment(request.comment());
    }
}
