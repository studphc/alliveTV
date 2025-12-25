package p000;

import android.graphics.Rect;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.gms.internal.measurement.zzmm;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.AbstractC1022u;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.Qualified;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import okio.Utf8;

/* loaded from: classes.dex */
public abstract class p63 implements pk2 {

    /* renamed from: b */
    public static so1 f25048b;

    /* renamed from: d */
    public static SparseArray f25050d;

    /* renamed from: e */
    public static zzaf f25051e;

    /* renamed from: a */
    public static final so1 f25047a = new so1(null, null, null);

    /* renamed from: c */
    public static final int[] f25049c = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* renamed from: A */
    public static void m6841A(ArrayList arrayList) {
        Set<C2073zx> set;
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            C2073zx c2073zx = new C2073zx(component);
            for (Qualified qualified : component.getProvidedInterfaces()) {
                boolean isValue = component.isValue();
                C0537ay c0537ay = new C0537ay(qualified, !isValue);
                if (!hashMap.containsKey(c0537ay)) {
                    hashMap.put(c0537ay, new HashSet());
                }
                Set set2 = (Set) hashMap.get(c0537ay);
                if (!set2.isEmpty() && isValue) {
                    throw new IllegalArgumentException("Multiple components provide " + qualified + ".");
                }
                set2.add(c2073zx);
            }
        }
        Iterator it2 = hashMap.values().iterator();
        while (it2.hasNext()) {
            for (C2073zx c2073zx2 : (Set) it2.next()) {
                for (Dependency dependency : c2073zx2.f29551a.getDependencies()) {
                    if (dependency.isDirectInjection() && (set = (Set) hashMap.get(new C0537ay(dependency.getInterface(), dependency.isSet()))) != null) {
                        for (C2073zx c2073zx3 : set) {
                            c2073zx2.f29552b.add(c2073zx3);
                            c2073zx3.f29553c.add(c2073zx2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it3 = hashMap.values().iterator();
        while (it3.hasNext()) {
            hashSet.addAll((Set) it3.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it4 = hashSet.iterator();
        while (it4.hasNext()) {
            C2073zx c2073zx4 = (C2073zx) it4.next();
            if (c2073zx4.f29553c.isEmpty()) {
                hashSet2.add(c2073zx4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            C2073zx c2073zx5 = (C2073zx) hashSet2.iterator().next();
            hashSet2.remove(c2073zx5);
            i++;
            Iterator it5 = c2073zx5.f29552b.iterator();
            while (it5.hasNext()) {
                C2073zx c2073zx6 = (C2073zx) it5.next();
                c2073zx6.f29553c.remove(c2073zx5);
                if (c2073zx6.f29553c.isEmpty()) {
                    hashSet2.add(c2073zx6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it6 = hashSet.iterator();
        while (it6.hasNext()) {
            C2073zx c2073zx7 = (C2073zx) it6.next();
            if (!c2073zx7.f29553c.isEmpty() && !c2073zx7.f29552b.isEmpty()) {
                arrayList2.add(c2073zx7.f29551a);
            }
        }
        throw new DependencyCycleException(arrayList2);
    }

    /* renamed from: B */
    public static Calendar m6842B(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    /* renamed from: C */
    public static boolean m6843C(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        int i2 = rect.top;
                        int i3 = rect2.top;
                        if ((i2 >= i3 && rect.bottom > i3) || rect.bottom >= rect2.bottom) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i4 = rect.left;
                int i5 = rect2.left;
                if ((i4 >= i5 && rect.right > i5) || rect.right >= rect2.right) {
                    return false;
                }
                return true;
            }
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            if ((i6 <= i7 && rect.top < i7) || rect.top <= rect2.top) {
                return false;
            }
            return true;
        }
        int i8 = rect.right;
        int i9 = rect2.right;
        if ((i8 <= i9 && rect.left < i9) || rect.left <= rect2.left) {
            return false;
        }
        return true;
    }

    /* renamed from: D */
    public static int m6844D(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        i2 = rect2.top;
                        i3 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i2 = rect2.left;
                    i3 = rect.right;
                }
            } else {
                i2 = rect.top;
                i3 = rect2.bottom;
            }
        } else {
            i2 = rect.left;
            i3 = rect2.right;
        }
        return Math.max(0, i2 - i3);
    }

    /* renamed from: E */
    public static int m6845E(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    /* renamed from: F */
    public static byte[] m6846F(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw new IllegalStateException(ye0.m8291k(i, "Not enough bytes to read: "));
            }
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.finished() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m6847G(FileInputStream fileInputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int i4 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int read = fileInputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    try {
                        i4 += inflater.inflate(bArr, i4, i2 - i4);
                        i3 += read;
                    } catch (DataFormatException e) {
                        throw new IllegalStateException(e.getMessage());
                    }
                } else {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } finally {
            inflater.end();
        }
    }

    /* renamed from: H */
    public static long m6848H(InputStream inputStream, int i) {
        byte[] m6846F = m6846F(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (m6846F[i2] & 255) << (i2 * 8);
        }
        return j;
    }

    /* renamed from: I */
    public static fx2 m6849I(fx2 fx2Var, String[] strArr, Map map) {
        int i = 0;
        if (fx2Var == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (fx2) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                fx2 fx2Var2 = new fx2();
                int length = strArr.length;
                while (i < length) {
                    fx2Var2.m4874a((fx2) map.get(strArr[i]));
                    i++;
                }
                return fx2Var2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                fx2Var.m4874a((fx2) map.get(strArr[0]));
                return fx2Var;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    fx2Var.m4874a((fx2) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return fx2Var;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [uc2, android.view.ViewOutlineProvider, java.lang.Object] */
    /* renamed from: J */
    public static void m6850J(int i, View view, boolean z) {
        if (z) {
            if (f25050d == null) {
                f25050d = new SparseArray();
            }
            ViewOutlineProvider viewOutlineProvider = (ViewOutlineProvider) f25050d.get(i);
            ViewOutlineProvider viewOutlineProvider2 = viewOutlineProvider;
            if (viewOutlineProvider == null) {
                ?? viewOutlineProvider3 = new ViewOutlineProvider();
                viewOutlineProvider3.f27224a = i;
                viewOutlineProvider2 = viewOutlineProvider3;
                if (f25050d.size() < 32) {
                    f25050d.put(i, viewOutlineProvider3);
                    viewOutlineProvider2 = viewOutlineProvider3;
                }
            }
            view.setOutlineProvider(viewOutlineProvider2);
        } else {
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        view.setClipToOutline(z);
    }

    /* renamed from: K */
    public static boolean m6851K(ExtractorInput extractorInput, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        long length = extractorInput.getLength();
        long j = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i2 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = length;
        }
        int i3 = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z7 = false;
        int i4 = 0;
        boolean z8 = false;
        while (i4 < i3) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z7 ? 1 : 0, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                i = 16;
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (readUnsignedInt < j3) {
                return z7;
            }
            i4 += i;
            if (readInt == 1836019574) {
                i3 += (int) readUnsignedInt;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
            } else {
                if (readInt == 1836019558 || readInt == 1836475768) {
                    z3 = z7 ? 1 : 0;
                    z4 = true;
                    z5 = true;
                    break;
                }
                int i5 = i2;
                if ((i4 + readUnsignedInt) - j3 >= i3) {
                    z3 = false;
                    z4 = true;
                    break;
                }
                int i6 = (int) (readUnsignedInt - j3);
                i4 += i6;
                if (readInt == 1718909296) {
                    if (i6 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i6);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i6);
                    int i7 = i6 / 4;
                    for (int i8 = 0; i8 < i7; i8++) {
                        if (i8 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else {
                            int readInt2 = parsableByteArray.readInt();
                            if ((readInt2 >>> 8) != 3368816 && (readInt2 != 1751476579 || !z2)) {
                                int[] iArr = f25049c;
                                for (int i9 = 0; i9 < 29; i9++) {
                                    if (iArr[i9] != readInt2) {
                                    }
                                }
                            }
                            z8 = true;
                            break;
                        }
                    }
                    if (!z8) {
                        return false;
                    }
                    z6 = false;
                    z8 = z8;
                } else {
                    z6 = false;
                    z8 = z8;
                    if (i6 != 0) {
                        extractorInput.advancePeekPosition(i6);
                        z8 = z8;
                    }
                }
                z7 = z6;
                i2 = i5;
            }
            j = -1;
            z8 = z8;
        }
        z3 = z7 ? 1 : 0;
        z4 = true;
        z5 = z3;
        if (!z8 || z != z5) {
            return z3;
        }
        return z4;
    }

    /* renamed from: L */
    public static void m6852L(ByteArrayOutputStream byteArrayOutputStream, long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    /* renamed from: M */
    public static void m6853M(ByteArrayOutputStream byteArrayOutputStream, int i) {
        m6852L(byteArrayOutputStream, i, 2);
    }

    /* renamed from: N */
    public static /* bridge */ /* synthetic */ void m6854N(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (!m6858R(b2)) {
            if ((((b2 + 112) + (b << Ascii.f14458FS)) >> 30) == 0 && !m6858R(b3) && !m6858R(b4)) {
                int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((i2 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw new zzmm("Protocol message had invalid UTF-8.");
    }

    /* renamed from: O */
    public static /* bridge */ /* synthetic */ void m6855O(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!m6858R(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!m6858R(b3)) {
                cArr[i] = (char) (((b & Ascii.f14464SI) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw new zzmm("Protocol message had invalid UTF-8.");
    }

    /* renamed from: P */
    public static /* bridge */ /* synthetic */ void m6856P(byte b, byte b2, char[] cArr, int i) {
        if (b >= -62 && !m6858R(b2)) {
            cArr[i] = (char) (((b & Ascii.f14467US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw new zzmm("Protocol message had invalid UTF-8.");
    }

    /* renamed from: Q */
    public static /* bridge */ /* synthetic */ boolean m6857Q(byte b) {
        if (b >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: R */
    public static boolean m6858R(byte b) {
        if (b > -65) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r10.bottom <= r12.top) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r9 == 17) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r9 != 66) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        r11 = m6844D(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r9 == 17) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (r9 == 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r9 == 66) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r9 != 130) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r9 = r12.bottom;
        r10 = r10.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r11 >= java.lang.Math.max(1, r9 - r10)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        r9 = r12.right;
        r10 = r10.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        r9 = r10.top;
        r10 = r12.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        r9 = r10.left;
        r10 = r12.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0033, code lost:
    
        if (r10.right <= r12.left) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x003a, code lost:
    
        if (r10.top >= r12.bottom) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0041, code lost:
    
        if (r10.left >= r12.right) goto L24;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m6859c(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean m6860d = m6860d(i, rect, rect2);
        if (m6860d(i, rect, rect3) || !m6860d) {
            return false;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m6860d(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static int m6861e(List list, Function function, Comparable comparable, pl2 pl2Var, jl2 jl2Var) {
        Preconditions.checkNotNull(comparable);
        return m6862f(list, function, comparable, Ordering.natural(), pl2Var, jl2Var);
    }

    /* renamed from: f */
    public static int m6862f(List list, Function function, Object obj, Ordering ordering, pl2 pl2Var, jl2 jl2Var) {
        List transform = Lists.transform(list, function);
        Preconditions.checkNotNull(ordering);
        Preconditions.checkNotNull(transform);
        Preconditions.checkNotNull(pl2Var);
        Preconditions.checkNotNull(jl2Var);
        if (!(transform instanceof RandomAccess)) {
            transform = Lists.newArrayList(transform);
        }
        int size = transform.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = ordering.compare(obj, transform.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare > 0) {
                i = i2 + 1;
            } else {
                return pl2Var.mo5563a(ordering, obj, transform.subList(i, size + 1), i2 - i) + i;
            }
        }
        return jl2Var.mo4955a(i);
    }

    /* renamed from: g */
    public static void m6863g(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                return;
            }
            String valueOf = String.valueOf(obj);
            throw new NullPointerException(AbstractC1726qj.m7059o("null value in entry: ", valueOf, "=null", valueOf.length() + 26));
        }
        String valueOf2 = String.valueOf(obj2);
        throw new NullPointerException(AbstractC1726qj.m7054j(valueOf2.length() + 24, "null key in entry: null=", valueOf2));
    }

    /* renamed from: h */
    public static void m6864h(boolean z, double d, RoundingMode roundingMode) {
        if (z) {
            return;
        }
        String valueOf = String.valueOf(roundingMode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 83);
        sb.append("rounded value is out of range for input ");
        sb.append(d);
        sb.append(" and rounding mode ");
        sb.append(valueOf);
        throw new ArithmeticException(sb.toString());
    }

    /* renamed from: i */
    public static void m6865i(String str, int i, int i2, boolean z) {
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(")");
        throw new ArithmeticException(sb.toString());
    }

    /* renamed from: j */
    public static void m6866j(boolean z, String str, long j, long j2) {
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 54);
        sb.append("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(")");
        throw new ArithmeticException(sb.toString());
    }

    /* renamed from: k */
    public static void m6867k(int i, String str) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 27);
        sb.append(str);
        sb.append(" (");
        sb.append(i);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: l */
    public static void m6868l(long j, String str) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append(str);
        sb.append(" (");
        sb.append(j);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: m */
    public static void m6869m(int i, String str) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: n */
    public static void m6870n(long j) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("distance".length() + 49);
        sb.append("distance cannot be negative but was: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: o */
    public static void m6871o(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str.concat(" should not be null"));
        }
    }

    /* renamed from: p */
    public static void m6872p(int i) {
        if (i > 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("x".length() + 26);
        sb.append("x (");
        sb.append(i);
        sb.append(") must be > 0");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: q */
    public static void m6873q(int i, String str) {
        if (i > 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 38);
        sb.append(str);
        sb.append(" must be positive but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: r */
    public static void m6874r(long j) {
        if (j > 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("x".length() + 35);
        sb.append("x (");
        sb.append(j);
        sb.append(") must be > 0");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: s */
    public static void m6875s(BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return;
        }
        String valueOf = String.valueOf(bigInteger);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o("x (", valueOf, ") must be > 0", valueOf.length() + "x".length() + 15));
    }

    /* renamed from: t */
    public static void m6876t(boolean z) {
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }

    /* renamed from: u */
    public static void m6877u(boolean z) {
        if (z) {
        } else {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    /* renamed from: w */
    public static byte[] m6878w(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    /* renamed from: x */
    public static String[] m6879x(int i, int i2) {
        String[] strArr = new String[(i2 - i) + 1];
        for (int i3 = i; i3 <= i2; i3++) {
            strArr[i3 - i] = String.format("%02d", Integer.valueOf(i3));
        }
        return strArr;
    }

    /* renamed from: z */
    public static boolean m6880z(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z = true;
            for (File file2 : listFiles) {
                if (m6880z(file2) && z) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        file.delete();
        return true;
    }

    @Override // p000.pk2
    /* renamed from: b */
    public float mo6881b(View view) {
        return view.getTranslationX();
    }

    @Override // p000.pk2
    public Property getProperty() {
        return View.TRANSLATION_X;
    }

    /* renamed from: v */
    public abstract void mo5038v(AbstractC1022u abstractC1022u, Set set);

    /* renamed from: y */
    public abstract int mo5039y(AbstractC1022u abstractC1022u);
}
