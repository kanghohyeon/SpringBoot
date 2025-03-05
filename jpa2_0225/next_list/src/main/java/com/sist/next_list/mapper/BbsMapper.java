package com.sist.next_list.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.sist.next_list.vo.BbsVO;

@Mapper // ✅ MyBatis Mapper로 등록
@Repository // ✅ Spring이 관리하는 Bean으로 등록
public interface BbsMapper {
    int totalCount(String searchType, String searchValue, String bname);

    List<BbsVO> list(String searchType, String searchValue, String bname, int begin, int end);

    int add(BbsVO vo);
}
