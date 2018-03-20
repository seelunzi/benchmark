/*     */
package com.tangtang.trade.hry.core.mvc.model;
/*     */
/*     */

import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.util.Properties;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class ModelUtil
        /*     */ {
    /*     */   public static final String CN = "cn";
    /*     */   public static final String EN = "en";
    /*     */   public static final String CNY = "cny";
    /*     */   public static final String USD = "usd";
    /*  30 */   public static Properties APP = null;
    /*     */   public static final String SSOKEY = "app.sso";

    /*     */
    /*     */   static
        /*     */ {
        /*  35 */
        APP = new Properties();
        /*     */
        try {
            /*  37 */
            APP.load(new FileReader(ModelUtil.class.getClassLoader().getResource("app.properties").getPath()));
            /*     */
            /*     */
            /*     */
        }
        /*     */ catch (Exception e)
            /*     */ {
            /*     */
            /*  44 */
            e.printStackTrace();
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static String getCurrencyType()
    /*     */ {
        /*  53 */
        if ("cn".equals(getWebsite())) {
            /*  54 */
            return "cny";
            /*     */
        }
        /*  56 */
        return "usd";
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static String getWebsite()
    /*     */ {
        /*  63 */
        HttpServletRequest request = getRequest();
        /*  64 */
        if (request != null) {
            /*  65 */
            String host = request.getHeader("HOST");
            /*  66 */
            if (!StringUtils.isEmpty(host))
                /*     */ {
                /*  68 */
                if (host.contains(APP.getProperty("app.website_en"))) {
                    /*  69 */
                    return "en";
                    /*     */
                }
                /*     */
            }
            /*     */
        } else {
            /*  73 */
            String website = RpcContext.getContext().getAttachment("website");
            /*  74 */
            if (!StringUtils.isEmpty(website)) {
                /*  75 */
                return website;
                /*     */
            }
            /*     */
        }
        /*  78 */
        return "cn";
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private static HttpServletRequest getRequest()
    /*     */ {
        /*     */
        try
            /*     */ {
            /*  95 */
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            /*     */
        }
        /*     */ catch (Exception e) {
        }
        /*     */
        /*     */
        /* 100 */
        return null;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\ModelUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */