package vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("vo")
public class MemberVO {
	private String id ;
	private String password ;
	private String name ;
	private String lev ;
	private int pay ;
	private String birthd ;
	private double weight ;
	private String uploadfile; // member Table�� ���ǵ� field ��� ����
	private MultipartFile uploadfilef;// form�� input tag�� name�� ����
	// form���� ���� �о���� ���� filename �ʵ�
	/* => Multipartfile type�� upload �� ȭ���� �����ϱ� ���� �ʿ��� Ÿ���̸�
	 * ������ ������ ��ġ�� image �� �����ϰ� 
	 * ���� db�� table���� ��ο� ȭ�ϸ��� String type���� ������.
	 * �׷��Ƿ� �̿� ���� ó���� �ʿ���
	 * => ������ String Type uploadfile �ʵ� �߰��Ͽ� �����
	 */
	
	public MultipartFile getUploadfilef() {
		return uploadfilef;
	}
	
	public void setUploadfilef(MultipartFile uploadfilef) {
		this.uploadfilef = uploadfilef;
	}
	
	public String getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", lev=" + lev + ", pay=" + pay
				+ ", birthd=" + birthd + ", weight=" + weight + ", uploadfile=" + uploadfile + ", uploadfilef="
				+ uploadfilef + "]";
	}
	
	
} // class
