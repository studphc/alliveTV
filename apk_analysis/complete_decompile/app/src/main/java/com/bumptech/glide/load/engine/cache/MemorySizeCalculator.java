package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.util.Preconditions;
import p000.b01;

/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    /* renamed from: a */
    public final int f8726a;

    /* renamed from: b */
    public final int f8727b;

    /* renamed from: c */
    public final int f8728c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: i */
        public static final int f8729i;

        /* renamed from: a */
        public final Context f8730a;

        /* renamed from: b */
        public final ActivityManager f8731b;

        /* renamed from: c */
        public final b01 f8732c;

        /* renamed from: e */
        public float f8734e;

        /* renamed from: d */
        public float f8733d = 2.0f;

        /* renamed from: f */
        public float f8735f = 0.4f;

        /* renamed from: g */
        public float f8736g = 0.33f;

        /* renamed from: h */
        public int f8737h = 4194304;

        static {
            int i;
            if (Build.VERSION.SDK_INT < 26) {
                i = 4;
            } else {
                i = 1;
            }
            f8729i = i;
        }

        public Builder(Context context) {
            this.f8734e = f8729i;
            this.f8730a = context;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            this.f8731b = activityManager;
            this.f8732c = new b01(25, context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && activityManager.isLowRamDevice()) {
                this.f8734e = RecyclerView.f7068F0;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setArrayPoolSize(int i) {
            this.f8737h = i;
            return this;
        }

        public Builder setBitmapPoolScreens(float f) {
            boolean z;
            if (f >= RecyclerView.f7068F0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Bitmap pool screens must be greater than or equal to 0");
            this.f8734e = f;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            boolean z;
            if (f >= RecyclerView.f7068F0 && f <= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Low memory max size multiplier must be between 0 and 1");
            this.f8736g = f;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f) {
            boolean z;
            if (f >= RecyclerView.f7068F0 && f <= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Size multiplier must be between 0 and 1");
            this.f8735f = f;
            return this;
        }

        public Builder setMemoryCacheScreens(float f) {
            boolean z;
            if (f >= RecyclerView.f7068F0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Memory cache screens must be greater than or equal to 0");
            this.f8733d = f;
            return this;
        }
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        boolean z;
        Context context = builder.f8730a;
        ActivityManager activityManager = builder.f8731b;
        if (activityManager.isLowRamDevice()) {
            i = builder.f8737h / 2;
        } else {
            i = builder.f8737h;
        }
        this.f8728c = i;
        int round = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? builder.f8736g : builder.f8735f));
        DisplayMetrics displayMetrics = (DisplayMetrics) builder.f8732c.f7833b;
        float f = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int round2 = Math.round(builder.f8734e * f);
        int round3 = Math.round(f * builder.f8733d);
        int i2 = round - i;
        int i3 = round3 + round2;
        if (i3 <= i2) {
            this.f8727b = round3;
            this.f8726a = round2;
        } else {
            float f2 = i2;
            float f3 = builder.f8734e;
            float f4 = builder.f8733d;
            float f5 = f2 / (f3 + f4);
            this.f8727b = Math.round(f4 * f5);
            this.f8726a = Math.round(f5 * builder.f8734e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(Formatter.formatFileSize(context, this.f8727b));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(context, this.f8726a));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(context, i));
            sb.append(", memory class limited? ");
            if (i3 > round) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(context, round));
            sb.append(", memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(activityManager.isLowRamDevice());
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public int getArrayPoolSizeInBytes() {
        return this.f8728c;
    }

    public int getBitmapPoolSize() {
        return this.f8726a;
    }

    public int getMemoryCacheSize() {
        return this.f8727b;
    }
}
