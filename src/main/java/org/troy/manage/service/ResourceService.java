package org.troy.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.ResourceMethod;
import org.troy.manage.mapper.ResourceMapper;
import org.troy.manage.vo.ResourceMethodRoleVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-13<p/>
 * Time: 上午10:51<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Service
public class ResourceService {
    public int getResourceMethodRoleVOTotal(ResourceMethod resourceMethod) {
        return resourceMapper.selectResourceMethodRoleVOTotal(resourceMethod);
    }
    public List<ResourceMethodRoleVO> getResourceMethodRoleVOList(PagingTool pagingTool) {
        return resourceMapper.selectResourceMethodRoleVOList(pagingTool);
    }
    public int getResourceMethodTotal(ResourceMethod resourceMethod) {
        return resourceMapper.selectResourceMethodTotal(resourceMethod);
    }

    public List<ResourceMethod> getResourceMethodList(PagingTool pagingTool) {
        return resourceMapper.selectResourceMethodList(pagingTool);
    }
    @Transactional
    public int saveResourceMethod(ResourceMethod resourceMethod) {
        return resourceMapper.insertResourceMethod(resourceMethod);
    }
    @Transactional
    public int removeResourceMethod(ResourceMethod resourceMethod) {
        return resourceMapper.deleteResourceMethod(resourceMethod);
    }
    @Autowired
    private ResourceMapper resourceMapper;


    public int updateResourceMethod(ResourceMethod resourceMethod) {
        return resourceMapper.updateResourceMethod(resourceMethod);
    }



}
