package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public final class n90 implements Key {

    /* renamed from: a */
    public final Object f23288a;

    /* renamed from: b */
    public final int f23289b;

    /* renamed from: c */
    public final int f23290c;

    /* renamed from: d */
    public final Class f23291d;

    /* renamed from: e */
    public final Class f23292e;

    /* renamed from: f */
    public final Key f23293f;

    /* renamed from: g */
    public final Map f23294g;

    /* renamed from: h */
    public final Options f23295h;

    /* renamed from: i */
    public int f23296i;

    public n90(Object obj, Key key, int i, int i2, Map map, Class cls, Class cls2, Options options) {
        this.f23288a = Preconditions.checkNotNull(obj);
        this.f23293f = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.f23289b = i;
        this.f23290c = i2;
        this.f23294g = (Map) Preconditions.checkNotNull(map);
        this.f23291d = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.f23292e = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.f23295h = (Options) Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof n90)) {
            return false;
        }
        n90 n90Var = (n90) obj;
        if (!this.f23288a.equals(n90Var.f23288a) || !this.f23293f.equals(n90Var.f23293f) || this.f23290c != n90Var.f23290c || this.f23289b != n90Var.f23289b || !this.f23294g.equals(n90Var.f23294g) || !this.f23291d.equals(n90Var.f23291d) || !this.f23292e.equals(n90Var.f23292e) || !this.f23295h.equals(n90Var.f23295h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        if (this.f23296i == 0) {
            int hashCode = this.f23288a.hashCode();
            this.f23296i = hashCode;
            int hashCode2 = ((((this.f23293f.hashCode() + (hashCode * 31)) * 31) + this.f23289b) * 31) + this.f23290c;
            this.f23296i = hashCode2;
            int hashCode3 = this.f23294g.hashCode() + (hashCode2 * 31);
            this.f23296i = hashCode3;
            int hashCode4 = this.f23291d.hashCode() + (hashCode3 * 31);
            this.f23296i = hashCode4;
            int hashCode5 = this.f23292e.hashCode() + (hashCode4 * 31);
            this.f23296i = hashCode5;
            this.f23296i = this.f23295h.hashCode() + (hashCode5 * 31);
        }
        return this.f23296i;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f23288a + ", width=" + this.f23289b + ", height=" + this.f23290c + ", resourceClass=" + this.f23291d + ", transcodeClass=" + this.f23292e + ", signature=" + this.f23293f + ", hashCode=" + this.f23296i + ", transformations=" + this.f23294g + ", options=" + this.f23295h + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
