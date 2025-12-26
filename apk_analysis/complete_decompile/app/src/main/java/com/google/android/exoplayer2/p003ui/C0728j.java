package com.google.android.exoplayer2.p003ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Util;

/* renamed from: com.google.android.exoplayer2.ui.j */
/* loaded from: classes.dex */
public final class C0728j extends RecyclerView.ViewHolder {

    /* renamed from: t */
    public final TextView f12348t;

    /* renamed from: u */
    public final View f12349u;

    public C0728j(View view) {
        super(view);
        if (Util.SDK_INT < 26) {
            view.setFocusable(true);
        }
        this.f12348t = (TextView) view.findViewById(R.id.exo_text);
        this.f12349u = view.findViewById(R.id.exo_check);
    }
}
