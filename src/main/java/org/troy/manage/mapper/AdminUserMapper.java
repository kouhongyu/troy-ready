package org.troy.manage.mapper;

import org.springframework.stereotype.Repository;
import org.troy.core.common.Pagination;
import org.troy.manage.entity.AdminUser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午4:18
 * Email:kouhongyu@163.com
 */
@Repository
public interface AdminUserMapper {


    public List<AdminUser> selectAdminUserList(Pagination pagination);

    public int selectAdminUserTotal(AdminUser adminUser);

    public AdminUser selectAdminUser(Long adminid);

    public void updateAdminUser(AdminUser adminUser);

    public void insertAdminUser(AdminUser adminUser);

    public void deleteAdminUser(Long adminid);
}
