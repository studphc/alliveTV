package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p000.na3;

/* loaded from: classes2.dex */
public final class zze implements zza {

    /* renamed from: a */
    public final HashSet f15503a;

    /* renamed from: b */
    public final AnalyticsConnector.AnalyticsConnectorListener f15504b;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f15504b = analyticsConnectorListener;
        appMeasurementSdk.registerOnMeasurementEventListener(new na3(this));
        this.f15503a = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f15504b;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set set) {
        HashSet hashSet = this.f15503a;
        hashSet.clear();
        HashSet hashSet2 = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (hashSet2.size() >= 50) {
                break;
            }
            ImmutableSet immutableSet = zzc.f15497a;
            if (str != null && str.length() != 0) {
                int codePointAt = str.codePointAt(0);
                if (!Character.isLetter(codePointAt)) {
                    if (codePointAt == 95) {
                        codePointAt = 95;
                    }
                }
                int length = str.length();
                int charCount = Character.charCount(codePointAt);
                while (true) {
                    if (charCount < length) {
                        int codePointAt2 = str.codePointAt(charCount);
                        if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                            charCount += Character.charCount(codePointAt2);
                        }
                    } else if (str.length() != 0) {
                        int codePointAt3 = str.codePointAt(0);
                        if (Character.isLetter(codePointAt3)) {
                            int length2 = str.length();
                            int charCount2 = Character.charCount(codePointAt3);
                            while (true) {
                                if (charCount2 < length2) {
                                    int codePointAt4 = str.codePointAt(charCount2);
                                    if (codePointAt4 == 95 || Character.isLetterOrDigit(codePointAt4)) {
                                        charCount2 += Character.charCount(codePointAt4);
                                    }
                                } else {
                                    String zzb = zzjy.zzb(str);
                                    if (zzb != null) {
                                        str = zzb;
                                    }
                                    Preconditions.checkNotNull(str);
                                    hashSet2.add(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        hashSet.addAll(hashSet2);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.f15503a.clear();
    }
}
