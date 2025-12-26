package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: q4 */
/* loaded from: classes.dex */
public final class C1711q4 extends WeakReference {

    /* renamed from: a */
    public final Key f25427a;

    /* renamed from: b */
    public final boolean f25428b;

    /* renamed from: c */
    public Resource f25429c;

    public C1711q4(Key key, p90 p90Var, ReferenceQueue referenceQueue, boolean z) {
        super(p90Var, referenceQueue);
        Resource resource;
        this.f25427a = (Key) Preconditions.checkNotNull(key);
        if (p90Var.f25069a && z) {
            resource = (Resource) Preconditions.checkNotNull(p90Var.f25071c);
        } else {
            resource = null;
        }
        this.f25429c = resource;
        this.f25428b = p90Var.f25069a;
    }
}
