package org.junhi.service.impl;

import org.junhi.domain.Information;
import org.junhi.domain.Replies;
import org.junhi.mapper.InformationsMapper;
import org.junhi.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 10:34
 */
@Service("informationService")
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationsMapper informationsMapper;

    @Override
    public List<Information> findAll() {
        return informationsMapper.findAll();
    }

    @Override
    public Information findInformationById(Integer iId) {
        //查找详情页的同时，查看次数+1
        informationsMapper.updateInformationsViewCountByIid(iId);
        return informationsMapper.findInformationById(iId);
    }

    @Override
    public List<Replies> findRepliesById(Integer iId) {
        return informationsMapper.findRepliesById(iId);
    }

    @Override
    public void saveRepliesByIid(Replies replies) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = df.format(new Date());
//        new java.sql.Timestamp(new Date().getTime());
        replies.setReplyTime(new Timestamp(System.currentTimeMillis()).toString());
        informationsMapper.saveRepliesByIid(replies);
        //保存回复消息的同时，回复次数+1
        informationsMapper.updateInformationsReplyCountByIid(replies);
    }


}
