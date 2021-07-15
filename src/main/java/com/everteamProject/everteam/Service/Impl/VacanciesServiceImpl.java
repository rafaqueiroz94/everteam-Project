package com.everteamProject.everteam.Service.Impl;

import com.everteamProject.everteam.Repository.VacanciesRepository;
import com.everteamProject.everteam.Service.VacanciesService;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.VacanciesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class VacanciesServiceImpl implements VacanciesService {

    @Autowired
    VacanciesRepository repository;

    @Override
    public VacanciesEntity postNewVacancies(VacanciesEntity vacanciesEntity) {
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        vacanciesEntity.setOpenDate(format.format(data));
        return repository.save(vacanciesEntity);
    }
    @Override
    public List<VacanciesEntity> getNameLeader(String name){
        return repository.findByNameLeader(name);
    }
    @Override
    public List<VacanciesEntity> searchStatusVacancies(TypeStatus status) {
        return repository.findByStatus(status.toString());
    }
    @Override
    public List<VacanciesEntity> getVacancies(){
        return repository.findAll();
    }
    @Override
    public List<VacanciesEntity> searchDate(String date) {
        return repository.findByOpenDate(date);
    }
    @Override
    public ResponseEntity updateVacancies(Long id, VacanciesEntity vacanciesEntity){
        return repository.findById(id)
                .map(user -> {

                    if (vacanciesEntity.getCodeVacancies() != BigDecimal.valueOf(0)){
                        user.setCodeVacancies(vacanciesEntity.getCodeVacancies());
                    }
                    if (vacanciesEntity.getNameVacancies() !=null && !vacanciesEntity.getNameVacancies().isEmpty()){
                        user.setNameVacancies(vacanciesEntity.getNameVacancies());
                    }
                    if (vacanciesEntity.getNameLeader() !=null && !vacanciesEntity.getNameLeader().isEmpty()){
                        user.setNameLeader(vacanciesEntity.getNameLeader());
                    }
                    if (vacanciesEntity.getRequiredPosition() !=null && !vacanciesEntity.getRequiredPosition().isEmpty()){
                        user.setRequiredPosition(vacanciesEntity.getRequiredPosition());
                    }
                    if (vacanciesEntity.getRequiredLevel() !=null && !vacanciesEntity.getRequiredLevel().isEmpty()){
                        user.setRequiredLevel(vacanciesEntity.getRequiredLevel());
                    }
                    if (vacanciesEntity.getServiceName() !=null && !vacanciesEntity.getServiceName().isEmpty()){
                        user.setServiceName(vacanciesEntity.getServiceName());
                    }
                    if (vacanciesEntity.getRequirements() !=null && !vacanciesEntity.getRequirements().isEmpty()){
                        user.setRequirements(vacanciesEntity.getRequirements());
                    }
                    if (vacanciesEntity.getDesirableRequirements() !=null && !vacanciesEntity.getDesirableRequirements().isEmpty()){
                        user.setDesirableRequirements(vacanciesEntity.getDesirableRequirements());
                    }
                    if (vacanciesEntity.getOpenDate() !=null && !vacanciesEntity.getOpenDate().isEmpty() ){
                        user.setOpenDate(vacanciesEntity.getOpenDate());
                    }
                    if (vacanciesEntity.getCloseDate() !=null && !vacanciesEntity.getCloseDate().isEmpty()){
                        user.setCloseDate(vacanciesEntity.getCloseDate());
                    }

                    repository.save(user);
                    return ResponseEntity.ok(user);

                }).orElse(ResponseEntity.notFound().build());
    }
    @Override
    public ResponseEntity changeStatusVacancies( Long id, TypeStatus status){
        return repository.findById(id)
                .map( user -> {
                    if( user.getStatus().toString() !=null){
                        user.setStatus(status);
                    }
                    repository.save(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
