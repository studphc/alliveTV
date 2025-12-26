package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import p000.t82;

/* loaded from: classes.dex */
public final class VideoSize implements Bundleable {

    @IntRange(from = 0)
    public final int height;

    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float pixelWidthHeightRatio;

    @IntRange(from = 0, m153to = 359)
    public final int unappliedRotationDegrees;

    @IntRange(from = 0)
    public final int width;
    public static final VideoSize UNKNOWN = new VideoSize(0, 0);
    public static final Bundleable.Creator<VideoSize> CREATOR = new t82(21);

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this(i, i2, 0, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.width == videoSize.width && this.height == videoSize.height && this.unappliedRotationDegrees == videoSize.unappliedRotationDegrees && this.pixelWidthHeightRatio == videoSize.pixelWidthHeightRatio) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.pixelWidthHeightRatio) + ((((((217 + this.width) * 31) + this.height) * 31) + this.unappliedRotationDegrees) * 31);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), this.width);
        bundle.putInt(Integer.toString(1, 36), this.height);
        bundle.putInt(Integer.toString(2, 36), this.unappliedRotationDegrees);
        bundle.putFloat(Integer.toString(3, 36), this.pixelWidthHeightRatio);
        return bundle;
    }

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, m153to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.width = i;
        this.height = i2;
        this.unappliedRotationDegrees = i3;
        this.pixelWidthHeightRatio = f;
    }
}
