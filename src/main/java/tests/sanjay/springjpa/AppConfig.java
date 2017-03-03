/**
 * File Name    :   AppConfig.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 12:04:36 AM
 * Purpose      :   Spring Configuration for PetStore App.
 *
 */

package tests.sanjay.springjpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Spring Configuration for PetStore App.
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@Configuration
@EnableJpaRepositories
public class AppConfig {

    @Bean
    public PetService petService() {
        return new PetService();
    }
    
    /**
     * Bootstraps an in-memory HSQL database.
     * 
     * @return
     * @see http 
     *      ://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html#jdbc-embedded-database
     *      -support
     */
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

}
