package org.troy.manage.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-7-24<p/>
 * Time: 上午10:18<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Service
public class TaskTest {

    public void say() {
        logger.info("----troy----TaskTest----System.currentTimeMillis() = " + System.currentTimeMillis());
    }

    private static final Log logger = LogFactory.getLog(TaskTest.class);
}
