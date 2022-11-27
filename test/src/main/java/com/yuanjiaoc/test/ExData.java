package com.yuanjiaoc.test;

import lombok.Data;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月26日
 */
@Data
public class ExData {

    /**
     * 联运退款单号.
     */
    private String refundNo;

    /**
     * skuNo.
     */
    private String skuNo;

    /**
     * skuCnt.
     */
    private String skuCnt;

    /**
     * 分配的 appKey.
     */
    private String appKey;

    /**
     * 接⼊⽅订单号.
     */
    private String externalRefundNo;

    /**
     * 接⼊⽅商品号.
     */
    private String externalProductId;

    /**
     * 接⼊⽅商品名.
     */
    private String productName;

    /**
     * 商品价格.
     */
    private String price;

    /**
     * 扩展参数.
     */
    private String paramExt;

    /**
     * ⽤户id.
     */
    private String userId;

    /**
     * ⽤户名.
     */
    private String userName;

    /**
     * VC=乐钻⽀付, 不传=其他现⾦⽅式⽀付.
     */
    private String merchantNo;
}
