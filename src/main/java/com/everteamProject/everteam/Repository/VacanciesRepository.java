package com.everteamProject.everteam.Repository;


import com.everteamProject.everteam.models.VacanciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface VacanciesRepository extends JpaRepository<VacanciesEntity, Long> {

    @Query(value = "SELECT * FROM VACANCIES WHERE NAME_LEADER like %:nameLeader%", nativeQuery = true)
    List<VacanciesEntity> findByNameLeader(String nameLeader);

    @Query ( value = "SELECT * FROM VACANCIES WHERE STATUS = :status ", nativeQuery = true)
    List<VacanciesEntity> findByStatus(String status);

    @Query( value = "SELECT * FROM VACANCIES WHERE OPEN_DATE like %:openDate% ", nativeQuery = true)
    List<VacanciesEntity> findByOpenDate(String openDate);
}
