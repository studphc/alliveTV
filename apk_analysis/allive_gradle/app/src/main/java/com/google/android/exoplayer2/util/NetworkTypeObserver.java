package com.google.android.exoplayer2.util;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.C1150e9;
import p000.RunnableC0583c7;

/* loaded from: classes.dex */
public final class NetworkTypeObserver {

    /* renamed from: e */
    public static NetworkTypeObserver f12732e;

    /* renamed from: a */
    public final Handler f12733a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public final CopyOnWriteArrayList f12734b = new CopyOnWriteArrayList();

    /* renamed from: c */
    public final Object f12735c = new Object();

    /* renamed from: d */
    public int f12736d = 0;

    /* loaded from: classes.dex */
    public interface Listener {
        void onNetworkTypeChanged(int i);
    }

    public NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new C1150e9(2, this), intentFilter);
    }

    /* renamed from: a */
    public static void m3035a(NetworkTypeObserver networkTypeObserver, int i) {
        synchronized (networkTypeObserver.f12735c) {
            try {
                if (networkTypeObserver.f12736d != i) {
                    networkTypeObserver.f12736d = i;
                    Iterator it = networkTypeObserver.f12734b.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        Listener listener = (Listener) weakReference.get();
                        if (listener != null) {
                            listener.onNetworkTypeChanged(i);
                        } else {
                            networkTypeObserver.f12734b.remove(weakReference);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static synchronized NetworkTypeObserver getInstance(Context context) {
        NetworkTypeObserver networkTypeObserver;
        synchronized (NetworkTypeObserver.class) {
            try {
                if (f12732e == null) {
                    f12732e = new NetworkTypeObserver(context);
                }
                networkTypeObserver = f12732e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return networkTypeObserver;
    }

    @VisibleForTesting
    public static synchronized void resetForTests() {
        synchronized (NetworkTypeObserver.class) {
            f12732e = null;
        }
    }

    public int getNetworkType() {
        int i;
        synchronized (this.f12735c) {
            i = this.f12736d;
        }
        return i;
    }

    public void register(Listener listener) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f12734b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        copyOnWriteArrayList.add(new WeakReference(listener));
        this.f12733a.post(new RunnableC0583c7(26, this, listener));
    }
}
