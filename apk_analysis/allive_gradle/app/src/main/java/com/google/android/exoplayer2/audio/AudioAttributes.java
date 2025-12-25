package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import p000.AbstractC1793sc;
import p000.AbstractC1830tc;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class AudioAttributes implements Bundleable {

    /* renamed from: a */
    public AudioAttributesV21 f9637a;
    public final int allowedCapturePolicy;
    public final int contentType;
    public final int flags;
    public final int spatializationBehavior;
    public final int usage;
    public static final AudioAttributes DEFAULT = new Builder().build();
    public static final Bundleable.Creator<AudioAttributes> CREATOR = new C1255h3(6);

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class AudioAttributesV21 {
        public final android.media.AudioAttributes audioAttributes;

        public AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.contentType).setFlags(audioAttributes.flags).setUsage(audioAttributes.usage);
            int i = Util.SDK_INT;
            if (i >= 29) {
                AbstractC1793sc.m7355a(usage, audioAttributes.allowedCapturePolicy);
            }
            if (i >= 32) {
                AbstractC1830tc.m7477a(usage, audioAttributes.spatializationBehavior);
            }
            this.audioAttributes = usage.build();
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public int f9638a = 0;

        /* renamed from: b */
        public int f9639b = 0;

        /* renamed from: c */
        public int f9640c = 1;

        /* renamed from: d */
        public int f9641d = 1;

        /* renamed from: e */
        public int f9642e = 0;

        public AudioAttributes build() {
            return new AudioAttributes(this.f9638a, this.f9639b, this.f9640c, this.f9641d, this.f9642e);
        }

        public Builder setAllowedCapturePolicy(int i) {
            this.f9641d = i;
            return this;
        }

        public Builder setContentType(int i) {
            this.f9638a = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.f9639b = i;
            return this;
        }

        public Builder setSpatializationBehavior(int i) {
            this.f9642e = i;
            return this;
        }

        public Builder setUsage(int i) {
            this.f9640c = i;
            return this;
        }
    }

    public AudioAttributes(int i, int i2, int i3, int i4, int i5) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
        this.spatializationBehavior = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy && this.spatializationBehavior == audioAttributes.spatializationBehavior) {
            return true;
        }
        return false;
    }

    @RequiresApi(21)
    public AudioAttributesV21 getAudioAttributesV21() {
        if (this.f9637a == null) {
            this.f9637a = new AudioAttributesV21(this);
        }
        return this.f9637a;
    }

    public int hashCode() {
        return ((((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy) * 31) + this.spatializationBehavior;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), this.contentType);
        bundle.putInt(Integer.toString(1, 36), this.flags);
        bundle.putInt(Integer.toString(2, 36), this.usage);
        bundle.putInt(Integer.toString(3, 36), this.allowedCapturePolicy);
        bundle.putInt(Integer.toString(4, 36), this.spatializationBehavior);
        return bundle;
    }
}
