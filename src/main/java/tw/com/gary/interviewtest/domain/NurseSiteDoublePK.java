package tw.com.gary.interviewtest.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class NurseSiteDoublePK implements Serializable {
	
	private Integer empid;
	private Integer siteid;
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NurseSiteDoublePK other = (NurseSiteDoublePK) obj;
        if ((this.empid == null) ?
            (other.empid != null) : !this.empid.equals(other.empid)) {
            return false;
        }
        if ((this.siteid == null) ?
            (other.siteid != null) : !this.siteid.equals(other.siteid)) {
            return false;
        }
        return true;
    }
	
	@Override
	public int hashCode() {
		 int hash = 5;
	        hash = 73 * hash + (this.empid != null ? this.empid.hashCode() : 0);
	        hash = 73 * hash + (this.siteid != null ? this.siteid.hashCode() : 0);
	        return hash;
	}
	
	
	
}
