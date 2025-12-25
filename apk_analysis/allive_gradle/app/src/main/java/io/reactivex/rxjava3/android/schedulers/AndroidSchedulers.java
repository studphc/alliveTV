package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;
import p000.cz0;

/* loaded from: classes2.dex */
public final class AndroidSchedulers {

    /* renamed from: a */
    public static final Scheduler f18483a = RxAndroidPlugins.initMainThreadScheduler(new Object());

    public static Scheduler from(Looper looper) {
        return from(looper, true);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(f18483a);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler from(Looper looper, boolean z) {
        if (looper != null) {
            return new cz0(new Handler(looper), z);
        }
        throw new NullPointerException("looper == null");
    }
}
