package p000;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class y10 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f28793a;

    /* renamed from: b */
    public final /* synthetic */ Object f28794b;

    /* renamed from: c */
    public final /* synthetic */ Object f28795c;

    /* renamed from: d */
    public final /* synthetic */ Object f28796d;

    public /* synthetic */ y10(Object obj, Object obj2, Object obj3, int i) {
        this.f28793a = i;
        this.f28794b = obj;
        this.f28795c = obj2;
        this.f28796d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f28793a) {
            case 0:
                z10 z10Var = (z10) this.f28794b;
                z10Var.getClass();
                int i = 13;
                return z10Var.f29215a.submit(new RunnableC0583c7(i, (Callable) this.f28795c, (b01) this.f28796d));
            default:
                try {
                    return ((Method) this.f28794b).invoke(this.f28795c, (Object[]) this.f28796d);
                } catch (InvocationTargetException e) {
                    SimpleTimeLimiter.m4344b(e, false);
                    throw null;
                }
        }
    }
}
