package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by songyangguang on 2018/1/16.
 */
public class DeviceListResponse {
    @JsonProperty("deviceSerial")
    public String deviceSerial;//设备序列号
    @JsonProperty("deviceName")
    public String deviceName;//设备名称
    @JsonProperty("deviceType")
    public String deviceType;//设备类型
    @JsonProperty("status")
    public int status;//在线状态：0-不在线，1-在线
    @JsonProperty("defence")
    public int defence;//具体防护能力的设备 布防状态：0-睡眠，8-在家，16-外出，普通IPC布防状态：0-撤防 1-布防
    @JsonProperty("deviceVersion")
    public int deviceVersion;//设备版本号

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(int deviceVersion) {
        this.deviceVersion = deviceVersion;
    }
}
