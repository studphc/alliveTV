package androidx.leanback.widget;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.t */
/* loaded from: classes.dex */
public final class C0387t extends Presenter {

    /* renamed from: b */
    public final int f6413b;

    public C0387t(int i) {
        this.f6413b = i;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        CharSequence label2;
        Action action = (Action) obj;
        C0383s c0383s = (C0383s) viewHolder;
        c0383s.f6408b.setImageDrawable(action.getIcon());
        TextView textView = c0383s.f6409c;
        if (textView != null) {
            if (action.getIcon() == null) {
                textView.setText(action.getLabel1());
            } else {
                textView.setText((CharSequence) null);
            }
        }
        if (TextUtils.isEmpty(action.getLabel2())) {
            label2 = action.getLabel1();
        } else {
            label2 = action.getLabel2();
        }
        View view = c0383s.f6410d;
        if (!TextUtils.equals(view.getContentDescription(), label2)) {
            view.setContentDescription(label2);
            view.sendAccessibilityEvent(32768);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0383s(LayoutInflater.from(viewGroup.getContext()).inflate(this.f6413b, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        C0383s c0383s = (C0383s) viewHolder;
        c0383s.f6408b.setImageDrawable(null);
        TextView textView = c0383s.f6409c;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        c0383s.f6410d.setContentDescription(null);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void setOnClickListener(Presenter.ViewHolder viewHolder, View.OnClickListener onClickListener) {
        ((C0383s) viewHolder).f6410d.setOnClickListener(onClickListener);
    }
}
