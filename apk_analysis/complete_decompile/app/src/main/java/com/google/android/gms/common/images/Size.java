package com.google.android.gms.common.images;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.ye0;

/* loaded from: classes.dex */
public final class Size {

    /* renamed from: a */
    public final int f13352a;

    /* renamed from: b */
    public final int f13353b;

    public Size(int i, int i2) {
        this.f13352a = i;
        this.f13353b = i2;
    }

    @NonNull
    public static Size parseSize(@NonNull String str) {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw new NumberFormatException(ye0.m8296p("Invalid Size: \"", str, "\""));
                }
            }
            throw new NumberFormatException(ye0.m8296p("Invalid Size: \"", str, "\""));
        }
        throw new IllegalArgumentException("string must not be null");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f13352a == size.f13352a && this.f13353b == size.f13353b) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f13353b;
    }

    public int getWidth() {
        return this.f13352a;
    }

    public int hashCode() {
        int i = this.f13352a;
        return ((i >>> 16) | (i << 16)) ^ this.f13353b;
    }

    @NonNull
    public String toString() {
        return this.f13352a + "x" + this.f13353b;
    }
}
