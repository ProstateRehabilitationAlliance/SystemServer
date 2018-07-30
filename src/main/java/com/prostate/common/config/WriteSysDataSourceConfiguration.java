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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 写操作 数据源
 */
@Configuration
@MapperScan(basePackages = "com.prostate.system.mapper.write", sqlSessionTemplateRef  = "writeSysSqlSessionTemplate")
public class WriteSysDataSourceConfiguration {

    @Value("${spring.datasource.writeSys.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.writeSys.url}")
    private String url;

    @Value("${spring.datasource.writeSys.username}")
    private String username;

    @Value("${spring.datasource.writeSys.password}")
    private String password;

    @Bean(name = "writeSysDataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

    @Bean(name = "writeSysSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("writeSysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/system/write/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "writeSysTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("writeSysDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "writeSysSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("writeSysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}