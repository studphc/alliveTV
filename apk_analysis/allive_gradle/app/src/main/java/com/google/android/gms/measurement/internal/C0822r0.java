package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000.l93;
import p000.v93;

/* renamed from: com.google.android.gms.measurement.internal.r0 */
/* loaded from: classes.dex */
public final class C0822r0 {

    /* renamed from: a */
    public zzhm f14085a;

    /* renamed from: b */
    public Long f14086b;

    /* renamed from: c */
    public long f14087c;

    /* renamed from: d */
    public final /* synthetic */ l93 f14088d;

    public /* synthetic */ C0822r0(l93 l93Var) {
        this.f14088d = l93Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
    
        if (r7 == null) goto L35;
     */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00df: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:224), block:B:71:0x00df */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzhm m3504a(zzhm zzhmVar, String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Pair pair;
        Object obj;
        String zzh = zzhmVar.zzh();
        List zzi = zzhmVar.zzi();
        l93 l93Var = this.f14088d;
        zzpv zzpvVar = l93Var.zzg;
        zzpvVar.zzA();
        Long l = (Long) zzqa.m3672g(zzhmVar, "_eid");
        if (l != null) {
            if (zzh.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpvVar.zzA();
                String str2 = (String) zzqa.m3672g(zzhmVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    l93Var.zzu.zzaW().zzh().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.f14085a == null || this.f14086b == null || l.longValue() != this.f14086b.longValue()) {
                    v93 zzj = zzpvVar.zzj();
                    zzj.zzg();
                    zzj.zzav();
                    try {
                        try {
                            cursor2 = zzj.m7841Q().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                            try {
                                if (!cursor2.moveToFirst()) {
                                    zzj.zzu.zzaW().zzj().zza("Main event not found");
                                    cursor2.close();
                                    pair = null;
                                } else {
                                    try {
                                        pair = Pair.create((zzhm) ((zzhl) zzqa.m3683x(zzhm.zze(), cursor2.getBlob(0))).zzba(), Long.valueOf(cursor2.getLong(1)));
                                        cursor2.close();
                                    } catch (IOException e) {
                                        zzj.zzu.zzaW().zze().zzd("Failed to merge main event. appId, eventId", zzhe.zzn(str), l, e);
                                        cursor2.close();
                                        pair = null;
                                        if (pair == null) {
                                        }
                                        l93Var.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                                        return null;
                                    }
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzj.zzu.zzaW().zze().zzb("Error selecting main event", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor3;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                    if (pair == null && (obj = pair.first) != null) {
                        this.f14085a = (zzhm) obj;
                        this.f14087c = ((Long) pair.second).longValue();
                        l93Var.zzg.zzA();
                        this.f14086b = (Long) zzqa.m3672g(this.f14085a, "_eid");
                    } else {
                        l93Var.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return null;
                    }
                }
                long j = this.f14087c - 1;
                this.f14087c = j;
                if (j <= 0) {
                    v93 zzj2 = l93Var.zzg.zzj();
                    zzj2.zzg();
                    zzj2.zzu.zzaW().zzj().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzj2.m7841Q().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e4) {
                        zzj2.zzu.zzaW().zze().zzb("Error clearing complex main event", e4);
                    }
                } else {
                    l93Var.zzg.zzj().m7832G(str, l, this.f14087c, this.f14085a);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : this.f14085a.zzi()) {
                    l93Var.zzg.zzA();
                    if (zzqa.m3671f(zzhmVar, zzhqVar.zzg()) == null) {
                        arrayList.add(zzhqVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    arrayList.addAll(zzi);
                    zzi = arrayList;
                } else {
                    l93Var.zzu.zzaW().zzh().zzb("No unique parameters in main event. eventName", str2);
                }
                zzh = str2;
            } else {
                this.f14086b = l;
                this.f14085a = zzhmVar;
                zzpvVar.zzA();
                Object obj2 = 0L;
                Object m3672g = zzqa.m3672g(zzhmVar, "_epc");
                if (m3672g != null) {
                    obj2 = m3672g;
                }
                long longValue = ((Long) obj2).longValue();
                this.f14087c = longValue;
                if (longValue <= 0) {
                    l93Var.zzu.zzaW().zzh().zzb("Complex event with zero extra param count. eventName", zzh);
                } else {
                    zzpvVar.zzj().m7832G(str, (Long) Preconditions.checkNotNull(l), this.f14087c, zzhmVar);
                }
            }
        }
        zzhl zzhlVar = (zzhl) zzhmVar.zzch();
        zzhlVar.zzi(zzh);
        zzhlVar.zzg();
        zzhlVar.zzd(zzi);
        return (zzhm) zzhlVar.zzba();
    }
}
