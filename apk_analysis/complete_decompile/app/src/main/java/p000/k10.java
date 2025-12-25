package p000;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class k10 {
    /* renamed from: a */
    public static Handler m5475a(Looper looper) {
        return Handler.createAsync(looper);
    }

    /* renamed from: b */
    public static Handler m5476b(Looper looper, Handler.Callback callback) {
        return Handler.createAsync(looper, callback);
    }

    /* renamed from: c */
    public static Handler m5477c(Looper looper) {
        return Handler.createAsync(looper);
    }

    /* renamed from: d */
    public static CharSequence m5478d(Context context, ServiceInfo serviceInfo) {
        Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
        if (namedContentLocales.isEmpty()) {
            return null;
        }
        String[] strArr = new String[namedContentLocales.size()];
        Iterator<Locale> it = serviceInfo.getNamedContentLocales().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().toLanguageTag();
            i++;
        }
        Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
        if (firstMatch == null) {
            return null;
        }
        return serviceInfo.getNameForLocale(firstMatch);
    }

    /* renamed from: e */
    public static boolean m5479e(Handler handler, Runnable runnable, Object obj, long j) {
        return handler.postDelayed(runnable, obj, j);
    }
}
