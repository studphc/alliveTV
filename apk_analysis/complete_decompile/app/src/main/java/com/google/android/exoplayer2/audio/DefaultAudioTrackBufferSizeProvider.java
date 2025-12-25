package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public class DefaultAudioTrackBufferSizeProvider implements InterfaceC0649c {
    public final int ac3BufferMultiplicationFactor;
    protected final int maxPcmBufferDurationUs;
    protected final int minPcmBufferDurationUs;
    protected final int offloadBufferDurationUs;
    protected final int passthroughBufferDurationUs;
    protected final int pcmBufferMultiplicationFactor;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public int f9746a = 250000;

        /* renamed from: b */
        public int f9747b = 750000;

        /* renamed from: c */
        public int f9748c = 4;

        /* renamed from: d */
        public int f9749d = 250000;

        /* renamed from: e */
        public int f9750e = 50000000;

        /* renamed from: f */
        public int f9751f = 2;

        public DefaultAudioTrackBufferSizeProvider build() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }

        public Builder setAc3BufferMultiplicationFactor(int i) {
            this.f9751f = i;
            return this;
        }

        public Builder setMaxPcmBufferDurationUs(int i) {
            this.f9747b = i;
            return this;
        }

        public Builder setMinPcmBufferDurationUs(int i) {
            this.f9746a = i;
            return this;
        }

        public Builder setOffloadBufferDurationUs(int i) {
            this.f9750e = i;
            return this;
        }

        public Builder setPassthroughBufferDurationUs(int i) {
            this.f9749d = i;
            return this;
        }

        public Builder setPcmBufferMultiplicationFactor(int i) {
            this.f9748c = i;
            return this;
        }
    }

    public DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.minPcmBufferDurationUs = builder.f9746a;
        this.maxPcmBufferDurationUs = builder.f9747b;
        this.pcmBufferMultiplicationFactor = builder.f9748c;
        this.passthroughBufferDurationUs = builder.f9749d;
        this.offloadBufferDurationUs = builder.f9750e;
        this.ac3BufferMultiplicationFactor = builder.f9751f;
    }

    public static int durationUsToBytes(int i, int i2, int i3) {
        return Ints.checkedCast(((i * i2) * i3) / 1000000);
    }

    public static int getMaximumEncodedRateBytesPerSecond(int i) {
        switch (i) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
            case 18:
                return Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
            case 11:
                return AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            case 12:
                return AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
        }
    }

    public int get1xBufferSizeInBytes(int i, int i2, int i3, int i4, int i5) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return getPassthroughBufferSizeInBytes(i2);
                }
                throw new IllegalArgumentException();
            }
            return getOffloadBufferSizeInBytes(i2);
        }
        return getPcmBufferSizeInBytes(i, i5, i4);
    }

    @Override // com.google.android.exoplayer2.audio.InterfaceC0649c
    public int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, double d) {
        return (((Math.max(i, (int) (get1xBufferSizeInBytes(i, i2, i3, i4, i5) * d)) + i4) - 1) / i4) * i4;
    }

    public int getOffloadBufferSizeInBytes(int i) {
        return Ints.checkedCast((this.offloadBufferDurationUs * getMaximumEncodedRateBytesPerSecond(i)) / 1000000);
    }

    public int getPassthroughBufferSizeInBytes(int i) {
        int i2 = this.passthroughBufferDurationUs;
        if (i == 5) {
            i2 *= this.ac3BufferMultiplicationFactor;
        }
        return Ints.checkedCast((i2 * getMaximumEncodedRateBytesPerSecond(i)) / 1000000);
    }

    public int getPcmBufferSizeInBytes(int i, int i2, int i3) {
        return Util.constrainValue(i * this.pcmBufferMultiplicationFactor, durationUsToBytes(this.minPcmBufferDurationUs, i2, i3), durationUsToBytes(this.maxPcmBufferDurationUs, i2, i3));
    }
}
