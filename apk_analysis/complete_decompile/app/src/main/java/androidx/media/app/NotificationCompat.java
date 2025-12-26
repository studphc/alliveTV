package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;
import p000.vr1;
import p000.xr1;
import p000.zr1;

/* loaded from: classes.dex */
public class NotificationCompat {

    /* loaded from: classes.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                xr1.m8182d(notificationBuilderWithBuilderAccessor.getBuilder(), xr1.m8180b(zr1.m8427a(), this.f6685d, this.f6686e));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        /* renamed from: e */
        public final void m1556e(RemoteViews remoteViews) {
            int color;
            if (this.mBuilder.getColor() != 0) {
                color = this.mBuilder.getColor();
            } else {
                color = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            }
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", color);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getBigContentView() != null) {
                contentView = this.mBuilder.getBigContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews m1557c = m1557c();
            buildIntoRemoteViews(m1557c, contentView);
            m1556e(m1557c);
            return m1557c;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z;
            int i;
            int min;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getContentView() != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z && this.mBuilder.getBigContentView() == null) {
                return null;
            }
            if (this.mBuilder.getContentView() != null) {
                i = R.layout.notification_template_media_custom;
            } else {
                i = R.layout.notification_template_media;
            }
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, i, true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.f6685d;
            if (iArr == null) {
                min = 0;
            } else {
                min = Math.min(iArr.length, 3);
            }
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i2 = 0; i2 < min; i2++) {
                    if (i2 < size) {
                        applyStandardTemplate.addView(R.id.media_actions, m1558d(this.mBuilder.mActions.get(this.f6685d[i2])));
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    }
                }
            }
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            if (z) {
                buildIntoRemoteViews(applyStandardTemplate, this.mBuilder.getContentView());
            }
            m1556e(applyStandardTemplate);
            return applyStandardTemplate;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getHeadsUpContentView() != null) {
                contentView = this.mBuilder.getHeadsUpContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews m1557c = m1557c();
            buildIntoRemoteViews(m1557c, contentView);
            m1556e(m1557c);
            return m1557c;
        }
    }

    /* loaded from: classes.dex */
    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: d */
        public int[] f6685d = null;

        /* renamed from: e */
        public MediaSessionCompat.Token f6686e;

        public MediaStyle() {
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Parcelable parcelable;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras != null && (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) != null) {
                return MediaSessionCompat.Token.fromToken(parcelable);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            xr1.m8182d(notificationBuilderWithBuilderAccessor.getBuilder(), xr1.m8180b(xr1.m8179a(), this.f6685d, this.f6686e));
        }

        /* renamed from: c */
        public final RemoteViews m1557c() {
            int i;
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            if (min <= 3) {
                i = R.layout.notification_template_big_media_narrow_custom;
            } else {
                i = R.layout.notification_template_big_media_custom;
            }
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, i, false);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i2 = 0; i2 < min; i2++) {
                    applyStandardTemplate.addView(R.id.media_actions, m1558d(this.mBuilder.mActions.get(i2)));
                }
            }
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            return applyStandardTemplate;
        }

        /* renamed from: d */
        public final RemoteViews m1558d(NotificationCompat.Action action) {
            boolean z;
            if (action.getActionIntent() == null) {
                z = true;
            } else {
                z = false;
            }
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            int i = R.id.action0;
            remoteViews.setImageViewResource(i, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(i, action.getActionIntent());
            }
            vr1.m7930a(remoteViews, i, action.getTitle());
            return remoteViews;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f6686e = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f6685d = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
