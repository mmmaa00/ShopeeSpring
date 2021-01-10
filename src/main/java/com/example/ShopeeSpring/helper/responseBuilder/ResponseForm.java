package com.example.ShopeeSpring.helper.responseBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForm<T> {
    //data, code, mess
    int code;
    String message;
    T data;

    public  static <T>ResponseForm<T>responseOk(T data,int code,String message){
        ResponseForm<T> responseForm = new ResponseForm<T>();
        responseForm.data=data;
        responseForm.code=code;
        responseForm.message=message;
        return responseForm;
    }
}
