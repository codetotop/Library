package com.justind.library.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.justind.codetotop.base.pattern_mvp.activity.BaseActivity;
import com.justind.codetotop.base.utils.ImageUtils;
import com.justind.library.R;
import com.justind.library.screen.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {
  @BindView(R.id.btnGetStart)
  Button mBtnGetStart;
  @BindView(R.id.btnContinue)
  Button mBtnContinue;
  @BindView(R.id.tvSignIn)
  TextView mTvSignIn;
  @BindView(R.id.tvSignUp)
  TextView mTvSignUp;
  @BindView(R.id.edtUserName)
  EditText mEdtUserName;
  @BindView(R.id.edtEmail)
  EditText mEdtEmail;
  @BindView(R.id.edtPassWord)
  EditText mEdtPassWord;
  @BindView(R.id.tvForgotPassWord)
  TextView mTvForgotPassword;
  @BindView(R.id.tvTermsAndConditions)
  TextView mTvTermsAndConditions;
  @BindView(R.id.imgBgLogin)
  SimpleDraweeView mImgBgLogin;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.activity_login;
  }

  @Override
  public LoginContract.Presenter createPresenter() {
    return new LoginPresenter();
  }

  @Override
  protected void initView() {
    ImageUtils.loadBlurImage(mImgBgLogin, R.drawable.bg_login, 8);
    setViewForSignInScreen();
  }

  @OnClick({R.id.btnContinue, R.id.btnGetStart})
  void openHomeActivity() {
    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.tvSignIn)
  void signIn() {
    setViewForSignInScreen();
    mEdtEmail.setVisibility(View.GONE);
    mTvForgotPassword.setVisibility(View.VISIBLE);
    mTvTermsAndConditions.setVisibility(View.GONE);
    mBtnContinue.setVisibility(View.VISIBLE);
    mBtnGetStart.setVisibility(View.GONE);
  }

  @OnClick(R.id.tvSignUp)
  void signUp() {
    setViewForSignUpScreen();
    mEdtEmail.setVisibility(View.VISIBLE);
    mTvForgotPassword.setVisibility(View.GONE);
    mTvTermsAndConditions.setVisibility(View.VISIBLE);
    mBtnContinue.setVisibility(View.GONE);
    mBtnGetStart.setVisibility(View.VISIBLE);
  }

  public void setViewForSignInScreen() {
    mTvSignIn.setBackgroundResource(R.drawable.bg_view_sign_in);
    mTvSignIn.setTextColor(getResources().getColor(R.color.color_login_screen_btn));
    mTvSignUp.setBackgroundColor(getResources().getColor(R.color.color_transparent));
    mTvSignUp.setTextColor(getResources().getColor(R.color.colorWhite));
  }

  public void setViewForSignUpScreen(){
    mTvSignUp.setBackgroundResource(R.drawable.bg_view_sign_up);
    mTvSignUp.setTextColor(getResources().getColor(R.color.color_login_screen_btn));
    mTvSignIn.setBackgroundColor(getResources().getColor(R.color.color_transparent));
    mTvSignIn.setTextColor(getResources().getColor(R.color.colorWhite));
  }

}
