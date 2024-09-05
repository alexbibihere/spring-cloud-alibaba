package com.ydg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydg.model.TOrder;
import com.ydg.service.TOrderService;
import com.ydg.mapper.TOrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author gaojt
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2024-08-30 14:20:03
*/
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder>
    implements TOrderService{

    @Override
    public List<TOrder> getAll() {
        return this.baseMapper.selectList(null);
    }
}




