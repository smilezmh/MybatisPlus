package jm.mes.api.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jm.mes.api.base.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import jm.mes.api.base.queryModel.CityQueryModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
public interface ICityService extends IService<City> {
    public List<City> GetList(CityQueryModel cityQueryModel);
    public Page<City> GetListPaged(CityQueryModel cityQueryModel);
    public List<City> GetTwoTableInfo();
    public Page<City> GetTwoTableInfoPage(int page,int limit);
    // 使用一个事务
    public void InsertCityAndUpdateCountry();
}
