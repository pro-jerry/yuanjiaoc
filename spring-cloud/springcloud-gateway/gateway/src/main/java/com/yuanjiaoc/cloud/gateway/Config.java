package com.yuanjiaoc.cloud.gateway;

import java.util.Map;
import java.util.function.Predicate;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月11日
 */
public class Config {

    private Class inClass;
    private Predicate predicate;
    private Map<String, Object> hints;

    public Config() {
    }

    public Class getInClass() {
        return this.inClass;
    }

    public Config setInClass(Class inClass) {
        this.inClass = inClass;
        return this;
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public Config setPredicate(Predicate predicate) {
        this.predicate = predicate;
        return this;
    }

    public <T> Config setPredicate(Class<T> inClass, Predicate<T> predicate) {
        this.setInClass(inClass);
        this.predicate = predicate;
        return this;
    }

    public Map<String, Object> getHints() {
        return this.hints;
    }

    public Config setHints(Map<String, Object> hints) {
        this.hints = hints;
        return this;
    }
}
