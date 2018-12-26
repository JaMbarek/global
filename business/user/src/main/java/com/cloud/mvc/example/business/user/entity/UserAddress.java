package com.cloud.mvc.example.business.user.entity;

import com.cloud.mvc.example.business.common.supers.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/12/26
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress extends BaseEntity {
    private Long id;

    private Long userAccountId;

    private String country;

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table user_address
     *
     * @mbg.generated
     */
    public enum Column {
        id("id"),
        userAccountId("user_account_id"),
        country("country");

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