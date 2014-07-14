package org.troy.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.troy.core.common.Pagination;
import org.troy.manage.entity.AdminUser;
import org.troy.manage.mapper.AdminUserMapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-13<p/>
 * Time: 上午10:51<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Service
public class AdminUserService {

    public void removeAdminUser(Long adminid) {
        adminUserMapper.deleteAdminUser(adminid);
    }

    public void addAdminUser(AdminUser adminUser) {
        adminUserMapper.insertAdminUser(adminUser);
    }
    public void saveAdminUser(AdminUser adminUser) {
        adminUserMapper.updateAdminUser(adminUser);
    }

    public AdminUser getAdminUser(Long adminid) {
        return adminUserMapper.selectAdminUser(adminid);
    }

    public int getAdminUserTotal(AdminUser adminUser) {
        return adminUserMapper.selectAdminUserTotal(adminUser);
    }

    public List<AdminUser> getAdminUserList(Pagination pagination) {
        return adminUserMapper.selectAdminUserList(pagination);
    }

    @Autowired
    private AdminUserMapper adminUserMapper;


}
