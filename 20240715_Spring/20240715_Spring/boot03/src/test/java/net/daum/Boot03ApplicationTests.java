package net.daum;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot03ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsert20() {
//		for(int i=1; i <=20;i++) {
//			BoardVO b = new BoardVO();
//			
//			b.setWriter("user0"+(i%10));
//			b.setTitle("게시판 제목...:" + i);
//			b.setContent("내용..."+i);
//			
//			this.boardRepo.save(b);
//		}
	}//샘플 더미데이터 20개저

	@Test
	public void testByTitle() {
//		this.boardRepo.findBoardVOByTitle("게시판 제목...:17").forEach(b->System.out.println(b));
		
		//자바 8이전
//		List<BoardVO> blist = this.boardRepo.findBoardVOByTitle("게시판 제목...:17");
//		
//		if(blist != null && blist.size() > 0) {
//			for(int i=0;i<blist.size(); i++) {
//				System.out.println(blist.get(i));
//			}
//		}else {
//			System.out.println("해당 자료가 없습니다!");
//		}
	}//testByTitle()

	@Test
	public void testByWriter() {
		
		Collection<BoardVO> blist = this.boardRepo.findByWriter("user00");
		
		blist.forEach(b -> {
			System.out.println(b);
		});
	}//testByWriter() => 글쓴이로 검색
}

