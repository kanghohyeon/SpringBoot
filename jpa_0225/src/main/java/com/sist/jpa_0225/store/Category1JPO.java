package com.sist.jpa_0225.store;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "category1_t")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category1JPO {
    @Id
    @GeneratedValue
    private long cIdx;// c_idx
    private String cName; // c_name
    private String cDesc; // c_desc
    private int status;

    @OneToMany //OneToMany는 현재 객체가 1이고 연결테이블에서는
                //여러개가 있다는 뜻이므로 현재 테이블에서 1개만 존재하는
                //것을 구별하는 것은 기본키다. 즉 cidx가 one이고
                //연결되는 테이블에는 여러 개가 참조되는 컬럼이 
                //category1이 되어야 한다.
    @JoinColumn(name = "category1")
    List<ProductJPO> list;
}
