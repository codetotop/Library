package com.justind.library.webservice.content;

import com.justind.library.pojo.business_model.AnswerDTO;
import com.justind.library.pojo.business_model.QuestionDTO;
import com.justind.library.pojo.business_model.SearchDTO;
import com.justind.library.pojo.business_model.SourceInformationPersonnelDTO;
import com.justind.library.pojo.response.BaseStackOverFlowResponse;
import com.justind.library.pojo.response.SourceChildrenResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProjectService {
  @POST("assets")
  @FormUrlEncoded
  Single<SourceChildrenResponse> fetchSourceChildrenList(@Field("page_num") int pageNum,
                                                         @Field("page_size") int pageSize,
                                                         @Field("company_id") String companyId,
                                                         @Field("organization_id") String organizationId,
                                                         @Field("parent_id") String parentId,
                                                         @Field("dmz_dma") String dmzDma);

  @POST("asset/personnel")
  @FormUrlEncoded
  Single<List<SourceInformationPersonnelDTO>> fetchSourceInformationPersonnel(@Field("asset_id") String assetId,
                                                                              @Field("organization_id") String organizationId,
                                                                              @Field("company_id") String companyId);

  @GET("2.2/questions")
  Single<BaseStackOverFlowResponse<QuestionDTO>> fetchQuestionList(@Query("order") String oder,
                                                                   @Query("sort") String sort,
                                                                   @Query("tagged") String tagged,
                                                                   @Query("site") String site);

  @GET("2.2/answers")
  Single<BaseStackOverFlowResponse<AnswerDTO>> fetchAnswersList(@Query("order") String order,
                                                                @Query("sort") String sort,
                                                                @Query("site") String site);

  @GET("2.2/search")
  Single<BaseStackOverFlowResponse<SearchDTO>> fetchSearchList(@Query("order") String oder,
                                                               @Query("sort") String sort,
                                                               @Query("tagged") String tagged,
                                                               @Query("site") String site);

}
