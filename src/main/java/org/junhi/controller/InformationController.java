package org.junhi.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junhi.domain.Information;
import org.junhi.domain.Replies;
import org.junhi.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 10:28
 */
@RestController
@RequestMapping("/informations")
public class InformationController {

    @Autowired
    private InformationService informationService;

    /**
     * 查询所有的资讯
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Information> findAll() throws JsonProcessingException {
        List<Information> informationList = informationService.findAll();
        informationList.forEach(x -> System.out.println(x));
        return informationList;
    }


    @RequestMapping(value = "/findInformationById")
    @ResponseBody
    public Information findInformationById(String iId){
        Information information = informationService.findInformationById(Integer.parseInt(iId));
        return information;
    }

    @RequestMapping("/saveRepliesByIid")
    public void saveRepliesByIid(Replies replies){
        informationService.saveRepliesByIid(replies);
    }

}
