package p000;

import java.io.Serializable;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ps1 implements Serializable {
    private static final long serialVersionUID = -1322257508628817540L;

    /* renamed from: a */
    public final Subscription f25278a;

    public ps1(Subscription subscription) {
        this.f25278a = subscription;
    }

    public final String toString() {
        return "NotificationLite.Subscription[" + this.f25278a + "]";
    }
}
