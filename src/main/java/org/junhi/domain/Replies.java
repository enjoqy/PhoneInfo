package org.junhi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author junhi
 * @date 2019/7/12 10:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Replies implements Serializable {

    private Integer Rid;
    private String content;
    private Date replyTime;
    private Integer Iid;

}
