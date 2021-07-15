package com.everteamProject.everteam.Service;


import com.everteamProject.everteam.Repository.VacanciesRepository;
import com.everteamProject.everteam.Service.Impl.VacanciesServiceImpl;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import com.everteamProject.everteam.models.VacanciesEntity;
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
public class VacanciesServiceTest {

    @Autowired
    VacanciesServiceImpl service;

    @Autowired
    VacanciesRepository repository;

    @Before
    public void setVac() {
        VacanciesEntity us = new VacanciesEntity();
        us.setId(1);
        us.setCodeVacancies(BigDecimal.valueOf(123));
        us.setNameVacancies("nome vaga");
        us.setNameLeader("nome lider");
        us.setRequiredPosition("requerida");
        us.setRequiredLevel("level requerido");
        us.setServiceName("nome do serviço");
        us.setRequirements("requerimentos");
        us.setDesirableRequirements("requerimentos desejados");
        us.setOpenDate(null);
        us.setCloseDate(null);
        us.setStatus(TypeStatus.ABERTO);
        repository.save(us);
    }

    @After
    public void dellVac() {
        repository.deleteAll();
    }

    @Test
    public void testNewVacansies() {
        VacanciesEntity data = new VacanciesEntity(2, BigDecimal.valueOf(123), "nome vaga",
                "nome lider", "requerida", "level requerido",
                "nome  serviço", "requerimento", "requerimento desejael",
                null, null, TypeStatus.valueOf("ABERTO"));

        VacanciesEntity value = service.postNewVacancies(data);
        assertNotNull(data);
    }

    //    @Test
//    public void tesUpdateVac(){
//        //Alterando close data
//        VacanciesEntity vcc = new VacanciesEntity(1,BigDecimal.valueOf(123),"nome vaga",
//                "nome lider","level requerido","level requerido",
//                "nome  serviço","requerimento","testando",
//                null,null,TypeStatus.valueOf("ABERTO"));
//
//        ResponseEntity us = service.updateVacancies(1L,vcc);
//        assertEquals(200,us.getStatusCode().value());
//    }
    @Test
    public void getAllVac() {
        assertNotNull(service.getVacancies());
    }
//    @Test
//    public void getStatusVac(){
//        List<VacanciesEntity> us = service.searchStatusVacancies(TypeStatus.valueOf("ABERTO"));
//        assertEquals(TypeStatus.ABERTO, us.get(0).getStatus());
//    }
}
