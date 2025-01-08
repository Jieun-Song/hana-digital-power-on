package hello.servlet.web.servlet;

import hello.servlet.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();
        w.write("<html lang='en'>");
        w.write("<head>");
        w.write("<meta charset='UTF-8'>");
        w.write("<title>MemberFormServlet</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<form action='/servlet/members/save' method='post'>");
        w.write("username: <input type='text' name='username'><br>");
        w.write("age: <input type='text' name='age'><br>");
        w.write("<button type='submit'>전송</button>");
        w.write("</form>");
        w.write("</body>");
        w.write("</html>");
    }
}
