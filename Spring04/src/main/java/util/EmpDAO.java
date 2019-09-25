package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import vo.EmpVO;

@Repository
public class EmpDAO {
	
	private Connection cn=JDBCUtil.getConnection();
	private Statement st ;
	private PreparedStatement pst ;
	private ResultSet rs ;
	private String sql ;

	public ArrayList<EmpVO> empList(){
		sql="select * from employees";
		ArrayList<EmpVO> eList = new ArrayList<EmpVO>();

		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
				do {
					EmpVO vo = new EmpVO();
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString(4));
					vo.setEnter(rs.getString(5));
					vo.setGender(rs.getString(6));
					vo.setPhone(rs.getString(7));
					eList.add(vo);
				}while (rs.next());
			} else {
				System.out.println("출력할 eList 자료가 1건도 없음~~");
				eList=null ;
			}
				
		} catch (Exception e) {
			System.out.println("employeesList Exception=>"+e.toString());
			eList=null ;
		}
		return eList;
	}
	
	
	public EmpVO eDetail(EmpVO vo) {
		sql="select * from employees where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs=pst.executeQuery();
			if (rs.next()) {
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setEnter(rs.getString(5));
				vo.setGender(rs.getString(6));
				vo.setPhone(rs.getString(7));
				return vo; 
			}
		} catch (Exception e) {
			System.out.println("eDetail Exception=>"+e.toString());
		}
		return null;
	}
	
	public int eInsert(EmpVO vo) {
		sql="insert into employees values(?,?,?,?,?,?,?)";
		int cnt=0 ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			pst.setString(2,vo.getPassword());
			pst.setString(3,vo.getName());
			pst.setString(4,vo.getLev());
			pst.setString(5,vo.getEnter());
			pst.setString(6,vo.getGender());
			pst.setString(7,vo.getPhone());
			cnt=pst.executeUpdate();
			if (cnt>0) return cnt ;
		} catch (Exception e) {
			System.out.println("eInsert Exception=>"+e.toString());
		} // catch
		return cnt ;
	} // eInsert
	
	public int eUpdate(EmpVO vo) {
		sql="update employees set password=?,name=?,lev=?,"
			+"enter=?,gender=?,phone=? where id=?"	;
		int cnt=0 ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getPassword());
			pst.setString(2,vo.getName());
			pst.setString(3,vo.getLev());
			pst.setString(4,vo.getEnter());
			pst.setString(5,vo.getGender());
			pst.setString(6,vo.getPhone());
			pst.setString(7,vo.getId());
			cnt = pst.executeUpdate();
			if (cnt>0) return cnt ;
		} catch (Exception e) {
			System.out.println("eUpdate Exception=>"+e.toString());
		}
		return cnt ;
	} // eUpdate
	
	public int eDelete(EmpVO vo) {
		sql="delete from employees where id=?";
		int cnt=0;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			cnt=pst.executeUpdate();
			if (cnt>0) return cnt;
		} catch (Exception e) {
			System.out.println("eDelete Exception=>"+e.toString());
		}
		return cnt;
	} // eDelete
	
	
}