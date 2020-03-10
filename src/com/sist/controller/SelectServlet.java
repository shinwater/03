package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;


@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	*/
    
    //form 으로 안써서 !! doget()인지 dopost()인지 모를떄? service()
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> emp = dao.select();
		
		request.setAttribute("list", emp);//키이름.데이터
		
		//페이지이동
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);//실제적으로 이동~~
	}


}
