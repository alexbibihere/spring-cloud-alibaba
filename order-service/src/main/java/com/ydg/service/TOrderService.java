package com.ydg.service;

import com.ydg.model.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gaojt
* @description 针对表【t_order】的数据库操作Service
* @createDate 2024-08-30 14:20:03
*/
public interface TOrderService extends IService<TOrder> {

    List<TOrder> getAll();
}
