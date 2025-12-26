package p000;

import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.TopicsManager;
import android.app.ActivityOptions;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class mk1 {
    /* renamed from: B */
    public static /* synthetic */ void m6150B() {
    }

    /* renamed from: C */
    public static /* synthetic */ void m6151C() {
    }

    /* renamed from: D */
    public static /* synthetic */ void m6152D() {
    }

    /* renamed from: a */
    public static /* synthetic */ ReportImpressionRequest m6153a(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    /* renamed from: c */
    public static /* synthetic */ WebSourceParams.Builder m6155c(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    /* renamed from: g */
    public static /* synthetic */ WebSourceRegistrationRequest.Builder m6159g(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: j */
    public static /* synthetic */ WebTriggerParams.Builder m6162j(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    /* renamed from: l */
    public static /* synthetic */ WebTriggerRegistrationRequest.Builder m6164l(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ GetTopicsResponse m6166n(Object obj) {
        return (GetTopicsResponse) obj;
    }

    /* renamed from: p */
    public static /* bridge */ /* synthetic */ TopicsManager m6168p(Object obj) {
        return (TopicsManager) obj;
    }

    /* renamed from: q */
    public static /* bridge */ /* synthetic */ ActivityOptions m6169q(ActivityOptions activityOptions) {
        return activityOptions.setPendingIntentBackgroundActivityStartMode(1);
    }

    /* renamed from: s */
    public static /* bridge */ /* synthetic */ Class m6171s() {
        return TopicsManager.class;
    }

    /* renamed from: t */
    public static /* synthetic */ void m6172t() {
    }

    /* renamed from: y */
    public static /* synthetic */ void m6177y() {
    }
}
