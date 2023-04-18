<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.entity.Dancer" %>

<%
    // request객체에 담긴 리스트 꺼내기
    List<Dancer> dancerList = (List<Dancer>) request.getAttribute("dl");
%>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    .del-btn {
        padding: 10px;
        outline: none;
        border: none;
        background: red;
        border-radius: 10px;
        color: #fff;
        margin-left: 10px;
    }
</style>
</head>
<body>

    <h1>mvc 버전 댄서 목록 뷰</h1>

      <!-- for (Dance d : dl) -->
      <c:forEach var="d" items="${dl}">
        <!-- <c:forEach var="d" items="${dl}"> </c:forEach>
        이거 잘 쓰니까 알기
    -->
 
        <li>
            <!-- ${d.name} 이라고 쓰면 게터를 불러온다. -->
            # 이름: <span class="dancer-name">${d.name()}</span>,
            # 크루명: ${d.CrewName()},
            # 레벨: ${d.DanceLevel()},
            # 페이: ${d.DanceLevel.payPerEvent}원
            <button class="del-btn">삭제</button>
        </li>
    </c:forEach>

    <script>

    </script>

    <a href="/dancer/join">재등록</a>

</body>
</html>