package org.ydg.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ydg.domain.TUser;
import org.ydg.mapper.TUserMapper;
import org.ydg.service.TUserService;

/**
* @author yandg
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-08-30 00:25:01
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{

}




