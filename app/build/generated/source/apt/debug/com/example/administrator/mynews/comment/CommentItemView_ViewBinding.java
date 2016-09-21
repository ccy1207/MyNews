// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.comment;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class CommentItemView_ViewBinding<T extends CommentItemView> implements Unbinder {
  protected T target;

  public CommentItemView_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mTvAuthor = finder.findRequiredViewAsType(source, R.id.tvAuthor, "field 'mTvAuthor'", TextView.class);
    target.mTvContent = finder.findRequiredViewAsType(source, R.id.tvContent, "field 'mTvContent'", TextView.class);
    target.mTvCreatedAt = finder.findRequiredViewAsType(source, R.id.tvCreatedAt, "field 'mTvCreatedAt'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvAuthor = null;
    target.mTvContent = null;
    target.mTvCreatedAt = null;

    this.target = null;
  }
}
