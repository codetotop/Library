package com.justind.library.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class SourceChildrenDTO {
  @SerializedName("oid")
  private float mOid;
  @SerializedName("code")
  private String mCode;
  @SerializedName("count_child")
  private float mCountChild;
  @SerializedName("name")
  private String mName;
  @SerializedName("notes")
  private String mNotes;
  @SerializedName("status")
  private String mStatus;
  @SerializedName("address")
  private String mAddress;
  @SerializedName("catalog_name")
  private String mCatalogName;
  @SerializedName("exploiter_name")
  private String mExploiterName;
  @SerializedName("management_name")
  private String mManagementName;
  @SerializedName("old_supply_id")
  private String mOldSupplyId;
  @SerializedName("supply_id")
  private String mSupplyId;
  @SerializedName("location_id")
  private String mLocationId;
  @SerializedName("date_of_use")
  private String mDateOfUse;
  @SerializedName("date_of_expiration")
  private String mDateOfExpiration;
  @SerializedName("scheme_id")
  private String mSchemeId;
  @SerializedName("status_name")
  private String mStatusName;

  // Getter Methods

  public float getOid() {
    return mOid;
  }

  public void setOid(float oid) {
    this.mOid = oid;
  }

  public String getCode() {
    return mCode;
  }

  public void setCode(String code) {
    this.mCode = code;
  }

  public float getCountChild() {
    return mCountChild;
  }

  public void setCountChild(float countChild) {
    this.mCountChild = countChild;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public String getNotes() {
    return mNotes;
  }

  public void setNotes(String notes) {
    this.mNotes = notes;
  }

  public String getStatus() {
    return mStatus;
  }

  public void setStatus(String status) {
    this.mStatus = status;
  }

  public String getAddress() {
    return mAddress;
  }

  public void setAddress(String address) {
    this.mAddress = address;
  }

  public String getCatalogName() {
    return mCatalogName;
  }

  public void setCatalogName(String catalogName) {
    this.mCatalogName = catalogName;
  }

  public String getExploiterName() {
    return mExploiterName;
  }

  // Setter Methods

  public void setExploiterName(String exploiterName) {
    this.mExploiterName = exploiterName;
  }

  public String getManagementName() {
    return mManagementName;
  }

  public void setManagementName(String managementName) {
    this.mManagementName = managementName;
  }

  public String getOldSupplyId() {
    return mOldSupplyId;
  }

  public void setOldSupplyId(String oldSupplyId) {
    this.mOldSupplyId = oldSupplyId;
  }

  public String getSupplyId() {
    return mSupplyId;
  }

  public void setSupplyId(String supplyId) {
    this.mSupplyId = supplyId;
  }

  public String getLocationId() {
    return mLocationId;
  }

  public void setLocationId(String locationId) {
    this.mLocationId = locationId;
  }

  public String getDateOfUse() {
    return mDateOfUse;
  }

  public void setDateOfUse(String dateOfUse) {
    this.mDateOfUse = dateOfUse;
  }

  public String getDateOfExpiration() {
    return mDateOfExpiration;
  }

  public void setDateOfExpiration(String dateOfExpiration) {
    this.mDateOfExpiration = dateOfExpiration;
  }

  public String getSchemeId() {
    return mSchemeId;
  }

  public void setSchemeId(String schemeId) {
    this.mSchemeId = schemeId;
  }

  public String getStatusName() {
    return mStatusName;
  }

  public void setStatusName(String statusName) {
    this.mStatusName = statusName;
  }
}
