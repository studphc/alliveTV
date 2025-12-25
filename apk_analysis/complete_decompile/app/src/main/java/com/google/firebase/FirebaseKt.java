package com.google.firebase;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\f\u001a)\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\r\"\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u000b\u001a\u00020\n*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"Lcom/google/firebase/Firebase;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Lcom/google/firebase/FirebaseApp;", "app", "(Lcom/google/firebase/Firebase;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "Landroid/content/Context;", "context", "initialize", "(Lcom/google/firebase/Firebase;Landroid/content/Context;)Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/FirebaseOptions;", "options", "(Lcom/google/firebase/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;)Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "getApp", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseApp;", "getOptions", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseOptions;", "com.google.firebase-firebase-common"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseKt {
    @NotNull
    public static final FirebaseApp app(@NotNull Firebase firebase, @NotNull String name) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "getInstance(name)");
        return firebaseApp;
    }

    @NotNull
    public static final FirebaseApp getApp(@NotNull Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "getInstance()");
        return firebaseApp;
    }

    @NotNull
    public static final FirebaseOptions getOptions(@NotNull Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "Firebase.app.options");
        return options;
    }

    @Nullable
    public static final FirebaseApp initialize(@NotNull Firebase firebase, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase, @NotNull Context context, @NotNull FirebaseOptions options) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase, @NotNull Context context, @NotNull FirebaseOptions options, @NotNull String name) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(name, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options, name);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
