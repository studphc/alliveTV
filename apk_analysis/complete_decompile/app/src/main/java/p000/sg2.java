package p000;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class sg2 implements Executor {

    /* renamed from: f */
    public static final Logger f26419f = Logger.getLogger(sg2.class.getName());

    /* renamed from: a */
    public final Executor f26420a;

    /* renamed from: b */
    public final ArrayDeque f26421b = new ArrayDeque();

    /* renamed from: c */
    public int f26422c = 1;

    /* renamed from: d */
    public long f26423d = 0;

    /* renamed from: e */
    public final xy1 f26424e = new xy1(this, 16);

    public sg2(Executor executor) {
        this.f26420a = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.f26421b) {
            int i = this.f26422c;
            if (i != 4 && i != 3) {
                long j = this.f26423d;
                RunnableC1609o4 runnableC1609o4 = new RunnableC1609o4(2, runnable);
                this.f26421b.add(runnableC1609o4);
                this.f26422c = 2;
                try {
                    this.f26420a.execute(this.f26424e);
                    if (this.f26422c != 2) {
                        return;
                    }
                    synchronized (this.f26421b) {
                        try {
                            if (this.f26423d == j && this.f26422c == 2) {
                                this.f26422c = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.f26421b) {
                        try {
                            int i2 = this.f26422c;
                            boolean z = true;
                            if ((i2 != 1 && i2 != 2) || !this.f26421b.removeLastOccurrence(runnableC1609o4)) {
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
            this.f26421b.add(runnable);
        }
    }

    public final String toString() {
        int identityHashCode = System.identityHashCode(this);
        String valueOf = String.valueOf(this.f26420a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 32);
        sb.append("SequentialExecutor@");
        sb.append(identityHashCode);
        sb.append("{");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
