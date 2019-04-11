package com.easyshop.web.controller.system;

import java.util.List;

import com.easyshop.system.domain.SysNotice;
import com.easyshop.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.easyshop.common.config.Global;
import com.easyshop.common.core.controller.BaseController;
import com.easyshop.framework.util.ShiroUtils;
import com.easyshop.system.domain.SysMenu;
import com.easyshop.system.domain.SysUser;
import com.easyshop.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysNoticeService noticeService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        // 查询公告
        SysNotice noticeQuery = new SysNotice();
        noticeQuery.setNoticeType("2");
        startPage();
        List<SysNotice> noticeList = noticeService.selectNoticeListForIndex(noticeQuery);

        // 查询通知
        startPage();
        noticeQuery.setNoticeType("1");
        List<SysNotice> messageList = noticeService.selectNoticeListForIndex(noticeQuery);
        mmap.put("noticeList", noticeList);
        mmap.put("messageList", messageList);
        mmap.put("version", Global.getVersion());
        return "main";
    }
}
