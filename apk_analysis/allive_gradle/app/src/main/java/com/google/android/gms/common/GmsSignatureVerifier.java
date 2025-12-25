package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzak;
import java.util.HashMap;
import p000.jb3;
import p000.od3;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GmsSignatureVerifier {
    static {
        zzak.zzl();
        zzak.zzl();
        jb3 jb3Var = od3.f23782d;
        zzak zzn = zzak.zzn(jb3Var.mo2083b(), od3.f23780b.mo2083b());
        Preconditions.checkNotNull(zzn);
        zzak zzk = zzak.zzk(zzn);
        jb3 jb3Var2 = od3.f23781c;
        zzak zzn2 = zzak.zzn(jb3Var2.mo2083b(), od3.f23779a.mo2083b());
        Preconditions.checkNotNull(zzn2);
        zzak zzk2 = zzak.zzk(zzn2);
        if (zzk.isEmpty() && zzk2.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        zzak.zzl();
        zzak.zzl();
        zzak zzm = zzak.zzm(jb3Var.mo2083b());
        Preconditions.checkNotNull(zzm);
        zzak zzk3 = zzak.zzk(zzm);
        zzak zzm2 = zzak.zzm(jb3Var2.mo2083b());
        Preconditions.checkNotNull(zzm2);
        zzak zzk4 = zzak.zzk(zzm2);
        if (zzk3.isEmpty() && zzk4.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        new HashMap();
    }
}
