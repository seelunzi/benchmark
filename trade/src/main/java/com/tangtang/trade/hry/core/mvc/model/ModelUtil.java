
package com.tangtang.trade.hry.core.mvc.model;


import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.util.Properties;

public class ModelUtil {
    public static final String CN = "cn";
    public static final String EN = "en";
    public static final String CNY = "cny";
    public static final String USD = "usd";
    public static Properties APP = null;
    public static final String SSOKEY = "app.sso";


    static {
        /*  35 */
        APP = new Properties();

        try {
            /*  37 */
            APP.load(new FileReader(ModelUtil.class.getClassLoader().getResource("app.properties").getPath()));


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static String getCurrencyType() {
        /*  53 */
        if ("cn".equals(getWebsite())) {
            /*  54 */
            return "cny";

        }
        return "usd";
    }

    public static String getWebsite() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            String host = request.getHeader("HOST");
            if (!StringUtils.isEmpty(host)) {
                if (host.contains(APP.getProperty("app.website_en"))) {
                    return "en";
                }
            }
        } else {
            String website = RpcContext.getContext().getAttachment("website");
            if (!StringUtils.isEmpty(website)) {
                return website;
            }
        }
        return "cn";
    }

    private static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
        }
        return null;
    }
}