package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class tb2 implements Key {

    /* renamed from: i */
    public static final LruCache f26759i = new LruCache(50);

    /* renamed from: a */
    public final ArrayPool f26760a;

    /* renamed from: b */
    public final Key f26761b;

    /* renamed from: c */
    public final Key f26762c;

    /* renamed from: d */
    public final int f26763d;

    /* renamed from: e */
    public final int f26764e;

    /* renamed from: f */
    public final Class f26765f;

    /* renamed from: g */
    public final Options f26766g;

    /* renamed from: h */
    public final Transformation f26767h;

    public tb2(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation transformation, Class cls, Options options) {
        this.f26760a = arrayPool;
        this.f26761b = key;
        this.f26762c = key2;
        this.f26763d = i;
        this.f26764e = i2;
        this.f26767h = transformation;
        this.f26765f = cls;
        this.f26766g = options;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof tb2)) {
            return false;
        }
        tb2 tb2Var = (tb2) obj;
        if (this.f26764e != tb2Var.f26764e || this.f26763d != tb2Var.f26763d || !Util.bothNullOrEqual(this.f26767h, tb2Var.f26767h) || !this.f26765f.equals(tb2Var.f26765f) || !this.f26761b.equals(tb2Var.f26761b) || !this.f26762c.equals(tb2Var.f26762c) || !this.f26766g.equals(tb2Var.f26766g)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        int hashCode = ((((this.f26762c.hashCode() + (this.f26761b.hashCode() * 31)) * 31) + this.f26763d) * 31) + this.f26764e;
        Transformation transformation = this.f26767h;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return this.f26766g.hashCode() + ((this.f26765f.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f26761b + ", signature=" + this.f26762c + ", width=" + this.f26763d + ", height=" + this.f26764e + ", decodedResourceClass=" + this.f26765f + ", transformation='" + this.f26767h + "', options=" + this.f26766g + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        ArrayPool arrayPool = this.f26760a;
        byte[] bArr = (byte[]) arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f26763d).putInt(this.f26764e).array();
        this.f26762c.updateDiskCacheKey(messageDigest);
        this.f26761b.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation transformation = this.f26767h;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.f26766g.updateDiskCacheKey(messageDigest);
        LruCache lruCache = f26759i;
        Class cls = this.f26765f;
        byte[] bArr2 = (byte[]) lruCache.get(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(Key.CHARSET);
            lruCache.put(cls, bArr2);
        }
        messageDigest.update(bArr2);
        arrayPool.put(bArr);
    }
}
