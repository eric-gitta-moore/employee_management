package com.example.employee_management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 附件表
 * </p>
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("em_attachment")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("公司法人，联系人，营业执照图片实体类")
public class EmAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 名称
     */
    @ApiModelProperty("图片名称")
    private String name;

    /**
     * 路径
     */
    @ApiModelProperty("图片路径名称")
    private String path;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String comment;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private String createBy;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    private String updateBy;




    public EmAttachment( String path, String name,String comment, LocalDateTime createTime, LocalDateTime updateTime, String createBy, String updateBy) {
        this.name = name;
        this.path = path;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }
}
