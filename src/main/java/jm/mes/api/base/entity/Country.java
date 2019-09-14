package jm.mes.api.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author smilezmh
 * @since 2019-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Country对象", description="")
public class Country extends Model<Country> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Code", type = IdType.AUTO)
    private String Code;

    @TableField("Name")
    private String Name;

    @TableField("Continent")
    private String Continent;

    @TableField("Region")
    private String Region;

    @TableField("SurfaceArea")
    private Float SurfaceArea;

    @TableField("IndepYear")
    private Integer IndepYear;

    @TableField("Population")
    private Integer Population;

    @TableField("LifeExpectancy")
    private Float LifeExpectancy;

    @TableField("GNP")
    private Float gnp;

    @TableField("GNPOld")
    private Float GNPOld;

    @TableField("LocalName")
    private String LocalName;

    @TableField("GovernmentForm")
    private String GovernmentForm;

    @TableField("HeadOfState")
    private String HeadOfState;

    @TableField("Capital")
    private Integer Capital;

    @TableField("Code2")
    private String Code2;


    @Override
    protected Serializable pkVal() {
        return this.Code;
    }

}
