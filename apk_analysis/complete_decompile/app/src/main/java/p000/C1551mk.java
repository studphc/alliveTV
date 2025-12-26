package p000;

import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: mk */
/* loaded from: classes.dex */
public final class C1551mk implements InterfaceC1588nk {

    /* renamed from: a */
    public final boolean f22963a;

    /* renamed from: b */
    public final Cipher f22964b;

    /* renamed from: c */
    public final SecretKeySpec f22965c;

    /* renamed from: d */
    public final SecureRandom f22966d;

    /* renamed from: e */
    public final AtomicFile f22967e;

    /* renamed from: f */
    public boolean f22968f;

    /* renamed from: g */
    public lc2 f22969g;

    public C1551mk(File file, byte[] bArr, boolean z) {
        boolean z2;
        Cipher cipher;
        SecretKeySpec secretKeySpec;
        if (bArr == null && z) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (bArr != null) {
            Assertions.checkArgument(bArr.length == 16);
            try {
                if (Util.SDK_INT == 18) {
                    try {
                        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                    } catch (Throwable unused) {
                    }
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                }
                cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            Assertions.checkArgument(!z);
            cipher = null;
            secretKeySpec = null;
        }
        this.f22963a = z;
        this.f22964b = cipher;
        this.f22965c = secretKeySpec;
        this.f22966d = z ? new SecureRandom() : null;
        this.f22967e = new AtomicFile(file);
    }

    /* renamed from: h */
    public static int m6147h(C1394kk c1394kk, int i) {
        int hashCode = c1394kk.f20878b.hashCode() + (c1394kk.f20877a * 31);
        if (i < 2) {
            long m8193a = AbstractC1997xv.m8193a(c1394kk.f20881e);
            return (hashCode * 31) + ((int) (m8193a ^ (m8193a >>> 32)));
        }
        return (hashCode * 31) + c1394kk.f20881e.hashCode();
    }

    /* renamed from: i */
    public static C1394kk m6148i(int i, DataInputStream dataInputStream) {
        DefaultContentMetadata m6572a;
        int readInt = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if (i < 2) {
            long readLong = dataInputStream.readLong();
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
            m6572a = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
        } else {
            m6572a = C1625ok.m6572a(dataInputStream);
        }
        return new C1394kk(readInt, readUTF, m6572a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [lc2, java.io.BufferedOutputStream] */
    @Override // p000.InterfaceC1588nk
    /* renamed from: a */
    public final void mo5930a(HashMap hashMap) {
        Cipher cipher = this.f22964b;
        AtomicFile atomicFile = this.f22967e;
        Closeable closeable = null;
        try {
            OutputStream startWrite = atomicFile.startWrite();
            lc2 lc2Var = this.f22969g;
            if (lc2Var == null) {
                this.f22969g = new BufferedOutputStream(startWrite);
            } else {
                lc2Var.m5920a(startWrite);
            }
            lc2 lc2Var2 = this.f22969g;
            DataOutputStream dataOutputStream = new DataOutputStream(lc2Var2);
            try {
                dataOutputStream.writeInt(2);
                boolean z = this.f22963a;
                dataOutputStream.writeInt(z ? 1 : 0);
                if (z) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) Util.castNonNull(this.f22966d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) Util.castNonNull(cipher)).init(1, (Key) Util.castNonNull(this.f22965c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(lc2Var2, cipher));
                    } catch (InvalidAlgorithmParameterException e) {
                        e = e;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(hashMap.size());
                int i = 0;
                for (C1394kk c1394kk : hashMap.values()) {
                    dataOutputStream.writeInt(c1394kk.f20877a);
                    dataOutputStream.writeUTF(c1394kk.f20878b);
                    C1625ok.m6573b(c1394kk.f20881e, dataOutputStream);
                    i += m6147h(c1394kk, 2);
                }
                dataOutputStream.writeInt(i);
                atomicFile.endWrite(dataOutputStream);
                Util.closeQuietly(null);
                this.f22968f = false;
            } catch (Throwable th) {
                th = th;
                closeable = dataOutputStream;
                Util.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: b */
    public final void mo5931b(C1394kk c1394kk, boolean z) {
        this.f22968f = true;
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: c */
    public final void mo5932c(C1394kk c1394kk) {
        this.f22968f = true;
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: d */
    public final boolean mo5933d() {
        return this.f22967e.exists();
    }

    @Override // p000.InterfaceC1588nk
    public final void delete() {
        this.f22967e.delete();
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: e */
    public final void mo5934e(HashMap hashMap) {
        if (!this.f22968f) {
            return;
        }
        mo5930a(hashMap);
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: g */
    public final void mo5936g(HashMap hashMap, SparseArray sparseArray) {
        BufferedInputStream bufferedInputStream;
        DataInputStream dataInputStream;
        boolean z = true;
        Assertions.checkState(!this.f22968f);
        AtomicFile atomicFile = this.f22967e;
        if (atomicFile.exists()) {
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(atomicFile.openRead());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        Cipher cipher = this.f22964b;
                        if (cipher != null) {
                            byte[] bArr = new byte[16];
                            dataInputStream.readFully(bArr);
                            try {
                                cipher.init(2, (Key) Util.castNonNull(this.f22965c), new IvParameterSpec(bArr));
                                dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, cipher));
                            } catch (InvalidAlgorithmParameterException e) {
                                e = e;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e2) {
                                e = e2;
                                throw new IllegalStateException(e);
                            }
                        }
                    } else if (this.f22963a) {
                        this.f22968f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        C1394kk m6148i = m6148i(readInt, dataInputStream);
                        String str = m6148i.f20878b;
                        hashMap.put(str, m6148i);
                        sparseArray.put(m6148i.f20877a, str);
                        i += m6147h(m6148i, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    if (dataInputStream.read() != -1) {
                        z = false;
                    }
                    if (readInt3 == i && z) {
                        Util.closeQuietly(dataInputStream);
                        return;
                    }
                }
                Util.closeQuietly(dataInputStream);
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    Util.closeQuietly(dataInputStream2);
                }
                hashMap.clear();
                sparseArray.clear();
                atomicFile.delete();
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    Util.closeQuietly(dataInputStream2);
                }
                throw th;
            }
            hashMap.clear();
            sparseArray.clear();
            atomicFile.delete();
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: f */
    public final void mo5935f(long j) {
    }
}
