package org.junhi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 资讯表 对应多张回复表
 *
 * @author junhi
 * @date 2019/7/12 10:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information implements Serializable {

    private Integer iId;
    private String iTitle;
    private String iContent;
    private Integer iReplyCount;
    private Integer iViewCount;
    private String iReportTime;
    private String iLastPostTime;

    private List<Replies> repliesList;

}
