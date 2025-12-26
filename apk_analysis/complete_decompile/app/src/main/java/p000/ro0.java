package p000;

import io.reactivex.rxjava3.operators.ConditionalSubscriber;

/* loaded from: classes2.dex */
public final class ro0 extends qo0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final ConditionalSubscriber f26078d;

    public ro0(ConditionalSubscriber conditionalSubscriber, int i, int i2) {
        super(i, i2);
        this.f26078d = conditionalSubscriber;
    }

    @Override // p000.qo0
    /* renamed from: a */
    public final void mo7114a() {
        int i = this.f25703a;
        ConditionalSubscriber conditionalSubscriber = this.f26078d;
        for (int i2 = this.f25704b; i2 != i; i2++) {
            if (this.f25705c) {
                return;
            }
            conditionalSubscriber.tryOnNext(Integer.valueOf(i2));
        }
        if (this.f25705c) {
            return;
        }
        conditionalSubscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        r9.f25704b = r1;
        r10 = addAndGet(-r5);
     */
    @Override // p000.qo0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo7115e(long j) {
        int i = this.f25703a;
        int i2 = this.f25704b;
        ConditionalSubscriber conditionalSubscriber = this.f26078d;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j && i2 != i) {
                    if (this.f25705c) {
                        return;
                    }
                    if (conditionalSubscriber.tryOnNext(Integer.valueOf(i2))) {
                        j2++;
                    }
                    i2++;
                } else if (i2 == i) {
                    if (!this.f25705c) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        break;
                    }
                }
            }
        } while (j != 0);
    }
}
