package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) : 데이터 접근 객체 - DB에 접속(연동)하는 객체
public class EmpDAO {
	
	Connection con = null; //DB와 연결
	PreparedStatement pstmt = null;// DB에 sql문을 전송하는 객체
	ResultSet rs = null; //sql문을 실행 후 그 결과값을 가진 객체
	
	public EmpDAO() { //기본 생성자 
		
		//오라클드라이버를 가져와서 사용할수있께해야해...... ... ㅜㅜ
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="genie";
		String password="1234";
		
		//1.드라이버 로오ㅗ오오딩~
		try {
			//애ㅗ냐면 오라클드라이버가 없을수있기떄문에에..
			
			Class.forName(driver);
			
			//2. DB와 연결
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//생성자~~~끝~~~
	
	//EMP 테이블의 전체 레코드를 조회하는 메서드
	public List<EmpDTO> select() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		try {
			String sql= "select * from emp order by empno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 실제로 DB상에서 sql문을 실행하는 메서드
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				//int컬럼중에서 empno라는 라벨의 값을 가져와라아, 와서 setEmpno에 저장해라아...
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("sal"));
				dto.setDeptno(rs.getInt("deptno"));
				
				list.add(dto);
			}
			
			//open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}//select() 메서드 end
	
	
	//DEPT 테이블의 전체 목록을 조회하는 메서드 
	public ArrayList<DeptDTO> dept() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		
		try {

			String sql="select * from dept order by deptno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DeptDTO dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}//dept() 메서드 end
	
	

}
