package com.example.jpapractice.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "board_table_test")
public class Board {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long bno;
    private String title;
    private String contents;
    private String writer;

}
