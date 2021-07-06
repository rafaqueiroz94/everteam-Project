package com.everteamProject.everteam.Repository;

import com.everteamProject.everteam.models.LeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends JpaRepository<LeaderEntity,Long> {


}
