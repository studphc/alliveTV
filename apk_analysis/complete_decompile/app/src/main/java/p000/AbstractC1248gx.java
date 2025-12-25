package p000;

import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.Topic;

/* renamed from: gx */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1248gx {
    /* renamed from: c */
    public static /* synthetic */ CustomAudience.Builder m4999c() {
        return new CustomAudience.Builder();
    }

    /* renamed from: e */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m5001e() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* renamed from: g */
    public static /* synthetic */ DeletionRequest.Builder m5003g() {
        return new DeletionRequest.Builder();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ MeasurementManager m5009m(Object obj) {
        return (MeasurementManager) obj;
    }

    /* renamed from: n */
    public static /* synthetic */ GetTopicsRequest.Builder m5010n() {
        return new GetTopicsRequest.Builder();
    }

    /* renamed from: r */
    public static /* bridge */ /* synthetic */ Topic m5014r(Object obj) {
        return (Topic) obj;
    }

    /* renamed from: s */
    public static /* bridge */ /* synthetic */ Class m5015s() {
        return MeasurementManager.class;
    }
}
