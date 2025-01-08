package hello.servlet.web.servlet;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("MemberSaveServlet.service");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //결과 html로 응답
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("<meta charset=\"utf-8\">");
        w.write("</head>");
        w.write("<body>");
        w.write("성공");
        w.write("<ul>");
        w.write("<li>id =" + member.getId() + "</li>");
        w.write("<li>username =" + member.getUsername() + "</li>");
        w.write("<li>age =" + member.getAge() + "</li>");
        w.write("</ul>");
        w.write("</body>");
        w.write("</html>");



    }
}
