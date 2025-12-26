package p000;

import com.bumptech.glide.request.ResourceCallback;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class k90 {

    /* renamed from: a */
    public final ResourceCallback f20792a;

    /* renamed from: b */
    public final Executor f20793b;

    public k90(ResourceCallback resourceCallback, Executor executor) {
        this.f20792a = resourceCallback;
        this.f20793b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k90) {
            return this.f20792a.equals(((k90) obj).f20792a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20792a.hashCode();
    }
}
