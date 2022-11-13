package tw.com.gary.interviewtest.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "nursesite")
public class NurseSiteBean {
	
//	@ManyToOne
//	@JoinColumn(
//			name="SITEID",
//			referencedColumnName = "SITEID"
//			)
//	private SiteBean siteBean;
//	
//	public SiteBean getSiteBean() {
//		return siteBean;
//	}
//	
//	public void setSiteBean(SiteBean siteBean) {
//		this.siteBean = siteBean;
//	}
//	
//	@ManyToOne
//	@JoinColumn(
//			name="EMPID",
//			referencedColumnName = "EMPID"
//			)
//	private NurseBean nurseBean;
//	
//	public NurseBean getNurseBean() {
//		return nurseBean;
//	}
//
//	public void setNurseBean(NurseBean nurseBean) {
//		this.nurseBean = nurseBean;
//	}

	@EmbeddedId
	private NurseSiteDoublePK nursesiteDoublePK;
	
	private Date addtime;

	@Override
	public String toString() {
		return "NurseSiteBean [nursesiteDoublePK=" + nursesiteDoublePK + ", addtime=" + addtime + "]";
	}

	public NurseSiteDoublePK getNursesiteDoublePK() {
		return nursesiteDoublePK;
	}
	
	public void setNursesiteDoublePK(NurseSiteDoublePK nursesiteDoublePK) {
		this.nursesiteDoublePK = nursesiteDoublePK;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	
	
	
}
