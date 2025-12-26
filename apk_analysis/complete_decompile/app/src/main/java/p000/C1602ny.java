package p000;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* renamed from: ny */
/* loaded from: classes.dex */
public final class C1602ny implements DiskCache.Writer {

    /* renamed from: a */
    public final Encoder f23527a;

    /* renamed from: b */
    public final Object f23528b;

    /* renamed from: c */
    public final Options f23529c;

    public C1602ny(Encoder encoder, Object obj, Options options) {
        this.f23527a = encoder;
        this.f23528b = obj;
        this.f23529c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public final boolean write(File file) {
        return this.f23527a.encode(this.f23528b, file, this.f23529c);
    }
}
