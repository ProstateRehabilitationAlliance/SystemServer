package com.prostate.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 */
@Configuration
@MapperScan(basePackages = "com.prostate.user.mapper.master", sqlSessionTemplateRef  = "writeUserSqlSessionTemplate")
public class WriteUserDataSourceConfiguration {

    @Value("${spring.datasource.writeUser.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.writeUser.url}")
    private String url;

    @Value("${spring.datasource.writeUser.username}")
    private String username;

    @Value("${spring.datasource.writeUser.password}")
    private String password;


    @Bean(name = "writeUserDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

    @Bean(name = "writeUserSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("writeUserDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/user/master/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "writeUserTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("writeUserDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "writeUserSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("writeUserSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}