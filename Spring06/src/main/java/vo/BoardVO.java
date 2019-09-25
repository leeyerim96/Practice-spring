package vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity // 테이블과 매핑되는 개체
@Table(name="board")
//Entity와 관련된 테이블을 name 속성을 사용하여 매핑함.
//=> name 생략시에는 클래스의 이름이 매핑됨
public class BoardVO {
	@Id // 테이블의 기본key와 매핑함
	@GeneratedValue // id로 설정된 기본키의 값을 자동으로 생성할 때 사용
	private int seq;
	private String title;
	private String id;
	private String content;
	@Temporal(TemporalType.TIMESTAMP) 
	// 날짜타입의 변수에 선언하여 날짜타입을 매핑
	// TemporalType.DATE : 날짜정보만 출력
	// TemporalType.TIME : 시간정보만 출력
	// TemporalType.TIMESTAMP : 날짜 시간 모두
	private Date regdate = new Date();
	private int cnt;
	private int root;
	private int step;
	private int indent;
	
	
	//@Transient // 테이블에서 제외시켜줌
	//private int age;
	
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", id=" + id + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + ", root=" + root + ", step=" + step + ", indent=" + indent + "]";
	}
	
	
}
