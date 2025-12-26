package p000;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.widget.WithHint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.gms.internal.measurement.zzld;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
public abstract class o63 {

    /* renamed from: a */
    public static final float[][] f23619a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b */
    public static final float[][] f23620b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c */
    public static final float[] f23621c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d */
    public static final float[][] f23622d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* renamed from: e */
    public static final byte[] f23623e = {112, 114, 111, 0};

    /* renamed from: f */
    public static final byte[] f23624f = {112, 114, 109, 0};

    /* renamed from: g */
    public static Class f23625g;

    /* renamed from: h */
    public static Method f23626h;

    /* renamed from: i */
    public static Method f23627i;

    /* renamed from: j */
    public static Method f23628j;

    /* renamed from: k */
    public static Method f23629k;

    /* renamed from: l */
    public static Method f23630l;

    /* renamed from: m */
    public static Field f23631m;

    /* renamed from: n */
    public static boolean f23632n;

    /* renamed from: o */
    public static Class f23633o;

    /* renamed from: p */
    public static boolean f23634p;

    /* renamed from: q */
    public static Field f23635q;

    /* renamed from: r */
    public static boolean f23636r;

    /* renamed from: s */
    public static Field f23637s;

    /* renamed from: t */
    public static boolean f23638t;

    /* renamed from: A */
    public static int[] m6446A(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += (int) p63.m6848H(byteArrayInputStream, 2);
            iArr[i3] = i2;
        }
        return iArr;
    }

    /* renamed from: B */
    public static r30[] m6447B(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, r30[] r30VarArr) {
        byte[] bArr3 = ProfileVersion.f6918f;
        if (Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(ProfileVersion.f6913a, bArr2)) {
                if (Arrays.equals(bArr, bArr3)) {
                    int m6848H = (int) p63.m6848H(fileInputStream, 1);
                    byte[] m6847G = p63.m6847G(fileInputStream, (int) p63.m6848H(fileInputStream, 4), (int) p63.m6848H(fileInputStream, 4));
                    if (fileInputStream.read() <= 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m6847G);
                        try {
                            r30[] m6448C = m6448C(byteArrayInputStream, m6848H, r30VarArr);
                            byteArrayInputStream.close();
                            return m6448C;
                        } catch (Throwable th) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    throw new IllegalStateException("Content found after the end of file");
                }
                throw new IllegalStateException("Unsupported meta version");
            }
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(bArr, ProfileVersion.f6919g)) {
            int m6848H2 = (int) p63.m6848H(fileInputStream, 2);
            byte[] m6847G2 = p63.m6847G(fileInputStream, (int) p63.m6848H(fileInputStream, 4), (int) p63.m6848H(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(m6847G2);
                try {
                    r30[] m6449D = m6449D(byteArrayInputStream2, bArr2, m6848H2, r30VarArr);
                    byteArrayInputStream2.close();
                    return m6449D;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported meta version");
    }

    /* renamed from: C */
    public static r30[] m6448C(ByteArrayInputStream byteArrayInputStream, int i, r30[] r30VarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new r30[0];
        }
        if (i == r30VarArr.length) {
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                int m6848H = (int) p63.m6848H(byteArrayInputStream, 2);
                iArr[i2] = (int) p63.m6848H(byteArrayInputStream, 2);
                strArr[i2] = new String(p63.m6846F(byteArrayInputStream, m6848H), StandardCharsets.UTF_8);
            }
            for (int i3 = 0; i3 < i; i3++) {
                r30 r30Var = r30VarArr[i3];
                if (r30Var.f25847b.equals(strArr[i3])) {
                    int i4 = iArr[i3];
                    r30Var.f25850e = i4;
                    r30Var.f25853h = m6446A(byteArrayInputStream, i4);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return r30VarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    /* renamed from: D */
    public static r30[] m6449D(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, r30[] r30VarArr) {
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new r30[0];
        }
        if (i == r30VarArr.length) {
            for (int i2 = 0; i2 < i; i2++) {
                p63.m6848H(byteArrayInputStream, 2);
                String str2 = new String(p63.m6846F(byteArrayInputStream, (int) p63.m6848H(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
                long m6848H = p63.m6848H(byteArrayInputStream, 4);
                int m6848H2 = (int) p63.m6848H(byteArrayInputStream, 2);
                r30 r30Var = null;
                if (r30VarArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= r30VarArr.length) {
                            break;
                        }
                        if (r30VarArr[i3].f25847b.equals(str)) {
                            r30Var = r30VarArr[i3];
                            break;
                        }
                        i3++;
                    }
                }
                if (r30Var != null) {
                    r30Var.f25849d = m6848H;
                    int[] m6446A = m6446A(byteArrayInputStream, m6848H2);
                    if (Arrays.equals(bArr, ProfileVersion.f6917e)) {
                        r30Var.f25850e = m6848H2;
                        r30Var.f25853h = m6446A;
                    }
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return r30VarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    /* renamed from: E */
    public static r30[] m6450E(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, ProfileVersion.f6914b)) {
            int m6848H = (int) p63.m6848H(fileInputStream, 1);
            byte[] m6847G = p63.m6847G(fileInputStream, (int) p63.m6848H(fileInputStream, 4), (int) p63.m6848H(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m6847G);
                try {
                    r30[] m6451F = m6451F(byteArrayInputStream, str, m6848H);
                    byteArrayInputStream.close();
                    return m6451F;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported version");
    }

    /* renamed from: F */
    public static r30[] m6451F(ByteArrayInputStream byteArrayInputStream, String str, int i) {
        TreeMap treeMap;
        int i2;
        if (byteArrayInputStream.available() == 0) {
            return new r30[0];
        }
        r30[] r30VarArr = new r30[i];
        for (int i3 = 0; i3 < i; i3++) {
            int m6848H = (int) p63.m6848H(byteArrayInputStream, 2);
            int m6848H2 = (int) p63.m6848H(byteArrayInputStream, 2);
            r30VarArr[i3] = new r30(str, new String(p63.m6846F(byteArrayInputStream, m6848H), StandardCharsets.UTF_8), p63.m6848H(byteArrayInputStream, 4), m6848H2, (int) p63.m6848H(byteArrayInputStream, 4), (int) p63.m6848H(byteArrayInputStream, 4), new int[m6848H2], new TreeMap());
        }
        for (int i4 = 0; i4 < i; i4++) {
            r30 r30Var = r30VarArr[i4];
            int available = byteArrayInputStream.available() - r30Var.f25851f;
            int i5 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = r30Var.f25854i;
                if (available2 <= available) {
                    break;
                }
                i5 += (int) p63.m6848H(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i5), 1);
                for (int m6848H3 = (int) p63.m6848H(byteArrayInputStream, 2); m6848H3 > 0; m6848H3--) {
                    p63.m6848H(byteArrayInputStream, 2);
                    int m6848H4 = (int) p63.m6848H(byteArrayInputStream, 1);
                    if (m6848H4 != 6 && m6848H4 != 7) {
                        while (m6848H4 > 0) {
                            p63.m6848H(byteArrayInputStream, 1);
                            for (int m6848H5 = (int) p63.m6848H(byteArrayInputStream, 1); m6848H5 > 0; m6848H5--) {
                                p63.m6848H(byteArrayInputStream, 2);
                            }
                            m6848H4--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                r30Var.f25853h = m6446A(byteArrayInputStream, r30Var.f25850e);
                int i6 = r30Var.f25852g;
                BitSet valueOf = BitSet.valueOf(p63.m6846F(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
                for (int i7 = 0; i7 < i6; i7++) {
                    if (valueOf.get(i7)) {
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    if (valueOf.get(i7 + i6)) {
                        i2 |= 4;
                    }
                    if (i2 != 0) {
                        Integer num = (Integer) treeMap.get(Integer.valueOf(i7));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(i7), Integer.valueOf(i2 | num.intValue()));
                    }
                }
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return r30VarArr;
    }

    /* renamed from: L */
    public static t43 m6452L(int i, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
        t43 m7449a = t43.m7449a(extractorInput, parsableByteArray);
        while (true) {
            int i2 = m7449a.f26693a;
            if (i2 != i) {
                AbstractC1726qj.m7036A(i2, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
                long j = m7449a.f26694b + 8;
                if (j <= 2147483647L) {
                    extractorInput.skipFully((int) j);
                    m7449a = t43.m7449a(extractorInput, parsableByteArray);
                } else {
                    throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + i2);
                }
            } else {
                return m7449a;
            }
        }
    }

    /* renamed from: M */
    public static int m6453M(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    /* renamed from: N */
    public static int m6454N(Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return m6453M(hashCode);
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: P */
    public static boolean m6455P(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, r30[] r30VarArr) {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = ProfileVersion.f6913a;
        int i = 0;
        if (Arrays.equals(bArr, bArr2)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                p63.m6853M(byteArrayOutputStream2, r30VarArr.length);
                int i2 = 2;
                int i3 = 2;
                for (r30 r30Var : r30VarArr) {
                    p63.m6852L(byteArrayOutputStream2, r30Var.f25848c, 4);
                    p63.m6852L(byteArrayOutputStream2, r30Var.f25849d, 4);
                    p63.m6852L(byteArrayOutputStream2, r30Var.f25852g, 4);
                    String m6471n = m6471n(bArr2, r30Var.f25846a, r30Var.f25847b);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = m6471n.getBytes(charset).length;
                    p63.m6853M(byteArrayOutputStream2, length2);
                    i3 = i3 + 14 + length2;
                    byteArrayOutputStream2.write(m6471n.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i3 == byteArray.length) {
                    j63 j63Var = new j63(byteArray, 1, false);
                    byteArrayOutputStream2.close();
                    arrayList2.add(j63Var);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < r30VarArr.length) {
                        try {
                            r30 r30Var2 = r30VarArr[i4];
                            p63.m6853M(byteArrayOutputStream3, i4);
                            p63.m6853M(byteArrayOutputStream3, r30Var2.f25850e);
                            i5 = i5 + 4 + (r30Var2.f25850e * 2);
                            int[] iArr = r30Var2.f25853h;
                            int length3 = iArr.length;
                            int i6 = i;
                            while (i < length3) {
                                int i7 = iArr[i];
                                p63.m6853M(byteArrayOutputStream3, i7 - i6);
                                i++;
                                i6 = i7;
                            }
                            i4++;
                            i = 0;
                        } catch (Throwable th) {
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (i5 == byteArray2.length) {
                        j63 j63Var2 = new j63(byteArray2, 3, true);
                        byteArrayOutputStream3.close();
                        arrayList2.add(j63Var2);
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        int i8 = 0;
                        int i9 = 0;
                        while (i8 < r30VarArr.length) {
                            try {
                                r30 r30Var3 = r30VarArr[i8];
                                Iterator it = r30Var3.f25854i.entrySet().iterator();
                                int i10 = 0;
                                while (it.hasNext()) {
                                    i10 |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                try {
                                    m6458U(byteArrayOutputStream4, i10, r30Var3);
                                    byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                    byteArrayOutputStream4.close();
                                    byteArrayOutputStream4 = new ByteArrayOutputStream();
                                    try {
                                        m6459V(byteArrayOutputStream4, r30Var3);
                                        byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                                        byteArrayOutputStream4.close();
                                        p63.m6853M(byteArrayOutputStream3, i8);
                                        int length4 = byteArray3.length + i2 + byteArray4.length;
                                        int i11 = i9 + 6;
                                        ArrayList arrayList4 = arrayList3;
                                        p63.m6852L(byteArrayOutputStream3, length4, 4);
                                        p63.m6853M(byteArrayOutputStream3, i10);
                                        byteArrayOutputStream3.write(byteArray3);
                                        byteArrayOutputStream3.write(byteArray4);
                                        i9 = i11 + length4;
                                        i8++;
                                        arrayList3 = arrayList4;
                                        i2 = 2;
                                    } finally {
                                    }
                                } finally {
                                }
                            } finally {
                                try {
                                    byteArrayOutputStream3.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                        if (i9 == byteArray5.length) {
                            j63 j63Var3 = new j63(byteArray5, 4, true);
                            byteArrayOutputStream3.close();
                            arrayList2.add(j63Var3);
                            long j = 4;
                            long size = j + j + 4 + (arrayList2.size() * 16);
                            int i12 = 4;
                            p63.m6852L(byteArrayOutputStream, arrayList2.size(), 4);
                            int i13 = 0;
                            while (i13 < arrayList2.size()) {
                                j63 j63Var4 = (j63) arrayList2.get(i13);
                                p63.m6852L(byteArrayOutputStream, AbstractC1726qj.m7050f(j63Var4.f20389a), i12);
                                p63.m6852L(byteArrayOutputStream, size, i12);
                                byte[] bArr3 = j63Var4.f20390b;
                                if (j63Var4.f20391c) {
                                    long length5 = bArr3.length;
                                    byte[] m6878w = p63.m6878w(bArr3);
                                    arrayList = arrayList5;
                                    arrayList.add(m6878w);
                                    p63.m6852L(byteArrayOutputStream, m6878w.length, 4);
                                    p63.m6852L(byteArrayOutputStream, length5, 4);
                                    length = m6878w.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr3);
                                    p63.m6852L(byteArrayOutputStream, bArr3.length, 4);
                                    p63.m6852L(byteArrayOutputStream, 0L, 4);
                                    length = bArr3.length;
                                }
                                size += length;
                                i13++;
                                arrayList5 = arrayList;
                                i12 = 4;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i14 = 0; i14 < arrayList6.size(); i14++) {
                                byteArrayOutputStream.write((byte[]) arrayList6.get(i14));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i9 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + i5 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + i3 + ", does not match actual size " + byteArray.length);
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream2.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        }
        byte[] bArr4 = ProfileVersion.f6914b;
        if (Arrays.equals(bArr, bArr4)) {
            byte[] m6467j = m6467j(r30VarArr, bArr4);
            p63.m6852L(byteArrayOutputStream, r30VarArr.length, 1);
            p63.m6852L(byteArrayOutputStream, m6467j.length, 4);
            byte[] m6878w2 = p63.m6878w(m6467j);
            p63.m6852L(byteArrayOutputStream, m6878w2.length, 4);
            byteArrayOutputStream.write(m6878w2);
            return true;
        }
        byte[] bArr5 = ProfileVersion.f6916d;
        if (Arrays.equals(bArr, bArr5)) {
            p63.m6852L(byteArrayOutputStream, r30VarArr.length, 1);
            for (r30 r30Var4 : r30VarArr) {
                int size2 = r30Var4.f25854i.size() * 4;
                String m6471n2 = m6471n(bArr5, r30Var4.f25846a, r30Var4.f25847b);
                Charset charset2 = StandardCharsets.UTF_8;
                p63.m6853M(byteArrayOutputStream, m6471n2.getBytes(charset2).length);
                p63.m6853M(byteArrayOutputStream, r30Var4.f25853h.length);
                p63.m6852L(byteArrayOutputStream, size2, 4);
                p63.m6852L(byteArrayOutputStream, r30Var4.f25848c, 4);
                byteArrayOutputStream.write(m6471n2.getBytes(charset2));
                Iterator it2 = r30Var4.f25854i.keySet().iterator();
                while (it2.hasNext()) {
                    p63.m6853M(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                    p63.m6853M(byteArrayOutputStream, 0);
                }
                for (int i15 : r30Var4.f25853h) {
                    p63.m6853M(byteArrayOutputStream, i15);
                }
            }
            return true;
        }
        byte[] bArr6 = ProfileVersion.f6915c;
        if (Arrays.equals(bArr, bArr6)) {
            byte[] m6467j2 = m6467j(r30VarArr, bArr6);
            p63.m6852L(byteArrayOutputStream, r30VarArr.length, 1);
            p63.m6852L(byteArrayOutputStream, m6467j2.length, 4);
            byte[] m6878w3 = p63.m6878w(m6467j2);
            p63.m6852L(byteArrayOutputStream, m6878w3.length, 4);
            byteArrayOutputStream.write(m6878w3);
            return true;
        }
        byte[] bArr7 = ProfileVersion.f6917e;
        if (Arrays.equals(bArr, bArr7)) {
            p63.m6853M(byteArrayOutputStream, r30VarArr.length);
            for (r30 r30Var5 : r30VarArr) {
                String m6471n3 = m6471n(bArr7, r30Var5.f25846a, r30Var5.f25847b);
                Charset charset3 = StandardCharsets.UTF_8;
                p63.m6853M(byteArrayOutputStream, m6471n3.getBytes(charset3).length);
                TreeMap treeMap = r30Var5.f25854i;
                p63.m6853M(byteArrayOutputStream, treeMap.size());
                p63.m6853M(byteArrayOutputStream, r30Var5.f25853h.length);
                p63.m6852L(byteArrayOutputStream, r30Var5.f25848c, 4);
                byteArrayOutputStream.write(m6471n3.getBytes(charset3));
                Iterator it3 = treeMap.keySet().iterator();
                while (it3.hasNext()) {
                    p63.m6853M(byteArrayOutputStream, ((Integer) it3.next()).intValue());
                }
                for (int i16 : r30Var5.f25853h) {
                    p63.m6853M(byteArrayOutputStream, i16);
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: S */
    public static void m6456S(ByteArrayOutputStream byteArrayOutputStream, r30 r30Var) {
        m6459V(byteArrayOutputStream, r30Var);
        int[] iArr = r30Var.f25853h;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            p63.m6853M(byteArrayOutputStream, i3 - i2);
            i++;
            i2 = i3;
        }
        int i4 = r30Var.f25852g;
        byte[] bArr = new byte[(((i4 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : r30Var.f25854i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i5 = intValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i6 = intValue + i4;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    /* renamed from: T */
    public static void m6457T(ByteArrayOutputStream byteArrayOutputStream, r30 r30Var, String str) {
        Charset charset = StandardCharsets.UTF_8;
        p63.m6853M(byteArrayOutputStream, str.getBytes(charset).length);
        p63.m6853M(byteArrayOutputStream, r30Var.f25850e);
        p63.m6852L(byteArrayOutputStream, r30Var.f25851f, 4);
        p63.m6852L(byteArrayOutputStream, r30Var.f25848c, 4);
        p63.m6852L(byteArrayOutputStream, r30Var.f25852g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    /* renamed from: U */
    public static void m6458U(ByteArrayOutputStream byteArrayOutputStream, int i, r30 r30Var) {
        int bitCount = Integer.bitCount(i & (-2));
        int i2 = r30Var.f25852g;
        byte[] bArr = new byte[(((bitCount * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : r30Var.f25854i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (i4 != 1 && (i4 & i) != 0) {
                    if ((i4 & intValue2) == i4) {
                        int i5 = (i3 * i2) + intValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    /* renamed from: V */
    public static void m6459V(ByteArrayOutputStream byteArrayOutputStream, r30 r30Var) {
        int i = 0;
        for (Map.Entry entry : r30Var.f25854i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                p63.m6853M(byteArrayOutputStream, intValue - i);
                p63.m6853M(byteArrayOutputStream, 0);
                i = intValue;
            }
        }
    }

    /* renamed from: W */
    public static float m6460W() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    /* renamed from: X */
    public static String m6461X(zzld zzldVar) {
        StringBuilder sb = new StringBuilder(zzldVar.zzd());
        for (int i = 0; i < zzldVar.zzd(); i++) {
            byte zza = zzldVar.zza(i);
            if (zza != 34) {
                if (zza != 39) {
                    if (zza != 92) {
                        switch (zza) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case 12:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (zza >= 32 && zza <= 126) {
                                    sb.append((char) zza);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((zza >>> 6) & 3) + 48));
                                    sb.append((char) (((zza >>> 3) & 7) + 48));
                                    sb.append((char) ((zza & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [vh2, java.lang.Object] */
    /* renamed from: a */
    public static vh2 m6462a(View view, float f, float f2, int i) {
        if (i > 0) {
            uh2 uh2Var = wh2.f28193a;
            p63.m6850J(i, view, true);
        } else {
            view.setOutlineProvider(wh2.f28193a);
        }
        ?? obj = new Object();
        obj.f27794a = view;
        obj.f27795b = f;
        obj.f27796c = f2;
        view.setZ(f);
        return obj;
    }

    /* renamed from: c */
    public static double m6463c(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        int bitLength = abs.bitLength();
        int i = bitLength - 1;
        if (i < 63) {
            return bigInteger.longValue();
        }
        if (i > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i2 = bitLength - 54;
        long longValue = abs.shiftRight(i2).longValue();
        long j = longValue >> 1;
        long j2 = 4503599627370495L & j;
        if ((longValue & 1) != 0 && ((j & 1) != 0 || abs.getLowestSetBit() < i2)) {
            j2++;
        }
        return Double.longBitsToDouble((((bitLength + AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) << 52) + j2) | (bigInteger.signum() & Long.MIN_VALUE));
    }

    /* renamed from: g */
    public static boolean m6464g(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i = t43.m7449a(extractorInput, parsableByteArray).f26693a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt != 1463899717) {
            Log.m3023e("WavHeaderReader", "Unsupported form type: " + readInt);
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public static int m6465h(double d, int i) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d * highestOneBit))) {
            int i2 = highestOneBit << 1;
            if (i2 <= 0) {
                return 1073741824;
            }
            return i2;
        }
        return highestOneBit;
    }

    /* renamed from: i */
    public static Handler m6466i() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }

    /* renamed from: j */
    public static byte[] m6467j(r30[] r30VarArr, byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (r30 r30Var : r30VarArr) {
            i2 += ((((r30Var.f25852g * 2) + 7) & (-8)) / 8) + (r30Var.f25850e * 2) + m6471n(bArr, r30Var.f25846a, r30Var.f25847b).getBytes(StandardCharsets.UTF_8).length + 16 + r30Var.f25851f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, ProfileVersion.f6915c)) {
            int length = r30VarArr.length;
            while (i < length) {
                r30 r30Var2 = r30VarArr[i];
                m6457T(byteArrayOutputStream, r30Var2, m6471n(bArr, r30Var2.f25846a, r30Var2.f25847b));
                m6456S(byteArrayOutputStream, r30Var2);
                i++;
            }
        } else {
            for (r30 r30Var3 : r30VarArr) {
                m6457T(byteArrayOutputStream, r30Var3, m6471n(bArr, r30Var3.f25846a, r30Var3.f25847b));
            }
            int length2 = r30VarArr.length;
            while (i < length2) {
                m6456S(byteArrayOutputStream, r30VarArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x0030, B:14:0x0056, B:19:0x006b, B:21:0x0073, B:32:0x0048, B:34:0x0052), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0085 -> B:13:0x0033). Please report as a decompilation issue!!! */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m6468k(FlowCollector flowCollector, ReceiveChannel receiveChannel, boolean z, Continuation continuation) {
        mf0 mf0Var;
        int i;
        ChannelIterator channelIterator;
        FlowCollector flowCollector2;
        ChannelIterator channelIterator2;
        Object hasNext;
        try {
            if (continuation instanceof mf0) {
                mf0 mf0Var2 = (mf0) continuation;
                int i2 = mf0Var2.f22925i;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    mf0Var2.f22925i = i2 - Integer.MIN_VALUE;
                    mf0Var = mf0Var2;
                    Object obj = mf0Var.f22924h;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = mf0Var.f22925i;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                z = mf0Var.f22923g;
                                channelIterator = mf0Var.f22922f;
                                receiveChannel = mf0Var.f22921e;
                                FlowCollector flowCollector3 = mf0Var.f22920d;
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector4 = flowCollector3;
                                channelIterator2 = channelIterator;
                                flowCollector = flowCollector4;
                                mf0Var.f22920d = flowCollector;
                                mf0Var.f22921e = receiveChannel;
                                mf0Var.f22922f = channelIterator2;
                                mf0Var.f22923g = z;
                                mf0Var.f22925i = 1;
                                hasNext = channelIterator2.hasNext(mf0Var);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                flowCollector2 = flowCollector;
                                channelIterator = channelIterator2;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator.next();
                                    mf0Var.f22920d = flowCollector2;
                                    mf0Var.f22921e = receiveChannel;
                                    mf0Var.f22922f = channelIterator;
                                    mf0Var.f22923g = z;
                                    mf0Var.f22925i = 2;
                                    Object emit = flowCollector2.emit(next, mf0Var);
                                    flowCollector4 = flowCollector2;
                                    if (emit == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelIterator2 = channelIterator;
                                    flowCollector = flowCollector4;
                                    mf0Var.f22920d = flowCollector;
                                    mf0Var.f22921e = receiveChannel;
                                    mf0Var.f22922f = channelIterator2;
                                    mf0Var.f22923g = z;
                                    mf0Var.f22925i = 1;
                                    hasNext = channelIterator2.hasNext(mf0Var);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    if (z) {
                                        ChannelsKt.cancelConsumed(receiveChannel, null);
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            z = mf0Var.f22923g;
                            channelIterator = mf0Var.f22922f;
                            receiveChannel = mf0Var.f22921e;
                            FlowCollector flowCollector5 = mf0Var.f22920d;
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector5;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FlowKt.ensureActive(flowCollector);
                        channelIterator2 = receiveChannel.iterator();
                        mf0Var.f22920d = flowCollector;
                        mf0Var.f22921e = receiveChannel;
                        mf0Var.f22922f = channelIterator2;
                        mf0Var.f22923g = z;
                        mf0Var.f22925i = 1;
                        hasNext = channelIterator2.hasNext(mf0Var);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z) {
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                }
                throw th2;
            }
        }
        mf0Var = new ContinuationImpl(continuation);
        Object obj2 = mf0Var.f22924h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = mf0Var.f22925i;
    }

    /* renamed from: l */
    public static double m6469l(double d) {
        Preconditions.checkArgument(!Double.isNaN(d));
        return Math.max(d, 0.0d);
    }

    /* renamed from: m */
    public static void m6470m(Object obj) {
        LongSparseArray longSparseArray;
        if (!f23634p) {
            try {
                f23633o = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                android.util.Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f23634p = true;
        }
        Class cls = f23633o;
        if (cls == null) {
            return;
        }
        if (!f23636r) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f23635q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                android.util.Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f23636r = true;
        }
        Field field = f23635q;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            android.util.Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* renamed from: n */
    public static String m6471n(byte[] bArr, String str, String str2) {
        Object obj;
        byte[] bArr2 = ProfileVersion.f6917e;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = ProfileVersion.f6916d;
        String str3 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            obj = "!";
        } else {
            obj = ":";
        }
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                return str2.replace("!", ":");
            }
            return str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (!str2.contains("!") && !str2.contains(":")) {
            if (str2.endsWith(".apk")) {
                return str2;
            }
            StringBuilder m7064t = AbstractC1726qj.m7064t(str);
            if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                str3 = ":";
            }
            return AbstractC1726qj.m7061q(m7064t, str3, str2);
        }
        if ("!".equals(obj)) {
            return str2.replace(":", "!");
        }
        if (":".equals(obj)) {
            return str2.replace("!", ":");
        }
        return str2;
    }

    /* renamed from: p */
    public static long m6472p(double d) {
        Preconditions.checkArgument(m6475t(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        if (exponent == -1023) {
            return doubleToRawLongBits << 1;
        }
        return doubleToRawLongBits | 4503599627370496L;
    }

    /* renamed from: q */
    public static boolean m6473q(Iterable iterable, Comparator comparator) {
        Comparator comparator2;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
        } else if (iterable instanceof fl2) {
            comparator2 = ((fl2) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }

    /* renamed from: r */
    public static int m6474r(float f) {
        float f2;
        boolean z;
        float f3;
        if (f < 1.0f) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f4 = (f + 16.0f) / 116.0f;
        if (f > 8.0f) {
            f2 = f4 * f4 * f4;
        } else {
            f2 = f / 903.2963f;
        }
        float f5 = f4 * f4 * f4;
        if (f5 > 0.008856452f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f3 = f5;
        } else {
            f3 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z) {
            f5 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f23621c;
        return ColorUtils.XYZToColor(f3 * fArr[0], f2 * fArr[1], f5 * fArr[2]);
    }

    /* renamed from: t */
    public static boolean m6475t(double d) {
        if (Math.getExponent(d) <= 1023) {
            return true;
        }
        return false;
    }

    /* renamed from: u */
    public static float m6476u(int i) {
        float m6477v = m6477v(Color.red(i));
        float m6477v2 = m6477v(Color.green(i));
        float m6477v3 = m6477v(Color.blue(i));
        float[] fArr = f23622d[1];
        float f = ((m6477v3 * fArr[2]) + ((m6477v2 * fArr[1]) + (m6477v * fArr[0]))) / 100.0f;
        if (f <= 0.008856452f) {
            return f * 903.2963f;
        }
        return (((float) Math.cbrt(f)) * 116.0f) - 16.0f;
    }

    /* renamed from: v */
    public static float m6477v(int i) {
        float pow;
        float f = i / 255.0f;
        if (f <= 0.04045f) {
            pow = f / 12.92f;
        } else {
            pow = (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    /* renamed from: x */
    public static void m6478x(InputConnection inputConnection, EditorInfo editorInfo, TextView textView) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof WithHint) {
                    editorInfo.hintText = ((WithHint) parent).getHint();
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: G */
    public double m6479G(Number number, RoundingMode roundingMode) {
        Number number2;
        double d;
        boolean z;
        Preconditions.checkNotNull(number, "x");
        Preconditions.checkNotNull(roundingMode, "mode");
        double mo5234H = mo5234H(number);
        if (Double.isInfinite(mo5234H)) {
            switch (du2.f16555a[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return mo5235K(number) * Double.MAX_VALUE;
                case 5:
                    if (mo5234H != Double.POSITIVE_INFINITY) {
                        return Double.NEGATIVE_INFINITY;
                    }
                    return Double.MAX_VALUE;
                case 6:
                    if (mo5234H == Double.POSITIVE_INFINITY) {
                        return Double.POSITIVE_INFINITY;
                    }
                    return -1.7976931348623157E308d;
                case 7:
                    return mo5234H;
                case 8:
                    String valueOf = String.valueOf(number);
                    throw new ArithmeticException(AbstractC1726qj.m7054j(valueOf.length() + 44, valueOf, " cannot be represented precisely as a double"));
            }
        }
        Number mo5236O = mo5236O(mo5234H, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) number).compareTo(mo5236O);
        int[] iArr = du2.f16555a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (mo5235K(number) >= 0) {
                    if (compareTo < 0) {
                        return -Math.nextUp(-mo5234H);
                    }
                    return mo5234H;
                }
                if (compareTo > 0) {
                    return Math.nextUp(mo5234H);
                }
                return mo5234H;
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d = Math.nextUp(mo5234H);
                    if (d == Double.POSITIVE_INFINITY) {
                        return mo5234H;
                    }
                    number2 = mo5236O(d, RoundingMode.CEILING);
                } else {
                    double d2 = -Math.nextUp(-mo5234H);
                    if (d2 == Double.NEGATIVE_INFINITY) {
                        return mo5234H;
                    }
                    Number mo5236O2 = mo5236O(d2, RoundingMode.FLOOR);
                    number2 = mo5236O;
                    mo5236O = mo5236O2;
                    d = mo5234H;
                    mo5234H = d2;
                }
                int compareTo2 = ((Comparable) mo5237w(number, mo5236O)).compareTo(mo5237w(number2, number));
                if (compareTo2 < 0) {
                    return mo5234H;
                }
                if (compareTo2 > 0) {
                    return d;
                }
                int i = iArr[roundingMode.ordinal()];
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (mo5235K(number) >= 0) {
                                return d;
                            }
                            return mo5234H;
                        }
                        throw new AssertionError("impossible");
                    }
                    if (mo5235K(number) < 0) {
                        return d;
                    }
                    return mo5234H;
                }
                if ((Double.doubleToRawLongBits(mo5234H) & 1) != 0) {
                    return d;
                }
                return mo5234H;
            case 5:
                if (compareTo < 0) {
                    return -Math.nextUp(-mo5234H);
                }
                return mo5234H;
            case 6:
                if (compareTo > 0) {
                    return Math.nextUp(mo5234H);
                }
                return mo5234H;
            case 7:
                if (mo5235K(number) >= 0) {
                    if (compareTo > 0) {
                        return Math.nextUp(mo5234H);
                    }
                    return mo5234H;
                }
                if (compareTo < 0) {
                    return -Math.nextUp(-mo5234H);
                }
                return mo5234H;
            case 8:
                if (compareTo == 0) {
                    z = true;
                } else {
                    z = false;
                }
                p63.m6877u(z);
                return mo5234H;
            default:
                throw new AssertionError("impossible");
        }
    }

    /* renamed from: H */
    public abstract double mo5234H(Number number);

    /* renamed from: I */
    public abstract void mo5505I(boolean z);

    /* renamed from: J */
    public abstract void mo5506J(boolean z);

    /* renamed from: K */
    public abstract int mo5235K(Number number);

    /* renamed from: O */
    public abstract Number mo5236O(double d, RoundingMode roundingMode);

    /* renamed from: Q */
    public abstract void mo5507Q();

    /* renamed from: R */
    public abstract TransformationMethod mo5508R(TransformationMethod transformationMethod);

    /* renamed from: b */
    public abstract o63 mo4488b(Serializable serializable);

    /* renamed from: d */
    public abstract boolean mo6480d(AbstractResolvableFuture abstractResolvableFuture, C1783s2 c1783s2, C1783s2 c1783s22);

    /* renamed from: e */
    public abstract boolean mo6481e(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

    /* renamed from: f */
    public abstract boolean mo6482f(AbstractResolvableFuture abstractResolvableFuture, C1931w2 c1931w2, C1931w2 c1931w22);

    /* renamed from: o */
    public abstract InputFilter[] mo5509o(InputFilter[] inputFilterArr);

    /* renamed from: s */
    public abstract boolean mo5510s();

    /* renamed from: w */
    public abstract Number mo5237w(Number number, Number number2);

    /* renamed from: y */
    public abstract void mo6483y(C1931w2 c1931w2, C1931w2 c1931w22);

    /* renamed from: z */
    public abstract void mo6484z(C1931w2 c1931w2, Thread thread);
}
