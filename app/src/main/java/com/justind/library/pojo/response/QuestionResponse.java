package com.justind.library.pojo.response;

import com.google.gson.annotations.SerializedName;
import com.justind.library.pojo.business_model.QuestionDTO;

import java.util.List;

public class QuestionResponse {
  @SerializedName("items")
  private List<QuestionDTO> mQuestionDTOS;

  public List<QuestionDTO> getQuestionDTOS() {
    return mQuestionDTOS;
  }

  public void setQuestionDTOS(List<QuestionDTO> questionDTOS) {
    mQuestionDTOS = questionDTOS;
  }
}
