package com.example.unit.test.github.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@MapperScan(basePackages = DataSourceOneConfig.PACKAGE,sqlSessionFactoryRef="sqlSessionFactoryOne")
public class DataSourceOneConfig {

    static final String PACKAGE = "com.example.unit.test.github.mapper";
    static final String MASTER_LOCATION = "classpath:mapper/*.xml";

    @Autowired
    private DruidProperties druidProperties;

    @Value("${datasource.one.driverClassName}")
    private String driverClassName;
    @Value("${datasource.one.url}")
    private String url;
    @Value("${datasource.one.username}")
    private String username;
    @Value("${datasource.one.password}")
    private String password;

    @Bean(name = "dataSourceOne")
    public DataSource dataSourceOne() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setInitialSize(druidProperties.getInitialSize());
        dataSource.setMinIdle(druidProperties.getMinIdle());
        dataSource.setMaxActive(druidProperties.getMaxActive());
        dataSource.setMaxWait(druidProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidProperties.getValidationQuery());
        dataSource.setTestWhileIdle(druidProperties.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(druidProperties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidProperties.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setConnectionProperties(druidProperties.getConnectionProperties());
        dataSource.setUseGlobalDataSourceStat(druidProperties.isUseGlobalDataSourceStat());

        return dataSource;
    }

    @Bean(name = "transactionManagerOne")
    public DataSourceTransactionManager transactionManagerOne() {
        return new DataSourceTransactionManager(dataSourceOne());
    }

    @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceOneConfig.MASTER_LOCATION));
        return sessionFactory.getObject();
    }
}