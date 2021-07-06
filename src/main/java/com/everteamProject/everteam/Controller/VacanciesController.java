package com.everteamProject.everteam.Controller;


import com.everteamProject.everteam.Service.VacanciesService;
import com.everteamProject.everteam.models.Enum.TypeStatus;
import com.everteamProject.everteam.models.VacanciesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@ResponseBody
@RequestMapping({"/api-two"})
@CrossOrigin(origins = "*")
public class VacanciesController {

    @Autowired
    VacanciesService service;

    @PostMapping("/new-vacancies")
    public VacanciesEntity newVacancies( @RequestBody VacanciesEntity vacanciesEntity){
        return service.postNewVacancies(vacanciesEntity);
    }

    @GetMapping("/list-vacancies/leaders")
    public List<VacanciesEntity> getNameLeaderVacancies(@RequestParam String name) {
        return service.getNameLeader(name);
    }

    @GetMapping("/list-vacancies/status")
    public List<VacanciesEntity> getStatusVacancies(@RequestParam TypeStatus status){
        return service.searchStatusVacancies(status);
    }

    @GetMapping("List-vacanciesAll/")
    public List<VacanciesEntity> getVacancie(){
        return service.getVacancies();
    }

    @GetMapping ("/list-vacancies/data")
    public List<VacanciesEntity> getDate(@RequestParam String date){
        return service.searchDate(date);
    }

    @PatchMapping ("/id")
    public ResponseEntity updateVacancies(@RequestParam (value = "id")long id,@RequestBody VacanciesEntity vacanciesEntity){
        return service.updateVacancies(id,vacanciesEntity);
    }

    @PatchMapping ("/list-vacancies/changeStatus")
    public ResponseEntity changeStatusVacancies(@RequestParam(value = "id") long id, TypeStatus status){
        return service.changeStatusVacancies(id,status);
    }
}
