package product.center.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESConfig {

	@Value("#{es.urls}")
	private String ESUrls;
	
	@Bean
	public RestHighLevelClient buildESClient() {
		HttpHost[] httpHosts=null;
		try {
			String[] urls=ESUrls.split(",");
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		RestHighLevelClient client=new RestHighLevelClient(
				RestClient.builder(new HttpHost[] {}));
		return client;
	}
}
