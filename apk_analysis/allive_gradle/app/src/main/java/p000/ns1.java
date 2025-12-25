package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ns1 implements Serializable {
    private static final long serialVersionUID = -7482590109178395495L;

    /* renamed from: a */
    public final Disposable f23480a;

    public ns1(Disposable disposable) {
        this.f23480a = disposable;
    }

    public final String toString() {
        return "NotificationLite.Disposable[" + this.f23480a + "]";
    }
}
