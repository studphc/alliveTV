package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_IMAGE_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;

    /* renamed from: a */
    public final DefaultAllocator f9290a;

    /* renamed from: b */
    public final long f9291b;

    /* renamed from: c */
    public final long f9292c;

    /* renamed from: d */
    public final long f9293d;

    /* renamed from: e */
    public final long f9294e;

    /* renamed from: f */
    public final int f9295f;

    /* renamed from: g */
    public final boolean f9296g;

    /* renamed from: h */
    public final long f9297h;

    /* renamed from: i */
    public final boolean f9298i;

    /* renamed from: j */
    public int f9299j;

    /* renamed from: k */
    public boolean f9300k;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public DefaultAllocator f9301a;

        /* renamed from: b */
        public int f9302b = 50000;

        /* renamed from: c */
        public int f9303c = 50000;

        /* renamed from: d */
        public int f9304d = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;

        /* renamed from: e */
        public int f9305e = 5000;

        /* renamed from: f */
        public int f9306f = -1;

        /* renamed from: g */
        public boolean f9307g = false;

        /* renamed from: h */
        public int f9308h = 0;

        /* renamed from: i */
        public boolean f9309i = false;

        /* renamed from: j */
        public boolean f9310j;

        public DefaultLoadControl build() {
            Assertions.checkState(!this.f9310j);
            this.f9310j = true;
            if (this.f9301a == null) {
                this.f9301a = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.f9301a, this.f9302b, this.f9303c, this.f9304d, this.f9305e, this.f9306f, this.f9307g, this.f9308h, this.f9309i);
        }

        @Deprecated
        public DefaultLoadControl createDefaultLoadControl() {
            return build();
        }

        public Builder setAllocator(DefaultAllocator defaultAllocator) {
            Assertions.checkState(!this.f9310j);
            this.f9301a = defaultAllocator;
            return this;
        }

        public Builder setBackBuffer(int i, boolean z) {
            Assertions.checkState(!this.f9310j);
            DefaultLoadControl.m2413a(i, "backBufferDurationMs", "0", 0);
            this.f9308h = i;
            this.f9309i = z;
            return this;
        }

        public Builder setBufferDurationsMs(int i, int i2, int i3, int i4) {
            Assertions.checkState(!this.f9310j);
            DefaultLoadControl.m2413a(i3, "bufferForPlaybackMs", "0", 0);
            DefaultLoadControl.m2413a(i4, "bufferForPlaybackAfterRebufferMs", "0", 0);
            DefaultLoadControl.m2413a(i, "minBufferMs", "bufferForPlaybackMs", i3);
            DefaultLoadControl.m2413a(i, "minBufferMs", "bufferForPlaybackAfterRebufferMs", i4);
            DefaultLoadControl.m2413a(i2, "maxBufferMs", "minBufferMs", i);
            this.f9302b = i;
            this.f9303c = i2;
            this.f9304d = i3;
            this.f9305e = i4;
            return this;
        }

        public Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            Assertions.checkState(!this.f9310j);
            this.f9307g = z;
            return this;
        }

        public Builder setTargetBufferBytes(int i) {
            Assertions.checkState(!this.f9310j);
            this.f9306f = i;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, false, 0, false);
    }

    /* renamed from: a */
    public static void m2413a(int i, String str, String str2, int i2) {
        boolean z;
        if (i >= i2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z, str + " cannot be less than " + str2);
    }

    /* renamed from: b */
    public final void m2414b(boolean z) {
        int i = this.f9295f;
        if (i == -1) {
            i = 13107200;
        }
        this.f9299j = i;
        this.f9300k = false;
        if (z) {
            this.f9290a.reset();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0014. Please report as an issue. */
    public int calculateTargetBufferBytes(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 13107200;
            if (i < rendererArr.length) {
                if (exoTrackSelectionArr[i] != null) {
                    switch (rendererArr[i].getTrackType()) {
                        case -2:
                            i3 = 0;
                            i2 += i3;
                            break;
                        case -1:
                        default:
                            throw new IllegalArgumentException();
                        case 0:
                            i3 = DEFAULT_MUXED_BUFFER_SIZE;
                            i2 += i3;
                            break;
                        case 1:
                            i2 += i3;
                            break;
                        case 2:
                            i3 = DEFAULT_VIDEO_BUFFER_SIZE;
                            i2 += i3;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            i3 = 131072;
                            i2 += i3;
                            break;
                    }
                }
                i++;
            } else {
                return Math.max(13107200, i2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.f9290a;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.f9297h;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        m2414b(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        m2414b(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        m2414b(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i = this.f9295f;
        if (i == -1) {
            i = calculateTargetBufferBytes(rendererArr, exoTrackSelectionArr);
        }
        this.f9299j = i;
        this.f9290a.setTargetBufferSize(i);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.f9298i;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j, long j2, float f) {
        boolean z;
        boolean z2 = true;
        if (this.f9290a.getTotalBytesAllocated() >= this.f9299j) {
            z = true;
        } else {
            z = false;
        }
        long j3 = this.f9292c;
        long j4 = this.f9291b;
        if (f > 1.0f) {
            j4 = Math.min(Util.getMediaDurationForPlayoutDuration(j4, f), j3);
        }
        if (j2 < Math.max(j4, 500000L)) {
            if (!this.f9296g && z) {
                z2 = false;
            }
            this.f9300k = z2;
            if (!z2 && j2 < 500000) {
                Log.m3027w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= j3 || z) {
            this.f9300k = false;
        }
        return this.f9300k;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, float f, boolean z, long j2) {
        long j3;
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j, f);
        if (z) {
            j3 = this.f9294e;
        } else {
            j3 = this.f9293d;
        }
        if (j2 != C0643C.TIME_UNSET) {
            j3 = Math.min(j2 / 2, j3);
        }
        if (j3 > 0 && playoutDurationForMediaDuration < j3 && (this.f9296g || this.f9290a.getTotalBytesAllocated() < this.f9299j)) {
            return false;
        }
        return true;
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        m2413a(i3, "bufferForPlaybackMs", "0", 0);
        m2413a(i4, "bufferForPlaybackAfterRebufferMs", "0", 0);
        m2413a(i, "minBufferMs", "bufferForPlaybackMs", i3);
        m2413a(i, "minBufferMs", "bufferForPlaybackAfterRebufferMs", i4);
        m2413a(i2, "maxBufferMs", "minBufferMs", i);
        m2413a(i6, "backBufferDurationMs", "0", 0);
        this.f9290a = defaultAllocator;
        this.f9291b = Util.msToUs(i);
        this.f9292c = Util.msToUs(i2);
        this.f9293d = Util.msToUs(i3);
        this.f9294e = Util.msToUs(i4);
        this.f9295f = i5;
        this.f9299j = i5 == -1 ? 13107200 : i5;
        this.f9296g = z;
        this.f9297h = Util.msToUs(i6);
        this.f9298i = z2;
    }
}
