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
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Countrylanguage对象", description="")
public class Countrylanguage extends Model<Countrylanguage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CountryCode", type = IdType.AUTO)
    private String CountryCode;

    @TableField("Language")
    private String Language;

    @TableField("IsOfficial")
    private String IsOfficial;

    @TableField("Percentage")
    private Float Percentage;


    @Override
    protected Serializable pkVal() {
        return this.CountryCode;
    }

}
