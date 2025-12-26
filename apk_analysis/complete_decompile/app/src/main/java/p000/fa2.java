package p000;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.DoNotInline;
import androidx.core.app.RemoteInput;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class fa2 {
    @DoNotInline
    /* renamed from: a */
    public static void m4790a(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        android.app.RemoteInput.addDataResultToIntent(RemoteInput.m708a(remoteInput), intent, map);
    }

    @DoNotInline
    /* renamed from: b */
    public static Set<String> m4791b(Object obj) {
        return ((android.app.RemoteInput) obj).getAllowedDataTypes();
    }

    @DoNotInline
    /* renamed from: c */
    public static Map<String, Uri> m4792c(Intent intent, String str) {
        return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
    }

    @DoNotInline
    /* renamed from: d */
    public static RemoteInput.Builder m4793d(RemoteInput.Builder builder, String str, boolean z) {
        return builder.setAllowDataType(str, z);
    }
}
