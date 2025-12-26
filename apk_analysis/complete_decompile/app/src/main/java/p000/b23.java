package p000;

import com.bumptech.glide.load.Option;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class b23 implements Option.CacheKeyUpdater {

    /* renamed from: a */
    public final ByteBuffer f7875a = ByteBuffer.allocate(4);

    @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
    public final void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num != null) {
            messageDigest.update(bArr);
            synchronized (this.f7875a) {
                this.f7875a.position(0);
                messageDigest.update(this.f7875a.putInt(num.intValue()).array());
            }
        }
    }
}
