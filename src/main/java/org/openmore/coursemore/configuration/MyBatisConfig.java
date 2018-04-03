package org.openmore.coursemore.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by michaeltang on 2018/3/22.
 */
@Configuration
public class MyBatisConfig implements EnvironmentAware{
    private Environment env;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DruidDataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.datasource.url"));
        datasource.setUsername(env.getProperty("spring.datasource.username"));
        datasource.setPassword(env.getProperty("spring.datasource.password"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));

        //configuration
        datasource.setInitialSize(Integer.parseInt(env.getProperty("spring.datasource.initialSize")));
        datasource.setMinIdle(Integer.parseInt(env.getProperty("spring.datasource.minIdle")));
        datasource.setMaxActive(Integer.parseInt(env.getProperty("spring.datasource.maxActive")));
        datasource.setMaxWait(Integer.parseInt(env.getProperty("spring.datasource.maxWait")));
        datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
        datasource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("spring.datasource.testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("spring.datasource.testOnBorrow")));
        datasource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("spring.datasource.testOnReturn")));
        datasource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("spring.datasource.poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize")));
        datasource.setUseGlobalDataSourceStat(Boolean.parseBoolean(env.getProperty("spring.datasource.useGlobalDataSourceStat")));
        try {
            datasource.setFilters(env.getProperty("spring.datasource.filters"));
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }
        datasource.setConnectionProperties(env.getProperty("spring.datasource.connectionProperties"));
        return datasource;
    }


//
//    @Bean
//    public ComboPooledDataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("spring.datasource.min-pool-size")));
//        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("spring.datasource.max-pool-size")));
//        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("spring.datasource.max-idle-time")));
//        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        dataSource.setUser(env.getProperty("spring.datasource.username"));
//        try {
//            dataSource.setDriverClass(env.getProperty("spring.datasource.driver"));
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//    @Autowired
//    private DruidDataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setTypeAliasesPackage("org.openmore.coursemore.entity");

        //分页插件
        PageInterceptor iterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        iterceptor.setProperties(properties);
        PageInterceptor[] interceptors = new PageInterceptor[]{iterceptor};
        //添加插件
        bean.setPlugins(interceptors);

//        也可以在mybatis-config.xml里添加插件

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("org.openmore.coursemore.dao");
        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
