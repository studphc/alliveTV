package p000;

import android.os.Looper;
import androidx.loader.content.ModernAsyncTask$Status;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class ro1 {

    /* renamed from: f */
    public static final ThreadPoolExecutor f26079f;

    /* renamed from: g */
    public static qo1 f26080g;

    /* renamed from: h */
    public static volatile ThreadPoolExecutor f26081h;

    /* renamed from: a */
    public final u40 f26082a;

    /* renamed from: b */
    public final no1 f26083b;

    /* renamed from: c */
    public volatile ModernAsyncTask$Status f26084c = ModernAsyncTask$Status.PENDING;

    /* renamed from: d */
    public final AtomicBoolean f26085d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicBoolean f26086e = new AtomicBoolean();

    static {
        j10 j10Var = new j10(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), j10Var);
        f26079f = threadPoolExecutor;
        f26081h = threadPoolExecutor;
    }

    public ro1() {
        u40 u40Var = new u40(1, this);
        this.f26082a = u40Var;
        this.f26083b = new no1(this, u40Var);
    }

    /* renamed from: a */
    public final void m7294a(Object obj) {
        qo1 qo1Var;
        synchronized (ro1.class) {
            try {
                if (f26080g == null) {
                    f26080g = new qo1(Looper.getMainLooper());
                }
                qo1Var = f26080g;
            } catch (Throwable th) {
                throw th;
            }
        }
        qo1Var.obtainMessage(1, new po1(this, obj)).sendToTarget();
    }
}
