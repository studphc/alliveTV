package p000;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes2.dex */
public final class sk0 extends nk0 {
    private static final long serialVersionUID = 3776720187248809713L;

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        long j;
        if (this.f23386b.isDisposed()) {
            return;
        }
        if (obj != null) {
            this.f23385a.onNext(obj);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
            return;
        }
        onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
    }
}
