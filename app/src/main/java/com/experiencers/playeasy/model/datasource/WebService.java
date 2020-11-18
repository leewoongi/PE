package com.experiencers.playeasy.model.datasource;


import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ApplyResponse;
import com.experiencers.playeasy.model.entity.MapResponse;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.model.entity.User;
import com.experiencers.playeasy.model.entity.LoginRequest;
import com.experiencers.playeasy.model.entity.LoginResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {

    /**
     * 로그인
     */
    //카카오 로그인
    @POST("api/auth/login")
    Maybe<LoginResponse> sendAccessToken(@Body LoginRequest loginRequest);

    /**
     * 메인 페이지
     */
    //매치 리스트 불러오기 (메인화면)
    @GET("api/match/list")
    Maybe<List<Match>> retrieveMatchList(@Query("date")String date);

    /**
     * 내 정보
     */
    // 불러오기
    @GET("api/user")
    Maybe<User> retrieveUserInfo(@Header("Authorization")String userKey);


    /**
     * 매치
     */
    // 상세보기
    @GET("api/match")
    Maybe<Match> retrieveMatch(@Query("matchId")int matchId,
                                       @Header("Authorization")String userKey);

    //신청하기
    @POST("api/application")
    Maybe<ApplyResponse> sendMatchApply(@Header("Authorization")String userKey,
                                        @Body Apply apply);

    //지도 검색
    @GET("api/map/search")
    Maybe<List<MapResponse>> retrievePlace(@Query("keyword")String keyWord,
                                        @Header("Authorization") String userKey);
}
