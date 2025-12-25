package p000;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class fp0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f17358a;

    public /* synthetic */ fp0(int i) {
        this.f17358a = i;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        switch (this.f17358a) {
            case 0:
                return new ArrayList(16);
            case 1:
                return null;
            case 2:
                return oe2.f23791a;
            case 3:
                return pe2.f25140a;
            case 4:
                return qe2.f25552a;
            default:
                return re2.f25949a;
        }
    }
}
