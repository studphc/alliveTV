package p000;

import com.bumptech.glide.load.Option;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a23 implements Option.CacheKeyUpdater {

    /* renamed from: a */
    public final ByteBuffer f28a = ByteBuffer.allocate(8);

    @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
    public final void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f28a) {
            this.f28a.position(0);
            messageDigest.update(this.f28a.putLong(l.longValue()).array());
        }
    }
}
