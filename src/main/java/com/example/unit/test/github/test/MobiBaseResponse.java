package com.example.unit.test.github.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MobiBaseResponse {
    private Integer result;
    private String resultMessage;


    /**
     * 直接返回成功的对象
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
     * 直接返回失败的对象
     * @param resultMessage
     * @return
     */
    public static final MobiBaseResponse fail(String resultMessage) {
        MobiBaseResponse mobiBaseResponse = new MobiBaseResponse();
        mobiBaseResponse.setResult(ResponseConstant.FAILED_CODE);
        mobiBaseResponse.setResultMessage(resultMessage);

        return mobiBaseResponse;
    }
    /**
     * 生成通用对象
     * @param result
     * @param resultMessage
     * @return
     */
    public static final MobiBaseResponse generate(Integer result,String resultMessage) {
    	MobiBaseResponse mobiBaseResponse = new MobiBaseResponse();
        mobiBaseResponse.setResult(result);
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
    public static final MobiBaseResponse fail(AppErrorCodeEnum errorCodeEnum, String resultMessage) {
        MobiBaseResponse resp = new MobiBaseResponse();
        resp.setResult(errorCodeEnum.getCode());
        resp.setResultMessage(resultMessage);
        return resp;
    }

}
