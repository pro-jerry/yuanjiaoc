package com.yuanjiaoc.test;

import java.util.Map;
import org.junit.Test;

/**
 * 签约.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年10月26日
 */
public class SignTest {

    private static final String noticeKey = "ccb8b984857587efbb70e9fa9156c754";

    private static final String leKey = "9ishlfuxxcufiicvawgfryuwjij81mae";

    @Test
    public void hmfSign() {
        HData hData = new HData();
        hData.setRespCode("00");
        hData.setRespInfo("交易成功");
        hData.setOrderNum("20221028125650787432");
        hData.setProductName("意甲赛季包");
        hData.setProductCount("1");
        hData.setProductPrice("1");
        hData.setAppSerialNo("9_1035537630739042304");
        hData.setCreateOrderTime("20221028125650");
        hData.setTransDate("20221028125650");
        hData.setExtension("123456");
        hData.setTotalFee("1");
        hData.setPayChannelType("2");

        Map<String, Object> sdkHmfNotifyReqMap = SignUtil.beanToMap(hData);
        String localSign = SignUtil.makeSign(sdkHmfNotifyReqMap, noticeKey);
        System.out.println(localSign);
    }

    @Test
    public void leTest() {

        LData lData = new LData();
        lData.setOrderNo("123456");
        lData.setSkuNo("123456");
        lData.setSkuCnt("123456");
        lData.setAppKey("123456");
        lData.setExternalOrderId("4d1039549190767644672");
        lData.setExternalProductId("10000044");
        lData.setProductName("体育通月卡");
        lData.setPrice("1");
        lData.setParamExt("123456");
        lData.setUserId("123456");
        lData.setUserName("123456");
        lData.setMerchantNo("123456");
        lData.setCurrencyCode("123456");

        Map<String, Object> signMap = SignUtil.beanToMap(lData);
        Map<String, Object> sortMap = SignUtil.sortMapByKey(signMap);
        sortMap.put("key", leKey);

        String sign = SignUtil.makeSign(sortMap, false);
        System.out.println(sign);
    }

//    public static void main(String[] args) {
//        SdkLeNotifyReq sdkLeNotifyReq = new SdkLeNotifyReq();
//        sdkLeNotifyReq.setOrderNo("123456");
//        sdkLeNotifyReq.setSkuNo("123456");
//        sdkLeNotifyReq.setSkuCnt("123456");
//        sdkLeNotifyReq.setAppKey("123456");
//        sdkLeNotifyReq.setExternalOrderId("4_1035156149973815296");
//        sdkLeNotifyReq.setExternalProductId("1000308111");
//        sdkLeNotifyReq.setProductName("意甲赛季包");
//        sdkLeNotifyReq.setPrice("1900");
//        sdkLeNotifyReq.setParamExt("123456");
//        sdkLeNotifyReq.setUserId("123456");
//        sdkLeNotifyReq.setUserName("123456");
//        sdkLeNotifyReq.setMerchantNo("123456");
//        sdkLeNotifyReq.setCurrencyCode("123456");
//
//        Map<String, Object> signMap = SignUtil.beanToMap(sdkLeNotifyReq);
//        Map<String, Object> sortMap = SignUtil.sortMapByKey(signMap);
//        sortMap.put("key", "etqygohsayyztdoyryoqlchyqluagdvk");
//        String sign = SignUtil.makeSign(sortMap, false);
//        System.out.println(sign);
//    }


}
