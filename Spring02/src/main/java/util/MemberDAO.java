package util;
// Data Access Object

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import vo.MemberVO;

@Component("dao")
public class MemberDAO {
	private Connection cn=JDBCUtil.getConnection();
	private Statement st ;
	private PreparedStatement pst ;
	private ResultSet rs ;
	private String sql ;
	
	public  ArrayList<MemberVO> memberList(){
		sql="select * from member";
		//sql="select id,password,name,lev,to_char(birthd, 'yyyy/mm/dd/') birthd,"
		//		+ "to_char(pay, '9,999,999,999') pay,weight from member";
		//sql="select id,password,name,lev,to_char(birthd, 'yyyy년mm월dd일') birthd,"
		//		+ "pay,weight from member";
		ArrayList<MemberVO> mList = new ArrayList<MemberVO>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
				do {
					MemberVO vo = new MemberVO() ;
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString("lev"));
					vo.setPay(rs.getInt("pay"));
					vo.setBirthd(rs.getString(6));
					vo.setWeight(rs.getDouble(7));
					mList.add(vo);
				}while (rs.next());
			}else {
				System.out.println("출력할 memberList 자료가 1건도 없음~~");
				mList=null ;
			}
		} catch (Exception e) {
			System.out.println("memberList Exception=>"+e.toString());
			mList=null ;
		}
		return mList ;
	} // memberList()
	
	public MemberVO memberLogin(MemberVO vo) {
		sql="select * from member where id=? and password=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			rs= pst.executeQuery();
			if (rs.next()) return vo ;
		} catch (Exception e) {
			System.out.println("memberLogin Exception=>"+e.toString());
		}
		return null ;
	} // memberLogin 
	
	public MemberVO mDetail(MemberVO vo) {
		sql="select * from member where id=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs=pst.executeQuery();
			if (rs.next()) {
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setPay(rs.getInt(5));
				vo.setBirthd(rs.getString(6));
				vo.setWeight(rs.getDouble(7));
				return vo; 
			}
		} catch (Exception e) {
			System.out.println("mDetail Exception=>"+e.toString());
		}
		return null ;
	} // mDetail 
	
	public int mInsert(MemberVO vo) {
		sql="insert into member values(?,?,?,?,?,?,?)";
		int cnt=0 ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			pst.setString(2,vo.getPassword());
			pst.setString(3,vo.getName());
			pst.setString(4,vo.getLev());
			pst.setInt(5,vo.getPay());
			pst.setString(6,vo.getBirthd());
			pst.setDouble(7,vo.getWeight());
			cnt=pst.executeUpdate();
			if (cnt>0) return cnt ;
		} catch (Exception e) {
			System.out.println("mInsert Exception=>"+e.toString());
		} // catch
		return cnt ;
	} // mInsert
	
	public int mUpdate(MemberVO vo) {
		sql="update member set password=?,name=?,lev=?,"
			+"birthd=?,pay=?,weight=? where id=?"	;
		int cnt=0 ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getPassword());
			pst.setString(2,vo.getName());
			pst.setString(3,vo.getLev());
			pst.setString(4,vo.getBirthd());
			pst.setInt(5,vo.getPay());
			pst.setDouble(6,vo.getWeight());
			pst.setString(7,vo.getId());
			cnt = pst.executeUpdate();
			if (cnt>0) return cnt ;
		} catch (Exception e) {
			System.out.println("mUpdate Exception=>"+e.toString());
		}
		return cnt ;
	} // mUpdate
	
	public int mDelete(MemberVO vo) {
		sql="delete from member where id=?";
		int cnt=0;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			cnt=pst.executeUpdate();
			if (cnt>0) return cnt;
		} catch (Exception e) {
			System.out.println("mDelete Exception=>"+e.toString());
		}
		return cnt;
	} // mDelete
	
	

} // class
