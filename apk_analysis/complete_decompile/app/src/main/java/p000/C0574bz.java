package p000;

import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.encoding.Base64;
import kotlin.io.encoding.Base64Kt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: bz */
/* loaded from: classes2.dex */
public final class C0574bz extends InputStream {

    /* renamed from: a */
    public final InputStream f8190a;

    /* renamed from: b */
    public final Base64 f8191b;

    /* renamed from: c */
    public boolean f8192c;

    /* renamed from: d */
    public boolean f8193d;

    /* renamed from: e */
    public final byte[] f8194e;

    /* renamed from: f */
    public final byte[] f8195f;

    /* renamed from: g */
    public final byte[] f8196g;

    /* renamed from: h */
    public int f8197h;

    /* renamed from: i */
    public int f8198i;

    public C0574bz(InputStream input, Base64 base64) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(base64, "base64");
        this.f8190a = input;
        this.f8191b = base64;
        this.f8194e = new byte[1];
        this.f8195f = new byte[1024];
        this.f8196g = new byte[1024];
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f8192c) {
            this.f8192c = true;
            this.f8190a.close();
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        int i = this.f8197h;
        int i2 = this.f8198i;
        if (i < i2) {
            int i3 = this.f8196g[i] & 255;
            int i4 = i + 1;
            this.f8197h = i4;
            if (i4 == i2) {
                this.f8197h = 0;
                this.f8198i = 0;
            }
            return i3;
        }
        byte[] bArr = this.f8194e;
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return -1;
        }
        if (read == 1) {
            return bArr[0] & 255;
        }
        throw new IllegalStateException("Unreachable");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int read(byte[] destination, int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int read;
        int read2;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i >= 0 && i2 >= 0 && (i3 = i + i2) <= destination.length) {
            if (!this.f8192c) {
                if (this.f8193d) {
                    return -1;
                }
                int i5 = 0;
                if (i2 == 0) {
                    return 0;
                }
                int i6 = this.f8198i;
                int i7 = this.f8197h;
                int i8 = i6 - i7;
                byte[] bArr = this.f8196g;
                if (i8 >= i2) {
                    ArraysKt___ArraysJvmKt.copyInto(bArr, destination, i, i7, i7 + i2);
                    int i9 = this.f8197h + i2;
                    this.f8197h = i9;
                    if (i9 == this.f8198i) {
                        this.f8197h = 0;
                        this.f8198i = 0;
                    }
                    return i2;
                }
                int i10 = (((i2 - (i6 - i7)) + 2) / 3) * 4;
                int i11 = i;
                while (true) {
                    z = this.f8193d;
                    if (z || i10 <= 0) {
                        break;
                    }
                    byte[] bArr2 = this.f8195f;
                    int min = Math.min(bArr2.length, i10);
                    int i12 = i5;
                    while (true) {
                        z2 = this.f8193d;
                        if (z2 || i12 >= min) {
                            break;
                        }
                        Base64 base64 = this.f8191b;
                        boolean isMimeScheme = base64.getIsMimeScheme();
                        InputStream inputStream = this.f8190a;
                        if (!isMimeScheme) {
                            read = inputStream.read();
                            if (read != -1) {
                                this.f8193d = true;
                            } else if (read != 61) {
                                bArr2[i12] = (byte) read;
                                i12++;
                            } else {
                                bArr2[i12] = Base64.padSymbol;
                                if ((i12 & 3) == 2) {
                                    if (!base64.getIsMimeScheme()) {
                                        read2 = inputStream.read();
                                        if (read2 >= 0) {
                                            bArr2[i12 + 1] = (byte) read2;
                                        }
                                        i12 += 2;
                                    }
                                    do {
                                        read2 = inputStream.read();
                                        if (read2 == -1) {
                                            break;
                                        }
                                    } while (!Base64Kt.isInMimeAlphabet(read2));
                                    if (read2 >= 0) {
                                    }
                                    i12 += 2;
                                } else {
                                    i12++;
                                }
                                this.f8193d = true;
                            }
                        }
                        do {
                            read = inputStream.read();
                            if (read == -1) {
                                break;
                            }
                        } while (!Base64Kt.isInMimeAlphabet(read));
                        if (read != -1) {
                        }
                    }
                    if (!z2 && i12 != min) {
                        throw new IllegalStateException("Check failed.");
                    }
                    i10 -= i12;
                    int i13 = this.f8198i;
                    int decodeIntoByteArray = i13 + this.f8191b.decodeIntoByteArray(this.f8195f, this.f8196g, i13, 0, i12);
                    this.f8198i = decodeIntoByteArray;
                    int min2 = Math.min(decodeIntoByteArray - this.f8197h, i3 - i11);
                    int i14 = this.f8197h;
                    ArraysKt___ArraysJvmKt.copyInto(bArr, destination, i11, i14, i14 + min2);
                    int i15 = this.f8197h + min2;
                    this.f8197h = i15;
                    if (i15 == this.f8198i) {
                        i4 = 0;
                        this.f8197h = 0;
                        this.f8198i = 0;
                    } else {
                        i4 = 0;
                    }
                    int length = bArr.length;
                    int i16 = this.f8198i;
                    if ((bArr2.length / 4) * 3 > length - i16) {
                        ArraysKt___ArraysJvmKt.copyInto(bArr, bArr, i4, this.f8197h, i16);
                        this.f8198i -= this.f8197h;
                        this.f8197h = i4;
                    }
                    i11 += min2;
                    i5 = i4;
                }
                if (i11 == i && z) {
                    return -1;
                }
                return i11 - i;
            }
            throw new IOException("The input stream is closed.");
        }
        StringBuilder m8302v = ye0.m8302v("offset: ", i, ", length: ", i2, ", buffer size: ");
        m8302v.append(destination.length);
        throw new IndexOutOfBoundsException(m8302v.toString());
    }
}
