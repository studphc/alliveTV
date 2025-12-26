package com.google.android.exoplayer2.p003ui;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.p003ui.TrackSelectionDialogBuilder;
import com.google.android.exoplayer2.p003ui.TrackSelectionView;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import p000.fb0;
import p000.fv2;

/* loaded from: classes.dex */
public final class TrackSelectionDialogBuilder {

    /* renamed from: a */
    public final Context f12290a;

    /* renamed from: b */
    public final CharSequence f12291b;

    /* renamed from: c */
    public final AbstractCollection f12292c;

    /* renamed from: d */
    public final DialogCallback f12293d;

    /* renamed from: e */
    public int f12294e;

    /* renamed from: f */
    public boolean f12295f;

    /* renamed from: g */
    public boolean f12296g;

    /* renamed from: h */
    public boolean f12297h;

    /* renamed from: i */
    public TrackNameProvider f12298i;

    /* renamed from: j */
    public boolean f12299j;

    /* renamed from: k */
    public Map f12300k;

    /* renamed from: l */
    public Comparator f12301l;

    /* loaded from: classes.dex */
    public interface DialogCallback {
        void onTracksSelected(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, List<Tracks.Group> list, DialogCallback dialogCallback) {
        this.f12290a = context;
        this.f12291b = charSequence;
        this.f12292c = ImmutableList.copyOf((Collection) list);
        this.f12293d = dialogCallback;
        this.f12300k = Collections.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [fv2] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractCollection, java.util.List] */
    /* renamed from: a */
    public final fv2 m2954a(View view) {
        final TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.f12296g);
        trackSelectionView.setAllowAdaptiveSelections(this.f12295f);
        trackSelectionView.setShowDisableOption(this.f12297h);
        TrackNameProvider trackNameProvider = this.f12298i;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.init(this.f12292c, this.f12299j, this.f12300k, this.f12301l, null);
        return new DialogInterface.OnClickListener() { // from class: fv2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                TrackSelectionDialogBuilder trackSelectionDialogBuilder = TrackSelectionDialogBuilder.this;
                trackSelectionDialogBuilder.getClass();
                TrackSelectionView trackSelectionView2 = trackSelectionView;
                trackSelectionDialogBuilder.f12293d.onTracksSelected(trackSelectionView2.getIsDisabled(), trackSelectionView2.getOverrides());
            }
        };
    }

    public Dialog build() {
        Dialog dialog;
        CharSequence charSequence = this.f12291b;
        Context context = this.f12290a;
        try {
            Class cls = Integer.TYPE;
            Object newInstance = AlertDialog.Builder.class.getConstructor(Context.class, cls).newInstance(context, Integer.valueOf(this.f12294e));
            View inflate = LayoutInflater.from((Context) AlertDialog.Builder.class.getMethod("getContext", null).invoke(newInstance, null)).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            fv2 m2954a = m2954a(inflate);
            AlertDialog.Builder.class.getMethod("setTitle", CharSequence.class).invoke(newInstance, charSequence);
            AlertDialog.Builder.class.getMethod("setView", View.class).invoke(newInstance, inflate);
            AlertDialog.Builder.class.getMethod("setPositiveButton", cls, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(R.string.ok), m2954a);
            AlertDialog.Builder.class.getMethod("setNegativeButton", cls, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(R.string.cancel), null);
            dialog = (Dialog) AlertDialog.Builder.class.getMethod("create", null).invoke(newInstance, null);
        } catch (ClassNotFoundException unused) {
            dialog = null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        if (dialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, this.f12294e);
            View inflate2 = LayoutInflater.from(builder.getContext()).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            return builder.setTitle(charSequence).setView(inflate2).setPositiveButton(R.string.ok, m2954a(inflate2)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        }
        return dialog;
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.f12295f = z;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.f12296g = z;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.f12299j = z;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(@Nullable TrackSelectionOverride trackSelectionOverride) {
        Map<TrackGroup, TrackSelectionOverride> m3924of;
        if (trackSelectionOverride == null) {
            m3924of = Collections.emptyMap();
        } else {
            m3924of = ImmutableMap.m3924of(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
        }
        return setOverrides(m3924of);
    }

    public TrackSelectionDialogBuilder setOverrides(Map<TrackGroup, TrackSelectionOverride> map) {
        this.f12300k = map;
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.f12297h = z;
        return this;
    }

    public TrackSelectionDialogBuilder setTheme(@StyleRes int i) {
        this.f12294e = i;
        return this;
    }

    public void setTrackFormatComparator(@Nullable Comparator<Format> comparator) {
        this.f12301l = comparator;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(@Nullable TrackNameProvider trackNameProvider) {
        this.f12298i = trackNameProvider;
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.AbstractCollection, java.util.List] */
    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, Player player, int i) {
        this.f12290a = context;
        this.f12291b = charSequence;
        ImmutableList<Tracks.Group> groups = player.getCurrentTracks().getGroups();
        this.f12292c = new ArrayList();
        for (int i2 = 0; i2 < groups.size(); i2++) {
            Tracks.Group group = groups.get(i2);
            if (group.getType() == i) {
                this.f12292c.add(group);
            }
        }
        this.f12300k = Collections.emptyMap();
        this.f12293d = new fb0(i, player);
    }
}
