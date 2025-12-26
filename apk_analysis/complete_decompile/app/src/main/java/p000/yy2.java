package p000;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.BlendModeCompat;
import androidx.leanback.transition.FadeAndShortSlide;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import com.google.android.gms.internal.measurement.C0784d;
import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzmm;
import com.google.android.gms.internal.measurement.zzof;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import kotlin.UShort;
import okio.Utf8;

/* loaded from: classes2.dex */
public abstract class yy2 implements pk2 {

    /* renamed from: a */
    public static final int[] f29177a = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};

    /* renamed from: b */
    public static final int[] f29178b = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};

    /* renamed from: c */
    public static final int[] f29179c = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};

    /* renamed from: d */
    public static final int[] f29180d = {R.attr.name, R.attr.pathData, R.attr.fillType};

    /* renamed from: e */
    public static final int[] f29181e = {R.attr.drawable};

    /* renamed from: f */
    public static final int[] f29182f = {R.attr.name, R.attr.animation};

    /* renamed from: g */
    public static final int[] f29183g = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    /* renamed from: h */
    public static final int[] f29184h = {R.attr.ordering};

    /* renamed from: i */
    public static final int[] f29185i = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};

    /* renamed from: j */
    public static final int[] f29186j = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};

    /* renamed from: k */
    public static final int[] f29187k = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    /* renamed from: l */
    public static final int[] f29188l = {R.attr.controlX1, R.attr.controlY1, R.attr.controlX2, R.attr.controlY2, R.attr.pathData};

    /* renamed from: m */
    public static final Object f29189m = new Object();

    /* renamed from: n */
    public static Method f29190n;

    /* renamed from: o */
    public static boolean f29191o;

    /* renamed from: A */
    public static boolean m8332A(byte b) {
        if (b >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [pr2, jr2] */
    /* JADX WARN: Type inference failed for: r0v2, types: [pr2, jr2] */
    /* renamed from: C */
    public static jr2 m8333C(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return new pr2(list, obj);
        }
        return new pr2(list, obj);
    }

    /* renamed from: D */
    public static int m8334D(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    /* renamed from: E */
    public static int m8335E(int i) {
        int i2;
        if (i < 32) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        return (i + 1) * i2;
    }

    /* renamed from: F */
    public static PorterDuff.Mode m8336F(BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (AbstractC1797sg.f26414a[blendModeCompat.ordinal()]) {
            case 1:
                return PorterDuff.Mode.CLEAR;
            case 2:
                return PorterDuff.Mode.SRC;
            case 3:
                return PorterDuff.Mode.DST;
            case 4:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.DST_OVER;
            case 6:
                return PorterDuff.Mode.SRC_IN;
            case 7:
                return PorterDuff.Mode.DST_IN;
            case 8:
                return PorterDuff.Mode.SRC_OUT;
            case 9:
                return PorterDuff.Mode.DST_OUT;
            case 10:
                return PorterDuff.Mode.SRC_ATOP;
            case 11:
                return PorterDuff.Mode.DST_ATOP;
            case 12:
                return PorterDuff.Mode.XOR;
            case 13:
                return PorterDuff.Mode.ADD;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.OVERLAY;
            case 17:
                return PorterDuff.Mode.DARKEN;
            case 18:
                return PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b4 A[SYNTHETIC] */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList m8337G(ParsableByteArray parsableByteArray) {
        ArrayList arrayList;
        boolean z;
        int i;
        ArrayList arrayList2;
        Projection$Mesh projection$Mesh;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        Projection$Mesh projection$Mesh2 = null;
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray2.skipBytes(7);
        int readInt = parsableByteArray.readInt();
        boolean z2 = true;
        if (readInt == 1684433976) {
            ParsableByteArray parsableByteArray3 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.inflate(parsableByteArray2, parsableByteArray3, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray2 = parsableByteArray3;
            } finally {
                inflater.end();
            }
        } else if (readInt != 1918990112) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        int position = parsableByteArray2.getPosition();
        int limit = parsableByteArray2.limit();
        while (position < limit) {
            int readInt2 = parsableByteArray2.readInt() + position;
            if (readInt2 > position && readInt2 <= limit) {
                if (parsableByteArray2.readInt() == 1835365224) {
                    int readInt3 = parsableByteArray2.readInt();
                    if (readInt3 <= 10000) {
                        float[] fArr = new float[readInt3];
                        for (int i2 = 0; i2 < readInt3; i2++) {
                            fArr[i2] = parsableByteArray2.readFloat();
                        }
                        int readInt4 = parsableByteArray2.readInt();
                        if (readInt4 <= 32000) {
                            double log = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int ceil = (int) Math.ceil(Math.log(readInt3 * 2.0d) / log);
                            ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray2.getData());
                            parsableBitArray.setPosition(parsableByteArray2.getPosition() * 8);
                            float[] fArr2 = new float[readInt4 * 5];
                            int i3 = 5;
                            int[] iArr = new int[5];
                            int i4 = 0;
                            int i5 = 0;
                            while (true) {
                                if (i4 < readInt4) {
                                    int i6 = 0;
                                    while (i6 < i3) {
                                        int i7 = iArr[i6];
                                        int readBits = parsableBitArray.readBits(ceil);
                                        int i8 = ((readBits >> 1) ^ (-(readBits & 1))) + i7;
                                        if (i8 >= readInt3 || i8 < 0) {
                                            break;
                                        }
                                        fArr2[i5] = fArr[i8];
                                        iArr[i6] = i8;
                                        i6++;
                                        i5++;
                                        i3 = 5;
                                    }
                                    i4++;
                                    i3 = 5;
                                } else {
                                    parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
                                    int i9 = 32;
                                    int readBits2 = parsableBitArray.readBits(32);
                                    Projection$SubMesh[] projection$SubMeshArr = new Projection$SubMesh[readBits2];
                                    int i10 = 0;
                                    while (i10 < readBits2) {
                                        int readBits3 = parsableBitArray.readBits(8);
                                        int readBits4 = parsableBitArray.readBits(8);
                                        int readBits5 = parsableBitArray.readBits(i9);
                                        if (readBits5 <= 128000) {
                                            i = limit;
                                            int ceil2 = (int) Math.ceil(Math.log(readInt4 * 2.0d) / log);
                                            float[] fArr3 = new float[readBits5 * 3];
                                            float[] fArr4 = new float[readBits5 * 2];
                                            int i11 = 0;
                                            int i12 = 0;
                                            while (i11 < readBits5) {
                                                int readBits6 = parsableBitArray.readBits(ceil2);
                                                ParsableBitArray parsableBitArray2 = parsableBitArray;
                                                float[] fArr5 = fArr4;
                                                int i13 = readBits2;
                                                int i14 = ((readBits6 >> 1) ^ (-(readBits6 & 1))) + i12;
                                                if (i14 < 0 || i14 >= readInt4) {
                                                    z = true;
                                                } else {
                                                    int i15 = i11 * 3;
                                                    int i16 = i14 * 5;
                                                    fArr3[i15] = fArr2[i16];
                                                    fArr3[i15 + 1] = fArr2[i16 + 1];
                                                    fArr3[i15 + 2] = fArr2[i16 + 2];
                                                    int i17 = i11 * 2;
                                                    fArr5[i17] = fArr2[i16 + 3];
                                                    fArr5[i17 + 1] = fArr2[i16 + 4];
                                                    i11++;
                                                    i12 = i14;
                                                    parsableBitArray = parsableBitArray2;
                                                    fArr4 = fArr5;
                                                    readBits2 = i13;
                                                }
                                            }
                                            projection$SubMeshArr[i10] = new Projection$SubMesh(readBits3, fArr3, fArr4, readBits4);
                                            i10++;
                                            limit = i;
                                            z2 = true;
                                            readBits2 = readBits2;
                                            i9 = 32;
                                        }
                                    }
                                    z = z2;
                                    i = limit;
                                    projection$Mesh = new Projection$Mesh(projection$SubMeshArr);
                                }
                            }
                            z = z2;
                            i = limit;
                            projection$Mesh = null;
                            if (projection$Mesh == null) {
                                arrayList = arrayList2;
                                arrayList.add(projection$Mesh);
                            }
                        }
                    }
                    projection$Mesh = projection$Mesh2;
                    arrayList2 = arrayList3;
                    z = z2;
                    i = limit;
                    if (projection$Mesh == null) {
                    }
                } else {
                    arrayList = arrayList3;
                    z = z2;
                    i = limit;
                }
                parsableByteArray2.setPosition(readInt2);
                arrayList3 = arrayList;
                position = readInt2;
                limit = i;
                z2 = z;
                projection$Mesh2 = null;
            }
            return null;
        }
        return arrayList3;
    }

    /* renamed from: J */
    public static long m8338J(Context context, Uri uri, String str, long j) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            return j;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return j;
        } finally {
            m8366l(cursor);
        }
    }

    /* renamed from: K */
    public static String m8339K(Context context, Uri uri, String str) {
        Cursor cursor;
        Throwable th;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst() && !cursor.isNull(0)) {
                        String string = cursor.getString(0);
                        m8366l(cursor);
                        return string;
                    }
                    m8366l(cursor);
                    return null;
                } catch (Exception e) {
                    e = e;
                    Log.w("DocumentFile", "Failed query: " + e);
                    m8366l(cursor);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                m8366l(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            m8366l(cursor);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r9 = r6 & r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r5 != (-1)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        m8342Q(r1, r9, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r13[r5] = m8334D(r13[r5], r9, r11);
     */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m8340L(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int m6454N = o63.m6454N(obj);
        int i2 = m6454N & i;
        int m8341P = m8341P(i2, obj3);
        if (m8341P == 0) {
            return -1;
        }
        int i3 = ~i;
        int i4 = m6454N & i3;
        int i5 = -1;
        while (true) {
            int i6 = m8341P - 1;
            int i7 = iArr[i6];
            if ((i7 & i3) != i4 || !Objects.equal(obj, objArr[i6]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i6]))) {
                int i8 = i7 & i;
                if (i8 == 0) {
                    return -1;
                }
                i5 = i6;
                m8341P = i8;
            }
        }
    }

    /* renamed from: P */
    public static int m8341P(int i, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & UShort.MAX_VALUE;
        }
        return ((int[]) obj)[i];
    }

    /* renamed from: Q */
    public static void m8342Q(int i, int i2, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    /* renamed from: R */
    public static String m8343R(int i) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    /* renamed from: S */
    public static boolean m8344S(Object obj, Function function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (obj instanceof Supplier) {
            try {
                Object obj2 = ((Supplier) obj).get();
                if (obj2 != null) {
                    Object apply = function.apply(obj2);
                    java.util.Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                    completableSource = (CompletableSource) apply;
                } else {
                    completableSource = null;
                }
                if (completableSource == null) {
                    EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.subscribe(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }
        return false;
    }

    /* renamed from: T */
    public static boolean m8345T(Object obj, Function function, Observer observer) {
        MaybeSource maybeSource;
        if (obj instanceof Supplier) {
            try {
                Object obj2 = ((Supplier) obj).get();
                if (obj2 != null) {
                    Object apply = function.apply(obj2);
                    java.util.Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                    maybeSource = (MaybeSource) apply;
                } else {
                    maybeSource = null;
                }
                if (maybeSource == null) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    maybeSource.subscribe(MaybeToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
                return true;
            }
        }
        return false;
    }

    /* renamed from: U */
    public static boolean m8346U(Object obj, Function function, Observer observer) {
        SingleSource singleSource;
        if (obj instanceof Supplier) {
            try {
                Object obj2 = ((Supplier) obj).get();
                if (obj2 != null) {
                    Object apply = function.apply(obj2);
                    java.util.Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                    singleSource = (SingleSource) apply;
                } else {
                    singleSource = null;
                }
                if (singleSource == null) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    singleSource.subscribe(SingleToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
                return true;
            }
        }
        return false;
    }

    /* renamed from: V */
    public static int m8347V(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 != 0) {
                if (i4 == i) {
                    return i3;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }

    /* renamed from: W */
    public static int m8348W(byte[] bArr, int i, oc3 oc3Var) {
        int m8355c0 = m8355c0(bArr, i, oc3Var);
        int i2 = oc3Var.f23766a;
        if (i2 >= 0) {
            if (i2 <= bArr.length - m8355c0) {
                if (i2 == 0) {
                    oc3Var.f23768c = zzld.zzb;
                    return m8355c0;
                }
                oc3Var.f23768c = zzld.zzj(bArr, m8355c0, i2);
                return m8355c0 + i2;
            }
            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: X */
    public static int m8349X(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* renamed from: Y */
    public static int m8350Y(xd3 xd3Var, byte[] bArr, int i, int i2, int i3, oc3 oc3Var) {
        Object zze = xd3Var.zze();
        int m8362g0 = m8362g0(zze, xd3Var, bArr, i, i2, i3, oc3Var);
        xd3Var.mo3234a(zze);
        oc3Var.f23768c = zze;
        return m8362g0;
    }

    /* renamed from: Z */
    public static int m8351Z(xd3 xd3Var, int i, byte[] bArr, int i2, int i3, zzmj zzmjVar, oc3 oc3Var) {
        Object zze = xd3Var.zze();
        int m8364h0 = m8364h0(zze, xd3Var, bArr, i2, i3, oc3Var);
        xd3Var.mo3234a(zze);
        oc3Var.f23768c = zze;
        zzmjVar.add(zze);
        while (m8364h0 < i3) {
            int m8355c0 = m8355c0(bArr, m8364h0, oc3Var);
            if (i != oc3Var.f23766a) {
                break;
            }
            Object zze2 = xd3Var.zze();
            int m8364h02 = m8364h0(zze2, xd3Var, bArr, m8355c0, i3, oc3Var);
            xd3Var.mo3234a(zze2);
            oc3Var.f23768c = zze2;
            zzmjVar.add(zze2);
            m8364h0 = m8364h02;
        }
        return m8364h0;
    }

    /* renamed from: a0 */
    public static int m8352a0(byte[] bArr, int i, zzmj zzmjVar, oc3 oc3Var) {
        hd3 hd3Var = (hd3) zzmjVar;
        int m8355c0 = m8355c0(bArr, i, oc3Var);
        int i2 = oc3Var.f23766a + m8355c0;
        while (m8355c0 < i2) {
            m8355c0 = m8355c0(bArr, m8355c0, oc3Var);
            hd3Var.m5053c(oc3Var.f23766a);
        }
        if (m8355c0 == i2) {
            return m8355c0;
        }
        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b0 */
    public static int m8353b0(int i, byte[] bArr, int i2, int i3, zzof zzofVar, oc3 oc3Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                zzofVar.m3478b(i, Integer.valueOf(m8349X(i2, bArr)));
                                return i2 + 4;
                            }
                            throw new zzmm("Protocol message contained an invalid tag (zero).");
                        }
                        int i5 = (i & (-8)) | 4;
                        zzof m3477a = zzof.m3477a();
                        int i6 = oc3Var.f23770e + 1;
                        oc3Var.f23770e = i6;
                        if (i6 < 100) {
                            int i7 = 0;
                            while (true) {
                                if (i2 >= i3) {
                                    break;
                                }
                                int m8355c0 = m8355c0(bArr, i2, oc3Var);
                                i7 = oc3Var.f23766a;
                                if (i7 == i5) {
                                    i2 = m8355c0;
                                    break;
                                }
                                i2 = m8353b0(i7, bArr, m8355c0, i3, m3477a, oc3Var);
                            }
                            oc3Var.f23770e--;
                            if (i2 <= i3 && i7 == i5) {
                                zzofVar.m3478b(i, m3477a);
                                return i2;
                            }
                            throw new zzmm("Failed to parse the message.");
                        }
                        throw new zzmm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                    }
                    int m8355c02 = m8355c0(bArr, i2, oc3Var);
                    int i8 = oc3Var.f23766a;
                    if (i8 >= 0) {
                        if (i8 <= bArr.length - m8355c02) {
                            if (i8 == 0) {
                                zzofVar.m3478b(i, zzld.zzb);
                            } else {
                                zzofVar.m3478b(i, zzld.zzj(bArr, m8355c02, i8));
                            }
                            return m8355c02 + i8;
                        }
                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                zzofVar.m3478b(i, Long.valueOf(m8365i0(i2, bArr)));
                return i2 + 8;
            }
            int m8361f0 = m8361f0(bArr, i2, oc3Var);
            zzofVar.m3478b(i, Long.valueOf(oc3Var.f23767b));
            return m8361f0;
        }
        throw new zzmm("Protocol message contained an invalid tag (zero).");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [pr2, sr2] */
    /* JADX WARN: Type inference failed for: r0v2, types: [pr2, sr2] */
    /* renamed from: c */
    public static sr2 m8354c(Set set, Object obj) {
        if (set instanceof SortedSet) {
            return new pr2((SortedSet) set, obj);
        }
        return new pr2(set, obj);
    }

    /* renamed from: c0 */
    public static int m8355c0(byte[] bArr, int i, oc3 oc3Var) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            oc3Var.f23766a = b;
            return i2;
        }
        return m8357d0(b, bArr, i2, oc3Var);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [pr2, gr2] */
    /* JADX WARN: Type inference failed for: r0v5, types: [pr2, gr2] */
    /* JADX WARN: Type inference failed for: r0v6, types: [pr2, gr2] */
    /* renamed from: d */
    public static gr2 m8356d(Collection collection, Object obj) {
        if (collection instanceof SortedSet) {
            return new pr2((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return new pr2((Set) collection, obj);
        }
        if (collection instanceof List) {
            return m8333C((List) collection, obj);
        }
        return new pr2(collection, obj);
    }

    /* renamed from: d0 */
    public static int m8357d0(int i, byte[] bArr, int i2, oc3 oc3Var) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            oc3Var.f23766a = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            oc3Var.f23766a = i5 | (b2 << Ascii.f14465SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            oc3Var.f23766a = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            oc3Var.f23766a = i9 | (b4 << Ascii.f14458FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                oc3Var.f23766a = i11;
                return i12;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [pr2, ir2] */
    /* renamed from: e */
    public static ir2 m8358e(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new pr2(entry, obj);
    }

    /* renamed from: e0 */
    public static int m8359e0(int i, byte[] bArr, int i2, int i3, zzmj zzmjVar, oc3 oc3Var) {
        hd3 hd3Var = (hd3) zzmjVar;
        int m8355c0 = m8355c0(bArr, i2, oc3Var);
        hd3Var.m5053c(oc3Var.f23766a);
        while (m8355c0 < i3) {
            int m8355c02 = m8355c0(bArr, m8355c0, oc3Var);
            if (i != oc3Var.f23766a) {
                break;
            }
            m8355c0 = m8355c0(bArr, m8355c02, oc3Var);
            hd3Var.m5053c(oc3Var.f23766a);
        }
        return m8355c0;
    }

    /* renamed from: f */
    public static void m8360f(ExecutorService executorService, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(timeUnit);
        String valueOf = String.valueOf(executorService);
        Runtime.getRuntime().addShutdownHook(MoreExecutors.m4336a(AbstractC1726qj.m7054j(valueOf.length() + 24, "DelayedShutdownHook-for-", valueOf), new vo1(executorService, j, timeUnit)));
    }

    /* renamed from: f0 */
    public static int m8361f0(byte[] bArr, int i, oc3 oc3Var) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            oc3Var.f23767b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        oc3Var.f23767b = j2;
        return i3;
    }

    /* renamed from: g0 */
    public static int m8362g0(Object obj, xd3 xd3Var, byte[] bArr, int i, int i2, int i3, oc3 oc3Var) {
        C0784d c0784d = (C0784d) xd3Var;
        int i4 = oc3Var.f23770e + 1;
        oc3Var.f23770e = i4;
        if (i4 < 100) {
            int m3251s = c0784d.m3251s(obj, bArr, i, i2, i3, oc3Var);
            oc3Var.f23770e--;
            oc3Var.f23768c = obj;
            return m3251s;
        }
        throw new zzmm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    /* renamed from: h */
    public static boolean m8363h(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String m8339K = m8339K(context, uri, "mime_type");
        int m8338J = (int) m8338J(context, uri, "flags", 0);
        if (TextUtils.isEmpty(m8339K)) {
            return false;
        }
        if ((m8338J & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(m8339K) && (m8338J & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(m8339K) || (m8338J & 2) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: h0 */
    public static int m8364h0(Object obj, xd3 xd3Var, byte[] bArr, int i, int i2, oc3 oc3Var) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = m8357d0(i4, bArr, i3, oc3Var);
            i4 = oc3Var.f23766a;
        }
        int i5 = i3;
        if (i4 >= 0 && i4 <= i2 - i5) {
            int i6 = oc3Var.f23770e + 1;
            oc3Var.f23770e = i6;
            if (i6 < 100) {
                int i7 = i4 + i5;
                xd3Var.mo3236c(obj, bArr, i5, i7, oc3Var);
                oc3Var.f23770e--;
                oc3Var.f23768c = obj;
                return i7;
            }
            throw new zzmm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: i0 */
    public static long m8365i0(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    /* renamed from: l */
    public static void m8366l(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: m */
    public static Object m8367m(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            if (i <= 256) {
                return new byte[i];
            }
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
        throw new IllegalArgumentException(ye0.m8290j(52, i, "must be power of 2 between 2^1 and 2^30: "));
    }

    /* renamed from: n */
    public static boolean m8368n(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return false;
        } finally {
            m8366l(cursor);
        }
    }

    /* renamed from: s */
    public static Set m8369s() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (invoke == null) {
                return Collections.emptySet();
            }
            Set set = (Set) invoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.emptySet();
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    /* renamed from: w */
    public static void m8370w(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (!m8373z(b2)) {
            if ((((b2 + 112) + (b << Ascii.f14458FS)) >> 30) == 0 && !m8373z(b3) && !m8373z(b4)) {
                int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((i2 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid UTF-8");
    }

    /* renamed from: x */
    public static void m8371x(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!m8373z(b2) && ((b != -32 || b2 >= -96) && ((b != -19 || b2 < -96) && !m8373z(b3)))) {
            cArr[i] = (char) (((b & Ascii.f14464SI) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw new IllegalArgumentException("Invalid UTF-8");
    }

    /* renamed from: y */
    public static void m8372y(byte b, byte b2, char[] cArr, int i) {
        if (b >= -62) {
            if (!m8373z(b2)) {
                cArr[i] = (char) (((b & Ascii.f14467US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        }
        throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
    }

    /* renamed from: z */
    public static boolean m8373z(byte b) {
        if (b > -65) {
            return true;
        }
        return false;
    }

    /* renamed from: B */
    public abstract boolean mo6324B(Class cls);

    /* renamed from: H */
    public abstract void mo5804H(C1892v0 c1892v0, C1892v0 c1892v02);

    /* renamed from: I */
    public abstract void mo5805I(C1892v0 c1892v0, Thread thread);

    /* renamed from: N */
    public abstract void mo35N();

    /* renamed from: O */
    public abstract void mo36O();

    @Override // p000.pk2
    /* renamed from: b */
    public float mo6881b(View view) {
        return view.getTranslationY();
    }

    /* renamed from: g */
    public boolean mo37g() {
        return false;
    }

    @Override // p000.pk2
    public Property getProperty() {
        return View.TRANSLATION_Y;
    }

    /* renamed from: i */
    public abstract boolean mo5806i(AbstractFuture abstractFuture, C1374k0 c1374k0, C1374k0 c1374k02);

    /* renamed from: j */
    public abstract boolean mo5807j(AbstractFuture abstractFuture, Object obj, Object obj2);

    /* renamed from: k */
    public abstract boolean mo5808k(AbstractFuture abstractFuture, C1892v0 c1892v0, C1892v0 c1892v02);

    /* renamed from: o */
    public abstract C1374k0 mo5809o(AbstractFuture abstractFuture);

    /* renamed from: p */
    public abstract C1892v0 mo5810p(AbstractFuture abstractFuture);

    /* renamed from: q */
    public abstract Method mo6325q(Class cls, Field field);

    /* renamed from: r */
    public abstract Constructor mo6326r(Class cls);

    /* renamed from: t */
    public float mo48t(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationX();
    }

    /* renamed from: u */
    public float mo49u(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationY();
    }

    /* renamed from: v */
    public abstract String[] mo6327v(Class cls);

    /* renamed from: M */
    public void mo34M() {
    }
}
