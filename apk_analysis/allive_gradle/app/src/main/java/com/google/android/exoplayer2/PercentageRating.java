package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;
import p000.ee0;

/* loaded from: classes.dex */
public final class PercentageRating extends Rating {
    public static final Bundleable.Creator<PercentageRating> CREATOR = new ee0(24);

    /* renamed from: a */
    public final float f9469a;

    public PercentageRating() {
        this.f9469a = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PercentageRating)) {
            return false;
        }
        if (this.f9469a != ((PercentageRating) obj).f9469a) {
            return false;
        }
        return true;
    }

    public float getPercent() {
        return this.f9469a;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f9469a));
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        if (this.f9469a != -1.0f) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.toString(0, 36), 1);
        bundle.putFloat(Integer.toString(1, 36), this.f9469a);
        return bundle;
    }

    public PercentageRating(@FloatRange(from = 0.0d, m152to = 100.0d) float f) {
        Assertions.checkArgument(f >= RecyclerView.f7068F0 && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.f9469a = f;
    }
}
