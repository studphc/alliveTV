package p000;

import android.app.Notification;
import android.content.LocusId;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ls1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m5978a(Notification.Builder builder, boolean z) {
        return builder.setAllowSystemGeneratedContextualActions(z);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m5979b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Action.Builder m5980c(Notification.Action.Builder builder, boolean z) {
        return builder.setContextual(z);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Builder m5981d(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}
