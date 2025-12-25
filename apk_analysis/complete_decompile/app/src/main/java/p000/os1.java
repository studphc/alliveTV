package p000;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class os1 implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;

    /* renamed from: a */
    public final Throwable f24895a;

    public os1(Throwable th) {
        this.f24895a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof os1) {
            return Objects.equals(this.f24895a, ((os1) obj).f24895a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f24895a.hashCode();
    }

    public final String toString() {
        return "NotificationLite.Error[" + this.f24895a + "]";
    }
}
