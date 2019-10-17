package org.aztec.spring.client.demo2.conf;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@Service
@Scope("singleton")
@DisconfFile(filename = "redis_conf.properties")
public class RedisConfig {

	private String hosts;
	private String sentinelHosts;
	private String ports;
	@DisconfFileItem(name = "redis.masters",associateField = "hosts")
	public String getHosts() {
		return hosts;
	}

	public void setHosts(String hosts) {
		this.hosts = hosts;
	}
	@DisconfFileItem(name = "redis.sentinel.hosts",associateField = "sentinelHosts")
	public String getSentinelHosts() {
		return sentinelHosts;
	}
	public void setSentinelHosts(String sentinelHosts) {
		this.sentinelHosts = sentinelHosts;
	}
	
	@DisconfFileItem(name = "redis.masters.ports",associateField = "ports")
	public String getPorts() {
		return ports;
	}
	public void setPorts(String ports) {
		this.ports = ports;
	}

	@Override
	public String toString() {
		return "RedisConfig [hosts=" + hosts + ", sentinelHosts=" + sentinelHosts + ", ports=" + ports + "]";
	}
	
	
}
