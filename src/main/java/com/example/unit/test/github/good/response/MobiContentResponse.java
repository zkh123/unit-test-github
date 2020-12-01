package com.example.unit.test.github.good.response;

import com.example.unit.test.github.good.constant.ResponseConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 此类用来返回给APP使用
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class MobiContentResponse<T> extends MobiBaseResponse {

    private T content;

    public MobiContentResponse(Integer result, String resultMessage,Object[] extParam) {
        super(result, resultMessage,extParam);
    }

    /**
     * 直接返回成功的对象
     */
    public static final MobiContentResponse<Object> success(String resultMessage, Object content) {
        MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
        mobiContentResponse.setResult(ResponseConstant.SUCCESS_CODE);
        mobiContentResponse.setResultMessage(resultMessage);
        mobiContentResponse.setContent(content);

        return mobiContentResponse;
    }

    /**
     * 直接返回成功的对象
     */
    public static final MobiContentResponse<Object> success(Object content) {
        MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        mobiContentResponse.setContent(content);

        return mobiContentResponse;
    }


    /**
     * 直接返回失败的对象
     */
    public static final MobiContentResponse<Object> fail(String resultMessage, Object content) {
        MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
        mobiContentResponse.setResult(ResponseConstant.FAILED_CODE);
        mobiContentResponse.setResultMessage(resultMessage);
        mobiContentResponse.setContent(content);

        return mobiContentResponse;
    }



}