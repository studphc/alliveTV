package p000;

import androidx.emoji2.text.flatbuffer.Utf8Old;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class mi0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f22944a;

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f22944a) {
            case 0:
                return Flowable.empty();
            case 1:
                return Maybe.empty();
            case 2:
                return Observable.empty();
            default:
                ThreadLocal threadLocal = Utf8Old.f4288b;
                return new y03();
        }
    }
}
