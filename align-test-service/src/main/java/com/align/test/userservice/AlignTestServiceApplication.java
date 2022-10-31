package com.align.test.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableEurekaClient
//@RestController
public class AlignTestServiceApplication {
	
/*	
	@Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/{applicationName}")
    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstancesById(applicationName).get(0).getAppName();
    }
*/
	public static void main(String[] args) {
		SpringApplication.run(AlignTestServiceApplication.class, args);
	}

	
	/*@Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9003");
    }*/
	
}
