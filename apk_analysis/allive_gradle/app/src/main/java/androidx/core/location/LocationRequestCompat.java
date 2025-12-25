package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.AbstractC1267hf;
import p000.AbstractC1726qj;
import p000.o63;
import p000.od1;

/* loaded from: classes.dex */
public final class LocationRequestCompat {
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;

    /* renamed from: a */
    public final int f3681a;

    /* renamed from: b */
    public final long f3682b;

    /* renamed from: c */
    public final long f3683c;

    /* renamed from: d */
    public final long f3684d;

    /* renamed from: e */
    public final int f3685e;

    /* renamed from: f */
    public final float f3686f;

    /* renamed from: g */
    public final long f3687g;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface Quality {
    }

    public LocationRequestCompat(long j, int i, long j2, int i2, long j3, float f, long j4) {
        this.f3682b = j;
        this.f3681a = i;
        this.f3683c = j3;
        this.f3684d = j2;
        this.f3685e = i2;
        this.f3686f = f;
        this.f3687g = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        if (this.f3681a == locationRequestCompat.f3681a && this.f3682b == locationRequestCompat.f3682b && this.f3683c == locationRequestCompat.f3683c && this.f3684d == locationRequestCompat.f3684d && this.f3685e == locationRequestCompat.f3685e && Float.compare(locationRequestCompat.f3686f, this.f3686f) == 0 && this.f3687g == locationRequestCompat.f3687g) {
            return true;
        }
        return false;
    }

    @IntRange(from = 1)
    public long getDurationMillis() {
        return this.f3684d;
    }

    @IntRange(from = 0)
    public long getIntervalMillis() {
        return this.f3682b;
    }

    @IntRange(from = 0)
    public long getMaxUpdateDelayMillis() {
        return this.f3687g;
    }

    @IntRange(from = 1, m153to = 2147483647L)
    public int getMaxUpdates() {
        return this.f3685e;
    }

    @FloatRange(from = 0.0d, m152to = 3.4028234663852886E38d)
    public float getMinUpdateDistanceMeters() {
        return this.f3686f;
    }

    @IntRange(from = 0)
    public long getMinUpdateIntervalMillis() {
        long j = this.f3683c;
        if (j == -1) {
            return this.f3682b;
        }
        return j;
    }

    public int getQuality() {
        return this.f3681a;
    }

