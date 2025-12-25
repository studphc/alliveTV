package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class zzh extends Handler {
    public zzh() {
        Looper.getMainLooper();
    }

    public zzh(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }

    public zzh(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        Looper.getMainLooper();
    }
}
