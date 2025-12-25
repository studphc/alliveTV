package p000;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class rg2 implements Executor {

    /* renamed from: f */
    public static final Logger f25961f = Logger.getLogger(rg2.class.getName());

    /* renamed from: a */
    public final Executor f25962a;

    /* renamed from: b */
    public final ArrayDeque f25963b = new ArrayDeque();

    /* renamed from: c */
    public int f25964c = 1;

    /* renamed from: d */
    public long f25965d = 0;

    /* renamed from: e */
    public final xy1 f25966e = new xy1(this, 15);

    public rg2(Executor executor) {
        this.f25962a = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.f25963b) {
            int i = this.f25964c;
            if (i != 4 && i != 3) {
                long j = this.f25965d;
                RunnableC1609o4 runnableC1609o4 = new RunnableC1609o4(1, runnable);
                this.f25963b.add(runnableC1609o4);
                this.f25964c = 2;
                try {
                    this.f25962a.execute(this.f25966e);
                    if (this.f25964c != 2) {
                        return;
                    }
                    synchronized (this.f25963b) {
                        try {
                            if (this.f25965d == j && this.f25964c == 2) {
                                this.f25964c = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.f25963b) {
                        try {
                            int i2 = this.f25964c;
                            boolean z = true;
                            if ((i2 != 1 && i2 != 2) || !this.f25963b.removeLastOccurrence(runnableC1609o4)) {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f25963b.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f25962a + "}";
    }
}
