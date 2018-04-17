package com.kakarot.plcenter.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class JedisFactory implements FactoryBean<JedisCluster>, InitializingBean {

    private JedisCluster jedisCluster;

    @Value("${redisNodes}")
    private String redisNodes;

    @Value("${redisPassword}")
    private String redisPassword;

    private Integer timeout;
    private Integer maxRedirections;
    private GenericObjectPoolConfig genericObjectPoolConfig;

    private Pattern patten = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

    @Override
    public JedisCluster getObject() throws Exception {
        return jedisCluster;
    }

    @Override
    public Class<?> getObjectType() {
        return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private Set<HostAndPort> parseHostAndPort() throws Exception {
        try {

            if(StringUtils.isEmpty(redisNodes)){
                throw new RuntimeException("redis集群配置错误");
            }
            String[] nodes = redisNodes.split(",");

            Set<HostAndPort> haps = new HashSet<HostAndPort>();
            for (String node : nodes) {
                boolean isIpPort = patten.matcher(node).matches();
                if (!isIpPort) {
                    throw new IllegalArgumentException("ip 或 port 不合法");
                }
                String[] ipAndPort = node.split(":");
                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                haps.add(hap);
            }

            return haps;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new Exception("解析 jedis 配置文件失败", ex);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set<HostAndPort> haps = this.parseHostAndPort();

        if (StringUtils.isEmpty(redisPassword)) {
            jedisCluster = new JedisCluster(haps, timeout, maxRedirections,genericObjectPoolConfig);
        } else {
            jedisCluster = new JedisCluster(haps, timeout,timeout, maxRedirections,redisPassword,genericObjectPoolConfig);
        }
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxRedirections() {
        return maxRedirections;
    }

    public void setMaxRedirections(Integer maxRedirections) {
        this.maxRedirections = maxRedirections;
    }

    public GenericObjectPoolConfig getGenericObjectPoolConfig() {
        return genericObjectPoolConfig;
    }

    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
        this.genericObjectPoolConfig = genericObjectPoolConfig;
    }
}
