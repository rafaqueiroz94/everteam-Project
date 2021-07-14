package com.everteamProject.everteam.Service;

import com.everteamProject.everteam.Service.Impl.OpportunityServiceImpl;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OpportunityServiceTest {

    @Autowired
    OpportunityServiceImpl service;

    @Before
    public void setOpp() {
        OpportunityEntity user = new OpportunityEntity();
        user.setCodeOpportunity(BigDecimal.valueOf(123));
    }

    @Test
    public void testNewOpportunity(){
        OpportunityEntity data = new OpportunityEntity(1,BigDecimal.valueOf(123),"Oportunidade","Rento","teste@email","descrição","tipo oportunidade",
                "requerimento","requerimento descrição",null,null, TypeStatus.valueOf("ABERTO"));
        OpportunityEntity value = service.postNewOpportunity(data);
        assertNotNull(data);
    }

    public void testUpdateOpportunity() {

    }
    public void testChangeStatus(){

    }
    public void testGetOpportunity (){
     
    }
    public void testGetNameOpportunity(){

    }
    public void testSearchStatus(){

    }


}
