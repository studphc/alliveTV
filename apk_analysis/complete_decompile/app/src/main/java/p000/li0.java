package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class li0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f22510a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f22510a) {
            case 0:
                return Flowable.just(obj);
            case 1:
                return Maybe.just(obj);
            default:
                return Observable.just(obj);
        }
    }
}
