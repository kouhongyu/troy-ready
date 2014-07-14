package org.troy.manage.action;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.manage.entity.AdminUser;
import org.troy.manage.service.AdminUserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-7-18<p/>
 * Time: 下午6:05<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class AdminUserAction extends GenericAction {


    public String removeAdminUserAjax() {
        try {
            if (adminUser == null) {
                putJson(STATUS, "没有传入用户信息");
            } else {
                adminUserService.removeAdminUser(adminUser.getAdminid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    public String addAdminUserAjax() {
        try {
            if (adminUser == null) {
                putJson(STATUS, "没有传入用户信息");
            } else {
                adminUser.setPassword(DigestUtils.md5Hex(adminUser.getPassword()));
                adminUserService.addAdminUser(adminUser);
                putJson("adminUser", adminUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }


        return SUCCESS;
    }

    public String saveAdminUserAjax() {
        try {
            if (adminUser == null) {
                putJson(STATUS, "没有传入用户信息");
            } else {
                adminUser.setPassword(DigestUtils.md5Hex(adminUser.getPassword()));
                adminUserService.saveAdminUser(adminUser);
                putJson("adminUser", adminUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    public String getAdminUserAjax() {
        try {
            if (adminid == null || adminid == 0) {
                putJson(STATUS, "没有传入adminid");
            } else {
                adminUser = adminUserService.getAdminUser(adminid);
                if (adminUser == null) {
                    putJson(STATUS, "没有找到菜单ID为“" + adminid + "”的用户");
                } else {
                    putJson("adminUser", adminUser);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    public String adminUserList() {

        pagination.setTotal(adminUserService.getAdminUserTotal(adminUser));
        pagination.setToPage(getRequest().getRequestURI());

        adminUserList = adminUserService.getAdminUserList(pagination);
        return SUCCESS;
    }

    @Autowired
    private AdminUserService adminUserService;
    List<AdminUser> adminUserList;
    private AdminUser adminUser;
    private Long adminid;
    private static final long serialVersionUID = -9071795970069412857L;

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public AdminUserService getAdminUserService() {
        return adminUserService;
    }

    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    public List<AdminUser> getAdminUserList() {
        return adminUserList;
    }

    public void setAdminUserList(List<AdminUser> adminUserList) {
        this.adminUserList = adminUserList;
    }
}
