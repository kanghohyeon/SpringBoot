package com.sist.jpa2_0225.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.jpa2_0225.repository.EmpRepository;
import com.sist.jpa2_0225.store.Emp;

@Service
public class EmpService {


    @Autowired
    private EmpRepository empRepository;


    public Emp[] sal(Long sal){
        Emp[] ar = null;

        List<Emp> list = empRepository.findBySalLessThan(sal); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능
        
        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        System.out.println(ar.length+"list.size()");
        return ar;
    }




    public Emp[] getAll(){
        Emp[] ar = null;

        List<Emp> list = empRepository.findAll(); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능
        
        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        System.out.println(ar.length+"list.size()");
        return ar;
    }

    public Emp[] getName(String ename){
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEname(ename); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능

        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

    public Emp[] getName2(String ename){
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEnameContaining(ename); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능

        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

    public Emp[] getName3(String ename){
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEnameLike("%"+ename+"%"); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능

        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

    public Emp[] searchJobDept(String job, String dept){
        Emp[] ar = null;

        List<Emp> list = empRepository.findByJobContainsAndDeptno(job,dept); // 명시하지 않아도 내장되어있음 JpaRepository를 상속받았기 때문에 가능

        if(list != null && list.size() > 0){
            ar = new Emp[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

}
