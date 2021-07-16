package com.everteamProject.everteam.Service;

import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.VacanciesEntity;
import org.springframework.http.ResponseEntity;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public interface VacanciesService  {


    VacanciesEntity postNewVacancies(VacanciesEntity vacanciesEntity);

    List<VacanciesEntity> getNameLeader(String name);

    List<VacanciesEntity> searchStatusVacancies(TypeStatus status);

    List<VacanciesEntity> getVacancies();

    List<VacanciesEntity> searchDate(String date);


    ResponseEntity updateVacancies(Long id, VacanciesEntity vacanciesEntity);

    ResponseEntity changeStatusVacancies(Long id, TypeStatus status);

    Optional<VacanciesEntity> getIdVacancies(Long id);
}
