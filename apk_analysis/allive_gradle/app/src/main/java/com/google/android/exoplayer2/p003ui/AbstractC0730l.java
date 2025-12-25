package com.google.android.exoplayer2.p003ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.AbstractC0730l;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import p000.pp2;

/* renamed from: com.google.android.exoplayer2.ui.l */
/* loaded from: classes.dex */
public abstract class AbstractC0730l extends RecyclerView.Adapter {

    /* renamed from: d */
    public List f12351d = new ArrayList();

    /* renamed from: e */
    public final /* synthetic */ StyledPlayerControlView f12352e;

    public AbstractC0730l(StyledPlayerControlView styledPlayerControlView) {
        this.f12352e = styledPlayerControlView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0728j c0728j, int i) {
        final Player player = this.f12352e.f12193O;
        if (player == null) {
            return;
        }
        if (i == 0) {
            mo2959b(c0728j);
            return;
        }
        boolean z = true;
        final pp2 pp2Var = (pp2) this.f12351d.get(i - 1);
        final TrackGroup mediaTrackGroup = pp2Var.f25254a.getMediaTrackGroup();
        int i2 = 0;
        if (player.getTrackSelectionParameters().overrides.get(mediaTrackGroup) == null || !pp2Var.f25254a.isTrackSelected(pp2Var.f25255b)) {
            z = false;
        }
        c0728j.f12348t.setText(pp2Var.f25256c);
        if (!z) {
            i2 = 4;
        }
        c0728j.f12349u.setVisibility(i2);
        c0728j.itemView.setOnClickListener(new View.OnClickListener() { // from class: qp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC0730l abstractC0730l = AbstractC0730l.this;
                abstractC0730l.getClass();
                Player player2 = player;
                TrackSelectionParameters.Builder buildUpon = player2.getTrackSelectionParameters().buildUpon();
                pp2 pp2Var2 = pp2Var;
                player2.setTrackSelectionParameters(buildUpon.setOverrideForType(new TrackSelectionOverride(mediaTrackGroup, ImmutableList.m3903of(Integer.valueOf(pp2Var2.f25255b)))).setTrackTypeDisabled(pp2Var2.f25254a.getType(), false).build());
                abstractC0730l.mo2960c(pp2Var2.f25256c);
                abstractC0730l.f12352e.f12227m0.dismiss();
            }
        });
    }

    /* renamed from: b */
    public abstract void mo2959b(C0728j c0728j);

    /* renamed from: c */
    public abstract void mo2960c(String str);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f12351d.isEmpty()) {
            return 0;
        }
        return this.f12351d.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0728j(LayoutInflater.from(this.f12352e.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
