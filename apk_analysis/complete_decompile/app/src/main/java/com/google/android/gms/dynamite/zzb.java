package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import p000.C0588cc;

/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a */
    public static ClassLoader f13713a;

    /* renamed from: b */
    public static Thread f13714b;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a4, code lost:
    
        if (r1 == null) goto L61;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        SecurityException e;
        Thread thread;
        ThreadGroup threadGroup;
        C0588cc c0588cc;
        synchronized (zzb.class) {
            if (f13713a == null) {
                Thread thread2 = f13714b;
                ClassLoader classLoader2 = null;
                if (thread2 == null) {
                    ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                    if (threadGroup2 == null) {
                        thread2 = null;
                    } else {
                        synchronized (Void.class) {
                            try {
                                try {
                                    int activeGroupCount = threadGroup2.activeGroupCount();
                                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                                    threadGroup2.enumerate(threadGroupArr);
                                    int i = 0;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < activeGroupCount) {
                                            threadGroup = threadGroupArr[i2];
                                            if ("dynamiteLoader".equals(threadGroup.getName())) {
                                                break;
                                            }
                                            i2++;
                                        } else {
                                            threadGroup = null;
                                            break;
                                        }
                                    }
                                    if (threadGroup == null) {
                                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                    }
                                    int activeCount = threadGroup.activeCount();
                                    Thread[] threadArr = new Thread[activeCount];
                                    threadGroup.enumerate(threadArr);
                                    while (true) {
                                        if (i < activeCount) {
                                            thread = threadArr[i];
                                            if ("GmsDynamite".equals(thread.getName())) {
                                                break;
                                            }
                                            i++;
                                        } else {
                                            thread = null;
                                            break;
                                        }
                                    }
                                    if (thread == null) {
                                        try {
                                            c0588cc = new C0588cc(threadGroup, "GmsDynamite");
                                        } catch (SecurityException e2) {
                                            e = e2;
                                        }
                                        try {
                                            c0588cc.setContextClassLoader(null);
                                            c0588cc.start();
                                            thread = c0588cc;
                                        } catch (SecurityException e3) {
                                            e = e3;
                                            thread = c0588cc;
                                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                                            thread2 = thread;
                                            f13714b = thread2;
                                        }
                                    }
                                } catch (SecurityException e4) {
                                    e = e4;
                                    thread = null;
                                }
                            } finally {
                            }
                        }
                        thread2 = thread;
                    }
                    f13714b = thread2;
                }
                synchronized (thread2) {
                    try {
                        classLoader2 = f13714b.getContextClassLoader();
                    } catch (SecurityException e5) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e5.getMessage());
                    }
                }
                f13713a = classLoader2;
            }
            classLoader = f13713a;
        }
        return classLoader;
    }
}
