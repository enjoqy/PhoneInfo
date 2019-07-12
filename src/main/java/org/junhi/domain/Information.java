package org.junhi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯表
 *
 * @author junhi
 * @date 2019/7/12 10:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information implements Serializable {

    private Integer Iid;
    private String title;
    private String content;
    private Integer replyCount;
    private Integer viewCount;
    private String reportTime;
    private String lastPostTime;

}
