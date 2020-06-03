package com.liudehuang.sentinel.cluster.embedded.entity;

import java.util.Set;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ClusterGroupEntity {
    private String machineId;
    private String ip;
    private Integer port;

    private Set<String> clientSet;

    public String getMachineId() {
        return machineId;
    }

    public ClusterGroupEntity setMachineId(String machineId) {
        this.machineId = machineId;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public ClusterGroupEntity setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ClusterGroupEntity setPort(Integer port) {
        this.port = port;
        return this;
    }

    public Set<String> getClientSet() {
        return clientSet;
    }

    public ClusterGroupEntity setClientSet(Set<String> clientSet) {
        this.clientSet = clientSet;
        return this;
    }

    @Override
    public String toString() {
        return "ClusterGroupEntity{" +
                "machineId='" + machineId + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", clientSet=" + clientSet +
                '}';
    }
}
