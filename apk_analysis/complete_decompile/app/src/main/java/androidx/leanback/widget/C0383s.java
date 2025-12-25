package androidx.leanback.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.s */
/* loaded from: classes.dex */
public final class C0383s extends Presenter.ViewHolder {

    /* renamed from: b */
    public final ImageView f6408b;

    /* renamed from: c */
    public final TextView f6409c;

    /* renamed from: d */
    public final View f6410d;

    public C0383s(View view) {
        super(view);
        this.f6408b = (ImageView) view.findViewById(androidx.leanback.R.id.icon);
        this.f6409c = (TextView) view.findViewById(androidx.leanback.R.id.label);
        this.f6410d = view.findViewById(androidx.leanback.R.id.button);
    }
}
