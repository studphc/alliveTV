package p000;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: my */
/* loaded from: classes.dex */
public final class C1565my implements Key {

    /* renamed from: a */
    public final Key f23157a;

    /* renamed from: b */
    public final Key f23158b;

    public C1565my(Key key, Key key2) {
        this.f23157a = key;
        this.f23158b = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1565my)) {
            return false;
        }
        C1565my c1565my = (C1565my) obj;
        if (!this.f23157a.equals(c1565my.f23157a) || !this.f23158b.equals(c1565my.f23158b)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.f23158b.hashCode() + (this.f23157a.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f23157a + ", signature=" + this.f23158b + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f23157a.updateDiskCacheKey(messageDigest);
        this.f23158b.updateDiskCacheKey(messageDigest);
    }
}