    public int hashCode() {
        int i = this.f3681a * 31;
        long j = this.f3682b;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f3683c;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    @NonNull
    @RequiresApi(31)
    public LocationRequest toLocationRequest() {
        return od1.m6562a(this);
    }

    @NonNull
    public String toString() {
        StringBuilder m7064t = AbstractC1726qj.m7064t("Request[");
        long j = this.f3682b;
        if (j != Long.MAX_VALUE) {
            m7064t.append("@");
            TimeUtils.formatDuration(j, m7064t);
            int i = this.f3681a;
            if (i != 100) {
                if (i != 102) {
                    if (i == 104) {
                        m7064t.append(" LOW_POWER");
                    }
                } else {
                    m7064t.append(" BALANCED");
                }
            } else {
                m7064t.append(" HIGH_ACCURACY");
            }
        } else {
            m7064t.append("PASSIVE");
        }
        long j2 = this.f3684d;
        if (j2 != Long.MAX_VALUE) {
            m7064t.append(", duration=");
            TimeUtils.formatDuration(j2, m7064t);
        }
        int i2 = this.f3685e;
        if (i2 != Integer.MAX_VALUE) {
            m7064t.append(", maxUpdates=");
            m7064t.append(i2);
        }
        long j3 = this.f3683c;
        if (j3 != -1 && j3 < j) {
            m7064t.append(", minUpdateInterval=");
            TimeUtils.formatDuration(j3, m7064t);
        }
        float f = this.f3686f;
        if (f > 0.0d) {
            m7064t.append(", minUpdateDistance=");
            m7064t.append(f);
        }
        long j4 = this.f3687g;
        if (j4 / 2 > j) {
            m7064t.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(j4, m7064t);
        }
        m7064t.append(']');
        return m7064t.toString();
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public LocationRequest toLocationRequest(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        Object obj = null;
        try {
            if (o63.f23625g == null) {
                o63.f23625g = Class.forName("android.location.LocationRequest");
            }
            if (o63.f23626h == null) {
                Method declaredMethod = o63.f23625g.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                o63.f23626h = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = o63.f23626h.invoke(null, str, Long.valueOf(getIntervalMillis()), Float.valueOf(getMinUpdateDistanceMeters()), Boolean.FALSE);
            if (invoke != null) {
                if (o63.f23627i == null) {
                    Method declaredMethod2 = o63.f23625g.getDeclaredMethod("setQuality", Integer.TYPE);
                    o63.f23627i = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                o63.f23627i.invoke(invoke, Integer.valueOf(getQuality()));
                if (o63.f23628j == null) {
                    Method declaredMethod3 = o63.f23625g.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    o63.f23628j = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                o63.f23628j.invoke(invoke, Long.valueOf(getMinUpdateIntervalMillis()));
                if (getMaxUpdates() < Integer.MAX_VALUE) {
                    if (o63.f23629k == null) {
                        Method declaredMethod4 = o63.f23625g.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        o63.f23629k = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    o63.f23629k.invoke(invoke, Integer.valueOf(getMaxUpdates()));
                }
                if (getDurationMillis() < Long.MAX_VALUE) {
                    if (o63.f23630l == null) {
                        Method declaredMethod5 = o63.f23625g.getDeclaredMethod("setExpireIn", Long.TYPE);
                        o63.f23630l = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    o63.f23630l.invoke(invoke, Long.valueOf(getDurationMillis()));
                }
                obj = invoke;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return AbstractC1267hf.m5063d(obj);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public long f3688a;

        /* renamed from: b */
        public int f3689b;

        /* renamed from: c */
        public long f3690c;

        /* renamed from: d */
        public int f3691d;

        /* renamed from: e */
        public long f3692e;

        /* renamed from: f */
        public float f3693f;

        /* renamed from: g */
        public long f3694g;

        public Builder(long j) {
            setIntervalMillis(j);
            this.f3689b = 102;
            this.f3690c = Long.MAX_VALUE;
            this.f3691d = Integer.MAX_VALUE;
            this.f3692e = -1L;
            this.f3693f = RecyclerView.f7068F0;
            this.f3694g = 0L;
        }

        @NonNull
        public LocationRequestCompat build() {
            boolean z;
            if (this.f3688a == Long.MAX_VALUE && this.f3692e == -1) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z, "passive location requests must have an explicit minimum update interval");
            long j = this.f3688a;
            return new LocationRequestCompat(j, this.f3689b, this.f3690c, this.f3691d, Math.min(this.f3692e, j), this.f3693f, this.f3694g);
        }

        @NonNull
        public Builder clearMinUpdateIntervalMillis() {
            this.f3692e = -1L;
            return this;
        }

        @NonNull
        public Builder setDurationMillis(@IntRange(from = 1) long j) {
            this.f3690c = Preconditions.checkArgumentInRange(j, 1L, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(@IntRange(from = 0) long j) {
            this.f3688a = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long j) {
            this.f3694g = j;
            this.f3694g = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(@IntRange(from = 1, m153to = 2147483647L) int i) {
            this.f3691d = Preconditions.checkArgumentInRange(i, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, m152to = 3.4028234663852886E38d) float f) {
            this.f3693f = f;
            this.f3693f = Preconditions.checkArgumentInRange(f, RecyclerView.f7068F0, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long j) {
            this.f3692e = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int i) {
            boolean z;
            if (i != 104 && i != 102 && i != 100) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i));
            this.f3689b = i;
            return this;
        }

        public Builder(@NonNull LocationRequestCompat locationRequestCompat) {
            this.f3688a = locationRequestCompat.f3682b;
            this.f3689b = locationRequestCompat.f3681a;
            this.f3690c = locationRequestCompat.f3684d;
            this.f3691d = locationRequestCompat.f3685e;
            this.f3692e = locationRequestCompat.f3683c;
            this.f3693f = locationRequestCompat.f3686f;
            this.f3694g = locationRequestCompat.f3687g;
        }
    }
}
