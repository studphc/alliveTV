package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TrackSelectionArray {

    /* renamed from: a */
    public final TrackSelection[] f11927a;

    /* renamed from: b */
    public int f11928b;
    public final int length;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.f11927a = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackSelectionArray.class == obj.getClass()) {
            return Arrays.equals(this.f11927a, ((TrackSelectionArray) obj).f11927a);
        }
        return false;
    }

    @Nullable
    public TrackSelection get(int i) {
        return this.f11927a[i];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[]) this.f11927a.clone();
    }

    public int hashCode() {
        if (this.f11928b == 0) {
            this.f11928b = 527 + Arrays.hashCode(this.f11927a);
        }
        return this.f11928b;
    }
}
