package com.everteamProject.everteam.Service.Impl;

import com.everteamProject.everteam.Repository.OpportunityRepository;
import com.everteamProject.everteam.Service.OpportunityService;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository repository;

    @Override
    public OpportunityEntity postNewOpportunity(OpportunityEntity opportunityEntity){
        return repository.save(opportunityEntity);
    }

    @Override
    public ResponseEntity updateOpportunity(Long id, OpportunityEntity opportunityEntity) {
        return repository.findById(id)
                .map(user -> {

                    if (opportunityEntity.getCodeOpportunity() != BigDecimal.valueOf(0)) {
                        user.setCodeOpportunity(opportunityEntity.getCodeOpportunity());
                    }
                    if (opportunityEntity.getNameOpportunity() != null && !opportunityEntity.getNameOpportunity().isEmpty()) {
                        user.setNameOpportunity(opportunityEntity.getNameOpportunity());
                    }
                    if (opportunityEntity.getResponsibleName() != null && !opportunityEntity.getResponsibleName().isEmpty()) {
                        user.setResponsibleName(opportunityEntity.getResponsibleName());
                    }
                    if (opportunityEntity.getResponsibleEmail() != null && !opportunityEntity.getResponsibleEmail().isEmpty()){
                        user.setResponsibleEmail(opportunityEntity.getResponsibleEmail());
                    }
                    if (opportunityEntity.getDescriptionOpportunity() != null && !opportunityEntity.getDescriptionOpportunity().isEmpty()) {
                        user.setDescriptionOpportunity(opportunityEntity.getDescriptionOpportunity());
                    }
                    if (opportunityEntity.getTypeOpportunity() != null && !opportunityEntity.getTypeOpportunity().isEmpty()) {
                        user.setTypeOpportunity(opportunityEntity.getTypeOpportunity());
                    }
                    if (opportunityEntity.getRequirement() != null && !opportunityEntity.getRequirement().isEmpty()) {
                        user.setRequirement(opportunityEntity.getRequirement());
                    }
                    if (opportunityEntity.getRequirementDescription() != null && !opportunityEntity.getRequirementDescription().isEmpty()) {
                        user.setRequirementDescription(opportunityEntity.getRequirementDescription());
                    }
                    if (opportunityEntity.getCommunity() != null && !opportunityEntity.getCommunity().isEmpty()){
                        user.setCommunity(opportunityEntity.getCommunity());
                    }
                    if (opportunityEntity.getReleaseTrain() != null && !opportunityEntity.getReleaseTrain().isEmpty()){
                        user.setReleaseTrain(opportunityEntity.getReleaseTrain());
                    }
                    if (opportunityEntity.getSquad() !=null && !opportunityEntity.getSquad().isEmpty()){
                        user.setSquad(opportunityEntity.getSquad());
                    }
                    if (opportunityEntity.getOpenDate() != null) {
                        user.setOpenDate(opportunityEntity.getOpenDate());
                    }
                    if (opportunityEntity.getCloseDate() != null && !opportunityEntity.getCloseDate().isEmpty()) {
                        user.setCloseDate(opportunityEntity.getCloseDate());
                    }

                    repository.save(user);
                    return ResponseEntity.ok(user);
                }).orElse(ResponseEntity.notFound().build());
    }


    @Override
    public ResponseEntity changeStatus(Long id, TypeStatus status){
        return repository.findById(id).
                map(us -> {

                    if (us.getStatus().toString() !=null) {
                        us.setStatus(status);
                    }

                    repository.save(us);
                   return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List getOpportunity(){
        return repository.findAll();
    }

    @Override
    public List<OpportunityEntity> getNameOpportunity(String name){
        return repository.findByName(name);
    }

    @Override
    public List<OpportunityEntity> searchStatus(TypeStatus status){
        return repository.findByStatus(status.toString());
    }

}
