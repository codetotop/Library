package com.justind.codetotop.base.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<O> extends RecyclerView.ViewHolder {

  public BaseViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public abstract void binView(O item, int position);
}
