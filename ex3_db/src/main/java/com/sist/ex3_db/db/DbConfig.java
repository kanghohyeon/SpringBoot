package com.sist.ex3_db.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.sist.ex3_db.mapper")
public class DbConfig {
    // 현재 클래스는 스프링환경이 알아서 호출하며 아래의 @Bean이라는 어노테이션 때문에 
    // 강제로 함수들을 한 번씩 호출하여 스프링환경(context)에 반환되어 객체들을 등록한다

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{

            SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
            // 생성된 팰토리빈은 비어있는 상태 이 때 인자로 받은 ds를 factoryBean에게 지정
            fb.setDataSource(ds);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // 리소스 경로를 찾는 객체

            fb.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/**/*.xml"));
            return fb.getObject();

    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

}
