package com.cloud.mvc.example.business.user.entity;

import com.cloud.mvc.example.business.common.supers.BaseEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/12/13
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount extends BaseEntity {
    private Long id;

    private String phone;

    private String email;

    private String loginPassword;

    private String dealPassword;

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table user_account
     *
     * @mbg.generated
     */
    public enum Column {
        id("id"),
        phone("phone"),
        email("email"),
        loginPassword("login_password"),
        dealPassword("deal_password"),
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