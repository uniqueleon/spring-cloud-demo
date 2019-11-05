package org.aztec.spring.client.demo2.conf;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@org.springframework.context.annotation.Configuration
@MapperScan(sqlSessionFactoryRef="sessionFactory"
,sqlSessionTemplateRef="sqlTempl"
,basePackages="org.aztec.spring.client.demo2.mapper")
public class IbatisSessionFactory {
	

	@Bean(name="sessionFactory")
	public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) {
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		//configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		//SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//builder.
		return sqlSessionFactory;
	}
	
	 @Bean(name = "sqlTempl")
	    @Primary
	    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
}
