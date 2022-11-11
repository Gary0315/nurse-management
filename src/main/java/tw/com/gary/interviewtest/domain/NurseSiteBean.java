package tw.com.gary.interviewtest.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nursesite")
public class NurseSiteBean {
	
	@EmbeddedId
	private NurseSiteDoublePK nursesiteDoublePK;

	
	@Override
	public String toString() {
		return "nursesiteBean [nursesiteDoublePK=" + nursesiteDoublePK + "]";
	}

	public NurseSiteDoublePK getNursesiteDoublePK() {
		return nursesiteDoublePK;
	}

	public void setNursesiteDoublePK(NurseSiteDoublePK nursesiteDoublePK) {
		this.nursesiteDoublePK = nursesiteDoublePK;
	}
	
	
	
}
