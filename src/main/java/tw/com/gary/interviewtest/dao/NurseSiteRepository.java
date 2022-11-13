package tw.com.gary.interviewtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.domain.NurseSiteDoublePK;

public interface NurseSiteRepository extends JpaRepository<NurseSiteBean, NurseSiteDoublePK> {

}
