package net.daum.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UploadController {
	
	//동기식 파일첨부 뷰페이지
	@GetMapping("/uploadForm")
	public void uploadForm() {
		//리턴 타입이 없는 void 형이면 매핑주소인 uploadForm이 뷰페이지 파일명이 된다.
		
	}//uploadForm()
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, HttpServletRequest request) {
		//uploadFile 매개변수명과 input type="file"의 네임 파라미터 이름이 같아야한다.
		String uploadFolder = request.getSession().getServletContext().getRealPath("upload");
		//첨부된 실제 이진파일이 업로드될 실제 경로를 구함
		System.out.println("실제 업로드 경로 : "+ uploadFolder);
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("==================>");
			System.out.println("upload file name :"+ multipartFile.getOriginalFilename());
			System.out.println("upload file size :"+ multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); //upload폴더에 실제 첨부된 파이 ㄹ업로드
			}catch(Exception e ) {e.printStackTrace();}
		}
		
	}//uploadFormAction
	
	//비동기식 파일첨부 뷰페이지
	@RequestMapping(value="/uploadAjax",method = RequestMethod.GET) // get으로 접근하는 매핑주소 처리
	public ModelAndView uploadAjax() {
		return new ModelAndView("uploadAjaxForm");//뷰페이지 경로가 /WEB-INf/views/uploadAjaxForm.jsp
	}//reloadAjax()
	
	@RequestMapping(value="/uploadAjaxAction", method =RequestMethod.POST) // post로 접근하는 매핑주소 처리
	public void uploadAjaxAction(MultipartFile[] uploadFile, HttpServletRequest request) {
		System.out.println("\n ==============> upload Ajax post....");
		String uploadFolder = request.getSession().getServletContext().getRealPath("upload");
		
		for (MultipartFile multipartFile : uploadFile) {
			System.out.println("\n ================> \n");
			System.out.println("Upload File Name : "+ multipartFile.getOriginalFilename());
			System.out.println("Upload File Size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename(); //첨부된 파일명을 구함
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("//"));
//			인터넷 익스플로러인 경우는 첨부파일 전체 경로가 전송된다. 경로 구분'\'를
//			lastIndexOf()메서드에 의해 맨 오른쪽에서부터 찾아서 가장 먼저 나오는 '\'의
//			위치번호를 맨왼쪽 0부터 시작해서 구한다.
//			결국 마지막 경로구분 '\' 이후부터 마지막 문자까지 구하면 실제 첨부 원본파일명을 구함
			System.out.println("only file name : "+uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
