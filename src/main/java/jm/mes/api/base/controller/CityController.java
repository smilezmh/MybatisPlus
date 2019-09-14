package jm.mes.api.base.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jm.mes.api.base.entity.City;
import jm.mes.api.base.queryModel.CityQueryModel;
import jm.mes.api.base.service.ICityService;
import jm.mes.api.config.LogConfig;
import jm.mes.api.utils.JsonResult;
import jm.mes.api.utils.JsonResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
@Api("城市业务接口")
@RestController
@RequestMapping("/base/city")
public class CityController {
    @Autowired
    ICityService cityService;

    /**
     * 根据名字和国家查询所有城市数据
     * @param name 名字
     * @param countryCode 国家
     * @return 城市结果
     */
    @ApiOperation("根据名字和国家查询所有城市数据")
    @RequestMapping(value="getlist/{name}/{countryCode}",method = RequestMethod.GET)
    public JsonResult<City> GetList(@PathVariable String name,@RequestParam(required = false) String countryCode)
    {
        CityQueryModel cityQueryModel=new CityQueryModel();
        cityQueryModel.setName(name);
        cityQueryModel.setCountryCode(countryCode);
        JsonResult<City> jsonResult=new JsonResult<City>();
        List<City> cityList;
        cityList= cityService.GetList(cityQueryModel);
        jsonResult.result=cityList;
        jsonResult.isSuccess=true;
        jsonResult.msg="成功返回";
        jsonResult.httpCode="200";
        jsonResult.count=cityList.size();
        return  jsonResult;
    }

    // 分页
    @ApiOperation("分页根据名字和国家查询所有城市数据")
    @RequestMapping(value="getlistPaged/{name}/{countryCode}/{page}/{limit}",method = RequestMethod.GET)
    public JsonResultPage<City> GetListPaged(@PathVariable String name, @RequestParam(required = false) String countryCode,
                                             @RequestParam(required = true) int page, @RequestParam(required = true) int limit)
    {
        CityQueryModel cityQueryModel=new CityQueryModel();
        cityQueryModel.setName(name);
        cityQueryModel.setCountryCode(countryCode);
        cityQueryModel.setCurrent(page);
        cityQueryModel.setSize(limit);

        JsonResultPage<City> jsonResultPage=new JsonResultPage<City>();
        Page<City> cityListPaged;
        cityListPaged= cityService.GetListPaged(cityQueryModel);
        jsonResultPage.setPage(cityListPaged);
        jsonResultPage.isSuccess=true;
        jsonResultPage.msg="成功返回";
        jsonResultPage.httpCode="200";
        return  jsonResultPage;
    }
    @ApiOperation("串表查询")
    @RequestMapping(value="GetTwoTableInfo",method = RequestMethod.GET)
    public JsonResult<City> GetTwoTableInfo()
    {
        JsonResult<City> jsonResult=new JsonResult<City>();
        List<City> cityList;
        cityList= cityService.GetTwoTableInfo();
        jsonResult.result=cityList;
        jsonResult.isSuccess=true;
        jsonResult.msg="成功返回";
        jsonResult.httpCode="200";
        //int a=1/0;
        return  jsonResult;
    }

    @ApiOperation("串表分页查询")
    @RequestMapping(value="GetTwoTableInfo/{page}/{limit}",method = RequestMethod.GET)
    public JsonResultPage<City> GetTwoTableInfoPage(@PathVariable int page,@PathVariable int limit)
    {
        JsonResultPage<City> jsonResultPage=new JsonResultPage<City>();
        Page<City> cityListPage;
        cityListPage= cityService.GetTwoTableInfoPage(page,limit);
        jsonResultPage.page=cityListPage;
        jsonResultPage.isSuccess=true;
        jsonResultPage.msg="成功返回";
        jsonResultPage.httpCode="200";
        //int a=1/0;
        return  jsonResultPage;
    }

    @ApiOperation("事务插入")
    @RequestMapping(value="insert",method = RequestMethod.POST)
    public void InsertCityAndUpdateCountry()
    {
        cityService.InsertCityAndUpdateCountry();
    }

}


