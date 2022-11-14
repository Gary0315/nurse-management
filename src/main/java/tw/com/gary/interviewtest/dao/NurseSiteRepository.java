package tw.com.gary.interviewtest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.domain.NurseSiteDoublePK;

public interface NurseSiteRepository extends JpaRepository<NurseSiteBean, NurseSiteDoublePK> {

	@Query("select ns from NurseSiteBean ns where ns.nursesiteDoublePK.empid = :empid")
	List<NurseSiteBean> selectNurse(@Param("empid") Integer empid);

	@Query("select ns from NurseSiteBean ns where ns.nursesiteDoublePK.siteid = :siteid")
	List<NurseSiteBean> selectSite(@Param("siteid") Integer siteid);

	@Modifying
	@Query("delete from NurseSiteBean ns where ns.nursesiteDoublePK.siteid = :siteid")
	void deleteAllSite(@Param("siteid") Integer siteid);

	@Modifying
	@Query("delete from NurseSiteBean ns where ns.nursesiteDoublePK.empid = :empid")
	void deleteAllEmp(@Param("empid") Integer empid);

}
