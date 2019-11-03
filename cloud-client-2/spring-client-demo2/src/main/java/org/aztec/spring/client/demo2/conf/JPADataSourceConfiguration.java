package org.aztec.spring.client.demo2.conf;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.aztec.spring.client.demo2.conf.sharding_jdbc.Constants;
import org.aztec.spring.client.demo2.conf.sharding_jdbc.DataSourceConfig;
import org.aztec.spring.client.demo2.conf.sharding_jdbc.TableRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.google.common.collect.Lists;

import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.InlineShardingStrategyConfiguration;

@Configuration
/*@EnableJpaRepositories(
		basePackages = {"org.aztec.spring.client.demo2.dao"},
		
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef =  "transactionManager")*/
public class JPADataSourceConfiguration {

	@Autowired
	private DataSourceConfig dsConfig;
	@Autowired
	private TableRules rules;

	private Map<String, DataSource> createDataSource() {
		Map<String, DataSource> dataSourceMap = new HashMap<>();
		List<DataSourceInfo> dsInfos = getDataSourceInfo();
		for (int i = 0; i < dsInfos.size(); i++) {

			BasicDataSource dataSource1 = new BasicDataSource();
			DataSourceInfo dsi = dsInfos.get(i);
			dataSource1.setDriverClassName(dsi.getDriver());
			dataSource1.setUrl(dsi.getUrl());
			dataSource1.setUsername(dsi.getUser());
			dataSource1.setPassword(dsi.getPassword());
			dataSourceMap.put(dsi.getName(), dataSource1);
		}
		return dataSourceMap;
	}

	private ShardingRuleConfiguration getRuleConfiguration() {

		//
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		List<TableRuleInfo> ruleInfo = getRules();
		for (int i = 0; i < ruleInfo.size(); i++) {
			TableRuleInfo rule = ruleInfo.get(i);
			TableRuleConfiguration tableRuleConfig = new TableRuleConfiguration();
			tableRuleConfig.setLogicTable(rule.getName());
			tableRuleConfig.setDatabaseShardingStrategyConfig(
					new InlineShardingStrategyConfiguration(rule.getPrimaryKey(), rule.getDbRule()));
			tableRuleConfig.setTableShardingStrategyConfig(
					new InlineShardingStrategyConfiguration(rule.getPrimaryKey(), rule.getTableRule()));
			shardingRuleConfig.getTableRuleConfigs().add(tableRuleConfig);
		}
		return shardingRuleConfig;
	}

	@Bean
	public DataSource getShardingJdbcDataSource() throws SQLException {

		System.out.println("init datasource:" + dsConfig.getConnectionUrls());
		Map<String, DataSource> dataSourceMap = createDataSource();

		// 配置第一个数据源
		DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, getRuleConfiguration(),
				new HashMap<String, Object>(), new Properties());
		return dataSource;
	}
	
	 @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("org.aztec.spring.client.demo2.entity");
	    factory.setDataSource(getShardingJdbcDataSource());
	    return factory;
	  }
	 

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
	

	public List<TableRuleInfo> getRules(){
		String[] names = rules.getTables().split(Constants.DEFAULT_SEPERATOR);
		String[] tRules = rules.getTableRules().split(Constants.DEFAULT_SEPERATOR);

		String[] dbRules = rules.getDatabaseRules().split(Constants.DEFAULT_SEPERATOR);
		String[] pks = rules.getPrimaryKeys().split(Constants.DEFAULT_SEPERATOR);
		List<TableRuleInfo> ds = Lists.newArrayList();
		for(int i = 0;i < names.length;i++) {
			ds.add(new TableRuleInfo(names[i], dbRules[i],tRules[i], pks[i]));
		}
		return ds;
	}
	
	public static class TableRuleInfo{
		private String name;
		private String dbRule;
		private String tableRule;
		private String primaryKey;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDbRule() {
			return dbRule;
		}
		public void setDbRule(String dbRule) {
			this.dbRule = dbRule;
		}
		public String getTableRule() {
			return tableRule;
		}
		public void setTableRule(String tableRule) {
			this.tableRule = tableRule;
		}
		public String getPrimaryKey() {
			return primaryKey;
		}
		public void setPrimaryKey(String primaryKey) {
			this.primaryKey = primaryKey;
		}
		public TableRuleInfo(String name, String dbRule, String tableRule, String primaryKey) {
			super();
			this.name = name;
			this.dbRule = dbRule;
			this.tableRule = tableRule;
			this.primaryKey = primaryKey;
		}
		
	}
	

	public List<DataSourceInfo> getDataSourceInfo(){
		String[] names = dsConfig.getDataSources().split(Constants.DEFAULT_SEPERATOR);
		String[] urls = dsConfig.getConnectionUrls().split(Constants.DEFAULT_SEPERATOR);

		String[] users = dsConfig.getUserNames().split(Constants.DEFAULT_SEPERATOR);
		String[] pwds = dsConfig.getPasswords().split(Constants.DEFAULT_SEPERATOR);
		String driver = "com.mysql.jdbc.Driver";
		List<DataSourceInfo> ds = Lists.newArrayList();
		for(int i = 0;i < names.length;i++) {
			ds.add(new DataSourceInfo(names[i], urls[i], driver, users[i], pwds[i]));
		}
		return ds;
	}
	
	public static class DataSourceInfo{
		
		private String name;
		private String url;
		private String driver;
		private String user;
		private String password;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getDriver() {
			return driver;
		}
		public void setDriver(String driver) {
			this.driver = driver;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public DataSourceInfo(String name, String url, String driver, String user, String password) {
			super();
			this.name = name;
			this.url = url;
			this.driver = driver;
			this.user = user;
			this.password = password;
		}
		
		
		
	}
	
}
