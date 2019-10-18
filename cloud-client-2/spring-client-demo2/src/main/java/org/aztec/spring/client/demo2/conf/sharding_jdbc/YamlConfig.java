package org.aztec.spring.client.demo2.conf.sharding_jdbc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class YamlConfig {

	
	private String content;

	//@DisconfItem(key="sharding_jdbc.yaml.config")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
