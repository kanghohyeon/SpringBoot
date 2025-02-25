package com.sist.jpa2_0225.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Emp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    @Id
    @Column(name = "empno") // 시스템 내부적으로 좋은 효율율
    private String empno;

    @Column(name = "ename")
    private String ename;

    @Column(name = "job")
    private String job;

    @Column(name = "sal")
    private long sal;

    @Column(name = "deptno")
    private String deptno;

}
