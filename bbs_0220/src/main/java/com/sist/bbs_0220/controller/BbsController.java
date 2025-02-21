package com.sist.bbs_0220.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sist.bbs_0220.service.BbsService;
import com.sist.bbs_0220.util.Paging;
import com.sist.bbs_0220.vo.BbsVO;

import jakarta.servlet.ServletContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BbsController {

    @Autowired
    private BbsService bService;

    @Autowired
    private ServletContext application;

    @RequestMapping("list")
    public ModelAndView list(@RequestParam String bname, String searchType,
            String searchValue, String cPage) {
        ModelAndView mv = new ModelAndView();

        int nowPage = 1;
        if(cPage != null)
            nowPage = Integer.parseInt(cPage);

        //bname이 무조건 인자로 넘어와야 한다. 그런데 공백이면 안된다.
        if(bname.trim().length() == 0)
                bname = "BBS";

        //전체게시물의 수
        int totalRecord = bService.getTotalCount(searchType, searchValue, bname);

        //페이징 객체 생성
        Paging page = new Paging(7, 5);
        page.setTotalRecord(totalRecord);
        page.setNowPage(nowPage);

        //뷰페이지에서 표현할 목록을 가져올 때 사용하는 값(begin,end)
        int begin = page.getBegin();
        int end = page.getEnd();

        //목록 가져오기
        BbsVO[] ar = bService.getList(searchType, searchValue, bname, begin, end);
        
        //뷰페이지에서 표현할 정보들을 mv에 저장!
        mv.addObject("ar", ar);
        mv.addObject("page", page);
        mv.addObject("totalRecord", totalRecord);
        mv.addObject("bname", bname);
        mv.addObject("nowPage", nowPage);

        mv.setViewName(bname+"/list");
        return mv;
    }

    @GetMapping("write")
    public String write(@RequestParam String bname, String cPage) {
        


        return bname+"/write";
    }
    
    
}
