package p000;

import com.bumptech.glide.util.pool.FactoryPools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class xd2 implements FactoryPools.Factory {
    @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
    public final Object create() {
        try {
            return new yd2(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
