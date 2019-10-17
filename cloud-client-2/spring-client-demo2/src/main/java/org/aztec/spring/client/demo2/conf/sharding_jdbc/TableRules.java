package org.aztec.spring.client.demo2.conf.sharding_jdbc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@Service
@Scope("singleton")
@DisconfFile(filename = "sharding_jdbc_table_rules.properties")
public class TableRules {

	
	private String tables;
	
	private String primaryKeys;
	
	private String databaseRules;
	
	private String tableRules;


	@DisconfFileItem(name = "tables",associateField = "tables")
	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}


	@DisconfFileItem(name = "db.rules",associateField = "databaseRules")
	public String getDatabaseRules() {
		return databaseRules;
	}

	public void setDatabaseRules(String databaseRules) {
		this.databaseRules = databaseRules;
	}


	@DisconfFileItem(name = "table.rules",associateField = "tableRules")
	public String getTableRules() {
		return tableRules;
	}

	public void setTableRules(String tableRules) {
		this.tableRules = tableRules;
	}


	@DisconfFileItem(name = "table.pks",associateField = "primaryKeys")
	public String getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(String primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
	
}
