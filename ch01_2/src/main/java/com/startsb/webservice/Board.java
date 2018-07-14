package com.startsb.webservice;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_hibernate")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String title;
    private String writer;
    private String content;

//    private Date created;
//    private Date updated;
//    @PrePersist
//    protected void onCreate(){
//        created = new Date();
//    }
//    @PreUpdate
//    protected void onUpdate(){
//        updated = new Date();
//    }

    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;


}
