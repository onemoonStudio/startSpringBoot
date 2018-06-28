package com.example.boot3;

import com.example.boot3.demain.Board;
import com.example.boot3.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot3ApplicationTests {

	@Autowired
	private BoardRepository repo;

	@Test
	public void testInsert200(){
		for(int i=0;i<200;i++){
			Board board  = new Board();
			board.setTitle("title_" + i);
			board.setContent("Contents_" + i);
			board.setWriter("Writer_0" + i%10);
			repo.save(board);
		}
	}

	@Test
	public void testByTitle(){
		repo.findBoardByTitle("title_192").forEach(board -> {
			System.out.println(board);
		});
	}

	@Test
	public void testByWriter(){
		Collection<Board> results =repo.findByWriter("Writer_00");

		results.forEach(
				board -> {
			System.out.println("@@@@@@"+board);
		});
	}

	@Test
	public void testByWriterContaining(){
		Collection<Board> results = repo.findByWriterContaining("02");

		results.forEach(board -> {
			System.out.println("@ "+board);
		});
	}

	@Test
	public void testContentOrWriterContaining(){
		Collection<Board> results = repo.findByContentContainingOrWriterContaining("3","07");

		results.forEach(board -> {
			System.out.println("@ "+board);
		});
	}

	@Test
	public void testTitleAndBnoGreater(){
		Collection<Board> results =  repo
				.findByTitleContainingAndBnoGreaterThan("5" , 50L);

		results.forEach(board -> {
			System.out.println(" IN DB > " + board);
		});
	}

	@Test
	public void testBnoOrder(){
		Collection<Board> results = repo
				.findByBnoGreaterThanOrderByBnoDesc(150L);

		results.forEach(board -> {
			System.out.println(" IN DB > " + board);
		});
	}


	@Test
	public void testBnoOrderByPaging(){
		Pageable paging  = PageRequest.of(2,10);

		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L,paging);
		results.forEach(board -> {
			System.out.println(board);
		});
	}

//	@Test
//	public void findByBnoGreaterThan(){
//		Pageable paging = PageRequest.of(0,10, Sort.Direction.ASC,"bno");
//
//		Collection<Board> results = repo.findByBnoGreaterThan(0L,paging);
//		results.forEach(board -> {
//			System.out.println(board);
//		});
//
//	}

	@Test
	public void testBnoPagingSort(){
		Pageable paging = PageRequest.of(0,10,Sort.Direction.ASC, "bno");
		Page<Board> result = repo.findByBnoGreaterThan(0L,paging);

		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());

		List<Board> list = result.getContent();

		list.forEach(board -> System.out.println(board));

	}

	@Test
	public void testByTitle2() {

		repo.findByTitle("17").forEach(board -> System.out.println(board));

	}

	@Test
	public void testByTitle17() {

		repo.findByTitle2("17").forEach(arr -> System.out.println(Arrays.toString(arr)));

	}

}
