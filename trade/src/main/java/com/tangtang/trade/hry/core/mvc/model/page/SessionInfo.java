
package com.tangtang.trade.hry.core.mvc.model.page;

import java.io.Serializable;
import java.util.List;

public class SessionInfo
        implements Serializable {
    /* 20 */   private List<String> permissionUrls = null;

    public List<String> getPermissionUrls() {
        return this.permissionUrls;
    }

    public void setPermissionUrls(List<String> permissionUrls) {
        this.permissionUrls = permissionUrls;
    }
}
