// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.video;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class VideoListView_ViewBinding<T extends VideoListView> implements Unbinder {
  protected T target;

  public VideoListView_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mProgressBar = finder.findRequiredViewAsType(source, R.id.progressBar, "field 'mProgressBar'", ProgressBar.class);
    target.mRefreshLayout = finder.findRequiredViewAsType(source, R.id.refreshLayout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
    target.mRecyclerView = finder.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mProgressBar = null;
    target.mRefreshLayout = null;
    target.mRecyclerView = null;

    this.target = null;
  }
}
