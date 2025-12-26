package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;
import androidx.annotation.DoNotInline;

/* renamed from: android.support.v4.media.session.r */
/* loaded from: classes.dex */
public abstract class AbstractC0062r {
    @DoNotInline
    /* renamed from: a */
    public static MediaSession.QueueItem m139a(MediaDescription mediaDescription, long j) {
        return new MediaSession.QueueItem(mediaDescription, j);
    }

    @DoNotInline
    /* renamed from: b */
    public static MediaDescription m140b(MediaSession.QueueItem queueItem) {
        return queueItem.getDescription();
    }

    @DoNotInline
    /* renamed from: c */
    public static long m141c(MediaSession.QueueItem queueItem) {
        return queueItem.getQueueId();
    }
}
