package com.example.unit.test.github.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * getLoanInfo, confLoanInfo"
 *
 * @author supengfei
 */
public class QueRenJieKuanXinXi {

    @Data
    @ApiModel("QueRenJiekuanXinXiIn")
    public static class In {

    }

    @Getter
    @Setter
    @Builder
    @ApiModel("QueRenJiekuanXinXiOut")
    public static class Out {
        private Integer result;
        private String resultMessage;
        private Content content;
        private boolean isSendMessage = false;

    }

    @Getter
    @Setter
    @Builder
    @ApiModel("QueRenJiekuanXinXiContent")
    public static class Content {
        /**
         * 持有人姓名
         */
        @JsonProperty("uname")
        private String chiYouRen;

        /**
         * 银行编码
         */
        @JsonProperty("bnkCode")
        private String yinHangBianMa;

        /**
         * 银行名称
         */
        @JsonProperty("bnkName")
        private String yinHangMIngZi;

        /**
         * 银行卡账号
         */
        @JsonProperty("bnkAcct")
        private String yinHangKaHao;

        /**
         * 收集用户信息状态 0：不收集 1：收集
         */
        @JsonProperty("collectionInfoStatus")
        private int collectionInfoStatus;

    }
}
