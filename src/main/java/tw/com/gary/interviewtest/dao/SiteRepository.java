package tw.com.gary.interviewtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.gary.interviewtest.domain.SiteBean;

public interface SiteRepository extends JpaRepository<SiteBean, Integer> {

}
