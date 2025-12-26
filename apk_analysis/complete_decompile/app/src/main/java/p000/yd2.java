package p000;

import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class yd2 implements FactoryPools.Poolable {

    /* renamed from: a */
    public final MessageDigest f28911a;

    /* renamed from: b */
    public final StateVerifier f28912b = StateVerifier.newInstance();

    public yd2(MessageDigest messageDigest) {
        this.f28911a = messageDigest;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier getVerifier() {
        return this.f28912b;
    }
}
