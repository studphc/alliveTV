package com.google.android.gms.measurement.internal;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzpk;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.internal.measurement.zzpt;
import com.google.android.gms.internal.measurement.zzqi;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqo;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.internal.measurement.zzqx;
import com.google.android.gms.internal.measurement.zzra;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.internal.measurement.zzrg;
import com.google.android.gms.internal.measurement.zzrj;
import com.google.android.gms.internal.measurement.zzrm;
import com.google.android.gms.internal.measurement.zzrp;
import com.google.android.gms.internal.measurement.zzrs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.nb3;

/* loaded from: classes.dex */
public final class zzgi {

    /* renamed from: a */
    public static final List f14158a = Collections.synchronizedList(new ArrayList());
    public static final zzgg zzA;
    public static final zzgg zzB;
    public static final zzgg zzC;
    public static final zzgg zzD;
    public static final zzgg zzE;
    public static final zzgg zzF;
    public static final zzgg zzG;
    public static final zzgg zzH;
    public static final zzgg zzI;
    public static final zzgg zzJ;
    public static final zzgg zzK;
    public static final zzgg zzL;
    public static final zzgg zzM;
    public static final zzgg zzN;
    public static final zzgg zzO;
    public static final zzgg zzP;
    public static final zzgg zzQ;
    public static final zzgg zzR;
    public static final zzgg zzS;
    public static final zzgg zzT;
    public static final zzgg zzU;
    public static final zzgg zzV;
    public static final zzgg zzW;
    public static final zzgg zzX;
    public static final zzgg zzY;
    public static final zzgg zzZ;
    public static final zzgg zza;
    public static final zzgg zzaA;
    public static final zzgg zzaB;
    public static final zzgg zzaC;
    public static final zzgg zzaD;
    public static final zzgg zzaE;
    public static final zzgg zzaF;
    public static final zzgg zzaG;
    public static final zzgg zzaH;
    public static final zzgg zzaI;
    public static final zzgg zzaJ;
    public static final zzgg zzaK;
    public static final zzgg zzaL;
    public static final zzgg zzaM;
    public static final zzgg zzaN;
    public static final zzgg zzaO;
    public static final zzgg zzaP;
    public static final zzgg zzaQ;
    public static final zzgg zzaR;
    public static final zzgg zzaS;
    public static final zzgg zzaT;
    public static final zzgg zzaU;
    public static final zzgg zzaV;
    public static final zzgg zzaW;
    public static final zzgg zzaX;
    public static final zzgg zzaY;
    public static final zzgg zzaZ;
    public static final zzgg zzaa;
    public static final zzgg zzab;
    public static final zzgg zzac;
    public static final zzgg zzad;
    public static final zzgg zzae;
    public static final zzgg zzaf;
    public static final zzgg zzag;
    public static final zzgg zzah;
    public static final zzgg zzai;
    public static final zzgg zzaj;
    public static final zzgg zzak;
    public static final zzgg zzal;
    public static final zzgg zzam;
    public static final zzgg zzan;
    public static final zzgg zzao;
    public static final zzgg zzap;
    public static final zzgg zzaq;
    public static final zzgg zzar;
    public static final zzgg zzas;
    public static final zzgg zzat;
    public static final zzgg zzau;
    public static final zzgg zzav;
    public static final zzgg zzaw;
    public static final zzgg zzax;
    public static final zzgg zzay;
    public static final zzgg zzaz;
    public static final zzgg zzb;
    public static final zzgg zzba;
    public static final zzgg zzbb;
    public static final zzgg zzbc;
    public static final zzgg zzbd;
    public static final zzgg zzbe;
    public static final zzgg zzbf;
    public static final zzgg zzbg;
    public static final zzgg zzbh;
    public static final zzgg zzbi;
    public static final zzgg zzbj;
    public static final zzgg zzbk;
    public static final zzgg zzbl;
    public static final zzgg zzbm;
    public static final zzgg zzbn;
    public static final zzgg zzbo;
    public static final zzgg zzbp;
    public static final zzgg zzbq;
    public static final zzgg zzbr;
    public static final zzgg zzc;
    public static final zzgg zzd;
    public static final zzgg zze;
    public static final zzgg zzf;
    public static final zzgg zzg;
    public static final zzgg zzh;
    public static final zzgg zzi;
    public static final zzgg zzj;
    public static final zzgg zzk;
    public static final zzgg zzl;
    public static final zzgg zzm;
    public static final zzgg zzn;
    public static final zzgg zzo;
    public static final zzgg zzp;
    public static final zzgg zzq;
    public static final zzgg zzr;
    public static final zzgg zzs;
    public static final zzgg zzt;
    public static final zzgg zzu;
    public static final zzgg zzv;
    public static final zzgg zzw;
    public static final zzgg zzx;
    public static final zzgg zzy;
    public static final zzgg zzz;

