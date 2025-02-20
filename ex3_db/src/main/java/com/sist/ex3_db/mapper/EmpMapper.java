package com.sist.ex3_db.mapper;

import java.util.List;
import java.util.Map;

import com.sist.ex3_db.vo.EmpVO;

public interface EmpMapper {
    // sql문을 가진 매퍼파일과 연동된다
    // 여기에 정의하는 함수들은 emp.xml에 존재하는 id명과 일치
    List<EmpVO> list();
    List<EmpVO> searchEmp(Map<String, Object> params);

}
