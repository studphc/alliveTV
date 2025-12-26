package androidx.core.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.j0 */
/* loaded from: classes.dex */
public abstract class AbstractC0157j0 {
    @DoNotInline
    /* renamed from: a */
    public static void m744a(Object obj, Intent intent, Bundle bundle) {
        android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
    }

    @DoNotInline
    /* renamed from: b */
    public static Bundle m745b(Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }
}
