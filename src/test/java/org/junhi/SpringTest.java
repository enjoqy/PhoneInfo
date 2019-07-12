package org.junhi;

import com.alibaba.fastjson.JSON;
import org.junhi.domain.Information;
import org.junhi.service.InformationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 11:23
 */
public class SpringTest {

    @Test
    public void test01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContent.xml");
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }


}
