package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public final class PreFillType {

    /* renamed from: a */
    public final int f8767a;

    /* renamed from: b */
    public final int f8768b;

    /* renamed from: c */
    public final Bitmap.Config f8769c;

    /* renamed from: d */
    public final int f8770d;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final int f8771a;

        /* renamed from: b */
        public final int f8772b;

        /* renamed from: c */
        public Bitmap.Config f8773c;

        /* renamed from: d */
        public int f8774d;

        public Builder(int i) {
            this(i, i);
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.f8773c = config;
            return this;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.f8774d = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i, int i2) {
            this.f8774d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 > 0) {
                this.f8771a = i;
                this.f8772b = i2;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    static {
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.f8769c = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.f8767a = i;
        this.f8768b = i2;
        this.f8770d = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.f8768b != preFillType.f8768b || this.f8767a != preFillType.f8767a || this.f8770d != preFillType.f8770d || this.f8769c != preFillType.f8769c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f8769c.hashCode() + (((this.f8767a * 31) + this.f8768b) * 31)) * 31) + this.f8770d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f8767a + ", height=" + this.f8768b + ", config=" + this.f8769c + ", weight=" + this.f8770d + '}';
    }
}
