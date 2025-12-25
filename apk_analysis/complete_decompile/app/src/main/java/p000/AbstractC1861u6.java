package p000;

import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;

/* renamed from: u6 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1861u6 {
    /* renamed from: D */
    public static /* bridge */ /* synthetic */ Class m7574D() {
        return CustomAudienceManager.class;
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ AppSetId m7576b(Object obj) {
        return (AppSetId) obj;
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ AppSetIdManager m7578d(Object obj) {
        return (AppSetIdManager) obj;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ AdTechIdentifier m7579e(String str) {
        return AdTechIdentifier.fromString(str);
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ CustomAudienceManager m7589o(Object obj) {
        return (CustomAudienceManager) obj;
    }

    /* renamed from: q */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m7591q() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* renamed from: u */
    public static /* synthetic */ TrustedBiddingData.Builder m7595u() {
        return new TrustedBiddingData.Builder();
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ Class m7599y() {
        return AppSetIdManager.class;
    }
}
