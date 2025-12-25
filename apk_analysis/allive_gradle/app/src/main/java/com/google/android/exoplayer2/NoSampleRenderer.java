package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import p000.pa2;
import p000.qa2;

/* loaded from: classes.dex */
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {

    /* renamed from: a */
    public RendererConfiguration f9464a;

    /* renamed from: b */
    public int f9465b;

    /* renamed from: c */
    public int f9466c;

    /* renamed from: d */
    public SampleStream f9467d;

    /* renamed from: e */
    public boolean f9468e;

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        boolean z = true;
        if (this.f9466c != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.f9466c = 0;
        this.f9467d = null;
        this.f9468e = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) {
        boolean z3;
        if (this.f9466c == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.checkState(z3);
        this.f9464a = rendererConfiguration;
        this.f9466c = 1;
        onEnabled(z);
        replaceStream(formatArr, sampleStream, j2, j3);
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Nullable
    public final RendererConfiguration getConfiguration() {
        return this.f9464a;
    }

    public final int getIndex() {
        return this.f9465b;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.f9466c;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public final SampleStream getStream() {
        return this.f9467d;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return -2;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void init(int i, PlayerId playerId) {
        this.f9465b = i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.f9468e;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z) {
    }

    public void onPositionReset(long j, boolean z) {
    }

    public void onRendererOffsetChanged(long j) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2) {
        Assertions.checkState(!this.f9468e);
        this.f9467d = sampleStream;
        onRendererOffsetChanged(j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        boolean z;
        if (this.f9466c == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) {
        this.f9468e = false;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.f9468e = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final /* synthetic */ void setPlaybackSpeed(float f, float f2) {
        pa2.m6898a(this, f, f2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() {
        boolean z = true;
        if (this.f9466c != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.f9466c = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        boolean z;
        if (this.f9466c == 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f9466c = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        return qa2.m7011a(0);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}
