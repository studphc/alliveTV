package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class li2 implements InvocationHandler {

    /* renamed from: a */
    public final /* synthetic */ Object f22513a;

    /* renamed from: b */
    public final /* synthetic */ long f22514b;

    /* renamed from: c */
    public final /* synthetic */ TimeUnit f22515c;

    /* renamed from: d */
    public final /* synthetic */ HashSet f22516d;

    /* renamed from: e */
    public final /* synthetic */ SimpleTimeLimiter f22517e;

    public li2(SimpleTimeLimiter simpleTimeLimiter, Object obj, long j, TimeUnit timeUnit, HashSet hashSet) {
        this.f22517e = simpleTimeLimiter;
        this.f22513a = obj;
        this.f22514b = j;
        this.f22515c = timeUnit;
        this.f22516d = hashSet;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        y10 y10Var = new y10(method, this.f22513a, objArr, 1);
        boolean contains = this.f22516d.contains(method);
        SimpleTimeLimiter simpleTimeLimiter = this.f22517e;
        simpleTimeLimiter.getClass();
        Preconditions.checkNotNull(y10Var);
        TimeUnit timeUnit = this.f22515c;
        Preconditions.checkNotNull(timeUnit);
        long j = this.f22514b;
        SimpleTimeLimiter.m4343a(j);
        Future submit = simpleTimeLimiter.f15341a.submit(y10Var);
        try {
            if (contains) {
                try {
                    return submit.get(j, timeUnit);
                } catch (InterruptedException e) {
                    submit.cancel(true);
                    throw e;
                }
            }
            return Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e2) {
            SimpleTimeLimiter.m4344b(e2, true);
            throw null;
        } catch (TimeoutException e3) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(e3);
        }
    }
}
