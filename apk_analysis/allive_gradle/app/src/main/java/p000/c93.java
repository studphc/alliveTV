package p000;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C0743a;
import com.google.android.gms.common.api.internal.zabz;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class c93 implements zabz {

    /* renamed from: a */
    public final /* synthetic */ int f8300a;

    /* renamed from: b */
    public final /* synthetic */ C0743a f8301b;

    public /* synthetic */ c93(C0743a c0743a, int i) {
        this.f8300a = i;
        this.f8301b = c0743a;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        C0743a c0743a;
        switch (this.f8300a) {
            case 0:
                c0743a = this.f8301b;
                c0743a.f13177m.lock();
                try {
                    c0743a.f13174j = connectionResult;
                    C0743a.m3092d(c0743a);
                    return;
                } finally {
                }
            default:
                c0743a = this.f8301b;
                c0743a.f13177m.lock();
                try {
                    c0743a.f13175k = connectionResult;
                    C0743a.m3092d(c0743a);
                    return;
                } finally {
                }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        C0743a c0743a;
        switch (this.f8300a) {
            case 0:
                c0743a = this.f8301b;
                c0743a.f13177m.lock();
                try {
                    Bundle bundle2 = c0743a.f13173i;
                    if (bundle2 == null) {
                        c0743a.f13173i = bundle;
                    } else if (bundle != null) {
                        bundle2.putAll(bundle);
                    }
                    c0743a.f13174j = ConnectionResult.RESULT_SUCCESS;
                    C0743a.m3092d(c0743a);
                    return;
                } finally {
                }
            default:
                c0743a = this.f8301b;
                c0743a.f13177m.lock();
                try {
                    c0743a.f13175k = ConnectionResult.RESULT_SUCCESS;
                    C0743a.m3092d(c0743a);
                    return;
                } finally {
                }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        Lock lock;
        ConnectionResult connectionResult;
        switch (this.f8300a) {
            case 0:
                C0743a c0743a = this.f8301b;
                Lock lock2 = c0743a.f13177m;
                lock = c0743a.f13177m;
                lock2.lock();
                try {
                    if (!c0743a.f13176l && (connectionResult = c0743a.f13175k) != null && connectionResult.isSuccess()) {
                        c0743a.f13176l = true;
                        c0743a.f13169e.onConnectionSuspended(i);
                        return;
                    }
                    c0743a.f13176l = false;
                    c0743a.f13166b.zac(i, z);
                    c0743a.f13175k = null;
                    c0743a.f13174j = null;
                    return;
                } finally {
                }
            default:
                C0743a c0743a2 = this.f8301b;
                Lock lock3 = c0743a2.f13177m;
                lock = c0743a2.f13177m;
                lock3.lock();
                try {
                    if (c0743a2.f13176l) {
                        c0743a2.f13176l = false;
                        c0743a2.f13166b.zac(i, z);
                        c0743a2.f13175k = null;
                        c0743a2.f13174j = null;
                    } else {
                        c0743a2.f13176l = true;
                        c0743a2.f13168d.onConnectionSuspended(i);
                    }
                    return;
                } finally {
                    lock.unlock();
                }
        }
    }
}
