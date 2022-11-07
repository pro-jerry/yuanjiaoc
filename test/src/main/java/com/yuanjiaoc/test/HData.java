package com.yuanjiaoc.test;

import lombok.Data;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月26日
 */
@Data
public class HData {

    /**
     * 返回码 00:交易成功；01:失败.
     */
    private String respCode;

    /**
     * 返回信息.
     */
    private String respInfo;

    /**
     * 订单号.
     */
    private String orderNum;

    /**
     * 产品名称.
     */
    private String productName;

    /**
     * 产品数量.
     */
    private String productCount;

    /**
     * 产品价格 以分为单位.
     */
    private String productPrice;

    /**
     * 商户订单号.
     */
    private String appSerialNo;

    /**
     * 订单创建时间 yyyyMMddHHmmss.
     */
    private String createOrderTime;

    /**
     * 支付订单付款完成时间 yyyyMMddHHmmss.
     */
    private String transDate;

    /**
     * 来自【统一下单接口】，原样返回.
     */
    private String extension;

    /**
     * 以分为单位，可选.
     */
    private String totalFee;

    /**
     * 支付渠道类型 1 支付宝 2 微信，受应用配置控制，可不回调该参数.
     */
    private String payChannelType;

    /**
     * 签名字符串.
     */
    private String sign;
}
