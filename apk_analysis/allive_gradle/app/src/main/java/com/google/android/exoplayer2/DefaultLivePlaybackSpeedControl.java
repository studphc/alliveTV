package com.google.android.exoplayer2;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Longs;

/* loaded from: classes.dex */
public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {
    public static final float DEFAULT_FALLBACK_MAX_PLAYBACK_SPEED = 1.03f;
    public static final float DEFAULT_FALLBACK_MIN_PLAYBACK_SPEED = 0.97f;
    public static final long DEFAULT_MAX_LIVE_OFFSET_ERROR_MS_FOR_UNIT_SPEED = 20;
    public static final float DEFAULT_MIN_POSSIBLE_LIVE_OFFSET_SMOOTHING_FACTOR = 0.999f;
    public static final long DEFAULT_MIN_UPDATE_INTERVAL_MS = 1000;
    public static final float DEFAULT_PROPORTIONAL_CONTROL_FACTOR = 0.1f;
    public static final long DEFAULT_TARGET_LIVE_OFFSET_INCREMENT_ON_REBUFFER_MS = 500;

    /* renamed from: a */
    public final float f9264a;

    /* renamed from: b */
    public final float f9265b;

    /* renamed from: c */
    public final long f9266c;

    /* renamed from: d */
    public final float f9267d;

    /* renamed from: e */
    public final long f9268e;

    /* renamed from: f */
    public final long f9269f;

    /* renamed from: g */
    public final float f9270g;

    /* renamed from: n */
    public float f9277n;

    /* renamed from: o */
    public float f9278o;

    /* renamed from: h */
    public long f9271h = C0643C.TIME_UNSET;

    /* renamed from: i */
    public long f9272i = C0643C.TIME_UNSET;

    /* renamed from: k */
    public long f9274k = C0643C.TIME_UNSET;

    /* renamed from: l */
    public long f9275l = C0643C.TIME_UNSET;

    /* renamed from: p */
    public float f9279p = 1.0f;

    /* renamed from: q */
    public long f9280q = C0643C.TIME_UNSET;

    /* renamed from: j */
    public long f9273j = C0643C.TIME_UNSET;

    /* renamed from: m */
    public long f9276m = C0643C.TIME_UNSET;

    /* renamed from: r */
    public long f9281r = C0643C.TIME_UNSET;

    /* renamed from: s */
    public long f9282s = C0643C.TIME_UNSET;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public float f9283a = 0.97f;

        /* renamed from: b */
        public float f9284b = 1.03f;

        /* renamed from: c */
        public long f9285c = 1000;

        /* renamed from: d */
        public float f9286d = 1.0E-7f;

        /* renamed from: e */
        public long f9287e = Util.msToUs(20);

        /* renamed from: f */
        public long f9288f = Util.msToUs(500);

        /* renamed from: g */
        public float f9289g = 0.999f;

        public DefaultLivePlaybackSpeedControl build() {
            return new DefaultLivePlaybackSpeedControl(this.f9283a, this.f9284b, this.f9285c, this.f9286d, this.f9287e, this.f9288f, this.f9289g);
        }

        public Builder setFallbackMaxPlaybackSpeed(float f) {
            boolean z;
            if (f >= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9284b = f;
            return this;
        }

        public Builder setFallbackMinPlaybackSpeed(float f) {
            boolean z;
            if (RecyclerView.f7068F0 < f && f <= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9283a = f;
            return this;
        }

        public Builder setMaxLiveOffsetErrorMsForUnitSpeed(long j) {
            boolean z;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9287e = Util.msToUs(j);
            return this;
        }

        public Builder setMinPossibleLiveOffsetSmoothingFactor(float f) {
            boolean z;
            if (f >= RecyclerView.f7068F0 && f < 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9289g = f;
            return this;
        }

        public Builder setMinUpdateIntervalMs(long j) {
            boolean z;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9285c = j;
            return this;
        }

        public Builder setProportionalControlFactor(float f) {
            boolean z;
            if (f > RecyclerView.f7068F0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9286d = f / 1000000.0f;
            return this;
        }

        public Builder setTargetLiveOffsetIncrementOnRebufferMs(long j) {
            boolean z;
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9288f = Util.msToUs(j);
            return this;
        }
    }

    public DefaultLivePlaybackSpeedControl(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.f9264a = f;
        this.f9265b = f2;
        this.f9266c = j;
        this.f9267d = f3;
        this.f9268e = j2;
        this.f9269f = j3;
        this.f9270g = f4;
        this.f9278o = f;
        this.f9277n = f2;
    }

    /* renamed from: a */
    public final void m2412a() {
        long j = this.f9271h;
        if (j != C0643C.TIME_UNSET) {
            long j2 = this.f9272i;
            if (j2 != C0643C.TIME_UNSET) {
                j = j2;
            }
            long j3 = this.f9274k;
            if (j3 != C0643C.TIME_UNSET && j < j3) {
                j = j3;
            }
            long j4 = this.f9275l;
            if (j4 != C0643C.TIME_UNSET && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.f9273j == j) {
            return;
        }
        this.f9273j = j;
        this.f9276m = j;
        this.f9281r = C0643C.TIME_UNSET;
        this.f9282s = C0643C.TIME_UNSET;
        this.f9280q = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public float getAdjustedPlaybackSpeed(long j, long j2) {
        if (this.f9271h == C0643C.TIME_UNSET) {
            return 1.0f;
        }
        long j3 = j - j2;
        long j4 = this.f9281r;
        if (j4 == C0643C.TIME_UNSET) {
            this.f9281r = j3;
            this.f9282s = 0L;
        } else {
            float f = (float) j4;
            float f2 = 1.0f - this.f9270g;
            this.f9281r = Math.max(j3, (((float) j3) * f2) + (f * r7));
            this.f9282s = (f2 * ((float) Math.abs(j3 - r9))) + (r7 * ((float) this.f9282s));
        }
        long j5 = this.f9280q;
        long j6 = this.f9266c;
        if (j5 != C0643C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f9280q < j6) {
            return this.f9279p;
        }
        this.f9280q = SystemClock.elapsedRealtime();
        long j7 = (this.f9282s * 3) + this.f9281r;
        long j8 = this.f9276m;
        float f3 = this.f9267d;
        if (j8 > j7) {
            float msToUs = (float) Util.msToUs(j6);
            this.f9276m = Longs.max(j7, this.f9273j, this.f9276m - (((this.f9279p - 1.0f) * msToUs) + ((this.f9277n - 1.0f) * msToUs)));
        } else {
            long constrainValue = Util.constrainValue(j - (Math.max(RecyclerView.f7068F0, this.f9279p - 1.0f) / f3), this.f9276m, j7);
            this.f9276m = constrainValue;
            long j9 = this.f9275l;
            if (j9 != C0643C.TIME_UNSET && constrainValue > j9) {
                this.f9276m = j9;
            }
        }
        long j10 = j - this.f9276m;
        if (Math.abs(j10) < this.f9268e) {
            this.f9279p = 1.0f;
        } else {
            this.f9279p = Util.constrainValue((f3 * ((float) j10)) + 1.0f, this.f9278o, this.f9277n);
        }
        return this.f9279p;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public long getTargetLiveOffsetUs() {
        return this.f9276m;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void notifyRebuffer() {
        long j = this.f9276m;
        if (j == C0643C.TIME_UNSET) {
            return;
        }
        long j2 = j + this.f9269f;
        this.f9276m = j2;
        long j3 = this.f9275l;
        if (j3 != C0643C.TIME_UNSET && j2 > j3) {
            this.f9276m = j3;
        }
        this.f9280q = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void setLiveConfiguration(MediaItem.LiveConfiguration liveConfiguration) {
        this.f9271h = Util.msToUs(liveConfiguration.targetOffsetMs);
        this.f9274k = Util.msToUs(liveConfiguration.minOffsetMs);
        this.f9275l = Util.msToUs(liveConfiguration.maxOffsetMs);
        float f = liveConfiguration.minPlaybackSpeed;
        if (f == -3.4028235E38f) {
            f = this.f9264a;
        }
        this.f9278o = f;
        float f2 = liveConfiguration.maxPlaybackSpeed;
        if (f2 == -3.4028235E38f) {
            f2 = this.f9265b;
        }
        this.f9277n = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.f9271h = C0643C.TIME_UNSET;
        }
        m2412a();
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void setTargetLiveOffsetOverrideUs(long j) {
        this.f9272i = j;
        m2412a();
    }
}
