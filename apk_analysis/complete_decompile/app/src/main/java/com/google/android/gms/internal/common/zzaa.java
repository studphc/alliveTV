package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jspecify.annotations.NullMarked;
import p000.C1369jw;
import p000.ai2;
import p000.df3;
import p000.ve3;

@NullMarked
/* loaded from: classes.dex */
public final class zzaa {

    /* renamed from: a */
    public final ve3 f13739a;

    /* renamed from: b */
    public final boolean f13740b;

    /* renamed from: c */
    public final ai2 f13741c;

    public zzaa(ai2 ai2Var, boolean z, ve3 ve3Var) {
        this.f13741c = ai2Var;
        this.f13740b = z;
        this.f13739a = ve3Var;
    }

    public static zzaa zzc(zzr zzrVar) {
        return new zzaa(new ai2(26, zzrVar), false, ve3.f27755b);
    }

    public final zzaa zzb() {
        return new zzaa(this.f13741c, true, this.f13739a);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new C1369jw(2, this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        df3 df3Var = new df3(this, charSequence, (zzr) this.f13741c.f216b);
        ArrayList arrayList = new ArrayList();
        while (df3Var.hasNext()) {
            arrayList.add((String) df3Var.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
