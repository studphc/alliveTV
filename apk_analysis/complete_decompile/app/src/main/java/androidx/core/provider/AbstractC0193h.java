package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.ExecutorC2014yb;
import p000.ThreadFactoryC1674p4;
import p000.o63;
import p000.sk1;
import p000.zs0;

/* renamed from: androidx.core.provider.h */
/* loaded from: classes.dex */
public abstract class AbstractC0193h {

    /* renamed from: a */
    public static final LruCache f3754a = new LruCache(16);

    /* renamed from: b */
    public static final ThreadPoolExecutor f3755b;

    /* renamed from: c */
    public static final Object f3756c;

    /* renamed from: d */
    public static final SimpleArrayMap f3757d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactoryC1674p4(1));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f3755b = threadPoolExecutor;
        f3756c = new Object();
        f3757d = new SimpleArrayMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0192g m884a(String str, Context context, FontRequest fontRequest, int i) {
        LruCache lruCache = f3754a;
        Typeface typeface = (Typeface) lruCache.get(str);
        if (typeface != null) {
            return new C0192g(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult m882a = AbstractC0189d.m882a(context, null, fontRequest);
            int i2 = 1;
            if (m882a.getStatusCode() != 0) {
                if (m882a.getStatusCode() == 1) {
                    i2 = -2;
                    if (i2 != 0) {
                        return new C0192g(i2);
                    }
                    Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, m882a.getFonts(), i);
                    if (createFromFontInfo != null) {
                        lruCache.put(str, createFromFontInfo);
                        return new C0192g(createFromFontInfo);
                    }
                    return new C0192g(-3);
                }
                i2 = -3;
                if (i2 != 0) {
                }
            } else {
                FontsContractCompat.FontInfo[] fonts = m882a.getFonts();
                if (fonts != null && fonts.length != 0) {
                    int length = fonts.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            int resultCode = fonts[i3].getResultCode();
                            if (resultCode != 0) {
                                if (resultCode >= 0) {
                                    i2 = resultCode;
                                }
                            } else {
                                i3++;
                            }
                        } else {
                            i2 = 0;
                            break;
                        }
                    }
                }
                if (i2 != 0) {
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0192g(-1);
        }
    }

    /* renamed from: b */
    public static Typeface m885b(Context context, FontRequest fontRequest, int i, ExecutorC2014yb executorC2014yb, C0188c c0188c) {
        String str = fontRequest.f3724f + "-" + i;
        Typeface typeface = (Typeface) f3754a.get(str);
        if (typeface != null) {
            c0188c.f3745b.post(new RunnableC0186a(c0188c.f3744a, typeface));
            return typeface;
        }
        C0190e c0190e = new C0190e(c0188c);
        synchronized (f3756c) {
            try {
                SimpleArrayMap simpleArrayMap = f3757d;
                ArrayList arrayList = (ArrayList) simpleArrayMap.get(str);
                if (arrayList != null) {
                    arrayList.add(c0190e);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(c0190e);
                simpleArrayMap.put(str, arrayList2);
                CallableC0191f callableC0191f = new CallableC0191f(str, context, fontRequest, i);
                Executor executor = executorC2014yb;
                if (executorC2014yb == null) {
                    executor = f3755b;
                }
                zs0 zs0Var = new zs0(str);
                Handler m6466i = o63.m6466i();
                sk1 sk1Var = new sk1();
                sk1Var.f26463b = callableC0191f;
                sk1Var.f26464c = zs0Var;
                sk1Var.f26465d = m6466i;
                executor.execute(sk1Var);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
