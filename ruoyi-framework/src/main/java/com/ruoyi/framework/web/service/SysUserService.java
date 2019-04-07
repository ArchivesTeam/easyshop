package com.ruoyi.framework.web.service;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
