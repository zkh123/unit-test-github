package com.example.unit.test.github.good.response;

import com.example.unit.test.github.good.constant.ResponseConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * 此类用来返回给APP使用
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MobiBaseResponse {
    /**
     * result为空时，会由mapping.properties接管文案与状态码
     */
    private Integer result;
    private String resultMessage;
    @JsonIgnore
    private Object[] extParam;


    /**
     * 直接返回成功的对象
     *
     * @param resultMessage
     * @return
     */
    public static final MobiBaseResponse success(String resultMessage) {
        MobiBaseResponse mobiBaseResponse = new MobiBaseResponse();
        mobiBaseResponse.setResult(ResponseConstant.SUCCESS_CODE);
        mobiBaseResponse.setResultMessage(resultMessage);
        return mobiBaseResponse;
    }

    /**
     * 直接返回成功的对象
     * @param
     * @return
     */
    public static final MobiBaseResponse success() {
        MobiBaseResponse mobiBaseResponse = new MobiBaseResponse();
        mobiBaseResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        return mobiBaseResponse;
    }

    /**
     * 直接返回失败的对象
     */
    public static final MobiContentResponse<Object> fail() {
        MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
        mobiContentResponse.setResultMessage(ResponseConstant.FAILED_VALUE);

        return mobiContentResponse;
    }

    /**
     * 直接返回失败的对象
     *
     * @param resultMessage
     * @return
     */
    public static final MobiBaseResponse fail(String resultMessage) {
        MobiBaseResponse mobiBaseResponse = new MobiBaseResponse();
        mobiBaseResponse.setResultMessage(resultMessage);

        return mobiBaseResponse;
    }

    public void failed(Integer result, String resultMessage) {
        this.result = result;
        this.resultMessage = resultMessage;
    }

    public void success(Integer result, String resultMessage) {
        this.result = result;
        this.resultMessage = resultMessage;
    }

    /**
     * 指定错误码和国际化的错误消息
     */
    public static final MobiBaseResponse fail(Integer result,String resultMessage) {
        MobiBaseResponse resp = new MobiBaseResponse();
        resp.setResult(result);
        resp.setResultMessage(resultMessage);
        return resp;
    }

}
