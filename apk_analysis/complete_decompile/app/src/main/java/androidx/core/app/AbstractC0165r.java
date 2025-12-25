package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: androidx.core.app.r */
/* loaded from: classes.dex */
public abstract class AbstractC0165r {
    @DoNotInline
    /* renamed from: a */
    public static Notification.CallStyle m766a(@NonNull android.app.Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.CallStyle m767b(@NonNull android.app.Person person, @NonNull PendingIntent pendingIntent) {
        return Notification.CallStyle.forOngoingCall(person, pendingIntent);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.CallStyle m768c(@NonNull android.app.Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.CallStyle m769d(Notification.CallStyle callStyle, @ColorInt int i) {
        return callStyle.setAnswerButtonColorHint(i);
    }

    @DoNotInline
    /* renamed from: e */
    public static Notification.Action.Builder m770e(Notification.Action.Builder builder, boolean z) {
        return builder.setAuthenticationRequired(z);
    }

    @DoNotInline
    /* renamed from: f */
    public static Notification.CallStyle m771f(Notification.CallStyle callStyle, @ColorInt int i) {
        return callStyle.setDeclineButtonColorHint(i);
    }

    @DoNotInline
    /* renamed from: g */
    public static Notification.CallStyle m772g(Notification.CallStyle callStyle, boolean z) {
        return callStyle.setIsVideo(z);
    }

    @DoNotInline
    /* renamed from: h */
    public static Notification.CallStyle m773h(Notification.CallStyle callStyle, @Nullable Icon icon) {
        return callStyle.setVerificationIcon(icon);
    }

    @DoNotInline
    /* renamed from: i */
    public static Notification.CallStyle m774i(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
        return callStyle.setVerificationText(charSequence);
    }
}
