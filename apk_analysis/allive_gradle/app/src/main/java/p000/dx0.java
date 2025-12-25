package p000;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.util.SparseIntArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy$CollectionAdapter;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.text.ExoplayerCuesDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.base.internal.Finalizer;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Predicate;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes.dex */
public class dx0 implements df1, ss2, Lifecycle, ObjectConstructor, RequestManagerTreeNode, FocusStrategy$CollectionAdapter, xd0, vu0, Predicate, HeartBeatConsumer, MediaChunkIterator, BiPredicate, StableIdStorage$StableIdLookup, SharingStarted, SubtitleDecoderFactory, d23, Continuation, zaq {

    /* renamed from: b */
    public static final dx0 f16573b = new dx0(1);

    /* renamed from: c */
    public static final dx0 f16574c = new dx0(2);

    /* renamed from: d */
    public static final dx0 f16575d = new dx0(3);

    /* renamed from: e */
    public static final dx0 f16576e = new dx0(4);

    /* renamed from: a */
    public final /* synthetic */ int f16577a;

    public /* synthetic */ dx0(int i) {
        this.f16577a = i;
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    @Override // p000.df1
    /* renamed from: b */
    public ef1 mo4573b(zf1 zf1Var, int i) {
        switch (this.f16577a) {
            case 1:
                return new ef1(zf1Var, i);
            case 2:
                return new qf1(zf1Var, i);
            default:
                return new uf1(zf1Var, i);
        }
    }

    @Override // p000.df1
    /* renamed from: c */
    public if1 mo4574c() {
        switch (this.f16577a) {
            case 1:
                return if1.f18394a;
            case 2:
                return if1.f18395b;
            default:
                return if1.f18395b;
        }
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow stateFlow) {
        return FlowKt.flowOf(SharingCommand.START);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f16577a) {
            case 6:
                return new TreeSet();
            case 7:
                return new ArrayDeque();
            case 8:
                return new ConcurrentSkipListMap();
            case 9:
                return new TreeMap();
            default:
                return new LinkedTreeMap();
        }
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
    public SubtitleDecoder createDecoder(Format format) {
        String str = format.sampleMimeType;
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals(MimeTypes.APPLICATION_DVBSUBS)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals(MimeTypes.APPLICATION_PGS)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals(MimeTypes.APPLICATION_MP4VTT)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals(MimeTypes.TEXT_VTT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals(MimeTypes.APPLICATION_TX3G)) {
                        c = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals(MimeTypes.TEXT_SSA)) {
                        c = 5;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals(MimeTypes.APPLICATION_MP4CEA608)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1201784583:
                    if (str.equals(MimeTypes.TEXT_EXOPLAYER_CUES)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals(MimeTypes.APPLICATION_CEA608)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals(MimeTypes.APPLICATION_CEA708)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals(MimeTypes.APPLICATION_SUBRIP)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals(MimeTypes.APPLICATION_TTML)) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new DvbDecoder(format.initializationData);
                case 1:
                    return new PgsDecoder();
                case 2:
                    return new Mp4WebvttDecoder();
                case 3:
                    return new WebvttDecoder();
                case 4:
                    return new Tx3gDecoder(format.initializationData);
                case 5:
                    return new SsaDecoder(format.initializationData);
                case 6:
                case '\b':
                    return new Cea608Decoder(str, format.accessibilityChannel, Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS);
                case 7:
                    return new ExoplayerCuesDecoder();
                case '\t':
                    return new Cea708Decoder(format.accessibilityChannel, format.initializationData);
                case '\n':
                    return new SubripDecoder();
                case 11:
                    return new TtmlDecoder();
            }
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Attempted to create decoder for unsupported MIME type: ", str));
    }

    @Override // p000.df1
    /* renamed from: d */
    public if1 mo4575d() {
        switch (this.f16577a) {
            case 1:
                return if1.f18394a;
            case 2:
                return if1.f18394a;
            default:
                return if1.f18395b;
        }
    }

    @Override // p000.xd0
    /* renamed from: e */
    public Class mo4626e() {
        try {
            Logger logger = Finalizer.f14509d;
            return Finalizer.class;
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: f */
    public SparseIntArray[] mo4627f() {
        return null;
    }

    @Override // p000.df1
    /* renamed from: g */
    public cf1 mo4576g(ef1 ef1Var, cf1 cf1Var, cf1 cf1Var2) {
        switch (this.f16577a) {
            case 1:
                lf1 lf1Var = (lf1) cf1Var;
                lf1 lf1Var2 = new lf1(lf1Var.f28923a, lf1Var.f28924b, (lf1) cf1Var2);
                lf1Var2.f22492d = lf1Var.f22492d;
                return lf1Var2;
            case 2:
                qf1 qf1Var = (qf1) ef1Var;
                pf1 pf1Var = (pf1) cf1Var;
                pf1 pf1Var2 = (pf1) cf1Var2;
                if (pf1Var.get() == 0) {
                    return null;
                }
                return new ze1(qf1Var.f25569h, pf1Var.get(), pf1Var.f29337a, pf1Var2);
            default:
                uf1 uf1Var = (uf1) ef1Var;
                tf1 tf1Var = (tf1) cf1Var;
                tf1 tf1Var2 = (tf1) cf1Var2;
                if (tf1Var.get() == 0) {
                    return null;
                }
                int i = ef1.f16785g;
                if (tf1Var.f26802c.get() == null) {
                    return null;
                }
                ReferenceQueue referenceQueue = uf1Var.f27247h;
                ReferenceQueue referenceQueue2 = uf1Var.f27248i;
                tf1 tf1Var3 = new tf1(referenceQueue, tf1Var.get(), tf1Var.f29337a, tf1Var2);
                tf1Var3.f26802c = tf1Var.f26802c.mo8055b(referenceQueue2, tf1Var3);
                return tf1Var3;
        }
    }

    @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
    public Object get(Object obj, int i) {
        return (AccessibilityNodeInfoCompat) ((SparseArrayCompat) obj).valueAt(i);
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public long getChunkEndTimeUs() {
        throw new NoSuchElementException();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public long getChunkStartTimeUs() {
        throw new NoSuchElementException();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public DataSpec getDataSpec() {
        throw new NoSuchElementException();
    }

    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set getDescendants() {
        return Collections.emptySet();
    }

    @Override // p000.d23
    /* renamed from: h */
    public void mo4514h(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // p000.df1
    /* renamed from: i */
    public void mo4577i(ef1 ef1Var, cf1 cf1Var, Object obj) {
        switch (this.f16577a) {
            case 1:
                ((lf1) cf1Var).f22492d = obj;
                return;
            case 2:
                return;
            default:
                tf1 tf1Var = (tf1) cf1Var;
                ReferenceQueue referenceQueue = ((uf1) ef1Var).f27248i;
                wf1 wf1Var = tf1Var.f26802c;
                tf1Var.f26802c = new xf1(referenceQueue, obj, tf1Var);
                wf1Var.clear();
                return;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        return true;
    }

    @Override // p000.ss2
    /* renamed from: j */
    public int mo4628j(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i));
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            i4 = 2;
                            break;
                    }
                    i++;
                }
                i4 = 0;
                i++;
            }
            i4 = 1;
            i++;
        }
        return i4;
    }

    /* renamed from: k */
    public SparseIntArray[] mo4629k(Activity activity) {
        return null;
    }

    /* renamed from: l */
    public SparseIntArray[] mo4630l() {
        return null;
    }

    @Override // androidx.recyclerview.widget.StableIdStorage$StableIdLookup
    public long localToGlobal(long j) {
        return -1L;
    }

    /* renamed from: m */
    public SparseIntArray[] mo4631m() {
        return null;
    }

    @Override // p000.df1
    /* renamed from: n */
    public cf1 mo4578n(ef1 ef1Var, Object obj, int i, cf1 cf1Var) {
        switch (this.f16577a) {
            case 1:
                return new lf1(obj, i, (lf1) cf1Var);
            case 2:
                return new ze1(((qf1) ef1Var).f25569h, obj, i, (pf1) cf1Var);
            default:
                return new tf1(((uf1) ef1Var).f27247h, obj, i, (tf1) cf1Var);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        return false;
    }

    @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
    public int size(Object obj) {
        return ((SparseArrayCompat) obj).size();
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
    public boolean supportsFormat(Format format) {
        String str = format.sampleMimeType;
        if (!MimeTypes.TEXT_VTT.equals(str) && !MimeTypes.TEXT_SSA.equals(str) && !MimeTypes.APPLICATION_TTML.equals(str) && !MimeTypes.APPLICATION_MP4VTT.equals(str) && !MimeTypes.APPLICATION_SUBRIP.equals(str) && !MimeTypes.APPLICATION_TX3G.equals(str) && !MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_MP4CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str) && !MimeTypes.APPLICATION_DVBSUBS.equals(str) && !MimeTypes.APPLICATION_PGS.equals(str) && !MimeTypes.TEXT_EXOPLAYER_CUES.equals(str)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.functions.BiPredicate
    public boolean test(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        if (((Boolean) task.getResult()).booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }

    public String toString() {
        switch (this.f16577a) {
            case 24:
                return "SharingStarted.Eagerly";
            default:
                return super.toString();
        }
    }

    @Override // com.google.android.gms.internal.base.zaq
    public ExecutorService zaa(ThreadFactory threadFactory, int i) {
        return zac(1, threadFactory, 1);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public ExecutorService zab(int i, int i2) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public ExecutorService zac(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object obj) {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public void reset() {
    }

    /* renamed from: a */
    public void mo4625a(Activity activity) {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener) {
    }
}
