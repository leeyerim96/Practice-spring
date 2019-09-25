package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import vo.BoardVO;
import vo.PageVO;

@Repository
public class BoardDAO {
	// ��������
	// list, detail, insert, update, delete

	public Connection cn = JDBCUtil.getConnection();
	public Statement st;
	public PreparedStatement pst;
	public ResultSet rs;
	public String sql;

	public int totalCount() {
		sql="select count(*) from board";
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("** totalCount Exception=>"+e.toString());
		}
		return 0;
	} // totalCount

	public PageVO pageList(PageVO pvo) {
		// totalCount ���ϱ�
		pvo.setTotalCount(totalCount());
		// ArrayList<BoardVO> list ���ϱ�
		// => ResertSet ���� ����
		sql = "select seq,title,id,content," + "to_char(regdate, 'yyyy/mm/dd/ hh24:mi:ss') regdate,cnt,root,step,indent"
				+ " from board order by root desc, step asc";
		ArrayList<BoardVO> blist = new ArrayList<BoardVO>();
		try {
			pst = cn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
			// skip data ���� ���ϱ�
			// rs ���� ����� page���� �ʿ��� ��ŭ�� ����
			// => rs ���� ������ġ �� ���� ��ġ
			// => ������ġ : skip ����, 
			// => ���� ��ġ : ������ġ + page�� ��� ����
			int skip = (pvo.getCurrPage()-1)*pvo.getPerPage();
			if (skip>0) rs.absolute(skip);
			
			for (int i=0; i<pvo.getPerPage() && rs.next();i++) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setRegdate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				vo.setRoot(rs.getInt(7));
				vo.setStep(rs.getInt(8));
				vo.setIndent(rs.getInt(9));
				blist.add(vo);
			} // for
			pvo.setList(blist);
		} catch (Exception e) {
			System.out.println("** boardList Exception =>" + e.toString());
			pvo=null;
		}
		return pvo;
	} // pageList


	// list, detail, insert, update, delete => CRUD
	public  ArrayList<BoardVO> boardList(){
		//sql="select * from board order by root desc, step asc";
		sql="select seq,title,id,content,"
				+"to_char(regdate,'yyyy/mm/dd/ hh24:mi:ss') regdate, cnt, root, step, indent "
				+"from board order by root desc, step asc";
		ArrayList<BoardVO> blist = new ArrayList<BoardVO>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
				do {
					BoardVO vo = new BoardVO() ;
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getShort(6));
					vo.setRoot(rs.getInt(7));
					vo.setStep(rs.getInt(8));
					vo.setIndent(rs.getInt(9));
					blist.add(vo);
				}while (rs.next());
			}else {
				System.out.println("BoardList : ����� �ڷᰡ ����");
				blist=null ;
			}
		} catch (Exception e) {
			System.out.println("BoardList Exception=>"+e.toString());
			blist=null ;
		}
		return blist ;
	} //boardList


	public BoardVO boardDetail(BoardVO vo) {
		sql="select * from board where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			rs=pst.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegdate(rs.getString(5));
				vo.setCnt(rs.getShort(6));
				vo.setRoot(rs.getInt(7));
				vo.setStep(rs.getInt(8));
				vo.setIndent(rs.getInt(9));
				return vo; 
			}else {
				System.out.println("** boardDetail : ����� �ڷᰡ ����");
			}
		} catch (Exception e) {
			System.out.println("bDetail Exception=>"+e.toString());
		}
		return null ;
	} // boardDetail 

	public int boardInsert(BoardVO vo) {
		sql="insert into board values " + 
				"((select nvl(max(seq), 0)+1 from board), ?, ?, ?,sysdate,0,"
				+ "(select nvl(max(seq), 0)+1 from board),0,0)";
		int cnt=0 ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getTitle());
			pst.setString(2,vo.getId());
			pst.setString(3,vo.getContent());

			cnt=pst.executeUpdate();
			if (cnt>0) return cnt ;
		} catch (Exception e) {
			System.out.println("boardInsert Exception=>"+e.toString());
		} // catch
		return cnt ;
	} // bInsert


	public int boardUpdate(BoardVO vo) {
		sql="update board set title=?, content=?"
				+"where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getTitle());
			pst.setString(2,vo.getContent());
			pst.setInt(3,vo.getSeq());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("bUpdate Exception=>"+e.toString());
			return 0;
		}
	} // bUpdate

	public int boardDelete(BoardVO vo) {
		// ������ ���� �ÿ��� ��� ����� ���� ����, ( root =? )
		// ����� �����ÿ��� �ش� ��۸� ���� (seq=?)
		// => 1) ���Ǻ� seq!=root : ��� / else : ����
		// => 2) �ش� sql ���� �ۼ�
		int test =0;
		if(vo.getSeq()!=vo.getRoot()) { // ���
			sql="delete board where seq=?";
			test = vo.getSeq();
		}else { // ����
			sql="delete board where root=?";
			test = vo.getRoot();
		}
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1,test);
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("bDelete Exception=>"+e.toString());
			return 0;
		}
	} // bDelete 


	public int countUp(BoardVO vo) {
		sql="update board set cnt=cnt+1 where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1,vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("countUp Exception=>"+e.toString());
			return 0;
		}
	}


	public int rinsert(BoardVO vo) {
		System.out.println("** rinsert StepUp cnt=>"+stepUp(vo));
		sql="insert into board values " + 
				"((select nvl(max(seq), 0)+1 from board), ?, ?, ?,sysdate,0,"
				+ "?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getTitle());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getContent());
			pst.setInt(4, vo.getRoot());
			pst.setInt(5, vo.getStep());
			pst.setInt(6, vo.getIndent());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("rinsert Exception=>"+e.toString());
			return 0;
		}
	}

	public int stepUp(BoardVO vo) {
		sql="update board set step=step+1 where root=? and step>=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getRoot());
			pst.setInt(2, vo.getStep());
			return pst.executeUpdate();
		}catch(Exception e) {
			System.out.println("stepUp Exception=>"+e.toString());
			return 0;
		}
	}
}
