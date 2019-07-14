package org.junhi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author junhi
 * @date 2019/7/12 11:23
 */
public class SpringTest {

    @Test
    public void test01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        System.out.println(format);

        System.out.println(new Timestamp(new Date().getTime()));
        long time = new Date().getTime();
        System.out.println(new Timestamp(time));
        long l = System.currentTimeMillis();
        System.out.println(new Timestamp(l).toString());
    }


}
