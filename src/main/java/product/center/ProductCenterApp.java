package product.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductCenterApp 
{
    public static void main( String[] args )
    {
       SpringApplication.run(ProductCenterApp.class, args);
    }
}
