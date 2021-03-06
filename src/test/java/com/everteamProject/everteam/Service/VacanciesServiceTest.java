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

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        VacanciesEntity user = new VacanciesEntity();
        user.setId(1);
        user.setCodeVacancies(BigDecimal.valueOf(123));
        user.setNameVacancies("nome vaga");
        user.setNameLeader("nome lider");
        user.setRequiredPosition("requerida");
        user.setRequiredLevel("level requerido");
        user.setServiceName("nome do serviço");
        user.setRequirements("requerimentos");
        user.setDesirableRequirements("requerimentos desejados");
        user.setOpenDate("16/07/2021");
        user.setCloseDate(null);
        user.setStatus(TypeStatus.ABERTO);
        VacanciesEntity result = repository.save(user);
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
                null, null, TypeStatus.ABERTO);

        VacanciesEntity value = service.postNewVacancies(data);
        assertNotNull(value);
    }

    @Test
    public void tesUpdateVac() {
        //Alterando DESIRABLE
        setVac();
        VacanciesEntity vcc = new VacanciesEntity(1, BigDecimal.valueOf(123), "nome vaga",
                "nome lider", "level requerido", "level requerido",
                "nome  serviço", "requerimento", "testando",
                null, null, TypeStatus.valueOf("ABERTO"));

        ResponseEntity us = service.updateVacancies(1L, vcc);
        assertEquals(200, us.getStatusCode().value());
    }

    @Test
    public void testGetAllVac() {
        assertNotNull(service.getVacancies());
    }

    @Test
    public void testGetStatusVac() {
        setVac();
        List<VacanciesEntity> us = service.searchStatusVacancies(TypeStatus.ABERTO);
        assertEquals(TypeStatus.ABERTO, us.get(0).getStatus());
    }

    @Test
    public void testGetNameLeaderVac() {
        setVac();
        List<VacanciesEntity> us = service.getNameLeader("nom");
        assertEquals("nome lider", us.get(0).getNameLeader());
    }

    @Test
    public void testUpdateStatus() {
        setVac();
        ResponseEntity us = service.changeStatusVacancies(1L, TypeStatus.CANCELADO);
        assertEquals(us.getStatusCode().value(), 200);
    }

    @Test
    public void testGetIdVac(){
        setVac();
        Optional<VacanciesEntity> us = service.getIdVacancies(1L);
        assertEquals(1,us.get().getId());
    }
    @Test
    public void testGetDataVac(){
        setVac();
        List<VacanciesEntity> us = service.searchDate("16/07/2021");
        assertEquals("16/07/2021",us.get(0).getOpenDate());
    }
}
