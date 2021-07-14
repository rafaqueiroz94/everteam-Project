package com.everteamProject.everteam.models;


import com.everteamProject.everteam.models.Enum.TypeStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "OPPORTUNITY")

public class OpportunityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal codeOpportunity;
    private String nameOpportunity;
    private String responsibleName;
    private String responsibleEmail;
    private String descriptionOpportunity;
    private String typeOpportunity;
    private String requirement;
    private String requirementDescription;
    private Date openDate;
    private String closeDate;

    @Enumerated(value = EnumType.STRING)
    private TypeStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getCodeOpportunity() {
        return codeOpportunity;
    }

    public void setCodeOpportunity(BigDecimal codeOpportunity) {
        this.codeOpportunity = codeOpportunity;
    }

    public String getNameOpportunity() {
        return nameOpportunity;
    }

    public void setNameOpportunity(String nameOpportunity) {
        this.nameOpportunity = nameOpportunity;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleEmail() {
        return responsibleEmail;
    }

    public void setResponsibleEmail(String responsibleEmail) {
        this.responsibleEmail = responsibleEmail;
    }

    public String getDescriptionOpportunity() {
        return descriptionOpportunity;
    }

    public void setDescriptionOpportunity(String descriptionOpportunity) {
        this.descriptionOpportunity = descriptionOpportunity;
    }

    public String getTypeOpportunity() {
        return typeOpportunity;
    }

    public void setTypeOpportunity(String typeOpportunity) {
        this.typeOpportunity = typeOpportunity;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getRequirementDescription() {
        return requirementDescription;
    }

    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
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

    public OpportunityEntity() {

    }

    public OpportunityEntity(long id, BigDecimal codeOpportunity, String nameOpportunity, String responsibleName,
                             String responsibleEmail, String descriptionOpportunity, String typeOpportunity,
                             String requirement, String requirementDescription, Date openDate, String closeDate,
                             TypeStatus status) {
        this.id = id;
        this.codeOpportunity = codeOpportunity;
        this.nameOpportunity = nameOpportunity;
        this.responsibleName = responsibleName;
        this.responsibleEmail = responsibleEmail;
        this.descriptionOpportunity = descriptionOpportunity;
        this.typeOpportunity = typeOpportunity;
        this.requirement = requirement;
        this.requirementDescription = requirementDescription;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.status = status;
    }
}
