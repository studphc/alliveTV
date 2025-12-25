package com.google.android.exoplayer2.p003ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.google.android.exoplayer2.ui.i */
/* loaded from: classes.dex */
public final class C0727i extends RecyclerView.Adapter {

    /* renamed from: d */
    public final String[] f12344d;

    /* renamed from: e */
    public final String[] f12345e;

    /* renamed from: f */
    public final Drawable[] f12346f;

    /* renamed from: g */
    public final /* synthetic */ StyledPlayerControlView f12347g;

    public C0727i(StyledPlayerControlView styledPlayerControlView, String[] strArr, Drawable[] drawableArr) {
        this.f12347g = styledPlayerControlView;
        this.f12344d = strArr;
        this.f12345e = new String[strArr.length];
        this.f12346f = drawableArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f12344d.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        C0726h c0726h = (C0726h) viewHolder;
        c0726h.f12340t.setText(this.f12344d[i]);
        String str = this.f12345e[i];
        TextView textView = c0726h.f12341u;
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        Drawable drawable = this.f12346f[i];
        ImageView imageView = c0726h.f12342v;
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        StyledPlayerControlView styledPlayerControlView = this.f12347g;
        return new C0726h(styledPlayerControlView, LayoutInflater.from(styledPlayerControlView.getContext()).inflate(R.layout.exo_styled_settings_list_item, viewGroup, false));
    }
}
