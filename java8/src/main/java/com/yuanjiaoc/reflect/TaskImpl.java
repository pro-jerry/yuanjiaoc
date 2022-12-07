package com.yuanjiaoc.reflect;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月02日
 */
public class TaskImpl implements Task {

    @Override
    public void setData(String data) {
        System.out.println(data + " Data is saved");
    }

    @Override
    public int getCalData(int x) {
        return x * 10;
    }
}
