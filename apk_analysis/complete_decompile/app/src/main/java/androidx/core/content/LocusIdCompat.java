package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import p000.xy0;

/* loaded from: classes.dex */
public final class LocusIdCompat {

    /* renamed from: a */
    public final String f3563a;

    /* renamed from: b */
    public final LocusId f3564b;

    public LocusIdCompat(@NonNull String str) {
        this.f3563a = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3564b = xy0.m8196b(str);
        } else {
            this.f3564b = null;
        }
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(xy0.m8198d(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        String str = ((LocusIdCompat) obj).f3563a;
        String str2 = this.f3563a;
        if (str2 == null) {
            if (str == null) {
                return true;
            }
            return false;
        }
        return str2.equals(str);
    }

    @NonNull
    public String getId() {
        return this.f3563a;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f3563a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.f3564b;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LocusIdCompat[");
        sb.append(this.f3563a.length() + "_chars");
        sb.append("]");
        return sb.toString();
    }
}
