package com.google.android.gms.internal.measurement;

import java.util.logging.Logger;
import p000.ie3;
import p000.je3;
import p000.ke3;
import p000.wc3;
import p000.xd3;

/* loaded from: classes.dex */
public abstract class zzlk extends zzkv {

    /* renamed from: b */
    public static final Logger f13877b = Logger.getLogger(zzlk.class.getName());

    /* renamed from: c */
    public static final boolean f13878c = ie3.f18390e;
    public static final /* synthetic */ int zzb = 0;

    /* renamed from: a */
    public wc3 f13879a;

    /* renamed from: b */
    public static int m3465b(int i, zznh zznhVar, xd3 xd3Var) {
        int zzz = zzz(i << 3);
        return ((zzko) zznhVar).mo3461a(xd3Var) + zzz + zzz;
    }

    /* renamed from: c */
    public static int m3466c(zznh zznhVar, xd3 xd3Var) {
        int mo3461a = ((zzko) zznhVar).mo3461a(xd3Var);
        return zzz(mo3461a) + mo3461a;
    }

    public static int zzA(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = ke3.m5525c(str);
        } catch (je3 unused) {
            length = str.getBytes(zzmk.f13887a).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    /* renamed from: a */
    public abstract void mo3467a(int i, zznh zznhVar, xd3 xd3Var);

    public final void zzB() {
        if (zza() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i, boolean z);

    public abstract void zze(int i, zzld zzldVar);

    public abstract void zzf(int i, int i2);

    public abstract void zzg(int i);

    public abstract void zzh(int i, long j);

    public abstract void zzi(long j);

    public abstract void zzj(int i, int i2);

    public abstract void zzk(int i);

    public abstract void zzl(byte[] bArr, int i, int i2);

    public abstract void zzn(int i, zznh zznhVar);

    public abstract void zzo(int i, zzld zzldVar);

    public abstract void zzp(int i, String str);

    public abstract void zzr(int i, int i2);

    public abstract void zzs(int i, int i2);

    public abstract void zzt(int i);

    public abstract void zzu(int i, long j);

    public abstract void zzv(long j);
}
