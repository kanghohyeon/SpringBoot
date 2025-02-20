package com.sist.ex3_db.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.ex3_db.mapper.EmpMapper;
import com.sist.ex3_db.vo.EmpVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ListService {

    // 필요한 매퍼 지정

    private final  EmpMapper mapper;


    public EmpVO[] search(String searchType, String searchValue){
        EmpVO[] ar=null;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", searchType);
        map.put("value", searchValue);

        System.out.println("type"+ searchType);
        System.out.println("value"+ searchValue);
        List<EmpVO> list = mapper.searchEmp(map);
        System.out.println("getlist"+list.size());
        if(list!=null && ! list.isEmpty()){
            ar = new EmpVO[list.size()];
            list.toArray(ar);
        }


        return ar;
    }

    //컨트롤러(요청)에서 호출하는 메서드 정의
    public EmpVO[] getlist(){
        EmpVO[] ar = null;
  
        List<EmpVO> list = mapper.list();
        
    
        if (list!=null && !list.isEmpty()) {
            //리스트가 비어있지 않을때만 배열 생성
            ar = new EmpVO[list.size()];
            list.toArray(ar);

        }

        return ar;
    }



}
