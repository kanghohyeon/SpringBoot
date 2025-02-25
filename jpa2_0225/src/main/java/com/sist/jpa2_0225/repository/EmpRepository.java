package com.sist.jpa2_0225.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.jpa2_0225.store.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, String> {
    //상속받은 findAll, findById, save, delete 등을 사용할 수 있음
   List<Emp> findByEname(String ename);
   List<Emp> findByEnameContaining(String ename);// like concat '%ename%'
   List<Emp> findByEnameLike(String ename);// like concat '%ename%'
   List<Emp> findByJobContainsAndDeptno(String job, String dept);

   List<Emp> findBySalLessThan(Long sal); // 1000 미만만
   List<Emp> findBySalLessThanEqual(Long sal); // 1000 이하만
   List<Emp> findBySalGreaterThan(Long sal); // 1000 초과만
   List<Emp> findBySalGreaterThanEqual(Long sal); // 1000 이상만
}
