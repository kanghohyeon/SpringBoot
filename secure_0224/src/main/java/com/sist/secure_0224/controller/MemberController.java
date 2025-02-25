package com.sist.secure_0224.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sist.secure_0224.service.MemberService;
import com.sist.secure_0224.vo.MemVO;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
public class MemberController {



    @Autowired
    private MemberService m_service;

    // 로그인 검증을 위한 세션
    @Autowired
    private HttpSession session;

    @PostMapping("reqLogin")
    public ModelAndView login(MemVO vo) {
        ModelAndView mv = new ModelAndView();
        MemVO mvo = m_service.login(vo);
        if(mvo != null){ //mvo가 null이면 아이디 또는 비밀번호가 틀린경우
            session.setAttribute("mvo", mvo);
        }else{
            mv.addObject("status", "1");
        }
        mv.setViewName("redirect:/");
       
        return mv;
    }
    

    @RequestMapping("login")
    public ModelAndView requestMethodName() {
        return new ModelAndView("login");
    }
    

    @PostMapping("reg")
    public ModelAndView postMethodName(MemVO vo) {
        //TODO: process POST request
        m_service.regMember(vo);
        
        ModelAndView mv = index();
        return mv;
    }
    

    @RequestMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("reg")
    public ModelAndView reg() {
        ModelAndView mv = new ModelAndView("reg");
       

        return mv;
    }
    
    
}
