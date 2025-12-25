package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.i */
/* loaded from: classes.dex */
public final class C0344i extends AbstractC0336g {
    @Override // androidx.leanback.widget.AbstractC0336g, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        super.onBindViewHolder(viewHolder, obj);
        ((C0340h) viewHolder).f6300b.setText(((Action) obj).getLabel1());
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0340h(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_action_1_line, viewGroup, false), viewGroup.getLayoutDirection());
    }
}
