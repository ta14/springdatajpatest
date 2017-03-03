/**
 * File Name    :   Pet.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 1, 2017 11:59:57 PM
 * Purpose      :   Main Test Class for Pet Store API Application.
 *
 */

package tests.sanjay.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tests.sanjay.springjpa.Application;

/**
 * Main Test Class for Pet Store API Application.
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }

}
