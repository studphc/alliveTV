package p000;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class aq2 {

    /* renamed from: a */
    public final EventBus f7711a;

    /* renamed from: b */
    public final Object f7712b;

    /* renamed from: c */
    public final Method f7713c;

    /* renamed from: d */
    public final Executor f7714d;

    public aq2(EventBus eventBus, Object obj, Method method) {
        this.f7711a = eventBus;
        this.f7712b = Preconditions.checkNotNull(obj);
        this.f7713c = method;
        method.setAccessible(true);
        this.f7714d = eventBus.f15023b;
    }

    /* renamed from: a */
    public void mo1960a(Object obj) {
        try {
            this.f7713c.invoke(this.f7712b, Preconditions.checkNotNull(obj));
        } catch (IllegalAccessException e) {
            String valueOf = String.valueOf(obj);
            throw new Error(AbstractC1726qj.m7054j(valueOf.length() + 28, "Method became inaccessible: ", valueOf), e);
        } catch (IllegalArgumentException e2) {
            String valueOf2 = String.valueOf(obj);
            throw new Error(AbstractC1726qj.m7054j(valueOf2.length() + 33, "Method rejected target/argument: ", valueOf2), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aq2)) {
            return false;
        }
        aq2 aq2Var = (aq2) obj;
        if (this.f7712b != aq2Var.f7712b || !this.f7713c.equals(aq2Var.f7713c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7712b) + ((this.f7713c.hashCode() + 31) * 31);
    }
}
