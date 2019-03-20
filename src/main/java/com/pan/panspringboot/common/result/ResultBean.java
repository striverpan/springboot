package com.pan.panspringboot.common.result;

import java.io.Serializable;

/** 
 * <p>TODO</p>
 * @author 张刚学 
 * @date 2017年4月30日 下午3:56:22 
 */
public class ResultBean<T> implements Serializable{
	/** 序列化参数 */ 
	private static final long serialVersionUID = 1L;
	/** 错误码 */
	private Integer code;
	/** 提示信息 */
	private String message;
	/** 具体内容 */
	private T bodyData;
	
	
	public ResultBean() {	}

	public ResultBean(int code) {
		this.code = code;
	}
	public ResultBean(String message) {
		this.message = message;
	}
	public ResultBean(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResultBean [code=" + code + ", message=" + message + ", bodyData=" + bodyData + "]";
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getBodyData() {
		return bodyData;
	}
	public void setBodyData(T bodyData) {
		this.bodyData = bodyData;
		
	}
}
