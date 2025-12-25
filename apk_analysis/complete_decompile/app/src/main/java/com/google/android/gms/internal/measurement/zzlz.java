package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzlz;
import com.google.android.gms.internal.measurement.zzmd;
import java.io.IOException;
import p000.oc3;
import p000.ud3;

/* loaded from: classes.dex */
public class zzlz<MessageType extends zzmd<MessageType, BuilderType>, BuilderType extends zzlz<MessageType, BuilderType>> extends zzkn<MessageType, BuilderType> {

    /* renamed from: a */
    public final zzmd f13886a;
    protected zzmd zza;

    public zzlz(MessageType messagetype) {
        this.f13886a = messagetype;
        if (!messagetype.m3474f()) {
            this.zza = (zzmd) messagetype.zzl(4, null, null);
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final /* bridge */ /* synthetic */ zzkn zzaS(byte[] bArr, int i, int i2) {
        zzlp zzlpVar = zzlp.f13880b;
        ud3 ud3Var = ud3.f27230c;
        zzaZ(bArr, 0, i2, zzlp.f13881c);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final /* bridge */ /* synthetic */ zzkn zzaT(byte[] bArr, int i, int i2, zzlp zzlpVar) {
        zzaZ(bArr, 0, i2, zzlpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    /* renamed from: zzaX, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzlz zzaR() {
        zzlz zzlzVar = (zzlz) this.f13886a.zzl(5, null, null);
        zzlzVar.zza = zzbc();
        return zzlzVar;
    }

    public final zzlz zzaY(zzmd zzmdVar) {
        if (!this.f13886a.equals(zzmdVar)) {
            if (!this.zza.m3474f()) {
                zzbf();
            }
            zzmd zzmdVar2 = this.zza;
            ud3.f27230c.m7701a(zzmdVar2.getClass()).mo3240g(zzmdVar2, zzmdVar);
        }
        return this;
    }

    public final zzlz zzaZ(byte[] bArr, int i, int i2, zzlp zzlpVar) {
        if (!this.zza.m3474f()) {
            zzbf();
        }
        try {
            ud3.f27230c.m7701a(this.zza.getClass()).mo3236c(this.zza, bArr, 0, i2, new oc3(zzlpVar));
            return this;
        } catch (zzmm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final MessageType zzba() {
        MessageType zzbc = zzbc();
        if (zzbc.zzcD()) {
            return zzbc;
        }
        throw new zzod(zzbc);
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    /* renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public MessageType zzbc() {
        if (!this.zza.m3474f()) {
            return (MessageType) this.zza;
        }
        this.zza.zzcr();
        return (MessageType) this.zza;
    }

    public final void zzbe() {
        if (!this.zza.m3474f()) {
            zzbf();
        }
    }

    public void zzbf() {
        zzmd zzmdVar = (zzmd) this.f13886a.zzl(4, null, null);
        ud3.f27230c.m7701a(zzmdVar.getClass()).mo3240g(zzmdVar, this.zza);
        this.zza = zzmdVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final /* bridge */ /* synthetic */ zznh zzcC() {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final boolean zzcD() {
        return zzmd.m3471g(this.zza, false);
    }
}
