package org.troy.manage.mapper;

import org.springframework.stereotype.Repository;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.ResourceMethod;
import org.troy.manage.entity.ResourceMenu;
import org.troy.manage.vo.ResourceMethodRoleVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午4:18
 * Email:kouhongyu@163.com
 */
@Repository
public interface ResourceMapper {

    public List<ResourceMenu> selectResourceMenuRootList();

    public List<ResourceMenu> selectResourceMenuList(String menucode);

    public ResourceMenu selectResourceMenu(Long menuid);

    public ResourceMethod selectResourceMethod(Long Methodid);

    public List<ResourceMethod> selectResourceMethodList(PagingTool pagingTool);

    public int selectResourceMethodTotal(ResourceMethod resourceMethod);

    public int insertResourceMethod(ResourceMethod resourceMethod);

    public int deleteResourceMethod(ResourceMethod resourceMethod);

    public int updateResourceMethod(ResourceMethod resourceMethod);

    public ResourceMenu selectParentResourceMenu(String menucode);

    public int updateResourceMenu(ResourceMenu resourceMenu);

    public String selectRootMenucodeMax();

    public void insertResourceMenu(ResourceMenu resourceMenu);

    public String selectNodeMenucodeMax(ResourceMenu parentResourceMenu);

    public void deleteResourceMenu(ResourceMenu resourceMenu);

    public ResourceMenu selectResourceMenuByMenucode(String menucode);

    public int selectResourceMethodRoleVOTotal(ResourceMethod resourceMethod);

    public List<ResourceMethodRoleVO> selectResourceMethodRoleVOList(PagingTool pagingTool);




}
