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
	private String uploadfile; // member Table에 정의된 field 명과 동일
	private MultipartFile uploadfilef;// form의 input tag의 name과 동일
	// form으로 부터 읽어오기 위한 filename 필드
	/* => Multipartfile type은 upload 된 화일을 저장하기 위해 필요한 타입이며
	 * 서버의 지정된 위치에 image 를 보관하고 
	 * 실제 db의 table에는 경로와 화일명이 String type으로 보관됨.
	 * 그러므로 이에 대한 처리가 필요함
	 * => 별도의 String Type uploadfile 필드 추가하여 사용함
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
