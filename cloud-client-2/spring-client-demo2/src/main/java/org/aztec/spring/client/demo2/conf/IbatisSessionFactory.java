package org.aztec.spring.client.demo2.conf;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.context.annotation.Configuration
@MapperScan(sqlSessionFactoryRef="sessionFactory"
,basePackages="org.aztec.spring.client.demo2")
public class IbatisSessionFactory {
	
	@Autowired
	DataSource dataSource;

	public SqlSessionFactory sessionFactory() {
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		//configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		//SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//builder.
		return sqlSessionFactory;
	}
	
	
}
