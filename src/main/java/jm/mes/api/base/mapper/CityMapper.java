package jm.mes.api.base.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jm.mes.api.base.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jm.mes.api.base.queryModel.CityQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
@Repository
public interface CityMapper extends BaseMapper<City> {

    @Select("SELECT id,city.Name ,countrycode,country.Name as countryName FROM city LEFT JOIN country  ON city.CountryCode=country.Code")
    public List<City> GetTwoTableInfo();

    @Select("SELECT id,city.Name ,countrycode,country.Name as countryName FROM city LEFT JOIN country  ON city.CountryCode=country.Code  ${ew.customSqlSegment}")
    public List<City> GetTwoTableInfoPage(Page<City> cityPage, @Param(Constants.WRAPPER) Wrapper<City> wrapper);


}
