package com.sist.ex3_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sist.ex3_db.service.ListService;
import com.sist.ex3_db.vo.EmpVO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmpController {

    @Autowired
    private ListService service;

    @RequestMapping("/list")
    public ModelAndView requestMethodName() {

        ModelAndView mv = new ModelAndView();

        EmpVO[] ar = service.getlist();
        mv.addObject("ar", ar);

        mv.setViewName("list");
        return mv;
    }
    
    @RequestMapping("/empSearch")
    public ModelAndView requestMethod(@RequestParam("value") String searchValue,  @RequestParam("type") String searchType) {

        ModelAndView mv = new ModelAndView();

        EmpVO[] ar = service.search(searchType, searchValue);
        mv.addObject("ar", ar);

        mv.setViewName("list");
        return mv;
    }
    



}
