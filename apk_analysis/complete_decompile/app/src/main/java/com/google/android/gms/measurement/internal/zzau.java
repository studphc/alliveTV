package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.u93;
import p000.v93;

/* loaded from: classes.dex */
public final class zzau {

    /* renamed from: a */
    public final String f14132a;

    /* renamed from: b */
    public long f14133b;

    /* renamed from: c */
    public final /* synthetic */ v93 f14134c;

    public zzau(v93 v93Var, String str) {
        this.f14134c = v93Var;
        Preconditions.checkNotEmpty(str);
        this.f14132a = str;
        this.f14133b = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cb A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza() {
        ArrayList arrayList;
        v93 v93Var = this.f14134c;
        ArrayList arrayList2 = new ArrayList();
        String valueOf = String.valueOf(this.f14133b);
        String str = this.f14132a;
        Cursor cursor = null;
        try {
            try {
                cursor = v93Var.m7841Q().query("raw_events", new String[]{"rowid", AppMeasurementSdk.ConditionalUserProperty.NAME, "timestamp", "metadata_fingerprint", DataSchemeDataSource.SCHEME_DATA, "realtime"}, "app_id = ? and rowid > ?", new String[]{str, valueOf}, null, null, "rowid", "1000");
            } catch (SQLiteException e) {
                v93Var.zzu.zzaW().zze().zzc("Data loss. Error querying raw events batch. appId", zzhe.zzn(str), e);
                arrayList = arrayList2;
            }
            if (!cursor.moveToFirst()) {
                arrayList = Collections.emptyList();
                return arrayList;
            }
            do {
                boolean z = false;
                long j = cursor.getLong(0);
                long j2 = cursor.getLong(3);
                if (cursor.getLong(5) == 1) {
                    z = true;
                }
                byte[] blob = cursor.getBlob(4);
                if (j > this.f14133b) {
                    this.f14133b = j;
                }
                try {
                    zzhl zzhlVar = (zzhl) zzqa.m3683x(zzhm.zze(), blob);
                    String string = cursor.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    zzhlVar.zzi(string);
                    zzhlVar.zzm(cursor.getLong(2));
                    arrayList2.add(new u93(j, j2, z, (zzhm) zzhlVar.zzba()));
                } catch (IOException e2) {
                    v93Var.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(str), e2);
                }
            } while (cursor.moveToNext());
            return arrayList;
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public zzau(v93 v93Var, String str, long j) {
        this.f14134c = v93Var;
        Preconditions.checkNotEmpty(str);
        this.f14132a = str;
        this.f14133b = v93Var.m7837M("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }
}
