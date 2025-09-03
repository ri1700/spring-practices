package com.bit2025.logex2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("ExampleController2")
public class ExampleController {

	// Logger 생성
	private static final Log logger = LogFactory.getLog(ExampleController.class);

	@ResponseBody
	@RequestMapping("/ex2")
	public String ex2() {

		/**
		 * 이 예제에서는 logback.xml 에서,
		 * 
		 * 1. fileAppender2 와 "com.bit2025.logexample2" logger 설정을 살펴 보아야 합니다.
		 * 
		 * 2. fileAppender2 에서는 /logex/logex2.log 로그파일 지정과
		 * 
		 * 3. 50KB 가 넘었을 때, /logex/logex2.i.log.zip 으로 압축되고 새로 logex2.log 파일이 생성되는 것을
		 * 확인해 봐야 합니다.
		 * 
		 * 4. 새로운 로거를 세팅하고 있습니다. "com.bit2025.logex2" 로거인데, 파일로만 로그를 남기고 있는 것을 확인해야 합니다.
		 * 
		 * 5. 이 로거의 로그 레벨이 INFO 인 것도 로그 파일에서 확인해 보세요.
		 */

		logger.debug("#ex2 - debug log");
		logger.info("#ex2 - info log");
		logger.warn("#ex2 - warn log");
		logger.error("#ex2 - error log");

		return "Logback Logging Example2";
	}
}
