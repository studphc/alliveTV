package p000;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;

/* loaded from: classes.dex */
public final class e82 extends BinarySearchSeeker {
    /* renamed from: a */
    public static int m4669a(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
