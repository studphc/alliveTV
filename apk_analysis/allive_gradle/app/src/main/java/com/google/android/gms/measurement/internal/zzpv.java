package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzhb;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzjm;
import com.google.android.gms.internal.measurement.zzmm;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlinx.coroutines.DebugKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.ai2;
import p000.da3;
import p000.ga3;
import p000.gd3;
import p000.hc3;
import p000.jz2;
import p000.l93;
import p000.ob3;
import p000.pc3;
import p000.rb3;
import p000.re3;
import p000.s93;
import p000.se3;
import p000.sn1;
import p000.tb3;
import p000.te3;
import p000.ue3;
import p000.v93;
import p000.ye3;

/* loaded from: classes.dex */
public final class zzpv implements hc3 {

    /* renamed from: K */
    public static volatile zzpv f14358K;

    /* renamed from: A */
    public long f14359A;

    /* renamed from: B */
    public final HashMap f14360B;

    /* renamed from: C */
    public final HashMap f14361C;

    /* renamed from: D */
    public final HashMap f14362D;

    /* renamed from: F */
    public zzmh f14364F;

    /* renamed from: G */
    public String f14365G;

    /* renamed from: H */
    public pc3 f14366H;

    /* renamed from: I */
    public long f14367I;

    /* renamed from: a */
    public final zzif f14369a;

    /* renamed from: b */
    public final zzhk f14370b;

    /* renamed from: c */
    public v93 f14371c;

    /* renamed from: d */
    public tb3 f14372d;

    /* renamed from: e */
    public zzoy f14373e;

    /* renamed from: f */
    public l93 f14374f;

    /* renamed from: g */
    public final zzqa f14375g;

    /* renamed from: h */
    public gd3 f14376h;

    /* renamed from: i */
    public zzoa f14377i;

    /* renamed from: j */
    public final zzpi f14378j;

    /* renamed from: k */
    public zzhw f14379k;

    /* renamed from: l */
    public final zzio f14380l;

    /* renamed from: n */
    public boolean f14382n;

    /* renamed from: o */
    public long f14383o;

    /* renamed from: p */
    public ArrayList f14384p;

    /* renamed from: r */
    public int f14386r;

    /* renamed from: s */
    public int f14387s;

    /* renamed from: t */
    public boolean f14388t;

    /* renamed from: u */
    public boolean f14389u;

    /* renamed from: v */
    public boolean f14390v;

    /* renamed from: w */
    public FileLock f14391w;

    /* renamed from: x */
    public FileChannel f14392x;

    /* renamed from: y */
    public ArrayList f14393y;

    /* renamed from: z */
    public ArrayList f14394z;

    /* renamed from: m */
    public final AtomicBoolean f14381m = new AtomicBoolean(false);

    /* renamed from: q */
    public final LinkedList f14385q = new LinkedList();

    /* renamed from: E */
    public final HashMap f14363E = new HashMap();

