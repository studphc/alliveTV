package androidx.core.app;

import android.app.Notification;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: androidx.core.app.k */
/* loaded from: classes.dex */
public abstract class AbstractC0158k {
    @Nullable
    @RequiresApi(30)
    /* renamed from: a */
    public static NotificationCompat.BubbleMetadata m746a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
        NotificationCompat.BubbleMetadata.Builder builder;
        if (bubbleMetadata == null) {
            return null;
        }
        if (bubbleMetadata.getShortcutId() != null) {
            builder = new NotificationCompat.BubbleMetadata.Builder(bubbleMetadata.getShortcutId());
        } else {
            builder = new NotificationCompat.BubbleMetadata.Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon()));
        }
        builder.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() != 0) {
            builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        }
        return builder.build();
    }

    @Nullable
    @RequiresApi(30)
    /* renamed from: b */
    public static Notification.BubbleMetadata m747b(@Nullable NotificationCompat.BubbleMetadata bubbleMetadata) {
        Notification.BubbleMetadata.Builder builder;
        if (bubbleMetadata == null) {
            return null;
        }
        if (bubbleMetadata.getShortcutId() != null) {
            builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId());
        } else {
            builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
        }
        builder.setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() != 0) {
            builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        }
        return builder.build();
    }
}
