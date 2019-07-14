package org.junhi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 回复表
 *
 * @author junhi
 * @date 2019/7/12 10:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Replies implements Serializable {

    private Integer rId;
    private String content;
    private String replyTime;
    private Integer iId;

}
