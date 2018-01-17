package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 设备状态信息的返回字段
 * Created by songyangguang on 2018/1/17.
 */
public class DeviceStatusResponse {
    @JsonProperty("privacyStatus")
    public int privacyStatus;//隐私状态: 0：隐私状态关闭；1：隐私状态打开；-1：初始值；2：不支持,C1专用,-2:设备没有上报或者设备不支持该状态
    @JsonProperty("pirStatus")
    public int pirStatus;//红外状态，1：红外启用，0：红外禁用，-1：初始值，2：不支持,-2:设备没有上报或者设备不支持该状态
    @JsonProperty("alarmSoundMode")
    public int alarmSoundMode;//报警声音模式，0：短叫，1：长叫，2：静音,3:自定义语音,-1:设备没有上报或者设备不支持该状态
    @JsonProperty("battryStatus")
    public int battryStatus;//电池电量,1到100(%)，-1:设备没有上报或者设备不支持该状态
    @JsonProperty("lockSignal")
    public int lockSignal;//门锁和网关间的无线信号，百分比表示 差值超过10上报,-1:设备没有上报或者设备不支持该状态
    @JsonProperty("diskNum")
    public int diskNum;//挂载的sd硬盘数量,-1:设备没有上报或者设备不支持该状态
    @JsonProperty("diskState")
    public String diskState;//sd硬盘状态:0:正常;1:存储介质错;2:未格式化;3:正在格式化;返回形式:一个硬盘表示为"0---------------"
                                // ,两个硬盘表示为"00--------------",以此类推;-1:设备没有上报或者设备不支持该状态

    @JsonProperty("cloudType")
    public int cloudType;
    @JsonProperty("cloudStatus")
    public int cloudStatus;//云存储状态: -2:设备不支持;-1: 未开通;0: 未激活;1: 激活;2: 过期
    @JsonProperty("nvrDiskNum")
    public int nvrDiskNum;//NVR上挂载的硬盘数量: -1:设备没有上报或者设备不支持;-2:未关联,类似于NVR类型的上级设备
    @JsonProperty("nvrDiskState")
    public String nvrDiskState;//NVR上挂载的硬盘状态:0:正常;1:存储介质错;2:未格式化;3:正在格式化;返回形式:
                                // 一个硬盘表示为"0---------------",两个硬盘表示为"00--------------",
                                // 以此类推;-1:设备没有上报或者设备不支持该状态;-2:未关联,类似于NVR类型的上机设备

    public int getPrivacyStatus() {
        return privacyStatus;
    }

    public void setPrivacyStatus(int privacyStatus) {
        this.privacyStatus = privacyStatus;
    }

    public int getPirStatus() {
        return pirStatus;
    }

    public void setPirStatus(int pirStatus) {
        this.pirStatus = pirStatus;
    }

    public int getAlarmSoundMode() {
        return alarmSoundMode;
    }

    public void setAlarmSoundMode(int alarmSoundMode) {
        this.alarmSoundMode = alarmSoundMode;
    }

    public int getBattryStatus() {
        return battryStatus;
    }

    public void setBattryStatus(int battryStatus) {
        this.battryStatus = battryStatus;
    }

    public int getLockSignal() {
        return lockSignal;
    }

    public void setLockSignal(int lockSignal) {
        this.lockSignal = lockSignal;
    }

    public int getDiskNum() {
        return diskNum;
    }

    public void setDiskNum(int diskNum) {
        this.diskNum = diskNum;
    }

    public String getDiskState() {
        return diskState;
    }

    public void setDiskState(String diskState) {
        this.diskState = diskState;
    }

    public int getCloudType() {
        return cloudType;
    }

    public void setCloudType(int cloudType) {
        this.cloudType = cloudType;
    }

    public int getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(int cloudStatus) {
        this.cloudStatus = cloudStatus;
    }

    public int getNvrDiskNum() {
        return nvrDiskNum;
    }

    public void setNvrDiskNum(int nvrDiskNum) {
        this.nvrDiskNum = nvrDiskNum;
    }

    public String getNvrDiskState() {
        return nvrDiskState;
    }

    public void setNvrDiskState(String nvrDiskState) {
        this.nvrDiskState = nvrDiskState;
    }
}
