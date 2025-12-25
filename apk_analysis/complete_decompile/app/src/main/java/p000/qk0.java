package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;

/* loaded from: classes2.dex */
public final class qk0 extends tk0 {
    private static final long serialVersionUID = 338953216916120960L;

    @Override // p000.tk0
    /* renamed from: f */
    public final void mo6914f() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
