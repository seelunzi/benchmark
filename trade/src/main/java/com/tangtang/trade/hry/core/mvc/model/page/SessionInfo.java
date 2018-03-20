/*    */
package com.tangtang.trade.hry.core.mvc.model.page;
/*    */
/*    */

import java.io.Serializable;
import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class SessionInfo
        /*    */ implements Serializable
        /*    */ {
    /* 20 */   private List<String> permissionUrls = null;

    /*    */
    /*    */
    public List<String> getPermissionUrls() {
        /* 23 */
        return this.permissionUrls;
        /*    */
    }

    /*    */
    /*    */
    public void setPermissionUrls(List<String> permissionUrls) {
        /* 27 */
        this.permissionUrls = permissionUrls;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\page\SessionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */