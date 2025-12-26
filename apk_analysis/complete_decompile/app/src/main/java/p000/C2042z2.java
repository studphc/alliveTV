package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.C0994g;
import com.google.common.util.concurrent.RunnableC0996h;
import com.google.common.util.concurrent.RunnableC0998i;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: z2 */
/* loaded from: classes2.dex */
public final class C2042z2 extends AbstractService {

    /* renamed from: p */
    public volatile InterfaceC2005y2 f29221p;

    /* renamed from: q */
    public volatile to1 f29222q;

    /* renamed from: r */
    public final ReentrantLock f29223r = new ReentrantLock();

    /* renamed from: s */
    public final RunnableC1104d f29224s = new RunnableC1104d(2, this);

    /* renamed from: t */
    public final /* synthetic */ AbstractScheduledService f29225t;

    public C2042z2(AbstractScheduledService abstractScheduledService) {
        this.f29225t = abstractScheduledService;
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStart() {
        ScheduledExecutorService executor = this.f29225t.executor();
        C0994g c0994g = new C0994g(this);
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(c0994g);
        this.f29222q = new to1(executor, c0994g);
        this.f29222q.execute(new RunnableC0996h(this));
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStop() {
        Objects.requireNonNull(this.f29221p);
        Objects.requireNonNull(this.f29222q);
        this.f29221p.cancel();
        this.f29222q.execute(new RunnableC0998i(this));
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final String toString() {
        return this.f29225t.toString();
    }
}
