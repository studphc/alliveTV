package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class TrackSelector {

    /* renamed from: a */
    public InvalidationListener f11955a;

    /* renamed from: b */
    public BandwidthMeter f11956b;

    /* loaded from: classes.dex */
    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public final BandwidthMeter getBandwidthMeter() {
        return (BandwidthMeter) Assertions.checkStateNotNull(this.f11956b);
    }

    public TrackSelectionParameters getParameters() {
        return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
    }

    @CallSuper
    public void init(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f11955a = invalidationListener;
        this.f11956b = bandwidthMeter;
    }

    public final void invalidate() {
        InvalidationListener invalidationListener = this.f11955a;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }

    public boolean isSetParametersSupported() {
        return false;
    }

    public abstract void onSelectionActivated(@Nullable Object obj);

    @CallSuper
    public void release() {
        this.f11955a = null;
        this.f11956b = null;
    }

    public abstract TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);

    public void setAudioAttributes(AudioAttributes audioAttributes) {
    }

    public void setParameters(TrackSelectionParameters trackSelectionParameters) {
    }
}
