package p000;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class ud1 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f27228a;

    public /* synthetic */ ud1(int i) {
        this.f27228a = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f27228a) {
            case 0:
                return new Number();
            case 1:
                return new Number();
            case 2:
                return new AtomicLong();
            default:
                return new AtomicLong();
        }
    }
}
