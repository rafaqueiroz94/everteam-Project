package com.everteamProject.everteam.Service;

import com.everteamProject.everteam.Repository.OpportunityRepository;
import com.everteamProject.everteam.Service.Impl.OpportunityServiceImpl;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OpportunityServiceTest {

    @Autowired
    OpportunityServiceImpl service;

    @Autowired
    OpportunityRepository repository;

    @Before
    public void  setOpp() {
        OpportunityEntity user = new OpportunityEntity();
            user.setId(1);
            user.setCodeOpportunity(BigDecimal.valueOf(123));
            user.setNameOpportunity("Oportunidade");
            user.setResponsibleName("Rento");
            user.setResponsibleEmail("teste@email");
            user.setDescriptionOpportunity("descrição");
            user.setTypeOpportunity("tipo oportunidade");
            user.setRequirement("requerimento");
            user.setRequirementDescription("requerimento descrição");
            user.setCommunity("community");
            user.setReleaseTrain("release");
            user.setSquad("squad");
            user.setOpenDate(null);
            user.setCloseDate(null);
            user.setStatus(TypeStatus.ABERTO);
         repository.save(user);
    }

    @After
    public void dellOpp(){
         repository.deleteAll();
    }

    @Test
    public void testNewOpportunity(){
        OpportunityEntity data = new OpportunityEntity(2,BigDecimal.valueOf(123),"Oportunidade",
                "Rento","teste@email","descrição","tipo oportunidade",
                "requerimento","requerimento descrição","community","release",
                "squad",null,null,
                TypeStatus.valueOf("ABERTO"));

        OpportunityEntity value = service.postNewOpportunity(data);
        assertNotNull(value);
    }

    @Test
    public void testUpdateOpportunity() {
        OpportunityEntity opp = new OpportunityEntity(1,BigDecimal.valueOf(123),"Oportunidade",
                "ronaldo","teste@email","descrição","tipo oportunidade",
                "requerimento","requerimento descrição","community","release",
                "squad",null,null,
                TypeStatus.valueOf("ABERTO"));

        ResponseEntity us = service.updateOpportunity(1L, opp);
        assertEquals(us.getStatusCode().value(), 200);
    }

    @Test
    public void testGetOpportunity (){
        assertNotNull(service.getOpportunity());
    }

    @Test
    public void testGetNameOpportunity(){
        List<OpportunityEntity> us = service.getNameOpportunity("Opor");
        assertNotNull(us);
        assertEquals("Oportunidade",us.get(0).getNameOpportunity());
    }

    @Test
    public void testSearchStatus(){
       List<OpportunityEntity> us = service.searchStatus(TypeStatus.valueOf("ABERTO"));
       assertEquals( TypeStatus.ABERTO, us.get(0).getStatus());
    }

//  @Test
//  public void testChangeStatus(){
//
//       ResponseEntity<OpportunityEntity> us = service.changeStatus(1L,TypeStatus.CANCELADO);
//
//       assertEquals(TypeStatus.CANCELADO, us);


}


