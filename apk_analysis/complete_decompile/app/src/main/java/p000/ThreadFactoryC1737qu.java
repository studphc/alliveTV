package p000;

import com.google.android.exoplayer2.util.Util;
import java.util.concurrent.ThreadFactory;

/* renamed from: qu */
/* loaded from: classes.dex */
public final /* synthetic */ class ThreadFactoryC1737qu implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ int f25750a;

    /* renamed from: b */
    public final /* synthetic */ String f25751b;

    public /* synthetic */ ThreadFactoryC1737qu(String str, int i) {
        this.f25750a = i;
        this.f25751b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f25751b;
        switch (this.f25750a) {
            case 0:
                Thread thread = new Thread(runnable, str);
                thread.setPriority(10);
                return thread;
            default:
                int i = Util.SDK_INT;
                return new Thread(runnable, str);
        }
    }
}
