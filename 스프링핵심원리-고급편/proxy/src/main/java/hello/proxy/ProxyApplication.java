package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


//@Import(AppV1Config.class)
@Import(AppV2Config.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의 AppV1Config 은 컴포넌트 스캔 대상에서 제외하고 설정을 갈아 끼우기 위해서 스캔 대상을 지정함
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
