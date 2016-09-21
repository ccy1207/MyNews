// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.video;

import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class VideoItemView_ViewBinding<T extends VideoItemView> implements Unbinder {
  protected T target;

  private View view2131558597;

  private View view2131558599;

  private View view2131558596;

  public VideoItemView_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    view = finder.findRequiredView(source, R.id.textureView, "field 'textureView' and method 'stopPlayer'");
    target.textureView = finder.castView(view, R.id.textureView, "field 'textureView'", TextureView.class);
    view2131558597 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.stopPlayer();
      }
    });
    view = finder.findRequiredView(source, R.id.ivPreview, "field 'ivPreview' and method 'startPlay'");
    target.ivPreview = finder.castView(view, R.id.ivPreview, "field 'ivPreview'", ImageView.class);
    view2131558599 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startPlay();
      }
    });
    target.tvNewsTitle = finder.findRequiredViewAsType(source, R.id.tvNewsTitle, "field 'tvNewsTitle'", TextView.class);
    view = finder.findRequiredView(source, R.id.tvCreatedAt, "field 'tvCreatedAt' and method 'simple'");
    target.tvCreatedAt = finder.castView(view, R.id.tvCreatedAt, "field 'tvCreatedAt'", TextView.class);
    view2131558596 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.simple();
      }
    });
    target.progressBar = finder.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.ivPlay = finder.findRequiredViewAsType(source, R.id.ivPlay, "field 'ivPlay'", ImageView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.textureView = null;
    target.ivPreview = null;
    target.tvNewsTitle = null;
    target.tvCreatedAt = null;
    target.progressBar = null;
    target.ivPlay = null;

    view2131558597.setOnClickListener(null);
    view2131558597 = null;
    view2131558599.setOnClickListener(null);
    view2131558599 = null;
    view2131558596.setOnClickListener(null);
    view2131558596 = null;

    this.target = null;
  }
}
