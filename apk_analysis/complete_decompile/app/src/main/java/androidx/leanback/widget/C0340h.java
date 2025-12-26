package androidx.leanback.widget;

import android.view.View;
import android.widget.Button;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.h */
/* loaded from: classes.dex */
public final class C0340h extends Presenter.ViewHolder {

    /* renamed from: b */
    public final Button f6300b;

    /* renamed from: c */
    public final int f6301c;

    public C0340h(View view, int i) {
        super(view);
        this.f6300b = (Button) view.findViewById(androidx.leanback.R.id.lb_action_button);
        this.f6301c = i;
    }
}
