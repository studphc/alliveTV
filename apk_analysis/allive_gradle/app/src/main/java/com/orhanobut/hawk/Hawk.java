package com.orhanobut.hawk;

import android.content.Context;
import com.orhanobut.hawk.HawkFacade;
import p000.p63;

/* loaded from: classes2.dex */
public final class Hawk {

    /* renamed from: a */
    public static HawkFacade f16033a = new HawkFacade.EmptyHawkFacade();

    public static boolean contains(String str) {
        return f16033a.contains(str);
    }

    public static long count() {
        return f16033a.count();
    }

    public static boolean delete(String str) {
        return f16033a.delete(str);
    }

    public static boolean deleteAll() {
        return f16033a.deleteAll();
    }

    public static void destroy() {
        f16033a.destroy();
    }

    public static <T> T get(String str) {
        return (T) f16033a.get(str);
    }

    public static HawkBuilder init(Context context) {
        p63.m6871o(context, "Context");
        f16033a = null;
        return new HawkBuilder(context);
    }

    public static boolean isBuilt() {
        return f16033a.isBuilt();
    }

    public static <T> boolean put(String str, T t) {
        return f16033a.put(str, t);
    }

    public static <T> T get(String str, T t) {
        return (T) f16033a.get(str, t);
    }
}
