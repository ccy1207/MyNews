// Generated code from Butter Knife. Do not modify!
package com.example.administrator.mynews.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.example.administrator.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SimpleVideoActivity_ViewBinding<T extends SimpleVideoActivity> implements Unbinder {
  protected T target;

  private View view2131558541;

  private View view2131558542;

  public SimpleVideoActivity_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mSimpleEv = finder.findRequiredViewAsType(source, R.id.simple_ev, "field 'mSimpleEv'", EditText.class);
    view = finder.findRequiredView(source, R.id.simple_send, "field 'mSimpleSend' and method 'onClick'");
    target.mSimpleSend = finder.castView(view, R.id.simple_send, "field 'mSimpleSend'", Button.class);
    view2131558541 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.simple_dan, "field 'mSimpleDan' and method 'onClick'");
    target.mSimpleDan = finder.castView(view, R.id.simple_dan, "field 'mSimpleDan'", Button.class);
    view2131558542 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mSimpleEv = null;
    target.mSimpleSend = null;
    target.mSimpleDan = null;

    view2131558541.setOnClickListener(null);
    view2131558541 = null;
    view2131558542.setOnClickListener(null);
    view2131558542 = null;

    this.target = null;
  }
}
