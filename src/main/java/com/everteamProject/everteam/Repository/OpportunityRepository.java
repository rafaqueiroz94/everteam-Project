package com.everteamProject.everteam.Repository;

import com.everteamProject.everteam.models.OpportunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OpportunityRepository extends JpaRepository<OpportunityEntity, Long> {

    @Query(value = "SELECT * FROM OPPORTUNITY WHERE NAME_OPPORTUNITY like %:nameOpportunity%", nativeQuery = true)
    List<OpportunityEntity> findByName(String nameOpportunity);

    @Query ( value = "SELECT * FROM OPPORTUNITY WHERE STATUS = :status " , nativeQuery = true)
    List<OpportunityEntity> findByStatus(String status);

}
