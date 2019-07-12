package org.junhi.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.junhi.domain.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 10:30
 */
@Repository
public interface InformationsMapper {

    /**
     * 查询所有的资讯
     * @return
     */
    @Select("select * from informations order by last_post_time desc;")
    @Results(id="informationMap", value={
            @Result(property = "Iid", column = "i_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "replyCount", column = "reply_count"),
            @Result(property = "viewCount", column = "view_count"),
            @Result(property = "reportTime", column = "report_time"),
            @Result(property = "lastPostTime", column = "last_post_time")
    })
    List<Information> findAll();


}
