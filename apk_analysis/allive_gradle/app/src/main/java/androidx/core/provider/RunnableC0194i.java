package androidx.core.provider;

/* renamed from: androidx.core.provider.i */
/* loaded from: classes.dex */
public final class RunnableC0194i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Object f3758a;

    /* renamed from: b */
    public final /* synthetic */ RunnableC0195j f3759b;

    public RunnableC0194i(RunnableC0195j runnableC0195j, Object obj) {
        this.f3759b = runnableC0195j;
        this.f3758a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3759b.f3762c.onReply(this.f3758a);
    }
}
