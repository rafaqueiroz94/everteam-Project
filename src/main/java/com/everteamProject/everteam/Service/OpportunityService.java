package com.everteamProject.everteam.Service;

import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OpportunityService {


    OpportunityEntity postNewOpportunity(OpportunityEntity opportunityEntity);

    ResponseEntity updateOpportunity(Long id, OpportunityEntity opportunityEntity);

    ResponseEntity changeStatus(Long id, TypeStatus status);

    List getOpportunity();

    List<OpportunityEntity> getNameOpportunity(String name);

    List<OpportunityEntity> searchStatus(TypeStatus status);
}
