package com.demo.crud.models;

/**
 * author: Naimul Hassan
 * date: 11/13/2024
 */
/**
 * this is the class(dto) for wrapping the response in the specified format
 * service class is responsible to call this class and must pass the expected
 * type of the response as generics this will act like template for all APIs
 */
public class ResponseInfo<T> {

	private int statusCode;
	private String message;
	private T data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
