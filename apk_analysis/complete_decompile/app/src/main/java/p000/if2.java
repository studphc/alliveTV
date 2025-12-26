package p000;

import android.os.Handler;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public final class if2 {

    /* renamed from: a */
    public Object f18397a;

    /* renamed from: b */
    public boolean f18398b;

    /* renamed from: a */
    public synchronized void m5233a(Resource resource, boolean z) {
        try {
            if (!this.f18398b && !z) {
                this.f18398b = true;
                resource.recycle();
                this.f18398b = false;
            }
            ((Handler) this.f18397a).obtainMessage(1, resource).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }
}
