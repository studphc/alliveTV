package p000;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes2.dex */
public abstract class tk0 extends nk0 {
    private static final long serialVersionUID = 4127754106204442833L;

    /* renamed from: f */
    public abstract void mo6914f();

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (this.f23386b.isDisposed()) {
            return;
        }
        if (obj == null) {
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
        } else if (get() != 0) {
            this.f23385a.onNext(obj);
            BackpressureHelper.produced(this, 1L);
        } else {
            mo6914f();
        }
    }
}
