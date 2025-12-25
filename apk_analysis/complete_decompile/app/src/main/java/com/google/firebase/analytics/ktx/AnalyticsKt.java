package com.google.firebase.analytics.ktx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000\u001a+\u0010\u0016\u001a\u00020\u000f*\u00020\u00012\u0019\b\u0004\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m5569d2 = {"ANALYTICS", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getANALYTICS", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setANALYTICS", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "LOCK", "", "getLOCK", "()Ljava/lang/Object;", "analytics", "Lcom/google/firebase/ktx/Firebase;", "getAnalytics", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/analytics/FirebaseAnalytics;", "logEvent", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "block", "Lkotlin/Function1;", "Lcom/google/firebase/analytics/ktx/ParametersBuilder;", "Lkotlin/ExtensionFunctionType;", "setConsent", "Lcom/google/firebase/analytics/ktx/ConsentBuilder;", "java.com.google.android.gmscore.integ.client.measurement_api_measurement_api"}, m5570k = 2, m5571mv = {2, 1, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AnalyticsKt {

    /* renamed from: a */
    public static volatile FirebaseAnalytics f15506a;

    /* renamed from: b */
    public static final Object f15507b = new Object();

    @Nullable
    public static final FirebaseAnalytics getANALYTICS() {
        return f15506a;
    }

    @NotNull
    public static final FirebaseAnalytics getAnalytics(@NonNull Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        if (f15506a == null) {
            synchronized (f15507b) {
                if (f15506a == null) {
                    f15506a = FirebaseAnalytics.getInstance(FirebaseKt.getApp(Firebase.INSTANCE).getApplicationContext());
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = f15506a;
        Intrinsics.checkNotNull(firebaseAnalytics);
        return firebaseAnalytics;
    }

    @NotNull
    public static final Object getLOCK() {
        return f15507b;
    }

    @Deprecated(message = "Migrate to use the KTX API from the main module: https://firebase.google.com/docs/android/kotlin-migration.")
    public static final void logEvent(@NonNull FirebaseAnalytics firebaseAnalytics, @NonNull String name, @NonNull Function1<? super ParametersBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        block.invoke(parametersBuilder);
        firebaseAnalytics.logEvent(name, parametersBuilder.getF15510a());
    }

    public static final void setANALYTICS(@org.jetbrains.annotations.Nullable FirebaseAnalytics firebaseAnalytics) {
        f15506a = firebaseAnalytics;
    }

    @Deprecated(message = "Migrate to use the KTX API from the main module: https://firebase.google.com/docs/android/kotlin-migration.")
    public static final void setConsent(@NonNull FirebaseAnalytics firebaseAnalytics, @NonNull Function1<? super ConsentBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ConsentBuilder consentBuilder = new ConsentBuilder();
        block.invoke(consentBuilder);
        firebaseAnalytics.setConsent(consentBuilder.asMap());
    }
}
