package com.qk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * role实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id; //角色id, 主键
    private String name; //角色名称
    private String label; //角色标识
    private String remark; //备注
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
