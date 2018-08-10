package demo.web;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class CrossFilter implements Filter  {
	protected Logger logger = LoggerFactory.getLogger(CrossFilter.class);
	private String allowCrossUrl = null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		allowCrossUrl = getProperties("oftenconfig.properties", "allowCrossUrl");
	}

	@Override
	public void destroy() {
		//destroy
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain)
			throws IOException, ServletException {
		//解决跨域问题
		logger.info("doFilter========");
		/*HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		StringBuffer url1 = request.getRequestURL();  
		String tempContextUrl = url1.delete(url1.length() - request.getRequestURI().length(), url1.length()).toString();  
        boolean agent = isMobileDevice(request.getHeader("user-agent"));
        if (!"".equals(tempContextUrl)) {
        	if(agent) {
        		String collFilterDomain = allowCrossUrl;
        		 logger.info("app访问:{}",collFilterDomain);
        		 response.addHeader("Access-Control-Allow-Origin", collFilterDomain);
        	}else {
        		tempContextUrl = allowCrossUrl;
        		response.addHeader("Access-Control-Allow-Origin",tempContextUrl);
        	}
        	response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
            response.addHeader("Access-Control-Allow-Credentials", "true");
        }*/
        chain.doFilter(req, resp);	
        
		
	}
	
	/** 
     * android : 所有android设备 
     * mac os : iphone ipad 
     * windows phone:Nokia等windows系统的手机 
     */  
	public static boolean isMobileDevice(String requestHeader){  
        String[] deviceArray = new String[]{"android","mac os","windows phone"};  
        if(requestHeader == null)  
            return false;  
        String header = requestHeader.toLowerCase();  
        for(int i=0;i<deviceArray.length;i++){  
            if(header.indexOf(deviceArray[i])>-1){  
                return true;  
            }  
        }  
        return false;  
	} 
	
	/**
     * 根据key读取value
     * 
     * @Title: getProperties_1   
     * @Description: 第一种方式：根据文件名使用spring中的工具类进行解析  
     *                  filePath是相对路劲，文件需在classpath目录下
     *                   比如：config.properties在包com.test.config下， 
     *                路径就是com/test/config/config.properties    
     *          
     * @param filePath 
     * @param keyWord      
     * @return
     * @return String  
     * @throws
     */
    public static String getProperties(String filePath, String keyWord){
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(filePath);
            // 根据关键字查询相应的值
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return value;
    }

	
}
