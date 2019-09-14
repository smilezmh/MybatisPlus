package jm.mes.api.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jm.mes.api.base.entity.City;
import jm.mes.api.base.mapper.CityMapper;
import jm.mes.api.base.queryModel.CityQueryModel;
import jm.mes.api.base.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {
    @Autowired
    private CityMapper cityMapper;

    /**
     * @param cityQueryModel 搜索条件
     * @return
     */
    public List<City> GetList(CityQueryModel cityQueryModel) {
        QueryWrapper<City> wrapper = new QueryWrapper<City>();
        wrapper.select("id", "name", "countryCode", "district", "population");
        if (cityQueryModel.getName() != null && !cityQueryModel.getName().isEmpty() && cityQueryModel.getName().trim() != "") {
            wrapper.like("name", cityQueryModel.getName());
        }

        if (cityQueryModel.getCountryCode() != null && !cityQueryModel.getCountryCode().isEmpty() && cityQueryModel.getCountryCode().trim() != "") {
            wrapper.eq("countryCode", cityQueryModel.getCountryCode());
        }

        wrapper.orderBy(true, true, "id");

        return cityMapper.selectList(wrapper);
    }

    public Page<City> GetListPaged(CityQueryModel cityQueryModel) {
        IPage<City> page = new Page<City>(cityQueryModel.getCurrent(),cityQueryModel.getSize());
        QueryWrapper<City> wrapper = new QueryWrapper<City>();
        wrapper.select("id", "name", "countryCode", "district", "population");

        if (cityQueryModel.getName() != null && !cityQueryModel.getName().isEmpty() && cityQueryModel.getName().trim() != "") {
            wrapper.like("name", cityQueryModel.getName());
        }

        if (cityQueryModel.getCountryCode() != null && !cityQueryModel.getCountryCode().isEmpty() && cityQueryModel.getCountryCode().trim() != "") {
            wrapper.eq("countryCode", cityQueryModel.getCountryCode());
        }

        wrapper.orderBy(true, true, "id");

  /*      List<City> totalCitys = cityMapper.selectList(wrapper);

        wrapper.last("limit "+(cityQueryModel.getCurrent()*cityQueryModel.getSize()-1)+","+cityQueryModel.getSize());
        List<City> pageCitys = cityMapper.selectList(wrapper);

        // 总页数
        page.setTotal(totalCitys.size());
        page.setSize(cityQueryModel.getSize());
        page.setCurrent(cityQueryModel.getCurrent());
        page.setRecords(pageCitys);*/

        // 使用插件分页方法
        page=cityMapper.selectPage(page,wrapper);

        return (Page<City>) page;

    }

    public List<City> GetTwoTableInfo()
    {
        return cityMapper.GetTwoTableInfo();
    }

    public Page<City> GetTwoTableInfoPage(int page,int limit)
    {
        Page<City> pagecity=new Page<City>(page,limit);
        QueryWrapper<City> wrapper=new QueryWrapper<City>();
        wrapper.like("city.name","Ka");
        pagecity.setRecords(cityMapper.GetTwoTableInfoPage(pagecity,wrapper));
        return pagecity;
    }

    @Transactional(propagation = Propagation.NESTED)
    public void InsertCityAndUpdateCountry()
    {
        City city=new City();
        city.setId(6669);
        city.setName("3hjk");
        city.setCountryCode("3h");
        city.insert();
        City city1=new City();
        city1.setId(6669);
        city1.setName("new");
        city1.setCountryCode("new");
        city1.insert();
    }
}
