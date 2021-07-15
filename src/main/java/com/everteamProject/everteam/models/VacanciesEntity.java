package com.everteamProject.everteam.models;


import com.everteamProject.everteam.models.Enum.TypeStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "VACANCIES")
public class VacanciesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal codeVacancies;
    private String nameVacancies;
    private String nameLeader;
    private String requiredPosition;
    private String requiredLevel;
    private String serviceName;
    private String requirements;
    private String desirableRequirements;
    private String openDate;
    private String closeDate;

    @Enumerated(value = EnumType.STRING)
    private TypeStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getCodeVacancies() {
        return codeVacancies;
    }

    public void setCodeVacancies(BigDecimal codeVacancies) {
        this.codeVacancies = codeVacancies;
    }

    public String getNameVacancies() {
        return nameVacancies;
    }

    public void setNameVacancies(String nameVacancies) {
        this.nameVacancies = nameVacancies;
    }

    public String getNameLeader() {
        return nameLeader;
    }

    public void setNameLeader(String nameLeader) {
        this.nameLeader = nameLeader;
    }

    public String getRequiredPosition() {
        return requiredPosition;
    }

    public void setRequiredPosition(String requiredPosition) {
        this.requiredPosition = requiredPosition;
    }

    public String getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDesirableRequirements() {
        return desirableRequirements;
    }

    public void setDesirableRequirements(String desirableRequirements) {
        this.desirableRequirements = desirableRequirements;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public TypeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeStatus status) {
        this.status = status;
    }

    public VacanciesEntity() {
    }


    public VacanciesEntity(long id, BigDecimal codeVacancies, String nameVacancies, String nameLeader,
                           String requiredPosition, String requiredLevel, String serviceName, String requirements,
                           String desirableRequirements, String openDate, String closeDate, TypeStatus status) {
        this.id = id;
        this.codeVacancies = codeVacancies;
        this.nameVacancies = nameVacancies;
        this.nameLeader = nameLeader;
        this.requiredPosition = requiredPosition;
        this.requiredLevel = requiredLevel;
        this.serviceName = serviceName;
        this.requirements = requirements;
        this.desirableRequirements = desirableRequirements;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.status = status;
    }
}


