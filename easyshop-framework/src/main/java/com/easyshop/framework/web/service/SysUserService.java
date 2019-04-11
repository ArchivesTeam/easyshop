package com.easyshop.framework.web.service;

import com.easyshop.system.domain.SysUser;
import com.easyshop.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author majingyuan
 * @Date Create in 2019/4/6 21:30
 */
@Service("user")
public class SysUserService {
    @Autowired
    private ISysUserService sysUserService;


    public String getUserName(Long userId)
    {
        return sysUserService.selectUserById(userId).getUserName();
    }

    public SysUser getUser(Long userId)
    {
        return sysUserService.selectUserById(userId);
    }
}
