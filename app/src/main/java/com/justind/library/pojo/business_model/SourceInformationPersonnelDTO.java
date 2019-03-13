package com.justind.library.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class SourceInformationPersonnelDTO {

  @SerializedName("asset_id")
  private String mAssetId;
  @SerializedName("department_name")
  private String mDepartmentName;
  @SerializedName("user_assign")
  private String mUserAssign;
  @SerializedName("role")
  private String mRole;
  @SerializedName("date_start")
  private String mDateStart;
  @SerializedName("date_end")
  private String mDateEnd;

  // Getter Methods

  public String getAssetId() {
    return mAssetId;
  }

  public void setAssetId(String assetId) {
    this.mAssetId = assetId;
  }

  public String getDepartmentName() {
    return mDepartmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.mDepartmentName = departmentName;
  }

  public String getUserAssign() {
    return mUserAssign;
  }

  public void setUserAssign(String userAssign) {
    this.mUserAssign = userAssign;
  }

  // Setter Methods

  public String getRole() {
    return mRole;
  }

  public void setRole(String role) {
    this.mRole = role;
  }

  public String getDateStart() {
    return mDateStart;
  }

  public void setDateStart(String dateStart) {
    this.mDateStart = dateStart;
  }

  public String getDateEnd() {
    return mDateEnd;
  }

  public void setDateEnd(String dateEnd) {
    this.mDateEnd = dateEnd;
  }
}
