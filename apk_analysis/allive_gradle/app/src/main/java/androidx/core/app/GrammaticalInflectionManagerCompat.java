package androidx.core.app;

import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.kx0;

/* loaded from: classes.dex */
public final class GrammaticalInflectionManagerCompat {
    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface GrammaticalGender {
    }

    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static int getApplicationGrammaticalGender(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return kx0.m5798a(context);
        }
        return 0;
    }

    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void setRequestedApplicationGrammaticalGender(@NonNull Context context, int i) {
        if (Build.VERSION.SDK_INT >= 34) {
            kx0.m5799b(context, i);
        }
    }
}
