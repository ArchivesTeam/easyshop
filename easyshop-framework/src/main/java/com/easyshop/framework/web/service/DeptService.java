package com.easyshop.framework.web.service;

import com.easyshop.system.service.IShopItemService;
import com.easyshop.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author majingyuan
 * @Date Create in 2019/4/6 21:30
 */
@Service("dept")
public class DeptService {
    @Autowired
    private ISysDeptService deptService;


    public String getLabel(Long deptId)
    {
        return deptService.selectDeptById(deptId).getDeptName();
    }
}
