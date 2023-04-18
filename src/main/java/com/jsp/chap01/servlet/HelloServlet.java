package com.jsp.chap01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/*
    역할: HTTP 요청과 응답 데이터를 쉽게 처리할 수 있게 해주는
            자바의 API
 */

// WAS에게 해당 서블릿을 언제 사용할지 알려주는 코드
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    // 기본 생성자


    public HelloServlet() {
        System.out.println("\n\n\n\n헬로 서블릿 객체가 생성됨!\n\n\n\n");
    }

    // 실제로 개발자가 작성해야되는 부분
    // 실행시점: 클라이언트가 어떠한 요청을 했을 때 서버는 뭘해줄것인가?
    @Override
    protected void service(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        // 요청 방식
        String method = req.getMethod();
        // 요청 URI
        String uri = req.getRequestURI();
        // 요청 파라미터
        String queryString = req.getQueryString();

        // 헤더 정보 읽기
        String cc = req.getHeader("Cache-Control");

        System.out.println("무슨일을 해볼까??");
        System.out.println("method = " + method);
        System.out.println("uri = " + uri);
        System.out.println("queryString = " + queryString);
        System.out.println("cc = " + cc);

        // 쿼리 스트링 파라미터 값 가져오기
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        // 응답메시지 생성
        // h1태그로 xxx님의 출생년도는 xxxx년 입니다.
        // 핵심로직: 출생년도 구하기
        // 올해년도 - 나이 + 1
        int year = LocalDate.now().getYear();
        int birthYear = year - Integer.parseInt(age) + 1;
        System.out.println("birthYear = " + birthYear);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // 응답 메시지 생성
        // 펜을 가져와야 됨
        PrintWriter w = resp.getWriter();



        w.write("<!DOCTYPE html>");
        w.write("<html>");
        w.write("<head>");
        w.write("<body>");
        w.write("<h1>");
        w.write(String.format("%s님은 %d년생 입니다.", name , birthYear));
        w.write("</h1>");
        w.write("</body>");
        w.write("</head>");
        w.write("</html>");
        
        w.flush(); // 버퍼 비우기;
        w.close(); // 펜 객체 해제

    }
}
