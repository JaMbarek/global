package com.cloud.mvc.example.business.system.entity;

import com.cloud.mvc.example.general.supers.BaseEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/11/26
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dict extends BaseEntity {
    private Long id;

    private String group;

    private String key;

    private String value;

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table dict
     *
     * @mbg.generated
     */
    public enum Column {
        id("id"),
        group("group"),
        key("key"),
        value("value"),
        createDate("create_date"),
        modifyDate("modify_date"),
        status("status");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}