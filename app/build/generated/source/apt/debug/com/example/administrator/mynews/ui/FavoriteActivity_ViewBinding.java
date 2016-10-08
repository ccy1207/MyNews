// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class FavoriteActivity_ViewBinding<T extends FavoriteActivity> implements Unbinder {
  protected T target;

  public FavoriteActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.recy = finder.findRequiredViewAsType(source, R.id.favorite, "field 'recy'", RecyclerView.class);
    target.toolbar = finder.findRequiredViewAsType(source, R.id.favorite_tb, "field 'toolbar'", Toolbar.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recy = null;
    target.toolbar = null;

    this.target = null;
  }
}
