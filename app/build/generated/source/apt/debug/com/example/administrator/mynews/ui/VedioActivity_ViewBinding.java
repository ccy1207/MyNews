// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.ui;

import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import com.example.videoplayer.part.SimpleVideoView;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class VedioActivity_ViewBinding<T extends VedioActivity> implements Unbinder {
  protected T target;

  public VedioActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mVideoView = finder.findRequiredViewAsType(source, R.id.video_simple, "field 'mVideoView'", SimpleVideoView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mVideoView = null;

    this.target = null;
  }
}
