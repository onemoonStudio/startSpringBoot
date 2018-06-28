package com.example.boot3.persistence;

import com.example.boot3.demain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    public List<Board> findBoardByTitle(String title);

    public Collection<Board> findByWriter(String writer);

    public Collection<Board> findByWriterContaining(String writer);

    public Collection<Board> findByContentContainingOrWriterContaining(String Content, String Writer);

    public Collection<Board> findByTitleContainingAndBnoGreaterThan(String title,Long bno);

    public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
    // or Asc

    public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno , Pageable paging);

    //public List<Board> findByBnoGreaterThan(Long bno , Pageable paging);


    public Page<Board> findByBnoGreaterThan(Long bno , Pageable paging);

    // JPQL
    @Query("SELECT b FROM Board b WHERE b.title like %?1% and b.bno > 0 ORDER BY b.bno desc")
    public List<Board> findByTitle(String title);

    @Query("SELECT b from Board b WHERE b.content like %:content%  and b.bno > 0 order by b.bno desc")
    public List<Board> findByContent(@Param("content") String content);

    @Query("select board.bno, board.title, board.writer, board.regdate "
            + " from Board board where board.title like %?1% and board.bno > 0 order by board.bno desc")
    public List<Object[]> findByTitle2(String title);

//    @Query("select board.bno, board.title, board.writer, board.regdate "
//            + " from Board board where board.title like %?1% and board.bno > 0 order by board.bno desc" , naitveQuery = true )
    // 위와 같이 nativeQuery 를 사용할 수 있다.


}
