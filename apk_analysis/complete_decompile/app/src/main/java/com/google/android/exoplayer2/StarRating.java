package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;
import p000.t82;

/* loaded from: classes.dex */
public final class StarRating extends Rating {
    public static final Bundleable.Creator<StarRating> CREATOR = new t82(2);

    /* renamed from: a */
    public final int f9492a;

    /* renamed from: b */
    public final float f9493b;

    public StarRating(@IntRange(from = 1) int i) {
        Assertions.checkArgument(i > 0, "maxStars must be a positive integer");
        this.f9492a = i;
        this.f9493b = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        if (this.f9492a != starRating.f9492a || this.f9493b != starRating.f9493b) {
            return false;
        }
        return true;
    }

    @IntRange(from = 1)
    public int getMaxStars() {
        return this.f9492a;
    }

    public float getStarRating() {
        return this.f9493b;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f9492a), Float.valueOf(this.f9493b));
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        if (this.f9493b != -1.0f) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), 2);
        bundle.putInt(Integer.toString(1, 36), this.f9492a);
        bundle.putFloat(Integer.toString(2, 36), this.f9493b);
        return bundle;
    }

    public StarRating(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        boolean z = false;
        Assertions.checkArgument(i > 0, "maxStars must be a positive integer");
        if (f >= RecyclerView.f7068F0 && f <= i) {
            z = true;
        }
        Assertions.checkArgument(z, "starRating is out of range [0, maxStars]");
        this.f9492a = i;
        this.f9493b = f;
    }
}
