package com.wsn.restful.service;

import com.wsn.restful.response.*;

import java.util.List;

/**
 * Created by songyangguang on 2018/1/11.
 */
public interface DeviceManage {
    /**
     *添加设备
     * @param url 添加设备访问的url
     * @param accesstoken 许可证号
     * @param deviceSerial 设备的序列号
     * @param validateCode 设备的验证码
     * @return
     */
    BasicResponse<NewDeviceResponse> addDevices(String url,String accesstoken,String deviceSerial,String validateCode);

    /**
     * 删除设备
     * @param url  添加访问路径url
     * @param accesstoken 许可证号
     * @param deviceSerial 设备序列号
     * @return
     */
    BasicResponse<NewDeviceResponse> deleteDevice(String url,String accesstoken,String deviceSerial);

    /**
     * 更改设备名称
     * @param url 访问路径url
     * @param accessToken 许可证号
     * @param deviceSerial 设备序列号
     * @param deviceName 设备名称
     * @return
     */
    BasicResponse<NewDeviceResponse> alterDeviceName(String url,String accessToken,String deviceSerial,String deviceName);

    /**
     * 抓拍设备当前画面
     * @param url
     * @param accessToken
     * @param deviceSerial
     * @return
     */
    BasicResponse<CapturePicture> capturePic(String url,String accessToken,String deviceSerial);

    /**
     * 该接口用于生成设备扫描配网二维码二进制数据，需要自行转换成图片
     * @param url 请求地址
     * @param accessToken 授权过程获取的accessToken
     * @param ssid 路由器SSID，即wifi名称
     * @param password wifi密码
     * @return
     */
    BasicResponse<CodeImageResponse> qrCodeWiFi(String url,String accessToken,String ssid,String password);

    /**
     * 查询用户下基本的信息列表
     * @param url 请求地址
     * @param accessToken 授权过程获取的access_token
     * @param pageStart 分页起始页，从0 开始
     * @param pageSize 分页大小，默认是10，最大是50
     * @return
     */
    BasicResponse<List<DeviceListResponse>> getDeviceList(String url,String accessToken,int pageStart,int pageSize);

    /**
     * 查询用户下指定的设备信息
     * @param url 请求地址
     * @param accessToken 授权过程获取的access_token
     * @param deviceSerial 设备序列号
     * @return
     */
    BasicResponse<SingleDeviceInfoResponse> getOneDevice(String url,String accessToken,String deviceSerial);

    /**
     * 获取监控点列表
     * @param url
     * @param accessToken
     * @param pageStart
     * @param pageSize
     * @return
     */
    BasicResponse<List<CameraListResponse>> getCameraList(String url,String accessToken,int pageStart,int pageSize);

}
