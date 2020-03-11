package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.DeptDTO;
import com.sist.model.EmpDAO;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	EmpDAO dao = new EmpDAO();
    	ArrayList<DeptDTO> dept = dao.dept();
    	
    	req.setAttribute("list",dept);
    	
    	//페이지이동
    	RequestDispatcher rd = 
    			req.getRequestDispatcher("insertForm.jsp");
    	rd.forward(req,resp);
    }
}
