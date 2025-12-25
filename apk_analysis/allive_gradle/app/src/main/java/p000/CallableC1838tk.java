package p000;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.Callable;

/* renamed from: tk */
/* loaded from: classes2.dex */
public final /* synthetic */ class CallableC1838tk implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f26850a;

    /* renamed from: b */
    public final /* synthetic */ Object f26851b;

    public /* synthetic */ CallableC1838tk(int i, Object obj) {
        this.f26850a = i;
        this.f26851b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object obj = this.f26851b;
        switch (this.f26850a) {
            case 0:
                return obj;
            default:
                Object obj2 = FirebaseInstallations.f15566m;
                FirebaseInstallations firebaseInstallations = (FirebaseInstallations) obj;
                firebaseInstallations.m4388j(null);
                PersistedInstallationEntry m4382d = firebaseInstallations.m4382d();
                if (m4382d.isRegistered()) {
                    FirebaseApp firebaseApp = firebaseInstallations.f15568a;
                    firebaseInstallations.f15569b.deleteFirebaseInstallation(firebaseApp.getOptions().getApiKey(), m4382d.getFirebaseInstallationId(), firebaseApp.getOptions().getProjectId(), m4382d.getRefreshToken());
                }
                firebaseInstallations.m4383e(m4382d.withNoGeneratedFid());
                return null;
        }
    }
}
