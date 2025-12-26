package androidx.core.app;

import android.app.RemoteInput;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.s */
/* loaded from: classes.dex */
public abstract class AbstractC0166s {
    @DoNotInline
    /* renamed from: a */
    public static RemoteInput.Builder m775a(RemoteInput.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    @DoNotInline
    /* renamed from: b */
    public static android.app.RemoteInput m776b(RemoteInput.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: c */
    public static Parcelable m777c(android.app.RemoteInput remoteInput) {
        return remoteInput;
    }

    @DoNotInline
    /* renamed from: d */
    public static RemoteInput.Builder m778d(String str) {
        return new RemoteInput.Builder(str);
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m779e(android.app.RemoteInput remoteInput) {
        return remoteInput.getAllowFreeFormInput();
    }

    @DoNotInline
    /* renamed from: f */
    public static CharSequence[] m780f(android.app.RemoteInput remoteInput) {
        return remoteInput.getChoices();
    }

    @DoNotInline
    /* renamed from: g */
    public static Bundle m781g(android.app.RemoteInput remoteInput) {
        return remoteInput.getExtras();
    }

    @DoNotInline
    /* renamed from: h */
    public static CharSequence m782h(android.app.RemoteInput remoteInput) {
        return remoteInput.getLabel();
    }

    @DoNotInline
    /* renamed from: i */
    public static String m783i(android.app.RemoteInput remoteInput) {
        return remoteInput.getResultKey();
    }

    @DoNotInline
    /* renamed from: j */
    public static RemoteInput.Builder m784j(RemoteInput.Builder builder, boolean z) {
        return builder.setAllowFreeFormInput(z);
    }

    @DoNotInline
    /* renamed from: k */
    public static RemoteInput.Builder m785k(RemoteInput.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setChoices(charSequenceArr);
    }

    @DoNotInline
    /* renamed from: l */
    public static RemoteInput.Builder m786l(RemoteInput.Builder builder, CharSequence charSequence) {
        return builder.setLabel(charSequence);
    }
}
