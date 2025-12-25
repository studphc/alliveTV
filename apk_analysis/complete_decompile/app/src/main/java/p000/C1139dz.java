package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.util.pool.GlideTrace;

/* renamed from: dz */
/* loaded from: classes.dex */
public final class C1139dz {

    /* renamed from: a */
    public Key f16616a;

    /* renamed from: b */
    public ResourceEncoder f16617b;

    /* renamed from: c */
    public rd1 f16618c;

    /* renamed from: a */
    public final void m4646a(i90 i90Var, Options options) {
        GlideTrace.beginSection("DecodeJob.encode");
        try {
            i90Var.m5200a().put(this.f16616a, new C1602ny(this.f16617b, this.f16618c, options));
        } finally {
            this.f16618c.m7268a();
            GlideTrace.endSection();
        }
    }
}
