package p000;

import android.view.ViewGroup;
import androidx.fragment.app.C0253h;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.internal.tls.CertificateChainCleaner;

/* renamed from: wl */
/* loaded from: classes2.dex */
public final class C1950wl extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f28220b;

    /* renamed from: c */
    public final /* synthetic */ Object f28221c;

    /* renamed from: d */
    public final /* synthetic */ Object f28222d;

    /* renamed from: e */
    public final /* synthetic */ Object f28223e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1950wl(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.f28220b = i;
        this.f28221c = obj;
        this.f28222d = obj2;
        this.f28223e = obj3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        List<Certificate> clean;
        switch (this.f28220b) {
            case 0:
                CertificateChainCleaner certificateChainCleaner = ((CertificatePinner) this.f28221c).getCertificateChainCleaner();
                List<Certificate> list = (List) this.f28222d;
                if (certificateChainCleaner != null && (clean = certificateChainCleaner.clean(list, (String) this.f28223e)) != null) {
                    list = clean;
                }
                ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((X509Certificate) ((Certificate) it.next()));
                }
                return arrayList;
            case 1:
                CertificateChainCleaner certificateChainCleaner2 = ((CertificatePinner) this.f28221c).getCertificateChainCleaner();
                Intrinsics.checkNotNull(certificateChainCleaner2);
                return certificateChainCleaner2.clean(((Handshake) this.f28222d).peerCertificates(), ((Address) this.f28223e).url().host());
            default:
                ((C0253h) this.f28221c).f4666f.beginDelayedTransition((ViewGroup) this.f28222d, this.f28223e);
                return Unit.INSTANCE;
        }
    }
}
