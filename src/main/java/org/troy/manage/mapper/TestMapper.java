package org.troy.manage.mapper;

import org.springframework.stereotype.Repository;
import org.troy.manage.entity.Test;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 13-8-7<p/>
 * Time: 下午5:45<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Repository
public interface TestMapper {

    public Integer insertTest(Test test);

}
