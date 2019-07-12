package org.junhi.service;

import org.junhi.domain.Information;

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
}
