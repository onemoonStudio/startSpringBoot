package com.startsb.webservice.Persistence;

import com.startsb.webservice.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board,Long>{


}
