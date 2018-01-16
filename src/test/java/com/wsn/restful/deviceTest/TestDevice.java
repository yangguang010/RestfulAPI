package com.wsn.restful.deviceTest;

import com.wsn.restful.api.device.*;
import com.wsn.restful.response.*;
import com.wsn.restful.util.QRCodeToImage;
import org.junit.Test;

import java.util.List;

/**
 * Created by songyangguang on 2018/1/11.
 */
public class TestDevice {
    @Test
    public void testAddDevice() {
        String url = "https://open.ys7.com/api/lapp/device/add";
        String accesstoken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String deviceSerial = "824875874";
        String validateCode = "OFJJTK";

        AddDeviceApi api = new AddDeviceApi(url,accesstoken,deviceSerial,validateCode);
        BasicResponse<NewDeviceResponse> response = api.executeApi();
        System.out.println("code"+response.code + " msg" + response.msg);
    }

    @Test
    public void testDeleteDevice() {
        String url = "https://open.ys7.com/api/lapp/device/delete";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String deviceSerial = "824875874";

        DeleteDeviceApi deleteDeviceApi = new DeleteDeviceApi(url,accessToken,deviceSerial);
        BasicResponse<NewDeviceResponse> response = deleteDeviceApi.executeApi();

        System.out.println("code:" + response.getCode() + "   msg:"+response.getMsg());
    }

    @Test
    public void testAlterDeviceName() {
        String url = "https://open.ys7.com/api/lapp/device/name/update";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String deviceSerial = "824875874";
        String deviceName = "yangguang1";

        AlterDeviceNameApi alterDeviceNameApi = new AlterDeviceNameApi(url,accessToken,deviceSerial,deviceName);
        BasicResponse<NewDeviceResponse> response = alterDeviceNameApi.executeApi();

        System.out.println("code:" + response.getCode() + "   msg:"+response.getMsg());
    }

    @Test
    public void testCapturePicApi() {
        String url = "https://open.ys7.com/api/lapp/device/capture";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String deviceSerial = "824875874";

        CapturePicApi capturePicApi = new CapturePicApi(url,accessToken,deviceSerial);
        BasicResponse<CapturePicture> response = capturePicApi.executeApi();

        System.out.println("data:"+response.getData().getPicUrl() + "   code:"+response.getCode() + "   msg:" + response.getMsg());
    }

    @Test
    public void testQrcodeWiFiApi() {
        String url = "https://open.ys7.com/api/lapp/device/wifi/qrcode";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String ssid = "WSN407";
        String password = "wsn407407";

        QrcodeWiFiApi qrcodeWiFiApi = new QrcodeWiFiApi(url,accessToken,ssid,password);
        BasicResponse<CodeImageResponse> response = qrcodeWiFiApi.executeApi();
        System.out.println("imageData:" + response.getData().getImageData());
        System.out.println("code:"+ response.getCode()+"   msg:" + response.getMsg());
        System.out.println("url = "+ (new QRCodeToImage()).base64StringToImage(response.getData().getImageData()));
    }

    @Test
    public void testDeviceListApi() {
        String url = "https://open.ys7.com/api/lapp/device/list";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        int pageStart = 0;
        int pageSize = 2;

        GetDeviceListApi getDeviceListApi = new GetDeviceListApi(url,accessToken,pageStart,pageSize);
        BasicResponse<List<DeviceListResponse>> response = getDeviceListApi.executeApi();
        System.out.println("msg:" + response.getMsg());
        System.out.println("data:" +response.getData().toString());
        System.out.println("data:" +response.getData().get(1));
        System.out.println("data:" +response.getJson());
    }

    @Test
    public void testGetOneDeviceApi() {
        String url = "https://open.ys7.com/api/lapp/device/info";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        String deviceSerial = "824875874";

        GetOneDeviceInfoApi getOneDeviceInfoApi = new GetOneDeviceInfoApi(url,accessToken,deviceSerial);
        BasicResponse<SingleDeviceInfoResponse> response = getOneDeviceInfoApi.executeApi();

        System.out.println("data:"+response.getJson());
        System.out.println("code:" + response.getCode());
        System.out.println("msg:" + response.getMsg());
    }

    @Test
    public void testGetCameraListApi() {
        String url = "https://open.ys7.com/api/lapp/camera/list";
        String accessToken = "at.38s4iyczacw2eet7b3yyubgl912t0pz1-2rsetdrwx6-1xeqgcb-fvpvhhoev";
        int pageStart = 0;
        int pageSize = 2;

        GetCameraListApi getCameraListApi = new GetCameraListApi(url,accessToken,pageStart,pageSize);
        BasicResponse<List<CameraListResponse>> response = getCameraListApi.executeApi();

        System.out.println("msg:" + response.getMsg());
        System.out.println("data_toString:" +response.getData().toString());
        System.out.println("data1:" +response.getData().get(1));
        System.out.println("data_Json:" +response.getJson());
    }
}
