
package com.tangtang.trade.hry.sms.send.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "app_sms_send")
public class AppSmsSend
        extends BaseModel {

    @Id

    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "serverUrl")
    private String serverUrl;

    @Column(name = "postParam")
    private String postParam;

    @Column(name = "receiveStatus")
    /*  36 */ private String receiveStatus = "0";


    @Column(name = "sendStatus")
    /*  39 */ private String sendStatus = "0";


    @Column(name = "thirdPartyResult")
    private String thirdPartyResult;



    @Column(name = "sendContent")
    private String sendContent;


    public Long getId() {
        /*  54 */
        return this.id;

    }


    public void setId(Long id) {
        /*  62 */
        this.id = id;

    }


    public String getType() {
        /*  70 */
        return this.type;

    }


    public void setType(String type) {
        /*  78 */
        this.type = type;

    }


    public String getServerUrl() {
        /*  86 */
        return this.serverUrl;

    }


    public void setServerUrl(String serverUrl) {
        /*  94 */
        this.serverUrl = serverUrl;

    }


    public String getPostParam() {
        /* 102 */
        return this.postParam;

    }


    public void setPostParam(String postParam) {
        /* 110 */
        this.postParam = postParam;

    }


    public String getReceiveStatus() {
        /* 118 */
        return this.receiveStatus;

    }


    public void setReceiveStatus(String receiveStatus) {
        /* 126 */
        this.receiveStatus = receiveStatus;

    }


    public String getSendStatus() {
        /* 134 */
        return this.sendStatus;

    }


    public void setSendStatus(String sendStatus) {
        /* 142 */
        this.sendStatus = sendStatus;

    }


    public String getThirdPartyResult() {
        /* 150 */
        return this.thirdPartyResult;

    }


    public void setThirdPartyResult(String thirdPartyResult) {
        /* 158 */
        this.thirdPartyResult = thirdPartyResult;

    }


    public String getSendContent() {
        /* 166 */
        return this.sendContent;

    }


    public void setSendContent(String sendContent) {
        /* 174 */
        this.sendContent = sendContent;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\sms\send\model\AppSmsSend.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */