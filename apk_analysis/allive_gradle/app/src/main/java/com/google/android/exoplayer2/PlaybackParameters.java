package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.ee0;

/* loaded from: classes.dex */
public final class PlaybackParameters implements Bundleable {

    /* renamed from: a */
    public final int f9470a;
    public final float pitch;
    public final float speed;
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public static final Bundleable.Creator<PlaybackParameters> CREATOR = new ee0(26);

    public PlaybackParameters(float f) {
        this(f, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
            return true;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * this.f9470a;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.pitch) + ((Float.floatToRawIntBits(this.speed) + 527) * 31);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(Integer.toString(0, 36), this.speed);
        bundle.putFloat(Integer.toString(1, 36), this.pitch);
        return bundle;
    }

    public String toString() {
        return Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.speed), Float.valueOf(this.pitch));
    }

    @CheckResult
    public PlaybackParameters withSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        return new PlaybackParameters(f, this.pitch);
    }

    public PlaybackParameters(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        Assertions.checkArgument(f > RecyclerView.f7068F0);
        Assertions.checkArgument(f2 > RecyclerView.f7068F0);
        this.speed = f;
        this.pitch = f2;
        this.f9470a = Math.round(f * 1000.0f);
    }
}
