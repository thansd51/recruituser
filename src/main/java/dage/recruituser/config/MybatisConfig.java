package dage.recruituser.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "dage.recruituser", annotationClass = org.springframework.stereotype.Repository.class)
public class MybatisConfig {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://210.206.179.191:3306/recruit?useUnicode=yes&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Seoul");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("dage5500");

        return dataSourceBuilder.build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml"));
        factoryBean.setTypeAliasesPackage("dage.recruituser");
        return factoryBean.getObject();
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
