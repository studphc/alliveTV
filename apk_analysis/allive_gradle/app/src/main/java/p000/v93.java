package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.C0791c;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzbc;
import com.google.android.gms.measurement.internal.zzbh;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzjw;
import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzmf;
import com.google.android.gms.measurement.internal.zzov;
import com.google.android.gms.measurement.internal.zzpc;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzpz;
import com.google.android.gms.measurement.internal.zzqa;
import com.google.android.gms.measurement.internal.zzqb;
import com.google.android.gms.measurement.internal.zzqf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class v93 extends re3 {

    /* renamed from: d */
    public static final String[] f27680d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: e */
    public static final String[] f27681e = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* renamed from: f */
    public static final String[] f27682f = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: g */
    public static final String[] f27683g = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};

    /* renamed from: h */
    public static final String[] f27684h = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: i */
    public static final String[] f27685i = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: j */
    public static final String[] f27686j = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: k */
    public static final String[] f27687k = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l */
    public static final String[] f27688l = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: m */
    public static final String[] f27689m = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* renamed from: n */
    public static final String[] f27690n = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: b */
    public final C0791c f27691b;

    /* renamed from: c */
    public final C1972x6 f27692c;

    public v93(zzpv zzpvVar) {
        super(zzpvVar);
        this.f27692c = new C1972x6(this.zzu.zzaU());
        this.zzu.zzf();
        this.f27691b = new C0791c(this, this.zzu.zzaT());
    }

    /* renamed from: D */
    public static final String m7825D(List list) {
        if (list.isEmpty()) {
            return "";
        }
        return ye0.m8296p(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    /* renamed from: K */
    public static final void m7826K(ContentValues contentValues, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put("value", (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* renamed from: A */
    public final void m7827A(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            m7841Q().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error deleting snapshot. appId", zzhe.zzn(str2), e);
        }
    }

    /* renamed from: B */
    public final void m7828B(String str, da3 da3Var) {
        Long l;
        Preconditions.checkNotNull(da3Var);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        String str2 = da3Var.f16314a;
        contentValues.put("app_id", str2);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, da3Var.f16315b);
        contentValues.put("lifetime_count", Long.valueOf(da3Var.f16316c));
        contentValues.put("current_bundle_count", Long.valueOf(da3Var.f16317d));
        contentValues.put("last_fire_timestamp", Long.valueOf(da3Var.f16319f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(da3Var.f16320g));
        contentValues.put("last_bundled_day", da3Var.f16321h);
        contentValues.put("last_sampled_complex_event_id", da3Var.f16322i);
        contentValues.put("last_sampling_rate", da3Var.f16323j);
        contentValues.put("current_session_count", Long.valueOf(da3Var.f16318e));
        Boolean bool = da3Var.f16324k;
        if (bool != null && bool.booleanValue()) {
            l = 1L;
        } else {
            l = null;
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (m7841Q().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzb("Failed to insert/update event aggregates (got -1). appId", zzhe.zzn(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing event aggregates. appId", zzhe.zzn(da3Var.f16314a), e);
        }
    }

    /* renamed from: C */
    public final void m7829C(ContentValues contentValues) {
        try {
            SQLiteDatabase m7841Q = m7841Q();
            if (contentValues.getAsString("app_id") == null) {
                this.zzu.zzaW().zzf().zzb("Value of the primary key is not set.", zzhe.zzn("app_id"));
            } else if (m7841Q.update("consent_settings", contentValues, "app_id = ?", new String[]{r3}) == 0 && m7841Q.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzc("Failed to insert/update table (got -1). key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzd("Error storing into table. key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"), e);
        }
    }

    /* renamed from: E */
    public final void m7830E(String str, zzov zzovVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzovVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        zzgg zzggVar = zzgi.zzau;
        long longValue = currentTimeMillis - ((Long) zzggVar.zza(null)).longValue();
        long j = zzovVar.zzb;
        if (j < longValue || j > ((Long) zzggVar.zza(null)).longValue() + currentTimeMillis) {
            zzioVar.zzaW().zzk().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzhe.zzn(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        zzioVar.zzaW().zzj().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzovVar.zza);
        contentValues.put(FirebaseAnalytics.Param.SOURCE, Integer.valueOf(zzovVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (m7841Q().insert("trigger_uris", null, contentValues) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert trigger URI (got -1). appId", zzhe.zzn(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing trigger URI. appId", zzhe.zzn(str), e);
        }
    }

    /* renamed from: F */
    public final boolean m7831F() {
        zzio zzioVar = this.zzu;
        Context zzaT = zzioVar.zzaT();
        zzioVar.zzf();
        return zzaT.getDatabasePath("google_app_measurement.db").exists();
    }

    /* renamed from: G */
    public final void m7832G(String str, Long l, long j, zzhm zzhmVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhmVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        byte[] zzcd = zzhmVar.zzcd();
        zzioVar.zzaW().zzj().zzc("Saving complex main event, appId, data size", zzioVar.zzj().zzd(str), Integer.valueOf(zzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzcd);
        try {
            if (m7841Q().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert complex main event (got -1). appId", zzhe.zzn(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing complex main event. appId", zzhe.zzn(str), e);
        }
    }

    /* renamed from: H */
    public final boolean m7833H(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        zzg();
        zzav();
        String str = zzaiVar.zza;
        Preconditions.checkNotNull(str);
        if (m7852a0(str, zzaiVar.zzc.zzb) == null) {
            long m7836L = m7836L("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzf();
            if (m7836L >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaiVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaiVar.zzc.zzb);
        m7826K(contentValues, Preconditions.checkNotNull(zzaiVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaiVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaiVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaiVar.zzh));
        zzio zzioVar = this.zzu;
        zzbh zzbhVar = zzaiVar.zzg;
        zzioVar.zzw().getClass();
        contentValues.put("timed_out_event", zzqf.m3704L(zzbhVar));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaiVar.zzd));
        zzqf zzw = zzioVar.zzw();
        zzbh zzbhVar2 = zzaiVar.zzi;
        zzw.getClass();
        contentValues.put("triggered_event", zzqf.m3704L(zzbhVar2));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaiVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaiVar.zzj));
        zzbh zzbhVar3 = zzaiVar.zzk;
        zzioVar.zzw().getClass();
        contentValues.put("expired_event", zzqf.m3704L(zzbhVar3));
        try {
            if (m7841Q().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert/update conditional user property (got -1)", zzhe.zzn(str));
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing conditional user property", zzhe.zzn(str), e);
            return true;
        }
    }

    /* renamed from: I */
    public final boolean m7834I(ye3 ye3Var) {
        Preconditions.checkNotNull(ye3Var);
        zzg();
        zzav();
        String str = ye3Var.f28928a;
        String str2 = ye3Var.f28930c;
        ye3 m7852a0 = m7852a0(str, str2);
        String str3 = ye3Var.f28929b;
        if (m7852a0 == null) {
            if (zzqf.m3700F(str2)) {
                if (m7836L("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzf().zzi(str, zzgi.zzU, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long m7836L = m7836L("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                this.zzu.zzf();
                if (m7836L >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", str3);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        contentValues.put("set_timestamp", Long.valueOf(ye3Var.f28931d));
        m7826K(contentValues, ye3Var.f28932e);
        try {
            if (m7841Q().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzb("Failed to insert/update user property (got -1). appId", zzhe.zzn(str));
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing user property. appId", zzhe.zzn(str), e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01e4 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7835J(String str, long j, long j2, se3 se3Var) {
        String str2;
        String str3;
        SQLiteDatabase m7841Q;
        String str4;
        String[] strArr;
        String string;
        String str5;
        String[] strArr2;
        String[] strArr3;
        Preconditions.checkNotNull(se3Var);
        zzg();
        zzav();
        Cursor cursor = null;
        try {
            try {
                m7841Q = m7841Q();
                str4 = "";
            } catch (SQLiteException e) {
                e = e;
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                if (j2 != -1) {
                    strArr3 = new String[]{String.valueOf(j2), String.valueOf(j)};
                } else {
                    strArr3 = new String[]{String.valueOf(j)};
                }
                if (j2 != -1) {
                    str4 = "rowid <= ? and ";
                }
                cursor = m7841Q.rawQuery("select app_id, metadata_fingerprint from raw_events where " + str4 + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", strArr3);
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str;
                }
                if (cursor.moveToFirst()) {
                    str3 = cursor.getString(0);
                    try {
                        string = cursor.getString(1);
                        cursor.close();
                    } catch (SQLiteException e3) {
                        e = e3;
                        this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str3), e);
                    }
                } else if (cursor != null) {
                    return;
                } else {
                    return;
                }
            } else {
                try {
                    if (j2 != -1) {
                        str2 = str;
                        strArr = new String[]{str2, String.valueOf(j2)};
                    } else {
                        str2 = str;
                        strArr = new String[]{str};
                    }
                    if (j2 != -1) {
                        str4 = " and rowid <= ?";
                    }
                    cursor = m7841Q.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + str4 + " order by rowid limit 1;", strArr);
                } catch (SQLiteException e4) {
                    e = e4;
                    str3 = str2;
                    this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str3), e);
                }
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    cursor.close();
                    str3 = str2;
                }
            }
            cursor = m7841Q.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, string}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
            if (!cursor.moveToFirst()) {
                this.zzu.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(str3));
            } else {
                try {
                    zzhx zzhxVar = (zzhx) ((zzhw) zzqa.m3683x(zzhx.zzz(), cursor.getBlob(0))).zzba();
                    if (cursor.moveToNext()) {
                        this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(str3));
                    }
                    cursor.close();
                    Preconditions.checkNotNull(zzhxVar);
                    se3Var.f26396a = zzhxVar;
                    if (j2 != -1) {
                        str5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr2 = new String[]{str3, string, String.valueOf(j2)};
                    } else {
                        str5 = "app_id = ? and metadata_fingerprint = ?";
                        strArr2 = new String[]{str3, string};
                    }
                    cursor = m7841Q.query("raw_events", new String[]{"rowid", AppMeasurementSdk.ConditionalUserProperty.NAME, "timestamp", DataSchemeDataSource.SCHEME_DATA}, str5, strArr2, null, null, "rowid", null);
                    if (!cursor.moveToFirst()) {
                        this.zzu.zzaW().zzk().zzb("Raw event data disappeared while in transaction. appId", zzhe.zzn(str3));
                    }
                    do {
                        long j3 = cursor.getLong(0);
                        try {
                            zzhl zzhlVar = (zzhl) zzqa.m3683x(zzhm.zze(), cursor.getBlob(3));
                            zzhlVar.zzi(cursor.getString(1));
                            zzhlVar.zzm(cursor.getLong(2));
                            if (!se3Var.m7369a(j3, (zzhm) zzhlVar.zzba())) {
                                break;
                            }
                        } catch (IOException e5) {
                            this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(str3), e5);
                        }
                    } while (cursor.moveToNext());
                } catch (IOException e6) {
                    this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(str3), e6);
                }
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* renamed from: L */
    public final long m7836L(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m7841Q().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    rawQuery.close();
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: M */
    public final long m7837M(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = m7841Q().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                cursor.close();
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: N */
    public final long m7838N(String str, zzhv zzhvVar, String str2, Map map, zzmf zzmfVar, Long l) {
        int delete;
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhvVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            zzg();
            zzav();
            if (m7831F()) {
                zzpv zzpvVar = this.zzg;
                long zza = zzpvVar.zzw().zzb.zza();
                long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
                long abs = Math.abs(elapsedRealtime - zza);
                zzioVar.zzf();
                if (abs > zzam.zzJ()) {
                    zzpvVar.zzw().zzb.zzb(elapsedRealtime);
                    zzg();
                    zzav();
                    if (m7831F() && (delete = m7841Q().delete("upload_queue", m7877y(), new String[0])) > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                    }
                    if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                        Preconditions.checkNotEmpty(str);
                        zzg();
                        zzav();
                        try {
                            int zzh = zzioVar.zzf().zzh(str, zzgi.zzz);
                            if (zzh > 0) {
                                m7841Q().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzh)});
                            }
                        } catch (SQLiteException e) {
                            this.zzu.zzaW().zze().zzc("Error deleting over the limit queued batches. appId", zzhe.zzn(str), e);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
            byte[] zzcd = zzhvVar.zzcd();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("measurement_batch", zzcd);
            contentValues.put("upload_uri", str2);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "\r\n");
                }
            }
            contentValues.put("upload_headers", sb.toString());
            contentValues.put("upload_type", Integer.valueOf(zzmfVar.zza()));
            zzio zzioVar2 = this.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar2.zzaU().currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            if (l != null) {
                contentValues.put("associated_row_id", l);
            }
            try {
                long insert = m7841Q().insert("upload_queue", null, contentValues);
                if (insert == -1) {
                    zzioVar2.zzaW().zze().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                    return -1L;
                }
                return insert;
            } catch (SQLiteException e2) {
                this.zzu.zzaW().zze().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            }
        }
        return -1L;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(3:2|3|4)|(2:6|(3:8|9|10)(1:13))|14|15|(3:17|9|10)(4:18|19|9|10)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0098, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a2, code lost:
    
        r14.zzu.zzaW().zze().zzd("Error inserting column. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r15), "first_open_count", r2);
     */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long m7839O(String str) {
        long j;
        long j2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzav();
        SQLiteDatabase m7841Q = m7841Q();
        m7841Q.beginTransaction();
        try {
            try {
                j2 = -1;
                j = m7837M("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
            } catch (SQLiteException e) {
                SQLiteException e2 = e;
                j = 0;
            }
            if (j == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (m7841Q.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    this.zzu.zzaW().zze().zzc("Failed to insert column (got -1). appId", zzhe.zzn(str), "first_open_count");
                    return j2;
                }
                j = 0;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put("first_open_count", Long.valueOf(1 + j));
            if (m7841Q.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                this.zzu.zzaW().zze().zzc("Failed to update column (got 0). appId", zzhe.zzn(str), "first_open_count");
                return j2;
            }
            m7841Q.setTransactionSuccessful();
            j2 = j;
            return j2;
        } finally {
            m7841Q.endTransaction();
        }
    }

    /* renamed from: P */
    public final long m7840P(String str) {
        Preconditions.checkNotEmpty(str);
        return m7837M("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* renamed from: Q */
    public final SQLiteDatabase m7841Q() {
        zzg();
        try {
            return this.f27691b.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzk().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[SYNTHETIC] */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ob3 m7842R(String str) {
        Throwable th;
        SQLiteException sQLiteException;
        Cursor cursor;
        Throwable th2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        long j;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        long j2;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Boolean valueOf;
        String str2;
        boolean z20;
        boolean z21;
        boolean z22;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            cursor = m7841Q().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            sQLiteException = e;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
        }
        try {
        } catch (SQLiteException e2) {
            sQLiteException = e2;
            try {
                this.zzu.zzaW().zze().zzc("Error querying app. appId", zzhe.zzn(str), sQLiteException);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th4) {
                th2 = th4;
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th5) {
            th2 = th5;
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
        }
        if (cursor.moveToFirst()) {
            zzpv zzpvVar = this.zzg;
            ob3 ob3Var = new ob3(zzpvVar.f14380l, str);
            zzio zzioVar = ob3Var.f23733a;
            zzjx m3641a0 = zzpvVar.m3641a0(str);
            zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
            if (m3641a0.zzr(zzjwVar)) {
                ob3Var.m6544k(cursor.getString(0));
            }
            boolean z23 = true;
            ob3Var.m6556w(cursor.getString(1));
            if (zzpvVar.m3641a0(str).zzr(zzjw.AD_STORAGE)) {
                ob3Var.m6530D(cursor.getString(2));
            }
            ob3Var.m6527A(cursor.getLong(3));
            ob3Var.m6528B(cursor.getLong(4));
            ob3Var.m6559z(cursor.getLong(5));
            ob3Var.m6546m(cursor.getString(6));
            ob3Var.m6545l(cursor.getString(7));
            ob3Var.m6557x(cursor.getLong(8));
            ob3Var.m6552s(cursor.getLong(9));
            if (cursor.isNull(10) || cursor.getInt(10) != 0) {
                z = true;
            } else {
                z = false;
            }
            ob3Var.m6529C(z);
            long j3 = cursor.getLong(11);
            zzioVar.zzaX().zzg();
            boolean z24 = ob3Var.f23730R;
            if (ob3Var.f23723K != j3) {
                z2 = true;
            } else {
                z2 = false;
            }
            ob3Var.f23730R = z24 | z2;
            ob3Var.f23723K = j3;
            long j4 = cursor.getLong(12);
            zzioVar.zzaX().zzg();
            boolean z25 = ob3Var.f23730R;
            if (ob3Var.f23724L != j4) {
                z3 = true;
            } else {
                z3 = false;
            }
            ob3Var.f23730R = z25 | z3;
            ob3Var.f23724L = j4;
            long j5 = cursor.getLong(13);
            zzioVar.zzaX().zzg();
            boolean z26 = ob3Var.f23730R;
            if (ob3Var.f23725M != j5) {
                z4 = true;
            } else {
                z4 = false;
            }
            ob3Var.f23730R = z26 | z4;
            ob3Var.f23725M = j5;
            long j6 = cursor.getLong(14);
            zzioVar.zzaX().zzg();
            boolean z27 = ob3Var.f23730R;
            if (ob3Var.f23726N != j6) {
                z5 = true;
            } else {
                z5 = false;
            }
            ob3Var.f23730R = z27 | z5;
            ob3Var.f23726N = j6;
            ob3Var.m6550q(cursor.getLong(15));
            long j7 = cursor.getLong(16);
            zzioVar.zzaX().zzg();
            boolean z28 = ob3Var.f23730R;
            if (ob3Var.f23732T != j7) {
                z6 = true;
            } else {
                z6 = false;
            }
            ob3Var.f23730R = z28 | z6;
            ob3Var.f23732T = j7;
            if (cursor.isNull(17)) {
                j = -2147483648L;
            } else {
                j = cursor.getInt(17);
            }
            ob3Var.m6547n(j);
            ob3Var.m6555v(cursor.getString(18));
            long j8 = cursor.getLong(19);
            zzioVar.zzaX().zzg();
            boolean z29 = ob3Var.f23730R;
            if (ob3Var.f23727O != j8) {
                z7 = true;
            } else {
                z7 = false;
            }
            ob3Var.f23730R = z29 | z7;
            ob3Var.f23727O = j8;
            long j9 = cursor.getLong(20);
            zzioVar.zzaX().zzg();
            boolean z30 = ob3Var.f23730R;
            if (ob3Var.f23728P != j9) {
                z8 = true;
            } else {
                z8 = false;
            }
            ob3Var.f23730R = z30 | z8;
            ob3Var.f23728P = j9;
            ob3Var.m6558y(cursor.getString(21));
            if (cursor.isNull(23) || cursor.getInt(23) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            zzioVar.zzaX().zzg();
            boolean z31 = ob3Var.f23730R;
            if (ob3Var.f23748p != z9) {
                z10 = true;
            } else {
                z10 = false;
            }
            ob3Var.f23730R = z31 | z10;
            ob3Var.f23748p = z9;
            ob3Var.m6543j(cursor.getString(24));
            if (cursor.isNull(25)) {
                j2 = 0;
            } else {
                j2 = cursor.getLong(25);
            }
            ob3Var.m6554u(j2);
            if (!cursor.isNull(26)) {
                ob3Var.m6531E(Arrays.asList(cursor.getString(26).split(",", -1)));
            }
            if (zzpvVar.m3641a0(str).zzr(zzjwVar)) {
                String string = cursor.getString(28);
                zzioVar.zzaX().zzg();
                ob3Var.f23730R |= !Objects.equals(ob3Var.f23753u, string);
                ob3Var.f23753u = string;
            }
            if (!cursor.isNull(29) && cursor.getInt(29) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzioVar.zzaX().zzg();
            boolean z32 = ob3Var.f23730R;
            if (ob3Var.f23754v != z11) {
                z12 = true;
            } else {
                z12 = false;
            }
            ob3Var.f23730R = z32 | z12;
            ob3Var.f23754v = z11;
            long j10 = cursor.getLong(39);
            zzioVar.zzaX().zzg();
            boolean z33 = ob3Var.f23730R;
            if (ob3Var.f23719G != j10) {
                z13 = true;
            } else {
                z13 = false;
            }
            ob3Var.f23730R = z33 | z13;
            ob3Var.f23719G = j10;
            String string2 = cursor.getString(36);
            zzioVar.zzaX().zzg();
            boolean z34 = ob3Var.f23730R;
            if (ob3Var.f23716D != string2) {
                z14 = true;
            } else {
                z14 = false;
            }
            ob3Var.f23730R = z34 | z14;
            ob3Var.f23716D = string2;
            long j11 = cursor.getLong(30);
            zzioVar.zzaX().zzg();
            boolean z35 = ob3Var.f23730R;
            if (ob3Var.f23755w != j11) {
                z15 = true;
            } else {
                z15 = false;
            }
            ob3Var.f23730R = z35 | z15;
            ob3Var.f23755w = j11;
            long j12 = cursor.getLong(31);
            zzioVar.zzaX().zzg();
            boolean z36 = ob3Var.f23730R;
            if (ob3Var.f23756x != j12) {
                z16 = true;
            } else {
                z16 = false;
            }
            ob3Var.f23730R = z36 | z16;
            ob3Var.f23756x = j12;
            zzqr.zzb();
            zzio zzioVar2 = this.zzu;
            if (zzioVar2.zzf().zzx(str, zzgi.zzaV)) {
                int i = cursor.getInt(32);
                zzioVar.zzaX().zzg();
                boolean z37 = ob3Var.f23730R;
                if (ob3Var.f23757y != i) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                ob3Var.f23730R = z37 | z22;
                ob3Var.f23757y = i;
                ob3Var.m6548o(cursor.getLong(35));
            }
            if (!cursor.isNull(33) && cursor.getInt(33) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            zzioVar.zzaX().zzg();
            boolean z38 = ob3Var.f23730R;
            if (ob3Var.f23758z != z17) {
                z18 = true;
            } else {
                z18 = false;
            }
            ob3Var.f23730R = z38 | z18;
            ob3Var.f23758z = z17;
            if (cursor.isNull(34)) {
                valueOf = null;
            } else {
                if (cursor.getInt(34) != 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                valueOf = Boolean.valueOf(z19);
            }
            zzioVar.zzaX().zzg();
            ob3Var.f23730R |= !Objects.equals(ob3Var.f23750r, valueOf);
            ob3Var.f23750r = valueOf;
            ob3Var.m6553t(cursor.getInt(37));
            ob3Var.m6551r(cursor.getInt(38));
            if (cursor.isNull(40)) {
                str2 = "";
            } else {
                str2 = (String) Preconditions.checkNotNull(cursor.getString(40));
            }
            zzioVar.zzaX().zzg();
            boolean z39 = ob3Var.f23730R;
            if (ob3Var.f23720H != str2) {
                z20 = true;
            } else {
                z20 = false;
            }
            ob3Var.f23730R = z39 | z20;
            ob3Var.f23720H = str2;
            if (!cursor.isNull(41)) {
                Long valueOf2 = Long.valueOf(cursor.getLong(41));
                zzioVar.zzaX().zzg();
                ob3Var.f23730R |= !Objects.equals(ob3Var.f23713A, valueOf2);
                ob3Var.f23713A = valueOf2;
            }
            if (!cursor.isNull(42)) {
                Long valueOf3 = Long.valueOf(cursor.getLong(42));
                zzioVar.zzaX().zzg();
                ob3Var.f23730R |= !Objects.equals(ob3Var.f23714B, valueOf3);
                ob3Var.f23714B = valueOf3;
            }
            byte[] blob = cursor.getBlob(43);
            zzioVar.zzaX().zzg();
            boolean z40 = ob3Var.f23730R;
            if (ob3Var.f23721I != blob) {
                z21 = true;
            } else {
                z21 = false;
            }
            ob3Var.f23730R = z40 | z21;
            ob3Var.f23721I = blob;
            if (zzioVar2.zzf().zzx(str, zzgi.zzaP) && !cursor.isNull(44)) {
                int i2 = cursor.getInt(44);
                zzioVar.zzaX().zzg();
                boolean z41 = ob3Var.f23730R;
                if (ob3Var.f23722J == i2) {
                    z23 = false;
                }
                ob3Var.f23730R = z23 | z41;
                ob3Var.f23722J = i2;
            }
            zzioVar.zzaX().zzg();
            ob3Var.f23730R = false;
            if (cursor.moveToNext()) {
                zzioVar2.zzaW().zze().zzb("Got multiple records for app, expected one. appId", zzhe.zzn(str));
            }
            cursor.close();
            return ob3Var;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00f4: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:245), block:B:32:0x00f4 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0117  */
    /* renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzai m7843S(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        boolean z;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        Cursor cursor3 = null;
        try {
            try {
                cursor = m7841Q().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zze().zzd("Error querying conditional property", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            String string = cursor.getString(0);
            if (string == null) {
                string = "";
            }
            String str3 = string;
            Object m7854b0 = m7854b0(cursor, 1);
            if (cursor.getInt(2) != 0) {
                z = true;
            } else {
                z = false;
            }
            String string2 = cursor.getString(3);
            long j = cursor.getLong(4);
            zzpv zzpvVar = this.zzg;
            zzqa zzA = zzpvVar.zzA();
            byte[] blob = cursor.getBlob(5);
            Parcelable.Creator<zzbh> creator = zzbh.CREATOR;
            zzbh zzbhVar = (zzbh) zzA.m3692t(blob, creator);
            zzai zzaiVar = new zzai(str, str3, new zzqb(cursor.getLong(8), m7854b0, str2, str3), cursor.getLong(6), z, string2, zzbhVar, j, (zzbh) zzpvVar.zzA().m3692t(cursor.getBlob(7), creator), cursor.getLong(9), (zzbh) zzpvVar.zzA().m3692t(cursor.getBlob(10), creator));
            if (cursor.moveToNext()) {
                zzio zzioVar2 = this.zzu;
                zzioVar2.zzaW().zze().zzc("Got multiple records for conditional property, expected one", zzhe.zzn(str), zzioVar2.zzj().zzf(str2));
            }
            cursor.close();
            return zzaiVar;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0085  */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final jz2 m7844T(String str) {
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            cursor = m7841Q().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        if (cursor.moveToNext()) {
                            this.zzu.zzaW().zze().zzb("Got multiple records for app config, expected one. appId", zzhe.zzn(str));
                        }
                        if (blob != null) {
                            jz2 jz2Var = new jz2(blob, string, string2, 9);
                            cursor.close();
                            return jz2Var;
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzc("Error querying remote config. appId", zzhe.zzn(str), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* renamed from: U */
    public final zzas m7845U(long j, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        return m7846V(j, str, 1L, false, false, z, false, z2, z3, z4);
    }

    /* renamed from: V */
    public final zzas m7846V(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        String[] strArr = {str};
        zzas zzasVar = new zzas();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase m7841Q = m7841Q();
                cursor = m7841Q.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    this.zzu.zzaW().zzk().zzb("Not updating daily counts, app is not known. appId", zzhe.zzn(str));
                } else {
                    if (cursor.getLong(0) == j) {
                        zzasVar.f14126b = cursor.getLong(1);
                        zzasVar.f14125a = cursor.getLong(2);
                        zzasVar.f14127c = cursor.getLong(3);
                        zzasVar.f14128d = cursor.getLong(4);
                        zzasVar.f14129e = cursor.getLong(5);
                        zzasVar.f14130f = cursor.getLong(6);
                        zzasVar.f14131g = cursor.getLong(7);
                    }
                    if (z) {
                        zzasVar.f14126b += j2;
                    }
                    if (z2) {
                        zzasVar.f14125a += j2;
                    }
                    if (z3) {
                        zzasVar.f14127c += j2;
                    }
                    if (z4) {
                        zzasVar.f14128d += j2;
                    }
                    if (z5) {
                        zzasVar.f14129e += j2;
                    }
                    if (z6) {
                        zzasVar.f14130f += j2;
                    }
                    if (z7) {
                        zzasVar.f14131g += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzasVar.f14125a));
                    contentValues.put("daily_events_count", Long.valueOf(zzasVar.f14126b));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzasVar.f14127c));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzasVar.f14128d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzasVar.f14129e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzasVar.f14130f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzasVar.f14131g));
                    m7841Q.update("apps", contentValues, "app_id=?", strArr);
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error updating daily counts. appId", zzhe.zzn(str), e);
            }
            if (cursor != null) {
                cursor.close();
            }
            return zzasVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: W */
    public final da3 m7847W(String str, zzhm zzhmVar, String str2) {
        da3 m7875w = m7875w("events", str, zzhmVar.zzh());
        if (m7875w == null) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzhe.zzn(str), zzioVar.zzj().zzd(str2));
            return new da3(str, zzhmVar.zzh(), 1L, 1L, 1L, zzhmVar.zzd(), 0L, null, null, null, null);
        }
        long j = m7875w.f16318e + 1;
        long j2 = m7875w.f16317d + 1;
        return new da3(m7875w.f16314a, m7875w.f16315b, m7875w.f16316c + 1, j2, j, m7875w.f16319f, m7875w.f16320g, m7875w.f16321h, m7875w.f16322i, m7875w.f16323j, m7875w.f16324k);
    }

    /* renamed from: X */
    public final zzjx m7848X(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        return zzjx.zzk(m7878z("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}), 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r5 == 0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjx m7849Y(String str) {
        Throwable th;
        SQLiteException e;
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        ?? r5 = {str};
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        zzjx zzjxVar = null;
        try {
            try {
                r5 = m7841Q().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", r5);
                try {
                    if (!r5.moveToFirst()) {
                        this.zzu.zzaW().zzj().zza("No data found");
                    } else {
                        zzjxVar = zzjx.zzk(r5.getString(0), r5.getInt(1));
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Error querying database.", e);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = r5;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            r5 = 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        r5.close();
        if (zzjxVar == null) {
            return zzjx.zza;
        }
        return zzjxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpz m7850Z(String str) {
        Cursor cursor;
        zzpz zzpzVar;
        v93 v93Var;
        Cursor cursor2;
        Cursor cursor3;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            return null;
        }
        if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
            List m7856d = m7856d(str, zzpc.zza(zzmf.GOOGLE_SIGNAL), 1);
            if (m7856d.isEmpty()) {
                return null;
            }
            return (zzpz) m7856d.get(0);
        }
        try {
            cursor2 = m7841Q().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "app_id=? AND NOT " + m7877y(), new String[]{str}, null, null, "creation_timestamp ASC", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            try {
            } catch (SQLiteException e) {
                e = e;
                zzpzVar = null;
                cursor3 = cursor2;
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
            }
        } catch (SQLiteException e2) {
            e = e2;
            zzpzVar = null;
            v93Var = this;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (!cursor2.moveToFirst()) {
            zzpzVar = null;
            if (cursor2 != null) {
                cursor2.close();
            }
            return zzpzVar;
        }
        zzpzVar = null;
        cursor3 = cursor2;
        try {
            zzpz m7876x = m7876x(str, cursor2.getLong(0), cursor2.getBlob(2), cursor2.getString(3), cursor2.getString(4), cursor2.getInt(5), cursor2.getInt(6), cursor2.getLong(7), cursor2.getLong(8), cursor2.getLong(9));
            cursor3.close();
            return m7876x;
        } catch (SQLiteException e3) {
            e = e3;
            v93Var = this;
            cursor = cursor3;
            try {
                v93Var.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                return zzpzVar;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m7851a() {
        SQLiteException e;
        Cursor cursor;
        SQLiteDatabase m7841Q = m7841Q();
        ?? r1 = 0;
        try {
            try {
                cursor = m7841Q.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        cursor.close();
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                r1 = m7841Q;
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0091  */
    /* renamed from: a0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ye3 m7852a0(String str, String str2) {
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            cursor = m7841Q().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        long j = cursor.getLong(0);
                        Object m7854b0 = m7854b0(cursor, 1);
                        if (m7854b0 != null) {
                            ye3 ye3Var = new ye3(str, cursor.getString(2), str2, j, m7854b0);
                            if (cursor.moveToNext()) {
                                this.zzu.zzaW().zze().zzb("Got multiple records for user property, expected one. appId", zzhe.zzn(str));
                            }
                            cursor.close();
                            return ye3Var;
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zze().zzd("Error querying user property. appId", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* renamed from: b */
    public final List m7853b(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return m7855c(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* renamed from: b0 */
    public final Object m7854b0(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            this.zzu.zzaW().zze().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            return null;
                        }
                        AbstractC1726qj.m7039D(this.zzu, "Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return cursor.getString(i);
                }
                return Double.valueOf(cursor.getDouble(i));
            }
            return Long.valueOf(cursor.getLong(i));
        }
        AbstractC1726qj.m7039D(this.zzu, "Loaded invalid null value from database");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0092, code lost:
    
        r20 = r11.getString(5);
        r22 = r11.getLong(6);
        r2 = r28.zzg;
        r3 = r2.zzA();
        r4 = r11.getBlob(7);
        r5 = com.google.android.gms.measurement.internal.zzbh.CREATOR;
        r21 = (com.google.android.gms.measurement.internal.zzbh) r3.m3692t(r4, r5);
        r0.add(new com.google.android.gms.measurement.internal.zzai(r14, r15, new com.google.android.gms.measurement.internal.zzqb(r11.getLong(10), r7, r8, r15), r11.getLong(8), r19, r20, r21, r22, (com.google.android.gms.measurement.internal.zzbh) r2.zzA().m3692t(r11.getBlob(9), r5), r11.getLong(11), (com.google.android.gms.measurement.internal.zzbh) r2.zzA().m3692t(r11.getBlob(12), r5)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00fd, code lost:
    
        if (r11.moveToNext() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0090, code lost:
    
        r19 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        r2 = r12.zzaW().zze();
        r12.zzf();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0049, code lost:
    
        if (r11.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004b, code lost:
    
        r2 = r0.size();
        r12.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0054, code lost:
    
        if (r2 < 1000) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0072, code lost:
    
        r14 = r11.getString(0);
        r15 = r11.getString(1);
        r8 = r11.getString(2);
        r7 = m7854b0(r11, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x008b, code lost:
    
        if (r11.getInt(4) == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x008d, code lost:
    
        r19 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m7855c(String str, String[] strArr) {
        zzg();
        zzav();
        ?? arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase m7841Q = m7841Q();
                String[] strArr2 = {"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
                zzio zzioVar = this.zzu;
                zzioVar.zzf();
                cursor = m7841Q.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error querying conditional user property value", e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m7856d(String str, zzpc zzpcVar, int i) {
        v93 v93Var;
        Cursor cursor;
        List list;
        String str2;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (!this.zzu.zzf().zzx(null, zzgi.zzaP)) {
            return Collections.emptyList();
        }
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        try {
            SQLiteDatabase m7841Q = m7841Q();
            String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
            String str3 = "app_id=?" + m7825D(zzpcVar.zza) + " AND NOT " + m7877y();
            String[] strArr2 = {str};
            if (i > 0) {
                str2 = String.valueOf(i);
            } else {
                str2 = null;
            }
            cursor = m7841Q.query("upload_queue", strArr, str3, strArr2, null, null, "creation_timestamp ASC", str2);
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    cursor2 = cursor;
                    try {
                        zzpz m7876x = m7876x(str, cursor.getLong(0), cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8), cursor.getLong(9));
                        if (m7876x != null) {
                            arrayList.add(m7876x);
                        }
                        cursor = cursor2;
                    } catch (SQLiteException e) {
                        e = e;
                        v93Var = this;
                        cursor3 = cursor2;
                        try {
                            v93Var.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                            cursor = cursor3;
                            list = Collections.emptyList();
                            if (cursor != null) {
                            }
                            return list;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                        }
                        throw th;
                    }
                }
                list = arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = cursor;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
            }
        } catch (SQLiteException e3) {
            e = e3;
            v93Var = this;
        } catch (Throwable th4) {
            th = th4;
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005a, code lost:
    
        if (r8 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
        r11.zzaW().zze().zzb("Read invalid user property value, ignoring it. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007c, code lost:
    
        if (r10.moveToNext() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
    
        r0.add(new p000.ye3(r13, r4, r5, r6, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x003a, code lost:
    
        if (r10.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003c, code lost:
    
        r5 = r10.getString(0);
        r1 = r10.getString(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0046, code lost:
    
        if (r1 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        r6 = r10.getLong(2);
        r8 = m7854b0(r10, 3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m7857e(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        ?? arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                zzio zzioVar = this.zzu;
                zzioVar.zzf();
                cursor = m7841Q().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error querying user properties. appId", zzhe.zzn(str), e);
                arrayList = Collections.emptyList();
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
    
        r0 = r9.zzaW().zze();
        r9.zzf();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011b A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m7858f(String str, String str2, String str3) {
        String str4;
        zzio zzioVar;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        ?? arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb = new StringBuilder("app_id=?");
                    if (!TextUtils.isEmpty(str2)) {
                        str4 = str2;
                        try {
                            arrayList2.add(str4);
                            sb.append(" and origin=?");
                        } catch (SQLiteException e) {
                            e = e;
                            this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), str4, e);
                            arrayList = Collections.emptyList();
                            return arrayList;
                        }
                    } else {
                        str4 = str2;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb.append(" and name glob ?");
                    }
                    String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    SQLiteDatabase m7841Q = m7841Q();
                    String[] strArr2 = {AppMeasurementSdk.ConditionalUserProperty.NAME, "set_timestamp", "value", "origin"};
                    String sb2 = sb.toString();
                    zzioVar = this.zzu;
                    zzioVar.zzf();
                    cursor = m7841Q.query("user_attributes", strArr2, sb2, strArr, null, null, "rowid", "1001");
                } catch (SQLiteException e2) {
                    e = e2;
                    str4 = str2;
                    this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), str4, e);
                    arrayList = Collections.emptyList();
                    return arrayList;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
        }
        if (!cursor.moveToFirst()) {
            return arrayList;
        }
        while (true) {
            int size = arrayList.size();
            zzioVar.zzf();
            if (size >= 1000) {
                break;
            }
            String string = cursor.getString(0);
            long j = cursor.getLong(1);
            Object m7854b0 = m7854b0(cursor, 2);
            str4 = cursor.getString(3);
            if (m7854b0 == null) {
                zzioVar.zzaW().zze().zzd("(2)Read invalid user property value, ignoring it", zzhe.zzn(str), str4, str3);
            } else {
                arrayList.add(new ye3(str, str4, string, j, m7854b0));
            }
            if (!cursor.moveToNext()) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x00ff, code lost:
    
        if (r2 == null) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0126 A[SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7859g(String str, Long l, String str2, Bundle bundle) {
        zzau zzauVar;
        zzau zzauVar2;
        Cursor cursor;
        Object obj;
        Object obj2;
        zzhx zzhxVar;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzav();
        zzio zzioVar = this.zzu;
        Cursor cursor2 = null;
        if (zzioVar.zzf().zzx(null, zzgi.zzbe) && l != null) {
            zzauVar = new zzau(this, str3, l.longValue());
        } else {
            zzauVar = new zzau(this, str3);
        }
        zzau zzauVar3 = zzauVar;
        List<u93> zza = zzauVar3.zza();
        while (!zza.isEmpty()) {
            for (u93 u93Var : zza) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        cursor = m7841Q().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, Long.toString(u93Var.f27159b)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        try {
                            try {
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            obj = cursor2;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = cursor2;
                        obj = cursor;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (!cursor.moveToFirst()) {
                        zzioVar.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(str));
                    } else {
                        try {
                            Object obj3 = (zzhx) ((zzhw) zzqa.m3683x(zzhx.zzz(), cursor.getBlob(0))).zzba();
                            try {
                                if (cursor.moveToNext()) {
                                    this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(str));
                                }
                                cursor.close();
                                obj2 = obj3;
                            } catch (SQLiteException e3) {
                                e = e3;
                                obj = obj3;
                                this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str), e);
                                zzhxVar = obj;
                                obj2 = obj;
                            }
                            cursor.close();
                            zzhxVar = obj2;
                        } catch (IOException e4) {
                            this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(str), e4);
                        }
                        if (zzhxVar == 0) {
                            Iterator it = zzhxVar.zzY().iterator();
                            while (it.hasNext()) {
                                if (((com.google.android.gms.internal.measurement.zzio) it.next()).zzg().equals(str2)) {
                                    break;
                                }
                            }
                        }
                    }
                    cursor.close();
                    zzhxVar = cursor2;
                    if (zzhxVar == 0) {
                    }
                }
                zzpv zzpvVar = this.zzg;
                zzqa zzA = zzpvVar.zzA();
                zzhm zzhmVar = u93Var.f27161d;
                Bundle bundle2 = new Bundle();
                for (zzhq zzhqVar : zzhmVar.zzi()) {
                    if (zzhqVar.zzu()) {
                        zzauVar2 = zzauVar3;
                        bundle2.putDouble(zzhqVar.zzg(), zzhqVar.zza());
                    } else {
                        zzauVar2 = zzauVar3;
                        if (zzhqVar.zzv()) {
                            bundle2.putFloat(zzhqVar.zzg(), zzhqVar.zzb());
                        } else if (zzhqVar.zzw()) {
                            bundle2.putLong(zzhqVar.zzg(), zzhqVar.zzd());
                        } else if (zzhqVar.zzy()) {
                            bundle2.putString(zzhqVar.zzg(), zzhqVar.zzh());
                        } else if (!zzhqVar.zzi().isEmpty()) {
                            bundle2.putParcelableArray(zzhqVar.zzg(), zzqa.m3668c(zzhqVar.zzi()));
                        } else {
                            zzA.zzu.zzaW().zze().zzb("Unexpected parameter type for parameter", zzhqVar);
                        }
                    }
                    zzauVar3 = zzauVar2;
                }
                zzau zzauVar4 = zzauVar3;
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzh = zzhmVar.zzh();
                if (string == null) {
                    string = "";
                }
                zzhf zzhfVar = new zzhf(zzh, string, bundle2, zzhmVar.zzd());
                zzio zzioVar2 = this.zzu;
                Bundle bundle3 = zzhfVar.zzd;
                zzioVar2.zzw().m3730j(bundle3, bundle);
                zzbc zzbcVar = new zzbc(this.zzu, zzhfVar.zzb, str, zzhmVar.zzh(), zzhmVar.zzd(), zzhmVar.zzc(), bundle3);
                long j = u93Var.f27158a;
                zzg();
                zzav();
                Preconditions.checkNotNull(zzbcVar);
                String str4 = zzbcVar.f14142a;
                Preconditions.checkNotEmpty(str4);
                byte[] zzcd = zzpvVar.zzA().m3694w(zzbcVar).zzcd();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str4);
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar.f14143b);
                contentValues.put("timestamp", Long.valueOf(zzbcVar.f14145d));
                contentValues.put("metadata_fingerprint", Long.valueOf(u93Var.f27159b));
                contentValues.put(DataSchemeDataSource.SCHEME_DATA, zzcd);
                contentValues.put("realtime", Integer.valueOf(u93Var.f27160c ? 1 : 0));
                try {
                    long update = m7841Q().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                    if (update != 1) {
                        zzioVar2.zzaW().zze().zzc("Failed to update raw event. appId, updatedRows", zzhe.zzn(str4), Long.valueOf(update));
                    }
                } catch (SQLiteException e5) {
                    this.zzu.zzaW().zze().zzc("Error updating raw event. appId", zzhe.zzn(str4), e5);
                }
                str3 = str;
                zzauVar3 = zzauVar4;
                cursor2 = null;
            }
            zza = zzauVar3.zza();
            str3 = str;
            cursor2 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r2.moveToNext() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002d, code lost:
    
        if (r2.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
    
        r1 = r2.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        if (r1 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        r1 = m7875w("events", r13, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if (r1 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        m7828B("events_snapshot", r1);
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7860h(String str) {
        m7827A("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = m7841Q().query("events", (String[]) Collections.singletonList(AppMeasurementSdk.ConditionalUserProperty.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error creating snapshot. appId", zzhe.zzn(str), e);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: i */
    public final void m7861i(ArrayList arrayList) {
        Preconditions.checkNotNull(arrayList);
        zzg();
        zzav();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(((Long) arrayList.get(i)).longValue());
        }
        sb.append(")");
        int delete = m7841Q().delete("raw_events", sb.toString(), null);
        if (delete != arrayList.size()) {
            this.zzu.zzaW().zze().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(arrayList.size()));
        }
    }

    /* renamed from: j */
    public final void m7862j(Long l) {
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            try {
                if (m7841Q().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                    zzioVar.zzaW().zzk().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
                throw e;
            }
        }
    }

    /* renamed from: k */
    public final void m7863k() {
        zzav();
        m7841Q().endTransaction();
    }

    /* renamed from: l */
    public final void m7864l(List list) {
        zzg();
        zzav();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (!m7831F()) {
            return;
        }
        String m8296p = ye0.m8296p("(", TextUtils.join(",", list), ")");
        if (m7836L("SELECT COUNT(1) FROM queue WHERE rowid IN " + m8296p + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
            AbstractC1726qj.m7037B(this.zzu, "The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            m7841Q().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + m8296p + " AND (retry_count IS NULL OR retry_count < 2147483647)");
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
        }
    }

    /* renamed from: m */
    public final void m7865m(Long l) {
        String str;
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM) && m7831F()) {
            if (m7836L("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                AbstractC1726qj.m7037B(zzioVar, "The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase m7841Q = m7841Q();
                if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                    str = " SET retry_count = retry_count + 1, last_upload_timestamp = " + zzioVar.zzaU().currentTimeMillis();
                } else {
                    str = " SET retry_count = retry_count + 1 ";
                }
                m7841Q.execSQL("UPDATE upload_queue" + str + " WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* renamed from: n */
    public final void m7866n(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            m7841Q().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting user property. appId", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
    
        m7828B("events", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
    
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7867o(String str) {
        boolean z;
        da3 m7875w;
        ArrayList arrayList = new ArrayList(Arrays.asList(AppMeasurementSdk.ConditionalUserProperty.NAME, "lifetime_count"));
        da3 m7875w2 = m7875w("events", str, "_f");
        da3 m7875w3 = m7875w("events", str, "_v");
        m7827A("events", str);
        Cursor cursor = null;
        boolean z2 = false;
        try {
            cursor = m7841Q().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            e = e;
            z = false;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            if (m7875w2 == null) {
            }
            m7828B("events", m7875w2);
            m7827A("events_snapshot", str);
        }
        boolean z3 = false;
        z = false;
        do {
            try {
                String string = cursor.getString(0);
                if (cursor.getLong(1) >= 1) {
                    if ("_f".equals(string)) {
                        z3 = true;
                    } else if ("_v".equals(string)) {
                        z = true;
                    }
                }
                if (string != null && (m7875w = m7875w("events_snapshot", str, string)) != null) {
                    m7828B("events", m7875w);
                }
            } catch (SQLiteException e2) {
                e = e2;
                z2 = z3;
                try {
                    this.zzu.zzaW().zze().zzc("Error querying snapshot. appId", zzhe.zzn(str), e);
                    z3 = z2;
                    if (cursor != null) {
                    }
                    if (!z3) {
                    }
                    if (!z) {
                    }
                    m7827A("events_snapshot", str);
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (z2 && m7875w2 != null) {
                        m7828B("events", m7875w2);
                    } else if (!z && m7875w3 != null) {
                        m7828B("events", m7875w3);
                    }
                    m7827A("events_snapshot", str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = z3;
                if (cursor != null) {
                }
                if (z2) {
                }
                if (!z) {
                    m7828B("events", m7875w3);
                }
                m7827A("events_snapshot", str);
                throw th;
            }
        } while (cursor.moveToNext());
        if (cursor != null) {
            cursor.close();
        }
        if (!z3 || m7875w2 == null) {
            if (!z) {
            }
            m7827A("events_snapshot", str);
        }
        m7828B("events", m7875w2);
        m7827A("events_snapshot", str);
    }

    /* renamed from: p */
    public final void m7868p() {
        zzav();
        m7841Q().setTransactionSuccessful();
    }

    /* renamed from: q */
    public final void m7869q(ob3 ob3Var, boolean z) {
        Preconditions.checkNotNull(ob3Var);
        zzg();
        zzav();
        String m6536c = ob3Var.m6536c();
        Preconditions.checkNotNull(m6536c);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", m6536c);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.m3641a0(m6536c).zzr(zzjw.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", ob3Var.m6537d());
        }
        contentValues.put("gmp_app_id", ob3Var.m6540g());
        zzpv zzpvVar = this.zzg;
        boolean zzr = zzpvVar.m3641a0(m6536c).zzr(zzjw.AD_STORAGE);
        zzio zzioVar = ob3Var.f23733a;
        if (zzr) {
            zzioVar.zzaX().zzg();
            contentValues.put("resettable_device_id_hash", ob3Var.f23737e);
        }
        zzioVar.zzaX().zzg();
        contentValues.put("last_bundle_index", Long.valueOf(ob3Var.f23739g));
        zzioVar.zzaX().zzg();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(ob3Var.f23740h));
        zzioVar.zzaX().zzg();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(ob3Var.f23741i));
        contentValues.put("app_version", ob3Var.m6538e());
        zzioVar.zzaX().zzg();
        contentValues.put("app_store", ob3Var.f23744l);
        zzioVar.zzaX().zzg();
        contentValues.put("gmp_version", Long.valueOf(ob3Var.f23745m));
        zzioVar.zzaX().zzg();
        contentValues.put("dev_cert_hash", Long.valueOf(ob3Var.f23746n));
        zzioVar.zzaX().zzg();
        contentValues.put("measurement_enabled", Boolean.valueOf(ob3Var.f23747o));
        zzioVar.zzaX().zzg();
        contentValues.put("day", Long.valueOf(ob3Var.f23723K));
        zzioVar.zzaX().zzg();
        contentValues.put("daily_public_events_count", Long.valueOf(ob3Var.f23724L));
        zzioVar.zzaX().zzg();
        contentValues.put("daily_events_count", Long.valueOf(ob3Var.f23725M));
        zzioVar.zzaX().zzg();
        contentValues.put("daily_conversions_count", Long.valueOf(ob3Var.f23726N));
        zzioVar.zzaX().zzg();
        contentValues.put("config_fetched_time", Long.valueOf(ob3Var.f23731S));
        zzioVar.zzaX().zzg();
        contentValues.put("failed_config_fetch_time", Long.valueOf(ob3Var.f23732T));
        contentValues.put("app_version_int", Long.valueOf(ob3Var.m6533G()));
        contentValues.put("firebase_instance_id", ob3Var.m6539f());
        zzioVar.zzaX().zzg();
        contentValues.put("daily_error_events_count", Long.valueOf(ob3Var.f23727O));
        zzioVar.zzaX().zzg();
        contentValues.put("daily_realtime_events_count", Long.valueOf(ob3Var.f23728P));
        zzioVar.zzaX().zzg();
        contentValues.put("health_monitor_sample", ob3Var.f23729Q);
        contentValues.put("android_id", (Long) 0L);
        zzioVar.zzaX().zzg();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(ob3Var.f23748p));
        contentValues.put("admob_app_id", ob3Var.m6534a());
        zzioVar.zzaX().zzg();
        contentValues.put("dynamite_version", Long.valueOf(ob3Var.f23751s));
        if (zzpvVar.m3641a0(m6536c).zzr(zzjw.ANALYTICS_STORAGE)) {
            zzioVar.zzaX().zzg();
            contentValues.put("session_stitching_token", ob3Var.f23753u);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(ob3Var.m6549p()));
        zzioVar.zzaX().zzg();
        contentValues.put("target_os_version", Long.valueOf(ob3Var.f23755w));
        zzioVar.zzaX().zzg();
        contentValues.put("session_stitching_token_hash", Long.valueOf(ob3Var.f23756x));
        zzqr.zzb();
        zzio zzioVar2 = this.zzu;
        if (zzioVar2.zzf().zzx(m6536c, zzgi.zzaV)) {
            zzioVar.zzaX().zzg();
            contentValues.put("ad_services_version", Integer.valueOf(ob3Var.f23757y));
            zzioVar.zzaX().zzg();
            contentValues.put("attribution_eligibility_status", Long.valueOf(ob3Var.f23715C));
        }
        zzioVar.zzaX().zzg();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(ob3Var.f23758z));
        zzioVar.zzaX().zzg();
        contentValues.put("npa_metadata_value", ob3Var.f23750r);
        zzioVar.zzaX().zzg();
        contentValues.put("bundle_delivery_index", Long.valueOf(ob3Var.f23719G));
        contentValues.put("sgtm_preview_key", ob3Var.m6541h());
        zzioVar.zzaX().zzg();
        contentValues.put("dma_consent_state", Integer.valueOf(ob3Var.f23717E));
        zzioVar.zzaX().zzg();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(ob3Var.f23718F));
        zzioVar.zzaX().zzg();
        contentValues.put("serialized_npa_metadata", ob3Var.f23720H);
        if (zzioVar2.zzf().zzx(m6536c, zzgi.zzaP)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(ob3Var.m6532F()));
        }
        zzioVar.zzaX().zzg();
        ArrayList arrayList = ob3Var.f23752t;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                zzioVar2.zzaW().zzk().zzb("Safelisted events should not be an empty list. appId", m6536c);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        zzpn.zzb();
        if (zzioVar2.zzf().zzx(null, zzgi.zzaJ) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        zzioVar.zzaX().zzg();
        contentValues.put("unmatched_pfo", ob3Var.f23713A);
        zzioVar.zzaX().zzg();
        contentValues.put("unmatched_uwa", ob3Var.f23714B);
        zzioVar.zzaX().zzg();
        contentValues.put("ad_campaign_info", ob3Var.f23721I);
        try {
            SQLiteDatabase m7841Q = m7841Q();
            if (m7841Q.update("apps", contentValues, "app_id = ?", new String[]{m6536c}) == 0 && m7841Q.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzioVar2.zzaW().zze().zzb("Failed to insert/update app (got -1). appId", zzhe.zzn(m6536c));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing app. appId", zzhe.zzn(m6536c), e);
        }
    }

    /* renamed from: r */
    public final void m7870r(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        m7871s(str, m7849Y(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjxVar.zzq());
        m7829C(contentValues);
    }

    /* renamed from: s */
    public final void m7871s(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjxVar.zzq());
        contentValues.put("consent_source", Integer.valueOf(zzjxVar.zzb()));
        m7829C(contentValues);
    }

    /* renamed from: t */
    public final boolean m7872t(String str) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                zzmf[] zzmfVarArr = {zzmf.GOOGLE_SIGNAL};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(zzmfVarArr[0].zza()));
                if (m7836L("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?" + m7825D(arrayList) + " AND NOT " + m7877y(), new String[]{str}) != 0) {
                    return true;
                }
                return false;
            }
            if (m7836L("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ".concat(m7877y()), new String[]{str}) != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: u */
    public final boolean m7873u(String str, String str2) {
        if (m7836L("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: v */
    public final void m7874v(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            m7841Q().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting conditional property", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x012b  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final da3 m7875w(String str, String str2, String str3) {
        Cursor cursor;
        boolean z;
        long j;
        Long valueOf;
        Long valueOf2;
        Long valueOf3;
        Boolean bool;
        long j2;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            z = false;
            cursor = m7841Q().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
                try {
                } catch (SQLiteException e) {
                    e = e;
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zze().zzd("Error querying events. appId", zzhe.zzn(str2), zzioVar.zzj().zzd(str3), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            long j3 = cursor.getLong(0);
            long j4 = cursor.getLong(1);
            long j5 = cursor.getLong(2);
            if (cursor.isNull(3)) {
                j = 0;
            } else {
                j = cursor.getLong(3);
            }
            if (cursor.isNull(4)) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(cursor.getLong(4));
            }
            if (cursor.isNull(5)) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(cursor.getLong(5));
            }
            if (cursor.isNull(6)) {
                valueOf3 = null;
            } else {
                valueOf3 = Long.valueOf(cursor.getLong(6));
            }
            if (!cursor.isNull(7)) {
                if (cursor.getLong(7) == 1) {
                    z = true;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            if (cursor.isNull(8)) {
                j2 = 0;
            } else {
                j2 = cursor.getLong(8);
            }
            da3 da3Var = new da3(str2, str3, j3, j4, j2, j5, j, valueOf, valueOf2, valueOf3, bool);
            if (cursor.moveToNext()) {
                this.zzu.zzaW().zze().zzb("Got multiple records for event aggregates, expected one. appId", zzhe.zzn(str2));
            }
            cursor.close();
            return da3Var;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* renamed from: x */
    public final zzpz m7876x(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaW().zzd().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzht zzhtVar = (zzht) zzqa.m3683x(zzhv.zzb(), bArr);
            zzmf zzb = zzmf.zzb(i);
            if (zzb != zzmf.GOOGLE_SIGNAL && zzb != zzmf.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhtVar.zzj().iterator();
                while (it.hasNext()) {
                    zzhw zzhwVar = (zzhw) ((zzhx) it.next()).zzch();
                    zzhwVar.zzat(i2);
                    arrayList.add((zzhx) zzhwVar.zzba());
                }
                zzhtVar.zzd();
                zzhtVar.zzb(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length != 2) {
                        this.zzu.zzaW().zze().zzb("Invalid upload header: ", str4);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i3++;
                }
            }
            return new zzpz(j, (zzhv) zzhtVar.zzba(), str2, hashMap, zzb, j3, j4, i2);
        } catch (IOException e) {
            this.zzu.zzaW().zze().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    /* renamed from: y */
    public final String m7877y() {
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        Locale locale = Locale.US;
        zzmf zzmfVar = zzmf.GOOGLE_SIGNAL;
        int zza = zzmfVar.zza();
        zzioVar.zzf();
        Long l = (Long) zzgi.zzR.zza(null);
        l.longValue();
        String str = "(upload_type = " + zza + " AND ABS(creation_timestamp - " + currentTimeMillis + ") > " + l + ")";
        int zza2 = zzmfVar.zza();
        zzioVar.zzf();
        return "(" + str + " OR " + ("(upload_type != " + zza2 + " AND ABS(creation_timestamp - " + currentTimeMillis + ") > " + zzam.zzI() + ")") + ")";
    }

    /* renamed from: z */
    public final String m7878z(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                cursor = m7841Q().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                }
                cursor.close();
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzH() {
        zzav();
        m7841Q().beginTransaction();
    }

    public final void zzO() {
        zzg();
        zzav();
        if (m7831F()) {
            zzpv zzpvVar = this.zzg;
            long zza = zzpvVar.zzw().zza.zza();
            zzio zzioVar = this.zzu;
            long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza);
            zzioVar.zzf();
            if (abs > zzam.zzJ()) {
                zzpvVar.zzw().zza.zzb(elapsedRealtime);
                zzg();
                zzav();
                if (m7831F()) {
                    SQLiteDatabase m7841Q = m7841Q();
                    String valueOf = String.valueOf(zzioVar.zzaU().currentTimeMillis());
                    zzioVar.zzf();
                    int delete = m7841Q.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzam.zzI())});
                    if (delete > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }
}
