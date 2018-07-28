package com.example.jpapractice.domain.board;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board,Long> {

    public List<Board> findBoardByTitle(String title);
    public List<Board> findByWriterContaining(String writer);

}
