package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.drm.C0660b;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n00 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ C0660b f23185a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n00(C0660b c0660b, Looper looper) {
        super(looper);
        this.f23185a = c0660b;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Pair pair = (Pair) message.obj;
        Object obj = pair.first;
        Object obj2 = pair.second;
        int i = message.what;
        C0660b c0660b = this.f23185a;
        if (i != 0) {
            if (i == 1 && obj == c0660b.f10025w && c0660b.m2523b()) {
                c0660b.f10025w = null;
                if (obj2 instanceof Exception) {
                    c0660b.m2525d((Exception) obj2, false);
                    return;
                }
                try {
                    byte[] bArr = (byte[]) obj2;
                    CopyOnWriteMultiset copyOnWriteMultiset = c0660b.f10011i;
                    ExoMediaDrm exoMediaDrm = c0660b.f10004b;
                    int i2 = c0660b.f10007e;
                    if (i2 == 3) {
                        exoMediaDrm.provideKeyResponse((byte[]) Util.castNonNull(c0660b.f10024v), bArr);
                        Iterator it = copyOnWriteMultiset.elementSet().iterator();
                        while (it.hasNext()) {
                            ((DrmSessionEventListener.EventDispatcher) it.next()).drmKeysRemoved();
                        }
                        return;
                    }
                    byte[] provideKeyResponse = exoMediaDrm.provideKeyResponse(c0660b.f10023u, bArr);
                    if ((i2 == 2 || (i2 == 0 && c0660b.f10024v != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                        c0660b.f10024v = provideKeyResponse;
                    }
                    c0660b.f10017o = 4;
                    Iterator it2 = copyOnWriteMultiset.elementSet().iterator();
                    while (it2.hasNext()) {
                        ((DrmSessionEventListener.EventDispatcher) it2.next()).drmKeysLoaded();
                    }
                    return;
                } catch (Exception e) {
                    c0660b.m2525d(e, true);
                    return;
                }
            }
            return;
        }
        if (obj == c0660b.f10026x) {
            if (c0660b.f10017o == 2 || c0660b.m2523b()) {
                c0660b.f10026x = null;
                boolean z = obj2 instanceof Exception;
                DefaultDrmSession$ProvisioningManager defaultDrmSession$ProvisioningManager = c0660b.f10005c;
                if (z) {
                    defaultDrmSession$ProvisioningManager.onProvisionError((Exception) obj2, false);
                    return;
                }
                try {
                    c0660b.f10004b.provideProvisionResponse((byte[]) obj2);
                    defaultDrmSession$ProvisioningManager.onProvisionCompleted();
                } catch (Exception e2) {
                    defaultDrmSession$ProvisioningManager.onProvisionError(e2, true);
                }
            }
        }
    }
}
