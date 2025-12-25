package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class sz0 extends AbstractC1966x0 {

    /* renamed from: a */
    public final HashFunction[] f26631a;

    public sz0(HashFunction[] hashFunctionArr) {
        boolean z;
        for (HashFunction hashFunction : hashFunctionArr) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.f26631a = hashFunctionArr;
        for (HashFunction hashFunction2 : hashFunctionArr) {
            if (hashFunction2.bits() % 8 == 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction2.bits(), (Object) hashFunction2);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        int i = 0;
        for (HashFunction hashFunction : this.f26631a) {
            i += hashFunction.bits();
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof sz0) {
            return Arrays.equals(this.f26631a, ((sz0) obj).f26631a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f26631a);
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        HashFunction[] hashFunctionArr = this.f26631a;
        int length = hashFunctionArr.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i = 0; i < length; i++) {
            hasherArr[i] = hashFunctionArr[i].newHasher();
        }
        return new C1928w(this, hasherArr);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        HashFunction[] hashFunctionArr = this.f26631a;
        int length = hashFunctionArr.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = hashFunctionArr[i2].newHasher(i);
        }
        return new C1928w(this, hasherArr);
    }
}
