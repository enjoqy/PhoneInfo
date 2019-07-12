package org.junhi.service.impl;

import org.junhi.domain.Information;
import org.junhi.mapper.InformationsMapper;
import org.junhi.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
