package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public final class rn1 extends AbstractC1966x0 implements Serializable {

    /* renamed from: a */
    public final MessageDigest f26038a;

    /* renamed from: b */
    public final int f26039b;

    /* renamed from: c */
    public final boolean f26040c;

    /* renamed from: d */
    public final String f26041d;

    public rn1(String str, String str2) {
        boolean z;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            this.f26038a = messageDigest;
            this.f26039b = messageDigest.getDigestLength();
            this.f26041d = (String) Preconditions.checkNotNull(str2);
            try {
                messageDigest.clone();
                z = true;
            } catch (CloneNotSupportedException unused) {
                z = false;
            }
            this.f26040c = z;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return this.f26039b * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        boolean z = this.f26040c;
        int i = this.f26039b;
        MessageDigest messageDigest = this.f26038a;
        if (z) {
            try {
                return new pn1((MessageDigest) messageDigest.clone(), i);
            } catch (CloneNotSupportedException unused) {
            }
        }
        try {
            return new pn1(MessageDigest.getInstance(messageDigest.getAlgorithm()), i);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final String toString() {
        return this.f26041d;
    }

    public Object writeReplace() {
        return new qn1(this.f26038a.getAlgorithm(), this.f26039b, this.f26041d);
    }

    public rn1(String str, int i, String str2) {
        this.f26041d = (String) Preconditions.checkNotNull(str2);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            this.f26038a = messageDigest;
            int digestLength = messageDigest.getDigestLength();
            boolean z = false;
            Preconditions.checkArgument(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
            this.f26039b = i;
            try {
                messageDigest.clone();
                z = true;
            } catch (CloneNotSupportedException unused) {
            }
            this.f26040c = z;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
