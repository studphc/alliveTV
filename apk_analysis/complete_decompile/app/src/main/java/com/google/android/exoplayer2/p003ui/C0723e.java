package com.google.android.exoplayer2.p003ui;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import p000.mp2;
import p000.pp2;

/* renamed from: com.google.android.exoplayer2.ui.e */
/* loaded from: classes.dex */
public final class C0723e extends AbstractC0730l {

    /* renamed from: f */
    public final /* synthetic */ StyledPlayerControlView f12334f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723e(StyledPlayerControlView styledPlayerControlView) {
        super(styledPlayerControlView);
        this.f12334f = styledPlayerControlView;
    }

    @Override // com.google.android.exoplayer2.p003ui.AbstractC0730l
    /* renamed from: b */
    public final void mo2959b(C0728j c0728j) {
        int i;
        c0728j.f12348t.setText(R.string.exo_track_selection_auto);
        if (m2961d(((Player) Assertions.checkNotNull(this.f12334f.f12193O)).getTrackSelectionParameters())) {
            i = 4;
        } else {
            i = 0;
        }
        c0728j.f12349u.setVisibility(i);
        c0728j.itemView.setOnClickListener(new mp2(1, this));
    }

    @Override // com.google.android.exoplayer2.p003ui.AbstractC0730l
    /* renamed from: c */
    public final void mo2960c(String str) {
        this.f12334f.f12223k0.f12345e[1] = str;
    }

    /* renamed from: d */
    public final boolean m2961d(TrackSelectionParameters trackSelectionParameters) {
        for (int i = 0; i < this.f12351d.size(); i++) {
            if (trackSelectionParameters.overrides.containsKey(((pp2) this.f12351d.get(i)).f25254a.getMediaTrackGroup())) {
                return true;
            }
        }
        return false;
    }
}
