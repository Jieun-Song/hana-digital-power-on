package org.example.practice;

import org.example.practice.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardVO, Integer> {

    //게시물 저장
//    @Query("insert into pr_board(bno, writer, title, content) values()")
//    public static void insertBoard(String writer, String title, String content) {
////        repository.save(entity)
//
//    }
    //getRowCount
    @Query(value = "SELECT count(*) FROM BoardVO")
    public int getRowCount();

}
