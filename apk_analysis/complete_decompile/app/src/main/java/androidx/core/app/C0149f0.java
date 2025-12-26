package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import p000.fs1;
import p000.gs1;
import p000.hs1;
import p000.is1;
import p000.js1;
import p000.ks1;
import p000.ls1;
import p000.ms1;

/* renamed from: androidx.core.app.f0 */
/* loaded from: classes.dex */
public final class C0149f0 implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a */
    public final Context f3514a;

    /* renamed from: b */
    public final Notification.Builder f3515b;

    /* renamed from: c */
    public final NotificationCompat.Builder f3516c;

    /* renamed from: d */
    public final RemoteViews f3517d;

    /* renamed from: e */
    public final RemoteViews f3518e;

    /* renamed from: f */
    public final Bundle f3519f;

    /* renamed from: g */
    public final int f3520g;

    /* renamed from: h */
    public final RemoteViews f3521h;

    public C0149f0(NotificationCompat.Builder builder) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Icon icon;
        ArrayList<String> arrayList;
        Notification notification;
        int i;
        int i2;
        Bundle bundle;
        Bundle[] bundleArr;
        ArrayList arrayList2;
        Notification notification2;
        new ArrayList();
        this.f3519f = new Bundle();
        this.f3516c = builder;
        Context context = builder.mContext;
        this.f3514a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3515b = js1.m5451a(context, builder.f3363I);
        } else {
            this.f3515b = new Notification.Builder(builder.mContext);
        }
        Notification notification3 = builder.f3372R;
        Notification.Builder lights = this.f3515b.setWhen(notification3.when).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, builder.f3380f).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS);
        if ((notification3.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z);
        if ((notification3.flags & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z2);
        if ((notification3.flags & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z3).setDefaults(notification3.defaults).setContentTitle(builder.f3376b).setContentText(builder.f3377c).setContentInfo(builder.f3382h).setContentIntent(builder.f3378d).setDeleteIntent(notification3.deleteIntent);
        PendingIntent pendingIntent = builder.f3379e;
        if ((notification3.flags & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z4).setNumber(builder.f3383i).setProgress(builder.f3392r, builder.f3393s, builder.f3394t);
        Notification.Builder builder2 = this.f3515b;
        IconCompat iconCompat = builder.f3381g;
        if (iconCompat == null) {
            icon = null;
        } else {
            icon = iconCompat.toIcon(context);
        }
        hs1.m5128b(builder2, icon);
        this.f3515b.setSubText(builder.f3389o).setUsesChronometer(builder.f3386l).setPriority(builder.f3384j);
        NotificationCompat.Style style = builder.f3388n;
        if (style instanceof NotificationCompat.CallStyle) {
            Iterator<NotificationCompat.Action> it = ((NotificationCompat.CallStyle) style).getActionsListWithSystemActions().iterator();
            while (it.hasNext()) {
                m730a(it.next());
            }
        } else {
            Iterator<NotificationCompat.Action> it2 = builder.mActions.iterator();
            while (it2.hasNext()) {
                m730a(it2.next());
            }
        }
        Bundle bundle2 = builder.f3356B;
        if (bundle2 != null) {
            this.f3519f.putAll(bundle2);
        }
        int i3 = Build.VERSION.SDK_INT;
        this.f3517d = builder.f3360F;
        this.f3518e = builder.f3361G;
        this.f3515b.setShowWhen(builder.f3385k);
        fs1.m4838i(this.f3515b, builder.f3398x);
        fs1.m4836g(this.f3515b, builder.f3395u);
        fs1.m4839j(this.f3515b, builder.f3397w);
        fs1.m4837h(this.f3515b, builder.f3396v);
        this.f3520g = builder.f3368N;
        gs1.m4987b(this.f3515b, builder.f3355A);
        gs1.m4988c(this.f3515b, builder.f3357C);
        gs1.m4991f(this.f3515b, builder.f3358D);
        gs1.m4989d(this.f3515b, builder.f3359E);
        gs1.m4990e(this.f3515b, notification3.sound, notification3.audioAttributes);
        if (i3 < 28) {
            ArrayList<Person> arrayList3 = builder.mPersonList;
            if (arrayList3 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(arrayList3.size());
                Iterator<Person> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next().resolveToLegacyUri());
                }
            }
            ArrayList<String> arrayList4 = builder.mPeople;
            if (arrayList == null) {
                arrayList = arrayList4;
            } else if (arrayList4 != null) {
                ArraySet arraySet = new ArraySet(arrayList4.size() + arrayList.size());
                arraySet.addAll(arrayList);
                arraySet.addAll(arrayList4);
                arrayList = new ArrayList<>(arraySet);
            }
        } else {
            arrayList = builder.mPeople;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                gs1.m4986a(this.f3515b, it4.next());
            }
        }
        this.f3521h = builder.f3362H;
        ArrayList arrayList5 = builder.f3375a;
        if (arrayList5.size() > 0) {
            Bundle bundle3 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            int i4 = 0;
            while (i4 < arrayList5.size()) {
                String num = Integer.toString(i4);
                NotificationCompat.Action action = (NotificationCompat.Action) arrayList5.get(i4);
                Bundle bundle6 = new Bundle();
                IconCompat iconCompat2 = action.getIconCompat();
                if (iconCompat2 != null) {
                    i2 = iconCompat2.getResId();
                } else {
                    i2 = 0;
                }
                bundle6.putInt("icon", i2);
                bundle6.putCharSequence("title", action.getTitle());
                bundle6.putParcelable("actionIntent", action.getActionIntent());
                if (action.getExtras() != null) {
                    bundle = new Bundle(action.getExtras());
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
                bundle6.putBundle("extras", bundle);
                RemoteInput[] remoteInputs = action.getRemoteInputs();
                if (remoteInputs == null) {
                    arrayList2 = arrayList5;
                    notification2 = notification3;
                    bundleArr = null;
                } else {
                    bundleArr = new Bundle[remoteInputs.length];
                    int i5 = 0;
                    while (i5 < remoteInputs.length) {
                        RemoteInput remoteInput = remoteInputs[i5];
                        ArrayList arrayList6 = arrayList5;
                        Bundle bundle7 = new Bundle();
                        RemoteInput[] remoteInputArr = remoteInputs;
                        Notification notification4 = notification3;
                        bundle7.putString("resultKey", remoteInput.getResultKey());
                        bundle7.putCharSequence("label", remoteInput.getLabel());
                        bundle7.putCharSequenceArray("choices", remoteInput.getChoices());
                        bundle7.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
                        bundle7.putBundle("extras", remoteInput.getExtras());
                        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
                        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
                            ArrayList<String> arrayList7 = new ArrayList<>(allowedDataTypes.size());
                            Iterator<String> it5 = allowedDataTypes.iterator();
                            while (it5.hasNext()) {
                                arrayList7.add(it5.next());
                            }
                            bundle7.putStringArrayList("allowedDataTypes", arrayList7);
                        }
                        bundleArr[i5] = bundle7;
                        i5++;
                        arrayList5 = arrayList6;
                        remoteInputs = remoteInputArr;
                        notification3 = notification4;
                    }
                    arrayList2 = arrayList5;
                    notification2 = notification3;
                }
                bundle6.putParcelableArray("remoteInputs", bundleArr);
                bundle6.putBoolean("showsUserInterface", action.getShowsUserInterface());
                bundle6.putInt("semanticAction", action.getSemanticAction());
                bundle5.putBundle(num, bundle6);
                i4++;
                arrayList5 = arrayList2;
                notification3 = notification2;
            }
            notification = notification3;
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle3);
            this.f3519f.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            notification = notification3;
        }
        int i6 = Build.VERSION.SDK_INT;
        Icon icon2 = builder.f3374T;
        if (icon2 != null) {
            hs1.m5129c(this.f3515b, icon2);
        }
        if (i6 >= 24) {
            this.f3515b.setExtras(builder.f3356B);
            is1.m5366e(this.f3515b, builder.f3391q);
            RemoteViews remoteViews = builder.f3360F;
            if (remoteViews != null) {
                is1.m5364c(this.f3515b, remoteViews);
            }
            RemoteViews remoteViews2 = builder.f3361G;
            if (remoteViews2 != null) {
                is1.m5363b(this.f3515b, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.f3362H;
            if (remoteViews3 != null) {
                is1.m5365d(this.f3515b, remoteViews3);
            }
        }
        if (i6 >= 26) {
            js1.m5452b(this.f3515b, builder.f3364J);
            js1.m5455e(this.f3515b, builder.f3390p);
            js1.m5456f(this.f3515b, builder.f3365K);
            js1.m5457g(this.f3515b, builder.f3367M);
            js1.m5454d(this.f3515b, builder.f3368N);
            if (builder.f3400z) {
                js1.m5453c(this.f3515b, builder.f3399y);
            }
            if (!TextUtils.isEmpty(builder.f3363I)) {
                this.f3515b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i6 >= 28) {
            Iterator<Person> it6 = builder.mPersonList.iterator();
            while (it6.hasNext()) {
                ks1.m5785a(this.f3515b, it6.next().toAndroidPerson());
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            ls1.m5978a(this.f3515b, builder.f3370P);
            ls1.m5979b(this.f3515b, NotificationCompat.BubbleMetadata.toPlatform(builder.f3371Q));
            LocusIdCompat locusIdCompat = builder.f3366L;
            if (locusIdCompat != null) {
                ls1.m5981d(this.f3515b, locusIdCompat.toLocusId());
            }
        }
        if (i7 >= 31 && (i = builder.f3369O) != 0) {
            ms1.m6247b(this.f3515b, i);
        }
        if (builder.f3373S) {
            if (this.f3516c.f3396v) {
                this.f3520g = 2;
            } else {
                this.f3520g = 1;
            }
            this.f3515b.setVibrate(null);
            this.f3515b.setSound(null);
            Notification notification5 = notification;
            int i8 = notification5.defaults & (-4);
            notification5.defaults = i8;
            this.f3515b.setDefaults(i8);
            if (i7 >= 26) {
                if (TextUtils.isEmpty(this.f3516c.f3395u)) {
                    fs1.m4836g(this.f3515b, NotificationCompat.GROUP_KEY_SILENT);
                }
                js1.m5454d(this.f3515b, this.f3520g);
            }
        }
    }

    /* renamed from: c */
    public static void m729c(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    /* renamed from: a */
    public final void m730a(NotificationCompat.Action action) {
        Icon icon;
        Bundle bundle;
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            icon = iconCompat.toIcon();
        } else {
            icon = null;
        }
        Notification.Action.Builder m5127a = hs1.m5127a(icon, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.m709b(action.getRemoteInputs())) {
                fs1.m4832c(m5127a, remoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            is1.m5362a(m5127a, action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i >= 28) {
            ks1.m5786b(m5127a, action.getSemanticAction());
        }
        if (i >= 29) {
            ls1.m5980c(m5127a, action.isContextual());
        }
        if (i >= 31) {
            ms1.m6246a(m5127a, action.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        fs1.m4831b(m5127a, bundle);
        fs1.m4830a(this.f3515b, fs1.m4833d(m5127a));
    }

    /* renamed from: b */
    public final Notification m731b() {
        RemoteViews remoteViews;
        Notification build;
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Builder builder = this.f3516c;
        NotificationCompat.Style style = builder.f3388n;
        if (style != null) {
            style.apply(this);
        }
        if (style != null) {
            remoteViews = style.makeContentView(this);
        } else {
            remoteViews = null;
        }
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder2 = this.f3515b;
        if (i >= 26) {
            build = builder2.build();
        } else {
            int i2 = this.f3520g;
            if (i >= 24) {
                build = builder2.build();
                if (i2 != 0) {
                    if (fs1.m4835f(build) != null && (build.flags & 512) != 0 && i2 == 2) {
                        m729c(build);
                    }
                    if (fs1.m4835f(build) != null && (build.flags & 512) == 0 && i2 == 1) {
                        m729c(build);
                    }
                }
            } else {
                builder2.setExtras(this.f3519f);
                build = builder2.build();
                RemoteViews remoteViews2 = this.f3517d;
                if (remoteViews2 != null) {
                    build.contentView = remoteViews2;
                }
                RemoteViews remoteViews3 = this.f3518e;
                if (remoteViews3 != null) {
                    build.bigContentView = remoteViews3;
                }
                RemoteViews remoteViews4 = this.f3521h;
                if (remoteViews4 != null) {
                    build.headsUpContentView = remoteViews4;
                }
                if (i2 != 0) {
                    if (fs1.m4835f(build) != null && (build.flags & 512) != 0 && i2 == 2) {
                        m729c(build);
                    }
                    if (fs1.m4835f(build) != null && (build.flags & 512) == 0 && i2 == 1) {
                        m729c(build);
                    }
                }
            }
        }
        if (remoteViews != null) {
            build.contentView = remoteViews;
        } else {
            RemoteViews remoteViews5 = builder.f3360F;
            if (remoteViews5 != null) {
                build.contentView = remoteViews5;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            build.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = builder.f3388n.makeHeadsUpContentView(this)) != null) {
            build.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = NotificationCompat.getExtras(build)) != null) {
            style.addCompatExtras(extras);
        }
        return build;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public final Notification.Builder getBuilder() {
        return this.f3515b;
    }
}
