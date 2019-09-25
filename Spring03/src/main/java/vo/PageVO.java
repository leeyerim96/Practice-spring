package vo;

import java.util.ArrayList;

public class PageVO {
	private ArrayList<BoardVO> list;  // 출력목록
	private int currPage;   // 출력할 현재 Page
	private int perPage=5;  // 1page 당 출력 갯수
	private int totalCount; // total Record 갯수
	private int perPageNo=3;
	public int getPerPageNo() {
		return perPageNo;
	}
	public void setPerPageNo(int perPageNo) {
		this.perPageNo = perPageNo;
	}
	public ArrayList<BoardVO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardVO> list) {
		this.list = list;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	@Override
	public String toString() {
		return "PageVO [list=" + list + ", currPage=" + currPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ ", perPageNo=" + perPageNo + "]";
	}
	
}
