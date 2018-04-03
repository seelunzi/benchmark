
package com.tangtang.trade.hry.core.mvc.model.page;
import java.io.Serializable;

public class JsonResult
        implements Serializable {
    private Boolean success = Boolean.valueOf(false);
    private String msg = "";
    private Object obj = null;
    private String code = "";
}