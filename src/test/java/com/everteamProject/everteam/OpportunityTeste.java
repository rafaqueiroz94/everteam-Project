package com.everteamProject.everteam;

import com.everteamProject.everteam.Service.Impl.OpportunityServiceImpl;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OpportunityTeste {

    @Autowired
    OpportunityServiceImpl service;

    @Test
    public void  tesNewOpportunity (){
        OpportunityEntity data = new OpportunityEntity(BigDecimal.valueOf(123),"Oportunidade","descrição","tipo oportunidade",
                                                        "requerimento","requerimento descrição",null,null, TypeStatus.valueOf("ABERTO"));
        OpportunityEntity value = service.postNewOpportunity(data);

        assertEquals(value.getCodeOpportunity(), BigDecimal.valueOf(123));
    }

}
