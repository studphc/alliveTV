package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import p000.pa2;
import p000.qa2;

/* loaded from: classes.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {

    /* renamed from: a */
    public final int f9249a;

    /* renamed from: c */
    public RendererConfiguration f9251c;

    /* renamed from: d */
    public int f9252d;

    /* renamed from: e */
    public PlayerId f9253e;

    /* renamed from: f */
    public int f9254f;

    /* renamed from: g */
    public SampleStream f9255g;

    /* renamed from: h */
    public Format[] f9256h;

    /* renamed from: i */
    public long f9257i;

    /* renamed from: j */
    public long f9258j;

    /* renamed from: l */
    public boolean f9260l;

    /* renamed from: m */
    public boolean f9261m;

    /* renamed from: b */
    public final FormatHolder f9250b = new FormatHolder();

    /* renamed from: k */
    public long f9259k = Long.MIN_VALUE;

    public BaseRenderer(int i) {
        this.f9249a = i;
    }

    public final ExoPlaybackException createRendererException(Throwable th, @Nullable Format format, int i) {
        return createRendererException(th, format, false, i);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        boolean z = true;
        if (this.f9254f != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.f9250b.clear();
        this.f9254f = 0;
        this.f9255g = null;
        this.f9256h = null;
        this.f9260l = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) {
        boolean z3;
        if (this.f9254f == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.checkState(z3);
        this.f9251c = rendererConfiguration;
        this.f9254f = 1;
        onEnabled(z, z2);
        replaceStream(formatArr, sampleStream, j2, j3);
        this.f9260l = false;
        this.f9258j = j;
        this.f9259k = j;
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return (RendererConfiguration) Assertions.checkNotNull(this.f9251c);
    }

    public final FormatHolder getFormatHolder() {
        FormatHolder formatHolder = this.f9250b;
        formatHolder.clear();
        return formatHolder;
    }

    public final int getIndex() {
        return this.f9252d;
    }

    public final long getLastResetPositionUs() {
        return this.f9258j;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return null;
    }

    public final PlayerId getPlayerId() {
        return (PlayerId) Assertions.checkNotNull(this.f9253e);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.f9259k;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.f9254f;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public final SampleStream getStream() {
        return this.f9255g;
    }

    public final Format[] getStreamFormats() {
        return (Format[]) Assertions.checkNotNull(this.f9256h);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.f9249a;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        if (this.f9259k == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void init(int i, PlayerId playerId) {
        this.f9252d = i;
        this.f9253e = playerId;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.f9260l;
    }

    public final boolean isSourceReady() {
        if (hasReadStreamToEnd()) {
            return this.f9260l;
        }
        return ((SampleStream) Assertions.checkNotNull(this.f9255g)).isReady();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() {
        ((SampleStream) Assertions.checkNotNull(this.f9255g)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z, boolean z2) {
    }

    public void onPositionReset(long j, boolean z) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] formatArr, long j, long j2) {
    }

    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        int readData = ((SampleStream) Assertions.checkNotNull(this.f9255g)).readData(formatHolder, decoderInputBuffer, i);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.f9259k = Long.MIN_VALUE;
                if (this.f9260l) {
                    return -4;
                }
                return -3;
            }
            long j = decoderInputBuffer.timeUs + this.f9257i;
            decoderInputBuffer.timeUs = j;
            this.f9259k = Math.max(this.f9259k, j);
        } else if (readData == -5) {
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.f9257i).build();
            }
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2) {
        Assertions.checkState(!this.f9260l);
        this.f9255g = sampleStream;
        if (this.f9259k == Long.MIN_VALUE) {
            this.f9259k = j;
        }
        this.f9256h = formatArr;
        this.f9257i = j2;
        onStreamChanged(formatArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        boolean z;
        if (this.f9254f == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f9250b.clear();
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) {
        this.f9260l = false;
        this.f9258j = j;
        this.f9259k = j;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.f9260l = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public /* synthetic */ void setPlaybackSpeed(float f, float f2) {
        pa2.m6898a(this, f, f2);
    }

    public int skipSource(long j) {
        return ((SampleStream) Assertions.checkNotNull(this.f9255g)).skipData(j - this.f9257i);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() {
        boolean z = true;
        if (this.f9254f != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.f9254f = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        boolean z;
        if (this.f9254f == 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f9254f = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }

    public final ExoPlaybackException createRendererException(Throwable th, @Nullable Format format, boolean z, int i) {
        int i2;
        if (format != null && !this.f9261m) {
            this.f9261m = true;
            try {
                i2 = qa2.m7016f(supportsFormat(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.f9261m = false;
            }
            return ExoPlaybackException.createForRenderer(th, getName(), getIndex(), format, i2, z, i);
        }
        i2 = 4;
        return ExoPlaybackException.createForRenderer(th, getName(), getIndex(), format, i2, z, i);
    }
}
