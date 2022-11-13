package tw.com.gary.interviewtest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.domain.NurseSiteDoublePK;

public interface NurseSiteRepository extends JpaRepository<NurseSiteBean, NurseSiteDoublePK> {

	@Query("select ns from NurseSiteBean ns where ns.nursesiteDoublePK.empid = :empid")
	List<NurseSiteBean> selectNurseSite(@Param("empid") Integer empid);
}
