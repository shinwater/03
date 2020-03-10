<%@page import="com.sist.model.EmpDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//set으로 보낸...키 의 밸류값받기! 
	List<EmpDTO> emp = (List<EmpDTO>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="blue">
		<h3>EMP 테이블 레코드 검색 결과</h3>
		<hr width="50%" color="blue">
		<br/><br/><br/>
		
		<table border="1" cellspacing="0" width="700">
			<tr>
				<th>사번</th><th>이름</th><th>담당 업무</th><th>관리자 NO.</th>
				<th>급여</th><th>보너스</th><th>부서번호</th><th>입사일자</th>
			</tr>		
			<%
				if(emp.size() != 0) { //emp에 데이터가 있다면...
					//emp 원소 수만큼 반복해서 출력
					for(int i=0; i<emp.size(); i++){
						EmpDTO dto = emp.get(i);
						%>
						<tr>
							<td><%= dto.getEmpno() %></td>
							<td><%= dto.getEname() %></td>
							<td><%= dto.getJob() %></td>
							<td><%= dto.getMgr() %></td>
							<td><%= dto.getSal() %></td>
							<td><%= dto.getComm() %></td>
							<td><%= dto.getDeptno() %></td>
							<td><%= dto.getHiredate().substring(0,10) %></td>
						</tr>
						
					<%} //for문 끝~~~~
				}else { //데이터가 없는 경우
					%>
					<tr>
						<td colspan="8" align="center">
							<h3> 검색된 레코드가 없습니다.</h3>
						</td>
					</tr>
				<% }%>
		</table>
	</div>
</body>
</html>