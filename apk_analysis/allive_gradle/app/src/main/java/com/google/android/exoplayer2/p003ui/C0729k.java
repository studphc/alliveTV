package com.google.android.exoplayer2.p003ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import p000.mp2;
import p000.pp2;

/* renamed from: com.google.android.exoplayer2.ui.k */
/* loaded from: classes.dex */
public final class C0729k extends AbstractC0730l {

    /* renamed from: f */
    public final /* synthetic */ StyledPlayerControlView f12350f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0729k(StyledPlayerControlView styledPlayerControlView) {
        super(styledPlayerControlView);
        this.f12350f = styledPlayerControlView;
    }

    @Override // com.google.android.exoplayer2.p003ui.AbstractC0730l, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(C0728j c0728j, int i) {
        int i2;
        super.onBindViewHolder(c0728j, i);
        if (i > 0) {
            pp2 pp2Var = (pp2) this.f12351d.get(i - 1);
            View view = c0728j.f12349u;
            if (pp2Var.f25254a.isTrackSelected(pp2Var.f25255b)) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            view.setVisibility(i2);
        }
    }

    @Override // com.google.android.exoplayer2.p003ui.AbstractC0730l
    /* renamed from: b */
    public final void mo2959b(C0728j c0728j) {
        c0728j.f12348t.setText(R.string.exo_track_selection_none);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f12351d.size()) {
                break;
            }
            pp2 pp2Var = (pp2) this.f12351d.get(i2);
            if (pp2Var.f25254a.isTrackSelected(pp2Var.f25255b)) {
                i = 4;
                break;
            }
            i2++;
        }
        c0728j.f12349u.setVisibility(i);
        c0728j.itemView.setOnClickListener(new mp2(3, this));
    }

    @Override // com.google.android.exoplayer2.p003ui.AbstractC0730l
    /* renamed from: c */
    public final void mo2960c(String str) {
    }

    /* renamed from: d */
    public final void m2963d(List list) {
        Drawable drawable;
        String str;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            pp2 pp2Var = (pp2) list.get(i);
            if (pp2Var.f25254a.isTrackSelected(pp2Var.f25255b)) {
                z = true;
                break;
            }
            i++;
        }
        StyledPlayerControlView styledPlayerControlView = this.f12350f;
        ImageView imageView = styledPlayerControlView.f12239s0;
        if (imageView != null) {
            if (z) {
                drawable = styledPlayerControlView.f12185G;
            } else {
                drawable = styledPlayerControlView.f12186H;
            }
            imageView.setImageDrawable(drawable);
            ImageView imageView2 = styledPlayerControlView.f12239s0;
            if (z) {
                str = styledPlayerControlView.f12187I;
            } else {
                str = styledPlayerControlView.f12188J;
            }
            imageView2.setContentDescription(str);
        }
        this.f12351d = list;
    }
}
