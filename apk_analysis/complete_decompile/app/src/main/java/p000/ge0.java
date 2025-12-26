package p000;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class ge0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17658a;

    /* renamed from: b */
    public final /* synthetic */ Object f17659b;

    /* renamed from: c */
    public final /* synthetic */ boolean f17660c;

    public /* synthetic */ ge0(Object obj, int i, boolean z) {
        this.f17658a = i;
        this.f17659b = obj;
        this.f17660c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        PersistedInstallationEntry m4385g;
        switch (this.f17658a) {
            case 0:
                Object obj = FirebaseInstallations.f15566m;
                ((FirebaseInstallations) this.f17659b).m4380b(this.f17660c);
                return;
            case 1:
                FirebaseInstallations firebaseInstallations = (FirebaseInstallations) this.f17659b;
                boolean z = this.f17660c;
                Object obj2 = FirebaseInstallations.f15566m;
                PersistedInstallationEntry m4382d = firebaseInstallations.m4382d();
                try {
                    if (!m4382d.isErrored() && !m4382d.isUnregistered()) {
                        if (!z && !firebaseInstallations.f15571d.isAuthTokenExpired(m4382d)) {
                            return;
                        }
                        m4385g = firebaseInstallations.m4381c(m4382d);
                        firebaseInstallations.m4383e(m4385g);
                        synchronized (firebaseInstallations) {
                            if (firebaseInstallations.f15578k.size() != 0 && !m4382d.getFirebaseInstallationId().equals(m4385g.getFirebaseInstallationId())) {
                                Iterator it = firebaseInstallations.f15578k.iterator();
                                while (it.hasNext()) {
                                    ((FidListener) it.next()).onFidChanged(m4385g.getFirebaseInstallationId());
                                }
                            }
                        }
                        if (m4385g.isRegistered()) {
                            firebaseInstallations.m4388j(m4385g.getFirebaseInstallationId());
                        }
                        if (m4385g.isErrored()) {
                            firebaseInstallations.m4386h(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
                            return;
                        } else if (m4385g.isNotGenerated()) {
                            firebaseInstallations.m4386h(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                            return;
                        } else {
                            firebaseInstallations.m4387i(m4385g);
                            return;
                        }
                    }
                    m4385g = firebaseInstallations.m4385g(m4382d);
                    firebaseInstallations.m4383e(m4385g);
                    synchronized (firebaseInstallations) {
                    }
                } catch (FirebaseInstallationsException e) {
                    firebaseInstallations.m4386h(e);
                    return;
                }
                break;
            default:
                ((AudioRendererEventListener) Util.castNonNull(((AudioRendererEventListener.EventDispatcher) this.f17659b).f9655b)).onSkipSilenceEnabledChanged(this.f17660c);
                return;
        }
    }
}
