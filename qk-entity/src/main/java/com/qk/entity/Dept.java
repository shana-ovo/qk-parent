package com.qk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //部门id，主键
    private String name;    //部门名称
    private Integer status; //状态：0-停用，1-正常
    private LocalDateTime createTime;   //创建时间
    private LocalDateTime updateTime;   //更新时间
}
