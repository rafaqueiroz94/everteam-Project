package com.everteamProject.everteam.models;


import javax.persistence.*;

@Entity
@Table(name = "leader")

public class LeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;

    @Column (name = "name")
    private String nameLeader;

    @Column (name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLeader() {
        return nameLeader;
    }

    public void setNameLeader(String nameLeader) {
        this.nameLeader = nameLeader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LeaderEntity() {
    }

    public LeaderEntity(String nameLeader, String email) {
        this.nameLeader = nameLeader;
        this.email = email;
    }

}
