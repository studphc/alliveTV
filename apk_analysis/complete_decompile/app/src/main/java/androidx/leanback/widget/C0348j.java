package androidx.leanback.widget;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.j */
/* loaded from: classes.dex */
public final class C0348j extends AbstractC0336g {
    @Override // androidx.leanback.widget.AbstractC0336g, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        super.onBindViewHolder(viewHolder, obj);
        Action action = (Action) obj;
        C0340h c0340h = (C0340h) viewHolder;
        CharSequence label1 = action.getLabel1();
        CharSequence label2 = action.getLabel2();
        if (TextUtils.isEmpty(label1)) {
            c0340h.f6300b.setText(label2);
            return;
        }
        if (TextUtils.isEmpty(label2)) {
            c0340h.f6300b.setText(label1);
            return;
        }
        c0340h.f6300b.setText(((Object) label1) + "\n" + ((Object) label2));
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0340h(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_action_2_lines, viewGroup, false), viewGroup.getLayoutDirection());
    }
}
