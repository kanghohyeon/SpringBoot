package com.sist.secure_0224.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.sist.secure_0224.mapper.MemberMapper;
import com.sist.secure_0224.vo.MemVO;

@Service
public class MemberService {

    @Autowired
    private MemberMapper m_Mapper;

    
    @Autowired
    private PasswordEncoder passwordEncoder;



    // 회원등록 함수
    
    public int regMember(MemVO vo){
        // 비밀번호 암호화
        vo.setM_pw(passwordEncoder.encode(vo.getM_pw()));
        return m_Mapper.reg(vo);
    } 
 
    public MemVO login(MemVO vo){
        // db로부터 mv에 있는 m_id를 보내어 해당 MemVO를 받아서 반환받는다
        // 이떄 비밀번호가 일치하는지는 passwordEncoder.matches()를 이용하여 확인한다.
        ModelAndView mv = new ModelAndView();
        MemVO mvo = m_Mapper.login(vo.getM_id());
        // 사용자가 입력한 아이디가 잘못 되었다면 mvo에는 널값이 찍힌다
        if(mvo != null){
            // 사용자가 입력한 비밀번호와 db에 저장된 비밀번호가 일치한다면
            if(passwordEncoder.matches(vo.getM_pw(), mvo.getM_pw())){ //순서유의의
                mv.addObject("mvo", mvo);
                return mvo;
            }

            //mvo가 null 이거나 비밀번호가 일치하지 않을 경우
            
        }
        return null;
    }
}
