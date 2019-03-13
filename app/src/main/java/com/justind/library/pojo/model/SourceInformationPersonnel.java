package com.justind.library.pojo.model;

import com.justind.library.pojo.business_model.SourceInformationPersonnelDTO;

public class SourceInformationPersonnel {
  private String mAssetId;
  private String mDepartmentName;
  private String mUserAssign;
  private String mRole;
  private String mDateStart;
  private String mDateEnd;


  public SourceInformationPersonnel() {
  }

  public SourceInformationPersonnel(String assetId, String departmentName, String userAssign, String role, String dateStart, String dateEnd) {
    mAssetId = assetId;
    mDepartmentName = departmentName;
    mUserAssign = userAssign;
    mRole = role;
    mDateStart = dateStart;
    mDateEnd = dateEnd;
  }


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

  public void convert(SourceInformationPersonnelDTO personnelDTO) {
    mAssetId = personnelDTO.getAssetId();
    mDepartmentName = personnelDTO.getDepartmentName();
    mUserAssign = personnelDTO.getUserAssign();
    mRole = personnelDTO.getRole();
    mDateStart = personnelDTO.getDateStart();
    mDateEnd = personnelDTO.getDateEnd();
  }
}
