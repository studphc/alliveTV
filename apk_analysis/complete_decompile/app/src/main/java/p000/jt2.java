package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* loaded from: classes2.dex */
public final class jt2 implements Function1 {

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater f20625d = AtomicIntegerFieldUpdater.newUpdater(jt2.class, "_state");

    @Volatile
    private volatile int _state;

    /* renamed from: a */
    public final Job f20626a;

    /* renamed from: b */
    public final Thread f20627b = Thread.currentThread();

    /* renamed from: c */
    public DisposableHandle f20628c;

    public jt2(Job job) {
        this.f20626a = job;
    }

    /* renamed from: b */
    public static void m5460b(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    /* renamed from: a */
    public final void m5461a() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20625d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        m5460b(i);
                        throw null;
                    }
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.f20628c;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20625d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    m5460b(i);
                    throw null;
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i, 2)) {
                this.f20627b.interrupt();
                atomicIntegerFieldUpdater.set(this, 3);
                break;
            }
        }
        return Unit.INSTANCE;
    }
}
