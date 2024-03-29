package com.yuanjiaoc.i18n;

import java.text.MessageFormat;
import java.util.Date;

/**
 * {@link MessageFormat} 示例
 *
 * @author 何二白
 * @version 1.0
 * @see MessageFormat
 * @since 2022年09月24日
 */
public class MessageFormatDemo {

    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";

        String messageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(messageFormatPattern);
        String result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        // 重置 MessageFormatPattern
        // applyPattern
        messageFormatPattern = "This is a text : {0}, {1}, {2}";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[]{"Hello,World", "666"});
        System.out.println(result);

    }
}
