package vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity // ���̺�� ���εǴ� ��ü
@Table(name="board")
//Entity�� ���õ� ���̺��� name �Ӽ��� ����Ͽ� ������.
//=> name �����ÿ��� Ŭ������ �̸��� ���ε�
public class BoardVO {
	@Id // ���̺��� �⺻key�� ������
	@GeneratedValue // id�� ������ �⺻Ű�� ���� �ڵ����� ������ �� ���
	private int seq;
	private String title;
	private String id;
	private String content;
	@Temporal(TemporalType.TIMESTAMP) 
	// ��¥Ÿ���� ������ �����Ͽ� ��¥Ÿ���� ����
	// TemporalType.DATE : ��¥������ ���
	// TemporalType.TIME : �ð������� ���
	// TemporalType.TIMESTAMP : ��¥ �ð� ���
	private Date regdate = new Date();
	private int cnt;
	private int root;
	private int step;
	private int indent;
	
	
	//@Transient // ���̺��� ���ܽ�����
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
