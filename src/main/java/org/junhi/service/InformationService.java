package org.junhi.service;

import org.junhi.domain.Information;
import org.junhi.domain.Replies;

import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 10:33
 */
public interface InformationService {

    /**
     * 查询所有的资讯
     * @return
     */
    List<Information> findAll();

    /**
     * 根据id查询一条数据，包含评论表replies的信息
     * @param iId
     * @return
     */
    Information findInformationById(Integer iId);

    /**
     * 查询回复表
     * @param iId
     * @return
     */
    List<Replies> findRepliesById(Integer iId);

    /**
     * 保存一条回复的消息
     * @param replies
     */
    void saveRepliesByIid(Replies replies);



}
