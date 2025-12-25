package p000;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ne0 implements sx1 {

    /* renamed from: a */
    public int f23338a;

    /* renamed from: b */
    public long f23339b;

    /* renamed from: c */
    public boolean f23340c;

    /* renamed from: d */
    public Object f23341d;

    /* renamed from: e */
    public Object f23342e;

    @Override // p000.sx1
    public wx1 call() {
        return new ay1(this.f23338a, this.f23339b, (TimeUnit) this.f23341d, (Scheduler) this.f23342e, this.f23340c);
    }
}
