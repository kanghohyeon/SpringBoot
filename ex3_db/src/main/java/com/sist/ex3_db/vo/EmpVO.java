package com.sist.ex3_db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// 데이터 어노테이션은 둘 다 한방에 되지만 스프링 환경에는 따로 명시하는 것이 좋다.
public class EmpVO {
    private String empno, ename, job, deptno;


}
