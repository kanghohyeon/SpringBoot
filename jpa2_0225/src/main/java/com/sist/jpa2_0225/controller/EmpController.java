package com.sist.jpa2_0225.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sist.jpa2_0225.service.EmpService;
import com.sist.jpa2_0225.store.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class EmpController {




    @Autowired
    private EmpService empService;

    @GetMapping("all")
    public String getAll() {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.getAll();

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
        return sb.toString();
    }

    @GetMapping("searchName")
    public String searchName(@RequestParam String ename) {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.getName(ename);

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
            return sb.toString();
    }

    @GetMapping("searchName2")
    public String searchName2(@RequestParam String ename) {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.getName2(ename);

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
            return sb.toString();
    }

    @GetMapping("searchName3")
    public String searchName3(@RequestParam String ename) {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.getName3(ename);

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
            return sb.toString();
    }


    @GetMapping("findByJobContainsAndDeptno")
    public String findByJobContainsAndDeptno(@RequestParam String job, @RequestParam String dept) {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.searchJobDept(job, dept);

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
            return sb.toString();
    }

    @GetMapping("sal")
    public String findByJobContainsAndDeptno(@RequestParam Long sal) {

        StringBuffer sb= new StringBuffer();
        Emp[] ar = empService.sal(sal);

            for(Emp emp : ar){
                sb.append(emp.getEmpno());
                sb.append("/");
                sb.append(emp.getEname());
                sb.append("<br/>");
            }
            return sb.toString();
    }
}

