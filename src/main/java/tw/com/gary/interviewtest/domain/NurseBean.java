package tw.com.gary.interviewtest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
public class NurseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String empname;
	private Date changetime;
	
	@Override
	public String toString() {
		return "NurseBean [empid=" + empid + ", empname=" + empname + ", changetime=" + changetime + "]";
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Date getChangetime() {
		return changetime;
	}
	public void setChangetime(Date changetime) {
		this.changetime = changetime;
	}
	

	
	
	
}
