package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p000.mk2;

/* loaded from: classes.dex */
public final class SizeFCompat {

    /* renamed from: a */
    public final float f3831a;

    /* renamed from: b */
    public final float f3832b;

    public SizeFCompat(float f, float f2) {
        this.f3831a = Preconditions.checkArgumentFinite(f, "width");
        this.f3832b = Preconditions.checkArgumentFinite(f2, "height");
    }

    @NonNull
    @RequiresApi(21)
    public static SizeFCompat toSizeFCompat(@NonNull SizeF sizeF) {
        return mk2.m6180b(sizeF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        if (sizeFCompat.f3831a == this.f3831a && sizeFCompat.f3832b == this.f3832b) {
            return true;
        }
        return false;
    }

    public float getHeight() {
        return this.f3832b;
    }

    public float getWidth() {
        return this.f3831a;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f3831a) ^ Float.floatToIntBits(this.f3832b);
    }

    @NonNull
    @RequiresApi(21)
    public SizeF toSizeF() {
        return mk2.m6179a(this);
    }

    @NonNull
    public String toString() {
        return this.f3831a + "x" + this.f3832b;
    }
}
