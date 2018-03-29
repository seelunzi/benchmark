/*     */
package com.tangtang.trade.hry.sms.send.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "app_juhe_send")
/*     */ public class AppJuheSend
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @Column(name = "id")
    /*     */ private Long id;
    /*     */
    @Column(name = "type")
    /*     */ private String type;
    /*     */
    @Column(name = "serverUrl")
    /*     */ private String serverUrl;
    /*     */
    @Column(name = "postParam")
    /*     */ private String postParam;
    /*     */
    @Column(name = "receiveStatus")
    /*  36 */ private String receiveStatus = "0";
    /*     */
    /*     */
    @Column(name = "sendStatus")
    /*  39 */ private String sendStatus = "0";
    /*     */
    /*     */
    /*     */
    @Column(name = "thirdPartyResult")
    /*     */ private String thirdPartyResult;
    /*     */
    /*     */
    /*     */
    @Column(name = "through")
    /*     */ private boolean through;

    /*     */
    /*     */
    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  53 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  61 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getType()
    /*     */ {
        /*  69 */
        return this.type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setType(String type)
    /*     */ {
        /*  77 */
        this.type = type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getServerUrl()
    /*     */ {
        /*  85 */
        return this.serverUrl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setServerUrl(String serverUrl)
    /*     */ {
        /*  93 */
        this.serverUrl = serverUrl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getPostParam()
    /*     */ {
        /* 101 */
        return this.postParam;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPostParam(String postParam)
    /*     */ {
        /* 109 */
        this.postParam = postParam;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getReceiveStatus()
    /*     */ {
        /* 117 */
        return this.receiveStatus;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setReceiveStatus(String receiveStatus)
    /*     */ {
        /* 125 */
        this.receiveStatus = receiveStatus;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getSendStatus()
    /*     */ {
        /* 133 */
        return this.sendStatus;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setSendStatus(String sendStatus)
    /*     */ {
        /* 141 */
        this.sendStatus = sendStatus;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getThirdPartyResult()
    /*     */ {
        /* 149 */
        return this.thirdPartyResult;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setThirdPartyResult(String thirdPartyResult)
    /*     */ {
        /* 157 */
        this.thirdPartyResult = thirdPartyResult;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public boolean isThrough()
    /*     */ {
        /* 165 */
        return this.through;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setThrough(boolean through)
    /*     */ {
        /* 173 */
        this.through = through;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\sms\send\model\AppJuheSend.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */