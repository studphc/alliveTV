package p000;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.LocusId;
import android.os.Bundle;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.LocusIdCompat;

/* renamed from: f5 */
/* loaded from: classes.dex */
public abstract class AbstractC1183f5 {
    @DoNotInline
    /* renamed from: a */
    public static Display m4770a(ContextWrapper contextWrapper) {
        return contextWrapper.getDisplay();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m4771b(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        LocusId locusId;
        if (locusIdCompat == null) {
            locusId = null;
        } else {
            locusId = locusIdCompat.toLocusId();
        }
        activity.setLocusContext(locusId, bundle);
    }
}
