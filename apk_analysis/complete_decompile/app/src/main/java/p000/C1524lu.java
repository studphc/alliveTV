package p000;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.offline.C0680a;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.p003ui.PlayerNotificationManager;
import com.google.android.exoplayer2.source.C0696e;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C0736a;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: lu */
/* loaded from: classes.dex */
public final /* synthetic */ class C1524lu implements Handler.Callback {

    /* renamed from: a */
    public final /* synthetic */ int f22666a;

    /* renamed from: b */
    public final /* synthetic */ Object f22667b;

    public /* synthetic */ C1524lu(int i, Object obj) {
        this.f22666a = i;
        this.f22667b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj = this.f22667b;
        switch (this.f22666a) {
            case 0:
                MediaItem mediaItem = ConcatenatingMediaSource.f10930w;
                ConcatenatingMediaSource concatenatingMediaSource = (ConcatenatingMediaSource) obj;
                concatenatingMediaSource.getClass();
                int i = message.what;
                if (i != 0) {
                    ArrayList arrayList = concatenatingMediaSource.f10934n;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i == 5) {
                                        concatenatingMediaSource.m2733f((Set) Util.castNonNull(message.obj));
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    concatenatingMediaSource.m2738k();
                                }
                            } else {
                                C1663ou c1663ou = (C1663ou) Util.castNonNull(message.obj);
                                concatenatingMediaSource.f10942v = (ShuffleOrder) c1663ou.f24910b;
                                concatenatingMediaSource.m2736i(c1663ou.f24911c);
                            }
                        } else {
                            C1663ou c1663ou2 = (C1663ou) Util.castNonNull(message.obj);
                            ShuffleOrder shuffleOrder = concatenatingMediaSource.f10942v;
                            int i2 = c1663ou2.f24909a;
                            ShuffleOrder cloneAndRemove = shuffleOrder.cloneAndRemove(i2, i2 + 1);
                            concatenatingMediaSource.f10942v = cloneAndRemove;
                            Integer num = (Integer) c1663ou2.f24910b;
                            concatenatingMediaSource.f10942v = cloneAndRemove.cloneAndInsert(num.intValue(), 1);
                            int intValue = num.intValue();
                            int i3 = c1663ou2.f24909a;
                            int min = Math.min(i3, intValue);
                            int max = Math.max(i3, intValue);
                            int i4 = ((C0696e) arrayList.get(min)).f11359e;
                            arrayList.add(intValue, (C0696e) arrayList.remove(i3));
                            while (min <= max) {
                                C0696e c0696e = (C0696e) arrayList.get(min);
                                c0696e.f11358d = min;
                                c0696e.f11359e = i4;
                                i4 += c0696e.f11355a.getTimeline().getWindowCount();
                                min++;
                            }
                            concatenatingMediaSource.m2736i(c1663ou2.f24911c);
                        }
                    } else {
                        C1663ou c1663ou3 = (C1663ou) Util.castNonNull(message.obj);
                        int i5 = c1663ou3.f24909a;
                        int intValue2 = ((Integer) c1663ou3.f24910b).intValue();
                        if (i5 == 0 && intValue2 == concatenatingMediaSource.f10942v.getLength()) {
                            concatenatingMediaSource.f10942v = concatenatingMediaSource.f10942v.cloneAndClear();
                        } else {
                            concatenatingMediaSource.f10942v = concatenatingMediaSource.f10942v.cloneAndRemove(i5, intValue2);
                        }
                        for (int i6 = intValue2 - 1; i6 >= i5; i6--) {
                            C0696e c0696e2 = (C0696e) arrayList.remove(i6);
                            concatenatingMediaSource.f10936p.remove(c0696e2.f11356b);
                            concatenatingMediaSource.m2730c(i6, -1, -c0696e2.f11355a.getTimeline().getWindowCount());
                            c0696e2.f11360f = true;
                            if (c0696e2.f11357c.isEmpty()) {
                                concatenatingMediaSource.f10937q.remove(c0696e2);
                                concatenatingMediaSource.releaseChildSource(c0696e2);
                            }
                        }
                        concatenatingMediaSource.m2736i(c1663ou3.f24911c);
                    }
                } else {
                    C1663ou c1663ou4 = (C1663ou) Util.castNonNull(message.obj);
                    ShuffleOrder shuffleOrder2 = concatenatingMediaSource.f10942v;
                    int i7 = c1663ou4.f24909a;
                    Collection collection = (Collection) c1663ou4.f24910b;
                    concatenatingMediaSource.f10942v = shuffleOrder2.cloneAndInsert(i7, collection.size());
                    concatenatingMediaSource.m2728a(c1663ou4.f24909a, collection);
                    concatenatingMediaSource.m2736i(c1663ou4.f24911c);
                }
                return true;
            case 1:
                C0680a c0680a = (C0680a) obj;
                boolean z = c0680a.f10859j;
                if (z) {
                    return false;
                }
                int i8 = message.what;
                DownloadHelper downloadHelper = c0680a.f10851b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        return false;
                    }
                    if (!z) {
                        c0680a.f10859j = true;
                        c0680a.f10856g.sendEmptyMessage(3);
                    }
                    ((Handler) Assertions.checkNotNull(downloadHelper.f10786f)).post(new RunnableC0583c7(16, downloadHelper, (IOException) Util.castNonNull(message.obj)));
                } else {
                    try {
                        DownloadHelper.m2703a(downloadHelper);
                    } catch (ExoPlaybackException e) {
                        c0680a.f10854e.obtainMessage(1, new IOException(e)).sendToTarget();
                    }
                }
                return true;
            case 2:
                int i9 = DownloadManager.DEFAULT_MAX_PARALLEL_DOWNLOADS;
                DownloadManager downloadManager = (DownloadManager) obj;
                downloadManager.getClass();
                int i10 = message.what;
                CopyOnWriteArraySet copyOnWriteArraySet = downloadManager.f10800f;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            c60 c60Var = (c60) message.obj;
                            downloadManager.f10809o = Collections.unmodifiableList(c60Var.f8269c);
                            boolean m2710d = downloadManager.m2710d();
                            boolean z2 = c60Var.f8268b;
                            Download download = c60Var.f8267a;
                            if (z2) {
                                Iterator it = copyOnWriteArraySet.iterator();
                                while (it.hasNext()) {
                                    ((DownloadManager.Listener) it.next()).onDownloadRemoved(downloadManager, download);
                                }
                            } else {
                                Iterator it2 = copyOnWriteArraySet.iterator();
                                while (it2.hasNext()) {
                                    ((DownloadManager.Listener) it2.next()).onDownloadChanged(downloadManager, download, c60Var.f8270d);
                                }
                            }
                            if (m2710d) {
                                downloadManager.m2707a();
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        int i11 = message.arg1;
                        int i12 = message.arg2;
                        downloadManager.f10801g -= i11;
                        downloadManager.f10802h = i12;
                        if (downloadManager.isIdle()) {
                            Iterator it3 = copyOnWriteArraySet.iterator();
                            while (it3.hasNext()) {
                                ((DownloadManager.Listener) it3.next()).onIdle(downloadManager);
                            }
                        }
                    }
                } else {
                    List list = (List) message.obj;
                    downloadManager.f10803i = true;
                    downloadManager.f10809o = Collections.unmodifiableList(list);
                    boolean m2710d2 = downloadManager.m2710d();
                    Iterator it4 = copyOnWriteArraySet.iterator();
                    while (it4.hasNext()) {
                        ((DownloadManager.Listener) it4.next()).onInitialized(downloadManager);
                    }
                    if (m2710d2) {
                        downloadManager.m2707a();
                    }
                }
                return true;
            case 3:
                ListenerSet listenerSet = (ListenerSet) obj;
                Iterator it5 = listenerSet.f12718d.iterator();
                while (it5.hasNext()) {
                    C0736a c0736a = (C0736a) it5.next();
                    if (!c0736a.f12787d && c0736a.f12786c) {
                        FlagSet build = c0736a.f12785b.build();
                        c0736a.f12785b = new FlagSet.Builder();
                        c0736a.f12786c = false;
                        listenerSet.f12717c.invoke(c0736a.f12784a, build);
                    }
                    if (listenerSet.f12716b.hasMessages(0)) {
                        return true;
                    }
                }
                return true;
            default:
                PlayerNotificationManager playerNotificationManager = (PlayerNotificationManager) obj;
                playerNotificationManager.getClass();
                int i13 = message.what;
                if (i13 != 0) {
                    if (i13 != 1) {
                        return false;
                    }
                    Player player = playerNotificationManager.f12141r;
                    if (player != null && playerNotificationManager.f12142s && playerNotificationManager.f12143t == message.arg1) {
                        playerNotificationManager.m2912b(player, (Bitmap) message.obj);
                    }
                } else {
                    Player player2 = playerNotificationManager.f12141r;
                    if (player2 != null) {
                        playerNotificationManager.m2912b(player2, null);
                    }
                }
                return true;
        }
    }
}
