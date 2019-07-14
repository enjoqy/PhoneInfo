package org.junhi.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junhi.domain.Information;
import org.junhi.domain.Replies;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author junhi
 * @date 2019/7/12 10:30
 */
@Repository
public interface InformationsMapper {

    /**
     * 查询所有的资讯，包含回复表，一对多
     * @return
     */
    @Select("select * from informations order by last_post_time desc;")
    @Results(id="informationMap", value={
            @Result(property = "iId", column = "i_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "replyCount", column = "reply_count"),
            @Result(property = "viewCount", column = "view_count"),
            @Result(property = "reportTime", column = "report_time"),
            @Result(property = "lastPostTime", column = "last_post_time"),
            @Result(property = "repliesList", column = "i_id", many=@Many(
                    select = "org.junhi.mapper.InformationsMapper.findRepliesById", fetchType = FetchType.LAZY))
    })
    List<Information> findAll();

    /**
     * 根据id查询informations一条数据
     * @param iId
     * @return
     */
    @Select("select * from informations where i_id = #{iId};")
    @ResultMap("informationMap")
    Information findInformationById(Integer iId);

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * property = "user"对应要封装的属性
     * column = "uid"用account中的uid去查user表
     * fetchType = FetchType.EAGER立即查询
     * @return
     */

    /**
     * 根据iId多表查询replies的多条数据
     * @param iId
     * @return
     */
    @Select("select * from replies where i_id = #{iId} order by reply_time desc;")
    @Results(id="repliesMap", value={
            @Result(property = "rId", column = "r_id"),
            @Result(property = "content", column = "content"),
            @Result(property = "replyTime", column = "reply_time"),
            @Result(property = "iId", column = "i_id")
    })
    List<Replies> findRepliesById(Integer iId);

    /**
     * 根据information表的iId保存一条记录
     * @param replies
     */
    @Insert("insert into replies (content, reply_time, i_id) values (#{content},#{replyTime},#{iId});")
    @ResultMap("repliesMap")
    void saveRepliesByIid(Replies replies);

    /**
     * 咨询表查看的次数+1
     * @param iId
     */
    @Update("update informations set view_count=(view_count + 1) where i_id=#{iId};  ")
    void updateInformationsViewCountByIid(Integer iId);

    /**
     * 咨询表回复的次数+1
     * @param iId
     */
    @Update("update informations set reply_count=(reply_count + 1) where i_id=#{iId};  ")
    void updateInformationsReplyCountByIid(Replies iId);

}
