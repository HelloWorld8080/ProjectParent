package com.liuxun.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author liuxun
 * @create 2023-07-07 23:26
 * @description
 */

@Configuration
@MapperScan(basePackages = "com.liuxun.order.mapper.ordermapper")
//@MapperScan(basePackages = "com.liuxun.service1.mapper.rbdamapper", sqlSessionFactoryRef="myRbdaSqlSessionFactory")
//@MapperScan(basePackages = "com.liuxun.service1.mapper.productmapper", sqlSessionFactoryRef="productSqlSessionFactory")
@ComponentScan("com.liuxun.util.snowflake")
@ComponentScan("com.liuxun.util.redis")
public class OrderConfig {
    @Bean
    public ScheduledThreadPoolExecutor executor(){
        return new ScheduledThreadPoolExecutor(5);
    }
//    @Bean
//    public Snowflake generateSnowflake(){
//        return new Snowflake(1,1);
//    }


    //配置多个数据库
//    private Logger logger = LoggerFactory.getLogger(MasterDbConfig.class);
    // 精确到 master 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.xbz.**.dao.master";
//    private static final String MAPPER_LOCATION = "classpath*:mapper/master/*.xml";
//    private static final String DOMAIN_PACKAGE = "com.xbz.**.domain";

//    @Value("#{'${test.list}'.split('.')}")

//    @Autowired
//    private DynamicDS dynamicDS;

//    @Resource
//    private DataSourceTransactionManager dataSourceTransactionManager;

//    @Value("${mybatis-plus.mapper-locations}")
//    private String MAPPER_LOCATION;
//
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;


//    @Bean(name="masterDataSource")   //声明其为Bean实例
//    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
//    public DataSource masterDataSource() {
//
////        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
////        //可以加载多个yml文件
////        yamlMapFactoryBean.setResources(new ClassPathResource("datasource.yml"));
////        //通过getObject()方法获取Map对象
////        Map<String, Object> map = yamlMapFactoryBean.getObject();
//////        System.out.println(map);
////        map.keySet().forEach(item -> {
////            //可以将map中的值强转为LinkedHashMap对象
////            LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>) (map.get(item));
////            System.out.println(linkedHashMap.get("tels"));
////        });
//
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//        return datasource;
//    }


//    @Bean(name="myDataSources")   //声明其为Bean实例
//    public List<DataSource> myDataSources() {
//        List<DataSource> datasources=new ArrayList<>();
//        List<DynamicDS.DataSourceConfig> dataSourceConfigs=dynamicDS.getDatasources();
//        for (int i = 0; i < dataSourceConfigs.size(); i++) {
//            DruidDataSource datasource = new DruidDataSource();
//            DynamicDS.DataSourceConfig dataSourceConfig=dataSourceConfigs.get(i);
//            datasource.setUrl(dataSourceConfig.getUrl());
//            datasource.setUsername(dataSourceConfig.getUsername());
//            datasource.setPassword(dataSourceConfig.getPassword());
//            datasource.setDriverClassName(dataSourceConfig.getDriverClassName());
//            datasources.add(datasource);
//        }
//        return datasources;
//    }

//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager masterTransactionManager() {
//        return new DataSourceTransactionManager(masterDataSource());
//    }
//
//    @Bean(name = "masterSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
//            throws Exception {
//        final MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
//        sessionFactory.setDataSource(masterDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(MAPPER_LOCATION));
////        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
//        //mybatis 数据库字段与实体类属性驼峰映射配置
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sessionFactory.getObject();
//    }

//    @Bean(name="myRbda")   //声明其为Bean实例
//    public DataSource rbdaDataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(this.dynamicDS.getRbda().getUrl());
//        datasource.setUsername(this.dynamicDS.getRbda().getUsername());
//        datasource.setPassword(this.dynamicDS.getRbda().getPassword());
//        datasource.setDriverClassName(this.dynamicDS.getRbda().getDriverClassName());
//        return datasource;
//    }

//    @Bean(name = "myRbdaSqlSessionFactory")
//    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("myRbda") DataSource slaveDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(slaveDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:com/liuxun/service1/mapper/rbdamapper/xml/*.xml"));
//        //mybatis 数据库字段与实体类属性驼峰映射配置
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sessionFactory.getObject();
//    }

//    @Bean(name="product")   //声明其为Bean实例
//    public DataSource productDataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(this.dynamicDS.getProduct().getUrl());
//        datasource.setUsername(this.dynamicDS.getProduct().getUsername());
//        datasource.setPassword(this.dynamicDS.getProduct().getPassword());
//        datasource.setDriverClassName(this.dynamicDS.getProduct().getDriverClassName());
//        return datasource;
//    }

//    @Bean(name = "productSqlSessionFactory")
//    public SqlSessionFactory productSqlSessionFactory(@Qualifier("product") DataSource productDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(productDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:com/liuxun/service1/mapper/productmapper/xml/*.xml"));
//        //mybatis 数据库字段与实体类属性驼峰映射配置
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sessionFactory.getObject();
//    }

    //配置第二个数据源

//    @Bean(name="slaveDataSource")   //声明其为Bean实例
//    public DataSource slaveDataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setUrl("jdbc:mysql://192.168.38.162:3306/service2?serverTimezone=GMT%2B8&useSSL=false");
//        datasource.setUsername("root");
//        datasource.setPassword("123456");
//        datasource.setDriverClassName("com.mysql.jdbc.Driver");
//        return datasource;
//    }

//    @Bean(name = "slaveTransactionManager")
//    public DataSourceTransactionManager slaveTransactionManager() {
//        return new DataSourceTransactionManager(slaveDataSource());
//    }

//    @Bean(name = "slaveSqlSessionFactory")
//    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(slaveDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:com/liuxun/service1/mapper2/xml/*.xml"));
////        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
//        //mybatis 数据库字段与实体类属性驼峰映射配置
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sessionFactory.getObject();
//    }
}
