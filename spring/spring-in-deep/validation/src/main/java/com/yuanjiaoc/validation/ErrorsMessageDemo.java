package com.yuanjiaoc.validation;

import com.yuanjiaoc.common.domain.User;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * 错误文案示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年09月29日
 */
public class ErrorsMessageDemo {

    public static void main(String[] args) {

        // 0. 创建 User 对象
        User user = new User();
        user.setName("猿教程");
        // 1. 选择 Errors - BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2. 调用 reject 或 rejectValue
        // reject 生成 ObjectError
        // reject 生成 FieldError
        errors.reject("user.properties.not.null");
        // user.name = user.getName()
        errors.rejectValue("name", "name.required");

        // 3. 获取 Errors 中 ObjectError 和 FieldError
        // FieldError is ObjectError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 4. 通过 ObjectError 和 FieldError 中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }

    private static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User 所有属性不能为空");
        messageSource.addMessage("id.required", Locale.getDefault(), "the id of User must not be null.");
        messageSource.addMessage("name.required", Locale.getDefault(), "the name of User must not be null.");
        return messageSource;
    }
}
