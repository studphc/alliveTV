package p000;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;

/* renamed from: ru */
/* loaded from: classes.dex */
public abstract class AbstractC1774ru {
    @DoNotInline
    /* renamed from: a */
    public static Handler m7303a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}
