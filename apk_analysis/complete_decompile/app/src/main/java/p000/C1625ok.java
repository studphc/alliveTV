package p000;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ok */
/* loaded from: classes.dex */
public final class C1625ok {

    /* renamed from: a */
    public final HashMap f23831a;

    /* renamed from: b */
    public final SparseArray f23832b;

    /* renamed from: c */
    public final SparseBooleanArray f23833c;

    /* renamed from: d */
    public final SparseBooleanArray f23834d;

    /* renamed from: e */
    public final InterfaceC1588nk f23835e;

    /* renamed from: f */
    public InterfaceC1588nk f23836f;

    public C1625ok(DatabaseProvider databaseProvider, File file, byte[] bArr, boolean z, boolean z2) {
        boolean z3;
        C1514lk c1514lk;
        if (databaseProvider == null && file == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assertions.checkState(z3);
        this.f23831a = new HashMap();
        this.f23832b = new SparseArray();
        this.f23833c = new SparseBooleanArray();
        this.f23834d = new SparseBooleanArray();
        if (databaseProvider != null) {
            c1514lk = new C1514lk(databaseProvider);
        } else {
            c1514lk = null;
        }
        C1551mk c1551mk = file != null ? new C1551mk(new File(file, "cached_content_index.exi"), bArr, z) : null;
        if (c1514lk != null && (c1551mk == null || !z2)) {
            this.f23835e = c1514lk;
            this.f23836f = c1551mk;
        } else {
            this.f23835e = (InterfaceC1588nk) Util.castNonNull(c1551mk);
            this.f23836f = c1514lk;
        }
    }

    /* renamed from: a */
    public static DefaultContentMetadata m6572a(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i2 = 0;
                while (i2 != readInt2) {
                    int i3 = i2 + min;
                    bArr = Arrays.copyOf(bArr, i3);
                    dataInputStream.readFully(bArr, i2, min);
                    min = Math.min(readInt2 - i3, 10485760);
                    i2 = i3;
                }
                hashMap.put(readUTF, bArr);
            } else {
                throw new IOException(ye0.m8291k(readInt2, "Invalid value size: "));
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    /* renamed from: b */
    public static void m6573b(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) {
        Set<Map.Entry<String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry<String, byte[]> entry : entrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    /* renamed from: c */
    public final C1394kk m6574c(String str) {
        return (C1394kk) this.f23831a.get(str);
    }

    /* renamed from: d */
    public final C1394kk m6575d(String str) {
        int keyAt;
        HashMap hashMap = this.f23831a;
        C1394kk c1394kk = (C1394kk) hashMap.get(str);
        if (c1394kk == null) {
            SparseArray sparseArray = this.f23832b;
            int size = sparseArray.size();
            int i = 0;
            if (size == 0) {
                keyAt = 0;
            } else {
                keyAt = sparseArray.keyAt(size - 1) + 1;
            }
            if (keyAt < 0) {
                while (i < size && i == sparseArray.keyAt(i)) {
                    i++;
                }
                keyAt = i;
            }
            C1394kk c1394kk2 = new C1394kk(keyAt, str, DefaultContentMetadata.EMPTY);
            hashMap.put(str, c1394kk2);
            sparseArray.put(keyAt, str);
            this.f23834d.put(keyAt, true);
            this.f23835e.mo5932c(c1394kk2);
            return c1394kk2;
        }
        return c1394kk;
    }

    /* renamed from: e */
    public final void m6576e(long j) {
        InterfaceC1588nk interfaceC1588nk;
        InterfaceC1588nk interfaceC1588nk2 = this.f23835e;
        interfaceC1588nk2.mo5935f(j);
        InterfaceC1588nk interfaceC1588nk3 = this.f23836f;
        if (interfaceC1588nk3 != null) {
            interfaceC1588nk3.mo5935f(j);
        }
        boolean mo5933d = interfaceC1588nk2.mo5933d();
        SparseArray sparseArray = this.f23832b;
        HashMap hashMap = this.f23831a;
        if (!mo5933d && (interfaceC1588nk = this.f23836f) != null && interfaceC1588nk.mo5933d()) {
            this.f23836f.mo5936g(hashMap, sparseArray);
            interfaceC1588nk2.mo5930a(hashMap);
        } else {
            interfaceC1588nk2.mo5936g(hashMap, sparseArray);
        }
        InterfaceC1588nk interfaceC1588nk4 = this.f23836f;
        if (interfaceC1588nk4 != null) {
            interfaceC1588nk4.delete();
            this.f23836f = null;
        }
    }

    /* renamed from: f */
    public final void m6577f(String str) {
        HashMap hashMap = this.f23831a;
        C1394kk c1394kk = (C1394kk) hashMap.get(str);
        if (c1394kk != null && c1394kk.f20879c.isEmpty() && c1394kk.f20880d.isEmpty()) {
            hashMap.remove(str);
            SparseBooleanArray sparseBooleanArray = this.f23834d;
            int i = c1394kk.f20877a;
            boolean z = sparseBooleanArray.get(i);
            this.f23835e.mo5931b(c1394kk, z);
            SparseArray sparseArray = this.f23832b;
            if (z) {
                sparseArray.remove(i);
                sparseBooleanArray.delete(i);
            } else {
                sparseArray.put(i, null);
                this.f23833c.put(i, true);
            }
        }
    }

    /* renamed from: g */
    public final void m6578g() {
        this.f23835e.mo5934e(this.f23831a);
        SparseBooleanArray sparseBooleanArray = this.f23833c;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            this.f23832b.remove(sparseBooleanArray.keyAt(i));
        }
        sparseBooleanArray.clear();
        this.f23834d.clear();
    }
}
