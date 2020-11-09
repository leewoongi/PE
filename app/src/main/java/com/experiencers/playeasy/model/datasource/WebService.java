package com.experiencers.playeasy.model.datasource;


import com.experiencers.playeasy.model.entity.LoginRequest;
import com.experiencers.playeasy.model.entity.LoginResponse;

import io.reactivex.rxjava3.core.Maybe;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebService {

    //카카오 로그인
    @POST("api/auth/login")
    Maybe<LoginResponse> sendAccessToken(@Body LoginRequest loginRequest);

}
