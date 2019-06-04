package com.stackroute.muzixservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Id;
@Data
@NoArgsConstructor
@Entity
public class Music {
    @Id

    private int tid;
    private String tname;
    private String comments;


    public Music(int tid, String tname, String comments) {
        this.tid = tid;
        this.tname = tname;
        this.comments = comments;
    }

}