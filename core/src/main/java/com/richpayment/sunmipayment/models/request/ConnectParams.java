package com.richpayment.sunmipayment.models.request;

public class ConnectParams {

    private ConnectType connectType = ConnectType.ON_DEVICE;
    private String packageName = "com.sunmi.tsys.sierra";
    private ConnectRole type = ConnectRole.MASTER;
    private String wifiAddress;
    private Integer wifiPort;
    private Integer baudRate;
    private Integer dataBits;
    private String parity;
    private Integer stopBits;

    public ConnectParams() {
    }

    public ConnectParams(ConnectType connectType) {
        this.connectType = connectType;
    }

    public ConnectParams(ConnectType connectType, String wifiAddress) {
        this.connectType = connectType;
        this.wifiAddress = wifiAddress;
    }

    public ConnectType getConnectType() {
        return connectType;
    }

    public void setConnectType(ConnectType connectType) {
        this.connectType = connectType != null ? connectType : ConnectType.ON_DEVICE;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ConnectRole getType() {
        return type;
    }

    public void setType(ConnectRole type) {
        this.type = type != null ? type : ConnectRole.MASTER;
    }

    public String getWifiAddress() {
        return wifiAddress;
    }

    public void setWifiAddress(String wifiAddress) {
        this.wifiAddress = wifiAddress;
    }

    public Integer getWifiPort() {
        return wifiPort;
    }

    public void setWifiPort(Integer wifiPort) {
        this.wifiPort = wifiPort;
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public Integer getDataBits() {
        return dataBits;
    }

    public void setDataBits(Integer dataBits) {
        this.dataBits = dataBits;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity;
    }

    public Integer getStopBits() {
        return stopBits;
    }

    public void setStopBits(Integer stopBits) {
        this.stopBits = stopBits;
    }

    public String getIpAddress() {
        return wifiAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.wifiAddress = ipAddress;
    }

    public Integer getPort() {
        return wifiPort;
    }

    public void setPort(Integer port) {
        this.wifiPort = port;
    }
}
