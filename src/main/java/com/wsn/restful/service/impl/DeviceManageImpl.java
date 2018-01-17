package com.wsn.restful.service.impl;

import com.wsn.restful.api.device.*;
import com.wsn.restful.response.*;
import com.wsn.restful.service.DeviceManage;

import java.util.List;

/**
 * 设备的管理
 * Created by songyangguang on 2018/1/11.
 */
public class DeviceManageImpl implements DeviceManage {
    /**
     * 添加设备
     * @param url 添加设备访问的url
     * @param accesstoken 许可证号
     * @param deviceSerial 设备的序列号
     * @param validateCode 设备的验证码
     * @return
     */
    @Override
    public BasicResponse<NewDeviceResponse> addDevices(String url, String accesstoken, String deviceSerial, String validateCode) {
        AddDeviceApi addDeviceApi = new AddDeviceApi(url,accesstoken,deviceSerial,validateCode);
        BasicResponse<NewDeviceResponse> response = addDeviceApi.executeApi();
        return response;
    }

    /**
     * 删除设备
     * @param url  添加访问路径url
     * @param accesstoken 许可证号
     * @param deviceSerial 设备序列号
     * @return
     */
    @Override
    public BasicResponse<NewDeviceResponse> deleteDevice(String url, String accesstoken, String deviceSerial) {
        DeleteDeviceApi deleteDeviceApi = new DeleteDeviceApi(url,accesstoken,deviceSerial);
        BasicResponse<NewDeviceResponse> response = deleteDeviceApi.executeApi();
        return response;
    }

    /**
     * 更改设备名称
     * @param url 访问路径url
     * @param accessToken 许可证号
     * @param deviceSerial 设备序列号
     * @param deviceName 设备名称
     * @return
     */
    @Override
    public BasicResponse<NewDeviceResponse> alterDeviceName(String url, String accessToken, String deviceSerial, String deviceName) {
        AlterDeviceNameApi alterDeviceNameApi = new AlterDeviceNameApi(url,accessToken,deviceSerial,deviceName);
        BasicResponse<NewDeviceResponse> response = alterDeviceNameApi.executeApi();
        return response;
    }

    /**
     * 抓拍设备当前画面
     * @param url
     * @param accessToken
     * @param deviceSerial
     * @return
     */
    @Override
    public BasicResponse<CapturePicture> capturePic(String url, String accessToken, String deviceSerial) {

        CapturePicApi capturePicApi = new CapturePicApi(url,accessToken,deviceSerial);
        BasicResponse<CapturePicture> response = capturePicApi.executeApi();
        return response;
    }

    /**
     * 该接口用于生成设备扫描配网二维码二进制数据，需要自行转换成图片
     * @param url 请求地址
     * @param accessToken 授权过程获取的accessToken
     * @param ssid 路由器SSID，即wifi名称
     * @param password wifi密码
     * @return
     *
     * 注：如果要将string类型的二维码信息转化成图片，可调用com.wsn.restful.util.QRCodeToImage类
     *    中的Base64StringToImage方法，生成一个可扫描的二维码图片
     */
    @Override
    public BasicResponse<CodeImageResponse> qrCodeWiFi(String url, String accessToken, String ssid, String password) {

        QrcodeWiFiApi qrcodeWiFiApi = new QrcodeWiFiApi(url,accessToken,ssid,password);
        BasicResponse<CodeImageResponse> response = qrcodeWiFiApi.executeApi();

        return response;
    }
    /**
     * 查询用户下基本的信息列表
     * @param url 请求地址
     * @param accessToken 授权过程获取的access_token
     * @param pageStart 分页起始页，从0 开始
     * @param pageSize 分页大小，默认是10，最大是50
     * @return
     */
    @Override
    public BasicResponse<List<DeviceListResponse>> getDeviceList(String url, String accessToken, int pageStart, int pageSize) {

        GetDeviceListApi getDeviceListApi = new GetDeviceListApi(url,accessToken,pageStart,pageSize);
        BasicResponse<List<DeviceListResponse>> response = getDeviceListApi.executeApi();
        return response;
    }

    /**
     * 查询用户下指定的设备信息
     *
     * @param url          请求地址
     * @param accessToken  授权过程获取的access_token
     * @param deviceSerial 设备序列号
     * @return
     */
    @Override
    public BasicResponse<SingleDeviceInfoResponse> getOneDevice(String url, String accessToken, String deviceSerial) {

        GetOneDeviceInfoApi getOneDeviceInfoApi = new GetOneDeviceInfoApi(url,accessToken,deviceSerial);
        BasicResponse<SingleDeviceInfoResponse> response = getOneDeviceInfoApi.executeApi();
        return response;
    }

    /**
     * 获取监控点列表
     *
     * @param url
     * @param accessToken
     * @param pageStart
     * @param pageSize
     * @return
     */
    @Override
    public BasicResponse<List<CameraListResponse>> getCameraList(String url, String accessToken, int pageStart, int pageSize) {

        GetCameraListApi getCameraListApi =new GetCameraListApi(url,accessToken,pageStart,pageSize);
        BasicResponse<List<CameraListResponse>> response = getCameraListApi.executeApi();
        return response;
    }

    /**
     * 该接口用于互联互通设备根据UUID查询抓拍的图片
     *
     * @param url         请求地址
     * @param accessToken 授权过程中获取到的access_token
     * @param uuid        设备sdk抓拍返回的UUID
     * @param size        图片的大小 范围在[0~1280]
     * @return 图片信息的json数据
     */
    @Override
    public BasicResponse<CapturePicture> getPictureByUUID(String url, String accessToken, String uuid, int size) {
        GetPictureByUUIDApi getPictureByUUIDApi = new GetPictureByUUIDApi(url,accessToken,uuid,size);
        BasicResponse<CapturePicture> response = getPictureByUUIDApi.executeApi();
        return response;
    }
}
