package p000;

import android.content.ClipDescription;
import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import androidx.leanback.widget.C0334f1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzpz;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.Ordering;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.StandardCharsets;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class jz2 implements BiConsumer, k41, rb3 {

    /* renamed from: e */
    public static jz2 f20696e;

    /* renamed from: a */
    public final /* synthetic */ int f20697a;

    /* renamed from: b */
    public Object f20698b;

    /* renamed from: c */
    public Object f20699c;

    /* renamed from: d */
    public Object f20700d;

    public /* synthetic */ jz2(zzpv zzpvVar, String str, Object obj, int i) {
        this.f20697a = i;
        this.f20699c = str;
        this.f20698b = obj;
        this.f20700d = zzpvVar;
    }

    /* renamed from: j */
    public static int m5468j(int i) {
        return (i - 1) / 2;
    }

    @Override // p000.k41
    /* renamed from: a */
    public Uri mo5386a() {
        return (Uri) this.f20700d;
    }

    @Override // io.reactivex.rxjava3.functions.BiConsumer
    public void accept(Object obj, Object obj2) {
        Map map = (Map) obj;
        Object apply = ((Function) this.f20700d).apply(obj2);
        Collection collection = (Collection) map.get(apply);
        if (collection == null) {
            collection = (Collection) ((Function) this.f20698b).apply(apply);
            map.put(apply, collection);
        }
        collection.add(((Function) this.f20699c).apply(obj2));
    }

    @Override // p000.k41
    /* renamed from: b */
    public Uri mo5387b() {
        return (Uri) this.f20698b;
    }

    @Override // p000.k41
    /* renamed from: d */
    public ClipDescription mo5389d() {
        return (ClipDescription) this.f20699c;
    }

    @Override // p000.k41
    /* renamed from: e */
    public Object mo5390e() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if (((com.google.common.collect.ImmutableList) r5.f20700d).equals((com.google.common.collect.ImmutableList) r6.f20700d) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        if (r2.equals(r6.getGenericDeclaration()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        switch (this.f20697a) {
            case 0:
                boolean z = hz2.f18230a;
                boolean z2 = true;
                GenericDeclaration genericDeclaration = (GenericDeclaration) this.f20698b;
                String str = (String) this.f20699c;
                if (z) {
                    if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof kz2)) {
                        return false;
                    }
                    jz2 jz2Var = ((kz2) Proxy.getInvocationHandler(obj)).f22259a;
                    if (str.equals((String) jz2Var.f20699c)) {
                        if (genericDeclaration.equals((GenericDeclaration) jz2Var.f20698b)) {
                            break;
                        }
                    }
                    z2 = false;
                } else {
                    if (!(obj instanceof TypeVariable)) {
                        return false;
                    }
                    TypeVariable typeVariable = (TypeVariable) obj;
                    if (str.equals(typeVariable.getName())) {
                        break;
                    }
                    z2 = false;
                }
                return z2;
            default:
                return super.equals(obj);
        }
    }

    /* renamed from: g */
    public int m5469g(int i, Object obj) {
        MinMaxPriorityQueue minMaxPriorityQueue;
        while (true) {
            minMaxPriorityQueue = (MinMaxPriorityQueue) this.f20700d;
            if (i <= 2) {
                break;
            }
            int m5468j = m5468j(m5468j(i));
            Object m4054a = minMaxPriorityQueue.m4054a(m5468j);
            if (((Ordering) this.f20698b).compare(m4054a, obj) <= 0) {
                break;
            }
            minMaxPriorityQueue.f14739d[i] = m4054a;
            i = m5468j;
        }
        minMaxPriorityQueue.f14739d[i] = obj;
        return i;
    }

    /* renamed from: h */
    public int m5470h(int i, Object obj) {
        int m5468j;
        MinMaxPriorityQueue minMaxPriorityQueue = (MinMaxPriorityQueue) this.f20700d;
        if (i == 0) {
            minMaxPriorityQueue.f14739d[0] = obj;
            return 0;
        }
        int m5468j2 = m5468j(i);
        Object m4054a = minMaxPriorityQueue.m4054a(m5468j2);
        Ordering ordering = (Ordering) this.f20698b;
        if (m5468j2 != 0 && (m5468j = (m5468j(m5468j2) * 2) + 2) != m5468j2 && (m5468j * 2) + 1 >= minMaxPriorityQueue.f14740e) {
            Object m4054a2 = minMaxPriorityQueue.m4054a(m5468j);
            if (ordering.compare(m4054a2, m4054a) < 0) {
                m5468j2 = m5468j;
                m4054a = m4054a2;
            }
        }
        if (ordering.compare(m4054a, obj) < 0) {
            Object[] objArr = minMaxPriorityQueue.f14739d;
            objArr[i] = m4054a;
            objArr[m5468j2] = obj;
            return m5468j2;
        }
        minMaxPriorityQueue.f14739d[i] = obj;
        return i;
    }

    public int hashCode() {
        switch (this.f20697a) {
            case 0:
                return ((GenericDeclaration) this.f20698b).hashCode() ^ ((String) this.f20699c).hashCode();
            default:
                return super.hashCode();
        }
    }

    /* renamed from: i */
    public int m5471i(int i, int i2) {
        boolean z;
        MinMaxPriorityQueue minMaxPriorityQueue = (MinMaxPriorityQueue) this.f20700d;
        if (i >= minMaxPriorityQueue.f14740e) {
            return -1;
        }
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        int min = Math.min(i, minMaxPriorityQueue.f14740e - i2) + i2;
        for (int i3 = i + 1; i3 < min; i3++) {
            if (((Ordering) this.f20698b).compare(minMaxPriorityQueue.m4054a(i3), minMaxPriorityQueue.m4054a(i)) < 0) {
                i = i3;
            }
        }
        return i;
    }

    /* renamed from: k */
    public boolean m5472k() {
        String trim;
        if (((String) this.f20699c) != null) {
            return true;
        }
        ArrayDeque arrayDeque = (ArrayDeque) this.f20700d;
        if (!arrayDeque.isEmpty()) {
            this.f20699c = (String) Assertions.checkNotNull((String) arrayDeque.poll());
            return true;
        }
        do {
            String readLine = ((BufferedReader) this.f20698b).readLine();
            this.f20699c = readLine;
            if (readLine != null) {
                trim = readLine.trim();
                this.f20699c = trim;
            } else {
                return false;
            }
        } while (trim.isEmpty());
        return true;
    }

    /* renamed from: l */
    public String m5473l() {
        if (m5472k()) {
            String str = (String) this.f20699c;
            this.f20699c = null;
            return str;
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        switch (this.f20697a) {
            case 0:
                return (String) this.f20699c;
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.String] */
    @Override // p000.rb3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        switch (this.f20697a) {
            case 10:
                ((zzpv) this.f20700d).m3653m(true, i, (IOException) th, bArr, (String) this.f20699c, (ArrayList) this.f20698b);
                return;
            default:
                zzpv zzpvVar = (zzpv) this.f20700d;
                zzpvVar.zzaX().zzg();
                zzpvVar.m3644d();
                if (bArr == null) {
                    try {
                        bArr = new byte[0];
                    } finally {
                        zzpvVar.f14389u = false;
                        zzpvVar.m3658u();
                    }
                }
                zzpz zzpzVar = (zzpz) this.f20698b;
                String str2 = (String) this.f20699c;
                if (i != 200) {
                    if (i == 204) {
                        i = 204;
                    }
                    String str3 = new String(bArr, StandardCharsets.UTF_8);
                    ?? substring = str3.substring(0, Math.min(32, str3.length()));
                    zzhc zzl = zzpvVar.zzaW().zzl();
                    Integer valueOf = Integer.valueOf(i);
                    if (th == null) {
                        th = substring;
                    }
                    zzl.zzd("Network upload failed. Will retry later. appId, status, error", str2, valueOf, th);
                    zzpvVar.zzj().m7865m(Long.valueOf(zzpzVar.zzc()));
                    zzpvVar.m3661x();
                    return;
                }
                if (th == null) {
                    zzpvVar.zzj().m7862j(Long.valueOf(zzpzVar.zzc()));
                    zzpvVar.zzaW().zzj().zzc("Successfully uploaded batch from upload queue. appId, status", str2, Integer.valueOf(i));
                    if (zzpvVar.zzi().zzx(null, zzgi.zzaM) && zzpvVar.zzp().zzd() && zzpvVar.zzj().m7872t(str2)) {
                        zzpvVar.m3631R(str2);
                    } else {
                        zzpvVar.m3661x();
                    }
                    return;
                }
                String str32 = new String(bArr, StandardCharsets.UTF_8);
                ?? substring2 = str32.substring(0, Math.min(32, str32.length()));
                zzhc zzl2 = zzpvVar.zzaW().zzl();
                Integer valueOf2 = Integer.valueOf(i);
                if (th == null) {
                }
                zzl2.zzd("Network upload failed. Will retry later. appId, status, error", str2, valueOf2, th);
                zzpvVar.zzj().m7865m(Long.valueOf(zzpzVar.zzc()));
                zzpvVar.m3661x();
                return;
        }
    }

    public /* synthetic */ jz2(Object obj, Object obj2, Object obj3, int i) {
        this.f20697a = i;
        this.f20698b = obj;
        this.f20699c = obj2;
        this.f20700d = obj3;
    }

    public /* synthetic */ jz2(AbstractCollection abstractCollection, Object obj, int i) {
        this.f20697a = i;
        this.f20700d = abstractCollection;
        this.f20698b = obj;
    }

    public jz2(int i) {
        this.f20697a = i;
        switch (i) {
            case 6:
                this.f20698b = new C0334f1(1);
                C0334f1 c0334f1 = new C0334f1(0);
                this.f20699c = c0334f1;
                this.f20700d = c0334f1;
                return;
            default:
                return;
        }
    }

    public jz2(Context context, LocationManager locationManager) {
        this.f20697a = 8;
        this.f20700d = new Object();
        this.f20698b = context;
        this.f20699c = locationManager;
    }

    public jz2(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
        this.f20697a = 0;
        mz2.m6265b(typeArr, "bound for type variable");
        this.f20698b = (GenericDeclaration) Preconditions.checkNotNull(genericDeclaration);
        this.f20699c = (String) Preconditions.checkNotNull(str);
        this.f20700d = ImmutableList.copyOf(typeArr);
    }

    @Override // p000.k41
    /* renamed from: c */
    public void mo5388c() {
    }

    @Override // p000.k41
    /* renamed from: f */
    public void mo5391f() {
    }
}
