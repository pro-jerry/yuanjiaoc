package com.yuanjiaoc.aop.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Async
@Component
public class GoodsService {

    //模拟获取商品基本信息，内部耗时500毫秒
    public Future<String> getGoodsInfo(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        return AsyncResult.forValue(String.format("商品%s基本信息!", goodsId));
    }

    //模拟获取商品描述信息，内部耗时500毫秒
    public Future<String> getGoodsDesc(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        return AsyncResult.forValue(String.format("商品%s描述信息!", goodsId));
    }

    //模拟获取商品评论信息列表，内部耗时500毫秒
    public Future<List<String>> getGoodsComments(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        List<String> comments = Arrays.asList("评论1", "评论2");
        return AsyncResult.forValue(comments);
    }
}
