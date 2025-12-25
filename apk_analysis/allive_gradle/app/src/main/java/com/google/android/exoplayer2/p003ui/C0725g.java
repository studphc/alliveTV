package com.google.android.exoplayer2.p003ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.p003ui.C0725g;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;

/* renamed from: com.google.android.exoplayer2.ui.g */
/* loaded from: classes.dex */
public final class C0725g extends RecyclerView.Adapter {

    /* renamed from: d */
    public final String[] f12336d;

    /* renamed from: e */
    public final float[] f12337e;

    /* renamed from: f */
    public int f12338f;

    /* renamed from: g */
    public final /* synthetic */ StyledPlayerControlView f12339g;

    public C0725g(StyledPlayerControlView styledPlayerControlView, String[] strArr, float[] fArr) {
        this.f12339g = styledPlayerControlView;
        this.f12336d = strArr;
        this.f12337e = fArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f12336d.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        C0728j c0728j = (C0728j) viewHolder;
        String[] strArr = this.f12336d;
        if (i < strArr.length) {
            c0728j.f12348t.setText(strArr[i]);
        }
        if (i == this.f12338f) {
            c0728j.itemView.setSelected(true);
            c0728j.f12349u.setVisibility(0);
        } else {
            c0728j.itemView.setSelected(false);
            c0728j.f12349u.setVisibility(4);
        }
        c0728j.itemView.setOnClickListener(new View.OnClickListener() { // from class: op2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0725g c0725g = C0725g.this;
                int i2 = c0725g.f12338f;
                int i3 = i;
                StyledPlayerControlView styledPlayerControlView = c0725g.f12339g;
                if (i3 != i2) {
                    styledPlayerControlView.setPlaybackSpeed(c0725g.f12337e[i3]);
                }
                styledPlayerControlView.f12227m0.dismiss();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0728j(LayoutInflater.from(this.f12339g.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
