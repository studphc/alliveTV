package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class LogTime {

    /* renamed from: a */
    public static final double f9171a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double getElapsedMillis(long j) {
        return (getLogTime() - j) * f9171a;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
