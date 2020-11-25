package com.example.unit.test.github.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MobiContentResponse<T> extends MobiBaseResponse {
	
	private T content;
	
	public MobiContentResponse(Integer result, String resultMessage) {
		super(result, resultMessage);
	}
	
    /**
     * 直接返回成功的对象
     * @param resultMessage
     * @param content
     * @return
     */
    public static final MobiContentResponse<Object> success(String resultMessage,Object content) {
    	MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
    	mobiContentResponse.setResult(ResponseConstant.SUCCESS_CODE);
    	mobiContentResponse.setResultMessage(resultMessage);
    	mobiContentResponse.setContent(content);
    	
    	return mobiContentResponse;
    }
    /**
	 * 直接返回失败的对象
	 * @param resultMessage
	 * @return
	 */
	public static final MobiContentResponse<Object> fail(String resultMessage,Object content) {
		MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
		mobiContentResponse.setResult(ResponseConstant.FAILED_CODE);
		mobiContentResponse.setResultMessage(resultMessage);
		mobiContentResponse.setContent(content);

		return mobiContentResponse;
	}
    
	/**
	 * 生成通用对象
	 * @param result
	 * @param resultMessage
	 * @param object
	 * @return
	 */
    public static final MobiContentResponse<Object> generate(Integer result,String resultMessage,Object object) {
    	MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
		mobiContentResponse.setResult(result);
		mobiContentResponse.setResultMessage(resultMessage);
		mobiContentResponse.setContent(object);
		
		return mobiContentResponse;
	}
	
	

	/**
	 * 直接返回失败的对象
	 * @param resultMessage
	 * @return
	 */
	public static final MobiContentResponse<Object> failByAppVersion(String resultMessage) {
		MobiContentResponse<Object> mobiContentResponse = new MobiContentResponse<>();
		mobiContentResponse.setResult(ResponseConstant.UPDATE_APP_VERSION_CODE);
		mobiContentResponse.setResultMessage(resultMessage);

		return mobiContentResponse;
	}
}