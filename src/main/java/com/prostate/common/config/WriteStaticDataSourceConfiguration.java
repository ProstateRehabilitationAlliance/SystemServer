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
@MapperScan(basePackages = "com.prostate.record.mapper.base.write", sqlSessionTemplateRef  = "writePraSqlSessionTemplate")
public class WriteStaticDataSourceConfiguration {

    @Value("${spring.datasource.writeStatic.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.writeStatic.url}")
    private String url;

    @Value("${spring.datasource.writeStatic.username}")
    private String username;

    @Value("${spring.datasource.writeStatic.password}")
    private String password;


    @Bean(name = "writePraDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

    @Bean(name = "writePraSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("writePraDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/pra/write/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "writePraTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("writePraDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "writePraSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("writePraSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}