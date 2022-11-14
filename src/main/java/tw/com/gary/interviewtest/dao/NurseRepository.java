package tw.com.gary.interviewtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.gary.interviewtest.domain.NurseBean;

public interface NurseRepository extends JpaRepository<NurseBean, Integer> {

}
