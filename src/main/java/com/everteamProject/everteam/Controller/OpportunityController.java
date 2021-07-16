package com.everteamProject.everteam.Controller;


import com.everteamProject.everteam.Service.OpportunityService;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.OpportunityEntity;
import com.everteamProject.everteam.models.VacanciesEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping({"/api"})
@CrossOrigin(origins = "*")

public class OpportunityController {

    @Autowired
    OpportunityService service;

    @PostMapping("/new-opportunity")
    @ApiOperation(value = "Nova oportunidade")
    public OpportunityEntity saveNewOpportunity(@RequestBody OpportunityEntity opportunityEntity){
        return service.postNewOpportunity(opportunityEntity);
    }

    @PatchMapping("/id")
    public ResponseEntity updateOpportunity(@RequestParam (value = "id")long id,
                                            @RequestBody OpportunityEntity opportunityEntity){
        return service.updateOpportunity(id,opportunityEntity);
    }

    @GetMapping ("/listAll-opportunity")
    public List getOpportunity(){
        return service.getOpportunity();
    }

    @GetMapping ("/list-opportunity/nameOpportunity")
    public List<OpportunityEntity> getNameOpportunity(@RequestParam String name){
        return service.getNameOpportunity(name);
    }

    @GetMapping ("/list-opportunity/status")
    public List<OpportunityEntity> searchStatus(@RequestParam TypeStatus status){
        return service.searchStatus(status);
    }
    @GetMapping ("/listId/{id}")
    public Optional<OpportunityEntity> getIdOpp(@PathVariable(value = "id")Long id) {
        return service.getIdOpportunity(id);
    }

    @PatchMapping(path = "/list-opportunity/id/changeStatus")
    public ResponseEntity changeStatus(@RequestParam(value = "id")long id, TypeStatus typeStatus){
        return service.changeStatus(id,typeStatus);
    }


}
