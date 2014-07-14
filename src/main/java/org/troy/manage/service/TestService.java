package org.troy.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.troy.manage.entity.Test;
import org.troy.manage.mapper.TestMapper;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 13-8-7<p/>
 * Time: 下午5:39<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Service
public class TestService {

    public Integer insertTest(Test test) {
        return testMapper.insertTest(test);
    }
    @Autowired
    private TestMapper testMapper;
}
