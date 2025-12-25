package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.base.Objects;
import p000.t82;

/* loaded from: classes.dex */
public final class ThumbRating extends Rating {
    public static final Bundleable.Creator<ThumbRating> CREATOR = new t82(3);

    /* renamed from: a */
    public final boolean f9494a;

    /* renamed from: b */
    public final boolean f9495b;

    public ThumbRating() {
        this.f9494a = false;
        this.f9495b = false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        if (this.f9495b != thumbRating.f9495b || this.f9494a != thumbRating.f9494a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f9494a), Boolean.valueOf(this.f9495b));
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        return this.f9494a;
    }

    public boolean isThumbsUp() {
        return this.f9495b;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), 3);
        bundle.putBoolean(Integer.toString(1, 36), this.f9494a);
        bundle.putBoolean(Integer.toString(2, 36), this.f9495b);
        return bundle;
    }

    public ThumbRating(boolean z) {
        this.f9494a = true;
        this.f9495b = z;
    }
}
