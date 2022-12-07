package com.yuanjiaoc.sourcecoderead.factorybean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月29日
 */
@Data
public class ToolFactory implements FactoryBean<Tool> {


    private int factoryId;
    private int toolId;

    @Override
    public Tool getObject() throws Exception {
        return new Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
