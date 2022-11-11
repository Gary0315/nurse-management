package tw.com.gary.interviewtest.domain;

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
		
		
		
		
		
		@Override
		public String toString() {
			return "siteBean [siteid=" + siteid + ", sitename=" + sitename + "]";
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
		
		
	
}
