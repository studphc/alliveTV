package p000;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.collect.Ordering;

/* loaded from: classes.dex */
public final class o10 implements Spatializer$OnSpatializerStateChangedListener {

    /* renamed from: a */
    public final /* synthetic */ DefaultTrackSelector f23563a;

    public o10(DefaultTrackSelector defaultTrackSelector) {
        this.f23563a = defaultTrackSelector;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        DefaultTrackSelector defaultTrackSelector = this.f23563a;
        Ordering ordering = DefaultTrackSelector.f11888j;
        defaultTrackSelector.m2881c();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        DefaultTrackSelector defaultTrackSelector = this.f23563a;
        Ordering ordering = DefaultTrackSelector.f11888j;
        defaultTrackSelector.m2881c();
    }
}
