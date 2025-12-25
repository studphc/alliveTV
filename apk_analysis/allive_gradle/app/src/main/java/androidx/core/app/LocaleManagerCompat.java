package androidx.core.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.os.LocaleListCompat;
import p000.oc1;
import p000.pc1;
import p000.qc1;

/* loaded from: classes.dex */
public final class LocaleManagerCompat {
    @NonNull
    @AnyThread
    public static LocaleListCompat getApplicationLocales(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            Object systemService = context.getSystemService("locale");
            if (systemService != null) {
                return LocaleListCompat.wrap(qc1.m7026a(systemService));
            }
            return LocaleListCompat.getEmptyLocaleList();
        }
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context context) {
        LocaleListCompat forLanguageTags;
        LocaleListCompat emptyLocaleList = LocaleListCompat.getEmptyLocaleList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            Object systemService = context.getSystemService("locale");
            if (systemService != null) {
                return LocaleListCompat.wrap(qc1.m7027b(systemService));
            }
            return emptyLocaleList;
        }
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (i >= 24) {
            forLanguageTags = pc1.m6908a(configuration);
        } else {
            forLanguageTags = LocaleListCompat.forLanguageTags(oc1.m6561a(configuration.locale));
        }
        return forLanguageTags;
    }
}
