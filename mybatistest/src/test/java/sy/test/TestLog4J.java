package sy.test;

import org.apache.log4j.Logger;

public class TestLog4J {
	
	private static Logger logger = Logger.getLogger(TestLog4J.class);  
    
	public static void main(String[] args) {  

        // 记录debug级别的信息  
        logger.debug("中文This is debug message.");  
        // 记录info级别的信息  
        logger.info("中文This is info message.");  
        // 记录error级别的信息  
        logger.error("中文This is error message.");  
    }  

}
