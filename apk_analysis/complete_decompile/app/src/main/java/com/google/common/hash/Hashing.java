package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.crypto.spec.SecretKeySpec;
import p000.AbstractC1726qj;
import p000.C1924vw;
import p000.ae0;
import p000.cc0;
import p000.jk2;
import p000.lz0;
import p000.mq1;
import p000.oq1;
import p000.pe1;
import p000.rz0;
import p000.sz0;
import p000.tz0;
import p000.uz0;
import p000.vz0;
import p000.wz0;
import p000.xz0;

/* loaded from: classes2.dex */
public final class Hashing {

    /* renamed from: a */
    public static final int f15058a = (int) System.currentTimeMillis();

    /* renamed from: a */
    public static String m4192a(String str, Key key) {
        String algorithm = key.getAlgorithm();
        String format = key.getFormat();
        StringBuilder sb = new StringBuilder("Hashing.");
        sb.append(str);
        sb.append("(Key[algorithm=");
        sb.append(algorithm);
        sb.append(", format=");
        return AbstractC1726qj.m7061q(sb, format, "])");
    }

    public static HashFunction adler32() {
        return rz0.ADLER_32.f26195a;
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        boolean z;
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            if (asBytes.length == bits) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) ((bArr[i] * 37) ^ asBytes[i]);
            }
        }
        return new lz0(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        boolean z;
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            if (asBytes.length == bits) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) (bArr[i] + asBytes[i]);
            }
        }
        return new lz0(bArr);
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        Collections.addAll(arrayList, hashFunctionArr);
        return new sz0((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int consistentHash(HashCode hashCode, int i) {
        return consistentHash(hashCode.padToLong(), i);
    }

    public static HashFunction crc32() {
        return rz0.CRC_32.f26195a;
    }

    public static HashFunction crc32c() {
        return C1924vw.f27979a;
    }

    public static HashFunction farmHashFingerprint64() {
        return cc0.f8324a;
    }

    public static HashFunction fingerprint2011() {
        return ae0.f150a;
    }

    public static HashFunction goodFastHash(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Number of bits must be positive");
        int i2 = (i + 31) & (-32);
        if (i2 == 32) {
            return oq1.f24866e;
        }
        if (i2 <= 128) {
            return mq1.f23059c;
        }
        int i3 = (i2 + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i3];
        hashFunctionArr[0] = mq1.f23059c;
        int i4 = f15058a;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 += 1500450271;
            hashFunctionArr[i5] = murmur3_128(i4);
        }
        return new sz0(hashFunctionArr);
    }

    public static HashFunction hmacMd5(Key key) {
        return new pe1("HmacMD5", key, m4192a("hmacMd5", key));
    }

    public static HashFunction hmacSha1(Key key) {
        return new pe1("HmacSHA1", key, m4192a("hmacSha1", key));
    }

    public static HashFunction hmacSha256(Key key) {
        return new pe1("HmacSHA256", key, m4192a("hmacSha256", key));
    }

    public static HashFunction hmacSha512(Key key) {
        return new pe1("HmacSHA512", key, m4192a("hmacSha512", key));
    }

    @Deprecated
    public static HashFunction md5() {
        return tz0.f27037a;
    }

    public static HashFunction murmur3_128(int i) {
        return new mq1(i);
    }

    @Deprecated
    public static HashFunction murmur3_32(int i) {
        return new oq1(i, false);
    }

    public static HashFunction murmur3_32_fixed(int i) {
        return new oq1(i, true);
    }

    @Deprecated
    public static HashFunction sha1() {
        return uz0.f27556a;
    }

    public static HashFunction sha256() {
        return vz0.f28017a;
    }

    public static HashFunction sha384() {
        return wz0.f28404a;
    }

    public static HashFunction sha512() {
        return xz0.f28771a;
    }

    public static HashFunction sipHash24() {
        return jk2.f20533e;
    }

    public static int consistentHash(long j, int i) {
        int i2 = 0;
        Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        while (true) {
            j = (j * 2862933555777941757L) + 1;
            int i3 = (int) ((i2 + 1) / ((((int) (j >>> 33)) + 1) / 2.147483648E9d));
            if (i3 < 0 || i3 >= i) {
                break;
            }
            i2 = i3;
        }
        return i2;
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    public static HashFunction murmur3_128() {
        return mq1.f23058b;
    }

    @Deprecated
    public static HashFunction murmur3_32() {
        return oq1.f24864c;
    }

    public static HashFunction murmur3_32_fixed() {
        return oq1.f24865d;
    }

    public static HashFunction sipHash24(long j, long j2) {
        return new jk2(j, j2);
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<HashFunction> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Preconditions.checkArgument(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new sz0((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }
}
