package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.base.Objects;
import p000.ee0;

/* loaded from: classes.dex */
public final class HeartRating extends Rating {
    public static final Bundleable.Creator<HeartRating> CREATOR = new ee0(6);

    /* renamed from: a */
    public final boolean f9386a;

    /* renamed from: b */
    public final boolean f9387b;

    public HeartRating() {
        this.f9386a = false;
        this.f9387b = false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        if (this.f9387b != heartRating.f9387b || this.f9386a != heartRating.f9386a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f9386a), Boolean.valueOf(this.f9387b));
    }

    public boolean isHeart() {
        return this.f9387b;
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        return this.f9386a;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), 0);
        bundle.putBoolean(Integer.toString(1, 36), this.f9386a);
        bundle.putBoolean(Integer.toString(2, 36), this.f9387b);
        return bundle;
    }

    public HeartRating(boolean z) {
        this.f9386a = true;
        this.f9387b = z;
    }
}
