package com.yuanjiaoc.sourcecoderead;

import com.yuanjiaoc.common.domain.City;
import com.yuanjiaoc.common.domain.Company;
import java.util.List;
import java.util.Properties;
import lombok.Data;
import org.springframework.core.io.Resource;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月08日
 */
@Data
public class Person {

    private Long id;

    private String name;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Resource configFileLocation;

    private Company company;

    private Properties context;

    private String contextAsText;
}
