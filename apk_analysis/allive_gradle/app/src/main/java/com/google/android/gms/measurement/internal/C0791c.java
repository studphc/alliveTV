package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzqr;
import p000.C1972x6;
import p000.v93;

/* renamed from: com.google.android.gms.measurement.internal.c */
/* loaded from: classes.dex */
public final class C0791c extends com.google.android.gms.internal.measurement.zzca {

    /* renamed from: a */
    public final /* synthetic */ int f13995a = 1;

    /* renamed from: b */
    public final /* synthetic */ AbstractC0811m f13996b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0791c(zzgv zzgvVar, Context context) {
        super(context, "google_app_measurement_local.db", null, 1);
        this.f13996b = zzgvVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        switch (this.f13995a) {
            case 0:
                v93 v93Var = (v93) this.f13996b;
                C1972x6 c1972x6 = v93Var.f27692c;
                v93Var.zzu.zzf();
                if (c1972x6.f28446b == 0 || ((Clock) c1972x6.f28447c).elapsedRealtime() - c1972x6.f28446b >= 3600000) {
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException unused) {
                        C1972x6 c1972x62 = v93Var.f27692c;
                        c1972x62.f28446b = ((Clock) c1972x62.f28447c).elapsedRealtime();
                        zzio zzioVar = v93Var.zzu;
                        zzioVar.zzaW().zze().zza("Opening the database failed, dropping and recreating it");
                        zzioVar.zzf();
                        if (!zzioVar.zzaT().getDatabasePath("google_app_measurement.db").delete()) {
                            zzioVar.zzaW().zze().zzb("Failed to delete corrupted db file", "google_app_measurement.db");
                        }
                        try {
                            SQLiteDatabase writableDatabase = super.getWritableDatabase();
                            c1972x62.f28446b = 0L;
                            return writableDatabase;
                        } catch (SQLiteException e) {
                            v93Var.zzu.zzaW().zze().zzb("Failed to open freshly created database", e);
                            throw e;
                        }
                    }
                }
                throw new SQLiteException("Database open failed");
            default:
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e2) {
                    throw e2;
                } catch (SQLiteException unused2) {
                    zzgv zzgvVar = (zzgv) this.f13996b;
                    zzio zzioVar2 = zzgvVar.zzu;
                    zzioVar2.zzaW().zze().zza("Opening the local database failed, dropping and recreating it");
                    zzioVar2.zzf();
                    if (!zzioVar2.zzaT().getDatabasePath("google_app_measurement_local.db").delete()) {
                        zzioVar2.zzaW().zze().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e3) {
                        zzgvVar.zzu.zzaW().zze().zzb("Failed to open local database. Events will bypass local storage", e3);
                        return null;
                    }
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.f13995a) {
            case 0:
                zzax.m3514b(((v93) this.f13996b).zzu.zzaW(), sQLiteDatabase);
                return;
            default:
                zzax.m3514b(((zzgv) this.f13996b).zzu.zzaW(), sQLiteDatabase);
                return;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.f13995a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        switch (this.f13995a) {
            case 0:
                zzio zzioVar = ((v93) this.f13996b).zzu;
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", v93.f27680d);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "events_snapshot", "CREATE TABLE IF NOT EXISTS events_snapshot ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, last_bundled_timestamp INTEGER, last_bundled_day INTEGER, last_sampled_complex_event_id INTEGER, last_sampling_rate INTEGER, last_exempt_from_sampling INTEGER, current_session_count INTEGER, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp,last_bundled_timestamp,last_bundled_day,last_sampled_complex_event_id,last_sampling_rate,last_exempt_from_sampling,current_session_count", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", v93.f27682f);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", v93.f27683g);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", v93.f27685i);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", v93.f27684h);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", v93.f27686j);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", v93.f27687k);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", v93.f27688l);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", v93.f27689m);
                zzqr.zzb();
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "trigger_uris", "CREATE TABLE IF NOT EXISTS trigger_uris ( app_id TEXT NOT NULL, trigger_uri TEXT NOT NULL, timestamp_millis INTEGER NOT NULL, source INTEGER NOT NULL);", "app_id,trigger_uri,source,timestamp_millis", v93.f27690n);
                zzax.m3513a(zzioVar.zzaW(), sQLiteDatabase, "upload_queue", "CREATE TABLE IF NOT EXISTS upload_queue ( app_id TEXT NOT NULL, upload_uri TEXT NOT NULL, upload_headers TEXT NOT NULL, upload_type INTEGER NOT NULL, measurement_batch BLOB NOT NULL, retry_count INTEGER NOT NULL, creation_timestamp INTEGER NOT NULL );", "app_id,upload_uri,upload_headers,upload_type,measurement_batch,retry_count,creation_timestamp", v93.f27681e);
                return;
            default:
                zzax.m3513a(((zzgv) this.f13996b).zzu.zzaW(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", zzgv.f14175d);
                return;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.f13995a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0791c(v93 v93Var, Context context) {
        super(context, "google_app_measurement.db", null, 1);
        this.f13996b = v93Var;
    }

    /* renamed from: a */
    private final void m3489a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: b */
    private final void m3490b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: c */
    private final void m3491c(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: d */
    private final void m3492d(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
