package com.cloud.mvc.example.business.user.entity;

import com.cloud.mvc.example.business.common.supers.BaseEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2019/03/28
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TSysUser extends BaseEntity {
    private Long fid;

    private String fusername;

    private String fpassword;

    private String femail;

    private String forgpath;

    private Long fkorgid;

    private String fname;

    private String fidcard;

    private String fphoneno;

    private LocalDateTime fctime;

    private Long fkuserid;

    private Short fisdelete;

    private LocalDateTime futime;

    private String fappkey;

    private Integer oldid;

    private String fgardenauthority;

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    public enum Column {
        fid("fid"),
        fusername("fusername"),
        fpassword("fpassword"),
        femail("femail"),
        forgpath("forgpath"),
        fkorgid("fkorgid"),
        fname("fname"),
        fidcard("fidcard"),
        fphoneno("fphoneno"),
        fctime("fctime"),
        fkuserid("fkuserid"),
        fisdelete("fisdelete"),
        futime("futime"),
        fappkey("fappkey"),
        oldid("oldId"),
        fgardenauthority("fgardenAuthority");

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