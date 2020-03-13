package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;


@WebServlet("/insertOk")
public class InsertOkServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertOkServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//한글 인코딩 처리
    	req.setCharacterEncoding("UTF-8");
    	
    	//입력폼 창에서 넘어온 데이터들을 처리해주자.
    	int empno = Integer.parseInt(req.getParameter("no"));
    	String ename = req.getParameter("name");
    	String job = req.getParameter("job");
    	int mgr = Integer.parseInt(req.getParameter("mgrNo"));
    	int sal = Integer.parseInt(req.getParameter("sal"));
    	int comm = Integer.parseInt(req.getParameter("comm"));
    	int deptno = Integer.parseInt(req.getParameter("deptNo"));
    	
    	EmpDTO dto = new EmpDTO();
    	dto.setEmpno(empno);
    	dto.setEname(ename);
    	dto.setJob(job);
    	dto.setMgr(mgr);
    	dto.setSal(sal);
    	dto.setComm(comm);
    	dto.setDeptno(deptno);
    	
    	EmpDAO dao = new EmpDAO();
    	int res = dao.insert(dto);
    	
    	resp.setContentType("text/html; charset=UTF-8"); 
    	PrintWriter out = resp.getWriter();
    	
    	if(res>0) {//레코드 추가 성공
    		resp.sendRedirect("select");
    		
    	}else {
    		out.println("<script>");
    		out.println("alert('레코드 추가실패!!!!')");
    		out.println("history.back()");
    		out.println("</script>");
    	}
    }
}
