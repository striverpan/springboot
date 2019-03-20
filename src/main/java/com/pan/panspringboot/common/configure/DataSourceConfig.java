package com.pan.panspringboot.common.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(env.getProperty("mysql.jdbc.url"));
        dataSource.setUsername(env.getProperty("mysql.jdbc.username"));
        dataSource.setPassword(env.getProperty("mysql.jdbc.password"));
        dataSource.setDriverClassName(env.getProperty("mysql.jdbc.driverClass"));
        return dataSource;
    }

    /**
     * <p>配置数据源的事务管理</p>
     * @return DataSourceTransactionManager:数据源事务管理实例
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * <p>配置sqlSession工厂类</p>
     * @return SqlSessionFactory:sqlSession工厂类
     * @throws Exception 异常
     */
    @Bean(name = "sqlSessionFactory")
    @Qualifier("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver
                .getResource("classpath:/mybatis-config.xml"));
        sessionFactory.setMapperLocations(resolver
                .getResources("classpath:/com/pan/panspringboot/resposity/*.xml"));
        return sessionFactory.getObject();
    }

    /**
     * <p>配置Spring JDBC工具类</p>
     * @return JdbcTemplate:Spring JDBC工具类
     * @throws Exception 异常
     */
    @Bean(name="jdbcTemplate")
    @Qualifier("jdbcTemplate")
    public JdbcTemplate jdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }


   /* @Bean(name = "hiveDataSource")
    @Qualifier("hiveDataSource")
    public DruidDataSource hiveDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("hive.jdbc.url"));
        dataSource.setUsername(env.getProperty("hive.server2.username"));
        dataSource.setPassword(env.getProperty("hive.server2.password"));
        dataSource.setDriverClassName(env.getProperty("hive.jdbc.driverClass"));
        return dataSource;
    }

    @Bean(name="hiveSqlSessionFactory")
    @Qualifier("hiveSqlSessionFactory")
    public SqlSessionFactory hiveSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hiveDataSource());
        return sessionFactory.getObject();
    }


    @Bean(name = "hiveJdbcTemplate")
    @Qualifier("hiveJdbcTemplate")
    public JdbcTemplate hiveJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(hiveDataSource());
        return jdbcTemplate;
    }*/

}
