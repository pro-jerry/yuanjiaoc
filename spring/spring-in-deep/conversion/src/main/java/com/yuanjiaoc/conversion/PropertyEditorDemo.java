package com.yuanjiaoc.conversion;

import java.beans.PropertyEditor;

/**
 * {@link PropertyEditor} 示例
 *
 * @author 何二白
 * @version 1.0
 * @see PropertyEditor
 * @since 2022年09月30日
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        // 模拟 Spring Framework 操作
        // 有一段文本 name = 小马哥;
        String text = "name = mina";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        // 传递 String 类型的内容
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());

        System.out.println(propertyEditor.getAsText());
    }
}
