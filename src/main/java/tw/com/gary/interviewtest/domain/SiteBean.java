package tw.com.gary.interviewtest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class SiteBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer siteid;
	private String sitename;
	private Date changetime;

	@Override
	public String toString() {
		return "SiteBean [siteid=" + siteid + ", sitename=" + sitename + ", changetime=" + changetime + "]";
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public Date getChangetime() {
		return changetime;
	}

	public void setChangetime(Date changetime) {
		this.changetime = changetime;
	}

}