    /* renamed from: J */
    public final ai2 f14368J = new ai2(24, this);

    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.measurement.internal.zzpi, com.google.android.gms.measurement.internal.p0] */
    /* JADX WARN: Type inference failed for: r0v8, types: [re3, com.google.android.gms.measurement.internal.zzqa] */
    public zzpv(zzpw zzpwVar) {
        Preconditions.checkNotNull(zzpwVar);
        this.f14380l = zzio.zzp(zzpwVar.f14395a, null, null);
        this.f14359A = -1L;
        this.f14378j = new AbstractC0818p0(this);
        ?? re3Var = new re3(this);
        re3Var.zzaw();
        this.f14375g = re3Var;
        zzhk zzhkVar = new zzhk(this);
        zzhkVar.zzaw();
        this.f14370b = zzhkVar;
        zzif zzifVar = new zzif(this);
        zzifVar.zzaw();
        this.f14369a = zzifVar;
        this.f14360B = new HashMap();
        this.f14361C = new HashMap();
        this.f14362D = new HashMap();
        zzaX().zzq(new sn1(this, zzpwVar));
    }

    /* renamed from: C */
    public static final boolean m3611C(zzr zzrVar) {
        if (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) {
            return false;
        }
        return true;
    }

    /* renamed from: D */
    public static final void m3612D(re3 re3Var) {
        if (re3Var != null) {
            if (re3Var.f25950a) {
                return;
            } else {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(re3Var.getClass())));
            }
        }
        throw new IllegalStateException("Upload Component not created");
    }

    /* renamed from: E */
    public static final Boolean m3613E(zzr zzrVar) {
        Boolean bool = zzrVar.zzq;
        String str = zzrVar.zzE;
        if (!TextUtils.isEmpty(str)) {
            int ordinal = ((zzju) ai2.m91g(str).f216b).ordinal();
            if (ordinal != 0 && ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return Boolean.FALSE;
                    }
                } else {
                    return Boolean.TRUE;
                }
            } else {
                return null;
            }
        }
        return bool;
    }

    /* renamed from: o */
    public static final void m3614o(zzhl zzhlVar, int i, String str) {
        List zzp = zzhlVar.zzp();
        for (int i2 = 0; i2 < zzp.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i2)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
        zze.zzj("_err");
        zze.zzi(i);
        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zze.zzba();
        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) zze2.zzba();
        zzhlVar.zzf(zzhqVar);
        zzhlVar.zzf(zzhqVar2);
    }

    /* renamed from: p */
    public static final void m3615p(zzhl zzhlVar, String str) {
        List zzp = zzhlVar.zzp();
        for (int i = 0; i < zzp.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i)).zzg())) {
                zzhlVar.zzh(i);
                return;
            }
        }
    }

    /* renamed from: t */
    public static String m3616t(String str, Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    if (!((List) entry.getValue()).isEmpty()) {
                        return (String) ((List) entry.getValue()).get(0);
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static zzpv zzz(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f14358K == null) {
            synchronized (zzpv.class) {
                try {
                    if (f14358K == null) {
                        f14358K = new zzpv((zzpw) Preconditions.checkNotNull(new zzpw(context)));
                    }
                } finally {
                }
            }
        }
        return f14358K;
    }

    /* renamed from: A */
    public final boolean m3617A(String str, String str2) {
        da3 m7875w = zzj().m7875w("events", str, str2);
        if (m7875w != null && m7875w.f16316c >= 1) {
            return false;
        }
        return true;
    }

    /* renamed from: B */
    public final boolean m3618B(zzhl zzhlVar, zzhl zzhlVar2) {
        String zzh;
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq m3671f = zzqa.m3671f((zzhm) zzhlVar.zzba(), "_sc");
        String str = null;
        if (m3671f == null) {
            zzh = null;
        } else {
            zzh = m3671f.zzh();
        }
        zzA();
        com.google.android.gms.internal.measurement.zzhq m3671f2 = zzqa.m3671f((zzhm) zzhlVar2.zzba(), "_pc");
        if (m3671f2 != null) {
            str = m3671f2.zzh();
        }
        if (str != null && str.equals(zzh)) {
            Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
            zzA();
            com.google.android.gms.internal.measurement.zzhq m3671f3 = zzqa.m3671f((zzhm) zzhlVar.zzba(), "_et");
            if (m3671f3 != null && m3671f3.zzw() && m3671f3.zzd() > 0) {
                long zzd = m3671f3.zzd();
                zzA();
                com.google.android.gms.internal.measurement.zzhq m3671f4 = zzqa.m3671f((zzhm) zzhlVar2.zzba(), "_et");
                if (m3671f4 != null && m3671f4.zzd() > 0) {
                    zzd += m3671f4.zzd();
                }
                zzA();
                zzqa.m3669d(zzhlVar2, "_et", Long.valueOf(zzd));
                zzA();
                zzqa.m3669d(zzhlVar, "_fr", 1L);
                return true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: F */
    public final void m3619F(ob3 ob3Var, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        boolean z;
        zzaX().zzg();
        m3644d();
        zzhb zzc = com.google.android.gms.internal.measurement.zzhc.zzc();
        zzio zzioVar = ob3Var.f23733a;
        zzioVar.zzaX().zzg();
        byte[] bArr = ob3Var.f23721I;
        if (bArr != null) {
            try {
                zzc = (zzhb) zzqa.m3683x(zzc, bArr);
            } catch (zzmm unused) {
                zzaW().zzk().zzb("Failed to parse locally stored ad campaign info. appId", zzhe.zzn(ob3Var.m6536c()));
            }
        }
        for (zzhm zzhmVar : zzhwVar.zzaM()) {
            if (zzhmVar.zzh().equals("_cmp")) {
                Serializable m3672g = zzqa.m3672g(zzhmVar, "gclid");
                Object obj = "";
                if (m3672g == null) {
                    m3672g = "";
                }
                String str = (String) m3672g;
                Serializable m3672g2 = zzqa.m3672g(zzhmVar, "gbraid");
                if (m3672g2 == null) {
                    m3672g2 = "";
                }
                String str2 = (String) m3672g2;
                Object m3672g3 = zzqa.m3672g(zzhmVar, "gad_source");
                if (m3672g3 != null) {
                    obj = m3672g3;
                }
                String str3 = (String) obj;
                if (!str.isEmpty() || !str2.isEmpty()) {
                    Object obj2 = 0L;
                    Object m3672g4 = zzqa.m3672g(zzhmVar, "click_timestamp");
                    if (m3672g4 != null) {
                        obj2 = m3672g4;
                    }
                    long longValue = ((Long) obj2).longValue();
                    if (longValue <= 0) {
                        longValue = zzhmVar.zzd();
                    }
                    if ("referrer API v2".equals(zzqa.m3672g(zzhmVar, "_cis"))) {
                        if (longValue > zzc.zzb()) {
                            if (str.isEmpty()) {
                                zzc.zzh();
                            } else {
                                zzc.zzp(str);
                            }
                            if (str2.isEmpty()) {
                                zzc.zzg();
                            } else {
                                zzc.zzo(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc.zzf();
                            } else {
                                zzc.zzn(str3);
                            }
                            zzc.zzm(longValue);
                        }
                    } else if (longValue > zzc.zza()) {
                        if (str.isEmpty()) {
                            zzc.zze();
                        } else {
                            zzc.zzk(str);
                        }
                        if (str2.isEmpty()) {
                            zzc.zzd();
                        } else {
                            zzc.zzj(str2);
                        }
                        if (str3.isEmpty()) {
                            zzc.zzc();
                        } else {
                            zzc.zzi(str3);
                        }
                        zzc.zzl(longValue);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).equals(com.google.android.gms.internal.measurement.zzhc.zze())) {
            zzhwVar.zzF((com.google.android.gms.internal.measurement.zzhc) zzc.zzba());
        }
        byte[] zzcd = ((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).zzcd();
        zzioVar.zzaX().zzg();
        boolean z2 = ob3Var.f23730R;
        if (ob3Var.f23721I != zzcd) {
            z = true;
        } else {
            z = false;
        }
        ob3Var.f23730R = z2 | z;
        ob3Var.f23721I = zzcd;
        zzioVar.zzaX().zzg();
        if (ob3Var.f23730R) {
            zzj().m7869q(ob3Var, false);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:61|62|(2:64|(11:66|(3:68|(2:70|(1:72))(1:95)|94)(1:96)|73|(1:75)(1:93)|76|77|78|79|80|(4:82|(1:84)(1:88)|85|(1:87))|89))|97|79|80|(0)|89) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x035b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x035c, code lost:
    
        zzaW().zze().zzc("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r3), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03f7 A[Catch: all -> 0x0344, TryCatch #3 {all -> 0x0344, blocks: (B:55:0x038e, B:56:0x0391, B:57:0x0419, B:78:0x0340, B:80:0x034d, B:92:0x035c, B:82:0x036f, B:84:0x0375, B:85:0x037d, B:87:0x0383, B:141:0x03a9, B:143:0x03dd, B:144:0x03e0, B:145:0x03f7, B:147:0x03fe), top: B:37:0x012b, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0120 A[Catch: all -> 0x00c0, TryCatch #2 {all -> 0x00c0, blocks: (B:25:0x00a3, B:27:0x00b5, B:30:0x00f7, B:32:0x0104, B:33:0x010d, B:36:0x0114, B:39:0x012d, B:42:0x0141, B:110:0x017e, B:149:0x0120, B:150:0x010a, B:152:0x00c6, B:155:0x00d6, B:157:0x00e4, B:159:0x00ee, B:162:0x00f4), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x010a A[Catch: all -> 0x00c0, TryCatch #2 {all -> 0x00c0, blocks: (B:25:0x00a3, B:27:0x00b5, B:30:0x00f7, B:32:0x0104, B:33:0x010d, B:36:0x0114, B:39:0x012d, B:42:0x0141, B:110:0x017e, B:149:0x0120, B:150:0x010a, B:152:0x00c6, B:155:0x00d6, B:157:0x00e4, B:159:0x00ee, B:162:0x00f4), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104 A[Catch: all -> 0x00c0, TryCatch #2 {all -> 0x00c0, blocks: (B:25:0x00a3, B:27:0x00b5, B:30:0x00f7, B:32:0x0104, B:33:0x010d, B:36:0x0114, B:39:0x012d, B:42:0x0141, B:110:0x017e, B:149:0x0120, B:150:0x010a, B:152:0x00c6, B:155:0x00d6, B:157:0x00e4, B:159:0x00ee, B:162:0x00f4), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114 A[Catch: all -> 0x00c0, TRY_ENTER, TryCatch #2 {all -> 0x00c0, blocks: (B:25:0x00a3, B:27:0x00b5, B:30:0x00f7, B:32:0x0104, B:33:0x010d, B:36:0x0114, B:39:0x012d, B:42:0x0141, B:110:0x017e, B:149:0x0120, B:150:0x010a, B:152:0x00c6, B:155:0x00d6, B:157:0x00e4, B:159:0x00ee, B:162:0x00f4), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #2 {all -> 0x00c0, blocks: (B:25:0x00a3, B:27:0x00b5, B:30:0x00f7, B:32:0x0104, B:33:0x010d, B:36:0x0114, B:39:0x012d, B:42:0x0141, B:110:0x017e, B:149:0x0120, B:150:0x010a, B:152:0x00c6, B:155:0x00d6, B:157:0x00e4, B:159:0x00ee, B:162:0x00f4), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x028d A[Catch: all -> 0x01c7, TryCatch #4 {all -> 0x01c7, blocks: (B:106:0x0165, B:108:0x016f, B:46:0x025d, B:48:0x028d, B:49:0x0290, B:51:0x02b4, B:62:0x02cc, B:64:0x02ef, B:66:0x02f7, B:68:0x0300, B:72:0x0313, B:73:0x0326, B:76:0x0332, B:95:0x031e, B:100:0x02db, B:113:0x018f, B:115:0x01b8, B:116:0x01cc, B:118:0x01d3, B:120:0x01d9, B:122:0x01e3, B:124:0x01e9, B:126:0x01ef, B:128:0x01f5, B:130:0x01fa, B:133:0x021a, B:138:0x021e, B:139:0x0232, B:140:0x0240, B:45:0x024e), top: B:105:0x0165, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02b4 A[Catch: all -> 0x01c7, TRY_LEAVE, TryCatch #4 {all -> 0x01c7, blocks: (B:106:0x0165, B:108:0x016f, B:46:0x025d, B:48:0x028d, B:49:0x0290, B:51:0x02b4, B:62:0x02cc, B:64:0x02ef, B:66:0x02f7, B:68:0x0300, B:72:0x0313, B:73:0x0326, B:76:0x0332, B:95:0x031e, B:100:0x02db, B:113:0x018f, B:115:0x01b8, B:116:0x01cc, B:118:0x01d3, B:120:0x01d9, B:122:0x01e3, B:124:0x01e9, B:126:0x01ef, B:128:0x01f5, B:130:0x01fa, B:133:0x021a, B:138:0x021e, B:139:0x0232, B:140:0x0240, B:45:0x024e), top: B:105:0x0165, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x038e A[Catch: all -> 0x0344, TryCatch #3 {all -> 0x0344, blocks: (B:55:0x038e, B:56:0x0391, B:57:0x0419, B:78:0x0340, B:80:0x034d, B:92:0x035c, B:82:0x036f, B:84:0x0375, B:85:0x037d, B:87:0x0383, B:141:0x03a9, B:143:0x03dd, B:144:0x03e0, B:145:0x03f7, B:147:0x03fe), top: B:37:0x012b, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x036f A[Catch: all -> 0x0344, TryCatch #3 {all -> 0x0344, blocks: (B:55:0x038e, B:56:0x0391, B:57:0x0419, B:78:0x0340, B:80:0x034d, B:92:0x035c, B:82:0x036f, B:84:0x0375, B:85:0x037d, B:87:0x0383, B:141:0x03a9, B:143:0x03dd, B:144:0x03e0, B:145:0x03f7, B:147:0x03fe), top: B:37:0x012b, inners: #5 }] */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3620G(zzr zzrVar) {
        int i;
        long j;
        da3 m7875w;
        boolean z;
        long j2;
        String str;
        long m7839O;
        PackageInfo packageInfo;
        zzpv zzpvVar;
        String str2;
        String str3;
        ApplicationInfo applicationInfo;
        long j3;
        long j4;
        boolean z2;
        long j5;
        zzaX().zzg();
        m3644d();
        Preconditions.checkNotNull(zzrVar);
        String str4 = zzrVar.zza;
        Preconditions.checkNotEmpty(str4);
        if (!m3611C(zzrVar)) {
            return;
        }
        ob3 m7842R = zzj().m7842R(str4);
        if (m7842R != null && TextUtils.isEmpty(m7842R.m6540g()) && !TextUtils.isEmpty(zzrVar.zzb)) {
            m7842R.m6550q(0L);
            zzj().m7869q(m7842R, false);
            zzif zzr = zzr();
            zzr.zzg();
            zzr.f14230f.remove(str4);
        }
        if (!zzrVar.zzh) {
            m3637X(zzrVar);
            return;
        }
        long j6 = zzrVar.zzl;
        if (j6 == 0) {
            j6 = zzaU().currentTimeMillis();
        }
        zzio zzioVar = this.f14380l;
        zzioVar.zzg().zzg();
        int i2 = zzrVar.zzm;
        if (i2 != 0 && i2 != 1) {
            zzaW().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzhe.zzn(str4), Integer.valueOf(i2));
            i = 0;
        } else {
            i = i2;
        }
        zzj().zzH();
        try {
            ye3 m7852a0 = zzj().m7852a0(str4, "_npa");
            Boolean m3613E = m3613E(zzrVar);
            try {
                if (m7852a0 != null) {
                    if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(m7852a0.f28929b)) {
                    }
                    if (!zzi().zzx(null, zzgi.zzbl)) {
                        m3646f(zzrVar, zzrVar.zzF);
                    } else {
                        m3646f(zzrVar, j6);
                    }
                    m3637X(zzrVar);
                    if (i != 0) {
                        m7875w = zzj().m7875w("events", str4, "_f");
                        z = false;
                    } else {
                        m7875w = zzj().m7875w("events", str4, "_v");
                        z = true;
                    }
                    if (m7875w != null) {
                        long j7 = ((j6 / 3600000) + 1) * 3600000;
                        if (!z) {
                            m3628O(new zzqb(j6, Long.valueOf(j7), "_fot", DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                            zzaX().zzg();
                            zzhw zzhwVar = (zzhw) Preconditions.checkNotNull(this.f14379k);
                            if (str4 != null) {
                                try {
                                    if (!str4.isEmpty()) {
                                        zzio zzioVar2 = zzhwVar.f14224a;
                                        zzioVar2.zzaX().zzg();
                                        if (!zzhwVar.m3535a()) {
                                            zzioVar2.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                            j2 = j6;
                                        } else {
                                            zzhv zzhvVar = new zzhv(zzhwVar, str4);
                                            zzioVar2.zzaX().zzg();
                                            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                            j2 = j6;
                                            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                            PackageManager packageManager = zzioVar2.zzaT().getPackageManager();
                                            if (packageManager == null) {
                                                zzioVar2.zzaW().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                            } else {
                                                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                                                    ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                                                    if (serviceInfo != null) {
                                                        String str5 = serviceInfo.packageName;
                                                        if (serviceInfo.name != null && "com.android.vending".equals(str5) && zzhwVar.m3535a()) {
                                                            try {
                                                                boolean bindService = ConnectionTracker.getInstance().bindService(zzioVar2.zzaT(), new Intent(intent), zzhvVar, 1);
                                                                zzhc zzj = zzioVar2.zzaW().zzj();
                                                                if (bindService) {
                                                                    str = "available";
                                                                } else {
                                                                    str = "not available";
                                                                }
                                                                zzj.zzb("Install Referrer Service is", str);
                                                            } catch (RuntimeException e) {
                                                                zzhwVar.f14224a.zzaW().zze().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                            }
                                                        } else {
                                                            zzioVar2.zzaW().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                        }
                                                    }
                                                } else {
                                                    zzioVar2.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                                }
                                            }
                                        }
                                        zzaX().zzg();
                                        m3644d();
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("_c", 1L);
                                        bundle.putLong("_r", 1L);
                                        bundle.putLong("_uwa", 0L);
                                        bundle.putLong("_pfo", 0L);
                                        bundle.putLong("_sys", 0L);
                                        bundle.putLong("_sysu", 0L);
                                        bundle.putLong("_et", 1L);
                                        if (zzrVar.zzo) {
                                            bundle.putLong("_dac", 1L);
                                        }
                                        String str6 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                        v93 zzj2 = zzj();
                                        Preconditions.checkNotEmpty(str6);
                                        zzj2.zzg();
                                        zzj2.zzav();
                                        m7839O = zzj2.m7839O(str6);
                                        if (zzioVar.zzaT().getPackageManager() != null) {
                                            zzaW().zze().zzb("PackageManager is null, first open report might be inaccurate. appId", zzhe.zzn(str6));
                                            j3 = 0;
                                            zzpvVar = this;
                                            str2 = "_pfo";
                                        } else {
                                            try {
                                                packageInfo = Wrappers.packageManager(zzioVar.zzaT()).getPackageInfo(str6, 0);
                                            } catch (PackageManager.NameNotFoundException e2) {
                                                zzaW().zze().zzc("Package info is null, first open report might be inaccurate. appId", zzhe.zzn(str6), e2);
                                                packageInfo = null;
                                            }
                                            if (packageInfo != null) {
                                                long j8 = packageInfo.firstInstallTime;
                                                if (j8 != 0) {
                                                    str2 = "_pfo";
                                                    str3 = "_sysu";
                                                    if (j8 != packageInfo.lastUpdateTime) {
                                                        applicationInfo = null;
                                                        if (zzi().zzx(null, zzgi.zzaH)) {
                                                            if (m7839O == 0) {
                                                                bundle.putLong("_uwa", 1L);
                                                                z2 = false;
                                                                m7839O = 0;
                                                            }
                                                        } else {
                                                            bundle.putLong("_uwa", 1L);
                                                        }
                                                        z2 = false;
                                                    } else {
                                                        applicationInfo = null;
                                                        z2 = true;
                                                    }
                                                    if (true != z2) {
                                                        j5 = 0;
                                                    } else {
                                                        j5 = 1;
                                                    }
                                                    zzpvVar = this;
                                                    zzpvVar.m3628O(new zzqb(j2, Long.valueOf(j5), "_fi", DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                                                    applicationInfo = Wrappers.packageManager(zzioVar.zzaT()).getApplicationInfo(str6, 0);
                                                    if (applicationInfo != null) {
                                                        if ((applicationInfo.flags & 1) != 0) {
                                                            j4 = 1;
                                                            bundle.putLong("_sys", 1L);
                                                        } else {
                                                            j4 = 1;
                                                        }
                                                        if ((applicationInfo.flags & 128) != 0) {
                                                            bundle.putLong(str3, j4);
                                                        }
                                                    }
                                                    j3 = 0;
                                                }
                                            }
                                            zzpvVar = this;
                                            str2 = "_pfo";
                                            str3 = "_sysu";
                                            applicationInfo = null;
                                            applicationInfo = Wrappers.packageManager(zzioVar.zzaT()).getApplicationInfo(str6, 0);
                                            if (applicationInfo != null) {
                                            }
                                            j3 = 0;
                                        }
                                        if (m7839O >= j3) {
                                            bundle.putLong(str2, m7839O);
                                        }
                                        zzpvVar.m3651k(new zzbh("_f", new zzbf(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j2), zzrVar);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    zzj().m7863k();
                                    throw th;
                                }
                            }
                            j2 = j6;
                            zzhwVar.f14224a.zzaW().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaX().zzg();
                            m3644d();
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("_c", 1L);
                            bundle2.putLong("_r", 1L);
                            bundle2.putLong("_uwa", 0L);
                            bundle2.putLong("_pfo", 0L);
                            bundle2.putLong("_sys", 0L);
                            bundle2.putLong("_sysu", 0L);
                            bundle2.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                            }
                            String str62 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            v93 zzj22 = zzj();
                            Preconditions.checkNotEmpty(str62);
                            zzj22.zzg();
                            zzj22.zzav();
                            m7839O = zzj22.m7839O(str62);
                            if (zzioVar.zzaT().getPackageManager() != null) {
                            }
                            if (m7839O >= j3) {
                            }
                            zzpvVar.m3651k(new zzbh("_f", new zzbf(bundle2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j2), zzrVar);
                        } else {
                            long j9 = j6;
                            m3628O(new zzqb(j9, Long.valueOf(j7), "_fvt", DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                            zzaX().zzg();
                            m3644d();
                            Bundle bundle3 = new Bundle();
                            bundle3.putLong("_c", 1L);
                            bundle3.putLong("_r", 1L);
                            bundle3.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle3.putLong("_dac", 1L);
                            }
                            m3651k(new zzbh("_v", new zzbf(bundle3), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j9), zzrVar);
                        }
                    } else {
                        long j10 = j6;
                        if (zzrVar.zzi) {
                            m3651k(new zzbh("_cd", new zzbf(new Bundle()), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j10), zzrVar);
                        }
                    }
                    zzj().m7868p();
                    zzj().m7863k();
                    return;
                }
                if (m7875w != null) {
                }
                zzj().m7868p();
                zzj().m7863k();
                return;
            } catch (Throwable th2) {
                th = th2;
            }
            if (m3613E != null) {
                if (true != m3613E.booleanValue()) {
                    j = 0;
                } else {
                    j = 1;
                }
                zzqb zzqbVar = new zzqb(j6, Long.valueOf(j), "_npa", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                if (m7852a0 == null || !m7852a0.f28932e.equals(zzqbVar.zzd)) {
                    m3628O(zzqbVar, zzrVar);
                }
            } else if (m7852a0 != null) {
                m3622I("_npa", zzrVar);
            }
            if (!zzi().zzx(null, zzgi.zzbl)) {
            }
            m3637X(zzrVar);
            if (i != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: H */
    public final void m3621H(zzai zzaiVar, zzr zzrVar) {
        Bundle bundle;
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        m3644d();
        if (!m3611C(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            m3637X(zzrVar);
            return;
        }
        zzj().zzH();
        try {
            m3637X(zzrVar);
            String str = (String) Preconditions.checkNotNull(zzaiVar.zza);
            zzai m7843S = zzj().m7843S(str, zzaiVar.zzc.zzb);
            zzio zzioVar = this.f14380l;
            if (m7843S != null) {
                zzaW().zzd().zzc("Removing conditional user property", zzaiVar.zza, zzioVar.zzj().zzf(zzaiVar.zzc.zzb));
                zzj().m7874v(str, zzaiVar.zzc.zzb);
                if (m7843S.zze) {
                    zzj().m7866n(str, zzaiVar.zzc.zzb);
                }
                zzbh zzbhVar = zzaiVar.zzk;
                if (zzbhVar != null) {
                    zzbf zzbfVar = zzbhVar.zzb;
                    if (zzbfVar != null) {
                        bundle = zzbfVar.zzc();
                    } else {
                        bundle = null;
                    }
                    m3633T((zzbh) Preconditions.checkNotNull(zzB().m3723b(((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, bundle, m7843S.zzb, zzbhVar.zzd, true)), zzrVar);
                }
            } else {
                zzaW().zzk().zzc("Conditional user property doesn't exist", zzhe.zzn(zzaiVar.zza), zzioVar.zzj().zzf(zzaiVar.zzc.zzb));
            }
            zzj().m7868p();
            zzj().m7863k();
        } catch (Throwable th) {
            zzj().m7863k();
            throw th;
        }
    }

    /* renamed from: I */
    public final void m3622I(String str, zzr zzrVar) {
        long j;
        zzaX().zzg();
        m3644d();
        if (!m3611C(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            m3637X(zzrVar);
            return;
        }
        Boolean m3613E = m3613E(zzrVar);
        if ("_npa".equals(str) && m3613E != null) {
            zzaW().zzd().zza("Falling back to manifest metadata value for ad personalization");
            long currentTimeMillis = zzaU().currentTimeMillis();
            if (true != m3613E.booleanValue()) {
                j = 0;
            } else {
                j = 1;
            }
            m3628O(new zzqb(currentTimeMillis, Long.valueOf(j), "_npa", DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
            return;
        }
        zzhc zzd = zzaW().zzd();
        zzio zzioVar = this.f14380l;
        zzd.zzb("Removing user property", zzioVar.zzj().zzf(str));
        zzj().zzH();
        try {
            m3637X(zzrVar);
            if ("_id".equals(str)) {
                zzj().m7866n((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
            }
            zzj().m7866n((String) Preconditions.checkNotNull(zzrVar.zza), str);
            zzj().m7868p();
            zzaW().zzd().zzb("User property removed", zzioVar.zzj().zzf(str));
            zzj().m7863k();
        } catch (Throwable th) {
            zzj().m7863k();
            throw th;
        }
    }

    /* renamed from: J */
    public final void m3623J(zzr zzrVar) {
        boolean z;
        zzaX().zzg();
        m3644d();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zze = zzba.zze(zzrVar.zzA);
        zzaW().zzj().zzc("Setting DMA consent for package", str, zze);
        zzaX().zzg();
        m3644d();
        zzju zzf = zzba.zzc(m3635V(str), 100).zzf();
        this.f14361C.put(str, zze);
        v93 zzj = zzj();
        zzj.getClass();
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zze);
        zzj.zzg();
        zzj.zzav();
        zzjx m7849Y = zzj.m7849Y(str);
        zzjx zzjxVar = zzjx.zza;
        if (m7849Y == zzjxVar) {
            zzj.m7871s(str, zzjxVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zze.zzj());
        zzj.m7829C(contentValues);
        zzju zzf2 = zzba.zzc(m3635V(str), 100).zzf();
        zzaX().zzg();
        m3644d();
        zzju zzjuVar = zzju.DENIED;
        boolean z2 = true;
        if (zzf == zzjuVar && zzf2 == zzju.GRANTED) {
            z = true;
        } else {
            z = false;
        }
        if (zzf != zzju.GRANTED || zzf2 != zzjuVar) {
            z2 = false;
        }
        if (!z && !z2) {
            return;
        }
        zzaW().zzj().zzb("Generated _dcu event for", str);
        Bundle bundle = new Bundle();
        if (zzj().m7845U(m3654n(), str, false, false, false, false).f14130f < zzi().zzh(str, zzgi.zzal)) {
            bundle.putLong("_r", 1L);
            zzaW().zzj().zzc("_dcu realtime event count", str, Long.valueOf(zzj().m7845U(m3654n(), str, false, false, true, false).f14130f));
        }
        this.f14368J.m98h(str, "_dcu", bundle);
    }

    /* renamed from: K */
    public final void m3624K(zzr zzrVar) {
        zzaX().zzg();
        m3644d();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjx zzk = zzjx.zzk(zzrVar.zzu, zzrVar.zzz);
        m3641a0(str);
        zzaW().zzj().zzc("Setting storage consent for package", str, zzk);
        zzaX().zzg();
        m3644d();
        this.f14360B.put(str, zzk);
        zzj().m7871s(str, zzk);
    }

    /* renamed from: L */
    public final void m3625L(ArrayList arrayList) {
        Preconditions.checkArgument(!arrayList.isEmpty());
        if (this.f14393y != null) {
            zzaW().zze().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.f14393y = new ArrayList(arrayList);
        }
    }

    /* renamed from: M */
    public final void m3626M(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzb);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        m3644d();
        if (!m3611C(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            m3637X(zzrVar);
            return;
        }
        zzai zzaiVar2 = new zzai(zzaiVar);
        boolean z = false;
        zzaiVar2.zze = false;
        zzj().zzH();
        try {
            zzai m7843S = zzj().m7843S((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzc.zzb);
            zzio zzioVar = this.f14380l;
            if (m7843S != null && !m7843S.zzb.equals(zzaiVar2.zzb)) {
                zzaW().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzioVar.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzb, m7843S.zzb);
            }
            if (m7843S != null && m7843S.zze) {
                zzaiVar2.zzb = m7843S.zzb;
                zzaiVar2.zzd = m7843S.zzd;
                zzaiVar2.zzh = m7843S.zzh;
                zzaiVar2.zzf = m7843S.zzf;
                zzaiVar2.zzi = m7843S.zzi;
                zzaiVar2.zze = true;
                zzqb zzqbVar = zzaiVar2.zzc;
                zzaiVar2.zzc = new zzqb(m7843S.zzc.zzc, zzqbVar.zza(), zzqbVar.zzb, m7843S.zzc.zzf);
            } else if (TextUtils.isEmpty(zzaiVar2.zzf)) {
                zzqb zzqbVar2 = zzaiVar2.zzc;
                zzaiVar2.zzc = new zzqb(zzaiVar2.zzd, zzqbVar2.zza(), zzqbVar2.zzb, zzaiVar2.zzc.zzf);
                zzaiVar2.zze = true;
                z = true;
            }
            if (zzaiVar2.zze) {
                zzqb zzqbVar3 = zzaiVar2.zzc;
                ye3 ye3Var = new ye3((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzb, zzqbVar3.zzb, zzqbVar3.zzc, Preconditions.checkNotNull(zzqbVar3.zza()));
                Object obj = ye3Var.f28932e;
                String str = ye3Var.f28930c;
                if (zzj().m7834I(ye3Var)) {
                    zzaW().zzd().zzd("User property updated immediately", zzaiVar2.zza, zzioVar.zzj().zzf(str), obj);
                } else {
                    zzaW().zze().zzd("(2)Too many active user properties, ignoring", zzhe.zzn(zzaiVar2.zza), zzioVar.zzj().zzf(str), obj);
                }
                if (z && zzaiVar2.zzi != null) {
                    m3633T(new zzbh(zzaiVar2.zzi, zzaiVar2.zzd), zzrVar);
                }
            }
            if (zzj().m7833H(zzaiVar2)) {
                zzaW().zzd().zzd("Conditional property added", zzaiVar2.zza, zzioVar.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
            } else {
                zzaW().zze().zzd("Too many conditional properties, ignoring", zzhe.zzn(zzaiVar2.zza), zzioVar.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
            }
            zzj().m7868p();
            zzj().m7863k();
        } catch (Throwable th) {
            zzj().m7863k();
            throw th;
        }
    }

    /* renamed from: N */
    public final void m3627N(String str, boolean z, Long l, Long l2) {
        boolean z2;
        ob3 m7842R = zzj().m7842R(str);
        if (m7842R != null) {
            zzio zzioVar = m7842R.f23733a;
            zzioVar.zzaX().zzg();
            boolean z3 = m7842R.f23730R;
            if (m7842R.f23758z != z) {
                z2 = true;
            } else {
                z2 = false;
            }
            m7842R.f23730R = z3 | z2;
            m7842R.f23758z = z;
            zzioVar.zzaX().zzg();
            m7842R.f23730R |= !Objects.equals(m7842R.f23713A, l);
            m7842R.f23713A = l;
            zzioVar.zzaX().zzg();
            m7842R.f23730R |= !Objects.equals(m7842R.f23714B, l2);
            m7842R.f23714B = l2;
            zzioVar.zzaX().zzg();
            if (m7842R.f23730R) {
                zzj().m7869q(m7842R, false);
            }
        }
    }

    /* renamed from: O */
    public final void m3628O(zzqb zzqbVar, zzr zzrVar) {
        boolean z;
        ye3 m7852a0;
        long j;
        long j2;
        int i;
        int i2;
        zzaX().zzg();
        m3644d();
        if (m3611C(zzrVar)) {
            if (!zzrVar.zzh) {
                m3637X(zzrVar);
                return;
            }
            zzqf zzB = zzB();
            String str = zzqbVar.zzb;
            int m3718P = zzB.m3718P(str);
            ai2 ai2Var = this.f14368J;
            if (m3718P != 0) {
                zzqf zzB2 = zzB();
                zzi();
                String zzG = zzB2.zzG(str, 24, true);
                if (str != null) {
                    i2 = str.length();
                } else {
                    i2 = 0;
                }
                zzqf zzB3 = zzB();
                String str2 = zzrVar.zza;
                zzB3.getClass();
                zzqf.m3708m(ai2Var, str2, m3718P, "_ev", zzG, i2);
                return;
            }
            int m3716N = zzB().m3716N(zzqbVar.zza(), str);
            if (m3716N != 0) {
                zzqf zzB4 = zzB();
                zzi();
                String zzG2 = zzB4.zzG(str, 24, true);
                Object zza = zzqbVar.zza();
                if (zza == null || (!(zza instanceof String) && !(zza instanceof CharSequence))) {
                    i = 0;
                } else {
                    i = zza.toString().length();
                }
                zzqf zzB5 = zzB();
                String str3 = zzrVar.zza;
                zzB5.getClass();
                zzqf.m3708m(ai2Var, str3, m3716N, "_ev", zzG2, i);
                return;
            }
            Object m3725d = zzB().m3725d(zzqbVar.zza(), str);
            if (m3725d != null) {
                long j3 = 0;
                if ("_sid".equals(str)) {
                    long j4 = zzqbVar.zzc;
                    String str4 = zzqbVar.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    ye3 m7852a02 = zzj().m7852a0(str5, "_sno");
                    if (m7852a02 != null) {
                        Object obj = m7852a02.f28932e;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            j = j4;
                            m3628O(new zzqb(j, Long.valueOf(j2 + 1), "_sno", str4), zzrVar);
                        }
                    }
                    if (m7852a02 != null) {
                        zzaW().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", m7852a02.f28932e);
                    }
                    da3 m7875w = zzj().m7875w("events", str5, "_s");
                    if (m7875w != null) {
                        zzhc zzj = zzaW().zzj();
                        j = j4;
                        long j5 = m7875w.f16316c;
                        zzj.zzb("Backfill the session number. Last used session number", Long.valueOf(j5));
                        j2 = j5;
                    } else {
                        j = j4;
                        j2 = 0;
                    }
                    m3628O(new zzqb(j, Long.valueOf(j2 + 1), "_sno", str4), zzrVar);
                }
                String str6 = zzrVar.zza;
                ye3 ye3Var = new ye3((String) Preconditions.checkNotNull(str6), (String) Preconditions.checkNotNull(zzqbVar.zzf), str, zzqbVar.zzc, m3725d);
                zzhc zzj2 = zzaW().zzj();
                zzio zzioVar = this.f14380l;
                zzgx zzj3 = zzioVar.zzj();
                String str7 = ye3Var.f28930c;
                zzj2.zzc("Setting user property", zzj3.zzf(str7), m3725d);
                zzj().zzH();
                try {
                    boolean equals = "_id".equals(str7);
                    Object obj2 = ye3Var.f28932e;
                    if (equals && (m7852a0 = zzj().m7852a0(str6, "_id")) != null && !obj2.equals(m7852a0.f28932e)) {
                        zzj().m7866n(str6, "_lair");
                    }
                    m3637X(zzrVar);
                    boolean m7834I = zzj().m7834I(ye3Var);
                    if ("_sid".equals(str)) {
                        zzqa zzA = zzA();
                        String str8 = zzrVar.zzw;
                        zzA.getClass();
                        if (!TextUtils.isEmpty(str8)) {
                            j3 = zzA.m3691r(str8.getBytes(Charset.forName("UTF-8")));
                        }
                        long j6 = j3;
                        ob3 m7842R = zzj().m7842R(str6);
                        if (m7842R != null) {
                            zzio zzioVar2 = m7842R.f23733a;
                            zzioVar2.zzaX().zzg();
                            boolean z2 = m7842R.f23730R;
                            if (m7842R.f23756x != j6) {
                                z = true;
                            } else {
                                z = false;
                            }
                            m7842R.f23730R = z2 | z;
                            m7842R.f23756x = j6;
                            zzioVar2.zzaX().zzg();
                            if (m7842R.f23730R) {
                                zzj().m7869q(m7842R, false);
                            }
                        }
                    }
                    zzj().m7868p();
                    if (!m7834I) {
                        zzaW().zze().zzc("Too many unique user properties are set. Ignoring user property", zzioVar.zzj().zzf(str7), obj2);
                        zzB().getClass();
                        zzqf.m3708m(ai2Var, str6, 9, null, null, 0);
                    }
                    zzj().m7863k();
                } catch (Throwable th) {
                    zzj().m7863k();
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
    
        if (r7 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0192, code lost:
    
        if (r1 == 0) goto L71;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpv] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3629P() {
        v93 zzj;
        long zzF;
        SQLiteException e;
        ob3 m7842R;
        zzaX().zzg();
        m3644d();
        this.f14390v = true;
        try {
            zzio zzioVar = this.f14380l;
            zzioVar.zzaV();
            Boolean bool = zzioVar.zzu().f14339d;
            if (bool == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.f14383o > 0) {
                m3661x();
            } else {
                zzaX().zzg();
                if (this.f14393y != null) {
                    zzaW().zzj().zza("Uploading requested multiple times");
                } else if (!zzp().zzd()) {
                    zzaW().zzj().zza("Network not connected, ignoring upload request");
                    m3661x();
                } else {
                    ?? currentTimeMillis = zzaU().currentTimeMillis();
                    Cursor cursor = null;
                    r7 = null;
                    Cursor cursor2 = null;
                    r7 = null;
                    r7 = null;
                    String str = null;
                    int zzh = zzi().zzh(null, zzgi.zzah);
                    zzi();
                    long zzF2 = currentTimeMillis - zzam.zzF();
                    for (int i = 0; i < zzh && m3662y(zzF2, null); i++) {
                    }
                    zzqr.zzb();
                    zzaX().zzg();
                    m3660w();
                    long zza = this.f14377i.zzd.zza();
                    if (zza != 0) {
                        zzaW().zzd().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                    }
                    String m7851a = zzj().m7851a();
                    long j = -1;
                    if (!TextUtils.isEmpty(m7851a)) {
                        if (this.f14359A == -1) {
                            v93 zzj2 = zzj();
                            try {
                                try {
                                    cursor2 = zzj2.m7841Q().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursor2.moveToFirst()) {
                                        j = cursor2.getLong(0);
                                    }
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                }
                            } catch (SQLiteException e2) {
                                zzj2.zzu.zzaW().zze().zzb("Error querying raw events", e2);
                            }
                            cursor2.close();
                            this.f14359A = j;
                        }
                        m3630Q(currentTimeMillis, m7851a);
                    } else {
                        try {
                            this.f14359A = -1L;
                            zzj = zzj();
                            zzi();
                            zzF = currentTimeMillis - zzam.zzF();
                            zzj.zzg();
                            zzj.zzav();
                        } catch (Throwable th) {
                            th = th;
                            cursor = currentTimeMillis;
                        }
                        try {
                            currentTimeMillis = zzj.m7841Q().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (!currentTimeMillis.moveToFirst()) {
                                    zzj.zzu.zzaW().zzj().zza("No expired configs for apps with pending events");
                                } else {
                                    str = currentTimeMillis.getString(0);
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                zzj.zzu.zzaW().zze().zzb("Error selecting expired configs", e);
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            currentTimeMillis = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                        currentTimeMillis.close();
                        if (!TextUtils.isEmpty(str) && (m7842R = zzj().m7842R(str)) != null) {
                            m3645e(m7842R);
                        }
                    }
                }
            }
            this.f14390v = false;
            m3658u();
        } catch (Throwable th3) {
            this.f14390v = false;
            m3658u();
            throw th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:336:0x01f6, code lost:
    
        if (r11 == null) goto L93;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01d4: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:469), block:B:339:0x01d4 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x053e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03d9  */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3630Q(long j, String str) {
        boolean z;
        boolean z2;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        List emptyList;
        boolean z3;
        zzio zzioVar;
        boolean z4;
        String str2;
        long j2;
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        zzph zzphVar;
        zzmf zzmfVar;
        zzmf zzmfVar2;
        Object zzi;
        Object obj;
        int i;
        boolean z5;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        ArrayMap arrayMap3;
        String zzaL;
        Iterator it;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        com.google.android.gms.internal.measurement.zzim zzb;
        int m3680q;
        int indexOf;
        String str3;
        byte[] byteArray;
        long j3;
        long j4;
        int zzh = zzi().zzh(str, zzgi.zzg);
        int i2 = 0;
        int max = Math.max(0, zzi().zzh(str, zzgi.zzh));
        v93 zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        int i3 = 1;
        if (zzh > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (max > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                cursor2 = zzj.m7841Q().query("queue", new String[]{"rowid", DataSchemeDataSource.SCHEME_DATA, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzh));
                try {
                } catch (SQLiteException e) {
                    e = e;
                    zzj.zzu.zzaW().zze().zzc("Error querying bundles. appId", zzhe.zzn(str), e);
                    emptyList = Collections.emptyList();
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursor3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (!cursor2.moveToFirst()) {
            emptyList = Collections.emptyList();
            cursor2.close();
            if (emptyList.isEmpty()) {
                if (m3641a0(str).zzr(zzjw.AD_STORAGE)) {
                    Iterator it2 = emptyList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhx zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((Pair) it2.next()).first;
                            if (!zzhxVar.zzT().isEmpty()) {
                                str3 = zzhxVar.zzT();
                                break;
                            }
                        } else {
                            str3 = null;
                            break;
                        }
                    }
                    if (str3 != null) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= emptyList.size()) {
                                break;
                            }
                            com.google.android.gms.internal.measurement.zzhx zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i4)).first;
                            if (!zzhxVar2.zzT().isEmpty() && !zzhxVar2.zzT().equals(str3)) {
                                emptyList = emptyList.subList(0, i4);
                                break;
                            }
                            i4++;
                        }
                    }
                }
                zzht zzb2 = com.google.android.gms.internal.measurement.zzhv.zzb();
                int size = emptyList.size();
                ArrayList arrayList = new ArrayList(emptyList.size());
                if (zzi().zzy(str) && m3641a0(str).zzr(zzjw.AD_STORAGE)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean zzr = m3641a0(str).zzr(zzjw.AD_STORAGE);
                boolean zzr2 = m3641a0(str).zzr(zzjw.ANALYTICS_STORAGE);
                zzrd.zzb();
                boolean zzx = zzi().zzx(str, zzgi.zzaL);
                zzpi zzpiVar = this.f14378j;
                zzph zza = zzpiVar.zza(str);
                int i5 = 0;
                while (true) {
                    zzioVar = this.f14380l;
                    if (i5 >= size) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i5)).first).zzch();
                    List list = emptyList;
                    arrayList.add((Long) ((Pair) emptyList.get(i5)).second);
                    zzi().zzj();
                    int i6 = size;
                    ArrayList arrayList2 = arrayList;
                    zzhwVar.zzaB(119002L);
                    zzhwVar.zzaA(j);
                    zzioVar.zzaV();
                    zzhwVar.zzau(false);
                    if (!z3) {
                        zzhwVar.zzt();
                    }
                    if (!zzr) {
                        zzhwVar.zzz();
                        zzhwVar.zzw();
                    }
                    if (!zzr2) {
                        zzhwVar.zzq();
                    }
                    zzif zzr3 = zzr();
                    zzr3.zzg();
                    zzr3.m3542e(str);
                    Set set = (Set) zzr3.f14227c.get(str);
                    if (set != null) {
                        zzhwVar.zzl(set);
                    }
                    zzif zzr4 = zzr();
                    zzr4.zzg();
                    zzr4.m3542e(str);
                    ArrayMap arrayMap4 = zzr4.f14227c;
                    if (arrayMap4.get(str) != 0) {
                        i = i6;
                        z5 = z3;
                        if (((Set) arrayMap4.get(str)).contains("device_model") || ((Set) arrayMap4.get(str)).contains("device_info")) {
                            zzhwVar.zzs();
                        }
                    } else {
                        i = i6;
                        z5 = z3;
                    }
                    if (zzr().m3539b(str)) {
                        String zzaK = zzhwVar.zzaK();
                        if (!TextUtils.isEmpty(zzaK) && (indexOf = zzaK.indexOf(".")) != -1) {
                            zzhwVar.zzam(zzaK.substring(0, indexOf));
                            zzif zzr5 = zzr();
                            zzr5.zzg();
                            zzr5.m3542e(str);
                            arrayMap = zzr5.f14227c;
                            if (arrayMap.get(str) != 0 && ((Set) arrayMap.get(str)).contains("user_id") && (m3680q = zzqa.m3680q(zzhwVar, "_id")) != -1) {
                                zzhwVar.zzE(m3680q);
                            }
                            zzif zzr6 = zzr();
                            zzr6.zzg();
                            zzr6.m3542e(str);
                            arrayMap2 = zzr6.f14227c;
                            if (arrayMap2.get(str) != 0 && ((Set) arrayMap2.get(str)).contains("google_signals")) {
                                zzhwVar.zzt();
                            }
                            if (zzr().m3538a(str)) {
                                zzhwVar.zzq();
                                if (m3641a0(str).zzr(zzjw.ANALYTICS_STORAGE)) {
                                    HashMap hashMap = this.f14362D;
                                    te3 te3Var = (te3) hashMap.get(str);
                                    if (te3Var == null || zzi().zzk(str, zzgi.zzaj) + te3Var.f26791b < zzaU().elapsedRealtime()) {
                                        te3Var = new te3(this, zzB().m3726e());
                                        hashMap.put(str, te3Var);
                                    }
                                    zzhwVar.zzac(te3Var.f26790a);
                                }
                            }
                            zzif zzr7 = zzr();
                            zzr7.zzg();
                            zzr7.m3542e(str);
                            arrayMap3 = zzr7.f14227c;
                            if (arrayMap3.get(str) != 0 && ((Set) arrayMap3.get(str)).contains("enhanced_user_id")) {
                                zzhwVar.zzA();
                            }
                            if (!zzx) {
                                zzhwVar.zzA();
                            }
                            if (!zzr2) {
                                zzhwVar.zzr();
                            }
                            zzaL = zzhwVar.zzaL();
                            if (TextUtils.isEmpty(zzaL) && !zzaL.equals("00000000-0000-0000-0000-000000000000")) {
                                z8 = zzr;
                                z9 = zzr2;
                                z10 = zzx;
                            } else {
                                ArrayList arrayList3 = new ArrayList(zzhwVar.zzaM());
                                it = arrayList3.iterator();
                                Long l = null;
                                Long l2 = null;
                                z6 = false;
                                z7 = false;
                                while (it.hasNext()) {
                                    boolean z11 = zzr;
                                    zzhm zzhmVar = (zzhm) it.next();
                                    boolean z12 = zzr2;
                                    boolean z13 = zzx;
                                    if ("_fx".equals(zzhmVar.zzh())) {
                                        it.remove();
                                        zzr2 = z12;
                                        zzr = z11;
                                        zzx = z13;
                                        z6 = true;
                                    } else if ("_f".equals(zzhmVar.zzh())) {
                                        zzA();
                                        com.google.android.gms.internal.measurement.zzhq m3671f = zzqa.m3671f(zzhmVar, "_pfo");
                                        if (m3671f != null) {
                                            l = Long.valueOf(m3671f.zzd());
                                        }
                                        zzA();
                                        com.google.android.gms.internal.measurement.zzhq m3671f2 = zzqa.m3671f(zzhmVar, "_uwa");
                                        if (m3671f2 != null) {
                                            l2 = Long.valueOf(m3671f2.zzd());
                                        }
                                        zzr2 = z12;
                                        zzr = z11;
                                        zzx = z13;
                                    } else {
                                        zzr2 = z12;
                                        zzr = z11;
                                        zzx = z13;
                                    }
                                    z7 = true;
                                }
                                z8 = zzr;
                                z9 = zzr2;
                                z10 = zzx;
                                if (z6) {
                                    zzhwVar.zzu();
                                    zzhwVar.zzj(arrayList3);
                                }
                                if (z7) {
                                    m3627N(zzhwVar.zzaF(), true, l, l2);
                                }
                            }
                            if (zzhwVar.zzc() != 0) {
                                if (zzi().zzx(str, zzgi.zzaB)) {
                                    zzhwVar.zzQ(zzA().m3691r(((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba()).zzcd()));
                                }
                                if (zzi().zzx(null, zzgi.zzaP) && (zzb = zza.zzb()) != null) {
                                    zzhwVar.zzaw(zzb);
                                }
                                zzb2.zzc(zzhwVar);
                            }
                            i5++;
                            arrayList = arrayList2;
                            emptyList = list;
                            z3 = z5;
                            size = i;
                            zzr2 = z9;
                            zzr = z8;
                            zzx = z10;
                        }
                    }
                    zzif zzr52 = zzr();
                    zzr52.zzg();
                    zzr52.m3542e(str);
                    arrayMap = zzr52.f14227c;
                    if (arrayMap.get(str) != 0) {
                        zzhwVar.zzE(m3680q);
                    }
                    zzif zzr62 = zzr();
                    zzr62.zzg();
                    zzr62.m3542e(str);
                    arrayMap2 = zzr62.f14227c;
                    if (arrayMap2.get(str) != 0) {
                        zzhwVar.zzt();
                    }
                    if (zzr().m3538a(str)) {
                    }
                    zzif zzr72 = zzr();
                    zzr72.zzg();
                    zzr72.m3542e(str);
                    arrayMap3 = zzr72.f14227c;
                    if (arrayMap3.get(str) != 0) {
                        zzhwVar.zzA();
                    }
                    if (!zzx) {
                    }
                    if (!zzr2) {
                    }
                    zzaL = zzhwVar.zzaL();
                    if (TextUtils.isEmpty(zzaL)) {
                    }
                    ArrayList arrayList32 = new ArrayList(zzhwVar.zzaM());
                    it = arrayList32.iterator();
                    Long l3 = null;
                    Long l22 = null;
                    z6 = false;
                    z7 = false;
                    while (it.hasNext()) {
                    }
                    z8 = zzr;
                    z9 = zzr2;
                    z10 = zzx;
                    if (z6) {
                    }
                    if (z7) {
                    }
                    if (zzhwVar.zzc() != 0) {
                    }
                    i5++;
                    arrayList = arrayList2;
                    emptyList = list;
                    z3 = z5;
                    size = i;
                    zzr2 = z9;
                    zzr = z8;
                    zzx = z10;
                }
                ArrayList arrayList4 = arrayList;
                if (zzb2.zza() == 0) {
                    m3625L(arrayList4);
                    m3653m(false, HttpStatusCodesKt.HTTP_NO_CONTENT, null, null, str, Collections.emptyList());
                    return;
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzb2.zzba();
                ArrayList arrayList5 = new ArrayList();
                if (zzi().zzx(null, zzgi.zzaP) && zza.zza() == zzmf.SGTM_CLIENT) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (zza.zza() != zzmf.SGTM) {
                    if (z4) {
                        z4 = true;
                    } else {
                        j2 = j;
                        if (zzi().zzx(null, zzgi.zzaO) || zzp().zzd()) {
                            if (!Log.isLoggable(zzaW().zzr(), 2)) {
                                obj = zzA().m3695y(zzhvVar);
                            } else {
                                obj = null;
                            }
                            zzA();
                            byte[] zzcd = zzhvVar.zzcd();
                            m3625L(arrayList4);
                            this.f14377i.zze.zzb(j2);
                            zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd.length), obj);
                            this.f14389u = true;
                            zzp().zzc(str, zza, zzhvVar, new jz2(this, str, (Object) arrayList5, 10));
                            return;
                        }
                        return;
                    }
                }
                Iterator it3 = ((com.google.android.gms.internal.measurement.zzhv) zzb2.zzba()).zzh().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (((com.google.android.gms.internal.measurement.zzhx) it3.next()).zzbI()) {
                            str2 = UUID.randomUUID().toString();
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzb2.zzba();
                zzaX().zzg();
                m3644d();
                zzht zzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar2);
                if (!TextUtils.isEmpty(str2)) {
                    zzc.zzf(str2);
                }
                String m3547l = zzr().m3547l(str);
                if (!TextUtils.isEmpty(m3547l)) {
                    zzc.zzg(m3547l);
                }
                ArrayList arrayList6 = new ArrayList();
                Iterator it4 = zzhvVar2.zzh().iterator();
                while (it4.hasNext()) {
                    com.google.android.gms.internal.measurement.zzhw zzA = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it4.next());
                    zzA.zzt();
                    arrayList6.add((com.google.android.gms.internal.measurement.zzhx) zzA.zzba());
                }
                zzc.zzd();
                zzc.zzb(arrayList6);
                zzam zzi2 = zzi();
                zzgg zzggVar = zzgi.zzaN;
                if (zzi2.zzx(null, zzggVar)) {
                    zzhc zzj2 = zzaW().zzj();
                    if (TextUtils.isEmpty(str2)) {
                        zzi = "null";
                    } else {
                        zzi = zzc.zzi();
                    }
                    zzj2.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", zzi);
                } else {
                    zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzc.zzba();
                if (!TextUtils.isEmpty(str2) && zzi().zzx(null, zzggVar)) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzb2.zzba();
                    zzaX().zzg();
                    m3644d();
                    zzht zzb3 = com.google.android.gms.internal.measurement.zzhv.zzb();
                    zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str2);
                    zzb3.zzf(str2);
                    for (com.google.android.gms.internal.measurement.zzhx zzhxVar3 : zzhvVar4.zzh()) {
                        com.google.android.gms.internal.measurement.zzhw zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                        zzz.zzY(zzhxVar3.zzN());
                        zzz.zzV(zzhxVar3.zzd());
                        zzb3.zzc(zzz);
                    }
                    com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
                    String m3547l2 = zzpiVar.zzg.zzr().m3547l(str);
                    if (!TextUtils.isEmpty(m3547l2)) {
                        Uri parse = Uri.parse((String) zzgi.zzr.zza(null));
                        Uri.Builder buildUpon = parse.buildUpon();
                        buildUpon.authority(m3547l2 + "." + parse.getAuthority());
                        String uri = buildUpon.build().toString();
                        if (z4) {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(uri, Collections.emptyMap(), zzmfVar2, null);
                    } else {
                        String str4 = (String) zzgi.zzr.zza(null);
                        if (z4) {
                            zzmfVar = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(str4, Collections.emptyMap(), zzmfVar, null);
                    }
                    arrayList5.add(Pair.create(zzhvVar5, zzphVar));
                }
                if (z4) {
                    zzht zzhtVar = (zzht) zzhvVar3.zzch();
                    for (int i7 = 0; i7 < zzhvVar3.zza(); i7++) {
                        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar3.zze(i7).zzch();
                        zzhwVar2.zzC();
                        zzhwVar2.zzO(j);
                        zzhtVar.zze(i7, zzhwVar2);
                    }
                    arrayList5.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zza));
                    m3625L(arrayList4);
                    m3653m(false, HttpStatusCodesKt.HTTP_NO_CONTENT, null, null, str, arrayList5);
                    if (m3634U(str, zza.zzc())) {
                        zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent = new Intent();
                        intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent.setPackage(str);
                        Context zzaT = zzioVar.zzaT();
                        if (Build.VERSION.SDK_INT >= 34) {
                            makeBasic = BroadcastOptions.makeBasic();
                            shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
                            bundle = shareIdentityEnabled.toBundle();
                            zzaT.sendBroadcast(intent, null, bundle);
                            return;
                        }
                        zzaT.sendBroadcast(intent);
                        return;
                    }
                    return;
                }
                j2 = j;
                zzhvVar = zzhvVar3;
                if (zzi().zzx(null, zzgi.zzaO)) {
                }
                if (!Log.isLoggable(zzaW().zzr(), 2)) {
                }
                zzA();
                byte[] zzcd2 = zzhvVar.zzcd();
                m3625L(arrayList4);
                this.f14377i.zze.zzb(j2);
                zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd2.length), obj);
                this.f14389u = true;
                zzp().zzc(str, zza, zzhvVar, new jz2(this, str, (Object) arrayList5, 10));
                return;
            }
            return;
        }
        ArrayList arrayList7 = new ArrayList();
        int i8 = 0;
        while (true) {
            long j5 = cursor2.getLong(i2);
            try {
                byte[] blob = cursor2.getBlob(i3);
                zzqa zzA2 = zzj.zzg.zzA();
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException e3) {
                    zzA2.zzu.zzaW().zze().zzb("Failed to ungzip content", e3);
                    throw e3;
                    break;
                }
            } catch (IOException e4) {
                zzj.zzu.zzaW().zze().zzc("Failed to unzip queued bundle. appId", zzhe.zzn(str), e4);
            }
            if (!arrayList7.isEmpty() && byteArray.length + i8 > max) {
                break;
            }
            try {
                com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) zzqa.m3683x(com.google.android.gms.internal.measurement.zzhx.zzz(), byteArray);
                if (!arrayList7.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzhx zzhxVar4 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) arrayList7.get(0)).first;
                    com.google.android.gms.internal.measurement.zzhx zzhxVar5 = (com.google.android.gms.internal.measurement.zzhx) zzhwVar3.zzba();
                    if (!zzhxVar4.zzK().equals(zzhxVar5.zzK()) || !zzhxVar4.zzJ().equals(zzhxVar5.zzJ()) || zzhxVar4.zzbu() != zzhxVar5.zzbu() || !zzhxVar4.zzL().equals(zzhxVar5.zzL())) {
                        break;
                    }
                    Iterator it5 = zzhxVar4.zzY().iterator();
                    while (true) {
                        j3 = -1;
                        if (it5.hasNext()) {
                            com.google.android.gms.internal.measurement.zzio zzioVar2 = (com.google.android.gms.internal.measurement.zzio) it5.next();
                            if ("_npa".equals(zzioVar2.zzg())) {
                                j4 = zzioVar2.zzc();
                                break;
                            }
                        } else {
                            j4 = -1;
                            break;
                        }
                    }
                    Iterator it6 = zzhxVar5.zzY().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzio zzioVar3 = (com.google.android.gms.internal.measurement.zzio) it6.next();
                        if ("_npa".equals(zzioVar3.zzg())) {
                            j3 = zzioVar3.zzc();
                            break;
                        }
                    }
                    if (j4 != j3) {
                        break;
                    }
                }
                if (!cursor2.isNull(2)) {
                    zzhwVar3.zzat(cursor2.getInt(2));
                }
                i8 += byteArray.length;
                arrayList7.add(Pair.create((com.google.android.gms.internal.measurement.zzhx) zzhwVar3.zzba(), Long.valueOf(j5)));
            } catch (IOException e5) {
                zzj.zzu.zzaW().zze().zzc("Failed to merge queued bundle. appId", zzhe.zzn(str), e5);
            }
            if (!cursor2.moveToNext() || i8 > max) {
                break;
            }
            i2 = 0;
            i3 = 1;
        }
        cursor2.close();
        emptyList = arrayList7;
        if (emptyList.isEmpty()) {
        }
    }

    /* renamed from: R */
    public final void m3631R(String str) {
        com.google.android.gms.internal.measurement.zzhv zzg;
        zzaX().zzg();
        m3644d();
        this.f14390v = true;
        try {
            zzio zzioVar = this.f14380l;
            zzioVar.zzaV();
            Boolean bool = zzioVar.zzu().f14339d;
            if (bool == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.f14383o > 0) {
                m3661x();
            } else if (!zzp().zzd()) {
                zzaW().zzj().zza("Network not connected, ignoring upload request");
                m3661x();
            } else if (!zzj().m7872t(str)) {
                zzaW().zzj().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzpz m7850Z = zzj().m7850Z(str);
                if (m7850Z != null && (zzg = m7850Z.zzg()) != null) {
                    zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, m7850Z.zzd(), m7850Z.zzh());
                    byte[] zzcd = zzg.zzcd();
                    if (Log.isLoggable(zzaW().zzr(), 2)) {
                        zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzA().m3695y(zzg));
                    }
                    this.f14389u = true;
                    zzp().zzc(str, m7850Z.zzf(), zzg, new jz2(this, str, (Object) m7850Z, 11));
                }
            }
            this.f14390v = false;
            m3658u();
        } catch (Throwable th) {
            this.f14390v = false;
            m3658u();
            throw th;
        }
    }

    /* renamed from: S */
    public final void m3632S(String str, com.google.android.gms.internal.measurement.zzhp zzhpVar, Bundle bundle, String str2) {
        int max;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (!zzqf.m3699E(zzhpVar.zzl()) && !zzqf.m3699E(str)) {
            zzam zzi = zzi();
            zzi.getClass();
            max = zzi.zzi(str2, zzgi.zzag, 100, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
        } else {
            zzam zzi2 = zzi();
            zzi2.getClass();
            max = Math.max(zzi2.zzi(str2, zzgi.zzag, 100, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR), 256);
        }
        long j = max;
        long codePointCount = zzhpVar.zzm().codePointCount(0, zzhpVar.zzm().length());
        zzqf zzB = zzB();
        String zzl = zzhpVar.zzl();
        zzi();
        String zzG = zzB.zzG(zzl, 40, true);
        if (codePointCount > j && !listOf.contains(zzhpVar.zzl())) {
            if ("_ev".equals(zzhpVar.zzl())) {
                zzqf zzB2 = zzB();
                String zzm = zzhpVar.zzm();
                zzam zzi3 = zzi();
                zzi3.getClass();
                bundle.putString("_ev", zzB2.zzG(zzm, Math.max(zzi3.zzi(str2, zzgi.zzag, 100, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR), 256), true));
                return;
            }
            zzaW().zzl().zzc("Param value is too long; discarded. Name, value length", zzG, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4L);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", zzG);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(zzhpVar.zzl());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:389|(2:391|(10:393|394|395|(1:397)|59|(0)(0)|62|(0)(0)|68|69))|398|399|400|401|402|394|395|(0)|59|(0)(0)|62|(0)(0)|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(71:70|(2:72|(3:74|(1:76)|77))|78|(2:80|(3:82|(1:84)|85))|86|87|(1:89)(1:360)|90|(2:94|(1:96))|97|(2:107|108)|111|(6:112|113|114|115|116|117)|118|(1:120)|121|(2:123|(1:127)(1:126))(1:352)|128|(1:130)|131|(1:133)|134|(1:136)|137|(1:139)|140|(1:142)|143|(1:145)|146|(2:148|(1:150))|151|(2:153|(43:155|(1:159)|160|(1:162)(1:350)|163|(1:165)(15:321|(1:323)(1:349)|324|(1:326)(1:348)|327|(1:329)(1:347)|330|(1:332)(1:346)|333|(1:335)(1:345)|336|(1:338)(1:344)|339|(1:341)(1:343)|342)|166|(1:168)|169|(1:171)(1:320)|(36:175|(4:178|(3:180|181|(3:183|184|(3:186|187|189)(1:310))(1:312))(1:317)|311|176)|318|190|(1:192)|(1:194)|195|196|(1:198)|199|(4:203|(1:205)(1:308)|206|(4:208|(1:210)|211|(3:217|218|(29:220|(1:222)(1:307)|223|(1:225)|226|227|(2:229|(1:231))|232|(3:234|(1:236)|237)(1:306)|238|(1:242)|243|(1:245)|246|(4:249|(2:251|(4:253|(1:255)(1:262)|256|(2:258|259)(1:261))(1:263))(1:264)|260|247)|265|266|267|268|269|(2:270|(2:272|(1:274)(1:290))(3:291|292|(1:296)))|275|276|277|278|(1:280)(2:285|286)|281|282|283))))|309|227|(0)|232|(0)(0)|238|(2:240|242)|243|(0)|246|(1:247)|265|266|267|268|269|(3:270|(0)(0)|290)|275|276|277|278|(0)(0)|281|282|283)|319|(0)|195|196|(0)|199|(5:201|203|(0)(0)|206|(0))|309|227|(0)|232|(0)(0)|238|(0)|243|(0)|246|(1:247)|265|266|267|268|269|(3:270|(0)(0)|290)|275|276|277|278|(0)(0)|281|282|283))|351|166|(0)|169|(0)(0)|(37:173|175|(1:176)|318|190|(0)|(0)|195|196|(0)|199|(0)|309|227|(0)|232|(0)(0)|238|(0)|243|(0)|246|(1:247)|265|266|267|268|269|(3:270|(0)(0)|290)|275|276|277|278|(0)(0)|281|282|283)|319|(0)|195|196|(0)|199|(0)|309|227|(0)|232|(0)(0)|238|(0)|243|(0)|246|(1:247)|265|266|267|268|269|(3:270|(0)(0)|290)|275|276|277|278|(0)(0)|281|282|283) */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0c06, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0c23, code lost:
    
        zzaW().zze().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r3.zzaF()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x02c6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x02c8, code lost:
    
        r9.zzu.zzaW().zze().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r3), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0569 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x05ab A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0675 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0680 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x068b A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0696 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x06a2 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06b3 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x06dd A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06f7 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x07a7 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x07d0 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07db A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0804 A[Catch: all -> 0x01b0, TRY_LEAVE, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0865 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0877 A[Catch: all -> 0x01b0, TRY_ENTER, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0898 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x08a7 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x08be A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x098d A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x09a4 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0a0d A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0a2e A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0a4a A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0b34 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0bd4 A[Catch: all -> 0x01b0, SQLiteException -> 0x0be8, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x0be8, blocks: (B:278:0x0bc3, B:280:0x0bd4), top: B:277:0x0bc3, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0beb  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0b42 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x08ac A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x07d5 A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x062b A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x034e A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x02ff A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03bc A[Catch: all -> 0x01b0, TryCatch #1 {all -> 0x01b0, blocks: (B:45:0x018d, B:48:0x019e, B:50:0x01a6, B:53:0x01b4, B:59:0x033a, B:62:0x0375, B:64:0x03bc, B:66:0x03c3, B:67:0x03da, B:72:0x03e7, B:74:0x03ff, B:76:0x0408, B:77:0x041f, B:80:0x0441, B:84:0x0464, B:85:0x047b, B:86:0x0484, B:89:0x04a1, B:90:0x04ba, B:92:0x04c4, B:94:0x04d2, B:96:0x04d8, B:97:0x04df, B:99:0x04ec, B:101:0x04f4, B:103:0x04fc, B:105:0x0502, B:108:0x0506, B:111:0x0512, B:113:0x051f, B:116:0x0544, B:120:0x0569, B:121:0x057e, B:123:0x05ab, B:126:0x05cb, B:127:0x060d, B:128:0x063b, B:130:0x0675, B:131:0x0678, B:133:0x0680, B:134:0x0683, B:136:0x068b, B:137:0x068e, B:139:0x0696, B:140:0x0699, B:142:0x06a2, B:143:0x06a6, B:145:0x06b3, B:146:0x06b6, B:148:0x06dd, B:150:0x06e5, B:151:0x06e8, B:153:0x06f7, B:155:0x0704, B:159:0x071b, B:163:0x0728, B:166:0x079f, B:168:0x07a7, B:169:0x07aa, B:171:0x07d0, B:173:0x07db, B:175:0x07e4, B:176:0x07fe, B:178:0x0804, B:181:0x0818, B:184:0x0824, B:187:0x0831, B:315:0x084b, B:190:0x085b, B:194:0x0865, B:195:0x0868, B:198:0x0877, B:199:0x087a, B:201:0x0898, B:203:0x089c, B:205:0x08a7, B:206:0x08b4, B:208:0x08be, B:210:0x08c9, B:211:0x08d2, B:213:0x08dc, B:215:0x08e8, B:218:0x08f4, B:220:0x08ff, B:222:0x0914, B:223:0x092c, B:225:0x0937, B:226:0x0940, B:227:0x0953, B:229:0x098d, B:231:0x0997, B:232:0x099a, B:234:0x09a4, B:236:0x09c2, B:237:0x09cd, B:238:0x0a05, B:240:0x0a0d, B:242:0x0a17, B:243:0x0a24, B:245:0x0a2e, B:246:0x0a3b, B:247:0x0a44, B:249:0x0a4a, B:251:0x0a86, B:253:0x0a97, B:256:0x0ab7, B:258:0x0ac6, B:262:0x0aa9, B:266:0x0acd, B:268:0x0b11, B:269:0x0b1c, B:270:0x0b2e, B:272:0x0b34, B:276:0x0b78, B:278:0x0bc3, B:280:0x0bd4, B:281:0x0c38, B:286:0x0bed, B:289:0x0bf0, B:292:0x0b42, B:294:0x0b66, B:300:0x0c0b, B:301:0x0c22, B:305:0x0c23, B:308:0x08ac, B:320:0x07d5, B:321:0x0733, B:324:0x073f, B:327:0x074d, B:330:0x075b, B:333:0x0769, B:336:0x0777, B:339:0x0783, B:342:0x0790, B:352:0x062b, B:356:0x0551, B:361:0x034e, B:362:0x035a, B:364:0x0360, B:367:0x036e, B:372:0x01ce, B:375:0x01dc, B:377:0x01f1, B:382:0x0204, B:385:0x0232, B:387:0x0238, B:389:0x0246, B:391:0x0256, B:393:0x0268, B:395:0x02f5, B:397:0x02ff, B:399:0x029b, B:401:0x02b4, B:402:0x02db, B:406:0x02c8, B:408:0x0210, B:409:0x022e), top: B:44:0x018d, inners: #0, #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03e3  */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3633T(zzbh zzbhVar, zzr zzrVar) {
        boolean z;
        long j;
        String str;
        String str2;
        String str3;
        ai2 ai2Var;
        zzio zzioVar;
        String str4;
        ye3 ye3Var;
        ye3 ye3Var2;
        zzbf zzbfVar;
        long j2;
        long zzH;
        String str5;
        long j3;
        da3 m7875w;
        String str6;
        da3 m4567b;
        String str7;
        com.google.android.gms.internal.measurement.zzhw zzz;
        String str8;
        String str9;
        String str10;
        long j4;
        String str11;
        long j5;
        zzjm zza;
        Map zzd;
        ArrayList arrayList;
        zzjx zzl;
        zzjw zzjwVar;
        String str12;
        zzbc zzbcVar;
        String str13;
        ob3 m7842R;
        int i;
        List m7857e;
        int i2;
        v93 zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        v93 zzj2;
        zzbc zzbcVar2;
        Iterator<String> it;
        ContentValues contentValues;
        long m3691r;
        Pair pair;
        ob3 m7842R2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Object obj;
        ye3 m7852a0;
        Preconditions.checkNotNull(zzrVar);
        String str14 = zzrVar.zza;
        Preconditions.checkNotEmpty(str14);
        long nanoTime = System.nanoTime();
        zzaX().zzg();
        m3644d();
        zzA();
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotNull(zzrVar);
        if (!TextUtils.isEmpty(zzrVar.zzb) || !TextUtils.isEmpty(zzrVar.zzp)) {
            if (!zzrVar.zzh) {
                m3637X(zzrVar);
                return;
            }
            zzif zzr = zzr();
            String str15 = zzbhVar.zza;
            boolean m3550o = zzr.m3550o(str14, str15);
            zzio zzioVar2 = this.f14380l;
            ai2 ai2Var2 = this.f14368J;
            if (m3550o) {
                zzaW().zzk().zzc("Dropping blocked event. appId", zzhe.zzn(str14), zzioVar2.zzj().zzd(str15));
                if (!IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zzr().zza(str14, "measurement.upload.blacklist_internal")) && !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zzr().zza(str14, "measurement.upload.blacklist_public"))) {
                    if (!"_err".equals(str15)) {
                        zzB().getClass();
                        zzqf.m3708m(ai2Var2, str14, 11, "_ev", str15, 0);
                        return;
                    }
                    return;
                }
                ob3 m7842R3 = zzj().m7842R(str14);
                if (m7842R3 != null) {
                    zzio zzioVar3 = m7842R3.f23733a;
                    zzioVar3.zzaX().zzg();
                    long j6 = m7842R3.f23732T;
                    zzioVar3.zzaX().zzg();
                    long abs = Math.abs(zzaU().currentTimeMillis() - Math.max(j6, m7842R3.f23731S));
                    zzi();
                    if (abs > ((Long) zzgi.zzM.zza(null)).longValue()) {
                        zzaW().zzd().zza("Fetching config for blocked app");
                        m3645e(m7842R3);
                        return;
                    }
                    return;
                }
                return;
            }
            zzhf zzb = zzhf.zzb(zzbhVar);
            zzB().m3732l(zzb, zzi().zzf(str14));
            int zzi = zzi().zzi(str14, zzgi.zzaf, 10, 35);
            Bundle bundle = zzb.zzd;
            Iterator it2 = new TreeSet(bundle.keySet()).iterator();
            while (it2.hasNext()) {
                String str16 = (String) it2.next();
                Iterator it3 = it2;
                if (FirebaseAnalytics.Param.ITEMS.equals(str16)) {
                    zzB().m3731k(bundle.getParcelableArray(str16), zzi);
                }
                it2 = it3;
            }
            zzbh zza2 = zzb.zza();
            if (Log.isLoggable(zzaW().zzr(), 2)) {
                zzaW().zzj().zzb("Logging event", zzioVar2.zzj().zzc(zza2));
            }
            zzj().zzH();
            try {
                m3637X(zzrVar);
                String str17 = zza2.zza;
                if ("ecommerce_purchase".equals(str17) || FirebaseAnalytics.Event.PURCHASE.equals(str17) || FirebaseAnalytics.Event.REFUND.equals(str17)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!"_iap".equals(str17)) {
                    if (!z) {
                        str = "events";
                        str2 = "_fx";
                        zzioVar = zzioVar2;
                        str4 = "_err";
                        str3 = str14;
                        ai2Var = ai2Var2;
                        String str18 = zza2.zza;
                        boolean m3700F = zzqf.m3700F(str18);
                        boolean equals = str4.equals(str18);
                        zzB();
                        zzbfVar = zza2.zzb;
                        if (zzbfVar != null) {
                            j2 = 0;
                        } else {
                            Iterator<String> it4 = zzbfVar.f14148a.keySet().iterator();
                            j2 = 0;
                            while (it4.hasNext()) {
                                if (zzbfVar.m3518b(it4.next()) instanceof Parcelable[]) {
                                    j2 += ((Parcelable[]) r12).length;
                                }
                            }
                        }
                        zzas m7846V = zzj().m7846V(m3654n(), str3, j2 + 1, true, m3700F, false, equals, false, false, false);
                        long j7 = m7846V.f14126b;
                        zzi();
                        zzH = j7 - zzam.zzH();
                        if (zzH <= 0) {
                            if (zzH % 1000 == 1) {
                                zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str3), Long.valueOf(m7846V.f14126b));
                            }
                            zzj().m7868p();
                        } else {
                            if (m3700F) {
                                long j8 = m7846V.f14125a;
                                zzi();
                                long intValue = j8 - ((Integer) zzgi.zzm.zza(null)).intValue();
                                if (intValue > 0) {
                                    if (intValue % 1000 == 1) {
                                        zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str3), Long.valueOf(m7846V.f14125a));
                                    }
                                    zzqf zzB = zzB();
                                    String str19 = zza2.zza;
                                    zzB.getClass();
                                    zzqf.m3708m(ai2Var, str3, 16, "_ev", str19, 0);
                                    zzj().m7868p();
                                }
                            }
                            if (equals) {
                                long max = m7846V.f14128d - Math.max(0, Math.min(1000000, zzi().zzh(zzrVar.zza, zzgi.zzl)));
                                if (max > 0) {
                                    if (max == 1) {
                                        zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str3), Long.valueOf(m7846V.f14128d));
                                    }
                                    zzj().m7868p();
                                }
                            }
                            Bundle zzc = zzbfVar.zzc();
                            zzqf zzB2 = zzB();
                            String str20 = zza2.zzc;
                            zzB2.m3733n(zzc, "_o", str20);
                            if (zzB().m3712B(str3, zzrVar.zzD)) {
                                zzB().m3733n(zzc, "_dbg", 1L);
                                zzB().m3733n(zzc, "_r", 1L);
                            }
                            if ("_s".equals(str18) && (m7852a0 = zzj().m7852a0(zzrVar.zza, "_sno")) != null) {
                                Object obj2 = m7852a0.f28932e;
                                if (obj2 instanceof Long) {
                                    zzB().m3733n(zzc, "_sno", obj2);
                                }
                            }
                            if (zzi().zzx(null, zzgi.zzbg) && Objects.equals(str20, "am") && str18.equals("_ai") && (obj = zzc.get("value")) != null && (obj instanceof String)) {
                                try {
                                    double parseDouble = Double.parseDouble((String) obj);
                                    zzc.remove("value");
                                    zzc.putDouble("value", parseDouble);
                                } catch (NumberFormatException unused) {
                                }
                            }
                            v93 zzj3 = zzj();
                            Preconditions.checkNotEmpty(str3);
                            zzj3.zzg();
                            zzj3.zzav();
                            try {
                                str5 = "raw_events";
                                try {
                                    j3 = zzj3.m7841Q().delete(str5, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str3, String.valueOf(Math.max(0, Math.min(1000000, zzj3.zzu.zzf().zzh(str3, zzgi.zzp))))});
                                } catch (SQLiteException e) {
                                    e = e;
                                    zzj3.zzu.zzaW().zze().zzc("Error deleting over the limit events. appId", zzhe.zzn(str3), e);
                                    j3 = 0;
                                    if (j3 > 0) {
                                    }
                                    zzio zzioVar4 = this.f14380l;
                                    String str21 = zza2.zzc;
                                    String str22 = zza2.zza;
                                    long j9 = zza2.zzd;
                                    String str23 = str5;
                                    zzbc zzbcVar3 = new zzbc(zzioVar4, str21, str3, str22, j9, 0L, zzc);
                                    v93 zzj4 = zzj();
                                    String str24 = zzbcVar3.f14143b;
                                    String str25 = str;
                                    m7875w = zzj4.m7875w(str25, str3, str24);
                                    if (m7875w != null) {
                                    }
                                    zzj().m7828B(str6, m4567b);
                                    zzaX().zzg();
                                    m3644d();
                                    Preconditions.checkNotNull(zzbcVar3);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str26 = zzbcVar3.f14142a;
                                    Preconditions.checkNotEmpty(str26);
                                    str7 = zzrVar.zza;
                                    Preconditions.checkArgument(str26.equals(str7));
                                    zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                    boolean z9 = true;
                                    zzz.zzar(1);
                                    zzz.zzan("android");
                                    if (!TextUtils.isEmpty(str7)) {
                                    }
                                    str8 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str8)) {
                                    }
                                    str9 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str9)) {
                                    }
                                    str10 = zzrVar.zzw;
                                    if (!TextUtils.isEmpty(str10)) {
                                    }
                                    j4 = zzrVar.zzj;
                                    if (j4 != -2147483648L) {
                                    }
                                    zzz.zzai(zzrVar.zze);
                                    str11 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str11)) {
                                    }
                                    zzjx zzl2 = m3641a0((String) Preconditions.checkNotNull(str7)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzz.zzT(zzl2.zzp());
                                    if (zzz.zzaJ().isEmpty()) {
                                    }
                                    zzqr.zzb();
                                    if (zzi().zzx(str7, zzgi.zzaV)) {
                                    }
                                    j5 = zzrVar.zzf;
                                    if (j5 != 0) {
                                    }
                                    zzz.zzZ(zzrVar.zzr);
                                    zzqa zzA = zzA();
                                    zza = zzjm.zza(zzA.zzg.f14380l.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.google.android.gms.internal.measurement.zzki.zzc();
                                        }
                                    });
                                    if (zza == null) {
                                    }
                                    if (zzd != null) {
                                    }
                                    arrayList = null;
                                    if (arrayList != null) {
                                    }
                                    if (zzi().zzx(null, zzgi.zzbk)) {
                                    }
                                    String str27 = zzrVar.zza;
                                    zzl = m3641a0((String) Preconditions.checkNotNull(str27)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzjwVar = zzjw.AD_STORAGE;
                                    if (zzl.zzr(zzjwVar)) {
                                    }
                                    str12 = str23;
                                    zzbcVar = zzbcVar3;
                                    str13 = "_r";
                                    zzioVar.zzg().zzv();
                                    zzz.zzX(Build.MODEL);
                                    zzioVar.zzg().zzv();
                                    zzz.zzam(Build.VERSION.RELEASE);
                                    zzz.zzaz((int) zzioVar.zzg().zza());
                                    zzz.zzaD(zzioVar.zzg().zzb());
                                    zzz.zzay(zzrVar.zzy);
                                    if (zzioVar.zzJ()) {
                                    }
                                    m7842R = zzj().m7842R(str27);
                                    if (m7842R != null) {
                                    }
                                    if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    }
                                    if (!TextUtils.isEmpty(m7842R.m6539f())) {
                                    }
                                    m7857e = zzj().m7857e(str27);
                                    while (i2 < m7857e.size()) {
                                    }
                                    zzj = zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                    zzj.zzg();
                                    zzj.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    byte[] zzcd = zzhxVar.zzcd();
                                    long m3691r2 = zzj.zzg.zzA().m3691r(zzcd);
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put("app_id", zzhxVar.zzF());
                                    contentValues2.put("metadata_fingerprint", Long.valueOf(m3691r2));
                                    contentValues2.put("metadata", zzcd);
                                    zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                    zzj2 = zzj();
                                    zzbcVar2 = zzbcVar;
                                    it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                        }
                                    }
                                    i = 1;
                                    zzj2.zzg();
                                    zzj2.zzav();
                                    Preconditions.checkNotNull(zzbcVar2);
                                    String str28 = zzbcVar2.f14142a;
                                    Preconditions.checkNotEmpty(str28);
                                    byte[] zzcd2 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put("app_id", str28);
                                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(m3691r2));
                                    contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd2);
                                    contentValues.put("realtime", Integer.valueOf(i));
                                    try {
                                        if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                        }
                                    } catch (SQLiteException e2) {
                                        zzj2.zzu.zzaW().zze().zzc("Error storing raw event. appId", zzhe.zzn(zzbcVar2.f14142a), e2);
                                    }
                                    zzj().m7868p();
                                    zzj().m7863k();
                                    m3661x();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                str5 = "raw_events";
                            }
                            if (j3 > 0) {
                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str3), Long.valueOf(j3));
                            }
                            zzio zzioVar42 = this.f14380l;
                            String str212 = zza2.zzc;
                            String str222 = zza2.zza;
                            long j92 = zza2.zzd;
                            String str232 = str5;
                            zzbc zzbcVar32 = new zzbc(zzioVar42, str212, str3, str222, j92, 0L, zzc);
                            v93 zzj42 = zzj();
                            String str242 = zzbcVar32.f14143b;
                            String str252 = str;
                            m7875w = zzj42.m7875w(str252, str3, str242);
                            if (m7875w != null) {
                                long m7840P = zzj().m7840P(str3);
                                zzi().getClass();
                                zzgg zzggVar = zzgi.zzV;
                                if (m7840P >= r6.zzi(str3, zzggVar, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 2000) && m3700F) {
                                    zzhc zze = zzaW().zze();
                                    Object zzn = zzhe.zzn(str3);
                                    String zzd2 = zzioVar42.zzj().zzd(str242);
                                    zzam zzi2 = zzi();
                                    zzi2.getClass();
                                    zze.zzd("Too many event names used, ignoring event. appId, name, supported count", zzn, zzd2, Integer.valueOf(zzi2.zzi(str3, zzggVar, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 2000)));
                                    zzB().getClass();
                                    zzqf.m3708m(ai2Var, str3, 8, null, null, 0);
                                } else {
                                    str6 = str252;
                                    m4567b = new da3(str3, str242, 0L, 0L, 0L, zzbcVar32.f14145d, 0L, null, null, null, null);
                                }
                            } else {
                                str6 = str252;
                                zzbcVar32 = zzbcVar32.m3516a(zzioVar42, m7875w.f16319f);
                                m4567b = m7875w.m4567b(zzbcVar32.f14145d);
                            }
                            zzj().m7828B(str6, m4567b);
                            zzaX().zzg();
                            m3644d();
                            Preconditions.checkNotNull(zzbcVar32);
                            Preconditions.checkNotNull(zzrVar);
                            String str262 = zzbcVar32.f14142a;
                            Preconditions.checkNotEmpty(str262);
                            str7 = zzrVar.zza;
                            Preconditions.checkArgument(str262.equals(str7));
                            zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                            boolean z92 = true;
                            zzz.zzar(1);
                            zzz.zzan("android");
                            if (!TextUtils.isEmpty(str7)) {
                                zzz.zzI(str7);
                            }
                            str8 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str8)) {
                                zzz.zzK(str8);
                            }
                            str9 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str9)) {
                                zzz.zzL(str9);
                            }
                            str10 = zzrVar.zzw;
                            if (!TextUtils.isEmpty(str10)) {
                                zzz.zzav(str10);
                            }
                            j4 = zzrVar.zzj;
                            if (j4 != -2147483648L) {
                                zzz.zzM((int) j4);
                            }
                            zzz.zzai(zzrVar.zze);
                            str11 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str11)) {
                                zzz.zzah(str11);
                            }
                            zzjx zzl22 = m3641a0((String) Preconditions.checkNotNull(str7)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzz.zzT(zzl22.zzp());
                            if (zzz.zzaJ().isEmpty()) {
                                String str29 = zzrVar.zzp;
                                if (!TextUtils.isEmpty(str29)) {
                                    zzz.zzH(str29);
                                }
                            }
                            zzqr.zzb();
                            try {
                                if (zzi().zzx(str7, zzgi.zzaV)) {
                                    zzB().getClass();
                                    if (zzqf.m3710t(str7)) {
                                        zzz.zzG(zzrVar.zzB);
                                        long j10 = zzrVar.zzC;
                                        if (!zzl22.zzr(zzjw.AD_STORAGE) && j10 != 0) {
                                            j10 = (j10 & (-2)) | 32;
                                        }
                                        if (j10 == 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        zzz.zzaa(z2);
                                        if (j10 != 0) {
                                            com.google.android.gms.internal.measurement.zzhf zza3 = zzhg.zza();
                                            if ((j10 & 1) == 0) {
                                                z92 = false;
                                            }
                                            zza3.zzc(z92);
                                            if ((j10 & 2) != 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            zza3.zze(z3);
                                            if ((j10 & 4) != 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            zza3.zzf(z4);
                                            if ((j10 & 8) != 0) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            zza3.zzg(z5);
                                            if ((j10 & 16) != 0) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            zza3.zzb(z6);
                                            if ((j10 & 32) != 0) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            zza3.zza(z7);
                                            if ((64 & j10) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            zza3.zzd(z8);
                                            zzz.zzN((zzhg) zza3.zzba());
                                        }
                                        j5 = zzrVar.zzf;
                                        if (j5 != 0) {
                                            zzz.zzW(j5);
                                        }
                                        zzz.zzZ(zzrVar.zzr);
                                        zzqa zzA2 = zzA();
                                        zza = zzjm.zza(zzA2.zzg.f14380l.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.gms.internal.measurement.zzki.zzc();
                                            }
                                        });
                                        if (zza == null) {
                                            zzd = Collections.emptyMap();
                                        } else {
                                            zzd = zza.zzd();
                                        }
                                        if (zzd != null && !zzd.isEmpty()) {
                                            arrayList = new ArrayList();
                                            int intValue2 = ((Integer) zzgi.zzae.zza(null)).intValue();
                                            for (Map.Entry entry : zzd.entrySet()) {
                                                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                                    try {
                                                        int parseInt = Integer.parseInt((String) entry.getValue());
                                                        if (parseInt != 0) {
                                                            arrayList.add(Integer.valueOf(parseInt));
                                                            if (arrayList.size() >= intValue2) {
                                                                zzA2.zzu.zzaW().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                                break;
                                                            }
                                                            continue;
                                                        } else {
                                                            continue;
                                                        }
                                                    } catch (NumberFormatException e4) {
                                                        zzA2.zzu.zzaW().zzk().zzb("Experiment ID NumberFormatException", e4);
                                                    }
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                            }
                                            if (arrayList != null) {
                                                zzz.zzk(arrayList);
                                            }
                                            if (zzi().zzx(null, zzgi.zzbk)) {
                                                zzz.zzaf("");
                                            }
                                            String str272 = zzrVar.zza;
                                            zzl = m3641a0((String) Preconditions.checkNotNull(str272)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzjwVar = zzjw.AD_STORAGE;
                                            if (zzl.zzr(zzjwVar) && zzrVar.zzn) {
                                                zzoa zzoaVar = this.f14377i;
                                                zzoaVar.getClass();
                                                if (!zzl.zzr(zzjwVar)) {
                                                    pair = zzoaVar.m3592a(str272);
                                                } else {
                                                    pair = new Pair("", Boolean.FALSE);
                                                }
                                                if (!TextUtils.isEmpty((CharSequence) pair.first)) {
                                                    zzz.zzas((String) pair.first);
                                                    Object obj3 = pair.second;
                                                    if (obj3 != null) {
                                                        zzz.zzal(((Boolean) obj3).booleanValue());
                                                    }
                                                    String str30 = str2;
                                                    if (!zzbcVar32.f14143b.equals(str30) && !((String) pair.first).equals("00000000-0000-0000-0000-000000000000") && (m7842R2 = zzj().m7842R(str272)) != null) {
                                                        zzio zzioVar5 = m7842R2.f23733a;
                                                        zzioVar5.zzaX().zzg();
                                                        if (m7842R2.f23758z) {
                                                            m3627N(str272, false, null, null);
                                                            Bundle bundle2 = new Bundle();
                                                            zzioVar5.zzaX().zzg();
                                                            Long l = m7842R2.f23713A;
                                                            if (l != null) {
                                                                str12 = str232;
                                                                zzbcVar = zzbcVar32;
                                                                bundle2.putLong("_pfo", Math.max(0L, l.longValue()));
                                                            } else {
                                                                str12 = str232;
                                                                zzbcVar = zzbcVar32;
                                                            }
                                                            zzioVar5.zzaX().zzg();
                                                            Long l2 = m7842R2.f23714B;
                                                            if (l2 != null) {
                                                                bundle2.putLong("_uwa", l2.longValue());
                                                            }
                                                            str13 = "_r";
                                                            bundle2.putLong(str13, 1L);
                                                            ai2Var.m98h(str272, str30, bundle2);
                                                            zzioVar.zzg().zzv();
                                                            zzz.zzX(Build.MODEL);
                                                            zzioVar.zzg().zzv();
                                                            zzz.zzam(Build.VERSION.RELEASE);
                                                            zzz.zzaz((int) zzioVar.zzg().zza());
                                                            zzz.zzaD(zzioVar.zzg().zzb());
                                                            zzz.zzay(zzrVar.zzy);
                                                            if (zzioVar.zzJ()) {
                                                                zzz.zzaF();
                                                                if (!TextUtils.isEmpty(null)) {
                                                                    zzz.zzY(null);
                                                                }
                                                            }
                                                            m7842R = zzj().m7842R(str272);
                                                            if (m7842R != null) {
                                                                m7842R = new ob3(zzioVar, str272);
                                                                m7842R.m6544k(m3640a(zzl));
                                                                m7842R.m6555v(zzrVar.zzk);
                                                                m7842R.m6556w(zzrVar.zzb);
                                                                if (zzl.zzr(zzjwVar)) {
                                                                    m7842R.m6530D(this.f14377i.m3593b(str272, zzrVar.zzn));
                                                                }
                                                                m7842R.m6527A(0L);
                                                                m7842R.m6528B(0L);
                                                                m7842R.m6559z(0L);
                                                                m7842R.m6546m(zzrVar.zzc);
                                                                m7842R.m6547n(zzrVar.zzj);
                                                                m7842R.m6545l(zzrVar.zzd);
                                                                m7842R.m6557x(zzrVar.zze);
                                                                m7842R.m6552s(zzrVar.zzf);
                                                                m7842R.m6529C(zzrVar.zzh);
                                                                m7842R.m6554u(zzrVar.zzr);
                                                                i = 0;
                                                                zzj().m7869q(m7842R, false);
                                                            } else {
                                                                i = 0;
                                                            }
                                                            if (zzl.zzr(zzjw.ANALYTICS_STORAGE) && !TextUtils.isEmpty(m7842R.m6537d())) {
                                                                zzz.zzJ((String) Preconditions.checkNotNull(m7842R.m6537d()));
                                                            }
                                                            if (!TextUtils.isEmpty(m7842R.m6539f())) {
                                                                zzz.zzag((String) Preconditions.checkNotNull(m7842R.m6539f()));
                                                            }
                                                            m7857e = zzj().m7857e(str272);
                                                            for (i2 = i; i2 < m7857e.size(); i2++) {
                                                                zzin zze2 = com.google.android.gms.internal.measurement.zzio.zze();
                                                                zze2.zzf(((ye3) m7857e.get(i2)).f28930c);
                                                                zze2.zzg(((ye3) m7857e.get(i2)).f28931d);
                                                                zzA().m3686E(zze2, ((ye3) m7857e.get(i2)).f28932e);
                                                                zzz.zzo(zze2);
                                                                if ("_sid".equals(((ye3) m7857e.get(i2)).f28930c)) {
                                                                    m7842R.f23733a.zzaX().zzg();
                                                                    if (m7842R.f23756x != 0) {
                                                                        zzqa zzA3 = zzA();
                                                                        String str31 = zzrVar.zzw;
                                                                        zzA3.getClass();
                                                                        if (TextUtils.isEmpty(str31)) {
                                                                            m3691r = 0;
                                                                        } else {
                                                                            m3691r = zzA3.m3691r(str31.getBytes(Charset.forName("UTF-8")));
                                                                        }
                                                                        m7842R.f23733a.zzaX().zzg();
                                                                        if (m3691r != m7842R.f23756x) {
                                                                            zzz.zzA();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            zzj = zzj();
                                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                                            zzj.zzg();
                                                            zzj.zzav();
                                                            Preconditions.checkNotNull(zzhxVar);
                                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                            byte[] zzcd3 = zzhxVar.zzcd();
                                                            long m3691r22 = zzj.zzg.zzA().m3691r(zzcd3);
                                                            ContentValues contentValues22 = new ContentValues();
                                                            contentValues22.put("app_id", zzhxVar.zzF());
                                                            contentValues22.put("metadata_fingerprint", Long.valueOf(m3691r22));
                                                            contentValues22.put("metadata", zzcd3);
                                                            zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                                                            zzj2 = zzj();
                                                            zzbcVar2 = zzbcVar;
                                                            it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    if (str13.equals(it.next())) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    zzif zzr2 = zzr();
                                                                    String str32 = zzbcVar2.f14142a;
                                                                    boolean m3549n = zzr2.m3549n(str32, zzbcVar2.f14143b);
                                                                    zzas m7845U = zzj().m7845U(m3654n(), str32, false, false, false, false);
                                                                    if (m3549n && m7845U.f14129e < zzi().zzh(str32, zzgi.zzo)) {
                                                                    }
                                                                }
                                                            }
                                                            i = 1;
                                                            zzj2.zzg();
                                                            zzj2.zzav();
                                                            Preconditions.checkNotNull(zzbcVar2);
                                                            String str282 = zzbcVar2.f14142a;
                                                            Preconditions.checkNotEmpty(str282);
                                                            byte[] zzcd22 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                                            contentValues = new ContentValues();
                                                            contentValues.put("app_id", str282);
                                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                                            contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                                            contentValues.put("metadata_fingerprint", Long.valueOf(m3691r22));
                                                            contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd22);
                                                            contentValues.put("realtime", Integer.valueOf(i));
                                                            if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                                                zzj2.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str282));
                                                            } else {
                                                                this.f14383o = 0L;
                                                            }
                                                            zzj().m7868p();
                                                            zzj().m7863k();
                                                            m3661x();
                                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                            str12 = str232;
                                            zzbcVar = zzbcVar32;
                                            str13 = "_r";
                                            zzioVar.zzg().zzv();
                                            zzz.zzX(Build.MODEL);
                                            zzioVar.zzg().zzv();
                                            zzz.zzam(Build.VERSION.RELEASE);
                                            zzz.zzaz((int) zzioVar.zzg().zza());
                                            zzz.zzaD(zzioVar.zzg().zzb());
                                            zzz.zzay(zzrVar.zzy);
                                            if (zzioVar.zzJ()) {
                                            }
                                            m7842R = zzj().m7842R(str272);
                                            if (m7842R != null) {
                                            }
                                            if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                zzz.zzJ((String) Preconditions.checkNotNull(m7842R.m6537d()));
                                            }
                                            if (!TextUtils.isEmpty(m7842R.m6539f())) {
                                            }
                                            m7857e = zzj().m7857e(str272);
                                            while (i2 < m7857e.size()) {
                                            }
                                            zzj = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                            zzj.zzg();
                                            zzj.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] zzcd32 = zzhxVar.zzcd();
                                            long m3691r222 = zzj.zzg.zzA().m3691r(zzcd32);
                                            ContentValues contentValues222 = new ContentValues();
                                            contentValues222.put("app_id", zzhxVar.zzF());
                                            contentValues222.put("metadata_fingerprint", Long.valueOf(m3691r222));
                                            contentValues222.put("metadata", zzcd32);
                                            zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues222, 4);
                                            zzj2 = zzj();
                                            zzbcVar2 = zzbcVar;
                                            it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                }
                                            }
                                            i = 1;
                                            zzj2.zzg();
                                            zzj2.zzav();
                                            Preconditions.checkNotNull(zzbcVar2);
                                            String str2822 = zzbcVar2.f14142a;
                                            Preconditions.checkNotEmpty(str2822);
                                            byte[] zzcd222 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                            contentValues = new ContentValues();
                                            contentValues.put("app_id", str2822);
                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                            contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(m3691r222));
                                            contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd222);
                                            contentValues.put("realtime", Integer.valueOf(i));
                                            if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                            }
                                            zzj().m7868p();
                                            zzj().m7863k();
                                            m3661x();
                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        arrayList = null;
                                        if (arrayList != null) {
                                        }
                                        if (zzi().zzx(null, zzgi.zzbk)) {
                                        }
                                        String str2722 = zzrVar.zza;
                                        zzl = m3641a0((String) Preconditions.checkNotNull(str2722)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzjwVar = zzjw.AD_STORAGE;
                                        if (zzl.zzr(zzjwVar)) {
                                            zzoa zzoaVar2 = this.f14377i;
                                            zzoaVar2.getClass();
                                            if (!zzl.zzr(zzjwVar)) {
                                            }
                                            if (!TextUtils.isEmpty((CharSequence) pair.first)) {
                                            }
                                        }
                                        str12 = str232;
                                        zzbcVar = zzbcVar32;
                                        str13 = "_r";
                                        zzioVar.zzg().zzv();
                                        zzz.zzX(Build.MODEL);
                                        zzioVar.zzg().zzv();
                                        zzz.zzam(Build.VERSION.RELEASE);
                                        zzz.zzaz((int) zzioVar.zzg().zza());
                                        zzz.zzaD(zzioVar.zzg().zzb());
                                        zzz.zzay(zzrVar.zzy);
                                        if (zzioVar.zzJ()) {
                                        }
                                        m7842R = zzj().m7842R(str2722);
                                        if (m7842R != null) {
                                        }
                                        if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                        }
                                        if (!TextUtils.isEmpty(m7842R.m6539f())) {
                                        }
                                        m7857e = zzj().m7857e(str2722);
                                        while (i2 < m7857e.size()) {
                                        }
                                        zzj = zzj();
                                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                        zzj.zzg();
                                        zzj.zzav();
                                        Preconditions.checkNotNull(zzhxVar);
                                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                                        byte[] zzcd322 = zzhxVar.zzcd();
                                        long m3691r2222 = zzj.zzg.zzA().m3691r(zzcd322);
                                        ContentValues contentValues2222 = new ContentValues();
                                        contentValues2222.put("app_id", zzhxVar.zzF());
                                        contentValues2222.put("metadata_fingerprint", Long.valueOf(m3691r2222));
                                        contentValues2222.put("metadata", zzcd322);
                                        zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues2222, 4);
                                        zzj2 = zzj();
                                        zzbcVar2 = zzbcVar;
                                        it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                            }
                                        }
                                        i = 1;
                                        zzj2.zzg();
                                        zzj2.zzav();
                                        Preconditions.checkNotNull(zzbcVar2);
                                        String str28222 = zzbcVar2.f14142a;
                                        Preconditions.checkNotEmpty(str28222);
                                        byte[] zzcd2222 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                        contentValues = new ContentValues();
                                        contentValues.put("app_id", str28222);
                                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                        contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(m3691r2222));
                                        contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd2222);
                                        contentValues.put("realtime", Integer.valueOf(i));
                                        if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                        }
                                        zzj().m7868p();
                                        zzj().m7863k();
                                        m3661x();
                                        zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                }
                                if (zzd != null) {
                                    arrayList = new ArrayList();
                                    int intValue22 = ((Integer) zzgi.zzae.zza(null)).intValue();
                                    while (r7.hasNext()) {
                                    }
                                    if (arrayList.isEmpty()) {
                                    }
                                    if (arrayList != null) {
                                    }
                                    if (zzi().zzx(null, zzgi.zzbk)) {
                                    }
                                    String str27222 = zzrVar.zza;
                                    zzl = m3641a0((String) Preconditions.checkNotNull(str27222)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzjwVar = zzjw.AD_STORAGE;
                                    if (zzl.zzr(zzjwVar)) {
                                    }
                                    str12 = str232;
                                    zzbcVar = zzbcVar32;
                                    str13 = "_r";
                                    zzioVar.zzg().zzv();
                                    zzz.zzX(Build.MODEL);
                                    zzioVar.zzg().zzv();
                                    zzz.zzam(Build.VERSION.RELEASE);
                                    zzz.zzaz((int) zzioVar.zzg().zza());
                                    zzz.zzaD(zzioVar.zzg().zzb());
                                    zzz.zzay(zzrVar.zzy);
                                    if (zzioVar.zzJ()) {
                                    }
                                    m7842R = zzj().m7842R(str27222);
                                    if (m7842R != null) {
                                    }
                                    if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    }
                                    if (!TextUtils.isEmpty(m7842R.m6539f())) {
                                    }
                                    m7857e = zzj().m7857e(str27222);
                                    while (i2 < m7857e.size()) {
                                    }
                                    zzj = zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                    zzj.zzg();
                                    zzj.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    byte[] zzcd3222 = zzhxVar.zzcd();
                                    long m3691r22222 = zzj.zzg.zzA().m3691r(zzcd3222);
                                    ContentValues contentValues22222 = new ContentValues();
                                    contentValues22222.put("app_id", zzhxVar.zzF());
                                    contentValues22222.put("metadata_fingerprint", Long.valueOf(m3691r22222));
                                    contentValues22222.put("metadata", zzcd3222);
                                    zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues22222, 4);
                                    zzj2 = zzj();
                                    zzbcVar2 = zzbcVar;
                                    it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                        }
                                    }
                                    i = 1;
                                    zzj2.zzg();
                                    zzj2.zzav();
                                    Preconditions.checkNotNull(zzbcVar2);
                                    String str282222 = zzbcVar2.f14142a;
                                    Preconditions.checkNotEmpty(str282222);
                                    byte[] zzcd22222 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put("app_id", str282222);
                                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(m3691r22222));
                                    contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd22222);
                                    contentValues.put("realtime", Integer.valueOf(i));
                                    if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                    }
                                    zzj().m7868p();
                                    zzj().m7863k();
                                    m3661x();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                }
                                zzj.m7841Q().insertWithOnConflict("raw_events_metadata", null, contentValues22222, 4);
                                zzj2 = zzj();
                                zzbcVar2 = zzbcVar;
                                it = zzbcVar2.f14147f.f14148a.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                    }
                                }
                                i = 1;
                                zzj2.zzg();
                                zzj2.zzav();
                                Preconditions.checkNotNull(zzbcVar2);
                                String str2822222 = zzbcVar2.f14142a;
                                Preconditions.checkNotEmpty(str2822222);
                                byte[] zzcd222222 = zzj2.zzg.zzA().m3694w(zzbcVar2).zzcd();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", str2822222);
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar2.f14143b);
                                contentValues.put("timestamp", Long.valueOf(zzbcVar2.f14145d));
                                contentValues.put("metadata_fingerprint", Long.valueOf(m3691r22222));
                                contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd222222);
                                contentValues.put("realtime", Integer.valueOf(i));
                                if (zzj2.m7841Q().insert(str12, null, contentValues) != -1) {
                                }
                                zzj().m7868p();
                                zzj().m7863k();
                                m3661x();
                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                return;
                            } catch (SQLiteException e5) {
                                zzj.zzu.zzaW().zze().zzc("Error storing raw event metadata. appId", zzhe.zzn(zzhxVar.zzF()), e5);
                                throw e5;
                            }
                            j5 = zzrVar.zzf;
                            if (j5 != 0) {
                            }
                            zzz.zzZ(zzrVar.zzr);
                            zzqa zzA22 = zzA();
                            zza = zzjm.zza(zzA22.zzg.f14380l.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                }
                            });
                            if (zza == null) {
                            }
                            arrayList = null;
                            if (arrayList != null) {
                            }
                            if (zzi().zzx(null, zzgi.zzbk)) {
                            }
                            String str272222 = zzrVar.zza;
                            zzl = m3641a0((String) Preconditions.checkNotNull(str272222)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzjwVar = zzjw.AD_STORAGE;
                            if (zzl.zzr(zzjwVar)) {
                            }
                            str12 = str232;
                            zzbcVar = zzbcVar32;
                            str13 = "_r";
                            zzioVar.zzg().zzv();
                            zzz.zzX(Build.MODEL);
                            zzioVar.zzg().zzv();
                            zzz.zzam(Build.VERSION.RELEASE);
                            zzz.zzaz((int) zzioVar.zzg().zza());
                            zzz.zzaD(zzioVar.zzg().zzb());
                            zzz.zzay(zzrVar.zzy);
                            if (zzioVar.zzJ()) {
                            }
                            m7842R = zzj().m7842R(str272222);
                            if (m7842R != null) {
                            }
                            if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                            }
                            if (!TextUtils.isEmpty(m7842R.m6539f())) {
                            }
                            m7857e = zzj().m7857e(str272222);
                            while (i2 < m7857e.size()) {
                            }
                            zzj = zzj();
                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                            zzj.zzg();
                            zzj.zzav();
                            Preconditions.checkNotNull(zzhxVar);
                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                            byte[] zzcd32222 = zzhxVar.zzcd();
                            long m3691r222222 = zzj.zzg.zzA().m3691r(zzcd32222);
                            ContentValues contentValues222222 = new ContentValues();
                            contentValues222222.put("app_id", zzhxVar.zzF());
                            contentValues222222.put("metadata_fingerprint", Long.valueOf(m3691r222222));
                            contentValues222222.put("metadata", zzcd32222);
                        }
                        zzj().m7863k();
                    }
                    z = true;
                }
                zzbf zzbfVar2 = zza2.zzb;
                String m3519c = zzbfVar2.m3519c();
                Bundle bundle3 = zzbfVar2.f14148a;
                if (z) {
                    double doubleValue = zzbfVar2.m3517a().doubleValue() * 1000000.0d;
                    if (doubleValue == 0.0d) {
                        doubleValue = bundle3.getLong("value") * 1000000.0d;
                    }
                    if (doubleValue <= 9.223372036854776E18d && doubleValue >= -9.223372036854776E18d) {
                        j = Math.round(doubleValue);
                        if (FirebaseAnalytics.Event.REFUND.equals(str17)) {
                            j = -j;
                        }
                    } else {
                        zzaW().zzk().zzc("Data lost. Currency value is too big. appId", zzhe.zzn(str14), Double.valueOf(doubleValue));
                        zzj().m7868p();
                        zzj().m7863k();
                    }
                } else {
                    j = bundle3.getLong("value");
                }
                if (!TextUtils.isEmpty(m3519c)) {
                    String upperCase = m3519c.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        String concat = "_ltv_".concat(upperCase);
                        ye3 m7852a02 = zzj().m7852a0(str14, concat);
                        if (m7852a02 != null) {
                            Object obj4 = m7852a02.f28932e;
                            if (obj4 instanceof Long) {
                                str2 = "_fx";
                                ai2Var = ai2Var2;
                                zzioVar = zzioVar2;
                                str4 = "_err";
                                str = "events";
                                str3 = str14;
                                ye3Var = new ye3(str14, zza2.zzc, concat, zzaU().currentTimeMillis(), Long.valueOf(((Long) obj4).longValue() + j));
                                ye3Var2 = ye3Var;
                                if (!zzj().m7834I(ye3Var2)) {
                                    zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str3), zzioVar.zzj().zzf(ye3Var2.f28930c), ye3Var2.f28932e);
                                    zzB().getClass();
                                    zzqf.m3708m(ai2Var, str3, 9, null, null, 0);
                                }
                                String str182 = zza2.zza;
                                boolean m3700F2 = zzqf.m3700F(str182);
                                boolean equals2 = str4.equals(str182);
                                zzB();
                                zzbfVar = zza2.zzb;
                                if (zzbfVar != null) {
                                }
                                zzas m7846V2 = zzj().m7846V(m3654n(), str3, j2 + 1, true, m3700F2, false, equals2, false, false, false);
                                long j72 = m7846V2.f14126b;
                                zzi();
                                zzH = j72 - zzam.zzH();
                                if (zzH <= 0) {
                                }
                                zzj().m7863k();
                            }
                        }
                        str = "events";
                        str2 = "_fx";
                        str3 = str14;
                        ai2Var = ai2Var2;
                        zzioVar = zzioVar2;
                        str4 = "_err";
                        v93 zzj5 = zzj();
                        int zzh = zzi().zzh(str3, zzgi.zzS) - 1;
                        Preconditions.checkNotEmpty(str3);
                        zzj5.zzg();
                        zzj5.zzav();
                        zzj5.m7841Q().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str3, str3, String.valueOf(zzh)});
                        ye3Var = new ye3(str3, zza2.zzc, concat, zzaU().currentTimeMillis(), Long.valueOf(j));
                        ye3Var2 = ye3Var;
                        if (!zzj().m7834I(ye3Var2)) {
                        }
                        String str1822 = zza2.zza;
                        boolean m3700F22 = zzqf.m3700F(str1822);
                        boolean equals22 = str4.equals(str1822);
                        zzB();
                        zzbfVar = zza2.zzb;
                        if (zzbfVar != null) {
                        }
                        zzas m7846V22 = zzj().m7846V(m3654n(), str3, j2 + 1, true, m3700F22, false, equals22, false, false, false);
                        long j722 = m7846V22.f14126b;
                        zzi();
                        zzH = j722 - zzam.zzH();
                        if (zzH <= 0) {
                        }
                        zzj().m7863k();
                    }
                }
                str = "events";
                str2 = "_fx";
                str3 = str14;
                ai2Var = ai2Var2;
                zzioVar = zzioVar2;
                str4 = "_err";
                String str18222 = zza2.zza;
                boolean m3700F222 = zzqf.m3700F(str18222);
                boolean equals222 = str4.equals(str18222);
                zzB();
                zzbfVar = zza2.zzb;
                if (zzbfVar != null) {
                }
                zzas m7846V222 = zzj().m7846V(m3654n(), str3, j2 + 1, true, m3700F222, false, equals222, false, false, false);
                long j7222 = m7846V222.f14126b;
                zzi();
                zzH = j7222 - zzam.zzH();
                if (zzH <= 0) {
                }
                zzj().m7863k();
            } catch (Throwable th) {
                zzj().m7863k();
                throw th;
            }
        }
    }

    /* renamed from: U */
    public final boolean m3634U(String str, String str2) {
        ob3 m7842R = zzj().m7842R(str);
        HashMap hashMap = this.f14363E;
        if (m7842R != null && zzB().m3712B(str, m7842R.m6541h())) {
            hashMap.remove(str2);
            return true;
        }
        ue3 ue3Var = (ue3) hashMap.get(str2);
        if (ue3Var == null || ue3Var.f27242a.zzaU().currentTimeMillis() >= ue3Var.f27244c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: V */
    public final Bundle m3635V(String str) {
        int i;
        String str2;
        zzaX().zzg();
        m3644d();
        if (zzr().m3546k(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjx m3641a0 = m3641a0(str);
        bundle.putAll(m3641a0.zzc());
        bundle.putAll(m3638Y(str, m3639Z(str), m3641a0, new ai2(19)).zzb());
        ye3 m7852a0 = zzj().m7852a0(str, "_npa");
        if (m7852a0 != null) {
            i = m7852a0.f28932e.equals(1L);
        } else {
            i = m3655q(str, new ai2(19));
        }
        if (1 != i) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    /* renamed from: W */
    public final Bundle m3636W(zzbh zzbhVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.f14148a.getLong("_sid"));
        ye3 m7852a0 = zzj().m7852a0(str, "_sno");
        if (m7852a0 != null) {
            Object obj = m7852a0.f28932e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x02b6, code lost:
    
        if (r10 != false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ob3 m3637X(zzr zzrVar) {
        String str;
        Pair pair;
        boolean z;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str6;
        boolean z6;
        long j2;
        boolean z7;
        String str7;
        boolean z8;
        boolean z9;
        zzaX().zzg();
        m3644d();
        Preconditions.checkNotNull(zzrVar);
        String str8 = zzrVar.zza;
        Preconditions.checkNotEmpty(str8);
        String str9 = zzrVar.zzv;
        if (!str9.isEmpty()) {
            this.f14362D.put(str8, new te3(this, str9));
        }
        ob3 m7842R = zzj().m7842R(str8);
        zzjx zzl = m3641a0(str8).zzl(zzjx.zzk(zzrVar.zzu, 100));
        zzjw zzjwVar = zzjw.AD_STORAGE;
        if (!zzl.zzr(zzjwVar)) {
            str = "";
        } else {
            str = this.f14377i.m3593b(str8, zzrVar.zzn);
        }
        boolean z10 = false;
        boolean z11 = true;
        if (m7842R == null) {
            m7842R = new ob3(this.f14380l, str8);
            if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                m7842R.m6544k(m3640a(zzl));
            }
            if (zzl.zzr(zzjwVar)) {
                m7842R.m6530D(str);
            }
        } else {
            if (zzl.zzr(zzjwVar) && str != null) {
                zzio zzioVar = m7842R.f23733a;
                zzioVar.zzaX().zzg();
                if (!str.equals(m7842R.f23737e)) {
                    zzioVar.zzaX().zzg();
                    boolean isEmpty = TextUtils.isEmpty(m7842R.f23737e);
                    m7842R.m6530D(str);
                    if (zzrVar.zzn) {
                        zzoa zzoaVar = this.f14377i;
                        zzoaVar.getClass();
                        if (zzl.zzr(zzjwVar)) {
                            pair = zzoaVar.m3592a(str8);
                        } else {
                            pair = new Pair("", Boolean.FALSE);
                        }
                        if (!"00000000-0000-0000-0000-000000000000".equals(pair.first) && !isEmpty) {
                            if (zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                m7842R.m6544k(m3640a(zzl));
                                z = false;
                            } else {
                                z = true;
                            }
                            if (zzj().m7852a0(str8, "_id") != null && zzj().m7852a0(str8, "_lair") == null) {
                                zzj().m7834I(new ye3(str8, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzaU().currentTimeMillis(), 1L));
                            }
                            m7842R.m6556w(zzrVar.zzb);
                            m7842R.m6543j(zzrVar.zzp);
                            str2 = zzrVar.zzk;
                            if (!TextUtils.isEmpty(str2)) {
                                m7842R.m6555v(str2);
                            }
                            j = zzrVar.zze;
                            if (j != 0) {
                                m7842R.m6557x(j);
                            }
                            str3 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str3)) {
                                m7842R.m6546m(str3);
                            }
                            m7842R.m6547n(zzrVar.zzj);
                            str4 = zzrVar.zzd;
                            if (str4 != null) {
                                m7842R.m6545l(str4);
                            }
                            m7842R.m6552s(zzrVar.zzf);
                            m7842R.m6529C(zzrVar.zzh);
                            str5 = zzrVar.zzg;
                            if (!TextUtils.isEmpty(str5)) {
                                m7842R.m6558y(str5);
                            }
                            z2 = zzrVar.zzn;
                            zzio zzioVar2 = m7842R.f23733a;
                            zzioVar2.zzaX().zzg();
                            boolean z12 = m7842R.f23730R;
                            if (m7842R.f23748p == z2) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            m7842R.f23730R = z12 | z3;
                            m7842R.f23748p = z2;
                            Boolean bool = zzrVar.zzq;
                            zzioVar2.zzaX().zzg();
                            m7842R.f23730R |= !Objects.equals(m7842R.f23750r, bool);
                            m7842R.f23750r = bool;
                            m7842R.m6554u(zzrVar.zzr);
                            String str10 = zzrVar.zzw;
                            zzioVar2.zzaX().zzg();
                            m7842R.f23730R |= !Objects.equals(m7842R.f23753u, str10);
                            m7842R.f23753u = str10;
                            zzpn.zzb();
                            if (!zzi().zzx(null, zzgi.zzaK)) {
                                m7842R.m6531E(zzrVar.zzs);
                            } else {
                                zzpn.zzb();
                                if (zzi().zzx(null, zzgi.zzaJ)) {
                                    m7842R.m6531E(null);
                                }
                            }
                            z4 = zzrVar.zzx;
                            zzioVar2.zzaX().zzg();
                            boolean z13 = m7842R.f23730R;
                            if (m7842R.f23754v == z4) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            m7842R.f23730R = z13 | z5;
                            m7842R.f23754v = z4;
                            str6 = zzrVar.zzD;
                            zzioVar2.zzaX().zzg();
                            boolean z14 = m7842R.f23730R;
                            if (m7842R.f23716D == str6) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            m7842R.f23730R = z14 | z6;
                            m7842R.f23716D = str6;
                            zzqr.zzb();
                            if (zzi().zzx(null, zzgi.zzaV)) {
                                int i = zzrVar.zzB;
                                zzioVar2.zzaX().zzg();
                                boolean z15 = m7842R.f23730R;
                                if (m7842R.f23757y != i) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                m7842R.f23730R = z15 | z9;
                                m7842R.f23757y = i;
                            }
                            j2 = zzrVar.zzy;
                            zzioVar2.zzaX().zzg();
                            boolean z16 = m7842R.f23730R;
                            if (m7842R.f23755w == j2) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            m7842R.f23730R = z16 | z7;
                            m7842R.f23755w = j2;
                            str7 = zzrVar.zzE;
                            zzioVar2.zzaX().zzg();
                            boolean z17 = m7842R.f23730R;
                            if (m7842R.f23720H == str7) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            m7842R.f23730R = z17 | z8;
                            m7842R.f23720H = str7;
                            if (zzi().zzx(null, zzgi.zzaP)) {
                                int i2 = zzrVar.zzG;
                                zzioVar2.zzaX().zzg();
                                boolean z18 = m7842R.f23730R;
                                if (m7842R.f23722J != i2) {
                                    z10 = true;
                                }
                                m7842R.f23730R = z18 | z10;
                                m7842R.f23722J = i2;
                            }
                            zzioVar2.zzaX().zzg();
                            if (!m7842R.f23730R) {
                                z11 = z;
                            }
                            zzj().m7869q(m7842R, z11);
                            return m7842R;
                        }
                    }
                    if (TextUtils.isEmpty(m7842R.m6537d()) && zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                        m7842R.m6544k(m3640a(zzl));
                    }
                }
            }
            if (TextUtils.isEmpty(m7842R.m6537d()) && zzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                m7842R.m6544k(m3640a(zzl));
            }
        }
        z = false;
        m7842R.m6556w(zzrVar.zzb);
        m7842R.m6543j(zzrVar.zzp);
        str2 = zzrVar.zzk;
        if (!TextUtils.isEmpty(str2)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str3 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str3)) {
        }
        m7842R.m6547n(zzrVar.zzj);
        str4 = zzrVar.zzd;
        if (str4 != null) {
        }
        m7842R.m6552s(zzrVar.zzf);
        m7842R.m6529C(zzrVar.zzh);
        str5 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str5)) {
        }
        z2 = zzrVar.zzn;
        zzio zzioVar22 = m7842R.f23733a;
        zzioVar22.zzaX().zzg();
        boolean z122 = m7842R.f23730R;
        if (m7842R.f23748p == z2) {
        }
        m7842R.f23730R = z122 | z3;
        m7842R.f23748p = z2;
        Boolean bool2 = zzrVar.zzq;
        zzioVar22.zzaX().zzg();
        m7842R.f23730R |= !Objects.equals(m7842R.f23750r, bool2);
        m7842R.f23750r = bool2;
        m7842R.m6554u(zzrVar.zzr);
        String str102 = zzrVar.zzw;
        zzioVar22.zzaX().zzg();
        m7842R.f23730R |= !Objects.equals(m7842R.f23753u, str102);
        m7842R.f23753u = str102;
        zzpn.zzb();
        if (!zzi().zzx(null, zzgi.zzaK)) {
        }
        z4 = zzrVar.zzx;
        zzioVar22.zzaX().zzg();
        boolean z132 = m7842R.f23730R;
        if (m7842R.f23754v == z4) {
        }
        m7842R.f23730R = z132 | z5;
        m7842R.f23754v = z4;
        str6 = zzrVar.zzD;
        zzioVar22.zzaX().zzg();
        boolean z142 = m7842R.f23730R;
        if (m7842R.f23716D == str6) {
        }
        m7842R.f23730R = z142 | z6;
        m7842R.f23716D = str6;
        zzqr.zzb();
        if (zzi().zzx(null, zzgi.zzaV)) {
        }
        j2 = zzrVar.zzy;
        zzioVar22.zzaX().zzg();
        boolean z162 = m7842R.f23730R;
        if (m7842R.f23755w == j2) {
        }
        m7842R.f23730R = z162 | z7;
        m7842R.f23755w = j2;
        str7 = zzrVar.zzE;
        zzioVar22.zzaX().zzg();
        boolean z172 = m7842R.f23730R;
        if (m7842R.f23720H == str7) {
        }
        m7842R.f23730R = z172 | z8;
        m7842R.f23720H = str7;
        if (zzi().zzx(null, zzgi.zzaP)) {
        }
        zzioVar22.zzaX().zzg();
        if (!m7842R.f23730R) {
        }
        zzj().m7869q(m7842R, z11);
        return m7842R;
    }

    /* renamed from: Y */
    public final zzba m3638Y(String str, zzba zzbaVar, zzjx zzjxVar, ai2 ai2Var) {
        zzju zzjuVar;
        zzjw zzjwVar;
        boolean z;
        zzjw zzjwVar2;
        int i = 90;
        if (zzr().m3546k(str) == null) {
            if (zzbaVar.zzf() == zzju.DENIED) {
                i = zzbaVar.zza();
                ai2Var.m99i(zzjw.AD_USER_DATA, i);
            } else {
                ai2Var.m100j(zzjw.AD_USER_DATA, s93.FAILSAFE);
            }
            return new zzba(Boolean.FALSE, i, Boolean.TRUE, "-");
        }
        zzju zzf = zzbaVar.zzf();
        zzju zzjuVar2 = zzju.GRANTED;
        boolean z2 = false;
        zzif zzifVar = this.f14369a;
        if (zzf != zzjuVar2 && zzf != (zzjuVar = zzju.DENIED)) {
            if (zzf == zzju.POLICY && (zzf = zzifVar.m3545j(str, (zzjwVar2 = zzjw.AD_USER_DATA))) != zzju.UNINITIALIZED) {
                ai2Var.m100j(zzjwVar2, s93.REMOTE_ENFORCED_DEFAULT);
            } else {
                zzjw zzjwVar3 = zzjw.AD_USER_DATA;
                zzifVar.zzg();
                zzifVar.m3542e(str);
                com.google.android.gms.internal.measurement.zzgi m3546k = zzifVar.m3546k(str);
                if (m3546k != null) {
                    for (com.google.android.gms.internal.measurement.zzgb zzgbVar : m3546k.zze()) {
                        if (zzjwVar3 == zzif.m3537h(zzgbVar.zzc())) {
                            zzjwVar = zzif.m3537h(zzgbVar.zzb());
                            break;
                        }
                    }
                }
                zzjwVar = null;
                zzju zze = zzjxVar.zze();
                zzf = zzju.GRANTED;
                if (zze == zzf || zze == zzjuVar) {
                    z = true;
                } else {
                    z = false;
                }
                if (zzjwVar == zzjw.AD_STORAGE && z) {
                    ai2Var.m100j(zzjw.AD_USER_DATA, s93.REMOTE_DELEGATION);
                    zzf = zze;
                } else {
                    zzjw zzjwVar4 = zzjw.AD_USER_DATA;
                    ai2Var.m100j(zzjwVar4, s93.REMOTE_DEFAULT);
                    if (true != zzifVar.m3548m(str, zzjwVar4)) {
                        zzf = zzjuVar;
                    }
                }
            }
        } else {
            i = zzbaVar.zza();
            ai2Var.m99i(zzjw.AD_USER_DATA, i);
        }
        zzifVar.zzg();
        zzifVar.m3542e(str);
        com.google.android.gms.internal.measurement.zzgi m3546k2 = zzifVar.m3546k(str);
        if (m3546k2 == null || !m3546k2.zzh() || m3546k2.zzg()) {
            z2 = true;
        }
        zzif zzr = zzr();
        zzr.zzg();
        zzr.m3542e(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzgi m3546k3 = zzr.m3546k(str);
        if (m3546k3 != null) {
            Iterator it = m3546k3.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).zzb());
            }
        }
        if (zzf != zzju.DENIED && !treeSet.isEmpty()) {
            Boolean bool = Boolean.TRUE;
            Boolean valueOf = Boolean.valueOf(z2);
            String str2 = "";
            if (z2) {
                str2 = TextUtils.join("", treeSet);
            }
            return new zzba(bool, i, valueOf, str2);
        }
        return new zzba(Boolean.FALSE, i, Boolean.valueOf(z2), "-");
    }

    /* renamed from: Z */
    public final zzba m3639Z(String str) {
        zzaX().zzg();
        m3644d();
        HashMap hashMap = this.f14361C;
        zzba zzbaVar = (zzba) hashMap.get(str);
        if (zzbaVar == null) {
            v93 zzj = zzj();
            zzj.getClass();
            Preconditions.checkNotNull(str);
            zzj.zzg();
            zzj.zzav();
            zzba zze = zzba.zze(zzj.m7878z("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
            hashMap.put(str, zze);
            return zze;
        }
        return zzbaVar;
    }

    /* renamed from: a */
    public final String m3640a(zzjx zzjxVar) {
        if (zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzB().m3727g().nextBytes(bArr);
            return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        return null;
    }

    /* renamed from: a0 */
    public final zzjx m3641a0(String str) {
        zzjx zzjxVar = zzjx.zza;
        zzaX().zzg();
        m3644d();
        HashMap hashMap = this.f14360B;
        zzjx zzjxVar2 = (zzjx) hashMap.get(str);
        if (zzjxVar2 == null) {
            zzjxVar2 = zzj().m7849Y(str);
            if (zzjxVar2 == null) {
                zzjxVar2 = zzjx.zza;
            }
            zzaX().zzg();
            m3644d();
            hashMap.put(str, zzjxVar2);
            zzj().m7871s(str, zzjxVar2);
        }
        return zzjxVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e9, code lost:
    
        if (r2.moveToFirst() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00eb, code lost:
    
        r3 = r2.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ef, code lost:
    
        if (r3 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f1, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f8, code lost:
    
        r1.add(new com.google.android.gms.measurement.internal.zzov(r3, r2.getLong(1), r2.getInt(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x010e, code lost:
    
        if (r2.moveToNext() != false) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m3642b(zzr zzrVar, Bundle bundle) {
        ?? arrayList;
        Cursor cursor;
        zzaX().zzg();
        zzqr.zzb();
        zzam zzi = zzi();
        String str = zzrVar.zza;
        if (zzi.zzx(str, zzgi.zzaV) && str != null) {
            if (bundle != null) {
                int[] intArray = bundle.getIntArray("uriSources");
                long[] longArray = bundle.getLongArray("uriTimestamps");
                if (intArray != null) {
                    if (longArray != null && longArray.length == intArray.length) {
                        for (int i = 0; i < intArray.length; i++) {
                            v93 zzj = zzj();
                            int i2 = intArray[i];
                            long j = longArray[i];
                            Preconditions.checkNotEmpty(str);
                            zzj.zzg();
                            zzj.zzav();
                            try {
                                int delete = zzj.m7841Q().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                                zzj.zzu.zzaW().zzj().zzd("Pruned " + delete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                            } catch (SQLiteException e) {
                                zzj.zzu.zzaW().zze().zzc("Error pruning trigger URIs. appId", zzhe.zzn(str), e);
                            }
                        }
                    } else {
                        zzaW().zze().zza("Uri sources and timestamps do not match");
                    }
                }
            }
            v93 zzj2 = zzj();
            String str2 = zzrVar.zza;
            Preconditions.checkNotEmpty(str2);
            zzj2.zzg();
            zzj2.zzav();
            arrayList = new ArrayList();
            cursor = null;
            try {
                try {
                    cursor = zzj2.m7841Q().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", FirebaseAnalytics.Param.SOURCE}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                } catch (SQLiteException e2) {
                    zzj2.zzu.zzaW().zze().zzc("Error querying trigger uris. appId", zzhe.zzn(str2), e2);
                    arrayList = Collections.emptyList();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            return new ArrayList();
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* renamed from: c */
    public final void m3643c() {
        zzaX().zzg();
        m3644d();
        if (!this.f14382n) {
            this.f14382n = true;
            zzaX().zzg();
            FileLock fileLock = this.f14391w;
            zzio zzioVar = this.f14380l;
            if (fileLock != null && fileLock.isValid()) {
                zzaW().zzj().zza("Storage concurrent access okay");
            } else {
                this.f14371c.zzu.zzf();
                File filesDir = zzioVar.zzaT().getFilesDir();
                com.google.android.gms.internal.measurement.zzbx.zza();
                ga3 ga3Var = com.google.android.gms.internal.measurement.zzcc.f13800a;
                try {
                    FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                    this.f14392x = channel;
                    FileLock tryLock = channel.tryLock();
                    this.f14391w = tryLock;
                    if (tryLock != null) {
                        zzaW().zzj().zza("Storage concurrent access okay");
                    } else {
                        zzaW().zze().zza("Storage concurrent data access panic");
                        return;
                    }
                } catch (FileNotFoundException e) {
                    zzaW().zze().zzb("Failed to acquire storage lock", e);
                    return;
                } catch (IOException e2) {
                    zzaW().zze().zzb("Failed to access storage lock file", e2);
                    return;
                } catch (OverlappingFileLockException e3) {
                    zzaW().zzk().zzb("Storage lock already acquired", e3);
                    return;
                }
            }
            FileChannel fileChannel = this.f14392x;
            zzaX().zzg();
            int i = 0;
            if (fileChannel != null && fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read != 4) {
                        if (read != -1) {
                            zzaW().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } else {
                        allocate.flip();
                        i = allocate.getInt();
                    }
                } catch (IOException e4) {
                    zzaW().zze().zzb("Failed to read from channel", e4);
                }
            } else {
                zzaW().zze().zza("Bad channel to read from");
            }
            zzgs zzh = zzioVar.zzh();
            zzh.zza();
            int i2 = zzh.f14161d;
            zzaX().zzg();
            if (i > i2) {
                zzaW().zze().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            }
            if (i < i2) {
                FileChannel fileChannel2 = this.f14392x;
                zzaX().zzg();
                if (fileChannel2 != null && fileChannel2.isOpen()) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(i2);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zze().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                        return;
                    } catch (IOException e5) {
                        zzaW().zze().zzb("Failed to write to channel", e5);
                    }
                } else {
                    zzaW().zze().zza("Bad channel to read from");
                }
                zzaW().zze().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    /* renamed from: d */
    public final void m3644d() {
        if (this.f14381m.get()) {
        } else {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* renamed from: e */
    public final void m3645e(ob3 ob3Var) {
        zzaX().zzg();
        if (TextUtils.isEmpty(ob3Var.m6540g()) && TextUtils.isEmpty(ob3Var.m6534a())) {
            m3652l((String) Preconditions.checkNotNull(ob3Var.m6536c()), HttpStatusCodesKt.HTTP_NO_CONTENT, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(ob3Var.m6536c());
        zzaW().zzj().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgo zzj = zzr().zzj(str);
        String zzl = zzr().zzl(str);
        ArrayMap arrayMap = null;
        if (zzj != null) {
            if (!TextUtils.isEmpty(zzl)) {
                arrayMap = new ArrayMap();
                arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzl);
            }
            String zzk = zzr().zzk(str);
            if (!TextUtils.isEmpty(zzk)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put("If-None-Match", zzk);
            }
        }
        this.f14388t = true;
        zzp().zza(ob3Var, arrayMap, new rb3() { // from class: com.google.android.gms.measurement.internal.zzpj
            @Override // p000.rb3
            public final void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzpv.this.m3652l(str2, i, th, bArr, map);
            }
        });
    }

    /* renamed from: f */
    public final void m3646f(zzr zzrVar, long j) {
        boolean z;
        ob3 m7842R = zzj().m7842R((String) Preconditions.checkNotNull(zzrVar.zza));
        if (m7842R != null && zzB().m3714J(zzrVar.zzb, m7842R.m6540g(), zzrVar.zzp, m7842R.m6534a())) {
            zzaW().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzhe.zzn(m7842R.m6536c()));
            v93 zzj = zzj();
            String m6536c = m7842R.m6536c();
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(m6536c);
            try {
                SQLiteDatabase m7841Q = zzj.m7841Q();
                String[] strArr = {m6536c};
                int delete = m7841Q.delete("events", "app_id=?", strArr) + m7841Q.delete("user_attributes", "app_id=?", strArr) + m7841Q.delete("conditional_properties", "app_id=?", strArr) + m7841Q.delete("apps", "app_id=?", strArr) + m7841Q.delete("raw_events", "app_id=?", strArr) + m7841Q.delete("raw_events_metadata", "app_id=?", strArr) + m7841Q.delete("event_filters", "app_id=?", strArr) + m7841Q.delete("property_filters", "app_id=?", strArr) + m7841Q.delete("audience_filter_values", "app_id=?", strArr) + m7841Q.delete("consent_settings", "app_id=?", strArr) + m7841Q.delete("default_event_params", "app_id=?", strArr) + m7841Q.delete("trigger_uris", "app_id=?", strArr);
                if (delete > 0) {
                    zzj.zzu.zzaW().zzj().zzc("Deleted application data. app, records", m6536c, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error deleting application data. appId, error", zzhe.zzn(m6536c), e);
            }
            m7842R = null;
        }
        if (m7842R != null) {
            boolean z2 = true;
            if (m7842R.m6533G() != -2147483648L && m7842R.m6533G() != zzrVar.zzj) {
                z = true;
            } else {
                z = false;
            }
            String m6538e = m7842R.m6538e();
            if (m7842R.m6533G() != -2147483648L || m6538e == null || m6538e.equals(zzrVar.zzc)) {
                z2 = false;
            }
            if (z | z2) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", m6538e);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j);
                if (zzi().zzx(null, zzgi.zzbm)) {
                    m3651k(zzbhVar, zzrVar);
                } else {
                    m3649i(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m3647g(ob3 ob3Var, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        ai2 ai2Var;
        com.google.android.gms.internal.measurement.zzio zzioVar;
        boolean z;
        int i;
        String str;
        s93 s93Var;
        zzaX().zzg();
        m3644d();
        String zzaH = zzhwVar.zzaH();
        EnumMap enumMap = new EnumMap(zzjw.class);
        int length = zzaH.length();
        int length2 = zzjw.values().length;
        s93 s93Var2 = s93.UNSET;
        int i2 = 0;
        if (length >= length2 && zzaH.charAt(0) == '1') {
            zzjw[] values = zzjw.values();
            int length3 = values.length;
            int i3 = 0;
            int i4 = 1;
            while (i3 < length3) {
                zzjw zzjwVar = values[i3];
                int i5 = i4 + 1;
                char charAt = zzaH.charAt(i4);
                s93[] values2 = s93.values();
                int length4 = values2.length;
                while (true) {
                    if (i2 < length4) {
                        s93Var = values2[i2];
                        str = zzaH;
                        if (s93Var.f26340a == charAt) {
                            break;
                        }
                        i2++;
                        zzaH = str;
                    } else {
                        str = zzaH;
                        s93Var = s93Var2;
                        break;
                    }
                }
                enumMap.put((EnumMap) zzjwVar, (zzjw) s93Var);
                i3++;
                i4 = i5;
                zzaH = str;
                i2 = 0;
            }
            ai2Var = new ai2(enumMap);
        } else {
            ai2Var = new ai2(19);
        }
        String m6536c = ob3Var.m6536c();
        zzaX().zzg();
        m3644d();
        zzjx m3641a0 = m3641a0(m6536c);
        int ordinal = m3641a0.zze().ordinal();
        s93 s93Var3 = s93.REMOTE_ENFORCED_DEFAULT;
        s93 s93Var4 = s93.FAILSAFE;
        if (ordinal != 1) {
            if (ordinal != 2 && ordinal != 3) {
                ai2Var.m100j(zzjw.AD_STORAGE, s93Var4);
            } else {
                ai2Var.m99i(zzjw.AD_STORAGE, m3641a0.zzb());
            }
        } else {
            ai2Var.m100j(zzjw.AD_STORAGE, s93Var3);
        }
        int ordinal2 = m3641a0.zzf().ordinal();
        if (ordinal2 != 1) {
            if (ordinal2 != 2 && ordinal2 != 3) {
                ai2Var.m100j(zzjw.ANALYTICS_STORAGE, s93Var4);
            } else {
                ai2Var.m99i(zzjw.ANALYTICS_STORAGE, m3641a0.zzb());
            }
        } else {
            ai2Var.m100j(zzjw.ANALYTICS_STORAGE, s93Var3);
        }
        String m6536c2 = ob3Var.m6536c();
        zzaX().zzg();
        m3644d();
        zzba m3638Y = m3638Y(m6536c2, m3639Z(m6536c2), m3641a0(m6536c2), ai2Var);
        zzhwVar.zzak(((Boolean) Preconditions.checkNotNull(m3638Y.zzh())).booleanValue());
        if (!TextUtils.isEmpty(m3638Y.zzi())) {
            zzhwVar.zzU(m3638Y.zzi());
        }
        zzaX().zzg();
        m3644d();
        Iterator it = zzhwVar.zzaN().iterator();
        while (true) {
            if (it.hasNext()) {
                zzioVar = (com.google.android.gms.internal.measurement.zzio) it.next();
                if ("_npa".equals(zzioVar.zzg())) {
                    break;
                }
            } else {
                zzioVar = null;
                break;
            }
        }
        if (zzioVar != null) {
            zzjw zzjwVar2 = zzjw.AD_PERSONALIZATION;
            s93 s93Var5 = (s93) ((EnumMap) ai2Var.f216b).get(zzjwVar2);
            if (s93Var5 == null) {
                s93Var5 = s93Var2;
            }
            if (s93Var5 == s93Var2) {
                ye3 m7852a0 = zzj().m7852a0(ob3Var.m6536c(), "_npa");
                s93 s93Var6 = s93.MANIFEST;
                s93 s93Var7 = s93.API;
                if (m7852a0 != null) {
                    String str2 = m7852a0.f28929b;
                    if ("tcf".equals(str2)) {
                        ai2Var.m100j(zzjwVar2, s93.TCF);
                    } else if ("app".equals(str2)) {
                        ai2Var.m100j(zzjwVar2, s93Var7);
                    } else {
                        ai2Var.m100j(zzjwVar2, s93Var6);
                    }
                } else {
                    ob3Var.f23733a.zzaX().zzg();
                    Boolean bool = ob3Var.f23750r;
                    if (bool != null && ((!bool.booleanValue() || zzioVar.zzc() == 1) && (bool.booleanValue() || zzioVar.zzc() == 0))) {
                        ai2Var.m100j(zzjwVar2, s93Var6);
                    } else {
                        ai2Var.m100j(zzjwVar2, s93Var7);
                    }
                }
            }
        } else {
            int m3655q = m3655q(ob3Var.m6536c(), ai2Var);
            zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
            zze.zzf("_npa");
            zze.zzg(zzaU().currentTimeMillis());
            zze.zze(m3655q);
            zzhwVar.zzp((com.google.android.gms.internal.measurement.zzio) zze.zzba());
            zzaW().zzj().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(m3655q));
        }
        zzhwVar.zzS(ai2Var.toString());
        String m6536c3 = ob3Var.m6536c();
        zzif zzifVar = this.f14369a;
        zzifVar.zzg();
        zzifVar.m3542e(m6536c3);
        com.google.android.gms.internal.measurement.zzgi m3546k = zzifVar.m3546k(m6536c3);
        if (m3546k == null || !m3546k.zzh() || m3546k.zzg()) {
            z = true;
        } else {
            z = false;
        }
        List zzaM = zzhwVar.zzaM();
        for (int i6 = 0; i6 < zzaM.size(); i6++) {
            if ("_tcf".equals(((zzhm) zzaM.get(i6)).zzh())) {
                zzhl zzhlVar = (zzhl) ((zzhm) zzaM.get(i6)).zzch();
                List zzp = zzhlVar.zzp();
                int i7 = 0;
                while (true) {
                    if (i7 >= zzp.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i7)).zzg())) {
                        String zzh = ((com.google.android.gms.internal.measurement.zzhq) zzp.get(i7)).zzh();
                        if (z && zzh.length() > 4) {
                            char[] charArray = zzh.toCharArray();
                            int i8 = 1;
                            while (true) {
                                if (i8 < 64) {
                                    if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i8)) {
                                        i = i8;
                                        break;
                                    }
                                    i8++;
                                } else {
                                    i = 0;
                                    break;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            zzh = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                        zze2.zzj("_tcfd");
                        zze2.zzk(zzh);
                        zzhlVar.zzj(i7, zze2);
                    } else {
                        i7++;
                    }
                }
                zzhwVar.zzad(i6, zzhlVar);
                return;
            }
        }
    }

    /* renamed from: h */
    public final void m3648h(com.google.android.gms.internal.measurement.zzhw zzhwVar, se3 se3Var) {
        String str;
        String str2;
        for (int i = 0; i < zzhwVar.zzc(); i++) {
            zzhl zzhlVar = (zzhl) zzhwVar.zzh(i).zzch();
            Iterator it = zzhlVar.zzp().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhq) it.next()).zzg())) {
                    if (se3Var.f26396a.zza() >= zzi().zzh(se3Var.f26396a.zzF(), zzgi.zzak)) {
                        int zzh = zzi().zzh(se3Var.f26396a.zzF(), zzgi.zzax);
                        LinkedList linkedList = this.f14385q;
                        if (zzh > 0) {
                            if (zzj().m7845U(m3654n(), se3Var.f26396a.zzF(), false, false, false, true).f14131g > zzh) {
                                com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze.zzj("_tnr");
                                zze.zzi(1L);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                            } else {
                                if (zzi().zzx(se3Var.f26396a.zzF(), zzgi.zzaX)) {
                                    str2 = zzB().m3726e();
                                    com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                                    zze2.zzj("_tu");
                                    zze2.zzk(str2);
                                    zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                                } else {
                                    str2 = null;
                                }
                                com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze3.zzj("_tr");
                                zze3.zzi(1L);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze3.zzba());
                                zzov m3693v = zzA().m3693v(se3Var.f26396a.zzF(), zzhwVar, zzhlVar, str2);
                                if (m3693v != null) {
                                    zzaW().zzj().zzc("Generated trigger URI. appId, uri", se3Var.f26396a.zzF(), m3693v.zza);
                                    zzj().m7830E(se3Var.f26396a.zzF(), m3693v);
                                    if (!linkedList.contains(se3Var.f26396a.zzF())) {
                                        linkedList.add(se3Var.f26396a.zzF());
                                    }
                                }
                            }
                        } else {
                            if (zzi().zzx(se3Var.f26396a.zzF(), zzgi.zzaX)) {
                                str = zzB().m3726e();
                                com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze4.zzj("_tu");
                                zze4.zzk(str);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze4.zzba());
                            } else {
                                str = null;
                            }
                            com.google.android.gms.internal.measurement.zzhp zze5 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze5.zzj("_tr");
                            zze5.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze5.zzba());
                            zzov m3693v2 = zzA().m3693v(se3Var.f26396a.zzF(), zzhwVar, zzhlVar, str);
                            if (m3693v2 != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", se3Var.f26396a.zzF(), m3693v2.zza);
                                zzj().m7830E(se3Var.f26396a.zzF(), m3693v2);
                                if (!linkedList.contains(se3Var.f26396a.zzF())) {
                                    linkedList.add(se3Var.f26396a.zzF());
                                }
                            }
                        }
                    }
                    zzhwVar.zzae(i, (zzhm) zzhlVar.zzba());
                }
            }
        }
    }

    /* renamed from: i */
    public final void m3649i(zzbh zzbhVar, zzr zzrVar) {
        zzmh zzmhVar;
        zzbh zzbhVar2;
        List m7855c;
        zzio zzioVar;
        List<zzai> m7855c2;
        List m7855c3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        m3644d();
        long j = zzbhVar.zzd;
        zzhf zzb = zzhf.zzb(zzbhVar);
        zzaX().zzg();
        if (this.f14364F == null || (str = this.f14365G) == null || !str.equals(str2)) {
            zzmhVar = null;
        } else {
            zzmhVar = this.f14364F;
        }
        zzqf.zzN(zzmhVar, zzb.zzd, false);
        zzbh zza = zzb.zza();
        zzA();
        Preconditions.checkNotNull(zza);
        Preconditions.checkNotNull(zzrVar);
        if (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) {
            return;
        }
        if (!zzrVar.zzh) {
            m3637X(zzrVar);
            return;
        }
        List list = zzrVar.zzs;
        if (list != null) {
            String str3 = zza.zza;
            if (list.contains(str3)) {
                Bundle zzc = zza.zzb.zzc();
                zzc.putLong("ga_safelisted", 1L);
                zzbhVar2 = new zzbh(str3, new zzbf(zzc), zza.zzc, zza.zzd);
            } else {
                zzaW().zzd().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza.zza, zza.zzc);
                return;
            }
        } else {
            zzbhVar2 = zza;
        }
        zzj().zzH();
        try {
            zzra.zzb();
            if (zzi().zzx(null, zzgi.zzbi) && "_s".equals(zzbhVar2.zza) && !zzj().m7873u(str2, "_s") && zzbhVar2.zzb.f14148a.getLong("_sid") != 0) {
                if (!zzj().m7873u(str2, "_f") && !zzj().m7873u(str2, "_v")) {
                    zzj().m7859g(str2, Long.valueOf(zzaU().currentTimeMillis() - 15000), "_sid", m3636W(zzbhVar2, str2));
                }
                zzj().m7859g(str2, null, "_sid", m3636W(zzbhVar2, str2));
            }
            v93 zzj = zzj();
            Preconditions.checkNotEmpty(str2);
            zzj.zzg();
            zzj.zzav();
            if (j < 0) {
                zzj.zzu.zzaW().zzk().zzc("Invalid time querying timed out conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                m7855c = Collections.emptyList();
            } else {
                m7855c = zzj.m7855c("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
            }
            Iterator it = m7855c.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                zzioVar = this.f14380l;
                if (!hasNext) {
                    break;
                }
                zzai zzaiVar = (zzai) it.next();
                if (zzaiVar != null) {
                    zzaW().zzj().zzd("User property timed out", zzaiVar.zza, zzioVar.zzj().zzf(zzaiVar.zzc.zzb), zzaiVar.zzc.zza());
                    zzbh zzbhVar3 = zzaiVar.zzg;
                    if (zzbhVar3 != null) {
                        m3633T(new zzbh(zzbhVar3, j), zzrVar);
                    }
                    zzj().m7874v(str2, zzaiVar.zzc.zzb);
                }
            }
            v93 zzj2 = zzj();
            Preconditions.checkNotEmpty(str2);
            zzj2.zzg();
            zzj2.zzav();
            if (j < 0) {
                zzj2.zzu.zzaW().zzk().zzc("Invalid time querying expired conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                m7855c2 = Collections.emptyList();
            } else {
                m7855c2 = zzj2.m7855c("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
            }
            ArrayList arrayList = new ArrayList(m7855c2.size());
            for (zzai zzaiVar2 : m7855c2) {
                if (zzaiVar2 != null) {
                    zzaW().zzj().zzd("User property expired", zzaiVar2.zza, zzioVar.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                    zzj().m7866n(str2, zzaiVar2.zzc.zzb);
                    zzbh zzbhVar4 = zzaiVar2.zzk;
                    if (zzbhVar4 != null) {
                        arrayList.add(zzbhVar4);
                    }
                    zzj().m7874v(str2, zzaiVar2.zzc.zzb);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m3633T(new zzbh((zzbh) it2.next(), j), zzrVar);
            }
            v93 zzj3 = zzj();
            String str4 = zzbhVar2.zza;
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str4);
            zzj3.zzg();
            zzj3.zzav();
            if (j < 0) {
                zzio zzioVar2 = zzj3.zzu;
                zzioVar2.zzaW().zzk().zzd("Invalid time querying triggered conditional properties", zzhe.zzn(str2), zzioVar2.zzj().zzd(str4), Long.valueOf(j));
                m7855c3 = Collections.emptyList();
            } else {
                m7855c3 = zzj3.m7855c("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
            }
            ArrayList arrayList2 = new ArrayList(m7855c3.size());
            Iterator it3 = m7855c3.iterator();
            while (it3.hasNext()) {
                zzai zzaiVar3 = (zzai) it3.next();
                if (zzaiVar3 != null) {
                    zzqb zzqbVar = zzaiVar3.zzc;
                    Iterator it4 = it3;
                    ye3 ye3Var = new ye3((String) Preconditions.checkNotNull(zzaiVar3.zza), zzaiVar3.zzb, zzqbVar.zzb, j, Preconditions.checkNotNull(zzqbVar.zza()));
                    Object obj = ye3Var.f28932e;
                    String str5 = ye3Var.f28930c;
                    if (zzj().m7834I(ye3Var)) {
                        zzaW().zzj().zzd("User property triggered", zzaiVar3.zza, zzioVar.zzj().zzf(str5), obj);
                    } else {
                        zzaW().zze().zzd("Too many active user properties, ignoring", zzhe.zzn(zzaiVar3.zza), zzioVar.zzj().zzf(str5), obj);
                    }
                    zzbh zzbhVar5 = zzaiVar3.zzi;
                    if (zzbhVar5 != null) {
                        arrayList2.add(zzbhVar5);
                    }
                    zzaiVar3.zzc = new zzqb(ye3Var);
                    zzaiVar3.zze = true;
                    zzj().m7833H(zzaiVar3);
                    it3 = it4;
                }
            }
            m3633T(zzbhVar2, zzrVar);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3633T(new zzbh((zzbh) it5.next(), j), zzrVar);
            }
            zzj().m7868p();
            zzj().m7863k();
        } catch (Throwable th) {
            zzj().m7863k();
            throw th;
        }
    }

    /* renamed from: j */
    public final void m3650j(zzbh zzbhVar, String str) {
        ob3 m7842R = zzj().m7842R(str);
        if (m7842R != null && !TextUtils.isEmpty(m7842R.m6538e())) {
            Boolean m3657s = m3657s(m7842R);
            if (m3657s == null) {
                if (!"_ui".equals(zzbhVar.zza)) {
                    zzaW().zzk().zzb("Could not find package. appId", zzhe.zzn(str));
                }
            } else if (!m3657s.booleanValue()) {
                zzaW().zze().zzb("App version does not match; dropping event. appId", zzhe.zzn(str));
                return;
            }
            String m6540g = m7842R.m6540g();
            String m6538e = m7842R.m6538e();
            long m6533G = m7842R.m6533G();
            zzio zzioVar = m7842R.f23733a;
            zzioVar.zzaX().zzg();
            String str2 = m7842R.f23744l;
            zzioVar.zzaX().zzg();
            long j = m7842R.f23745m;
            zzioVar.zzaX().zzg();
            long j2 = m7842R.f23746n;
            zzioVar.zzaX().zzg();
            boolean z = m7842R.f23747o;
            String m6539f = m7842R.m6539f();
            zzioVar.zzaX().zzg();
            boolean z2 = m7842R.f23748p;
            String m6534a = m7842R.m6534a();
            zzioVar.zzaX().zzg();
            Boolean bool = m7842R.f23750r;
            zzioVar.zzaX().zzg();
            long j3 = m7842R.f23751s;
            zzioVar.zzaX().zzg();
            ArrayList arrayList = m7842R.f23752t;
            String zzq = m3641a0(str).zzq();
            boolean m6549p = m7842R.m6549p();
            zzioVar.zzaX().zzg();
            long j4 = m7842R.f23755w;
            int zzb = m3641a0(str).zzb();
            String zzj = m3639Z(str).zzj();
            zzioVar.zzaX().zzg();
            int i = m7842R.f23757y;
            zzioVar.zzaX().zzg();
            long j5 = m7842R.f23715C;
            String m6541h = m7842R.m6541h();
            zzioVar.zzaX().zzg();
            m3651k(zzbhVar, new zzr(str, m6540g, m6538e, m6533G, str2, j, j2, (String) null, z, false, m6539f, 0L, 0, z2, false, m6534a, bool, j3, (List) arrayList, (String) null, zzq, "", (String) null, m6549p, j4, zzb, zzj, i, j5, m6541h, m7842R.f23720H, 0L, m7842R.m6532F()));
            return;
        }
        zzaW().zzd().zzb("No app data available; dropping event", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0094, code lost:
    
        if (r5 == null) goto L27;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x007e: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:127), block:B:32:0x007e */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3651k(zzbh zzbhVar, zzr zzrVar) {
        SQLiteException e;
        Cursor cursor;
        Cursor cursor2;
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzhf zzb = zzhf.zzb(zzbhVar);
        Bundle bundle = zzb.zzd;
        zzqf zzB = zzB();
        v93 zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        Cursor cursor3 = null;
        r4 = null;
        Bundle bundle2 = null;
        try {
            try {
                cursor = zzj.m7841Q().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj.zzu.zzaW().zze().zzb("Error selecting default event parameters", e);
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (!cursor.moveToFirst()) {
            zzj.zzu.zzaW().zzj().zza("Default event parameters not found");
        } else {
            try {
                zzhm zzhmVar = (zzhm) ((zzhl) zzqa.m3683x(zzhm.zze(), cursor.getBlob(0))).zzba();
                zzj.zzg.zzA();
                bundle2 = zzqa.m3670e(zzhmVar.zzi());
            } catch (IOException e4) {
                zzj.zzu.zzaW().zze().zzc("Failed to retrieve default event parameters. appId", zzhe.zzn(str), e4);
            }
            cursor.close();
            zzB.m3730j(bundle, bundle2);
            zzB().m3732l(zzb, zzi().zzf(str));
            zzbh zza = zzb.zza();
            if ("_cmp".equals(zza.zza)) {
                zzbf zzbfVar = zza.zzb;
                if ("referrer API v2".equals(zzbfVar.f14148a.getString("_cis"))) {
                    String string = zzbfVar.f14148a.getString("gclid");
                    if (!TextUtils.isEmpty(string)) {
                        m3628O(new zzqb(zza.zzd, string, "_lgclid", DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                    }
                }
            }
            m3649i(zza, zzrVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0175, B:24:0x006a, B:27:0x0085, B:31:0x00cf, B:32:0x00c0, B:34:0x00d4, B:38:0x00e6, B:39:0x00ff, B:41:0x0113, B:42:0x0132, B:44:0x013c, B:46:0x0142, B:47:0x0146, B:49:0x0152, B:51:0x015c, B:53:0x016a, B:54:0x0172, B:55:0x0121, B:56:0x00ee, B:58:0x00f8), top: B:4:0x002f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0113 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0175, B:24:0x006a, B:27:0x0085, B:31:0x00cf, B:32:0x00c0, B:34:0x00d4, B:38:0x00e6, B:39:0x00ff, B:41:0x0113, B:42:0x0132, B:44:0x013c, B:46:0x0142, B:47:0x0146, B:49:0x0152, B:51:0x015c, B:53:0x016a, B:54:0x0172, B:55:0x0121, B:56:0x00ee, B:58:0x00f8), top: B:4:0x002f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0175, B:24:0x006a, B:27:0x0085, B:31:0x00cf, B:32:0x00c0, B:34:0x00d4, B:38:0x00e6, B:39:0x00ff, B:41:0x0113, B:42:0x0132, B:44:0x013c, B:46:0x0142, B:47:0x0146, B:49:0x0152, B:51:0x015c, B:53:0x016a, B:54:0x0172, B:55:0x0121, B:56:0x00ee, B:58:0x00f8), top: B:4:0x002f, outer: #1 }] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3652l(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        m3644d();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f14388t = false;
                m3658u();
                throw th2;
            }
        }
        zzhc zzj = zzaW().zzj();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzj.zzb("onConfigFetched. Response size", valueOf);
        zzj().zzH();
        try {
            ob3 m7842R = zzj().m7842R(str);
            boolean z2 = true;
            if (i != 200 && i != 204) {
                if (i == 304) {
                    i = 304;
                }
                z = false;
                if (m7842R == null) {
                    zzaW().zzk().zzb("App does not exist in onConfigFetched. appId", zzhe.zzn(str));
                } else {
                    if (!z && i != 404) {
                        long currentTimeMillis = zzaU().currentTimeMillis();
                        m7842R.f23733a.zzaX().zzg();
                        boolean z3 = m7842R.f23730R;
                        if (m7842R.f23732T == currentTimeMillis) {
                            z2 = false;
                        }
                        m7842R.f23730R = z2 | z3;
                        m7842R.f23732T = currentTimeMillis;
                        zzj().m7869q(m7842R, false);
                        zzaW().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                        zzr().zzq(str);
                        this.f14377i.zze.zzb(zzaU().currentTimeMillis());
                        if (i == 503 || i == 429) {
                            this.f14377i.zzc.zzb(zzaU().currentTimeMillis());
                        }
                        m3661x();
                    }
                    String m3616t = m3616t("Last-Modified", map);
                    String m3616t2 = m3616t("ETag", map);
                    if (i != 404 && i != 304) {
                        zzr().zzz(str, bArr, m3616t, m3616t2);
                        m7842R.m6550q(zzaU().currentTimeMillis());
                        zzj().m7869q(m7842R, false);
                        if (i != 404) {
                            zzaW().zzl().zzb("Config not found. Using empty config. appId", str);
                        } else {
                            zzaW().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                        }
                        if (!zzp().zzd() && m3663z()) {
                            m3629P();
                        } else if (!zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().m7872t(m7842R.m6536c())) {
                            m3631R(m7842R.m6536c());
                        } else {
                            m3661x();
                        }
                    }
                    if (zzr().zzj(str) == null) {
                        zzr().zzz(str, null, null, null);
                    }
                    m7842R.m6550q(zzaU().currentTimeMillis());
                    zzj().m7869q(m7842R, false);
                    if (i != 404) {
                    }
                    if (!zzp().zzd()) {
                    }
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                    }
                    m3661x();
                }
                zzj().m7868p();
                zzj().m7863k();
                this.f14388t = false;
                m3658u();
            }
            if (th == null) {
                z = true;
                if (m7842R == null) {
                }
                zzj().m7868p();
                zzj().m7863k();
                this.f14388t = false;
                m3658u();
            }
            z = false;
            if (m7842R == null) {
            }
            zzj().m7868p();
            zzj().m7863k();
            this.f14388t = false;
            m3658u();
        } catch (Throwable th3) {
            zzj().m7863k();
            throw th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r23 != null) goto L16;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3653m(boolean z, int i, IOException iOException, byte[] bArr, String str, List list) {
        byte[] bArr2;
        long j;
        v93 zzj;
        long longValue;
        int i2 = i;
        zzaX().zzg();
        m3644d();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.f14389u = false;
                m3658u();
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.f14393y);
        this.f14393y = null;
        try {
            if (z) {
                if (i2 != 200) {
                    if (i2 == 204) {
                        i2 = 204;
                    }
                    String str2 = new String(bArr2, StandardCharsets.UTF_8);
                    zzaW().zzl().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), iOException, str2.substring(0, Math.min(32, str2.length())));
                    this.f14377i.zze.zzb(zzaU().currentTimeMillis());
                    if (i2 == 503 || i2 == 429) {
                        this.f14377i.zzc.zzb(zzaU().currentTimeMillis());
                    }
                    zzj().m7864l(list2);
                    m3661x();
                    this.f14389u = false;
                    m3658u();
                    return;
                }
            }
            long j2 = -1;
            if (zzi().zzx(null, zzgi.zzaM)) {
                if (zzi().zzx(null, zzgi.zzaP)) {
                    HashMap hashMap = new HashMap();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair.first;
                        zzph zzphVar = (zzph) pair.second;
                        if (zzphVar.zza() != zzmf.SGTM_CLIENT) {
                            long j3 = j2;
                            long m7838N = zzj().m7838N(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), null);
                            if (zzphVar.zza() == zzmf.GOOGLE_SIGNAL_PENDING && m7838N != j3 && !zzhvVar.zzf().isEmpty()) {
                                hashMap.put(zzhvVar.zzf(), Long.valueOf(m7838N));
                            }
                            j2 = j3;
                        }
                    }
                    j = j2;
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Pair pair2 = (Pair) it2.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair2.first;
                        zzph zzphVar2 = (zzph) pair2.second;
                        if (zzphVar2.zza() == zzmf.SGTM_CLIENT) {
                            zzj().m7838N(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), (Long) hashMap.get(zzhvVar2.zzf()));
                        }
                    }
                } else {
                    j = -1;
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        Pair pair3 = (Pair) it3.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) pair3.first;
                        zzph zzphVar3 = (zzph) pair3.second;
                        zzj().m7838N(str, zzhvVar3, zzphVar3.zzc(), zzphVar3.zzd(), zzphVar3.zza(), null);
                    }
                }
            } else {
                j = -1;
            }
            for (Long l : list2) {
                try {
                    zzj = zzj();
                    longValue = l.longValue();
                    zzj.zzg();
                    zzj.zzav();
                } catch (SQLiteException e) {
                    ArrayList arrayList = this.f14394z;
                    if (arrayList == null || !arrayList.contains(l)) {
                        throw e;
                    }
                }
                try {
                    if (zzj.m7841Q().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                        break;
                    }
                } catch (SQLiteException e2) {
                    zzj.zzu.zzaW().zze().zzb("Failed to delete a bundle in a queue table", e2);
                    throw e2;
                    break;
                }
            }
            zzj().m7868p();
            zzj().m7863k();
            this.f14394z = null;
            if (zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().m7872t(str)) {
                m3631R(str);
            } else if (zzp().zzd() && m3663z()) {
                m3629P();
            } else {
                this.f14359A = j;
                m3661x();
            }
            this.f14383o = 0L;
            this.f14389u = false;
            m3658u();
            return;
        } catch (Throwable th) {
            zzj().m7863k();
            throw th;
        }
        zzhc zzj2 = zzaW().zzj();
        Integer valueOf = Integer.valueOf(i2);
        zzj2.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z));
        if (z) {
            try {
                this.f14377i.zzd.zzb(zzaU().currentTimeMillis());
            } catch (SQLiteException e3) {
                zzaW().zze().zzb("Database error while trying to delete uploaded bundles", e3);
                this.f14383o = zzaU().elapsedRealtime();
                zzaW().zzj().zzb("Disable upload, time", Long.valueOf(this.f14383o));
            }
        }
        this.f14377i.zze.zzb(0L);
        m3661x();
        if (z) {
            zzaW().zzj().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaW().zzj().zza("Purged empty bundles");
        }
        zzj().zzH();
    }

    /* renamed from: n */
    public final long m3654n() {
        long currentTimeMillis = zzaU().currentTimeMillis();
        zzoa zzoaVar = this.f14377i;
        zzoaVar.zzav();
        zzoaVar.zzg();
        zzhp zzhpVar = zzoaVar.zzf;
        long zza = zzhpVar.zza();
        if (zza == 0) {
            zza = zzoaVar.zzu.zzw().m3727g().nextInt(86400000) + 1;
            zzhpVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    /* renamed from: q */
    public final int m3655q(String str, ai2 ai2Var) {
        zzjw zzjwVar;
        zzju m3545j;
        zzif zzifVar = this.f14369a;
        if (zzifVar.m3546k(str) == null) {
            ai2Var.m100j(zzjw.AD_PERSONALIZATION, s93.FAILSAFE);
            return 1;
        }
        ob3 m7842R = zzj().m7842R(str);
        if (m7842R != null) {
            m7842R.f23733a.zzaX().zzg();
            if (((zzju) ai2.m91g(m7842R.f23720H).f216b) == zzju.POLICY && (m3545j = zzifVar.m3545j(str, (zzjwVar = zzjw.AD_PERSONALIZATION))) != zzju.UNINITIALIZED) {
                ai2Var.m100j(zzjwVar, s93.REMOTE_ENFORCED_DEFAULT);
                if (m3545j != zzju.GRANTED) {
                    return 1;
                }
                return 0;
            }
        }
        zzjw zzjwVar2 = zzjw.AD_PERSONALIZATION;
        ai2Var.m100j(zzjwVar2, s93.REMOTE_DEFAULT);
        if (!zzifVar.m3548m(str, zzjwVar2)) {
            return 1;
        }
        return 0;
    }

    /* renamed from: r */
    public final zzr m3656r(String str) {
        ob3 m7842R = zzj().m7842R(str);
        if (m7842R != null && !TextUtils.isEmpty(m7842R.m6538e())) {
            Boolean m3657s = m3657s(m7842R);
            if (m3657s != null && !m3657s.booleanValue()) {
                zzaW().zze().zzb("App version does not match; dropping. appId", zzhe.zzn(str));
                return null;
            }
            String m6540g = m7842R.m6540g();
            String m6538e = m7842R.m6538e();
            long m6533G = m7842R.m6533G();
            zzio zzioVar = m7842R.f23733a;
            zzioVar.zzaX().zzg();
            String str2 = m7842R.f23744l;
            zzioVar.zzaX().zzg();
            long j = m7842R.f23745m;
            zzioVar.zzaX().zzg();
            long j2 = m7842R.f23746n;
            zzioVar.zzaX().zzg();
            boolean z = m7842R.f23747o;
            String m6539f = m7842R.m6539f();
            zzioVar.zzaX().zzg();
            boolean z2 = m7842R.f23748p;
            String m6534a = m7842R.m6534a();
            zzioVar.zzaX().zzg();
            Boolean bool = m7842R.f23750r;
            zzioVar.zzaX().zzg();
            long j3 = m7842R.f23751s;
            zzioVar.zzaX().zzg();
            ArrayList arrayList = m7842R.f23752t;
            String zzq = m3641a0(str).zzq();
            boolean m6549p = m7842R.m6549p();
            zzioVar.zzaX().zzg();
            long j4 = m7842R.f23755w;
            int zzb = m3641a0(str).zzb();
            String zzj = m3639Z(str).zzj();
            zzioVar.zzaX().zzg();
            int i = m7842R.f23757y;
            zzioVar.zzaX().zzg();
            long j5 = m7842R.f23715C;
            String m6541h = m7842R.m6541h();
            zzioVar.zzaX().zzg();
            return new zzr(str, m6540g, m6538e, m6533G, str2, j, j2, (String) null, z, false, m6539f, 0L, 0, z2, false, m6534a, bool, j3, (List) arrayList, (String) null, zzq, "", (String) null, m6549p, j4, zzb, zzj, i, j5, m6541h, m7842R.f23720H, 0L, m7842R.m6532F());
        }
        zzaW().zzd().zzb("No app data available; dropping", str);
        return null;
    }

    /* renamed from: s */
    public final Boolean m3657s(ob3 ob3Var) {
        try {
            long m6533G = ob3Var.m6533G();
            zzio zzioVar = this.f14380l;
            if (m6533G != -2147483648L) {
                if (ob3Var.m6533G() == Wrappers.packageManager(zzioVar.zzaT()).getPackageInfo(ob3Var.m6536c(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(zzioVar.zzaT()).getPackageInfo(ob3Var.m6536c(), 0).versionName;
                String m6538e = ob3Var.m6538e();
                if (m6538e != null && m6538e.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: u */
    public final void m3658u() {
        zzaX().zzg();
        if (!this.f14388t && !this.f14389u && !this.f14390v) {
            zzaW().zzj().zza("Stopping uploading service(s)");
            ArrayList arrayList = this.f14384p;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            ((List) Preconditions.checkNotNull(this.f14384p)).clear();
            return;
        }
        zzaW().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f14388t), Boolean.valueOf(this.f14389u), Boolean.valueOf(this.f14390v));
    }

    /* renamed from: v */
    public final void m3659v(com.google.android.gms.internal.measurement.zzhw zzhwVar, long j, boolean z) {
        String str;
        ye3 ye3Var;
        String str2;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        ye3 m7852a0 = zzj().m7852a0(zzhwVar.zzaF(), str);
        if (m7852a0 != null && (obj = m7852a0.f28932e) != null) {
            ye3Var = new ye3(zzhwVar.zzaF(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzaU().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        } else {
            ye3Var = new ye3(zzhwVar.zzaF(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzaU().currentTimeMillis(), Long.valueOf(j));
        }
        zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
        zze.zzf(str);
        zze.zzg(zzaU().currentTimeMillis());
        Object obj2 = ye3Var.f28932e;
        zze.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) zze.zzba();
        int m3680q = zzqa.m3680q(zzhwVar, str);
        if (m3680q >= 0) {
            zzhwVar.zzaC(m3680q, zzioVar);
        } else {
            zzhwVar.zzp(zzioVar);
        }
        if (j > 0) {
            zzj().m7834I(ye3Var);
            if (true != z) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzaW().zzj().zzc("Updated engagement user property. scope, value", str2, obj2);
        }
    }

    /* renamed from: w */
    public final void m3660w() {
        zzaX().zzg();
        if (!this.f14385q.isEmpty()) {
            if (this.f14366H == null) {
                this.f14366H = new pc3(this, this.f14380l, 2);
            }
            if (this.f14366H.f28111c == 0) {
                long max = Math.max(0L, ((Integer) zzgi.zzaA.zza(null)).intValue() - (zzaU().elapsedRealtime() - this.f14367I));
                zzaW().zzj().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
                if (this.f14366H == null) {
                    this.f14366H = new pc3(this, this.f14380l, 2);
                }
                this.f14366H.m8016c(max);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c3  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3661x() {
        boolean z;
        long max;
        long j;
        long j2;
        zzaX().zzg();
        m3644d();
        if (this.f14383o > 0) {
            long abs = 3600000 - Math.abs(zzaU().elapsedRealtime() - this.f14383o);
            if (abs > 0) {
                zzaW().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzq().m7476a();
                zzx().zza();
                return;
            }
            this.f14383o = 0L;
        }
        if (this.f14380l.zzM() && m3663z()) {
            long currentTimeMillis = zzaU().currentTimeMillis();
            zzi();
            long max2 = Math.max(0L, ((Long) zzgi.zzN.zza(null)).longValue());
            if (zzj().m7836L("select count(1) > 0 from raw_events where realtime = 1", null) != 0 || zzj().m7836L("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String zzo = zzi().zzo();
                if (!TextUtils.isEmpty(zzo) && !".none.".equals(zzo)) {
                    zzi();
                    max = Math.max(0L, ((Long) zzgi.zzI.zza(null)).longValue());
                } else {
                    zzi();
                    max = Math.max(0L, ((Long) zzgi.zzH.zza(null)).longValue());
                }
            } else {
                zzi();
                max = Math.max(0L, ((Long) zzgi.zzG.zza(null)).longValue());
            }
            long zza = this.f14377i.zzd.zza();
            long zza2 = this.f14377i.zze.zza();
            long j3 = max;
            long max3 = Math.max(zzj().m7837M("select max(bundle_end_timestamp) from queue", null, 0L), zzj().m7837M("select max(timestamp) from raw_events", null, 0L));
            if (max3 != 0) {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
                long j4 = max2 + abs2;
                long max4 = Math.max(abs3, abs4);
                if (z && max4 > 0) {
                    j4 = Math.min(abs2, max4) + j3;
                }
                if (!zzA().m3687G(max4, j3)) {
                    j4 = max4 + j3;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        zzi();
                        if (i >= Math.min(20, Math.max(0, ((Integer) zzgi.zzP.zza(null)).intValue()))) {
                            break;
                        }
                        zzi();
                        j4 += Math.max(0L, ((Long) zzgi.zzO.zza(null)).longValue()) * (1 << i);
                        if (j4 > abs4) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                j = j4;
                j2 = 0;
                if (j != j2) {
                    zzaW().zzj().zza("Next upload time is 0");
                    zzq().m7476a();
                    zzx().zza();
                    return;
                }
                if (zzp().zzd()) {
                    long zza3 = this.f14377i.zzc.zza();
                    zzi();
                    long max5 = Math.max(0L, ((Long) zzgi.zzE.zza(null)).longValue());
                    if (!zzA().m3687G(zza3, max5)) {
                        j = Math.max(j, zza3 + max5);
                    }
                    zzq().m7476a();
                    long currentTimeMillis2 = j - zzaU().currentTimeMillis();
                    if (currentTimeMillis2 <= 0) {
                        zzi();
                        currentTimeMillis2 = Math.max(0L, ((Long) zzgi.zzJ.zza(null)).longValue());
                        this.f14377i.zzd.zzb(zzaU().currentTimeMillis());
                    }
                    zzaW().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                    zzx().zzd(currentTimeMillis2);
                    return;
                }
                zzaW().zzj().zza("No network");
                tb3 zzq = zzq();
                zzpv zzpvVar = zzq.f26768a;
                zzpvVar.m3644d();
                zzpvVar.zzaX().zzg();
                if (!zzq.f26769b) {
                    zzpvVar.zzaT().registerReceiver(zzq, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    zzq.f26770c = zzpvVar.zzp().zzd();
                    zzpvVar.zzaW().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzq.f26770c));
                    zzq.f26769b = true;
                }
                zzx().zza();
                return;
            }
            j2 = 0;
            j = 0;
            if (j != j2) {
            }
        } else {
            zzaW().zzj().zza("Nothing to upload or uploading impossible");
            zzq().m7476a();
            zzx().zza();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:446:0x0dd8, code lost:
    
        if (r11 > (com.google.android.gms.measurement.internal.zzam.zzI() + r9)) goto L461;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03ec A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04b1 A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x055a A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0502 A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x09f8 A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0a41 A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0a6a A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0dca A[Catch: all -> 0x00fe, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0e4c A[Catch: all -> 0x00fe, TRY_LEAVE, TryCatch #10 {all -> 0x00fe, blocks: (B:3:0x0011, B:5:0x0028, B:7:0x0031, B:8:0x0047, B:11:0x005f, B:14:0x0085, B:16:0x00be, B:19:0x00d5, B:21:0x00df, B:24:0x0680, B:25:0x0113, B:27:0x0125, B:30:0x0135, B:32:0x013b, B:34:0x0179, B:36:0x0187, B:39:0x01a7, B:41:0x01ad, B:43:0x01bd, B:45:0x01cb, B:47:0x01db, B:49:0x01e8, B:54:0x01eb, B:57:0x0201, B:63:0x0233, B:66:0x023d, B:68:0x024b, B:70:0x0294, B:71:0x0268, B:73:0x0278, B:81:0x02a0, B:83:0x02cd, B:84:0x02f5, B:86:0x0326, B:87:0x032d, B:90:0x0339, B:92:0x036a, B:93:0x0385, B:95:0x038b, B:97:0x0399, B:99:0x03ae, B:100:0x03a2, B:106:0x03b4, B:109:0x03bb, B:110:0x03d3, B:112:0x03ec, B:113:0x03f8, B:116:0x0402, B:120:0x0427, B:121:0x0415, B:128:0x042e, B:130:0x043a, B:132:0x0446, B:136:0x048b, B:137:0x0463, B:140:0x0475, B:142:0x047b, B:144:0x0485, B:147:0x04a3, B:149:0x04b1, B:152:0x04c2, B:154:0x04d3, B:156:0x04df, B:158:0x0554, B:160:0x055a, B:161:0x0566, B:163:0x056c, B:165:0x057c, B:167:0x0586, B:168:0x0597, B:170:0x059d, B:171:0x05b6, B:173:0x05bc, B:175:0x05da, B:177:0x05e7, B:179:0x060e, B:180:0x05ee, B:182:0x05fa, B:184:0x0615, B:185:0x062d, B:187:0x0633, B:190:0x0646, B:195:0x0653, B:196:0x0657, B:198:0x065d, B:200:0x066b, B:207:0x0502, B:209:0x0512, B:212:0x0523, B:214:0x0534, B:216:0x0540, B:222:0x0141, B:224:0x014c, B:226:0x0158, B:228:0x015e, B:231:0x0169, B:237:0x0697, B:239:0x06a5, B:241:0x06ae, B:243:0x06e1, B:244:0x06b6, B:246:0x06c0, B:248:0x06c6, B:250:0x06d2, B:252:0x06da, B:255:0x06e3, B:256:0x06ef, B:259:0x06f7, B:262:0x0709, B:263:0x0714, B:265:0x071c, B:266:0x0741, B:268:0x075b, B:269:0x0770, B:271:0x078a, B:272:0x079f, B:273:0x07ad, B:275:0x07b3, B:277:0x07c3, B:278:0x07ca, B:280:0x07d6, B:282:0x07dd, B:285:0x07e0, B:287:0x0822, B:289:0x0828, B:290:0x084f, B:292:0x0857, B:293:0x0860, B:295:0x0866, B:296:0x086c, B:298:0x0881, B:300:0x0894, B:302:0x08a4, B:304:0x08ac, B:305:0x08af, B:307:0x08f0, B:308:0x0903, B:311:0x090b, B:314:0x0925, B:316:0x093e, B:318:0x0956, B:320:0x095b, B:322:0x095f, B:324:0x0963, B:326:0x096d, B:327:0x0973, B:329:0x0977, B:331:0x097d, B:332:0x0989, B:333:0x0992, B:335:0x0c31, B:336:0x09a0, B:417:0x09b6, B:339:0x09d2, B:341:0x09f8, B:342:0x0a00, B:344:0x0a06, B:348:0x0a18, B:353:0x0a41, B:355:0x0a6a, B:357:0x0a76, B:359:0x0a8a, B:360:0x0ac6, B:365:0x0ae0, B:367:0x0aeb, B:369:0x0aef, B:371:0x0af3, B:373:0x0af7, B:374:0x0b03, B:375:0x0b08, B:377:0x0b0e, B:379:0x0b24, B:380:0x0b29, B:384:0x0b70, B:386:0x0c2c, B:393:0x0b82, B:395:0x0b92, B:398:0x0ba9, B:400:0x0bd1, B:401:0x0bd8, B:404:0x0c11, B:411:0x0c1f, B:412:0x0b97, B:415:0x0a2c, B:421:0x09bd, B:423:0x0c40, B:425:0x0c50, B:426:0x0c56, B:427:0x0c5e, B:429:0x0c64, B:432:0x0c7f, B:434:0x0c8f, B:435:0x0d3a, B:437:0x0d40, B:439:0x0d55, B:442:0x0d5c, B:443:0x0d8b, B:445:0x0dca, B:447:0x0dfb, B:449:0x0dff, B:450:0x0e09, B:452:0x0e4c, B:454:0x0e59, B:456:0x0e68, B:460:0x0e80, B:463:0x0e99, B:464:0x0dda, B:465:0x0d64, B:467:0x0d70, B:468:0x0d74, B:469:0x0eb1, B:471:0x0ec2, B:472:0x0ee1, B:478:0x0ece, B:479:0x0ca8, B:481:0x0cae, B:486:0x0cbf, B:487:0x0cc6, B:495:0x0cdd, B:496:0x0ce4, B:500:0x0cf8, B:504:0x0d07, B:506:0x0d1e, B:507:0x0d25, B:508:0x0d22, B:515:0x0ce1, B:519:0x0cc3, B:524:0x0836, B:526:0x083c, B:528:0x0842, B:529:0x079c, B:530:0x076d, B:531:0x0721, B:533:0x0727, B:537:0x0ee9), top: B:2:0x0011, inners: #1, #5, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0e68 A[Catch: all -> 0x00fe, SQLiteException -> 0x0e7e, TRY_LEAVE, TryCatch #8 {SQLiteException -> 0x0e7e, blocks: (B:454:0x0e59, B:456:0x0e68), top: B:453:0x0e59, outer: #10 }] */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3662y(long j, String str) {
        Throwable th;
        boolean z;
        int i;
        int i2;
        zzio zzioVar;
        com.google.android.gms.internal.measurement.zzhw zzhwVar;
        zzio zzioVar2;
        se3 se3Var;
        v93 zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        long currentTimeMillis;
        long zzo;
        ContentValues contentValues;
        long parseLong;
        zzio zzioVar3;
        int m3544i;
        boolean z2;
        SecureRandom secureRandom;
        int i3;
        se3 se3Var2;
        zzhl zzhlVar;
        long zzt;
        ArrayList arrayList;
        int i4;
        Long l;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z3;
        String str6;
        int i5;
        int i6;
        int i7;
        int i8;
        String str7;
        String str8;
        int i9;
        String str9;
        String str10 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        String str11 = "_ai";
        String str12 = FirebaseAnalytics.Event.PURCHASE;
        String str13 = FirebaseAnalytics.Param.ITEMS;
        zzj().zzH();
        try {
            se3 se3Var3 = new se3(this);
            zzj().m7835J(str, j, this.f14359A, se3Var3);
            ArrayList arrayList2 = se3Var3.f26398c;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) se3Var3.f26396a.zzch();
                zzhwVar2.zzu();
                int i10 = -1;
                int i11 = 0;
                int i12 = 0;
                boolean z4 = false;
                int i13 = 0;
                zzhl zzhlVar2 = null;
                zzhl zzhlVar3 = null;
                int i14 = -1;
                while (true) {
                    int size = se3Var3.f26398c.size();
                    i = i13;
                    String str14 = "_e";
                    i2 = i12;
                    zzioVar = this.f14380l;
                    zzhwVar = zzhwVar2;
                    int i15 = i10;
                    if (i11 >= size) {
                        break;
                    }
                    zzhl zzhlVar4 = (zzhl) ((zzhm) se3Var3.f26398c.get(i11)).zzch();
                    int i16 = i11;
                    if (zzr().m3550o(se3Var3.f26396a.zzF(), zzhlVar4.zzo())) {
                        zzaW().zzk().zzc("Dropping blocked raw event. appId", zzhe.zzn(se3Var3.f26396a.zzF()), zzioVar.zzj().zzd(zzhlVar4.zzo()));
                        if (!str10.equals(zzr().zza(se3Var3.f26396a.zzF(), "measurement.upload.blacklist_internal")) && !str10.equals(zzr().zza(se3Var3.f26396a.zzF(), "measurement.upload.blacklist_public")) && !"_err".equals(zzhlVar4.zzo())) {
                            zzqf zzB = zzB();
                            ai2 ai2Var = this.f14368J;
                            String zzF = se3Var3.f26396a.zzF();
                            String zzo2 = zzhlVar4.zzo();
                            zzB.getClass();
                            zzqf.m3708m(ai2Var, zzF, 11, "_ev", zzo2, 0);
                        }
                        i13 = i;
                        str2 = str10;
                        str4 = str11;
                        str6 = str12;
                        i12 = i2;
                        zzhwVar2 = zzhwVar;
                        i7 = i16;
                    } else {
                        com.google.android.gms.internal.measurement.zzoy.zzb();
                        str2 = str10;
                        if (zzi().zzx(null, zzgi.zzbf)) {
                            String zzo3 = zzhlVar4.zzo();
                            str3 = str13;
                            if (zzo3.equals(str12) || zzo3.equals("_iap") || zzo3.equals("ecommerce_purchase")) {
                                com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze.zzj("_cbs");
                                if (!z4) {
                                    String zzF2 = se3Var3.f26396a.zzF();
                                    if (m3617A(zzF2, str12) && m3617A(zzF2, "_iap") && m3617A(zzF2, "ecommerce_purchase")) {
                                        str9 = "new_buyer";
                                        zze.zzk(str9);
                                        zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                        z4 = true;
                                    }
                                }
                                str9 = "returning_buyer";
                                zze.zzk(str9);
                                zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                z4 = true;
                            }
                        } else {
                            str3 = str13;
                        }
                        if (zzhlVar4.zzo().equals(zzjy.zza(str11))) {
                            zzhlVar4.zzi(str11);
                            zzaW().zzj().zza("Renaming ad_impression to _ai");
                            if (Log.isLoggable(zzaW().zzr(), 5)) {
                                for (int i17 = 0; i17 < zzhlVar4.zza(); i17++) {
                                    if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhlVar4.zzn(i17).zzg()) && !zzhlVar4.zzn(i17).zzh().isEmpty() && "admob".equalsIgnoreCase(zzhlVar4.zzn(i17).zzh())) {
                                        zzaW().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                }
                            }
                        }
                        boolean m3549n = zzr().m3549n(se3Var3.f26396a.zzF(), zzhlVar4.zzo());
                        if (!m3549n) {
                            zzA();
                            String zzo4 = zzhlVar4.zzo();
                            Preconditions.checkNotEmpty(zzo4);
                            str4 = str11;
                            if (zzo4.hashCode() != 95027 || !zzo4.equals("_ui")) {
                                str6 = str12;
                                z3 = z4;
                                str5 = "_e";
                                m3549n = false;
                                i13 = i;
                                if (m3549n) {
                                    ArrayList arrayList3 = new ArrayList(zzhlVar4.zzp());
                                    int i18 = -1;
                                    int i19 = -1;
                                    for (int i20 = 0; i20 < arrayList3.size(); i20++) {
                                        if ("value".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList3.get(i20)).zzg())) {
                                            i18 = i20;
                                        } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhq) arrayList3.get(i20)).zzg())) {
                                            i19 = i20;
                                        }
                                    }
                                    if (i18 != -1) {
                                        if (!((com.google.android.gms.internal.measurement.zzhq) arrayList3.get(i18)).zzw() && !((com.google.android.gms.internal.measurement.zzhq) arrayList3.get(i18)).zzu()) {
                                            zzaW().zzl().zza("Value must be specified with a numeric type.");
                                            zzhlVar4.zzh(i18);
                                            m3615p(zzhlVar4, "_c");
                                            m3614o(zzhlVar4, 18, "value");
                                        } else {
                                            if (i19 != -1) {
                                                String zzh = ((com.google.android.gms.internal.measurement.zzhq) arrayList3.get(i19)).zzh();
                                                if (zzh.length() == 3) {
                                                    int i21 = 0;
                                                    while (i21 < zzh.length()) {
                                                        int codePointAt = zzh.codePointAt(i21);
                                                        if (Character.isLetter(codePointAt)) {
                                                            i21 += Character.charCount(codePointAt);
                                                        }
                                                    }
                                                }
                                            }
                                            zzaW().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                            zzhlVar4.zzh(i18);
                                            m3615p(zzhlVar4, "_c");
                                            m3614o(zzhlVar4, 19, FirebaseAnalytics.Param.CURRENCY);
                                            break;
                                        }
                                    }
                                }
                                if (!str5.equals(zzhlVar4.zzo())) {
                                    zzA();
                                    if (zzqa.m3671f((zzhm) zzhlVar4.zzba(), "_fr") == null) {
                                        if (zzhlVar3 != null && Math.abs(zzhlVar3.zzc() - zzhlVar4.zzc()) <= 1000) {
                                            zzhl zzhlVar5 = (zzhl) zzhlVar3.clone();
                                            if (m3618B(zzhlVar4, zzhlVar5)) {
                                                int i22 = i14;
                                                zzhwVar2 = zzhwVar;
                                                zzhwVar2.zzad(i22, zzhlVar5);
                                                i14 = i22;
                                                i6 = i15;
                                                zzhlVar2 = null;
                                                zzhlVar3 = null;
                                                if (zzhlVar4.zza() == 0) {
                                                    zzA();
                                                    Bundle m3670e = zzqa.m3670e(zzhlVar4.zzp());
                                                    int i23 = 0;
                                                    while (i23 < zzhlVar4.zza()) {
                                                        com.google.android.gms.internal.measurement.zzhq zzn = zzhlVar4.zzn(i23);
                                                        String str15 = str3;
                                                        if (zzn.zzg().equals(str15) && !zzn.zzi().isEmpty()) {
                                                            String zzF3 = se3Var3.f26396a.zzF();
                                                            List zzi = zzn.zzi();
                                                            Parcelable[] parcelableArr = new Bundle[zzi.size()];
                                                            int i24 = 0;
                                                            while (i24 < zzi.size()) {
                                                                com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zzi.get(i24);
                                                                zzA();
                                                                Bundle m3670e2 = zzqa.m3670e(zzhqVar.zzi());
                                                                Iterator it = zzhqVar.zzi().iterator();
                                                                while (it.hasNext()) {
                                                                    m3632S(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) ((com.google.android.gms.internal.measurement.zzhq) it.next()).zzch(), m3670e2, zzF3);
                                                                    zzi = zzi;
                                                                    i6 = i6;
                                                                }
                                                                parcelableArr[i24] = m3670e2;
                                                                i24++;
                                                                zzi = zzi;
                                                                i6 = i6;
                                                            }
                                                            i8 = i6;
                                                            m3670e.putParcelableArray(str15, parcelableArr);
                                                        } else {
                                                            i8 = i6;
                                                            if (!zzn.zzg().equals(str15)) {
                                                                m3632S(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzn.zzch(), m3670e, se3Var3.f26396a.zzF());
                                                            }
                                                        }
                                                        i23++;
                                                        str3 = str15;
                                                        i6 = i8;
                                                    }
                                                    i15 = i6;
                                                    str13 = str3;
                                                    zzhlVar4.zzg();
                                                    zzqa zzA = zzA();
                                                    ArrayList arrayList4 = new ArrayList();
                                                    for (String str16 : m3670e.keySet()) {
                                                        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                                                        zze2.zzj(str16);
                                                        Object obj = m3670e.get(str16);
                                                        if (obj != null) {
                                                            zzA.m3685D(zze2, obj);
                                                            arrayList4.add((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                                                        }
                                                    }
                                                    Iterator it2 = arrayList4.iterator();
                                                    while (it2.hasNext()) {
                                                        zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) it2.next());
                                                    }
                                                } else {
                                                    i15 = i6;
                                                    str13 = str3;
                                                }
                                                i7 = i16;
                                                se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                                zzhwVar2.zzn(zzhlVar4);
                                                i12 = i2 + 1;
                                                z4 = z3;
                                            }
                                        }
                                        zzhwVar2 = zzhwVar;
                                        zzhlVar2 = zzhlVar4;
                                        i14 = i14;
                                        i6 = i2;
                                        if (zzhlVar4.zza() == 0) {
                                        }
                                        i7 = i16;
                                        se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                        zzhwVar2.zzn(zzhlVar4);
                                        i12 = i2 + 1;
                                        z4 = z3;
                                    } else {
                                        i5 = i14;
                                        zzhwVar2 = zzhwVar;
                                        i14 = i5;
                                        i6 = i15;
                                        if (zzhlVar4.zza() == 0) {
                                        }
                                        i7 = i16;
                                        se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                        zzhwVar2.zzn(zzhlVar4);
                                        i12 = i2 + 1;
                                        z4 = z3;
                                    }
                                } else {
                                    i5 = i14;
                                    zzhwVar2 = zzhwVar;
                                    if ("_vs".equals(zzhlVar4.zzo())) {
                                        zzA();
                                        if (zzqa.m3671f((zzhm) zzhlVar4.zzba(), "_et") == null) {
                                            if (zzhlVar2 != null && Math.abs(zzhlVar2.zzc() - zzhlVar4.zzc()) <= 1000) {
                                                zzhl zzhlVar6 = (zzhl) zzhlVar2.clone();
                                                if (m3618B(zzhlVar6, zzhlVar4)) {
                                                    zzhwVar2.zzad(i15, zzhlVar6);
                                                    i14 = i5;
                                                    i6 = i15;
                                                    zzhlVar2 = null;
                                                    zzhlVar3 = null;
                                                    if (zzhlVar4.zza() == 0) {
                                                    }
                                                    i7 = i16;
                                                    se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                                    zzhwVar2.zzn(zzhlVar4);
                                                    i12 = i2 + 1;
                                                    z4 = z3;
                                                }
                                            }
                                            zzhlVar3 = zzhlVar4;
                                            i6 = i15;
                                            i14 = i2;
                                            if (zzhlVar4.zza() == 0) {
                                            }
                                            i7 = i16;
                                            se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                            zzhwVar2.zzn(zzhlVar4);
                                            i12 = i2 + 1;
                                            z4 = z3;
                                        }
                                    }
                                    i14 = i5;
                                    i6 = i15;
                                    if (zzhlVar4.zza() == 0) {
                                    }
                                    i7 = i16;
                                    se3Var3.f26398c.set(i7, (zzhm) zzhlVar4.zzba());
                                    zzhwVar2.zzn(zzhlVar4);
                                    i12 = i2 + 1;
                                    z4 = z3;
                                }
                            }
                        } else {
                            str4 = str11;
                        }
                        str6 = str12;
                        int i25 = 0;
                        boolean z5 = false;
                        boolean z6 = false;
                        while (true) {
                            z3 = z4;
                            if (i25 >= zzhlVar4.zza()) {
                                break;
                            }
                            if ("_c".equals(zzhlVar4.zzn(i25).zzg())) {
                                com.google.android.gms.internal.measurement.zzhp zzhpVar = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i25).zzch();
                                str8 = str14;
                                zzhpVar.zzi(1L);
                                zzhlVar4.zzk(i25, (com.google.android.gms.internal.measurement.zzhq) zzhpVar.zzba());
                                i9 = 1;
                                z5 = true;
                            } else {
                                str8 = str14;
                                if ("_r".equals(zzhlVar4.zzn(i25).zzg())) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar2 = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i25).zzch();
                                    zzhpVar2.zzi(1L);
                                    zzhlVar4.zzk(i25, (com.google.android.gms.internal.measurement.zzhq) zzhpVar2.zzba());
                                    i9 = 1;
                                    z6 = true;
                                } else {
                                    i9 = 1;
                                }
                            }
                            i25 += i9;
                            z4 = z3;
                            str14 = str8;
                        }
                        str5 = str14;
                        if (z5 || !m3549n) {
                            str7 = "_err";
                        } else {
                            zzaW().zzj().zzb("Marking event as conversion", zzioVar.zzj().zzd(zzhlVar4.zzo()));
                            com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze3.zzj("_c");
                            str7 = "_err";
                            zze3.zzi(1L);
                            zzhlVar4.zze(zze3);
                        }
                        if (!z6) {
                            zzaW().zzj().zzb("Marking event as real-time", zzioVar.zzj().zzd(zzhlVar4.zzo()));
                            com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze4.zzj("_r");
                            zze4.zzi(1L);
                            zzhlVar4.zze(zze4);
                        }
                        if (zzj().m7845U(m3654n(), se3Var3.f26396a.zzF(), false, true, false, false).f14129e > zzi().zzh(se3Var3.f26396a.zzF(), zzgi.zzo)) {
                            m3615p(zzhlVar4, "_r");
                            i13 = i;
                        } else {
                            i13 = 1;
                        }
                        if (zzqf.m3700F(zzhlVar4.zzo()) && m3549n && zzj().m7845U(m3654n(), se3Var3.f26396a.zzF(), true, false, false, false).f14127c > zzi().zzh(se3Var3.f26396a.zzF(), zzgi.zzn)) {
                            zzaW().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzhe.zzn(se3Var3.f26396a.zzF()));
                            boolean z7 = false;
                            com.google.android.gms.internal.measurement.zzhp zzhpVar3 = null;
                            int i26 = -1;
                            for (int i27 = 0; i27 < zzhlVar4.zza(); i27++) {
                                com.google.android.gms.internal.measurement.zzhq zzn2 = zzhlVar4.zzn(i27);
                                if ("_c".equals(zzn2.zzg())) {
                                    zzhpVar3 = (com.google.android.gms.internal.measurement.zzhp) zzn2.zzch();
                                    i26 = i27;
                                } else if (str7.equals(zzn2.zzg())) {
                                    z7 = true;
                                }
                            }
                            if (z7) {
                                if (zzhpVar3 != null) {
                                    zzhlVar4.zzh(i26);
                                } else {
                                    zzhpVar3 = null;
                                }
                            }
                            if (zzhpVar3 != null) {
                                com.google.android.gms.internal.measurement.zzhp zzhpVar4 = (com.google.android.gms.internal.measurement.zzhp) zzhpVar3.clone();
                                zzhpVar4.zzj(str7);
                                zzhpVar4.zzi(10L);
                                zzhlVar4.zzk(i26, (com.google.android.gms.internal.measurement.zzhq) zzhpVar4.zzba());
                            } else {
                                zzaW().zze().zzb("Did not find conversion parameter. appId", zzhe.zzn(se3Var3.f26396a.zzF()));
                            }
                        }
                        if (m3549n) {
                        }
                        if (!str5.equals(zzhlVar4.zzo())) {
                        }
                    }
                    i11 = i7 + 1;
                    i10 = i15;
                    str10 = str2;
                    str11 = str4;
                    str12 = str6;
                }
                com.google.android.gms.internal.measurement.zzhw zzhwVar3 = zzhwVar;
                long j2 = 0;
                int i28 = i2;
                int i29 = 0;
                while (i29 < i28) {
                    zzhm zzh2 = zzhwVar3.zzh(i29);
                    if ("_e".equals(zzh2.zzh())) {
                        zzA();
                        if (zzqa.m3671f(zzh2, "_fr") != null) {
                            zzhwVar3.zzD(i29);
                            i28--;
                            i29--;
                            i29++;
                        }
                    }
                    zzA();
                    com.google.android.gms.internal.measurement.zzhq m3671f = zzqa.m3671f(zzh2, "_et");
                    if (m3671f != null) {
                        if (m3671f.zzw()) {
                            l = Long.valueOf(m3671f.zzd());
                        } else {
                            l = null;
                        }
                        if (l != null && l.longValue() > 0) {
                            j2 += l.longValue();
                        }
                    }
                    i29++;
                }
                m3659v(zzhwVar3, j2, false);
                Iterator it3 = zzhwVar3.zzaM().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if ("_s".equals(((zzhm) it3.next()).zzh())) {
                        zzj().m7866n(zzhwVar3.zzaF(), "_se");
                        break;
                    }
                }
                if (zzqa.m3680q(zzhwVar3, "_sid") >= 0) {
                    m3659v(zzhwVar3, j2, true);
                } else {
                    int m3680q = zzqa.m3680q(zzhwVar3, "_se");
                    if (m3680q >= 0) {
                        zzhwVar3.zzE(m3680q);
                        zzaW().zze().zzb("Session engagement user property is in the bundle without session ID. appId", zzhe.zzn(se3Var3.f26396a.zzF()));
                    }
                }
                String zzF4 = se3Var3.f26396a.zzF();
                zzaX().zzg();
                m3644d();
                ob3 m7842R = zzj().m7842R(zzF4);
                if (m7842R == null) {
                    zzaW().zze().zzb("Cannot fix consent fields without appInfo. appId", zzhe.zzn(zzF4));
                } else {
                    m3647g(m7842R, zzhwVar3);
                }
                String zzF5 = se3Var3.f26396a.zzF();
                zzaX().zzg();
                m3644d();
                ob3 m7842R2 = zzj().m7842R(zzF5);
                if (m7842R2 == null) {
                    zzaW().zzk().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzhe.zzn(zzF5));
                } else {
                    m3619F(m7842R2, zzhwVar3);
                }
                zzhwVar3.zzax(Long.MAX_VALUE);
                zzhwVar3.zzab(Long.MIN_VALUE);
                for (int i30 = 0; i30 < zzhwVar3.zzc(); i30++) {
                    zzhm zzh3 = zzhwVar3.zzh(i30);
                    if (zzh3.zzd() < zzhwVar3.zzf()) {
                        zzhwVar3.zzax(zzh3.zzd());
                    }
                    if (zzh3.zzd() > zzhwVar3.zze()) {
                        zzhwVar3.zzab(zzh3.zzd());
                    }
                }
                zzhwVar3.zzB();
                zzjx zzjxVar = zzjx.zza;
                zzjx zzl = m3641a0(se3Var3.f26396a.zzF()).zzl(zzjx.zzk(se3Var3.f26396a.zzK(), 100));
                zzjx m7848X = zzj().m7848X(se3Var3.f26396a.zzF());
                zzj().m7870r(se3Var3.f26396a.zzF(), zzl);
                zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                if (!zzl.zzr(zzjwVar) && m7848X.zzr(zzjwVar)) {
                    zzj().m7860h(se3Var3.f26396a.zzF());
                } else if (zzl.zzr(zzjwVar) && !m7848X.zzr(zzjwVar)) {
                    zzj().m7867o(se3Var3.f26396a.zzF());
                }
                zzjw zzjwVar2 = zzjw.AD_STORAGE;
                if (!zzl.zzr(zzjwVar2)) {
                    zzhwVar3.zzz();
                    zzhwVar3.zzw();
                    zzhwVar3.zzt();
                }
                if (!zzl.zzr(zzjwVar)) {
                    zzhwVar3.zzq();
                    zzhwVar3.zzA();
                }
                zzqr.zzb();
                if (zzi().zzx(se3Var3.f26396a.zzF(), zzgi.zzaV)) {
                    zzqf zzB2 = zzB();
                    String zzF6 = se3Var3.f26396a.zzF();
                    zzB2.getClass();
                    if (zzqf.m3710t(zzF6) && m3641a0(se3Var3.f26396a.zzF()).zzr(zzjwVar2) && se3Var3.f26396a.zzbt()) {
                        m3648h(zzhwVar3, se3Var3);
                    }
                }
                zzhwVar3.zzr();
                zzhwVar3.zzi(zzh().m5910a(zzhwVar3.zzaF(), zzhwVar3.zzaM(), zzhwVar3.zzaN(), Long.valueOf(zzhwVar3.zzf()), Long.valueOf(zzhwVar3.zze()), !zzl.zzr(zzjwVar)));
                if (zzi().zzB(se3Var3.f26396a.zzF())) {
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList5 = new ArrayList();
                    SecureRandom m3727g = zzB().m3727g();
                    int i31 = 0;
                    while (i31 < zzhwVar3.zzc()) {
                        zzhl zzhlVar7 = (zzhl) zzhwVar3.zzh(i31).zzch();
                        if (zzhlVar7.zzo().equals("_ep")) {
                            zzA();
                            String str17 = (String) zzqa.m3672g((zzhm) zzhlVar7.zzba(), "_en");
                            da3 da3Var = (da3) hashMap.get(str17);
                            if (da3Var == null && (da3Var = zzj().m7875w("events", se3Var3.f26396a.zzF(), (String) Preconditions.checkNotNull(str17))) != null) {
                                hashMap.put(str17, da3Var);
                            }
                            if (da3Var != null && da3Var.f16322i == null) {
                                Long l2 = da3Var.f16323j;
                                if (l2 != null && l2.longValue() > 1) {
                                    zzA();
                                    zzqa.m3669d(zzhlVar7, "_sr", l2);
                                }
                                Boolean bool = da3Var.f16324k;
                                if (bool != null && bool.booleanValue()) {
                                    zzA();
                                    zzqa.m3669d(zzhlVar7, "_efs", 1L);
                                }
                                arrayList5.add((zzhm) zzhlVar7.zzba());
                            }
                            zzhwVar3.zzad(i31, zzhlVar7);
                            arrayList = arrayList5;
                            secureRandom = m3727g;
                            i4 = i31;
                            se3Var2 = se3Var3;
                            zzioVar3 = zzioVar;
                        } else {
                            zzif zzr = zzr();
                            String zzF7 = se3Var3.f26396a.zzF();
                            String zza = zzr.zza(zzF7, "measurement.account.time_zone_offset_minutes");
                            if (!TextUtils.isEmpty(zza)) {
                                try {
                                    parseLong = Long.parseLong(zza);
                                } catch (NumberFormatException e) {
                                    zzr.zzu.zzaW().zzk().zzc("Unable to parse timezone offset. appId", zzhe.zzn(zzF7), e);
                                }
                                zzioVar3 = zzioVar;
                                long zzt2 = zzB().zzt(zzhlVar7.zzc(), parseLong);
                                zzhm zzhmVar = (zzhm) zzhlVar7.zzba();
                                Long l3 = 1L;
                                long j3 = parseLong;
                                if (!TextUtils.isEmpty("_dbg")) {
                                    Iterator it4 = zzhmVar.zzi().iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) it4.next();
                                        Iterator it5 = it4;
                                        if ("_dbg".equals(zzhqVar2.zzg())) {
                                            if (l3.equals(Long.valueOf(zzhqVar2.zzd()))) {
                                                m3544i = 1;
                                            }
                                        } else {
                                            it4 = it5;
                                        }
                                    }
                                }
                                m3544i = zzr().m3544i(se3Var3.f26396a.zzF(), zzhlVar7.zzo());
                                if (m3544i > 0) {
                                    zzaW().zzk().zzc("Sample rate must be positive. event, rate", zzhlVar7.zzo(), Integer.valueOf(m3544i));
                                    arrayList5.add((zzhm) zzhlVar7.zzba());
                                    zzhwVar3.zzad(i31, zzhlVar7);
                                } else {
                                    da3 da3Var2 = (da3) hashMap.get(zzhlVar7.zzo());
                                    if (da3Var2 == null && (da3Var2 = zzj().m7875w("events", se3Var3.f26396a.zzF(), zzhlVar7.zzo())) == null) {
                                        zzaW().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", se3Var3.f26396a.zzF(), zzhlVar7.zzo());
                                        da3Var2 = new da3(se3Var3.f26396a.zzF(), zzhlVar7.zzo(), 1L, 1L, 1L, zzhlVar7.zzc(), 0L, null, null, null, null);
                                    }
                                    zzA();
                                    Long l4 = (Long) zzqa.m3672g((zzhm) zzhlVar7.zzba(), "_eid");
                                    if (l4 != null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (m3544i == 1) {
                                        arrayList5.add((zzhm) zzhlVar7.zzba());
                                        if (z2 && (da3Var2.f16322i != null || da3Var2.f16323j != null || da3Var2.f16324k != null)) {
                                            hashMap.put(zzhlVar7.zzo(), da3Var2.m4566a(null, null, null));
                                        }
                                        zzhwVar3.zzad(i31, zzhlVar7);
                                    } else {
                                        if (m3727g.nextInt(m3544i) == 0) {
                                            zzA();
                                            Long valueOf = Long.valueOf(m3544i);
                                            zzqa.m3669d(zzhlVar7, "_sr", valueOf);
                                            arrayList5.add((zzhm) zzhlVar7.zzba());
                                            if (z2) {
                                                da3Var2 = da3Var2.m4566a(null, valueOf, null);
                                            }
                                            try {
                                                secureRandom = m3727g;
                                                se3Var2 = se3Var3;
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar4 = zzhwVar3;
                                                ArrayList arrayList6 = arrayList5;
                                                i3 = i31;
                                                zzhlVar = zzhlVar7;
                                                hashMap = hashMap;
                                                hashMap.put(zzhlVar7.zzo(), new da3(da3Var2.f16314a, da3Var2.f16315b, da3Var2.f16316c, da3Var2.f16317d, da3Var2.f16318e, da3Var2.f16319f, zzhlVar7.zzc(), Long.valueOf(zzt2), da3Var2.f16322i, da3Var2.f16323j, da3Var2.f16324k));
                                                zzhwVar3 = zzhwVar4;
                                                arrayList = arrayList6;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                zzj().m7863k();
                                                throw th;
                                            }
                                        } else {
                                            ArrayList arrayList7 = arrayList5;
                                            secureRandom = m3727g;
                                            i3 = i31;
                                            se3Var2 = se3Var3;
                                            com.google.android.gms.internal.measurement.zzhw zzhwVar5 = zzhwVar3;
                                            zzhlVar = zzhlVar7;
                                            Long l5 = da3Var2.f16321h;
                                            if (l5 != null) {
                                                zzt = l5.longValue();
                                            } else {
                                                zzt = zzB().zzt(zzhlVar.zzb(), j3);
                                            }
                                            if (zzt != zzt2) {
                                                zzA();
                                                zzqa.m3669d(zzhlVar, "_efs", 1L);
                                                zzA();
                                                Long valueOf2 = Long.valueOf(m3544i);
                                                zzqa.m3669d(zzhlVar, "_sr", valueOf2);
                                                arrayList = arrayList7;
                                                arrayList.add((zzhm) zzhlVar.zzba());
                                                if (z2) {
                                                    da3Var2 = da3Var2.m4566a(null, valueOf2, Boolean.TRUE);
                                                }
                                                String zzo5 = zzhlVar.zzo();
                                                long zzc = zzhlVar.zzc();
                                                try {
                                                    zzhlVar = zzhlVar;
                                                    hashMap.put(zzo5, new da3(da3Var2.f16314a, da3Var2.f16315b, da3Var2.f16316c, da3Var2.f16317d, da3Var2.f16318e, da3Var2.f16319f, zzc, Long.valueOf(zzt2), da3Var2.f16322i, da3Var2.f16323j, da3Var2.f16324k));
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    th = th;
                                                    zzj().m7863k();
                                                    throw th;
                                                }
                                            } else {
                                                arrayList = arrayList7;
                                                if (z2) {
                                                    hashMap.put(zzhlVar.zzo(), da3Var2.m4566a(l4, null, null));
                                                }
                                            }
                                            zzhwVar3 = zzhwVar5;
                                        }
                                        i4 = i3;
                                        zzhwVar3.zzad(i4, zzhlVar);
                                    }
                                }
                                arrayList = arrayList5;
                                secureRandom = m3727g;
                                i4 = i31;
                                se3Var2 = se3Var3;
                            }
                            parseLong = 0;
                            zzioVar3 = zzioVar;
                            long zzt22 = zzB().zzt(zzhlVar7.zzc(), parseLong);
                            zzhm zzhmVar2 = (zzhm) zzhlVar7.zzba();
                            Long l32 = 1L;
                            long j32 = parseLong;
                            if (!TextUtils.isEmpty("_dbg")) {
                            }
                            m3544i = zzr().m3544i(se3Var3.f26396a.zzF(), zzhlVar7.zzo());
                            if (m3544i > 0) {
                            }
                            arrayList = arrayList5;
                            secureRandom = m3727g;
                            i4 = i31;
                            se3Var2 = se3Var3;
                        }
                        i31 = i4 + 1;
                        arrayList5 = arrayList;
                        zzioVar = zzioVar3;
                        m3727g = secureRandom;
                        se3Var3 = se3Var2;
                    }
                    ArrayList arrayList8 = arrayList5;
                    se3 se3Var4 = se3Var3;
                    zzioVar2 = zzioVar;
                    z = true;
                    if (arrayList8.size() < zzhwVar3.zzc()) {
                        zzhwVar3.zzu();
                        zzhwVar3.zzj(arrayList8);
                    }
                    Iterator it6 = hashMap.entrySet().iterator();
                    while (it6.hasNext()) {
                        zzj().m7828B("events", (da3) ((Map.Entry) it6.next()).getValue());
                    }
                    se3Var = se3Var4;
                } else {
                    zzioVar2 = zzioVar;
                    z = true;
                    se3Var = se3Var3;
                }
                String zzF8 = se3Var.f26396a.zzF();
                ob3 m7842R3 = zzj().m7842R(zzF8);
                if (m7842R3 == null) {
                    zzaW().zze().zzb("Bundling raw events w/o app info. appId", zzhe.zzn(se3Var.f26396a.zzF()));
                } else if (zzhwVar3.zzc() > 0) {
                    try {
                        m7842R3.f23733a.zzaX().zzg();
                        long j4 = m7842R3.f23741i;
                        if (j4 != 0) {
                            zzhwVar3.zzap(j4);
                        } else {
                            zzhwVar3.zzx();
                        }
                        try {
                            m7842R3.f23733a.zzaX().zzg();
                            long j5 = m7842R3.f23740h;
                            if (j5 != 0) {
                                j4 = j5;
                            }
                            if (j4 != 0) {
                                zzhwVar3.zzaq(j4);
                            } else {
                                zzhwVar3.zzy();
                            }
                            m7842R3.m6542i(zzhwVar3.zzc());
                            try {
                                m7842R3.f23733a.zzaX().zzg();
                                zzhwVar3.zzV((int) m7842R3.f23719G);
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    try {
                        m7842R3.f23733a.zzaX().zzg();
                        zzhwVar3.zzP((int) m7842R3.f23739g);
                        m7842R3.m6528B(zzhwVar3.zzf());
                        m7842R3.m6559z(zzhwVar3.zze());
                        String m6535b = m7842R3.m6535b();
                        if (m6535b != null) {
                            zzhwVar3.zzaj(m6535b);
                        } else {
                            zzhwVar3.zzv();
                        }
                        zzj().m7869q(m7842R3, false);
                    } catch (Throwable th7) {
                        th = th7;
                        th = th;
                        zzj().m7863k();
                        throw th;
                    }
                }
                if (zzhwVar3.zzc() > 0) {
                    zzioVar2.zzaV();
                    com.google.android.gms.internal.measurement.zzgo zzj2 = zzr().zzj(se3Var.f26396a.zzF());
                    try {
                        try {
                            if (zzj2 != null && zzj2.zzw()) {
                                zzhwVar3.zzR(zzj2.zzc());
                                zzj = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar3.zzba();
                                zzj.zzg();
                                zzj.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                Preconditions.checkState(zzhxVar.zzbK());
                                zzj.zzO();
                                zzio zzioVar4 = zzj.zzu;
                                currentTimeMillis = zzioVar4.zzaU().currentTimeMillis();
                                zzo = zzhxVar.zzo();
                                zzioVar4.zzf();
                                if (zzo >= currentTimeMillis - zzam.zzI()) {
                                    long zzo6 = zzhxVar.zzo();
                                    zzioVar4.zzf();
                                }
                                zzioVar4.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                                byte[] m3688b = zzj.zzg.zzA().m3688b(zzhxVar.zzcd());
                                zzio zzioVar5 = zzj.zzu;
                                zzioVar5.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(m3688b.length));
                                contentValues = new ContentValues();
                                contentValues.put("app_id", zzhxVar.zzF());
                                contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                                contentValues.put(DataSchemeDataSource.SCHEME_DATA, m3688b);
                                contentValues.put("has_realtime", Integer.valueOf(i));
                                if (zzhxVar.zzbR()) {
                                    contentValues.put("retry_count", Integer.valueOf(zzhxVar.zzg()));
                                }
                                if (zzj.m7841Q().insert("queue", null, contentValues) == -1) {
                                    zzioVar5.zzaW().zze().zzb("Failed to insert bundle (got -1). appId", zzhe.zzn(zzhxVar.zzF()));
                                }
                            }
                            if (zzj.m7841Q().insert("queue", null, contentValues) == -1) {
                            }
                        } catch (SQLiteException e2) {
                            zzj.zzu.zzaW().zze().zzc("Error storing bundle. appId", zzhe.zzn(zzhxVar.zzF()), e2);
                        }
                        byte[] m3688b2 = zzj.zzg.zzA().m3688b(zzhxVar.zzcd());
                        zzio zzioVar52 = zzj.zzu;
                        zzioVar52.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(m3688b2.length));
                        contentValues = new ContentValues();
                        contentValues.put("app_id", zzhxVar.zzF());
                        contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                        contentValues.put(DataSchemeDataSource.SCHEME_DATA, m3688b2);
                        contentValues.put("has_realtime", Integer.valueOf(i));
                        if (zzhxVar.zzbR()) {
                        }
                    } catch (IOException e3) {
                        zzj.zzu.zzaW().zze().zzc("Data loss. Failed to serialize bundle. appId", zzhe.zzn(zzhxVar.zzF()), e3);
                    }
                    if (se3Var.f26396a.zzP().isEmpty()) {
                        zzhwVar3.zzR(-1L);
                    } else {
                        zzaW().zzk().zzb("Did not find measurement config or missing version info. appId", zzhe.zzn(se3Var.f26396a.zzF()));
                    }
                    zzj = zzj();
                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar3.zzba();
                    zzj.zzg();
                    zzj.zzav();
                    Preconditions.checkNotNull(zzhxVar);
                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                    Preconditions.checkState(zzhxVar.zzbK());
                    zzj.zzO();
                    zzio zzioVar42 = zzj.zzu;
                    currentTimeMillis = zzioVar42.zzaU().currentTimeMillis();
                    zzo = zzhxVar.zzo();
                    zzioVar42.zzf();
                    if (zzo >= currentTimeMillis - zzam.zzI()) {
                    }
                    zzioVar42.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                }
                zzj().m7861i(se3Var.f26397b);
                v93 zzj3 = zzj();
                try {
                    zzj3.m7841Q().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzF8, zzF8});
                } catch (SQLiteException e4) {
                    zzj3.zzu.zzaW().zze().zzc("Failed to remove unused event metadata. appId", zzhe.zzn(zzF8), e4);
                }
                zzj().m7868p();
            } else {
                zzj().m7868p();
                z = false;
            }
            zzj().m7863k();
            return z;
        } catch (Throwable th8) {
            th = th8;
            zzj().m7863k();
            throw th;
        }
    }

    /* renamed from: z */
    public final boolean m3663z() {
        zzaX().zzg();
        m3644d();
        if (zzj().m7836L("select count(1) > 0 from raw_events", null) != 0 || !TextUtils.isEmpty(zzj().m7851a())) {
            return true;
        }
        return false;
    }

    public final zzqa zzA() {
        zzqa zzqaVar = this.f14375g;
        m3612D(zzqaVar);
        return zzqaVar;
    }

    public final zzqf zzB() {
        return ((zzio) Preconditions.checkNotNull(this.f14380l)).zzw();
    }

    @Override // p000.hc3
    public final Context zzaT() {
        return this.f14380l.zzaT();
    }

    @Override // p000.hc3
    public final Clock zzaU() {
        return ((zzio) Preconditions.checkNotNull(this.f14380l)).zzaU();
    }

    @Override // p000.hc3
    public final zzaf zzaV() {
        return this.f14380l.zzaV();
    }

    @Override // p000.hc3
    public final zzhe zzaW() {
        return ((zzio) Preconditions.checkNotNull(this.f14380l)).zzaW();
    }

    @Override // p000.hc3
    public final zzil zzaX() {
        return ((zzio) Preconditions.checkNotNull(this.f14380l)).zzaX();
    }

    @WorkerThread
    public final void zzaj(String str, zzmh zzmhVar) {
        zzaX().zzg();
        String str2 = this.f14365G;
        if (str2 != null && !str2.equals(str) && zzmhVar == null) {
            return;
        }
        this.f14365G = str;
        this.f14364F = zzmhVar;
    }

    @WorkerThread
    public final void zzam() {
        zzaX().zzg();
        zzj().zzO();
        v93 zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        if (zzj.m7831F()) {
            zzgg zzggVar = zzgi.zzau;
            if (((Long) zzggVar.zza(null)).longValue() != 0) {
                SQLiteDatabase m7841Q = zzj.m7841Q();
                zzio zzioVar = zzj.zzu;
                int delete = m7841Q.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzioVar.zzaU().currentTimeMillis()), String.valueOf(zzggVar.zza(null))});
                if (delete > 0) {
                    zzioVar.zzaW().zzj().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.f14377i.zzd.zza() == 0) {
            this.f14377i.zzd.zzb(zzaU().currentTimeMillis());
        }
        m3661x();
    }

    public final l93 zzh() {
        l93 l93Var = this.f14374f;
        m3612D(l93Var);
        return l93Var;
    }

    public final zzam zzi() {
        return ((zzio) Preconditions.checkNotNull(this.f14380l)).zzf();
    }

    public final v93 zzj() {
        v93 v93Var = this.f14371c;
        m3612D(v93Var);
        return v93Var;
    }

    public final zzgx zzo() {
        return this.f14380l.zzj();
    }

    public final zzhk zzp() {
        zzhk zzhkVar = this.f14370b;
        m3612D(zzhkVar);
        return zzhkVar;
    }

    public final tb3 zzq() {
        tb3 tb3Var = this.f14372d;
        if (tb3Var != null) {
            return tb3Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzif zzr() {
        zzif zzifVar = this.f14369a;
        m3612D(zzifVar);
        return zzifVar;
    }

    public final gd3 zzv() {
        gd3 gd3Var = this.f14376h;
        m3612D(gd3Var);
        return gd3Var;
    }

    public final zzoa zzw() {
        return this.f14377i;
    }

    public final zzoy zzx() {
        zzoy zzoyVar = this.f14373e;
        m3612D(zzoyVar);
        return zzoyVar;
    }

    public final zzpi zzy() {
        return this.f14378j;
    }
}
