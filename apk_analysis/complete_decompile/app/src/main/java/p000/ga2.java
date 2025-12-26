package p000;

import android.app.RemoteInput;
import android.content.Intent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ga2 {
    @DoNotInline
    /* renamed from: a */
    public static int m4931a(Intent intent) {
        return RemoteInput.getResultsSource(intent);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m4932b(Intent intent, int i) {
        RemoteInput.setResultsSource(intent, i);
    }
}
