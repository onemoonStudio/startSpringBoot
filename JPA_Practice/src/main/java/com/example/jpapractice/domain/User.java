package com.example.jpapractice.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_table_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNum;

    private String userId;

    @CreationTimestamp
    private Timestamp regDate;
    @UpdateTimestamp
    private Timestamp updateDate;


}
