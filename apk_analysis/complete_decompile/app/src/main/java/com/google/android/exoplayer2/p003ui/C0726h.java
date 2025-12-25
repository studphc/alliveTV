package com.google.android.exoplayer2.p003ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Util;
import p000.mp2;

/* renamed from: com.google.android.exoplayer2.ui.h */
/* loaded from: classes.dex */
public final class C0726h extends RecyclerView.ViewHolder {

    /* renamed from: t */
    public final TextView f12340t;

    /* renamed from: u */
    public final TextView f12341u;

    /* renamed from: v */
    public final ImageView f12342v;

    /* renamed from: w */
    public final /* synthetic */ StyledPlayerControlView f12343w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0726h(StyledPlayerControlView styledPlayerControlView, View view) {
        super(view);
        this.f12343w = styledPlayerControlView;
        if (Util.SDK_INT < 26) {
            view.setFocusable(true);
        }
        this.f12340t = (TextView) view.findViewById(R.id.exo_main_text);
        this.f12341u = (TextView) view.findViewById(R.id.exo_sub_text);
        this.f12342v = (ImageView) view.findViewById(R.id.exo_icon);
        view.setOnClickListener(new mp2(2, this));
    }
}
