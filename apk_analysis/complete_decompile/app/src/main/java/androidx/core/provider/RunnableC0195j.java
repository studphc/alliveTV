package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.SelfDestructiveThread;
import java.util.concurrent.Callable;

/* renamed from: androidx.core.provider.j */
/* loaded from: classes.dex */
public final class RunnableC0195j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Callable f3760a;

    /* renamed from: b */
    public final /* synthetic */ Handler f3761b;

    /* renamed from: c */
    public final /* synthetic */ SelfDestructiveThread.ReplyCallback f3762c;

    public RunnableC0195j(Callable callable, Handler handler, SelfDestructiveThread.ReplyCallback replyCallback) {
        this.f3760a = callable;
        this.f3761b = handler;
        this.f3762c = replyCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        try {
            obj = this.f3760a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f3761b.post(new RunnableC0194i(this, obj));
    }
}
