package jm.mes.api.base.service.impl;

import jm.mes.api.base.entity.Country;
import jm.mes.api.base.mapper.CountryMapper;
import jm.mes.api.base.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}
