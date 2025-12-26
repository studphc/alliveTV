package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p000.ga3;

/* loaded from: classes.dex */
public abstract class zzca extends SQLiteOpenHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzca(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
        ga3 ga3Var = zzcc.f13800a;
        zzbx.zza();
    }
}
