package p000;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a9 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0010a9 implements OnBackInvokedCallback {

    /* renamed from: a */
    public final /* synthetic */ int f88a;

    /* renamed from: b */
    public final /* synthetic */ Object f89b;

    public /* synthetic */ C0010a9(int i, Object obj) {
        this.f88a = i;
        this.f89b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f88a) {
            case 0:
                ((LayoutInflaterFactory2C0084e) this.f89b).m193w();
                return;
            case 1:
                Function0 onBackInvoked = (Function0) this.f89b;
                Intrinsics.checkNotNullParameter(onBackInvoked, "$onBackInvoked");
                onBackInvoked.invoke();
                return;
            default:
                ((Runnable) this.f89b).run();
                return;
        }
    }
}
