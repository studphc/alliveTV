package p000;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import java.util.Objects;

/* renamed from: b9 */
/* loaded from: classes.dex */
public abstract class AbstractC0549b9 {
    @DoNotInline
    /* renamed from: a */
    public static OnBackInvokedDispatcher m2064a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    @DoNotInline
    /* renamed from: b */
    public static OnBackInvokedCallback m2065b(Object obj, LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        Objects.requireNonNull(layoutInflaterFactory2C0084e);
        C0010a9 c0010a9 = new C0010a9(0, layoutInflaterFactory2C0084e);
        AbstractC1747r3.m7177h(obj).registerOnBackInvokedCallback(1000000, c0010a9);
        return c0010a9;
    }

    @DoNotInline
    /* renamed from: c */
    public static void m2066c(Object obj, Object obj2) {
        AbstractC1747r3.m7177h(obj).unregisterOnBackInvokedCallback(AbstractC1747r3.m7174e(obj2));
    }
}
