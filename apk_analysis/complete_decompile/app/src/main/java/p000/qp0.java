package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayList;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class qp0 extends ArrayList implements jp0 {
    private static final long serialVersionUID = 7063189396499112664L;

    /* renamed from: a */
    public volatile int f25709a;

    @Override // p000.jp0
    /* renamed from: a */
    public final void mo4740a(Object obj) {
        add(NotificationLite.next(obj));
        this.f25709a++;
    }

    @Override // p000.jp0
    /* renamed from: b */
    public final void mo4741b(Throwable th) {
        add(NotificationLite.error(th));
        this.f25709a++;
    }

    @Override // p000.jp0
    /* renamed from: c */
    public final void mo4742c(gp0 gp0Var) {
        int i;
        synchronized (gp0Var) {
            try {
                if (gp0Var.f17788e) {
                    gp0Var.f17789f = true;
                    return;
                }
                gp0Var.f17788e = true;
                Subscriber subscriber = gp0Var.f17785b;
                while (!gp0Var.isDisposed()) {
                    int i2 = this.f25709a;
                    Integer num = (Integer) gp0Var.f17786c;
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 0;
                    }
                    long j = gp0Var.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && i < i2) {
                        E e = get(i);
                        try {
                            if (NotificationLite.accept(e, subscriber) || gp0Var.isDisposed()) {
                                return;
                            }
                            i++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            gp0Var.dispose();
                            if (!NotificationLite.isError(e) && !NotificationLite.isComplete(e)) {
                                subscriber.onError(th);
                                return;
                            } else {
                                RxJavaPlugins.onError(th);
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        gp0Var.f17786c = Integer.valueOf(i);
                        if (j != Long.MAX_VALUE) {
                            BackpressureHelper.producedCancel(gp0Var, j3);
                        }
                    }
                    synchronized (gp0Var) {
                        try {
                            if (!gp0Var.f17789f) {
                                gp0Var.f17788e = false;
                                return;
                            }
                            gp0Var.f17789f = false;
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // p000.jp0
    public final void complete() {
        add(NotificationLite.complete());
        this.f25709a++;
    }
}
