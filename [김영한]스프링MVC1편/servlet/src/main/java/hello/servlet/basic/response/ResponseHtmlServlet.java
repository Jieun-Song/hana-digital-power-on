package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //content타입먼저 잡아야함. text/html, charser=utf-8
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        res.getWriter().write("<html lang='en'><head><meta charset='UTF-8'><title>Title</title></head><body><h1>안녕하세요</h1></body></html>");

    }
}
