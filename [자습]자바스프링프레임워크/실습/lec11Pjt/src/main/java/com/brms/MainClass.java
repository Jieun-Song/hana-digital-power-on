package com.brms;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.brms.book.Book;
import com.brms.book.service.BookRegisterService;
import com.brms.book.service.BookSearchService;
import com.brms.member.Member;
import com.brms.member.service.MemberRegisterService;
import com.brms.member.service.MemberSearchService;

public class MainClass {
	public static void main(String[] args) {

		String[] bNums = { "739", "985", "184", "830", "816" };
		String[] bTitles = { "html", "css", "jQuery", "java", "spring" };
		
		String[] mIds = { "rabbit", "hippo", "raccoon", "elephan", "lion" };
		String[] mPws = { "96539", "94875", "15284", "48765", "28661" };
		String[] mNames = { "agatha", "barbara", "chris", "doris", "elva" };
		
		//스프링 컨테이너 생성
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// 더미 도서 목록 등록
		BookRegisterService bookRegisterService = 
				ctx.getBean("bookRegisterService", BookRegisterService.class);
		for (int i = 0; i < bNums.length; i++) {
			Book book = new Book(bNums[i], bTitles[i], true, null);
			bookRegisterService.register(book);
		}
		
		// 더미 도서 목록 출력
		BookSearchService bookSearchService = 
				ctx.getBean("bookSearchService", BookSearchService.class);
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("------------------------------------------");
		for (int i = 0; i < bNums.length; i++) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getBNum() + "\t");
			System.out.print(book.getBTitle() + "\t");
			System.out.print(book.isBCanRental() + "\t");
			System.out.println(book.getBMember() == null ? null : book.getBMember().getMId());
		}
		
		// 더미 회원 목록 등록
		MemberRegisterService memberRegisterService = 
				ctx.getBean("memberRegisterService", MemberRegisterService.class);
		for (int i = 0; i < mIds.length; i++) {
			Member member = new Member(mIds[i], mPws[i], mNames[i]);
			memberRegisterService.register(member);
		}
		
		// 더미 회원 목록 출력
		MemberSearchService memberSearchService = 
				ctx.getBean("memberSearchService", MemberSearchService.class);
		System.out.println("\nmId\tmPw\tmName");
		System.out.println("------------------------------------------");
		for (int i = 0; i < mIds.length; i++) {
			Member member = memberSearchService.searchMember(mIds[i]);
			System.out.print(member.getMId() + "\t");
			System.out.print(member.getMPw() + "\t");
			System.out.print(member.getMName() + "\n");
		}
		
		// 도서 대여 목록 등록
		bookRegisterService.register(new Book("739", "html", false, memberSearchService.searchMember("elephan")));
		bookRegisterService.register(new Book("184", "jQuery", false, memberSearchService.searchMember("hippo")));
		bookRegisterService.register(new Book("816", "spring", false, memberSearchService.searchMember("rabbit")));
		bookRegisterService.register(new Book("985", "css", false, memberSearchService.searchMember("rabbit")));
		
		// 도서 대여 목록 출력
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("------------------------------------------");
		for (int i = 0; i < bNums.length; i++) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getBNum() + "\t");
			System.out.print(book.getBTitle() + "\t");
			System.out.print(book.isBCanRental() + "\t");
			System.out.println(book.getBMember() == null ? null : book.getBMember().getMId());
		}
		
		ctx.close();
		
	}
}
