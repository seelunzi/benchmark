
package com.tangtang.trade.hry.trade.mq.controller;


import hry.core.mvc.model.page.JsonResult;
import hry.core.util.springmvcPropertyeditor.DateTimePropertyEditorSupport;
import hry.core.util.springmvcPropertyeditor.StringPropertyEditorSupport;
import hry.trade.mq.service.MessageProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Controller

@RequestMapping({"/test"})
public class TestController {

    @Resource
    private MessageProducer messageProducer;



    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /* 37 */
        binder.registerCustomEditor(Date.class, new DateTimePropertyEditorSupport());




        /* 42 */
        binder.registerCustomEditor(String.class, new StringPropertyEditorSupport(true, false));

    }


    @RequestMapping({"sell"})

    @ResponseBody
    public JsonResult sell(HttpServletRequest request, HttpServletResponse response) {
        /* 59 */
        return new JsonResult();

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\controller\TestController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */