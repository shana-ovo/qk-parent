package com.qk.dto;

import lombok.Data;

/**
 * /courses?name=Java&subject=1&target=1&page=1&pageSize=10
 * 封装查询参数
 */
@Data
public class CourseDto {
    private String name;    //姓名
    private Integer subject; //  学科, 1: AI智能应用开发(Java), 2: AI大模型开发(Python)，3: AI鸿蒙开发，4: AI大数据，5: AI嵌入式，6: AI测试，7: AI运维
    private Integer page;   //页码
    private Integer pageSize;   //单页记录数
}
