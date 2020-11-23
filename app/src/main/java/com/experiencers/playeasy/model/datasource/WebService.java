package com.experiencers.playeasy.model.datasource;


import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ApplyResponse;
import com.experiencers.playeasy.model.entity.ChangeMatchStatusRequest;
import com.experiencers.playeasy.model.entity.ChangeMatchStatusResponse;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.MapResponse;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.model.entity.ModifyMatchRequest;
import com.experiencers.playeasy.model.entity.User;
import com.experiencers.playeasy.model.entity.LoginRequest;
import com.experiencers.playeasy.model.entity.LoginResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    //작성하기
    //지도 검색
    @GET("api/map/search")
    Maybe<List<MapResponse>> retrievePlace(@Query("keyword")String keyWord,
                                           @Header("Authorization") String userKey);
    //작성하기
    @POST("api/match")
    Maybe<Match> sendCreateMatch(@Header("Authorization") String userKey,
                                 @Body CreateMatchRequest createMatchRequest);

    // 상세보기
    @GET("api/match")
    Maybe<Match> retrieveMatch(@Query("matchId")int matchId,
                                       @Header("Authorization")String userKey);

    //신청하기
    @POST("api/application")
    Maybe<ApplyResponse> sendMatchApply(@Header("Authorization")String userKey,
                                        @Body Apply apply);

    /** 나의매치 **/
    //내가 등록한 매치
    @GET("api/user/matches")
    Maybe<List<Match>> retrieveRegisterMatchList(@Header("Authorization")String userKey);

    //나의 신청현황
    @GET("api/user/applications")
    Maybe<List<Match>> retrieveApplyMatchList(@Query("type")String type,
                                              @Header("Authorization")String userKey);

    //나의 신청 현황 -> 취소하기
    @PUT("api/application")
    Maybe<Match> ModifyApplyStatus(@Header("Authorization")String userKey,
                                      @Body ChangeMatchStatusRequest changeMatchStatusRequest);

    /** 매치수정 **/
    //수정하기
    @PUT("api/match")
    Maybe<Match> modifyMatch(@Header("Authorization") String userKey,
                             @Body ModifyMatchRequest modifyMatchRequest);
}
