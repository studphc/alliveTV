package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class pe1 extends AbstractC1966x0 {

    /* renamed from: a */
    public final Mac f25135a;

    /* renamed from: b */
    public final Key f25136b;

    /* renamed from: c */
    public final String f25137c;

    /* renamed from: d */
    public final int f25138d;

    /* renamed from: e */
    public final boolean f25139e;

    public pe1(String str, Key key, String str2) {
        boolean z;
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            this.f25135a = mac;
            this.f25136b = (Key) Preconditions.checkNotNull(key);
            this.f25137c = (String) Preconditions.checkNotNull(str2);
            this.f25138d = mac.getMacLength() * 8;
            try {
                mac.clone();
                z = true;
            } catch (CloneNotSupportedException unused) {
                z = false;
            }
            this.f25139e = z;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return this.f25138d;
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        boolean z = this.f25139e;
        Mac mac = this.f25135a;
        if (z) {
            try {
                return new oe1((Mac) mac.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        String algorithm = mac.getAlgorithm();
        Key key = this.f25136b;
        try {
            Mac mac2 = Mac.getInstance(algorithm);
            mac2.init(key);
            return new oe1(mac2);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final String toString() {
        return this.f25137c;
    }
}
