package com.ruoyi.framework.web.service;

import com.ruoyi.system.domain.Client;
import com.ruoyi.system.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author majingyuan
 * @Date Create in 2019/4/6 21:30
 */
@Service("client")
public class ClientService {
    @Autowired
    private IClientService clientService;


    public String getClientName(String clientId)
    {
        return clientService.selectClientById(clientId).getClientName();
    }

    public Client getClient(String clientId)
    {
        return clientService.selectClientById(clientId);
    }
}
