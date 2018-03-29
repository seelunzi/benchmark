////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package hry.exapi.api.user.controller;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.StringUtil;
//import hry.core.JsonResult;
//import hry.core.annotation.RequestLimit;
//import hry.exapi.util.EncryptUtil;
//import hry.manage.remote.RemoteApiService;
//import hry.manage.remote.RemoteAppTransactionManageService;
//import hry.manage.remote.RemoteManageService;
//import hry.manage.remote.model.ApiExApiApply;
//import hry.manage.remote.model.AppBankCardManage;
//import hry.manage.remote.model.AppTransactionManage;
//import hry.manage.remote.model.Coin;
//import hry.manage.remote.model.CoinAccount;
//import hry.manage.remote.model.ExDigitalmoneyAccountManage;
//import hry.manage.remote.model.RemoteResult;
//import hry.manage.remote.model.User;
//import hry.manage.remote.model.base.FrontPage;
//import hry.redis.common.utils.RedisService;
//import hry.trade.redis.model.EntrustTrade;
//import hry.util.GoogleAuthenticatorUtil;
//import hry.util.SpringUtil;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping({"/api/user"})
//public class UserController {
//    public UserController() {
//    }
//
//    @RequestMapping(
//            value = {"/appSendFrom"},
//            method = {RequestMethod.POST},
//            produces = {"application/json; charset=utf-8"}
//    )
//    @ResponseBody
//    public JsonResult TransferCurrency(String accesskey, String sign1, Long toCustomerId, BigDecimal count, String coinCode) {
//        JsonResult jsonResult = new JsonResult();
//        RemoteApiService remoteApiService = (RemoteApiService)SpringUtil.getBean("remoteApiService");
//        ApiExApiApply exApiApply = remoteApiService.getExApiApply(accesskey);
//        String sign2 = EncryptUtil.hmacSign(toCustomerId + coinCode + count, exApiApply.getAccessKey());
//        if (sign1 != null && sign2.equals(sign1)) {
//            if (exApiApply != null && !exApiApply.equals("")) {
//                Long fromCustomerId = exApiApply.getCustomerId();
//                String string = remoteApiService.TransferCurrency(fromCustomerId, toCustomerId, count, coinCode, "123");
//                jsonResult = (JsonResult)JSONObject.parseObject(string, JsonResult.class);
//                return jsonResult;
//            } else {
//                jsonResult.setSuccess(false);
//                jsonResult.setCode("0000");
//                jsonResult.setMsg("key无效");
//                return jsonResult;
//            }
//        } else {
//            jsonResult.setSuccess(false);
//            jsonResult.setMsg("sign错误");
//            jsonResult.setCode("0000");
//            return jsonResult;
//        }
//    }
//
//
//}
