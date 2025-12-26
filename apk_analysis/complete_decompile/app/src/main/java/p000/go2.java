package p000;

import android.security.NetworkSecurityPolicy;
import android.view.PointerIcon;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class go2 {
    /* renamed from: b */
    public static /* bridge */ /* synthetic */ PointerIcon m4961b(Object obj) {
        return (PointerIcon) obj;
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ Locale.Category m4963d() {
        return Locale.Category.DISPLAY;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ Locale m4964e(Locale.Category category) {
        return Locale.getDefault(category);
    }

    /* renamed from: i */
    public static /* synthetic */ PriorityQueue m4968i(Comparator comparator) {
        return new PriorityQueue(comparator);
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ boolean m4974o(NetworkSecurityPolicy networkSecurityPolicy, String str) {
        return networkSecurityPolicy.isCleartextTrafficPermitted(str);
    }
}
