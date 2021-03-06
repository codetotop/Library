package com.justind.codetotop.base.pattern_mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.justind.codetotop.base.remote.ErrorHandler;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BaseFragmentContract.Presenter>
    extends Fragment implements BaseFragmentContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResourceID(), container, false);
    mUnbinder = ButterKnife.bind(this, view);
    return view;
  }

  protected abstract int getLayoutResourceID();

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Nullable
  @Override
  public Context getContext() {
    return getActivity();
  }

  @Override
  public void showError() {
    ErrorHandler errorHandler = ErrorHandler.getInstance();
    int error_code = errorHandler.getCode();
    String error_message = errorHandler.getMessage();
    Toast.makeText(getActivity(), error_code + ": " + error_message, Toast.LENGTH_SHORT).show();
  }

  protected void addOrReplaceChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_back_stack, String tag) {
    if (args != null)
      children_fragment.setArguments(args);
    FragmentManager manager = getChildFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(container_id, children_fragment, tag);
    if (add_to_back_stack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

  protected void addOrShowChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_back_stack, String tag) {
    FragmentManager manager = getChildFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    List<Fragment> fragments = manager.getFragments();
    if (fragments.isEmpty()) {
      addChildrenFragment(container_id, children_fragment, args, add_to_back_stack, tag);
    } else {
      Fragment fm = manager.findFragmentByTag(tag);
      for (Fragment fragment : fragments) {
        if (fragment != null && fragment != fm)
          transaction.hide(fragment);
      }
      if (fm != null)
        showChildrenFragment(fm);
      else {
        addChildrenFragment(container_id, children_fragment, args, add_to_back_stack, tag);
      }
    }
    transaction.commit();
  }

  protected void showChildrenFragment(Fragment children_fragment) {
    FragmentManager manager = getChildFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.show(children_fragment);
    transaction.commit();
  }

  protected void addChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_back_stack, String tag) {
    if (args != null)
      children_fragment.setArguments(args);
    FragmentManager manager = getChildFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(container_id, children_fragment, tag);
    if (add_to_back_stack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

}