    static {
        Collections.synchronizedSet(new HashSet());
        zza = m3524a("measurement.ad_id_cache_time", 10000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zza());
            }
        }, false);
        zzb = m3524a("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzb());
            }
        }, false);
        zzc = m3524a("measurement.monitoring.sample_period_millis", 86400000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdx
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzt());
            }
        }, false);
        zzd = m3524a("measurement.config.cache_time", 86400000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzej
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzd());
            }
        }, false);
        zze = m3524a("measurement.config.url_scheme", "https", new nb3() { // from class: com.google.android.gms.measurement.internal.zzev
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzah();
            }
        }, false);
        zzf = m3524a("measurement.config.url_authority", "app-measurement.com", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfi
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzag();
            }
        }, false);
        zzg = m3524a("measurement.upload.max_bundles", 100, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfu
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzT());
            }
        }, false);
        zzh = m3524a("measurement.upload.max_batch_size", 65536, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzab());
            }
        }, false);
        zzi = m3524a("measurement.upload.max_bundle_size", 65536, new nb3() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzS());
            }
        }, false);
        zzj = m3524a("measurement.upload.max_events_per_bundle", 1000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzW());
            }
        }, false);
        Integer valueOf = Integer.valueOf(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        zzk = m3524a("measurement.upload.max_events_per_day", valueOf, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcl
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzX());
            }
        }, false);
        zzl = m3524a("measurement.upload.max_error_events_per_day", 1000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcx
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzV());
            }
        }, false);
        zzm = m3524a("measurement.upload.max_public_events_per_day", 50000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzY());
            }
        }, false);
        zzn = m3524a("measurement.upload.max_conversions_per_day", 10000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzU());
            }
        }, false);
        zzo = m3524a("measurement.upload.max_realtime_events_per_day", 10, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzaa());
            }
        }, false);
        zzp = m3524a("measurement.store.max_stored_events_per_app", valueOf, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzk());
            }
        }, false);
        zzq = m3524a("measurement.upload.url", "https://app-measurement.com/a", new nb3() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzar();
            }
        }, false);
        zzr = m3524a("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", new nb3() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzaj();
            }
        }, false);
        zzs = m3524a("measurement.sgtm.service_upload_apps_list", "", new nb3() { // from class: com.google.android.gms.measurement.internal.zzdj
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzal();
            }
        }, false);
        zzt = m3524a("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", new nb3() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzam();
            }
        }, false);
        zzu = m3524a("measurement.sgtm.upload.retry_interval", 600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzH());
            }
        }, false);
        zzv = m3524a("measurement.sgtm.upload.retry_max_wait", 21600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzI());
            }
        }, false);
        zzw = m3524a("measurement.sgtm.batch.retry_interval", 1800000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzz());
            }
        }, false);
        zzx = m3524a("measurement.sgtm.batch.retry_max_wait", 21600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzB());
            }
        }, false);
        zzy = m3524a("measurement.sgtm.batch.retry_max_count", 10, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzA());
            }
        }, false);
        zzz = m3524a("measurement.sgtm.upload.max_queued_batches", 5000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzD());
            }
        }, false);
        zzA = m3524a("measurement.sgtm.upload.batches_retrieval_limit", 5, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzC());
            }
        }, false);
        zzB = m3524a("measurement.sgtm.upload.min_delay_after_startup", 5000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzG());
            }
        }, false);
        zzC = m3524a("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzF());
            }
        }, false);
        zzD = m3524a("measurement.sgtm.upload.min_delay_after_background", 600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzE());
            }
        }, false);
        zzE = m3524a("measurement.upload.backoff_period", 43200000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzP());
            }
        }, false);
        zzF = m3524a("measurement.upload.window_interval", 3600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdz
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzae());
            }
        }, false);
        zzG = m3524a("measurement.upload.interval", 3600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzeb
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzR());
            }
        }, false);
        zzH = m3524a("measurement.upload.realtime_upload_interval", 10000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzec
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzv());
            }
        }, false);
        zzI = m3524a("measurement.upload.debug_upload_interval", 1000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzed
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zze());
            }
        }, false);
        zzJ = m3524a("measurement.upload.minimum_delay", 500L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzee
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzs());
            }
        }, false);
        zzK = m3524a("measurement.alarm_manager.minimum_interval", 60000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzef
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzr());
            }
        }, false);
        zzL = m3524a("measurement.upload.stale_data_deletion_interval", 86400000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzeg
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzJ());
            }
        }, false);
        zzM = m3524a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzeh
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzw());
            }
        }, false);
        zzN = m3524a("measurement.upload.initial_upload_delay_time", Long.valueOf(C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS), new nb3() { // from class: com.google.android.gms.measurement.internal.zzei
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzQ());
            }
        }, false);
        zzO = m3524a("measurement.upload.retry_time", 1800000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzek
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzad());
            }
        }, false);
        zzP = m3524a("measurement.upload.retry_count", 6, new nb3() { // from class: com.google.android.gms.measurement.internal.zzem
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzac());
            }
        }, false);
        zzQ = m3524a("measurement.upload.max_queue_time", 518400000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzen
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzZ());
            }
        }, false);
        zzR = m3524a("measurement.upload.google_signal_max_queue_time", 300000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzeo
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzg());
            }
        }, false);
        zzS = m3524a("measurement.lifetimevalue.max_currency_tracked", 4, new nb3() { // from class: com.google.android.gms.measurement.internal.zzep
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzh());
            }
        }, false);
        zzT = m3524a("measurement.audience.filter_result_max_count", 200, new nb3() { // from class: com.google.android.gms.measurement.internal.zzeq
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzm());
            }
        }, false);
        zzU = m3524a("measurement.upload.max_public_user_properties", 100, null, false);
        zzV = m3524a("measurement.upload.max_event_name_cardinality", 2000, null, false);
        zzW = m3524a("measurement.upload.max_public_event_params", 100, null, false);
        zzX = m3524a("measurement.service_client.idle_disconnect_millis", 5000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzer
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzx());
            }
        }, false);
        zzY = m3524a("measurement.service_client.reconnect_millis", 1000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzes
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzy());
            }
        }, false);
        Boolean bool = Boolean.FALSE;
        zzZ = m3524a("measurement.test.boolean_flag", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzet
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqo.zzg());
            }
        }, false);
        zzaa = m3524a("measurement.test.string_flag", "---", new nb3() { // from class: com.google.android.gms.measurement.internal.zzeu
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return zzqo.zzf();
            }
        }, false);
        zzab = m3524a("measurement.test.long_flag", -1L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzex
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(zzqo.zzd());
            }
        }, false);
        m3524a("measurement.test.cached_long_flag", -1L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzey
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(zzqo.zzb());
            }
        }, true);
        zzac = m3524a("measurement.test.int_flag", -2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzez
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) zzqo.zzc());
            }
        }, false);
        zzad = m3524a("measurement.test.double_flag", Double.valueOf(-3.0d), new nb3() { // from class: com.google.android.gms.measurement.internal.zzfa
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Double.valueOf(zzqo.zza());
            }
        }, false);
        zzae = m3524a("measurement.experiment.max_ids", 50, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfb
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzl());
            }
        }, false);
        zzaf = m3524a("measurement.upload.max_item_scoped_custom_parameters", 27, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfc
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzn());
            }
        }, false);
        zzag = m3524a("measurement.upload.max_event_parameter_value_length", Integer.valueOf(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR), new nb3() { // from class: com.google.android.gms.measurement.internal.zzfd
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzj());
            }
        }, true);
        zzah = m3524a("measurement.max_bundles_per_iteration", 100, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfe
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzc());
            }
        }, false);
        zzai = m3524a("measurement.sdk.attribution.cache.ttl", 604800000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzff
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzN());
            }
        }, false);
        zzaj = m3524a("measurement.redaction.app_instance_id.ttl", 7200000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfg
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzO());
            }
        }, false);
        zzak = m3524a("measurement.rb.attribution.client.min_ad_services_version", 7, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfj
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzq());
            }
        }, false);
        zzal = m3524a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfk
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzi());
            }
        }, false);
        zzam = m3524a("measurement.rb.attribution.uri_scheme", "https", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfl
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzaq();
            }
        }, false);
        zzan = m3524a("measurement.rb.attribution.uri_authority", "google-analytics.com", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfm
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzan();
            }
        }, false);
        zzao = m3524a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfn
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzao();
            }
        }, false);
        zzap = m3524a("measurement.session.engagement_interval", 3600000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfo
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzf());
            }
        }, false);
        zzaq = m3524a("measurement.rb.attribution.app_allowlist", "*", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfp
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzak();
            }
        }, false);
        zzar = m3524a("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfq
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzas();
            }
        }, false);
        zzas = m3524a("measurement.rb.attribution.event_params", "value|currency", new nb3() { // from class: com.google.android.gms.measurement.internal.zzfr
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzai();
            }
        }, false);
        zzat = m3524a("measurement.rb.attribution.query_parameters_to_remove", "", new nb3() { // from class: com.google.android.gms.measurement.internal.zzft
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return com.google.android.gms.internal.measurement.zzpb.zzap();
            }
        }, false);
        zzau = m3524a("measurement.rb.attribution.max_queue_time", 864000000L, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfv
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Long.valueOf(com.google.android.gms.internal.measurement.zzpb.zzM());
            }
        }, false);
        zzav = m3524a("measurement.rb.attribution.max_retry_delay_seconds", 16, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfw
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzK());
            }
        }, false);
        zzaw = m3524a("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfx
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzL());
            }
        }, false);
        m3524a("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfy
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzp());
            }
        }, false);
        zzax = m3524a("measurement.rb.max_trigger_registrations_per_day", 1000, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfz
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzo());
            }
        }, false);
        Boolean bool2 = Boolean.TRUE;
        zzay = m3524a("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzga
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpb.zzat());
            }
        }, false);
        zzaz = m3524a("measurement.config.notify_trigger_uris_on_backgrounded", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzgb
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpb.zzau());
            }
        }, false);
        zzaA = m3524a("measurement.rb.attribution.notify_app_delay_millis", Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS), new nb3() { // from class: com.google.android.gms.measurement.internal.zzgc
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpb.zzu());
            }
        }, false);
        zzaB = m3524a("measurement.quality.checksum", bool, null, false);
        zzaC = m3524a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbk
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpq.zzd());
            }
        }, false);
        zzaD = m3524a("measurement.audience.refresh_event_count_filters_timestamp", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbl
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpq.zzc());
            }
        }, false);
        zzaE = m3524a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbn
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpq.zze());
            }
        }, true);
        zzaF = m3524a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzql.zzb());
            }
        }, false);
        zzaG = m3524a("measurement.integration.disable_firebase_instance_id", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrp.zzc());
            }
        }, false);
        zzaH = m3524a("measurement.collection.service.update_with_analytics_fix", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrs.zzb());
            }
        }, false);
        zzaI = m3524a("measurement.service.storage_consent_support_version", 203600, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzpe.zza());
            }
        }, false);
        zzaJ = m3524a("measurement.service.store_null_safelist", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpn.zzc());
            }
        }, false);
        zzaK = m3524a("measurement.service.store_safelist", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpn.zzd());
            }
        }, false);
        zzaL = m3524a("measurement.session_stitching_token_enabled", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrd.zzc());
            }
        }, false);
        zzaM = m3524a("measurement.sgtm.upload_queue", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzh());
            }
        }, false);
        zzaN = m3524a("measurement.sgtm.google_signal.enable", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzd());
            }
        }, false);
        zzaO = m3524a("measurement.sgtm.upload_on_uninstall", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbz
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzi());
            }
        }, false);
        zzaP = m3524a("measurement.sgtm.no_proxy.service", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzf());
            }
        }, false);
        zzaQ = m3524a("measurement.sgtm.service.batching_on_backgrounded", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzg());
            }
        }, false);
        zzaR = m3524a("measurement.sgtm.no_proxy.client2", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zze());
            }
        }, true);
        zzaS = m3524a("measurement.sgtm.client.upload_on_backgrounded.dev", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzc());
            }
        }, true);
        zzaT = m3524a("measurement.sgtm.client.scion_upload_action", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrj.zzb());
            }
        }, true);
        zzaU = m3524a("measurement.gmscore_client_telemetry", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(zzqi.zzb());
            }
        }, false);
        zzaV = m3524a("measurement.rb.attribution.service", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzh());
            }
        }, true);
        zzaW = m3524a("measurement.rb.attribution.client2", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzc());
            }
        }, true);
        zzaX = m3524a("measurement.rb.attribution.uuid_generation", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzj());
            }
        }, false);
        zzaY = m3524a("measurement.rb.attribution.enable_trigger_redaction", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzi());
            }
        }, false);
        m3524a("measurement.rb.attribution.followup1.service", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzd());
            }
        }, false);
        zzaZ = m3524a("measurement.rb.attribution.retry_disposition", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzea
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzg());
            }
        }, false);
        zzba = m3524a("measurement.client.sessions.enable_fix_background_engagement", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzel
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(zzrg.zzb());
            }
        }, false);
        zzbb = m3524a("measurement.fix_engagement_on_reset_analytics_data", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzew
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpt.zzb());
            }
        }, false);
        zzbc = m3524a("measurement.set_default_event_parameters_propagate_clear.service.dev", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfh
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpk.zzc());
            }
        }, false);
        zzbd = m3524a("measurement.set_default_event_parameters_propagate_clear.client.dev", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzfs
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzpk.zzb());
            }
        }, false);
        zzbe = m3524a("measurement.set_default_event_parameters.fix_deferred_analytics_collection", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzgd
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzph.zzc());
            }
        }, false);
        zzbf = m3524a("measurement.chimera.parameter.service", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzbu
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzc());
            }
        }, false);
        zzbg = m3524a("measurement.service.ad_impression.convert_value_to_double", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzos.zzb());
            }
        }, false);
        m3524a("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zzf());
            }
        }, false);
        m3524a("measurement.remove_conflicting_first_party_apis.dev", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqu.zzb());
            }
        }, false);
        zzbh = m3524a("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqr.zze());
            }
        }, false);
        zzbi = m3524a("measurement.backfill_session_ids.service", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(zzra.zzc());
            }
        }, false);
        zzbj = m3524a("measurement.tcf.consent_fix", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzrm.zzb());
            }
        }, false);
        zzbk = m3524a("measurement.experiment.enable_phenotype_experiment_reporting", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // p000.nb3
            public final Object zza() {
                List list = zzgi.f14158a;
                return Boolean.valueOf(zzqx.zzb());
            }
        }, false);
        zzbl = m3524a("measurement.set_default_event_parameters.fix_service_request_ordering", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzph.zzd());
            }
        }, false);
        zzbm = m3524a("measurement.set_default_event_parameters.fix_app_update_logging", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzph.zzb());
            }
        }, false);
        zzbn = m3524a("measurement.fix_high_memory.prune_ees_config", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpw.zzb());
            }
        }, false);
        zzbo = m3524a("measurement.upload_controller.wait_initialization", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpz.zzb());
            }
        }, true);
        zzbp = m3524a("measurement.admob_plus_removal.client.dev", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzov.zzb());
            }
        }, false);
        m3524a("measurement.admob_plus_removal.service", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzov.zzc());
            }
        }, false);
        zzbq = m3524a("measurement.service.fix_stop_bundling_bug", bool, new nb3() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzqf.zzb());
            }
        }, false);
        zzbr = m3524a("measurement.fix_params_logcat_spam", bool2, new nb3() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // p000.nb3
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzqc.zzb());
            }
        }, false);
    }

    /* renamed from: a */
    public static zzgg m3524a(String str, Object obj, nb3 nb3Var, boolean z) {
        zzgg zzggVar = new zzgg(str, obj, nb3Var);
        if (z) {
            f14158a.add(zzggVar);
        }
        return zzggVar;
    }
}
