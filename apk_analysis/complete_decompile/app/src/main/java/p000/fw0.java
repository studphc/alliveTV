package p000;

import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class fw0 implements Future {

    /* renamed from: a */
    public final /* synthetic */ Future f17415a;

    /* renamed from: b */
    public final /* synthetic */ Function f17416b;

    public fw0(Future future, Function function) {
        this.f17415a = future;
        this.f17416b = function;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f17415a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        try {
            return this.f17416b.apply(this.f17415a.get());
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f17415a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f17415a.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        try {
            return this.f17416b.apply(this.f17415a.get(j, timeUnit));
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }
}
