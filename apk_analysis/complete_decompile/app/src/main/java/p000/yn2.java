package p000;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class yn2 implements Flow {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f29045b = AtomicIntegerFieldUpdater.newUpdater(yn2.class, "consumed");

    /* renamed from: a */
    public final Stream f29046a;

    @Volatile
    private volatile int consumed = 0;

    public yn2(Stream stream) {
        this.f29046a = stream;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x002b, B:14:0x0050, B:16:0x0056), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        xn2 xn2Var;
        int i;
        yn2 yn2Var;
        Iterator it;
        FlowCollector flowCollector2;
        Iterator it2;
        if (continuation instanceof xn2) {
            xn2Var = (xn2) continuation;
            int i2 = xn2Var.f28664i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xn2Var.f28664i = i2 - Integer.MIN_VALUE;
                Object obj = xn2Var.f28662g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = xn2Var.f28664i;
                if (i == 0) {
                    if (i == 1) {
                        it2 = xn2Var.f28661f;
                        FlowCollector flowCollector3 = xn2Var.f28660e;
                        yn2Var = xn2Var.f28659d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector3;
                        } catch (Throwable th) {
                            th = th;
                            yn2Var.f29046a.close();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (f29045b.compareAndSet(this, 0, 1)) {
                        try {
                            it = this.f29046a.iterator();
                            yn2Var = this;
                            flowCollector2 = flowCollector;
                            it2 = it;
                        } catch (Throwable th2) {
                            th = th2;
                            yn2Var = this;
                            yn2Var.f29046a.close();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once");
                    }
                }
                while (it2.hasNext()) {
                    Object next = it2.next();
                    xn2Var.f28659d = yn2Var;
                    xn2Var.f28660e = flowCollector2;
                    xn2Var.f28661f = it2;
                    xn2Var.f28664i = 1;
                    if (flowCollector2.emit(next, xn2Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                yn2Var.f29046a.close();
                return Unit.INSTANCE;
            }
        }
        xn2Var = new xn2(this, continuation);
        Object obj2 = xn2Var.f28662g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = xn2Var.f28664i;
        if (i == 0) {
        }
        while (it2.hasNext()) {
        }
        yn2Var.f29046a.close();
        return Unit.INSTANCE;
    }
}
