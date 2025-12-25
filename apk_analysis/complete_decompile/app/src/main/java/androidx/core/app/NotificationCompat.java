package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import p000.AbstractC1726qj;
import p000.as1;
import p000.bs1;
import p000.cs1;
import p000.ds1;
import p000.es1;
import p000.fa2;
import p000.ha2;
import p000.hm1;
import p000.uk1;
import p000.wr1;
import p000.yr1;

/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";

    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON = "android.callPerson";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_TYPE = "android.callType";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";

    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* loaded from: classes.dex */
    public static class Action {
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;

        /* renamed from: a */
        public final Bundle f3312a;

        @Nullable
        public PendingIntent actionIntent;

        /* renamed from: b */
        public IconCompat f3313b;

        /* renamed from: c */
        public final RemoteInput[] f3314c;

        /* renamed from: d */
        public final RemoteInput[] f3315d;

        /* renamed from: e */
        public final boolean f3316e;

        /* renamed from: f */
        public final boolean f3317f;

        /* renamed from: g */
        public final int f3318g;

        /* renamed from: h */
        public final boolean f3319h;

        /* renamed from: i */
        public final boolean f3320i;

        @Deprecated
        public int icon;
        public CharSequence title;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public final IconCompat f3321a;

            /* renamed from: b */
            public final CharSequence f3322b;

            /* renamed from: c */
            public final PendingIntent f3323c;

            /* renamed from: d */
            public boolean f3324d;

            /* renamed from: e */
            public final Bundle f3325e;

            /* renamed from: f */
            public ArrayList f3326f;

            /* renamed from: g */
            public int f3327g;

            /* renamed from: h */
            public boolean f3328h;

            /* renamed from: i */
            public boolean f3329i;

            /* renamed from: j */
            public boolean f3330j;

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action action) {
                Builder builder;
                Set<String> m4791b;
                if (AbstractC0142c.m722a(action) != null) {
                    builder = new Builder(IconCompat.createFromIconOrNullIfZeroResId(AbstractC0142c.m722a(action)), action.title, action.actionIntent);
                } else {
                    builder = new Builder(action.icon, action.title, action.actionIntent);
                }
                android.app.RemoteInput[] m716b = AbstractC0140b.m716b(action);
                if (m716b != null && m716b.length != 0) {
                    for (android.app.RemoteInput remoteInput : m716b) {
                        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
                        if (Build.VERSION.SDK_INT >= 26 && (m4791b = fa2.m4791b(remoteInput)) != null) {
                            Iterator<String> it = m4791b.iterator();
                            while (it.hasNext()) {
                                addExtras.setAllowDataType(it.next(), true);
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 29) {
                            addExtras.setEditChoicesBeforeSending(ha2.m5047a(remoteInput));
                        }
                        builder.addRemoteInput(addExtras.build());
                    }
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    builder.f3324d = AbstractC0144d.m724a(action);
                }
                if (i >= 28) {
                    builder.setSemanticAction(AbstractC0146e.m726a(action));
                }
                if (i >= 29) {
                    builder.setContextual(AbstractC0148f.m728a(action));
                }
                if (i >= 31) {
                    builder.setAuthenticationRequired(AbstractC0150g.m732a(action));
                }
                builder.addExtras(AbstractC0140b.m715a(action));
                return builder;
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle bundle) {
                if (bundle != null) {
                    this.f3325e.putAll(bundle);
                }
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput remoteInput) {
                if (this.f3326f == null) {
                    this.f3326f = new ArrayList();
                }
                if (remoteInput != null) {
                    this.f3326f.add(remoteInput);
                }
                return this;
            }

            @NonNull
            public Action build() {
                RemoteInput[] remoteInputArr;
                if (!this.f3329i || this.f3323c != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = this.f3326f;
                    if (arrayList3 != null) {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RemoteInput remoteInput = (RemoteInput) it.next();
                            if (remoteInput.isDataOnly()) {
                                arrayList.add(remoteInput);
                            } else {
                                arrayList2.add(remoteInput);
                            }
                        }
                    }
                    RemoteInput[] remoteInputArr2 = null;
                    if (arrayList.isEmpty()) {
                        remoteInputArr = null;
                    } else {
                        remoteInputArr = (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                    }
                    if (!arrayList2.isEmpty()) {
                        remoteInputArr2 = (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]);
                    }
                    return new Action(this.f3321a, this.f3322b, this.f3323c, this.f3325e, remoteInputArr2, remoteInputArr, this.f3324d, this.f3327g, this.f3328h, this.f3329i, this.f3330j);
                }
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            @NonNull
            public Builder extend(@NonNull Extender extender) {
                extender.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.f3325e;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean z) {
                this.f3324d = z;
                return this;
            }

            @NonNull
            public Builder setAuthenticationRequired(boolean z) {
                this.f3330j = z;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean z) {
                this.f3329i = z;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int i) {
                this.f3327g = i;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean z) {
                this.f3328h = z;
                return this;
            }

            public Builder(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(@NonNull Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.f3312a), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.f3317f, action.isContextual(), action.isAuthenticationRequired());
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3, boolean z4) {
                this.f3324d = true;
                this.f3328h = true;
                this.f3321a = iconCompat;
                this.f3322b = Builder.limitCharSequenceLength(charSequence);
                this.f3323c = pendingIntent;
                this.f3325e = bundle;
                this.f3326f = remoteInputArr == null ? null : new ArrayList(Arrays.asList(remoteInputArr));
                this.f3324d = z;
                this.f3327g = i;
                this.f3328h = z2;
                this.f3329i = z3;
                this.f3330j = z4;
            }
        }

        /* loaded from: classes.dex */
        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface SemanticAction {
        }

        /* loaded from: classes.dex */
        public static final class WearableExtender implements Extender {

            /* renamed from: a */
            public int f3331a;

            /* renamed from: b */
            public CharSequence f3332b;

            /* renamed from: c */
            public CharSequence f3333c;

            /* renamed from: d */
            public CharSequence f3334d;

            public WearableExtender() {
                this.f3331a = 1;
            }

            /* renamed from: a */
            public final void m695a(int i, boolean z) {
                if (z) {
                    this.f3331a = i | this.f3331a;
                } else {
                    this.f3331a = (~i) & this.f3331a;
                }
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            @NonNull
            public Builder extend(@NonNull Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.f3331a;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.f3332b;
                if (charSequence != null) {
                    bundle.putCharSequence("inProgressLabel", charSequence);
                }
                CharSequence charSequence2 = this.f3333c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("confirmLabel", charSequence2);
                }
                CharSequence charSequence3 = this.f3334d;
                if (charSequence3 != null) {
                    bundle.putCharSequence("cancelLabel", charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            @Nullable
            @Deprecated
            public CharSequence getCancelLabel() {
                return this.f3334d;
            }

            @Nullable
            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.f3333c;
            }

            public boolean getHintDisplayActionInline() {
                if ((this.f3331a & 4) != 0) {
                    return true;
                }
                return false;
            }

            public boolean getHintLaunchesActivity() {
                if ((this.f3331a & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Nullable
            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.f3332b;
            }

            public boolean isAvailableOffline() {
                if ((this.f3331a & 1) != 0) {
                    return true;
                }
                return false;
            }

            @NonNull
            public WearableExtender setAvailableOffline(boolean z) {
                m695a(1, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence charSequence) {
                this.f3334d = charSequence;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence charSequence) {
                this.f3333c = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean z) {
                m695a(4, z);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean z) {
                m695a(2, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence charSequence) {
                this.f3332b = charSequence;
                return this;
            }

            @NonNull
            /* renamed from: clone, reason: merged with bridge method [inline-methods] */
            public WearableExtender m8479clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f3331a = this.f3331a;
                wearableExtender.f3332b = this.f3332b;
                wearableExtender.f3333c = this.f3333c;
                wearableExtender.f3334d = this.f3334d;
                return wearableExtender;
            }

            public WearableExtender(@NonNull Action action) {
                this.f3331a = 1;
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f3331a = bundle.getInt("flags", 1);
                    this.f3332b = bundle.getCharSequence("inProgressLabel");
                    this.f3333c = bundle.getCharSequence("confirmLabel");
                    this.f3334d = bundle.getCharSequence("cancelLabel");
                }
            }
        }

        public Action(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent);
        }

        @Nullable
        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f3316e;
        }

        @Nullable
        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.f3315d;
        }

        @NonNull
        public Bundle getExtras() {
            return this.f3312a;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            int i;
            if (this.f3313b == null && (i = this.icon) != 0) {
                this.f3313b = IconCompat.createWithResource(null, "", i);
            }
            return this.f3313b;
        }

        @Nullable
        public RemoteInput[] getRemoteInputs() {
            return this.f3314c;
        }

        public int getSemanticAction() {
            return this.f3318g;
        }

        public boolean getShowsUserInterface() {
            return this.f3317f;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.f3320i;
        }

        public boolean isContextual() {
            return this.f3319h;
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i2, z2, z3, z4);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.f3317f = true;
            this.f3313b = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.f3312a = bundle == null ? new Bundle() : bundle;
            this.f3314c = remoteInputArr;
            this.f3315d = remoteInputArr2;
            this.f3316e = z;
            this.f3318g = i;
            this.f3317f = z2;
            this.f3319h = z3;
            this.f3320i = z4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface BadgeIconType {
    }

    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {

        /* renamed from: d */
        public IconCompat f3335d;

        /* renamed from: e */
        public IconCompat f3336e;

        /* renamed from: f */
        public boolean f3337f;

        /* renamed from: g */
        public CharSequence f3338g;

        /* renamed from: h */
        public boolean f3339h;

        public BigPictureStyle() {
        }

        /* renamed from: c */
        public static IconCompat m696c(Parcelable parcelable) {
            if (parcelable != null) {
                if (parcelable instanceof Icon) {
                    return IconCompat.createFromIcon((Icon) parcelable);
                }
                if (parcelable instanceof Bitmap) {
                    return IconCompat.createWithBitmap((Bitmap) parcelable);
                }
                return null;
            }
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat getPictureIcon(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (parcelable != null) {
                return m696c(parcelable);
            }
            return m696c(bundle.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Context context;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f3438a);
            IconCompat iconCompat = this.f3335d;
            Context context2 = null;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (notificationBuilderWithBuilderAccessor instanceof C0149f0) {
                        context = ((C0149f0) notificationBuilderWithBuilderAccessor).f3514a;
                    } else {
                        context = null;
                    }
                    AbstractC0154i.m737a(bigContentTitle, iconCompat.toIcon(context));
                } else if (iconCompat.getType() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f3335d.getBitmap());
                }
            }
            if (this.f3337f) {
                IconCompat iconCompat2 = this.f3336e;
                if (iconCompat2 == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    if (notificationBuilderWithBuilderAccessor instanceof C0149f0) {
                        context2 = ((C0149f0) notificationBuilderWithBuilderAccessor).f3514a;
                    }
                    AbstractC0152h.m734a(bigContentTitle, iconCompat2.toIcon(context2));
                }
            }
            if (this.f3440c) {
                bigContentTitle.setSummaryText(this.f3439b);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                AbstractC0154i.m739c(bigContentTitle, this.f3339h);
                AbstractC0154i.m738b(bigContentTitle, this.f3338g);
            }
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap bitmap) {
            this.f3336e = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
            this.f3337f = true;
            return this;
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap bitmap) {
            this.f3335d = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            bundle.remove(NotificationCompat.EXTRA_PICTURE);
            bundle.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            bundle.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            if (bundle.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.f3336e = m696c(bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
                this.f3337f = true;
            }
            this.f3335d = getPictureIcon(bundle);
            this.f3339h = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f3438a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle setContentDescription(@Nullable CharSequence charSequence) {
            this.f3338g = charSequence;
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f3439b = Builder.limitCharSequenceLength(charSequence);
            this.f3440c = true;
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle showBigPictureWhenCollapsed(boolean z) {
            this.f3339h = z;
            return this;
        }

        public BigPictureStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle bigPicture(@Nullable Icon icon) {
            this.f3335d = IconCompat.createFromIcon(icon);
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public BigPictureStyle bigLargeIcon(@Nullable Icon icon) {
            this.f3336e = icon == null ? null : IconCompat.createFromIcon(icon);
            this.f3337f = true;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {

        /* renamed from: d */
        public CharSequence f3340d;

        public BigTextStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f3438a).bigText(this.f3340d);
            if (this.f3440c) {
                bigText.setSummaryText(this.f3439b);
            }
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence charSequence) {
            this.f3340d = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.f3340d = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f3438a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f3439b = Builder.limitCharSequenceLength(charSequence);
            this.f3440c = true;
            return this;
        }

        public BigTextStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static final class BubbleMetadata {

        /* renamed from: a */
        public PendingIntent f3341a;

        /* renamed from: b */
        public PendingIntent f3342b;

        /* renamed from: c */
        public IconCompat f3343c;

        /* renamed from: d */
        public int f3344d;

        /* renamed from: e */
        public int f3345e;

        /* renamed from: f */
        public int f3346f;

        /* renamed from: g */
        public String f3347g;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public PendingIntent f3348a;

            /* renamed from: b */
            public IconCompat f3349b;

            /* renamed from: c */
            public int f3350c;

            /* renamed from: d */
            public int f3351d;

            /* renamed from: e */
            public int f3352e;

            /* renamed from: f */
            public PendingIntent f3353f;

            /* renamed from: g */
            public final String f3354g;

            @Deprecated
            public Builder() {
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [androidx.core.app.NotificationCompat$BubbleMetadata, java.lang.Object] */
            @NonNull
            public BubbleMetadata build() {
                String str = this.f3354g;
                if (str == null && this.f3348a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f3349b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                PendingIntent pendingIntent = this.f3348a;
                PendingIntent pendingIntent2 = this.f3353f;
                IconCompat iconCompat = this.f3349b;
                int i = this.f3350c;
                int i2 = this.f3351d;
                int i3 = this.f3352e;
                ?? obj = new Object();
                obj.f3341a = pendingIntent;
                obj.f3343c = iconCompat;
                obj.f3344d = i;
                obj.f3345e = i2;
                obj.f3342b = pendingIntent2;
                obj.f3346f = i3;
                obj.f3347g = str;
                obj.setFlags(i3);
                return obj;
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z) {
                if (z) {
                    this.f3352e |= 1;
                } else {
                    this.f3352e &= -2;
                }
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                this.f3353f = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i) {
                this.f3350c = Math.max(i, 0);
                this.f3351d = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i) {
                this.f3351d = i;
                this.f3350c = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                if (this.f3354g == null) {
                    if (iconCompat != null) {
                        this.f3349b = iconCompat;
                        return this;
                    }
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                if (this.f3354g == null) {
                    if (pendingIntent != null) {
                        this.f3348a = pendingIntent;
                        return this;
                    }
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setSuppressNotification(boolean z) {
                if (z) {
                    this.f3352e |= 2;
                } else {
                    this.f3352e &= -3;
                }
                return this;
            }

            @RequiresApi(30)
            public Builder(@NonNull String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.f3354g = str;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            public Builder(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat != null) {
                    this.f3348a = pendingIntent;
                    this.f3349b = iconCompat;
                    return;
                }
                throw new NullPointerException("Bubbles require non-null icon");
            }
        }

        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return AbstractC0158k.m746a(bubbleMetadata);
            }
            if (i != 29) {
                return null;
            }
            return AbstractC0156j.m742a(bubbleMetadata);
        }

        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return AbstractC0158k.m747b(bubbleMetadata);
            }
            if (i != 29) {
                return null;
            }
            return AbstractC0156j.m743b(bubbleMetadata);
        }

        public boolean getAutoExpandBubble() {
            if ((this.f3346f & 1) != 0) {
                return true;
            }
            return false;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.f3342b;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.f3344d;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.f3345e;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat getIcon() {
            return this.f3343c;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent getIntent() {
            return this.f3341a;
        }

        @Nullable
        public String getShortcutId() {
            return this.f3347g;
        }

        public boolean isNotificationSuppressed() {
            if ((this.f3346f & 2) != 0) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setFlags(int i) {
            this.f3346f = i;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: A */
        public String f3355A;

        /* renamed from: B */
        public Bundle f3356B;

        /* renamed from: C */
        public int f3357C;

        /* renamed from: D */
        public int f3358D;

        /* renamed from: E */
        public Notification f3359E;

        /* renamed from: F */
        public RemoteViews f3360F;

        /* renamed from: G */
        public RemoteViews f3361G;

        /* renamed from: H */
        public RemoteViews f3362H;

        /* renamed from: I */
        public String f3363I;

        /* renamed from: J */
        public int f3364J;

        /* renamed from: K */
        public String f3365K;

        /* renamed from: L */
        public LocusIdCompat f3366L;

        /* renamed from: M */
        public long f3367M;

        /* renamed from: N */
        public int f3368N;

        /* renamed from: O */
        public int f3369O;

        /* renamed from: P */
        public boolean f3370P;

        /* renamed from: Q */
        public BubbleMetadata f3371Q;

        /* renamed from: R */
        public final Notification f3372R;

        /* renamed from: S */
        public boolean f3373S;

        /* renamed from: T */
        public Icon f3374T;

        /* renamed from: a */
        public final ArrayList f3375a;

        /* renamed from: b */
        public CharSequence f3376b;

        /* renamed from: c */
        public CharSequence f3377c;

        /* renamed from: d */
        public PendingIntent f3378d;

        /* renamed from: e */
        public PendingIntent f3379e;

        /* renamed from: f */
        public RemoteViews f3380f;

        /* renamed from: g */
        public IconCompat f3381g;

        /* renamed from: h */
        public CharSequence f3382h;

        /* renamed from: i */
        public int f3383i;

        /* renamed from: j */
        public int f3384j;

        /* renamed from: k */
        public boolean f3385k;

        /* renamed from: l */
        public boolean f3386l;

        /* renamed from: m */
        public boolean f3387m;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;

        @Deprecated
        public ArrayList<String> mPeople;

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Person> mPersonList;

        /* renamed from: n */
        public Style f3388n;

        /* renamed from: o */
        public CharSequence f3389o;

        /* renamed from: p */
        public CharSequence f3390p;

        /* renamed from: q */
        public CharSequence[] f3391q;

        /* renamed from: r */
        public int f3392r;

        /* renamed from: s */
        public int f3393s;

        /* renamed from: t */
        public boolean f3394t;

        /* renamed from: u */
        public String f3395u;

        /* renamed from: v */
        public boolean f3396v;

        /* renamed from: w */
        public String f3397w;

        /* renamed from: x */
        public boolean f3398x;

        /* renamed from: y */
        public boolean f3399y;

        /* renamed from: z */
        public boolean f3400z;

        public Builder(@NonNull Context context, @NonNull Notification notification) {
            this(context, NotificationCompat.getChannelId(notification));
            Bundle bundle;
            ArrayList parcelableArrayList;
            Bundle bundle2 = notification.extras;
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            Builder smallIcon = setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(extractStyleFromNotification).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, (notification.flags & 128) != 0).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(bundle2.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), bundle2.getInt(NotificationCompat.EXTRA_PROGRESS), bundle2.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel);
            if (notification.extras == null) {
                bundle = null;
            } else {
                Bundle bundle3 = new Bundle(notification.extras);
                bundle3.remove(NotificationCompat.EXTRA_TITLE);
                bundle3.remove(NotificationCompat.EXTRA_TEXT);
                bundle3.remove(NotificationCompat.EXTRA_INFO_TEXT);
                bundle3.remove(NotificationCompat.EXTRA_SUB_TEXT);
                bundle3.remove(NotificationCompat.EXTRA_CHANNEL_ID);
                bundle3.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
                bundle3.remove(NotificationCompat.EXTRA_SHOW_WHEN);
                bundle3.remove(NotificationCompat.EXTRA_PROGRESS);
                bundle3.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
                bundle3.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
                bundle3.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
                bundle3.remove(NotificationCompat.EXTRA_COLORIZED);
                bundle3.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
                bundle3.remove(NotificationCompat.EXTRA_PEOPLE);
                bundle3.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
                bundle3.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
                bundle3.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
                bundle3.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
                bundle3.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
                Bundle bundle4 = bundle3.getBundle("android.car.EXTENSIONS");
                if (bundle4 != null) {
                    Bundle bundle5 = new Bundle(bundle4);
                    bundle5.remove("invisible_actions");
                    bundle3.putBundle("android.car.EXTENSIONS", bundle5);
                }
                if (extractStyleFromNotification != null) {
                    extractStyleFromNotification.clearCompatExtraKeys(bundle3);
                }
                bundle = bundle3;
            }
            smallIcon.addExtras(bundle);
            this.f3374T = AbstractC0160m.m754b(notification);
            Icon m753a = AbstractC0160m.m753a(notification);
            if (m753a != null) {
                this.f3381g = IconCompat.createFromIcon(m753a);
            }
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null && actionArr.length != 0) {
                for (Notification.Action action : actionArr) {
                    addAction(Action.Builder.fromAndroidAction(action).build());
                }
            }
            List<Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
            if (!invisibleActions.isEmpty()) {
                Iterator<Action> it = invisibleActions.iterator();
                while (it.hasNext()) {
                    addInvisibleAction(it.next());
                }
            }
            String[] stringArray = notification.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    addPerson(str);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    addPerson(Person.fromAndroidPerson(hm1.m5099g(it2.next())));
                }
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24 && bundle2.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(bundle2.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (i < 26 || !bundle2.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                return;
            }
            setColorized(bundle2.getBoolean(NotificationCompat.EXTRA_COLORIZED));
        }

        @Nullable
        public static CharSequence limitCharSequenceLength(@Nullable CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        /* renamed from: a */
        public final void m697a(int i, boolean z) {
            Notification notification = this.f3372R;
            if (z) {
                notification.flags = i | notification.flags;
            } else {
                notification.flags = (~i) & notification.flags;
            }
        }

        @NonNull
        public Builder addAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.f3356B;
                if (bundle2 == null) {
                    this.f3356B = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f3375a.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String str) {
            if (str != null && !str.isEmpty()) {
                this.mPeople.add(str);
            }
            return this;
        }

        @NonNull
        public Notification build() {
            return new C0149f0(this).m731b();
        }

        @NonNull
        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        public Builder clearInvisibleActions() {
            this.f3375a.clear();
            Bundle bundle = this.f3356B.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.f3356B.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @NonNull
        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createBigContentView() {
            RemoteViews makeBigContentView;
            Style style;
            if (this.f3361G != null && ((style = this.f3388n) == null || !style.displayCustomViewInline())) {
                return this.f3361G;
            }
            C0149f0 c0149f0 = new C0149f0(this);
            Style style2 = this.f3388n;
            if (style2 != null && (makeBigContentView = style2.makeBigContentView(c0149f0)) != null) {
                return makeBigContentView;
            }
            Notification m731b = c0149f0.m731b();
            if (Build.VERSION.SDK_INT >= 24) {
                return AbstractC0161n.m755a(AbstractC0161n.m758d(this.mContext, m731b));
            }
            return m731b.bigContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createContentView() {
            RemoteViews makeContentView;
            Style style;
            if (this.f3360F != null && ((style = this.f3388n) == null || !style.displayCustomViewInline())) {
                return this.f3360F;
            }
            C0149f0 c0149f0 = new C0149f0(this);
            Style style2 = this.f3388n;
            if (style2 != null && (makeContentView = style2.makeContentView(c0149f0)) != null) {
                return makeContentView;
            }
            Notification m731b = c0149f0.m731b();
            if (Build.VERSION.SDK_INT >= 24) {
                return AbstractC0161n.m756b(AbstractC0161n.m758d(this.mContext, m731b));
            }
            return m731b.contentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createHeadsUpContentView() {
            RemoteViews makeHeadsUpContentView;
            Style style;
            int i = Build.VERSION.SDK_INT;
            if (this.f3362H != null && ((style = this.f3388n) == null || !style.displayCustomViewInline())) {
                return this.f3362H;
            }
            C0149f0 c0149f0 = new C0149f0(this);
            Style style2 = this.f3388n;
            if (style2 != null && (makeHeadsUpContentView = style2.makeHeadsUpContentView(c0149f0)) != null) {
                return makeHeadsUpContentView;
            }
            Notification m731b = c0149f0.m731b();
            if (i >= 24) {
                return AbstractC0161n.m757c(AbstractC0161n.m758d(this.mContext, m731b));
            }
            return m731b.headsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.f3361G;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.f3371Q;
        }

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.f3357C;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.f3360F;
        }

        @NonNull
        public Bundle getExtras() {
            if (this.f3356B == null) {
                this.f3356B = new Bundle();
            }
            return this.f3356B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getForegroundServiceBehavior() {
            return this.f3369O;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.f3362H;
        }

        @NonNull
        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.f3384j;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.f3385k) {
                return this.f3372R.when;
            }
            return 0L;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z) {
            this.f3370P = z;
            return this;
        }

        @NonNull
        public Builder setAutoCancel(boolean z) {
            m697a(16, z);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int i) {
            this.f3364J = i;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            this.f3371Q = bubbleMetadata;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String str) {
            this.f3355A = str;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String str) {
            this.f3363I = str;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean z) {
            this.f3387m = z;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int i) {
            this.f3357C = i;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean z) {
            this.f3399y = z;
            this.f3400z = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews remoteViews) {
            this.f3372R.contentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence charSequence) {
            this.f3382h = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent pendingIntent) {
            this.f3378d = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence charSequence) {
            this.f3377c = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence charSequence) {
            this.f3376b = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews remoteViews) {
            this.f3361G = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews remoteViews) {
            this.f3360F = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews remoteViews) {
            this.f3362H = remoteViews;
            return this;
        }

        @NonNull
        public Builder setDefaults(int i) {
            Notification notification = this.f3372R;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
            this.f3372R.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.f3356B = bundle;
            return this;
        }

        @NonNull
        public Builder setForegroundServiceBehavior(int i) {
            this.f3369O = i;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent pendingIntent, boolean z) {
            this.f3379e = pendingIntent;
            m697a(128, z);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.f3395u = str;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int i) {
            this.f3368N = i;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean z) {
            this.f3396v = z;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap bitmap) {
            this.f3381g = bitmap == null ? null : IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, bitmap));
            return this;
        }

        @NonNull
        public Builder setLights(@ColorInt int i, int i2, int i3) {
            int i4;
            Notification notification = this.f3372R;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            if (i2 != 0 && i3 != 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            notification.flags = i4 | (notification.flags & (-2));
            return this;
        }

        @NonNull
        public Builder setLocalOnly(boolean z) {
            this.f3398x = z;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.f3366L = locusIdCompat;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.f3373S = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int i) {
            this.f3383i = i;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean z) {
            m697a(2, z);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean z) {
            m697a(8, z);
            return this;
        }

        @NonNull
        public Builder setPriority(int i) {
            this.f3384j = i;
            return this;
        }

        @NonNull
        public Builder setProgress(int i, int i2, boolean z) {
            this.f3392r = i;
            this.f3393s = i2;
            this.f3394t = z;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification notification) {
            this.f3359E = notification;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] charSequenceArr) {
            this.f3391q = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence charSequence) {
            this.f3390p = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String str) {
            this.f3365K = str;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.f3365K = shortcutInfoCompat.getId();
            if (this.f3366L == null) {
                if (shortcutInfoCompat.getLocusId() != null) {
                    this.f3366L = shortcutInfoCompat.getLocusId();
                } else if (shortcutInfoCompat.getId() != null) {
                    this.f3366L = new LocusIdCompat(shortcutInfoCompat.getId());
                }
            }
            if (this.f3376b == null) {
                setContentTitle(shortcutInfoCompat.getShortLabel());
            }
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean z) {
            this.f3385k = z;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean z) {
            this.f3373S = z;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setSmallIcon(@NonNull IconCompat iconCompat) {
            this.f3374T = iconCompat.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String str) {
            this.f3397w = str;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri) {
            Notification notification = this.f3372R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = AbstractC0159l.m748a(AbstractC0159l.m752e(AbstractC0159l.m750c(AbstractC0159l.m749b(), 4), 5));
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style style) {
            if (this.f3388n != style) {
                this.f3388n = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence charSequence) {
            this.f3389o = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence charSequence) {
            this.f3372R.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long j) {
            this.f3367M = j;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean z) {
            this.f3386l = z;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] jArr) {
            this.f3372R.vibrate = jArr;
            return this;
        }

        @NonNull
        public Builder setVisibility(int i) {
            this.f3358D = i;
            return this;
        }

        @NonNull
        public Builder setWhen(long j) {
            this.f3372R.when = j;
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(@Nullable Action action) {
            if (action != null) {
                this.f3375a.add(action);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i) {
            this.f3372R.icon = i;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence charSequence, @Nullable RemoteViews remoteViews) {
            this.f3372R.tickerText = limitCharSequenceLength(charSequence);
            this.f3380f = remoteViews;
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i, int i2) {
            Notification notification = this.f3372R;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setLargeIcon(@Nullable Icon icon) {
            this.f3381g = icon == null ? null : IconCompat.createFromIcon(icon);
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, int i) {
            Notification notification = this.f3372R;
            notification.sound = uri;
            notification.audioStreamType = i;
            notification.audioAttributes = AbstractC0159l.m748a(AbstractC0159l.m751d(AbstractC0159l.m750c(AbstractC0159l.m749b(), 4), i));
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.mPersonList = new ArrayList<>();
            this.f3375a = new ArrayList();
            this.f3385k = true;
            this.f3398x = false;
            this.f3357C = 0;
            this.f3358D = 0;
            this.f3364J = 0;
            this.f3368N = 0;
            this.f3369O = 0;
            Notification notification = new Notification();
            this.f3372R = notification;
            this.mContext = context;
            this.f3363I = str;
            notification.when = System.currentTimeMillis();
            notification.audioStreamType = -1;
            this.f3384j = 0;
            this.mPeople = new ArrayList<>();
            this.f3370P = true;
        }

        @Deprecated
        public Builder(@NonNull Context context) {
            this(context, (String) null);
        }
    }

    /* loaded from: classes.dex */
    public static class CallStyle extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;

        /* renamed from: d */
        public int f3401d;

        /* renamed from: e */
        public Person f3402e;

        /* renamed from: f */
        public PendingIntent f3403f;

        /* renamed from: g */
        public PendingIntent f3404g;

        /* renamed from: h */
        public PendingIntent f3405h;

        /* renamed from: i */
        public boolean f3406i;

        /* renamed from: j */
        public Integer f3407j;

        /* renamed from: k */
        public Integer f3408k;

        /* renamed from: l */
        public IconCompat f3409l;

        /* renamed from: m */
        public CharSequence f3410m;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* loaded from: classes.dex */
        public @interface CallType {
        }

        public CallStyle() {
        }

        @NonNull
        public static CallStyle forIncomingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(1, person, null, pendingIntent, pendingIntent2);
        }

        @NonNull
        public static CallStyle forOngoingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            return new CallStyle(2, person, pendingIntent, null, null);
        }

        @NonNull
        public static CallStyle forScreeningCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(3, person, pendingIntent, null, pendingIntent2);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.f3401d);
            bundle.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.f3406i);
            Person person = this.f3402e;
            if (person != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, AbstractC0164q.m765b(person.toAndroidPerson()));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, person.toBundle());
                }
            }
            IconCompat iconCompat = this.f3409l;
            if (iconCompat != null) {
                bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, AbstractC0163p.m761a(iconCompat.toIcon(this.mBuilder.mContext)));
            }
            bundle.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.f3410m);
            bundle.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.f3403f);
            bundle.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.f3404g);
            bundle.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.f3405h);
            Integer num = this.f3407j;
            if (num != null) {
                bundle.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, num.intValue());
            }
            Integer num2 = this.f3408k;
            if (num2 != null) {
                bundle.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence charSequence;
            CharSequence charSequence2;
            int i = Build.VERSION.SDK_INT;
            String str = null;
            r5 = null;
            Notification.CallStyle m766a = null;
            if (i >= 31) {
                int i2 = this.f3401d;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (Log.isLoggable("NotifCompat", 3)) {
                                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f3401d));
                            }
                        } else {
                            m766a = AbstractC0165r.m768c(this.f3402e.toAndroidPerson(), this.f3405h, this.f3403f);
                        }
                    } else {
                        m766a = AbstractC0165r.m767b(this.f3402e.toAndroidPerson(), this.f3405h);
                    }
                } else {
                    m766a = AbstractC0165r.m766a(this.f3402e.toAndroidPerson(), this.f3404g, this.f3403f);
                }
                if (m766a != null) {
                    m766a.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                    Integer num = this.f3407j;
                    if (num != null) {
                        AbstractC0165r.m769d(m766a, num.intValue());
                    }
                    Integer num2 = this.f3408k;
                    if (num2 != null) {
                        AbstractC0165r.m771f(m766a, num2.intValue());
                    }
                    AbstractC0165r.m774i(m766a, this.f3410m);
                    IconCompat iconCompat = this.f3409l;
                    if (iconCompat != null) {
                        AbstractC0165r.m773h(m766a, iconCompat.toIcon(this.mBuilder.mContext));
                    }
                    AbstractC0165r.m772g(m766a, this.f3406i);
                    return;
                }
                return;
            }
            Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
            Person person = this.f3402e;
            if (person != null) {
                charSequence = person.getName();
            } else {
                charSequence = null;
            }
            builder.setContentTitle(charSequence);
            Bundle bundle = this.mBuilder.f3356B;
            if (bundle != null && bundle.containsKey(NotificationCompat.EXTRA_TEXT)) {
                charSequence2 = this.mBuilder.f3356B.getCharSequence(NotificationCompat.EXTRA_TEXT);
            } else {
                charSequence2 = null;
            }
            if (charSequence2 == null) {
                int i3 = this.f3401d;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            str = this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
                        }
                    } else {
                        str = this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
                    }
                } else {
                    str = this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
                }
                charSequence2 = str;
            }
            builder.setContentText(charSequence2);
            Person person2 = this.f3402e;
            if (person2 != null) {
                if (person2.getIcon() != null) {
                    AbstractC0163p.m763c(builder, this.f3402e.getIcon().toIcon(this.mBuilder.mContext));
                }
                if (i >= 28) {
                    AbstractC0164q.m764a(builder, this.f3402e.toAndroidPerson());
                } else {
                    AbstractC0162o.m759a(builder, this.f3402e.getUri());
                }
            }
            AbstractC0162o.m760b(builder, NotificationCompat.CATEGORY_CALL);
        }

        /* renamed from: c */
        public final Action m698c(int i, int i2, Integer num, int i3, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, i3));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.mBuilder.mContext.getResources().getString(i2));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action build = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, i), spannableStringBuilder, pendingIntent).build();
            build.getExtras().putBoolean("key_action_priority", true);
            return build;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @NonNull
        @RequiresApi(20)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> getActionsListWithSystemActions() {
            Action m698c;
            int i;
            int i2;
            Action m698c2;
            int i3 = R.drawable.ic_call_decline;
            PendingIntent pendingIntent = this.f3404g;
            if (pendingIntent == null) {
                m698c = m698c(i3, R.string.call_notification_hang_up_action, this.f3408k, R.color.call_notification_decline_color, this.f3405h);
            } else {
                m698c = m698c(i3, R.string.call_notification_decline_action, this.f3408k, R.color.call_notification_decline_color, pendingIntent);
            }
            int i4 = R.drawable.ic_call_answer_video;
            int i5 = R.drawable.ic_call_answer;
            PendingIntent pendingIntent2 = this.f3403f;
            if (pendingIntent2 == null) {
                m698c2 = null;
            } else {
                boolean z = this.f3406i;
                if (z) {
                    i = i4;
                } else {
                    i = i5;
                }
                if (z) {
                    i2 = R.string.call_notification_answer_video_action;
                } else {
                    i2 = R.string.call_notification_answer_action;
                }
                m698c2 = m698c(i, i2, this.f3407j, R.color.call_notification_answer_color, pendingIntent2);
            }
            ArrayList<Action> arrayList = new ArrayList<>(3);
            arrayList.add(m698c);
            ArrayList<Action> arrayList2 = this.mBuilder.mActions;
            int i6 = 2;
            if (arrayList2 != null) {
                for (Action action : arrayList2) {
                    if (action.isContextual()) {
                        arrayList.add(action);
                    } else if (!action.getExtras().getBoolean("key_action_priority") && i6 > 1) {
                        arrayList.add(action);
                        i6--;
                    }
                    if (m698c2 != null && i6 == 1) {
                        arrayList.add(m698c2);
                        i6--;
                    }
                }
            }
            if (m698c2 != null && i6 >= 1) {
                arrayList.add(m698c2);
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            Integer num;
            super.restoreFromCompatExtras(bundle);
            this.f3401d = bundle.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.f3406i = bundle.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey(NotificationCompat.EXTRA_CALL_PERSON)) {
                this.f3402e = Person.fromAndroidPerson(hm1.m5098f(bundle.getParcelable(NotificationCompat.EXTRA_CALL_PERSON)));
            } else if (bundle.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT)) {
                this.f3402e = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON)) {
                this.f3409l = IconCompat.createFromIcon((Icon) bundle.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
            } else if (bundle.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT)) {
                this.f3409l = IconCompat.createFromBundle(bundle.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
            }
            this.f3410m = bundle.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.f3403f = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.f3404g = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.f3405h = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            Integer num2 = null;
            if (bundle.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR)) {
                num = Integer.valueOf(bundle.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
            } else {
                num = null;
            }
            this.f3407j = num;
            if (bundle.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR)) {
                num2 = Integer.valueOf(bundle.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
            }
            this.f3408k = num2;
        }

        @NonNull
        public CallStyle setAnswerButtonColorHint(@ColorInt int i) {
            this.f3407j = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public CallStyle setDeclineButtonColorHint(@ColorInt int i) {
            this.f3408k = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public CallStyle setIsVideo(boolean z) {
            this.f3406i = z;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public CallStyle setVerificationIcon(@Nullable Icon icon) {
            this.f3409l = icon == null ? null : IconCompat.createFromIcon(icon);
            return this;
        }

        @NonNull
        public CallStyle setVerificationText(@Nullable CharSequence charSequence) {
            this.f3410m = charSequence;
            return this;
        }

        public CallStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }

        @NonNull
        public CallStyle setVerificationIcon(@Nullable Bitmap bitmap) {
            this.f3409l = IconCompat.createWithBitmap(bitmap);
            return this;
        }

        public CallStyle(int i, Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
            if (person != null && !TextUtils.isEmpty(person.getName())) {
                this.f3401d = i;
                this.f3402e = person;
                this.f3403f = pendingIntent3;
                this.f3404g = pendingIntent2;
                this.f3405h = pendingIntent;
                return;
            }
            throw new IllegalArgumentException("person must have a non-empty a name");
        }
    }

    /* loaded from: classes.dex */
    public static class DecoratedCustomViewStyle extends Style {
        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(AbstractC0168u.m788a());
            }
        }

        /* renamed from: c */
        public final RemoteViews m699c(RemoteViews remoteViews, boolean z) {
            ArrayList arrayList;
            int min;
            boolean z2;
            int i;
            int i2 = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(R.id.actions);
            ArrayList<Action> arrayList2 = this.mBuilder.mActions;
            if (arrayList2 == null) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Action action : arrayList2) {
                    if (!action.isContextual()) {
                        arrayList3.add(action);
                    }
                }
                arrayList = arrayList3;
            }
            if (z && arrayList != null && (min = Math.min(arrayList.size(), 3)) > 0) {
                for (int i3 = 0; i3 < min; i3++) {
                    Action action2 = (Action) arrayList.get(i3);
                    if (action2.actionIntent == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String packageName = this.mBuilder.mContext.getPackageName();
                    if (z2) {
                        i = R.layout.notification_action_tombstone;
                    } else {
                        i = R.layout.notification_action;
                    }
                    RemoteViews remoteViews2 = new RemoteViews(packageName, i);
                    IconCompat iconCompat = action2.getIconCompat();
                    if (iconCompat != null) {
                        remoteViews2.setImageViewBitmap(R.id.action_image, m704a(iconCompat, R.color.notification_action_color_filter, 0));
                    }
                    remoteViews2.setTextViewText(R.id.action_text, action2.title);
                    if (!z2) {
                        remoteViews2.setOnClickPendingIntent(R.id.action_container, action2.actionIntent);
                    }
                    remoteViews2.setContentDescription(R.id.action_container, action2.title);
                    applyStandardTemplate.addView(R.id.actions, remoteViews2);
                }
            } else {
                i2 = 8;
            }
            applyStandardTemplate.setViewVisibility(R.id.actions, i2);
            applyStandardTemplate.setViewVisibility(R.id.action_divider, i2);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return m699c(bigContentView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24 || this.mBuilder.getContentView() == null) {
                return null;
            }
            return m699c(this.mBuilder.getContentView(), false);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            if (headsUpContentView != null) {
                contentView = headsUpContentView;
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (headsUpContentView == null) {
                return null;
            }
            return m699c(contentView, true);
        }
    }

    /* loaded from: classes.dex */
    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface StreamType {
    }

    /* loaded from: classes.dex */
    public static abstract class Style {

        /* renamed from: a */
        public CharSequence f3438a;

        /* renamed from: b */
        public CharSequence f3439b;

        /* renamed from: c */
        public boolean f3440c = false;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder mBuilder;

        /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Style extractStyleFromNotification(@NonNull Notification notification) {
            Style style;
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            String string = extras.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
            if (string != null) {
                char c = 65535;
                switch (string.hashCode()) {
                    case -716705180:
                        if (string.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -171946061:
                        if (string.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 714386739:
                        if (string.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 912942987:
                        if (string.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 919595044:
                        if (string.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 2090799565:
                        if (string.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        style = new DecoratedCustomViewStyle();
                        break;
                    case 1:
                        style = new BigPictureStyle();
                        break;
                    case 2:
                        style = new CallStyle();
                        break;
                    case 3:
                        style = new InboxStyle();
                        break;
                    case 4:
                        style = new BigTextStyle();
                        break;
                    case 5:
                        style = new MessagingStyle();
                        break;
                }
                if (style == null) {
                    if (!extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) && !extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                        if (!extras.containsKey(NotificationCompat.EXTRA_PICTURE) && !extras.containsKey(NotificationCompat.EXTRA_PICTURE_ICON)) {
                            if (extras.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
                                style = new BigTextStyle();
                            } else if (extras.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                                style = new InboxStyle();
                            } else if (extras.containsKey(NotificationCompat.EXTRA_CALL_TYPE)) {
                                style = new CallStyle();
                            } else {
                                String string2 = extras.getString(NotificationCompat.EXTRA_TEMPLATE);
                                if (string2 != null) {
                                    if (string2.equals(Notification.BigPictureStyle.class.getName())) {
                                        style = new BigPictureStyle();
                                    } else if (string2.equals(Notification.BigTextStyle.class.getName())) {
                                        style = new BigTextStyle();
                                    } else if (string2.equals(Notification.InboxStyle.class.getName())) {
                                        style = new InboxStyle();
                                    } else if (Build.VERSION.SDK_INT >= 24) {
                                        if (string2.equals(uk1.m7713c().getName())) {
                                            style = new MessagingStyle();
                                        } else if (string2.equals(uk1.m7709C().getName())) {
                                            style = new DecoratedCustomViewStyle();
                                        }
                                    }
                                }
                                style = null;
                            }
                        } else {
                            style = new BigPictureStyle();
                        }
                    } else {
                        style = new MessagingStyle();
                    }
                }
                if (style != null) {
                    try {
                        style.restoreFromCompatExtras(extras);
                    } catch (ClassCastException unused) {
                        return null;
                    }
                }
                return style;
            }
            style = null;
            if (style == null) {
            }
            if (style != null) {
            }
            return style;
        }

        /* renamed from: a */
        public final Bitmap m704a(IconCompat iconCompat, int i, int i2) {
            int i3;
            Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
            if (i2 == 0) {
                i3 = loadDrawable.getIntrinsicWidth();
            } else {
                i3 = i2;
            }
            if (i2 == 0) {
                i2 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, i3, i2);
            if (i != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            if (this.f3440c) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.f3439b);
            }
            CharSequence charSequence = this.f3438a;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            String className = getClassName();
            if (className != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, className);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x013d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0181  */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RemoteViews applyStandardTemplate(boolean z, int i, boolean z2) {
            boolean z3;
            boolean z4;
            CharSequence charSequence;
            int i2;
            Resources resources = this.mBuilder.mContext.getResources();
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), i);
            this.mBuilder.getPriority();
            int i3 = Build.VERSION.SDK_INT;
            Builder builder = this.mBuilder;
            int i4 = 0;
            if (builder.f3381g != null) {
                int i5 = R.id.icon;
                remoteViews.setViewVisibility(i5, 0);
                remoteViews.setImageViewBitmap(i5, m704a(this.mBuilder.f3381g, 0, 0));
                if (z && this.mBuilder.f3372R.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                    Builder builder2 = this.mBuilder;
                    Bitmap m705b = m705b(builder2.f3372R.icon, dimensionPixelSize, dimensionPixelSize2, builder2.getColor());
                    int i6 = R.id.right_icon;
                    remoteViews.setImageViewBitmap(i6, m705b);
                    remoteViews.setViewVisibility(i6, 0);
                }
            } else if (z && builder.f3372R.icon != 0) {
                int i7 = R.id.icon;
                remoteViews.setViewVisibility(i7, 0);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                Builder builder3 = this.mBuilder;
                remoteViews.setImageViewBitmap(i7, m705b(builder3.f3372R.icon, dimensionPixelSize3, dimensionPixelSize4, builder3.getColor()));
            }
            CharSequence charSequence2 = this.mBuilder.f3376b;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(R.id.title, charSequence2);
            }
            CharSequence charSequence3 = this.mBuilder.f3377c;
            boolean z5 = true;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(R.id.text, charSequence3);
                z3 = true;
            } else {
                z3 = false;
            }
            Builder builder4 = this.mBuilder;
            CharSequence charSequence4 = builder4.f3382h;
            if (charSequence4 != null) {
                int i8 = R.id.info;
                remoteViews.setTextViewText(i8, charSequence4);
                remoteViews.setViewVisibility(i8, 0);
            } else if (builder4.f3383i > 0) {
                if (this.mBuilder.f3383i > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.f3383i));
                }
                remoteViews.setViewVisibility(R.id.info, 0);
            } else {
                remoteViews.setViewVisibility(R.id.info, 8);
                z4 = false;
                charSequence = this.mBuilder.f3389o;
                if (charSequence != null) {
                    int i9 = R.id.text;
                    remoteViews.setTextViewText(i9, charSequence);
                    CharSequence charSequence5 = this.mBuilder.f3377c;
                    if (charSequence5 != null) {
                        int i10 = R.id.text2;
                        remoteViews.setTextViewText(i10, charSequence5);
                        remoteViews.setViewVisibility(i10, 0);
                        if (z2) {
                            remoteViews.setTextViewTextSize(i9, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                        }
                        remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                    } else {
                        remoteViews.setViewVisibility(R.id.text2, 8);
                    }
                }
                if (this.mBuilder.getWhenIfShowing() == 0) {
                    if (this.mBuilder.f3386l) {
                        int i11 = R.id.chronometer;
                        remoteViews.setViewVisibility(i11, 0);
                        remoteViews.setLong(i11, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + this.mBuilder.getWhenIfShowing());
                        remoteViews.setBoolean(i11, "setStarted", true);
                        boolean z6 = this.mBuilder.f3387m;
                        if (z6 && i3 >= 24) {
                            AbstractC0139a0.m714a(remoteViews, i11, z6);
                        }
                    } else {
                        int i12 = R.id.time;
                        remoteViews.setViewVisibility(i12, 0);
                        remoteViews.setLong(i12, "setTime", this.mBuilder.getWhenIfShowing());
                    }
                } else {
                    z5 = z4;
                }
                int i13 = R.id.right_side;
                if (!z5) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                remoteViews.setViewVisibility(i13, i2);
                int i14 = R.id.line3;
                if (!z3) {
                    i4 = 8;
                }
                remoteViews.setViewVisibility(i14, i4);
                return remoteViews;
            }
            z3 = true;
            z4 = true;
            charSequence = this.mBuilder.f3389o;
            if (charSequence != null) {
            }
            if (this.mBuilder.getWhenIfShowing() == 0) {
            }
            int i132 = R.id.right_side;
            if (!z5) {
            }
            remoteViews.setViewVisibility(i132, i2);
            int i142 = R.id.line3;
            if (!z3) {
            }
            remoteViews.setViewVisibility(i142, i4);
            return remoteViews;
        }

        /* renamed from: b */
        public final Bitmap m705b(int i, int i2, int i3, int i4) {
            int i5 = R.drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap m704a = m704a(IconCompat.createWithResource(this.mBuilder.mContext, i5), i4, i2);
            Canvas canvas = new Canvas(m704a);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return m704a;
        }

        @Nullable
        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
            int i = R.id.notification_main_column;
            remoteViews.removeAllViews(i);
            remoteViews.addView(i, remoteViews2.clone());
            remoteViews.setViewVisibility(i, 0);
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float f = resources.getConfiguration().fontScale;
            if (f < 1.0f) {
                f = 1.0f;
            } else if (f > 1.3f) {
                f = 1.3f;
            }
            float f2 = (f - 1.0f) / 0.29999995f;
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, Math.round((f2 * dimensionPixelSize2) + ((1.0f - f2) * dimensionPixelSize)), 0, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            bundle.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            bundle.remove(NotificationCompat.EXTRA_TITLE_BIG);
            bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i, int i2) {
            return m704a(IconCompat.createWithResource(this.mBuilder.mContext, i), i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            if (bundle.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.f3439b = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.f3440c = true;
            }
            this.f3438a = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class WearableExtender implements Extender {

        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;

        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;

        @Deprecated
        public static final int SIZE_DEFAULT = 0;

        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;

        @Deprecated
        public static final int SIZE_LARGE = 4;

        @Deprecated
        public static final int SIZE_MEDIUM = 3;

        @Deprecated
        public static final int SIZE_SMALL = 2;

        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a */
        public ArrayList f3446a;

        /* renamed from: b */
        public int f3447b;

        /* renamed from: c */
        public PendingIntent f3448c;

        /* renamed from: d */
        public ArrayList f3449d;

        /* renamed from: e */
        public Bitmap f3450e;

        /* renamed from: f */
        public int f3451f;

        /* renamed from: g */
        public int f3452g;

        /* renamed from: h */
        public int f3453h;

        /* renamed from: i */
        public int f3454i;

        /* renamed from: j */
        public int f3455j;

        /* renamed from: k */
        public int f3456k;

        /* renamed from: l */
        public int f3457l;

        /* renamed from: m */
        public String f3458m;

        /* renamed from: n */
        public String f3459n;

        public WearableExtender() {
            this.f3446a = new ArrayList();
            this.f3447b = 1;
            this.f3449d = new ArrayList();
            this.f3452g = GravityCompat.END;
            this.f3453h = -1;
            this.f3454i = 0;
            this.f3456k = 80;
        }

        /* renamed from: a */
        public final void m706a(int i, boolean z) {
            if (z) {
                this.f3447b = i | this.f3447b;
            } else {
                this.f3447b = (~i) & this.f3447b;
            }
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action action) {
            this.f3446a.add(action);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> list) {
            this.f3446a.addAll(list);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification notification) {
            this.f3449d.add(notification);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> list) {
            this.f3449d.addAll(list);
            return this;
        }

        @NonNull
        public WearableExtender clearActions() {
            this.f3446a.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender clearPages() {
            this.f3449d.clear();
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder builder) {
            Icon icon;
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            if (!this.f3446a.isEmpty()) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f3446a.size());
                Iterator it = this.f3446a.iterator();
                while (it.hasNext()) {
                    Action action = (Action) it.next();
                    int i = Build.VERSION.SDK_INT;
                    IconCompat iconCompat = action.getIconCompat();
                    if (iconCompat == null) {
                        icon = null;
                    } else {
                        icon = iconCompat.toIcon();
                    }
                    Notification.Action.Builder m723a = AbstractC0143c0.m723a(icon, action.getTitle(), action.getActionIntent());
                    if (action.getExtras() != null) {
                        bundle = new Bundle(action.getExtras());
                    } else {
                        bundle = new Bundle();
                    }
                    bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
                    if (i >= 24) {
                        AbstractC0145d0.m725a(m723a, action.getAllowGeneratedReplies());
                    }
                    if (i >= 31) {
                        AbstractC0147e0.m727a(m723a, action.isAuthenticationRequired());
                    }
                    AbstractC0141b0.m717a(m723a, bundle);
                    RemoteInput[] remoteInputs = action.getRemoteInputs();
                    if (remoteInputs != null) {
                        for (android.app.RemoteInput remoteInput : RemoteInput.m709b(remoteInputs)) {
                            AbstractC0141b0.m718b(m723a, remoteInput);
                        }
                    }
                    arrayList.add(AbstractC0141b0.m719c(m723a));
                }
                bundle2.putParcelableArrayList("actions", arrayList);
            }
            int i2 = this.f3447b;
            if (i2 != 1) {
                bundle2.putInt("flags", i2);
            }
            PendingIntent pendingIntent = this.f3448c;
            if (pendingIntent != null) {
                bundle2.putParcelable("displayIntent", pendingIntent);
            }
            if (!this.f3449d.isEmpty()) {
                ArrayList arrayList2 = this.f3449d;
                bundle2.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f3450e;
            if (bitmap != null) {
                bundle2.putParcelable("background", bitmap);
            }
            int i3 = this.f3451f;
            if (i3 != 0) {
                bundle2.putInt("contentIcon", i3);
            }
            int i4 = this.f3452g;
            if (i4 != 8388613) {
                bundle2.putInt("contentIconGravity", i4);
            }
            int i5 = this.f3453h;
            if (i5 != -1) {
                bundle2.putInt("contentActionIndex", i5);
            }
            int i6 = this.f3454i;
            if (i6 != 0) {
                bundle2.putInt("customSizePreset", i6);
            }
            int i7 = this.f3455j;
            if (i7 != 0) {
                bundle2.putInt("customContentHeight", i7);
            }
            int i8 = this.f3456k;
            if (i8 != 80) {
                bundle2.putInt("gravity", i8);
            }
            int i9 = this.f3457l;
            if (i9 != 0) {
                bundle2.putInt("hintScreenTimeout", i9);
            }
            String str = this.f3458m;
            if (str != null) {
                bundle2.putString("dismissalId", str);
            }
            String str2 = this.f3459n;
            if (str2 != null) {
                bundle2.putString("bridgeTag", str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle2);
            return builder;
        }

        @NonNull
        public List<Action> getActions() {
            return this.f3446a;
        }

        @Nullable
        @Deprecated
        public Bitmap getBackground() {
            return this.f3450e;
        }

        @Nullable
        public String getBridgeTag() {
            return this.f3459n;
        }

        public int getContentAction() {
            return this.f3453h;
        }

        @Deprecated
        public int getContentIcon() {
            return this.f3451f;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.f3452g;
        }

        public boolean getContentIntentAvailableOffline() {
            if ((this.f3447b & 1) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.f3455j;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.f3454i;
        }

        @Nullable
        public String getDismissalId() {
            return this.f3458m;
        }

        @Nullable
        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.f3448c;
        }

        @Deprecated
        public int getGravity() {
            return this.f3456k;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            if ((this.f3447b & 32) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            if ((this.f3447b & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if ((this.f3447b & 64) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            if ((this.f3447b & 2) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.f3457l;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            if ((this.f3447b & 4) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @Deprecated
        public List<Notification> getPages() {
            return this.f3449d;
        }

        public boolean getStartScrollBottom() {
            if ((this.f3447b & 8) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @Deprecated
        public WearableExtender setBackground(@Nullable Bitmap bitmap) {
            this.f3450e = bitmap;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String str) {
            this.f3459n = str;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int i) {
            this.f3453h = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int i) {
            this.f3451f = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int i) {
            this.f3452g = i;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            m706a(1, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int i) {
            this.f3455j = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int i) {
            this.f3454i = i;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String str) {
            this.f3458m = str;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent pendingIntent) {
            this.f3448c = pendingIntent;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int i) {
            this.f3456k = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            m706a(32, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            m706a(16, z);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            m706a(64, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            m706a(2, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int i) {
            this.f3457l = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            m706a(4, z);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean z) {
            m706a(8, z);
            return this;
        }

        @NonNull
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WearableExtender m8480clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f3446a = new ArrayList(this.f3446a);
            wearableExtender.f3447b = this.f3447b;
            wearableExtender.f3448c = this.f3448c;
            wearableExtender.f3449d = new ArrayList(this.f3449d);
            wearableExtender.f3450e = this.f3450e;
            wearableExtender.f3451f = this.f3451f;
            wearableExtender.f3452g = this.f3452g;
            wearableExtender.f3453h = this.f3453h;
            wearableExtender.f3454i = this.f3454i;
            wearableExtender.f3455j = this.f3455j;
            wearableExtender.f3456k = this.f3456k;
            wearableExtender.f3457l = this.f3457l;
            wearableExtender.f3458m = this.f3458m;
            wearableExtender.f3459n = this.f3459n;
            return wearableExtender;
        }

        public WearableExtender(@NonNull Notification notification) {
            Notification[] notificationArr;
            this.f3446a = new ArrayList();
            this.f3447b = 1;
            this.f3449d = new ArrayList();
            this.f3452g = GravityCompat.END;
            this.f3453h = -1;
            this.f3454i = 0;
            this.f3456k = 80;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i = 0; i < size; i++) {
                        actionArr[i] = AbstractC0141b0.m721e(parcelableArrayList, i);
                    }
                    Collections.addAll(this.f3446a, actionArr);
                }
                this.f3447b = bundle.getInt("flags", 1);
                this.f3448c = (PendingIntent) bundle.getParcelable("displayIntent");
                Parcelable[] parcelableArray = bundle.getParcelableArray("pages");
                if (!(parcelableArray instanceof Notification[]) && parcelableArray != null) {
                    notificationArr = new Notification[parcelableArray.length];
                    for (int i2 = 0; i2 < parcelableArray.length; i2++) {
                        notificationArr[i2] = (Notification) parcelableArray[i2];
                    }
                    bundle.putParcelableArray("pages", notificationArr);
                } else {
                    notificationArr = (Notification[]) parcelableArray;
                }
                if (notificationArr != null) {
                    Collections.addAll(this.f3449d, notificationArr);
                }
                this.f3450e = (Bitmap) bundle.getParcelable("background");
                this.f3451f = bundle.getInt("contentIcon");
                this.f3452g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.f3453h = bundle.getInt("contentActionIndex", -1);
                this.f3454i = bundle.getInt("customSizePreset", 0);
                this.f3455j = bundle.getInt("customContentHeight");
                this.f3456k = bundle.getInt("gravity", 80);
                this.f3457l = bundle.getInt("hintScreenTimeout");
                this.f3458m = bundle.getString("dismissalId");
                this.f3459n = bundle.getString("bridgeTag");
            }
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    /* renamed from: a */
    public static Action m694a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        android.app.RemoteInput[] m8078g = wr1.m8078g(action);
        IconCompat iconCompat = null;
        boolean z3 = false;
        if (m8078g == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[m8078g.length];
            for (int i4 = 0; i4 < m8078g.length; i4++) {
                android.app.RemoteInput remoteInput = m8078g[i4];
                String m8079h = wr1.m8079h(remoteInput);
                CharSequence m8077f = wr1.m8077f(remoteInput);
                CharSequence[] m8073b = wr1.m8073b(remoteInput);
                boolean m8072a = wr1.m8072a(remoteInput);
                if (Build.VERSION.SDK_INT >= 29) {
                    i = ds1.m4610c(remoteInput);
                } else {
                    i = 0;
                }
                remoteInputArr2[i4] = new RemoteInput(m8079h, m8077f, m8073b, m8072a, i, wr1.m8075d(remoteInput), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 24) {
            if (!wr1.m8074c(action).getBoolean("android.support.allowGeneratedReplies") && !as1.m1961a(action)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = wr1.m8074c(action).getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z4 = z;
        boolean z5 = wr1.m8074c(action).getBoolean("android.support.action.showsUserInterface", true);
        if (i5 >= 28) {
            i2 = cs1.m4487a(action);
        } else {
            i2 = wr1.m8074c(action).getInt("android.support.action.semanticAction", 0);
        }
        int i6 = i2;
        if (i5 >= 29) {
            z2 = ds1.m4612e(action);
        } else {
            z2 = false;
        }
        if (i5 >= 31) {
            z3 = es1.m4754a(action);
        }
        boolean z6 = z3;
        if (yr1.m8317a(action) == null && (i3 = action.icon) != 0) {
            return new Action(i3, action.title, action.actionIntent, wr1.m8074c(action), remoteInputArr, (RemoteInput[]) null, z4, i6, z5, z2, z6);
        }
        if (yr1.m8317a(action) != null) {
            iconCompat = IconCompat.createFromIconOrNullIfZeroResId(yr1.m8317a(action));
        }
        return new Action(iconCompat, action.title, action.actionIntent, wr1.m8074c(action), remoteInputArr, (RemoteInput[]) null, z4, i6, z5, z2, z6);
    }

    @Nullable
    public static Action getAction(@NonNull Notification notification, int i) {
        return m694a(notification.actions[i]);
    }

    public static int getActionCount(@NonNull Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ds1.m4608a(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(@NonNull Notification notification) {
        if ((notification.flags & 16) != 0) {
            return true;
        }
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2158a(notification);
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(ds1.m4609b(notification));
        }
        return null;
    }

    @Nullable
    public static String getCategory(@NonNull Notification notification) {
        return notification.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2159b(notification);
        }
        return null;
    }

    public static int getColor(@NonNull Notification notification) {
        return notification.color;
    }

    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    public static CharSequence getContentText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification notification) {
        return notification.extras;
    }

    @Nullable
    public static String getGroup(@NonNull Notification notification) {
        return wr1.m8076e(notification);
    }

    public static int getGroupAlertBehavior(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2160c(notification);
        }
        return 0;
    }

    @NonNull
    @RequiresApi(21)
    public static List<Action> getInvisibleActions(@NonNull Notification notification) {
        boolean z;
        Bundle[] bundleArr;
        Bundle[] bundleArr2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle == null) {
            return arrayList;
        }
        Bundle bundle2 = bundle.getBundle("invisible_actions");
        if (bundle2 != null) {
            for (int i = 0; i < bundle2.size(); i++) {
                Bundle bundle3 = bundle2.getBundle(Integer.toString(i));
                Bundle bundle4 = bundle3.getBundle("extras");
                if (bundle4 != null) {
                    z = bundle4.getBoolean("android.support.allowGeneratedReplies", false);
                } else {
                    z = false;
                }
                int i2 = bundle3.getInt("icon");
                CharSequence charSequence = bundle3.getCharSequence("title");
                PendingIntent pendingIntent = (PendingIntent) bundle3.getParcelable("actionIntent");
                Bundle bundle5 = bundle3.getBundle("extras");
                Parcelable[] parcelableArray = bundle3.getParcelableArray("remoteInputs");
                if (!(parcelableArray instanceof Bundle[]) && parcelableArray != null) {
                    bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
                    bundle3.putParcelableArray("remoteInputs", bundleArr);
                } else {
                    bundleArr = (Bundle[]) parcelableArray;
                }
                RemoteInput[] m733a = AbstractC0151g0.m733a(bundleArr);
                Parcelable[] parcelableArray2 = bundle3.getParcelableArray("dataOnlyRemoteInputs");
                if (!(parcelableArray2 instanceof Bundle[]) && parcelableArray2 != null) {
                    bundleArr2 = (Bundle[]) Arrays.copyOf(parcelableArray2, parcelableArray2.length, Bundle[].class);
                    bundle3.putParcelableArray("dataOnlyRemoteInputs", bundleArr2);
                } else {
                    bundleArr2 = (Bundle[]) parcelableArray2;
                }
                arrayList.add(new Action(i2, charSequence, pendingIntent, bundle5, m733a, AbstractC0151g0.m733a(bundleArr2), z, bundle3.getInt("semanticAction"), bundle3.getBoolean("showsUserInterface"), false, false));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@NonNull Notification notification) {
        if ((notification.flags & 256) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification notification) {
        LocusId m4611d;
        if (Build.VERSION.SDK_INT < 29 || (m4611d = ds1.m4611d(notification)) == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(m4611d);
    }

    public static boolean getOngoing(@NonNull Notification notification) {
        if ((notification.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification notification) {
        if ((notification.flags & 8) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Person.fromAndroidPerson(hm1.m5099g(it.next())));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new Person.Builder().setUri(str).build());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification notification) {
        return notification.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2161d(notification);
        }
        return null;
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2162e(notification);
        }
        return null;
    }

    public static boolean getShowWhen(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification notification) {
        return wr1.m8080i(notification);
    }

    @Nullable
    public static CharSequence getSubText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return bs1.m2163f(notification);
        }
        return 0L;
    }

    public static boolean getUsesChronometer(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification notification) {
        if ((notification.flags & 512) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Bitmap reduceLargeIconSize(@NonNull Context context, @Nullable Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
        }
        return bitmap;
    }

    /* loaded from: classes.dex */
    public static final class CarExtender implements Extender {

        /* renamed from: a */
        public Bitmap f3411a;

        /* renamed from: b */
        public UnreadConversation f3412b;

        /* renamed from: c */
        public int f3413c;

        @Deprecated
        /* loaded from: classes.dex */
        public static class UnreadConversation {

            /* renamed from: a */
            public final String[] f3414a;

            /* renamed from: b */
            public final RemoteInput f3415b;

            /* renamed from: c */
            public final PendingIntent f3416c;

            /* renamed from: d */
            public final PendingIntent f3417d;

            /* renamed from: e */
            public final String[] f3418e;

            /* renamed from: f */
            public final long f3419f;

            /* loaded from: classes.dex */
            public static class Builder {

                /* renamed from: a */
                public final ArrayList f3420a = new ArrayList();

                /* renamed from: b */
                public final String f3421b;

                /* renamed from: c */
                public RemoteInput f3422c;

                /* renamed from: d */
                public PendingIntent f3423d;

                /* renamed from: e */
                public PendingIntent f3424e;

                /* renamed from: f */
                public long f3425f;

                public Builder(@NonNull String str) {
                    this.f3421b = str;
                }

                @NonNull
                public Builder addMessage(@Nullable String str) {
                    if (str != null) {
                        this.f3420a.add(str);
                    }
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    ArrayList arrayList = this.f3420a;
                    return new UnreadConversation((String[]) arrayList.toArray(new String[arrayList.size()]), this.f3422c, this.f3424e, this.f3423d, new String[]{this.f3421b}, this.f3425f);
                }

                @NonNull
                public Builder setLatestTimestamp(long j) {
                    this.f3425f = j;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent pendingIntent) {
                    this.f3423d = pendingIntent;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent pendingIntent, @Nullable RemoteInput remoteInput) {
                    this.f3422c = remoteInput;
                    this.f3424e = pendingIntent;
                    return this;
                }
            }

            public UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f3414a = strArr;
                this.f3415b = remoteInput;
                this.f3417d = pendingIntent2;
                this.f3416c = pendingIntent;
                this.f3418e = strArr2;
                this.f3419f = j;
            }

            public long getLatestTimestamp() {
                return this.f3419f;
            }

            @Nullable
            public String[] getMessages() {
                return this.f3414a;
            }

            @Nullable
            public String getParticipant() {
                String[] strArr = this.f3418e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @Nullable
            public String[] getParticipants() {
                return this.f3418e;
            }

            @Nullable
            public PendingIntent getReadPendingIntent() {
                return this.f3417d;
            }

            @Nullable
            public RemoteInput getRemoteInput() {
                return this.f3415b;
            }

            @Nullable
            public PendingIntent getReplyPendingIntent() {
                return this.f3416c;
            }
        }

        public CarExtender() {
            this.f3413c = 0;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder builder) {
            String str;
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f3411a;
            if (bitmap != null) {
                bundle.putParcelable("large_icon", bitmap);
            }
            int i = this.f3413c;
            if (i != 0) {
                bundle.putInt("app_color", i);
            }
            UnreadConversation unreadConversation = this.f3412b;
            if (unreadConversation != null) {
                Bundle bundle2 = new Bundle();
                if (unreadConversation.getParticipants() != null && unreadConversation.getParticipants().length > 1) {
                    str = unreadConversation.getParticipants()[0];
                } else {
                    str = null;
                }
                int length = unreadConversation.getMessages().length;
                Parcelable[] parcelableArr = new Parcelable[length];
                for (int i2 = 0; i2 < length; i2++) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(MimeTypes.BASE_TYPE_TEXT, unreadConversation.getMessages()[i2]);
                    bundle3.putString("author", str);
                    parcelableArr[i2] = bundle3;
                }
                bundle2.putParcelableArray("messages", parcelableArr);
                RemoteInput remoteInput = unreadConversation.getRemoteInput();
                if (remoteInput != null) {
                    RemoteInput.Builder m778d = AbstractC0166s.m778d(remoteInput.getResultKey());
                    AbstractC0166s.m786l(m778d, remoteInput.getLabel());
                    AbstractC0166s.m785k(m778d, remoteInput.getChoices());
                    AbstractC0166s.m784j(m778d, remoteInput.getAllowFreeFormInput());
                    AbstractC0166s.m775a(m778d, remoteInput.getExtras());
                    bundle2.putParcelable("remote_input", AbstractC0166s.m777c(AbstractC0166s.m776b(m778d)));
                }
                bundle2.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
                bundle2.putParcelable("on_read", unreadConversation.getReadPendingIntent());
                bundle2.putStringArray("participants", unreadConversation.getParticipants());
                bundle2.putLong("timestamp", unreadConversation.getLatestTimestamp());
                bundle.putBundle("car_conversation", bundle2);
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.f3413c;
        }

        @Nullable
        public Bitmap getLargeIcon() {
            return this.f3411a;
        }

        @Nullable
        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.f3412b;
        }

        @NonNull
        public CarExtender setColor(@ColorInt int i) {
            this.f3413c = i;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap bitmap) {
            this.f3411a = bitmap;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation unreadConversation) {
            this.f3412b = unreadConversation;
            return this;
        }

        public CarExtender(@NonNull Notification notification) {
            String[] strArr;
            this.f3413c = 0;
            UnreadConversation unreadConversation = null;
            unreadConversation = null;
            unreadConversation = null;
            unreadConversation = null;
            unreadConversation = null;
            Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                this.f3411a = (Bitmap) bundle.getParcelable("large_icon");
                this.f3413c = bundle.getInt("app_color", 0);
                Bundle bundle2 = bundle.getBundle("car_conversation");
                if (bundle2 != null) {
                    Parcelable[] parcelableArray = bundle2.getParcelableArray("messages");
                    if (parcelableArray != null) {
                        int length = parcelableArray.length;
                        String[] strArr2 = new String[length];
                        for (int i = 0; i < length; i++) {
                            Parcelable parcelable = parcelableArray[i];
                            if (!(parcelable instanceof Bundle)) {
                                break;
                            }
                            String string = ((Bundle) parcelable).getString(MimeTypes.BASE_TYPE_TEXT);
                            strArr2[i] = string;
                            if (string == null) {
                                break;
                            }
                        }
                        strArr = strArr2;
                    } else {
                        strArr = null;
                    }
                    PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable("on_read");
                    PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable("on_reply");
                    android.app.RemoteInput remoteInput = (android.app.RemoteInput) bundle2.getParcelable("remote_input");
                    String[] stringArray = bundle2.getStringArray("participants");
                    if (stringArray != null && stringArray.length == 1) {
                        unreadConversation = new UnreadConversation(strArr, remoteInput != null ? new RemoteInput(AbstractC0166s.m783i(remoteInput), AbstractC0166s.m782h(remoteInput), AbstractC0166s.m780f(remoteInput), AbstractC0166s.m779e(remoteInput), Build.VERSION.SDK_INT >= 29 ? AbstractC0167t.m787a(remoteInput) : 0, AbstractC0166s.m781g(remoteInput), null) : null, pendingIntent2, pendingIntent, stringArray, bundle2.getLong("timestamp"));
                    }
                }
                this.f3412b = unreadConversation;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class InboxStyle extends Style {

        /* renamed from: d */
        public final ArrayList f3426d = new ArrayList();

        public InboxStyle() {
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence charSequence) {
            if (charSequence != null) {
                this.f3426d.add(Builder.limitCharSequenceLength(charSequence));
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f3438a);
            if (this.f3440c) {
                bigContentTitle.setSummaryText(this.f3439b);
            }
            Iterator it = this.f3426d.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            ArrayList arrayList = this.f3426d;
            arrayList.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                Collections.addAll(arrayList, bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f3438a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f3439b = Builder.limitCharSequenceLength(charSequence);
            this.f3440c = true;
            return this;
        }

        public InboxStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static final class TvExtender implements Extender {

        /* renamed from: a */
        public final int f3441a;

        /* renamed from: b */
        public String f3442b;

        /* renamed from: c */
        public PendingIntent f3443c;

        /* renamed from: d */
        public PendingIntent f3444d;

        /* renamed from: e */
        public boolean f3445e;

        public TvExtender() {
            this.f3441a = 1;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder builder) {
            if (Build.VERSION.SDK_INT < 26) {
                return builder;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("flags", this.f3441a);
            bundle.putString("channel_id", this.f3442b);
            bundle.putBoolean("suppressShowOverApps", this.f3445e);
            PendingIntent pendingIntent = this.f3443c;
            if (pendingIntent != null) {
                bundle.putParcelable("content_intent", pendingIntent);
            }
            PendingIntent pendingIntent2 = this.f3444d;
            if (pendingIntent2 != null) {
                bundle.putParcelable("delete_intent", pendingIntent2);
            }
            builder.getExtras().putBundle("android.tv.EXTENSIONS", bundle);
            return builder;
        }

        @Nullable
        public String getChannelId() {
            return this.f3442b;
        }

        @Nullable
        public PendingIntent getContentIntent() {
            return this.f3443c;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.f3444d;
        }

        public boolean isAvailableOnTv() {
            if ((this.f3441a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isSuppressShowOverApps() {
            return this.f3445e;
        }

        @NonNull
        public TvExtender setChannelId(@Nullable String str) {
            this.f3442b = str;
            return this;
        }

        @NonNull
        public TvExtender setContentIntent(@Nullable PendingIntent pendingIntent) {
            this.f3443c = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender setDeleteIntent(@Nullable PendingIntent pendingIntent) {
            this.f3444d = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender setSuppressShowOverApps(boolean z) {
            this.f3445e = z;
            return this;
        }

        public TvExtender(@NonNull Notification notification) {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            Bundle bundle = notification.extras;
            Bundle bundle2 = bundle == null ? null : bundle.getBundle("android.tv.EXTENSIONS");
            if (bundle2 != null) {
                this.f3441a = bundle2.getInt("flags");
                this.f3442b = bundle2.getString("channel_id");
                this.f3445e = bundle2.getBoolean("suppressShowOverApps");
                this.f3443c = (PendingIntent) bundle2.getParcelable("content_intent");
                this.f3444d = (PendingIntent) bundle2.getParcelable("delete_intent");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;

        /* renamed from: d */
        public final ArrayList f3427d = new ArrayList();

        /* renamed from: e */
        public final ArrayList f3428e = new ArrayList();

        /* renamed from: f */
        public Person f3429f;

        /* renamed from: g */
        public CharSequence f3430g;

        /* renamed from: h */
        public Boolean f3431h;

        public MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification notification) {
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            if (extractStyleFromNotification instanceof MessagingStyle) {
                return (MessagingStyle) extractStyleFromNotification;
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.f3429f.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.f3429f.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.f3430g);
            if (this.f3430g != null && this.f3431h.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.f3430g);
            }
            ArrayList arrayList = this.f3427d;
            if (!arrayList.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.m701a(arrayList));
            }
            ArrayList arrayList2 = this.f3428e;
            if (!arrayList2.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.m701a(arrayList2));
            }
            Boolean bool = this.f3431h;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message message) {
            if (message != null) {
                ArrayList arrayList = this.f3428e;
                arrayList.add(message);
                if (arrayList.size() > 25) {
                    arrayList.remove(0);
                }
            }
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j, @Nullable CharSequence charSequence2) {
            Message message = new Message(charSequence, j, new Person.Builder().setName(charSequence2).build());
            ArrayList arrayList = this.f3427d;
            arrayList.add(message);
            if (arrayList.size() > 25) {
                arrayList.remove(0);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Message message;
            boolean z;
            int size;
            CharSequence text;
            CharSequence text2;
            Notification.MessagingStyle m790b;
            setGroupConversation(isGroupConversation());
            int i = Build.VERSION.SDK_INT;
            ArrayList arrayList = this.f3427d;
            if (i >= 24) {
                if (i >= 28) {
                    m790b = AbstractC0173x.m793a(this.f3429f.toAndroidPerson());
                } else {
                    m790b = AbstractC0171v.m790b(this.f3429f.getName());
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AbstractC0171v.m789a(uk1.m7711a(m790b), ((Message) it.next()).m703c());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator it2 = this.f3428e.iterator();
                    while (it2.hasNext()) {
                        AbstractC0172w.m792a(uk1.m7711a(m790b), ((Message) it2.next()).m703c());
                    }
                }
                if (this.f3431h.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    AbstractC0171v.m791c(uk1.m7711a(m790b), this.f3430g);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    AbstractC0173x.m794b(uk1.m7711a(m790b), this.f3431h.booleanValue());
                }
                m790b.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            int size2 = arrayList.size() - 1;
            while (true) {
                if (size2 >= 0) {
                    message = (Message) arrayList.get(size2);
                    if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                        break;
                    } else {
                        size2--;
                    }
                } else if (!arrayList.isEmpty()) {
                    message = (Message) AbstractC1726qj.m7053i(arrayList, 1);
                } else {
                    message = null;
                }
            }
            if (this.f3430g != null && this.f3431h.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.f3430g);
            } else if (message != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (message.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(message.getPerson().getName());
                }
            }
            if (message != null) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                if (this.f3430g != null) {
                    text2 = m700c(message);
                } else {
                    text2 = message.getText();
                }
                builder.setContentText(text2);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f3430g == null) {
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    Message message2 = (Message) arrayList.get(size3);
                    if (message2.getPerson() == null || message2.getPerson().getName() != null) {
                    }
                }
                z = false;
                for (size = arrayList.size() - 1; size >= 0; size--) {
                    Message message3 = (Message) arrayList.get(size);
                    if (z) {
                        text = m700c(message3);
                    } else {
                        text = message3.getText();
                    }
                    if (size != arrayList.size() - 1) {
                        spannableStringBuilder.insert(0, (CharSequence) "\n");
                    }
                    spannableStringBuilder.insert(0, text);
                }
                new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
            z = true;
            while (size >= 0) {
            }
            new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
        }

        /* renamed from: c */
        public final SpannableStringBuilder m700c(Message message) {
            CharSequence name;
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            CharSequence charSequence = "";
            if (message.getPerson() == null) {
                name = "";
            } else {
                name = message.getPerson().getName();
            }
            boolean isEmpty = TextUtils.isEmpty(name);
            int i = ViewCompat.MEASURED_STATE_MASK;
            if (isEmpty) {
                name = this.f3429f.getName();
                if (this.mBuilder.getColor() != 0) {
                    i = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = bidiFormatter.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence = message.getText();
            }
            spannableStringBuilder.append((CharSequence) "  ").append(bidiFormatter.unicodeWrap(charSequence));
            return spannableStringBuilder;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.f3430g;
        }

        @NonNull
        public List<Message> getHistoricMessages() {
            return this.f3428e;
        }

        @NonNull
        public List<Message> getMessages() {
            return this.f3427d;
        }

        @NonNull
        public Person getUser() {
            return this.f3429f;
        }

        @Nullable
        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.f3429f.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            if (builder != null && builder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.f3431h == null) {
                if (this.f3430g == null) {
                    return false;
                }
                return true;
            }
            Boolean bool = this.f3431h;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            ArrayList arrayList = this.f3427d;
            arrayList.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.f3429f = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.f3429f = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.f3430g = charSequence;
            if (charSequence == null) {
                this.f3430g = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                arrayList.addAll(Message.m702b(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (parcelableArray2 != null) {
                this.f3428e.addAll(Message.m702b(parcelableArray2));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.f3431h = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            this.f3430g = charSequence;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean z) {
            this.f3431h = Boolean.valueOf(z);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.f3429f = new Person.Builder().setName(charSequence).build();
        }

        /* loaded from: classes.dex */
        public static final class Message {

            /* renamed from: a */
            public final CharSequence f3432a;

            /* renamed from: b */
            public final long f3433b;

            /* renamed from: c */
            public final Person f3434c;

            /* renamed from: d */
            public final Bundle f3435d;

            /* renamed from: e */
            public String f3436e;

            /* renamed from: f */
            public Uri f3437f;

            public Message(@Nullable CharSequence charSequence, long j, @Nullable Person person) {
                this.f3435d = new Bundle();
                this.f3432a = charSequence;
                this.f3433b = j;
                this.f3434c = person;
            }

            /* renamed from: a */
            public static Bundle[] m701a(ArrayList arrayList) {
                Bundle[] bundleArr = new Bundle[arrayList.size()];
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Message message = (Message) arrayList.get(i);
                    message.getClass();
                    Bundle bundle = new Bundle();
                    CharSequence charSequence = message.f3432a;
                    if (charSequence != null) {
                        bundle.putCharSequence(MimeTypes.BASE_TYPE_TEXT, charSequence);
                    }
                    bundle.putLong("time", message.f3433b);
                    Person person = message.f3434c;
                    if (person != null) {
                        bundle.putCharSequence("sender", person.getName());
                        if (Build.VERSION.SDK_INT >= 28) {
                            bundle.putParcelable("sender_person", AbstractC0175z.m797a(person.toAndroidPerson()));
                        } else {
                            bundle.putBundle("person", person.toBundle());
                        }
                    }
                    String str = message.f3436e;
                    if (str != null) {
                        bundle.putString("type", str);
                    }
                    Uri uri = message.f3437f;
                    if (uri != null) {
                        bundle.putParcelable("uri", uri);
                    }
                    Bundle bundle2 = message.f3435d;
                    if (bundle2 != null) {
                        bundle.putBundle("extras", bundle2);
                    }
                    bundleArr[i] = bundle;
                }
                return bundleArr;
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
            
                r0.add(r11);
             */
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static ArrayList m702b(Parcelable[] parcelableArr) {
                Person person;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if (parcelable instanceof Bundle) {
                        Bundle bundle = (Bundle) parcelable;
                        Message message = null;
                        try {
                            if (bundle.containsKey(MimeTypes.BASE_TYPE_TEXT) && bundle.containsKey("time")) {
                                if (bundle.containsKey("person")) {
                                    person = Person.fromBundle(bundle.getBundle("person"));
                                } else if (bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
                                    person = Person.fromAndroidPerson(hm1.m5098f(bundle.getParcelable("sender_person")));
                                } else if (bundle.containsKey("sender")) {
                                    person = new Person.Builder().setName(bundle.getCharSequence("sender")).build();
                                } else {
                                    person = null;
                                }
                                Message message2 = new Message(bundle.getCharSequence(MimeTypes.BASE_TYPE_TEXT), bundle.getLong("time"), person);
                                if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                                    message2.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                                }
                                if (bundle.containsKey("extras")) {
                                    message2.getExtras().putAll(bundle.getBundle("extras"));
                                }
                                message = message2;
                            }
                        } catch (ClassCastException unused) {
                        }
                    }
                }
                return arrayList;
            }

            /* renamed from: c */
            public final Notification.MessagingStyle.Message m703c() {
                Notification.MessagingStyle.Message m795a;
                Person person = getPerson();
                CharSequence charSequence = null;
                android.app.Person person2 = null;
                if (Build.VERSION.SDK_INT >= 28) {
                    CharSequence text = getText();
                    long timestamp = getTimestamp();
                    if (person != null) {
                        person2 = person.toAndroidPerson();
                    }
                    m795a = AbstractC0175z.m798b(text, timestamp, person2);
                } else {
                    CharSequence text2 = getText();
                    long timestamp2 = getTimestamp();
                    if (person != null) {
                        charSequence = person.getName();
                    }
                    m795a = AbstractC0174y.m795a(text2, timestamp2, charSequence);
                }
                if (getDataMimeType() != null) {
                    AbstractC0174y.m796b(m795a, getDataMimeType(), getDataUri());
                }
                return m795a;
            }

            @Nullable
            public String getDataMimeType() {
                return this.f3436e;
            }

            @Nullable
            public Uri getDataUri() {
                return this.f3437f;
            }

            @NonNull
            public Bundle getExtras() {
                return this.f3435d;
            }

            @Nullable
            public Person getPerson() {
                return this.f3434c;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                Person person = this.f3434c;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @Nullable
            public CharSequence getText() {
                return this.f3432a;
            }

            public long getTimestamp() {
                return this.f3433b;
            }

            @NonNull
            public Message setData(@Nullable String str, @Nullable Uri uri) {
                this.f3436e = str;
                this.f3437f = uri;
                return this;
            }

            @Deprecated
            public Message(@Nullable CharSequence charSequence, long j, @Nullable CharSequence charSequence2) {
                this(charSequence, j, new Person.Builder().setName(charSequence2).build());
            }
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j, @Nullable Person person) {
            addMessage(new Message(charSequence, j, person));
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message message) {
            if (message != null) {
                ArrayList arrayList = this.f3427d;
                arrayList.add(message);
                if (arrayList.size() > 25) {
                    arrayList.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.getName())) {
                this.f3429f = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }
}
