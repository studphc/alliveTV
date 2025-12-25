package com.google.firebase.analytics;

import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, m5569d2 = {"Lcom/google/firebase/analytics/ConsentBuilder;", "", "<init>", "()V", "adStorage", "Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;", "getAdStorage", "()Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;", "setAdStorage", "(Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;)V", "analyticsStorage", "getAnalyticsStorage", "setAnalyticsStorage", "adUserData", "getAdUserData", "setAdUserData", "adPersonalization", "getAdPersonalization", "setAdPersonalization", "asMap", "", "Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentType;", "java.com.google.android.gmscore.integ.client.measurement_api_measurement_api"}, m5570k = 1, m5571mv = {2, 1, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConsentBuilder {

    /* renamed from: a */
    public FirebaseAnalytics.ConsentStatus f15482a;

    /* renamed from: b */
    public FirebaseAnalytics.ConsentStatus f15483b;

    /* renamed from: c */
    public FirebaseAnalytics.ConsentStatus f15484c;

    /* renamed from: d */
    public FirebaseAnalytics.ConsentStatus f15485d;

    @NotNull
    public final Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus> asMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FirebaseAnalytics.ConsentStatus consentStatus = this.f15482a;
        if (consentStatus != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_STORAGE, consentStatus);
        }
        FirebaseAnalytics.ConsentStatus consentStatus2 = this.f15483b;
        if (consentStatus2 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, consentStatus2);
        }
        FirebaseAnalytics.ConsentStatus consentStatus3 = this.f15484c;
        if (consentStatus3 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_USER_DATA, consentStatus3);
        }
        FirebaseAnalytics.ConsentStatus consentStatus4 = this.f15485d;
        if (consentStatus4 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_PERSONALIZATION, consentStatus4);
        }
        return linkedHashMap;
    }

    @Nullable
    /* renamed from: getAdPersonalization, reason: from getter */
    public final FirebaseAnalytics.ConsentStatus getF15485d() {
        return this.f15485d;
    }

    @Nullable
    /* renamed from: getAdStorage, reason: from getter */
    public final FirebaseAnalytics.ConsentStatus getF15482a() {
        return this.f15482a;
    }

    @Nullable
    /* renamed from: getAdUserData, reason: from getter */
    public final FirebaseAnalytics.ConsentStatus getF15484c() {
        return this.f15484c;
    }

    @Nullable
    /* renamed from: getAnalyticsStorage, reason: from getter */
    public final FirebaseAnalytics.ConsentStatus getF15483b() {
        return this.f15483b;
    }

    public final void setAdPersonalization(@org.jetbrains.annotations.Nullable FirebaseAnalytics.ConsentStatus consentStatus) {
        this.f15485d = consentStatus;
    }

    public final void setAdStorage(@org.jetbrains.annotations.Nullable FirebaseAnalytics.ConsentStatus consentStatus) {
        this.f15482a = consentStatus;
    }

    public final void setAdUserData(@org.jetbrains.annotations.Nullable FirebaseAnalytics.ConsentStatus consentStatus) {
        this.f15484c = consentStatus;
    }

    public final void setAnalyticsStorage(@org.jetbrains.annotations.Nullable FirebaseAnalytics.ConsentStatus consentStatus) {
        this.f15483b = consentStatus;
    }
}
