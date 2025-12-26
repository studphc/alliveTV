package p000;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class bc3 extends zzz {

    /* renamed from: a */
    public final int f7969a;

    public bc3(byte[] bArr) {
        boolean z;
        if (bArr.length == 25) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f7969a = Arrays.hashCode(bArr);
    }

    /* renamed from: a */
    public static byte[] m2082a(String str) {
        try {
            return str.getBytes(C0643C.ISO88591_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public abstract byte[] mo2083b();

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaaVar = (zzaa) obj;
                if (zzaaVar.zzc() != this.f7969a || (zzd = zzaaVar.zzd()) == null) {
                    return false;
                }
                return Arrays.equals(mo2083b(), (byte[]) ObjectWrapper.unwrap(zzd));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7969a;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.f7969a;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(mo2083b());
    }
}
